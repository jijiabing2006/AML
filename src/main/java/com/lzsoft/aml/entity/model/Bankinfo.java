package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.lzsoft.aml.entity.base.BaseEO;

@Entity
@Table(name = "core_bankinfo")
@Repository("bankinfo")
public class Bankinfo extends BaseEO {

	private static final long serialVersionUID = 1L;

	private int id;

	private String bkid;
	private String subbkid;
	private String branchcode;
	private String bankcode;
	private String amlbankcode;
	private String shortcnname;
	private String shortenname;
	private String fullcnname;
	private String fullenname;
	private String areacode;
	private String parentid;
	private String address;
	private String provincecode;
	private String citycode;
	private String cityname;
	private String provincename;

	// Constructors

	/** default constructor */
	public Bankinfo() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "AMLBANKCODE")
	public String getAmlbankcode() {
		return this.amlbankcode;
	}

	public void setAmlbankcode(String amlbankcode) {
		this.amlbankcode = amlbankcode;
	}

	@Column(name = "SHORTCNNAME")
	public String getShortcnname() {
		return this.shortcnname;
	}

	public void setShortcnname(String shortcnname) {
		this.shortcnname = shortcnname;
	}

	@Column(name = "SHORTENNAME")
	public String getShortenname() {
		return this.shortenname;
	}

	public void setShortenname(String shortenname) {
		this.shortenname = shortenname;
	}

	@Column(name = "FULLCNNAME")
	public String getFullcnname() {
		return this.fullcnname;
	}

	public void setFullcnname(String fullcnname) {
		this.fullcnname = fullcnname;
	}

	@Column(name = "FULLENNAME")
	public String getFullenname() {
		return this.fullenname;
	}

	public void setFullenname(String fullenname) {
		this.fullenname = fullenname;
	}

	@Column(name = "PARENTID")
	public String getParentid() {
		return this.parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name = "BKID")
	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}
	@Column(name = "SUBBKID")
	public String getSubbkid() {
		return subbkid;
	}
	
	public void setSubbkid(String subbkid) {
		this.subbkid = subbkid;
	}
	@Column(name = "BRANCHCODE")
	public String getBranchcode() {
		return branchcode;
	}

	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}
	@Column(name = "BANKCODE_C14")
	public String getBankcode() {
		return bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	@Column(name = "AREACODE")
	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getProvincecode() {
		return provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}


	public String getProvincename() {
		return provincename;
	}

	public void setProvincename(String provincename) {
		this.provincename = provincename;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCityname() {
		return cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
}