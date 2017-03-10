package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Title: Entity
 * @Description: 同业客户信息表
 * @author onlineGenerator
 * @date 2015-08-26 15:21:50
 * @version V1.0
 * 
 */
@Entity
@Table(name = "t_cust_bank", schema = "")
@SuppressWarnings("serial")
@PrimaryKeyJoinColumn(name = "id")
public class CustBankEntity extends CustBaseEntity implements java.io.Serializable {
	/** 评级机构名称 */
	@Excel(name = "评级机构名称")
	private java.lang.String ecas;
	/** 外部信用评级 */
	@Excel(name = "外部信用评级")
	private java.lang.String crating;
	/** 国税证号 */
	@Excel(name = "国税证号")
	private java.lang.String nationaltaxlic;
	/** 地税证号 */
	@Excel(name = "地税证号")
	private java.lang.String localtaxlic;
	/** 客户税务登记证地址 */
	@Excel(name = "客户税务登记证地址")
	private java.lang.String taxAddress;
	/** 客户收件地址 */
	@Excel(name = "客户收件地址")
	private java.lang.String receiveAddress;
	/** 是否需要开票 */
	@Excel(name = "是否需要开票")
	private java.lang.String isInvoice;
	/** 发票类型 */
	@Excel(name = "发票类型")
	private java.lang.String typeInvoice;
	/** 开户日期 */
	@Excel(name = "开户日期")
	private java.util.Date opdt;
	/** 交易对手金融机构代码 */
	@Excel(name = "交易对手金融机构代码")
	private java.lang.String cptc;
	/** 统一社会信用代码 */
	@Excel(name = "统一社会信用代码")
	private java.lang.String citpUscc;
	/** 联系人 */
	@Excel(name = "联系人")
	private java.lang.String contactor;
	/** 邮政编码 */
	@Excel(name = "邮政编码")
	private java.lang.String zipcode;
	/** 开票频率 */
	@Excel(name = "开票频率")
	private java.lang.String invFreq;	
	/** SWIFT代码 */
	@Excel(name = "SWIFT代码")
	private java.lang.String swiftcode;	
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 评级机构名称
	 */
	@Column(name = "ECAS", nullable = true, length = 10)
	public java.lang.String getEcas() {
		return this.ecas;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 评级机构名称
	 */
	public void setEcas(java.lang.String ecas) {
		this.ecas = ecas;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 外部信用评级
	 */
	@Column(name = "CRATING", nullable = true, length = 10)
	public java.lang.String getCrating() {
		return this.crating;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 外部信用评级
	 */
	public void setCrating(java.lang.String crating) {
		this.crating = crating;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 国税证号
	 */
	@Column(name = "NATIONALTAXLIC", nullable = true, length = 50)
	public java.lang.String getNationaltaxlic() {
		return this.nationaltaxlic;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 国税证号
	 */
	public void setNationaltaxlic(java.lang.String nationaltaxlic) {
		this.nationaltaxlic = nationaltaxlic;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 地税证号
	 */
	@Column(name = "LOCALTAXLIC", nullable = true, length = 50)
	public java.lang.String getLocaltaxlic() {
		return this.localtaxlic;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 地税证号
	 */
	public void setLocaltaxlic(java.lang.String localtaxlic) {
		this.localtaxlic = localtaxlic;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 客户税务登记证地址
	 */
	@Column(name = "TAX_ADDRESS", nullable = true, length = 50)
	public java.lang.String getTaxAddress() {
		return this.taxAddress;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 客户税务登记证地址
	 */
	public void setTaxAddress(java.lang.String taxAddress) {
		this.taxAddress = taxAddress;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 客户收件地址
	 */
	@Column(name = "RECEIVE_ADDRESS", nullable = true, length = 50)
	public java.lang.String getReceiveAddress() {
		return this.receiveAddress;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 客户收件地址
	 */
	public void setReceiveAddress(java.lang.String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否需要开票
	 */
	@Column(name = "IS_INVOICE", nullable = true, length = 1)
	public java.lang.String getIsInvoice() {
		return this.isInvoice;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否需要开票
	 */
	public void setIsInvoice(java.lang.String isInvoice) {
		this.isInvoice = isInvoice;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 发票类型
	 */
	@Column(name = "TYPE_INVOICE", nullable = true, length = 50)
	public java.lang.String getTypeInvoice() {
		return this.typeInvoice;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 发票类型
	 */
	public void setTypeInvoice(java.lang.String typeInvoice) {
		this.typeInvoice = typeInvoice;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 开户日期
	 */
	@Column(name = "OPDT", nullable = true)
	public java.util.Date getOpdt() {
		return this.opdt;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 开户日期
	 */
	public void setOpdt(java.util.Date opdt) {
		this.opdt = opdt;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手金融机构代码
	 */
	@Column(name = "CPTC", nullable = true, length = 50)
	public java.lang.String getCptc() {
		return this.cptc;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手金融机构代码
	 */
	public void setCptc(java.lang.String cptc) {
		this.cptc = cptc;
	}
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 统一社会信用代码
	 */
	@Column(name = "CITP_USCC", nullable = true, length = 50)
	public java.lang.String getCitpUscc() {
		return citpUscc;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 统一社会信用代码
	 */
	public void setCitpUscc(java.lang.String citpUscc) {
		this.citpUscc = citpUscc;
	}
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 联系人
	 */
	@Column(name = "CONTACTOR", nullable = true, length = 50)
	public java.lang.String getContactor() {
		return this.contactor;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 联系人
	 */
	public void setContactor(java.lang.String contactor) {
		this.contactor = contactor;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 邮政编码
	 */
	@Column(name = "ZIPCODE", nullable = true, length = 35)
	public java.lang.String getZipcode() {
		return this.zipcode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 邮政编码
	 */
	public void setZipcode(java.lang.String zipcode) {
		this.zipcode = zipcode;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 开票频率
	 */
	@Column(name = "INV_FREQ", nullable = true, length = 50)
	public java.lang.String getInvFreq() {
		return invFreq;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 开票频率
	 */
	public void setInvFreq(java.lang.String invFreq) {
		this.invFreq = invFreq;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String SWIFT代码
	 */
	@Column(name = "SWIFTCODE", nullable = true, length = 50)
	public java.lang.String getSwiftcode() {
		return swiftcode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 开票频率
	 */
	public void setSwiftcode(java.lang.String swiftcode) {
		this.swiftcode = swiftcode;
	}
}
