package com.lzsoft.aml.autoexecute.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lzsoft.aml.autoexecute.commons.Constants;
import com.lzsoft.aml.entity.model.AccCustEntity;
import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.Amlbase;
import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.CustBaseEntity;
import com.lzsoft.aml.entity.model.TaskSchedule;
import com.lzsoft.aml.entity.model.TranDetailEntity;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.util.LogUtil;
import com.lzsoft.rules.core.RulesEngine;
import com.lzsoft.rules.core.RulesEngineHelper;

@Service(value = "amlExtractServiceImpl")
public class AmlExtractServiceImpl extends ExtractServiceImpl {

	/**
	 * 
	 * */
	@Override
	public void execute() throws Exception {
		try {
			pc = new PropertiesConfiguration(Constants.DATA_FILES_PATH);
			logPath = pc.getString("logpath");
			Date maxImportdate = getMaxImportDate("autoExtractAml");
			LogUtil.generateLog(logPath, "开始" + maxImportdate + "下反洗钱大额的采集");
			LogUtil.generateLog(logPath,
					"反洗钱大额采集开始时间：" + DateUtil.getCurrDate24() + "。");
			// System.out.println("extracteAcc()  Start of Time========" + new
			// Date());
			if (null != maxImportdate) {
				TaskSchedule task = queryTaskSchedule(maxImportdate,
						"autoExtractAml");
				if (null != task && task.isExecutable()) {// 允许执行下面方法
					String message = extractAmlReport(maxImportdate, "606",
							"606");
					LogUtil.generateLog(logPath, message);

					LogUtil.generateLog(logPath,
							"反洗钱大额采集完成时间：" + DateUtil.getCurrDate24() + "。");
					task.setExecutable(false);
					dao.update(task);
				} else {
					if (null == task) {
						LogUtil.generateLog(logPath, "反洗钱大额采集时,在："
								+ maxImportdate + "下没有TaskSchedule,跳过提取步骤。");
					} else {
						LogUtil.generateLog(logPath, "反洗钱大额采集时,日期为：："
								+ maxImportdate + " 已经提取过。");
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.handle(logPath, e);
			logs.setEventdate(new Date());
			logs.setEvents("AML大额采集");
			logs.setObjects("反洗钱大额采集时发生异常！");
			logs.setUserid("admin");
			dao.save(logs);
		}
	}

	/**
	 * 提取Aml，返回提取结果
	 * 
	 * @param importdate
	 * @param task
	 * @return
	 * @throws ManagerException
	 * @throws Exception
	 */
	public String extractAmlReport(Date importdate, String bkid, String subbkid)
			throws ManagerException, Exception {

		List<TranDetailEntity> TranDetailEntitys = getTransByImportdate(importdate);
		List<TranDetailEntity> trans = getTransByRepaymentsandDrawdown(importdate);// 贷款还款/
		List<String> csnms = new ArrayList<String>();
		csnms.addAll(getApostpdidAndCnum(TranDetailEntitys));// 普通交易

		csnms.addAll(getApostpdidAndCnum(trans));// 贷款还款
		int count = 0;
		if (!csnms.isEmpty()) {
			// 需要报AML的交易列表,得到对应的交易流水和客户号列表

			Map<String, CustBaseEntity> custMaps = getCustMaps(importdate, csnms);
			Map<String, AccCustEntity> acctMaps = getAcctMaps(importdate, csnms);
			Map<String, Bankinfo> bankMaps = getBanksMap();
			List<?> objs = combineObjs(TranDetailEntitys, acctMaps, custMaps, bankMaps);

			RulesEngine rulesEngine = RulesEngineHelper
					.getRulesEngine(Constants.AML_RULE_PATH);

			Map<String, List<?>> results = rulesEngine.passesRule(objs);
			rulesEngine = null;
			if (null != results && !results.isEmpty()) {

				List<Amlbase> amlList = new LinkedList<Amlbase>();
				Bankinfo b = bankMaps.get(bkid + "|" + subbkid);
				count = setAmlDatas(amlList, results, b);
				// TODO beginning to filter Cathaybk customization rules
				if (!trans.isEmpty()) {
					Map<String, List<?>> esTrans = new HashMap<String, List<?>>();
					List<?> combinetrans = combineObjs(trans, acctMaps,
							custMaps, bankMaps);
					esTrans.put("esdl", combinetrans);
					count += setAmlDatas(amlList, esTrans, b);
				}
				// end

				if (0 != count && !amlList.isEmpty()) {
					removeApprovedTrans(importdate, amlList);
					dao.saveAll(amlList);
				}
			}

		}
		return getExtractMessages4Aml(count);
	}

	private void removeApprovedTrans(Date importdate, List<Amlbase> amlList) {
		if (amlList.get(0).getClass().equals(AmlBigAmount.class)) {
			List<Object[]> ticds = dao.queryFieldValues(
					AmlBigAmount.class, new String[] { "ticd" },
					"importdate=? and isvalidation='1'",
					new Object[] { importdate });
			List<Amlbase> temp = new ArrayList<Amlbase>();
			for (Amlbase amlbase : amlList) {
				if (ticds.contains(amlbase.getTicd())) {
					temp.add(amlbase);
				}
			}
			amlList.removeAll(temp);
		}
	}

	protected Map<String, AccCustEntity> getAcctMaps(Date importdate,
			List<String> csnms) {
		List<AccCustEntity> acctList = dao.queryByWhere(AccCustEntity.class,
				"importdate=? and csnm in ?2",
				new Object[] { importdate, csnms });

		Map<String, AccCustEntity> acctMaps = new HashMap<String, AccCustEntity>();
		for (AccCustEntity AccCustEntity : acctList) {
			acctMaps.put(AccCustEntity.getCsnm() + "|" + AccCustEntity.getAcod() + "|"
					+ AccCustEntity.getCcy(), AccCustEntity);
		}
		return acctMaps;
	}

	protected Map<String, CustBaseEntity> getCustMaps(Date importdate,
			List<String> csnms) {
		List<CustBaseEntity> custList = dao.queryByWhere(CustBaseEntity.class,
				"importdate=? and csnm in ?2",
				new Object[] { importdate, csnms });
		Map<String, CustBaseEntity> custMaps = new HashMap<String, CustBaseEntity>();
		for (CustBaseEntity CustBaseEntity : custList) {
			custMaps.put(CustBaseEntity.getCsnm(), CustBaseEntity);
		}
		return custMaps;
	}

	protected Map<String, Bankinfo> getBanksMap() throws Exception {
		List<Bankinfo> banks = dao.queryByWhere(Bankinfo.class, "");
		Map<String, Bankinfo> bankMaps = new HashMap<String, Bankinfo>();
		for (Bankinfo bankinfo : banks) {
			bankMaps.put(bankinfo.getBkid() + "|" + bankinfo.getSubbkid(),
					bankinfo);
		}
		return bankMaps;
	}

	private List<?> combineObjs(List<TranDetailEntity> TranDetailEntitys,
			Map<String, AccCustEntity> acctMaps, Map<String, CustBaseEntity> custMaps,
			Map<String, Bankinfo> bankMaps) {
		List<Object> objs = new ArrayList<Object>();
		List<Object> obj = null;
		for (TranDetailEntity TranDetailEntity : TranDetailEntitys) {
			obj = new ArrayList<Object>();
			obj.add(TranDetailEntity);
			obj.add(custMaps.get(TranDetailEntity.getCsnm()));
			obj.add(acctMaps.get(TranDetailEntity.getCsnm() + "|" + TranDetailEntity.getAcod()
					+ "|" + TranDetailEntity.getCcy()));
			obj.add(bankMaps.get(TranDetailEntity.getParentbrca() + "|" + TranDetailEntity.getBrca()));
			objs.add(obj);
		}
		return objs;
	}

	protected String getExtractMessages4Aml(int count) {
		String message = "";
		if (0 == count) {
			message = "提取完成,无符合反洗钱大额条件的交易";
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("提取完成.大额交易共[").append(count).append("]条.\n");

			message = builder.toString();
		}
		return message;
	}

	public int setAmlDatas(List<Amlbase> amlList,
			Map<String, List<?>> resultsMap, Bankinfo bankinfo)
			throws Exception {
		int aNum = 0;
		Set keySet = resultsMap.keySet();
		for (Object obkey : keySet) {
			String key = (String) obkey;
			Object obj = resultsMap.get(key);
			Object bigamount = null;
			if (obj.getClass().getName().toLowerCase().indexOf("list") >= 0) {
				for (Object object : (List) obj) {
					bigamount = new AmlBigAmount();
					setAmlByInstitution(bankinfo, key, bigamount);
					if (object.getClass().getName().toLowerCase()
							.indexOf("list") >= 0) {
						for (Object o : (List) object) {
							if (null != o) {
								if (o.getClass().getSimpleName().toLowerCase()
										.equals("CustBaseEntity")) {// assignment
																// customer
																// information
									setAmlByCustInfo(bigamount, o);
								} else if (o.getClass().getSimpleName()
										.toLowerCase().equals("TranDetailEntity")) {// assignment
																			// deals
									setAmlbyTran(o, bigamount);

								} else if (o.getClass().getSimpleName()
										.toLowerCase().equals("AccCustEntity")) {// assignment
																			// account
																			// information
									setAmlByAcct(bigamount, o);
								} else if (o.getClass().getSimpleName()
										.toLowerCase().equals("bankinfo")) {// assignment
																			// financial
																			// institution
																			// information
									setAmlByBankinfo(bigamount, o);
								}
							}

						}
					} else {
						if (object.getClass().getSimpleName().toLowerCase()
								.equals("TranDetailEntity")) {// assignment deals
														// information
							setAmlbyTran(object, bigamount);
							PropertyUtils.setProperty(bigamount, "csnm",
									PropertyUtils.getProperty(object, "csnm"));
							PropertyUtils.setProperty(bigamount, "crpp",
									"还/放款业务，是否要上报需要人工判断");
						}
					}

					setTbDefalutValue(bigamount);

					setDefaultValue(bigamount);

					amlList.add((Amlbase) bigamount);

					aNum++;
				}
			} else {

				setTbDefalutValue(bigamount);

				setDefaultValue(bigamount);
			}
		}

		return aNum;
	}

	protected void setAmlByBankinfo(Object bigamount, Object o)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.setProperty(bigamount, "finn",
				PropertyUtils.getProperty(o, "fullcnname"));
		PropertyUtils.setProperty(bigamount, "firc",
				PropertyUtils.getProperty(o, "areacode"));
		PropertyUtils.setProperty(bigamount, "rltp", "00");
		PropertyUtils.setProperty(bigamount, "fict", "00");
		PropertyUtils.setProperty(bigamount, "finc",
				PropertyUtils.getProperty(o, "branchcode"));
	}

	protected void setAmlByAcct(Object bigamount, Object o)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.setProperty(bigamount, "catp",
				PropertyUtils.getProperty(o, "amlacctype"));
	}

	protected void setAmlByInstitution(Bankinfo bankinfo, String key,
			Object bigamount) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		// assign name of reporting organization
		PropertyUtils.setProperty(bigamount, "rinm", bankinfo.getFullcnname());
		PropertyUtils.setProperty(bigamount, "ricd", bankinfo.getAmlbankcode());
		// PropertyUtils.setProperty(bigamount, "rpdt",
		// DateUtil.getCurrDate8());
		PropertyUtils.setProperty(bigamount, "crcd", key);
	}

