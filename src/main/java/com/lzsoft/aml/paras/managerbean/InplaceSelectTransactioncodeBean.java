package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_Transactioncode;

@ManagedBean
@ApplicationScoped
public class InplaceSelectTransactioncodeBean {
	@ManagedProperty(value = "#{para_TransactioncodeParser.transactioncodeList}")
	private List<Para_Transactioncode> transactioncodes;
	private List<SelectItem> transactionOptions = null;

	@PostConstruct
	public void init() {
		transactionOptions = new ArrayList<SelectItem>();
		for (Para_Transactioncode transaction : transactioncodes) {
			transactionOptions.add(new SelectItem(transaction.getCode(),
					transaction.getCode() + "-" + transaction.getName()));
		}
	}

	public List<Para_Transactioncode> getTransactioncodes() {
		return transactioncodes;
	}

	public void setTransactioncodes(List<Para_Transactioncode> transactioncodes) {
		this.transactioncodes = transactioncodes;
	}

	public List<SelectItem> getTransactionOptions() {
		return transactionOptions;
	}

	public void setTransactionOptions(List<SelectItem> transactionOptions) {
		this.transactionOptions = transactionOptions;
	}
}
