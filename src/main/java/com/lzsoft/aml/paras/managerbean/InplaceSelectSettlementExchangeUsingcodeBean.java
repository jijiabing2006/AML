package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_SettlementExchangeUsingcode;

@ManagedBean
@ApplicationScoped
public class InplaceSelectSettlementExchangeUsingcodeBean {
	@ManagedProperty(value = "#{para_SettlementExchangeUsingcodeParser.usingcodeList}")
	private List<Para_SettlementExchangeUsingcode> usingcodes;
	private List<SelectItem> usingcodeOptions = null;
	private String value;

	@PostConstruct
	public void init() {
		usingcodeOptions = new ArrayList<SelectItem>();
		for (Para_SettlementExchangeUsingcode settlementExchangeUsingcode : usingcodes) {
			usingcodeOptions.add(new SelectItem(
					settlementExchangeUsingcode.getCode(),
					settlementExchangeUsingcode.getCode() + "-"
							+ settlementExchangeUsingcode.getName()));
		}
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = "1000";
	}

	public List<Para_SettlementExchangeUsingcode> getUsingcodes() {
		return usingcodes;
	}

	public void setUsingcodes(List<Para_SettlementExchangeUsingcode> usingcodes) {
		this.usingcodes = usingcodes;
	}

	public List<SelectItem> getUsingcodeOptions() {
		return usingcodeOptions;
	}

	public void setUsingcodeOptions(List<SelectItem> usingcodeOptions) {
		this.usingcodeOptions = usingcodeOptions;
	}


}
