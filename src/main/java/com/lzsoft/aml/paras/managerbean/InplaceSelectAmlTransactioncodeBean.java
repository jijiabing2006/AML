package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_AmlTransactioncode;

@ManagedBean
@ApplicationScoped
public class InplaceSelectAmlTransactioncodeBean {
	@ManagedProperty(value = "#{para_AmlTransactioncodeParser.transactioncodeList}")
	private List<Para_AmlTransactioncode> transactioncodes;
	private List<SelectItem> transactionOptions = null;

	@PostConstruct
	public void init() {
		transactionOptions = new ArrayList<SelectItem>();
		for (Para_AmlTransactioncode transaction : transactioncodes) {
			transactionOptions.add(new SelectItem(transaction.getCode(),
					transaction.getCode() + "-" + transaction.getName()));
		}
	}

	public List<Para_AmlTransactioncode> getTransactioncodes() {
		return transactioncodes;
	}

	public void setTransactioncodes(List<Para_AmlTransactioncode> transactioncodes) {
		this.transactioncodes = transactioncodes;
	}

	public List<SelectItem> getTransactionOptions() {
		return transactionOptions;
	}

	public void setTransactionOptions(List<SelectItem> transactionOptions) {
		this.transactionOptions = transactionOptions;
	}

	
}
