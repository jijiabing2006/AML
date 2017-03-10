package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.lzsoft.aml.paras.model.Para_Accountttype;



@ManagedBean
@ApplicationScoped
public class AutocompleteAccounttypeBean {
    private List<String> autocompleteList;
    @ManagedProperty(value = "#{para_AccounttypesParser.accounttypesList}")
    private List<Para_Accountttype> accounttypes;

    public AutocompleteAccounttypeBean() {
    }

    @PostConstruct
    public void init() {
        autocompleteList = new ArrayList<String>();
        for (Para_Accountttype accounttype : accounttypes) {
            autocompleteList.add(accounttype.getCode());
        }
    }

    public List<String> autocomplete(String prefix) {
        ArrayList<String> result = new ArrayList<String>();
        if ((prefix == null) || (prefix.length() == 0)) {
            for (int i = 0; i < 10; i++) {
                result.add(accounttypes.get(i).getCode());
            }
        } else {
            Iterator<Para_Accountttype> iterator = accounttypes.iterator();
            while (iterator.hasNext()) {
            	Para_Accountttype elem = ((Para_Accountttype) iterator.next());
                if ((elem.getCode() != null && elem.getCode().toLowerCase().indexOf(prefix.toLowerCase()) == 0)
                    || "".equals(prefix)) {
                    result.add(elem.getCode());
                }
            }
        }

        return result;
    }

	public List<String> getAutocompleteList() {
		return autocompleteList;
	}

	public void setAutocompleteList(List<String> autocompleteList) {
		this.autocompleteList = autocompleteList;
	}

	public List<Para_Accountttype> getAccounttypes() {
		return accounttypes;
	}

	public void setAccounttypes(List<Para_Accountttype> accounttypes) {
		this.accounttypes = accounttypes;
	}

 
}
