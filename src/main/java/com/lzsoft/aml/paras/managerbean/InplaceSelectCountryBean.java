package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_Country;


@ManagedBean
@ApplicationScoped
public class InplaceSelectCountryBean {
    @ManagedProperty(value = "#{para_CountryParser.countryList}")
    private List<Para_Country> countrys;
    private List<SelectItem> countryOptions = null;

    @PostConstruct
    public void init() {
        countryOptions = new ArrayList<SelectItem>();
        for (Para_Country country : countrys) {
            countryOptions.add(new SelectItem(country.getCode(), country.getCode()+"-"+country.getCnname()));
        }
    }

	public List<Para_Country> getCountrys() {
		return countrys;
	}

	public void setCountrys(List<Para_Country> countrys) {
		this.countrys = countrys;
	}

	public List<SelectItem> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(List<SelectItem> countryOptions) {
		this.countryOptions = countryOptions;
	}
 

}
