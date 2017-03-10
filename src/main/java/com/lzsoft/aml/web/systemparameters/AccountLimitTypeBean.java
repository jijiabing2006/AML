package com.lzsoft.aml.web.systemparameters;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.lzsoft.aml.entity.model.AccountLimitType;
import com.lzsoft.aml.service.systemparameters.IAccountLimitTypeService;
import com.lzsoft.aml.web.BaseBean;
@ManagedBean(name="accountLimitTypeBean")
@ViewScoped
public class AccountLimitTypeBean extends BaseBean{
	@ManagedProperty("#{accountLimitType}")
	private AccountLimitType accountLimitType;

	@ManagedProperty("#{accountLimitTypeService}")
	private IAccountLimitTypeService accountLimitTypeService;
	
	private List<AccountLimitType> accountLimitTypes;
	

	public List<AccountLimitType> getAccountLimitTypes() {


			if (null == accountLimitTypes) {
				accountLimitTypes = accountLimitTypeService.findAll();
			}
		return accountLimitTypes;
	}

	public void deleteRecord(AccountLimitType accountlimittype) {
			this.accountLimitTypeService.delete(accountlimittype);
			this.accountLimitTypes.remove(accountlimittype);//同步(accountlimittypes)
	}

	public void removeRecord() {
		for (AccountLimitType accountLimitType : accountLimitTypes) {
			if (currentId == accountLimitType.getId()) {
				this.accountLimitTypeService.delete(accountLimitType);
				this.accountLimitTypes.remove(accountLimitType);// 同步(accountlimittypes)
				break;
			}
		}
	}
	
	public void deleteRecordByID() {
		System.out.println("");
		AccountLimitType ac=new  AccountLimitType();
		ac.setId(5);
		ac.setTypecode("22");
		ac.setTypenamecn("测试2");
		
		accountLimitTypes.add(ac);
	}
	public String addConfirmedUser() {
		  boolean added = true;
		  FacesMessage doneMessage = null;
		  String outcome = null;
		    if (added) {
		        doneMessage = new FacesMessage("Successfully added new user");
		        outcome = "accountlimittype";
		    } else {
		        doneMessage = new FacesMessage("Failed to add new user");
		        outcome = "accountlimittype";
		    }
		  FacesContext.getCurrentInstance().addMessage(null, doneMessage);
		  return outcome;
		}


	public String addRecordAndRedirect() {
		System.out.println("");
//		AccountLimitType ac=new  AccountLimitType();
//		ac.setId(5);
//		ac.setTypecode("22");
//		ac.setTypenamecn("测试2");
//		
//		accountLimitTypes.add(ac);
		return "accountlimittype_edit?faces-redirect=true&amp;includeViewParams=true";
	}
	public void goEdit(AccountLimitType accountlimittype ) {
		setAccountLimitType(accountlimittype);
		System.out.println();
	}
	public void goEdit() {
		System.out.println();
	}
	public void updateAccountLimitType( ) {
		this.accountLimitTypeService.update(accountLimitType);
		addWorningMessage("editPane",accountLimitType.toString()+"的内容已经保存！",false,0);
	}
	
	public void setAccountLimitTypes(List<AccountLimitType> accountLimitTypes) {
		this.accountLimitTypes = accountLimitTypes;
	}

	public AccountLimitType getAccountLimitType() {
		return accountLimitType;
	}

	public void setAccountLimitType(AccountLimitType accountLimitType) {
		this.accountLimitType = accountLimitType;
	}

	public IAccountLimitTypeService getAccountLimitTypeService() {
		return accountLimitTypeService;
	}

	public void setAccountLimitTypeService(
			IAccountLimitTypeService accountLimitTypeService) {
		this.accountLimitTypeService = accountLimitTypeService;
	}

}
