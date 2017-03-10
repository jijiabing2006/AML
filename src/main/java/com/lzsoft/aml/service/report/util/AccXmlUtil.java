package com.lzsoft.aml.service.report.util;

import java.text.DecimalFormat;

import org.apache.commons.beanutils.BeanUtils;
import org.jdom2.Element;

import com.lzsoft.aml.util.DateUtil;

public class AccXmlUtil extends SafeXmlUtil{
	
	public AccXmlUtil(String type){
		super(type);
	}

	// 根据传入的文件类型和数据动态得到REC节点
	@Override
	public Element getRec(String fileType, Object data) throws Exception {
		Element REC = new Element("REC");
		Element ACTIONTYPE = new Element("ACTIONTYPE");// 操作类型
		ACTIONTYPE.setText(BeanUtils.getProperty(data, "actiontype"));
		REC.addContent(ACTIONTYPE);
		Element ACTIONDESC = new Element("ACTIONDESC");// 修改 删除原因
		ACTIONDESC.setText(BeanUtils.getProperty(data, "actiondesc"));
		REC.addContent(ACTIONDESC);
		Element BRANCHCODE = new Element("BRANCH_CODE");// 金融机构标识码
		BRANCHCODE.setText(BeanUtils.getProperty(data, "branchcode"));
		REC.addContent(BRANCHCODE);
		if ("CA".equals(fileType)) {
			Element BRANCHNAME = new Element("BRANCH_NAME");// 金融机构名称
			BRANCHNAME.setText(BeanUtils.getProperty(data, "branchname"));
			REC.addContent(BRANCHNAME);
		}

		Element ACCOUNTNO = new Element("ACCOUNTNO");// 账号
		ACCOUNTNO.setText(BeanUtils.getProperty(data, "accountno"));
		REC.addContent(ACCOUNTNO);
		if ("CB".equals(fileType)) {
			Element DEALDATE = new Element("DEAL_DATE");// 发生日期
			DEALDATE.setText(DateUtil.dateToStr(DateUtil.strToDate(BeanUtils
					.getProperty(data, "dealdate"), "yyyy-MM-dd"),
					"yyyyMMdd"));
			REC.addContent(DEALDATE);
		}

		if ("CA".equals(fileType)) {
			Element ACCOUNTSTAT = new Element("ACCOUNTSTAT");// 账户状态
			ACCOUNTSTAT
					.setText(BeanUtils.getProperty(data, "accountstat"));
			REC.addContent(ACCOUNTSTAT);
			Element AMTYPE = new Element("AMTYPE");// 开户主体类型
			AMTYPE.setText(BeanUtils.getProperty(data, "amtype"));
			REC.addContent(AMTYPE);
			Element ENCODE = new Element("EN_CODE");// 开户主体代码
			ENCODE.setText(BeanUtils.getProperty(data, "encode"));
			REC.addContent(ENCODE);
			Element ENNAME = new Element("EN_NAME");// 开户主体名称
			ENNAME.setText(BeanUtils.getProperty(data, "enname"));
			REC.addContent(ENNAME);
			Element ACCOUNTTYPE = new Element("ACCOUNT_TYPE");// 收入款金额
			ACCOUNTTYPE
					.setText(BeanUtils.getProperty(data, "accounttype"));
			REC.addContent(ACCOUNTTYPE);
			Element ACCOUNTCATA = new Element("ACCOUNT_CATA");// 账户类别
			ACCOUNTCATA
					.setText(BeanUtils.getProperty(data, "accountcata"));
			REC.addContent(ACCOUNTCATA);
		}
		Element CURRENCYCODE = new Element("CURRENCY_CODE");// 币种
		CURRENCYCODE.setText(BeanUtils.getProperty(data, "currencycode"));
		REC.addContent(CURRENCYCODE);
		if ("CB".equals(fileType)) {
			@SuppressWarnings("unused")
			DecimalFormat df = new DecimalFormat("##00.00");
			Element CREDIT = new Element("CREDIT");// 当日贷方发生额
			CREDIT.setText(BeanUtils.getProperty(data, "credit"));
//			if (Double.valueOf(BeanUtils.getProperty(data, "credit"))
//					.compareTo(Double.valueOf("0")) == 0)
//				CREDIT.setText("0");
//			else
//			CREDIT.setText(df.format(Double.valueOf(BeanUtils
//					.getProperty(data, "credit"))));
			REC.addContent(CREDIT);
			Element DEBIT = new Element("DEBIT");// 当日借方发生额
//			if (Double.valueOf(BeanUtils.getProperty(data, "debit"))
//					.compareTo(Double.valueOf("0")) == 0)
//				DEBIT.setText("0");
//			else
//				DEBIT.setText(df.format(Double.valueOf(BeanUtils
//						.getProperty(data, "debit"))));
			DEBIT.setText(BeanUtils.getProperty(data, "debit"));
			REC.addContent(DEBIT);
			Element BALANCE = new Element("BALANCE");// 当日借方发生额
//			if (Double.valueOf(BeanUtils.getProperty(data, "balance"))
//					.compareTo(Double.valueOf("0")) == 0)
//				BALANCE.setText("0");
//			else
//				BALANCE.setText(df.format(Double.valueOf(BeanUtils
//						.getProperty(data, "balance"))));
			BALANCE.setText(BeanUtils.getProperty(data, "balance"));
			REC.addContent(BALANCE);
		}
		if ("CA".equals(fileType)) {
			Element BUSINESSDATE = new Element("BUSINESS_DATE");// 业务发生日期
			BUSINESSDATE.setText(DateUtil.dateToStr(DateUtil.strToDate(
					BeanUtils.getProperty(data, "businessdate"),
					"yyyy-MM-dd"), "yyyyMMdd"));
			REC.addContent(BUSINESSDATE);
			Element FILENUMBER = new Element("FILE_NUMBER");// 外汇局批件号/备案表号/业务编号
			FILENUMBER.setText(BeanUtils.getProperty(data, "filenumber"));
			REC.addContent(FILENUMBER);
			Element LIMITTYPE = new Element("LIMIT_TYPE");// 限额类型
			LIMITTYPE.setText(BeanUtils.getProperty(data, "limittype"));
			REC.addContent(LIMITTYPE);
			Element ACCOUNTLIMIT = new Element("ACCOUNT_LIMIT");// 账户限额
			ACCOUNTLIMIT.setText(BeanUtils.getProperty(data,
					"accountlimit"));
			REC.addContent(ACCOUNTLIMIT);
		}
		Element REMARK = new Element("REMARK");// 备注
		REMARK.setText(BeanUtils.getProperty(data, "remark"));
		REC.addContent(REMARK);
		return REC;
	}

	@Override
	public String generateEmptyReport(String pbocBankCode, String reportDate,
			int parseInt) {
		return null;
	}
}