	protected void setAmlbyTran(Object obj, Object bigamount)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		// 交易时间和交易日期
		Date vald = (Date) PropertyUtils.getProperty(obj, "vald");
		Date importdate = (Date) PropertyUtils.getProperty(obj, "importdate");
		Date rpdt = vald.compareTo(importdate) >= 0 ? vald : importdate;
		PropertyUtils.setProperty(bigamount, "htdt",
				DateUtil.dateToStr(rpdt, "yyyyMMdd"));
		PropertyUtils.setProperty(bigamount, "tstm",
				DateUtil.dateToStr(rpdt, "yyyyMMdd") + "tttttt");
		//
		PropertyUtils.setProperty(bigamount, "ctac",
				PropertyUtils.getProperty(obj, "acod"));
		Object o = PropertyUtils.getProperty(obj, "apostpdid");
		String apdid = null != o ? StringUtils.replace(StringUtils.replace(
				StringUtils.replace((String) o, "#*", ""), " ", ""), "-", "")
				: DateUtil.getCurrDate24();
		PropertyUtils.setProperty(bigamount, "ticd", apdid);
		PropertyUtils.setProperty(bigamount, "tstp",
				PropertyUtils.getProperty(obj, "paymethodtwo"));
		PropertyUtils.setProperty(bigamount, "tsct",
				PropertyUtils.getProperty(obj, "transactcode"));
		String drcr = ((String) PropertyUtils.getProperty(obj, "drcr"))
				.equals("C") ? "01" : "02";
		PropertyUtils.setProperty(bigamount, "tsdr", drcr);
		PropertyUtils.setProperty(bigamount, "tdrc",
				PropertyUtils.getProperty(obj, "tdrc"));
		PropertyUtils.setProperty(bigamount, "trcd", "@N");
		PropertyUtils.setProperty(bigamount, "crpp", "@N");
		PropertyUtils.setProperty(bigamount, "crtp",
				PropertyUtils.getProperty(obj, "ccy"));
		PropertyUtils.setProperty(bigamount, "crat",
				PropertyUtils.getProperty(obj, "psta"));
		PropertyUtils.setProperty(bigamount, "cfin",
				PropertyUtils.getProperty(obj, "opbank"));
		PropertyUtils.setProperty(bigamount, "cfct", "@N");
		Object opbankcode = (String) PropertyUtils.getProperty(obj,
				"opbankcode");
		if (null != opbankcode && ((String) opbankcode).length() == 12) {
			PropertyUtils.setProperty(bigamount, "cfic", opbankcode);
		} else {
			PropertyUtils.setProperty(bigamount, "cfic", "@N");
		}
		String opname = (String) PropertyUtils.getProperty(obj, "opname");
		opname = null != opname && opname.length() > 64 ? StringUtils
				.substring(opname, 0, 63) : opname;
		PropertyUtils.setProperty(bigamount, "tcnm", opname);
		PropertyUtils.setProperty(bigamount, "tcit", "@N");
		PropertyUtils.setProperty(bigamount, "tcid", "@N");
		PropertyUtils.setProperty(bigamount, "tcat", "@N");
		PropertyUtils.setProperty(bigamount, "tcac",
				PropertyUtils.getProperty(obj, "opaccount"));
		PropertyUtils.setProperty(bigamount, "bkid",
				PropertyUtils.getProperty(obj, "bkid"));
		PropertyUtils.setProperty(bigamount, "subbkid",
				PropertyUtils.getProperty(obj, "subbkid"));
		PropertyUtils.setProperty(bigamount, "importdate",
				PropertyUtils.getProperty(obj, "importdate"));
	}

	protected void setTbDefalutValue(Object bigamount)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.setProperty(bigamount, "tbnm", "@N");
		PropertyUtils.setProperty(bigamount, "tbit", "@N");
		PropertyUtils.setProperty(bigamount, "tbid", "@N");
		PropertyUtils.setProperty(bigamount, "tbnt", "@N");
	}

	protected void setDefaultValue(Object bigamount)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.setProperty(bigamount, "rpdt", "");
		PropertyUtils.setProperty(bigamount, "isedit", "0");
		PropertyUtils.setProperty(bigamount, "isdel", "0");
		PropertyUtils.setProperty(bigamount, "isvalidation", "0");
		PropertyUtils.setProperty(bigamount, "isexport", "0");
		PropertyUtils.setProperty(bigamount, "isinpboc", "0");
		PropertyUtils.setProperty(bigamount, "ishandadd", "0");
	}

	protected void setAmlByCustInfo(Object bigamount, Object o)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		PropertyUtils.setProperty(bigamount, "ctnm",
				PropertyUtils.getProperty(o, "ctnm"));
		PropertyUtils.setProperty(bigamount, "citp",
				PropertyUtils.getProperty(o, "citp"));
		PropertyUtils.setProperty(bigamount, "ctid",
				PropertyUtils.getProperty(o, "ctid"));
		PropertyUtils.setProperty(bigamount, "csnm",
				PropertyUtils.getProperty(o, "csnm"));
		PropertyUtils.setProperty(bigamount, "ctnt",
				PropertyUtils.getProperty(o, "ctnt"));
	}

	/**
	 * 得到所有交易的客户号
	 * 
	 * @param TranDetailEntitys
	 */
	private List<String> getApostpdidAndCnum(List<TranDetailEntity> TranDetailEntitys) {
		List<String> csnmList = new ArrayList<String>();
		for (TranDetailEntity TranDetailEntity : TranDetailEntitys) {
			if (StringUtils.isNotEmpty(TranDetailEntity.getCsnm())) {
				csnmList.add(TranDetailEntity.getCsnm());
			}
		}
		return csnmList;
	}

	/**
	 * 通过importdate提取AML交易记录，已经复核的交易数据不作重复提取 同时对已经提取的AML数据进行清除(未复核的数据)
	 * 
	 * @param importdate
	 * @return
	 */
	protected List<TranDetailEntity> getTransByImportdate(Date importdate) {

		// 1.apostpdid不是以EX,IM,LN开头的
		List<Object[]> ticds = delectUnValidationDatas(importdate);
		String querySQL = " importdate=? and (apostpdid not like ? and  apostpdid not like ? and apostpdid not like ?)";

		Object[] queryParas = null;
		if (!ticds.isEmpty()) {
			querySQL += " and dlref not in ?5";
			queryParas = new Object[] { importdate, "EX%", "IM%", "LN%", ticds };
		} else {
			queryParas = new Object[] { importdate, "EX%", "IM%", "LN%" };
		}
		List<TranDetailEntity> TranDetailEntitys = dao.queryByWhere(TranDetailEntity.class, querySQL,
				queryParas);
		// 去除apostpid cs转td （如CS#*20130930#*TD#*。。。。）或者td转cs的 ，或者td转td
		TranDetailEntity tradDetailEntiry = null;
		for (Iterator<TranDetailEntity> iter = TranDetailEntitys.iterator(); iter.hasNext();) {
			tradDetailEntiry = iter.next();
			//TODO 已经复核的交易数据不作重复提取 
		//	if (StringUtils.equals(tradDetailEntiry.getEnname(), tradDetailEntiry.getOpname())) {// 同名
		//		String[] apids = StringUtils
		//				.split(tradDetailEntiry.getApostpdid(), "#*");
		//		if ((StringUtils.startsWith(apids[0].trim(), "CS") && StringUtils
		//				.startsWith(apids[2].trim(), "TD"))
		//				|| (StringUtils.startsWith(apids[0].trim(), "TD") && StringUtils
		//						.startsWith(apids[2].trim(), "CS"))
		//				|| (StringUtils.startsWith(apids[0].trim(), "TD") && StringUtils
		//						.startsWith(apids[2].trim(), "TD"))) {
//
		//			iter.remove();
		//		}
		//	}
		}
		return TranDetailEntitys;

	}

	protected List<TranDetailEntity> getTransByRepaymentsandDrawdown(Date importdate) {
		return null;/*

		List<Object[]> ticds = delectUnValidationDatas(importdate);
		String querySQL = " importdate=? and principalaccountno is null and interestaccountno is null ";

		Object[] queryParas = null;
		if (!ticds.isEmpty()) {
			querySQL += " and lnrf not in ?2";
			queryParas = new Object[] { importdate, ticds };
		} else {
			queryParas = new Object[] { importdate };
		}
		List<TranDetailEntity> trans = new ArrayList<TranDetailEntity>();
		// 1.多讀 REPAYMENTADD
		// ,判斷repayment_date=當天只抓Principal_account_no及Interest_account_no是空白,才要將”客戶號/業務編號/交易金額”,放到AML中，如果不為空白，就不放AML
		List<Ifxrepayment> ifxrepayments = dao.queryByWhere(Ifxrepayment.class,
				querySQL, queryParas);

		if (null != ifxrepayments && !ifxrepayments.isEmpty()) {
			setRepayment2Tran(ifxrepayments, trans);

		}
		// 2.多讀 DRAWDOWNADD
		// ,判斷Drawdown_date=當天,只抓Principal_account_no及Interest_account_no是空白,才要將”客戶號/業務編號/交易金額”,放到AML中，如果不為空白，就不放AML
		List<Ifxdrawdown> ifxdrawdowns = dao.queryByWhere(Ifxdrawdown.class,
				querySQL, queryParas);
		if (null != ifxdrawdowns && !ifxdrawdowns.isEmpty()) {
			setdrawdown2Tran(ifxdrawdowns, trans);

		}
		// 讀到APPOSTPDADD
		// “IM”及”EX”打頭的資料,且其中APPOSTPDADD的“account”(客戶帳戶)是空白,才要將”客戶號/業務編號/交易金額”,放到AML中，如果不為空白，就不放AML
		querySQL = " importdate=? and (apostpdid  like ? and  apostpdid  like ? ) and acod is null";

		if (!ticds.isEmpty()) {
			querySQL += " and dlref not in ?4";
			queryParas = new Object[] { importdate, "EX%", "IM%", ticds };
		} else {
			queryParas = new Object[] { importdate, "EX%", "IM%" };
		}
		List<TranDetailEntity> TranDetailEntitys = dao.queryByWhere(TranDetailEntity.class, querySQL,
				queryParas);

		if (null != ifxdrawdowns && !ifxdrawdowns.isEmpty()) {
			trans.addAll(TranDetailEntitys);
		}
		return trans;

	*/}

/*	private void setRepayment2Tran(List<Ifxrepayment> ifxrepayments,
			List<TranDetailEntity> trans) {
		TranDetailEntity tran = null;
		for (Ifxrepayment rep : ifxrepayments) {
			tran = new TranDetailEntity();
			BeanUtils.copyProperties(rep, tran);
			tran.setPsta(rep.getRepaymentamount());
			tran.setApostpdid(rep.getLnrf());
			tran.setVald(rep.getRepaymentdate());
			tran.setDrcr("C");
			trans.add(tran);
		}

	}
*/


	/**
	 * 删除未复核的数据（已经复核的记录不可以通过提取按键删除)
	 * 
	 * @param importdate
	 * @return
	 */
	protected List<Object[]> delectUnValidationDatas(Date importdate) {
		List<Object[]> ticds = new ArrayList<Object[]>();
		ticds.addAll(dao.queryFieldValues(AmlBigAmount.class,
				new String[] { "ticd" }, "importdate=? and isvalidation='1'",
				new Object[] { importdate }));
		dao.deleteByWhere(AmlBigAmount.class,
				"importdate=? and isvalidation!='1'",
				new Object[] { importdate });
		return ticds;
	}

}
