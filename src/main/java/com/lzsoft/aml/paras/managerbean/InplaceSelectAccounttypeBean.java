package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_Accountttype;


@ManagedBean
@ApplicationScoped
public class InplaceSelectAccounttypeBean {
    @ManagedProperty(value = "#{para_AccounttypesParser.accounttypesList}")
    private List<Para_Accountttype> accounttypes;
    private List<SelectItem> accounttypeOptions = null;
    private String value;

    @PostConstruct
    public void init() {
        accounttypeOptions = new ArrayList<SelectItem>();
        for (Para_Accountttype accounttype : accounttypes) {
            accounttypeOptions.add(new SelectItem(accounttype.getCode(), accounttype.getCode()+"-"+accounttype.getName()));
        }
    }

   
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = "1000";
    }


	public List<SelectItem> getAccounttypeOptions() {
		return accounttypeOptions;
	}


	public void setAccounttypeOptions(List<SelectItem> accounttypeOptions) {
		this.accounttypeOptions = accounttypeOptions;
	}


	public void setAccounttypes(List<Para_Accountttype> accounttypes) {
		this.accounttypes = accounttypes;
	}
}
