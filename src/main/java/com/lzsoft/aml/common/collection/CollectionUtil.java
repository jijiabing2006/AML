package com.lzsoft.aml.common.collection;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;

import com.lzsoft.aml.entity.model.AccountLimitType;
import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.service.systemmanager.IBankInfoService;
import com.lzsoft.aml.service.systemparameters.IAccountLimitTypeService;
import com.lzsoft.aml.web.BaseBean;

/**
 * 
 * @author Lawrence
 * 
 */
@ManagedBean(name = "collctionutilMB")
@RequestScoped
public class CollectionUtil extends BaseBean {

	private static String language;
	// * 国家代码管理类
	// * 机构协会代码管理类
	// * 行业代码管理类
	// * 机构属性代码管理类
	// * 帐户性质代码管理类
	// * 币种代码管理类
	// *  交易编码管理类
	// * 区域代码管理类
	// * 银行信息管理类
	// * AML行业类型管理类
	// * ABOQ帐户类型集合
	/**
	 * ACC限额类型集合
	 */
	private static List<SelectItem> accountLimitTypeList;
	/**
	 * Branch集合
	 */
	private static List<SelectItem> branchList;
	/**
	 * subBranch集合
	 */
	private List<SelectItem> subBranchList;

	private String bankname = "";

	@ManagedProperty("#{accountLimitTypeService}")
	private IAccountLimitTypeService accountLimitTypeService;

	@ManagedProperty("#{bankService}")
	private IBankInfoService bankService;

	public IAccountLimitTypeService getAccountLimitTypeService() {
		return accountLimitTypeService;
	}

	public void setAccountLimitTypeService(
			IAccountLimitTypeService accountLimitTypeService) {
		this.accountLimitTypeService = accountLimitTypeService;
	}

	public IBankInfoService getBankService() {
		return bankService;
	}

	public void setBankService(IBankInfoService bankService) {
		this.bankService = bankService;
	}

	public String getLanguage() {
		return language;
	}

	public List<SelectItem> getAccountLimitTypeList() {

		if (null == accountLimitTypeList) {
			// accountLimitTypeList = accountLimitTypeService
			// .findAllSelectItems(language);
			List<AccountLimitType> bList = accountLimitTypeService.findAll();
			accountLimitTypeList = findAllSelectItems(language, bList,
					accountLimitTypeList, "typecode", new Object[] {
							"typecode", "typenamecn", "typenameen" }, true,
					true);
		}
		// }
		return accountLimitTypeList;
	}

	public void setAccountLimitTypeList(List<SelectItem> accountLimitTypeList) {
		CollectionUtil.accountLimitTypeList = accountLimitTypeList;
	}

	public List<SelectItem> getBranchList() {
		if (null == branchList) {
			List<Bankinfo> bList;
			try {
				bList = bankService.queryByWhere("1=1 group by bkid");

				branchList = findAllSelectItems(language, bList, branchList,
						"bkid", new Object[] { "bkid", "shortcnname",
								"shortenname" }, true, false);
			}catch (Exception e) {
				//e.printStackTrace();
				addWorningMessage("", "获得银行信息分行下拉列表内容时发生错误" + e.getMessage(),
						false, 3);
				log.error("获得银行信息分行下拉列表内容时发生错误", e);
			}
		}
		// }
		return branchList;
	}

	public void setBranchList(List<SelectItem> branchList) {
		CollectionUtil.branchList = branchList;
	}

	public void setSubBranchList(List<SelectItem> subBranchList) {
		this.subBranchList = subBranchList;
	}

	public List<SelectItem> getSubBranchList() {
		if (null == subBranchList) {
			List<Bankinfo> bList;
			try {
				bList = bankService.queryByWhere("1=1 group by subbkid");
				subBranchList = findAllSelectItems(language, bList,
						subBranchList, "subbkid", new Object[] { "subbkid",
								"shortcnname", "shortenname" }, true, false);
			} catch (Exception e) {
				//e.printStackTrace();
				addWorningMessage("", "获得银行信息支行下拉列表内容时发生错误" + e.getMessage(),
						false, 3);
				log.error("获得银行信息支行下拉列表内容时发生错误", e);
			}

		}
		return subBranchList;
	}

	public CollectionUtil() {
		setLanguage();
	}

	private List<SelectItem> findAllSelectItems(String language, @SuppressWarnings("rawtypes") List beList,
			List<SelectItem> selectList, String key, Object[] objects,
			boolean h, boolean v) {

		selectList = new ArrayList<SelectItem>();
		for (Object object : beList) {

			String[] values = new String[4];

			getSelectValues(objects, key, h, v, object, values);
			if ("zh".equalsIgnoreCase(language)
					|| "zh_CN".equalsIgnoreCase(language)
					|| language.toUpperCase().indexOf("ZH") >= 0)

				selectList.add(new SelectItem(values[0], values[2]));
			else {
				selectList.add(new SelectItem(values[0], values[3]));
			}
		}

		return selectList;
	}

	/**
	 * 
	 * @param objects
	 *            含有h,v对应的字段名
	 * @param key
	 *            下拉列表的Key 字段名
	 * @param h
	 *            是否要“-”左边
	 * @param v
	 *            是否要“-”右边
	 * @param object
	 * @param values
	 *            根据 h ,v 组合values内容
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected void getSelectValues(Object[] objects, String key, boolean h,
			boolean v, Object object, String[] values) {
		try {
			values[0] = (String) PropertyUtils.getProperty(object, key);
			if (h)
				values[1] = (String) PropertyUtils.getProperty(object,
						(String) objects[0]);
			if (v) {
				values[2] = (String) PropertyUtils.getProperty(object,
						(String) objects[1]);
				values[3] = (String) PropertyUtils.getProperty(object,
						(String) objects[2]);
				values[3] = values[3].equals("") ? values[2] : values[3];
				if (h) {
					values[2] = values[1] + "-" + values[2];
					values[3] = values[1] + "-" + values[3];
				}
			} else {
				values[3] = values[2] = values[1];
			}
		} catch (IllegalAccessException e) {
		//	e.printStackTrace();
			addWorningMessage("", "获得下拉列表内容时发生错误" + e.getMessage(), false, 3);
			log.error("获得下拉列表内容时发生错误", e);
		} catch (InvocationTargetException e) {
		//	e.printStackTrace();
			addWorningMessage("", "获得下拉列表内容时发生错误" + e.getMessage(), false, 3);
			log.error("获得下拉列表内容时发生错误", e);
		} catch (NoSuchMethodException e) {
		//	e.printStackTrace();
			addWorningMessage("", "获得下拉列表内容时发生错误" + e.getMessage(), false, 3);
			log.error("获得下拉列表内容时发生错误", e);
		}
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public void setLanguage() {
		if (null == language) {
			HttpSession session = ((HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest())
					.getSession();
			CollectionUtil.language = "zh_CN";
			if (null != session.getAttribute("myLocale"))
				CollectionUtil.language = session.getAttribute("myLocale")
						.toString();
		}

	}

	public void valueBkidChanged(ValueChangeEvent event) {
		if (null != subBranchList){
			subBranchList.clear();
		}
		if (null != event.getNewValue()) {
			String bkid = (String) event.getNewValue();
			List<Bankinfo> bList;
			try {
				bList = bankService.queryByWhere(" bkid= " + bkid);

				subBranchList = findAllSelectItems(language, bList,
						subBranchList, "subbkid", new Object[] { "subbkid",
								"shortcnname", "shortenname" }, true, false);
			}catch (Exception e) {
			//	e.printStackTrace();
				log.error("转换BKID时发生错误", e);
			}
		}
	}

}
