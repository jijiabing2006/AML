package com.lzsoft.aml.web.systemmanager.basedata;

import java.util.Collection;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.service.systemmanager.ISuperadditionService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean
@RequestScoped
public class SuperaddManagerBean extends BaseBean {/*

	@ManagedProperty("#{ifxacct}")
	private Ifxacct ifxacct;
	@ManagedProperty("#{ifxtran}")
	private Ifxtran ifxtran;
	@ManagedProperty("#{ifxcust}")
	private Ifxcust ifxcust;

	boolean hascust;
	boolean hasaccount;
	Date importdate;

	@ManagedProperty("#{superadditionService}")
	private ISuperadditionService service;


	private Collection<Object> selection;

	public void selectionListener(AjaxBehaviorEvent event) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		Object originalKey = dataTable.getRowKey();
		ifxacct = null;
		for (Object selectionKey : selection) {
			dataTable.setRowKey(selectionKey);
			if (dataTable.isRowAvailable()) {
				ifxacct = (Ifxacct) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(originalKey);
	}
	
	public void save(){
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);

		} else {
			int flag = this.service.save(user, importdate, ifxacct, ifxtran,
					ifxcust, hascust, hasaccount);
			if (flag == 1) {
				addWorningMessage("dataForm","营业日期为["+importdate+"],客户编号["+ifxcust.getCsnm()+"],账户["+ifxacct.getAcod()+"],币种["+ifxacct.getCcy()+"]的交易已经保存完成。", false, 0);
			} else {
				addWorningMessage("dataForm","营业日期为["+importdate+"],客户编号["+ifxcust.getCsnm()+"],账户["+ifxacct.getAcod()+"],币种["+ifxacct.getCcy()+"]的交易保存失败。", false, 3);
			}
		}
	}
	public void importdb(){
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作。", false, 1);
		} else {
			try {
				this.service.importdb();
				 addWorningMessage("dataForm","数据导入完成。", false, 0);
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("exportform", "导入数据时发生错误。", false, 2);
			}
		   
		}
	}
	
	public void importSummit2db(){
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作。", false, 1);
		} else if(null == importdate) {
			addWorningMessage("exportform", "请选择导入Summit数据的日期。", false, 1);
		} else {
			try {
				this.service.importSummit2Db(importdate);
				addWorningMessage("dataForm", "数据导入完成。", false, 0);
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("exportform", "导入数据时发生错误。", false, 2);
			}
		   
		}
	}

	public Ifxacct getIfxacct() {
		return ifxacct;
	}

	public void setIfxacct(Ifxacct ifxacct) {
		this.ifxacct = ifxacct;
	}

	public Ifxtran getIfxtran() {
		return ifxtran;
	}

	public void setIfxtran(Ifxtran ifxtran) {
		this.ifxtran = ifxtran;
	}

	public Ifxcust getIfxcust() {
		return ifxcust;
	}

	public void setIfxcust(Ifxcust ifxcust) {
		this.ifxcust = ifxcust;
	}

	public ISuperadditionService getService() {
		return service;
	}

	public void setService(ISuperadditionService service) {
		this.service = service;
	}

	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}

	public boolean isHascust() {
		return hascust;
	}

	public void setHascust(boolean hascust) {
		this.hascust = hascust;
	}

	public boolean isHasaccount() {
		return hasaccount;
	}

	public void setHasaccount(boolean hasaccount) {
		this.hasaccount = hasaccount;
	}
*/}
