package com.lzsoft.aml.entity.model.querymodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.base.BaseEO;

/**
 * @author cn60243
 *
 */
@SuppressWarnings("serial")

@ManagedBean(name="bankQueryBean")
@ViewScoped
public class BankInfoQueryBean  extends BaseEO{
	private String branchcode; //12 digit
	private String bankcodec14; //14 digit
	private String amlbankcode; //15 digit
	private String shortcnname; //
	private String shortenname; //
	private String fullcnname; //
	private String fullenname; //
	private String parentid; //
	private String areacode; //
	private String address; //
	private String bkid; //
	private String subbkid; //



	public String getBkid() {
		return bkid;
	}


	public void setBkid(String bkid) {
		this.bkid = bkid;
	}


	public String getSubbkid() {
		return subbkid;
	}


	public void setSubbkid(String subbkid) {
		this.subbkid = subbkid;
	}


	public String getBranchcode() {
		return branchcode;
	}


	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}


	public String getBankcodec14() {
		return bankcodec14;
	}


	public void setBankcodec14(String bankcodec14) {
		this.bankcodec14 = bankcodec14;
	}


	public String getAmlbankcode() {
		return amlbankcode;
	}


	public void setAmlbankcode(String amlbankcode) {
		this.amlbankcode = amlbankcode;
	}


	public String getShortcnname() {
		return shortcnname;
	}


	public void setShortcnname(String shortcnname) {
		this.shortcnname = shortcnname;
	}


	public String getShortenname() {
		return shortenname;
	}


	public void setShortenname(String shortenname) {
		this.shortenname = shortenname;
	}


	public String getFullcnname() {
		return fullcnname;
	}


	public void setFullcnname(String fullcnname) {
		this.fullcnname = fullcnname;
	}


	public String getFullenname() {
		return fullenname;
	}


	public void setFullenname(String fullenname) {
		this.fullenname = fullenname;
	}


	public String getParentid() {
		return parentid;
	}


	public void setParentid(String parentid) {
		this.parentid = parentid;
	}


	public String getAreacode() {
		return areacode;
	}


	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
