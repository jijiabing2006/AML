package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import com.lzsoft.aml.paras.model.Para_Currency;



@ManagedBean
@ApplicationScoped
public class AutocompleteCurrencyBean {
    private List<String> autocompleteList;
    @ManagedProperty(value = "#{para_CurrencyParser.currencyList}")
    private List<Para_Currency> currencys;

    public AutocompleteCurrencyBean() {
    }

    @PostConstruct
    public void init() {
        autocompleteList = new ArrayList<String>();
        for (Para_Currency currency : currencys) {
            autocompleteList.add(currency.getCode());
        }
    }

    public List<String> autocomplete(String prefix) {
        ArrayList<String> result = new ArrayList<String>();
        if ((prefix == null) || (prefix.length() == 0)) {
            for (int i = 0; i < 10; i++) {
                result.add(currencys.get(i).getCode());
            }
        } else {
            Iterator<Para_Currency> iterator = currencys.iterator();
            while (iterator.hasNext()) {
            	Para_Currency elem = ((Para_Currency) iterator.next());
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

	public List<Para_Currency> getCurrencys() {
		return currencys;
	}

	public void setCurrencys(List<Para_Currency> currencys) {
		this.currencys = currencys;
	}
 
}
