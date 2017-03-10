package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Title: Entity
 * @Description: 企业客户信息表
 * @author onlineGenerator
 * @date 2015-08-26 15:22:17
 * @version V1.0
 * 
 */
@Entity
@Table(name = "t_cust_corp", schema = "")
@SuppressWarnings("serial")
@PrimaryKeyJoinColumn(name = "id")
public class CustCorpEntity extends CustBaseEntity implements
		java.io.Serializable {
	/** 法人标志 */
	@Excel(name = "法人标志")
	private java.lang.String mlpr;
	/** 母公司客户名称 */
	@Excel(name = "母公司客户名称")
	private java.lang.String pctnm;
	/** 母公司注册国家 */
	@Excel(name = "母公司注册国家")
	private java.lang.String pctnt;
	/** 国内注册地址 */
	@Excel(name = "国内注册地址")
	private java.lang.String regaddress;
	/** 企业出资人经济成分 */
	@Excel(name = "企业出资人经济成分")
	private java.lang.String attcode;
	/** 企业规模 */
	@Excel(name = "企业规模")
	private java.lang.String custsize;
	/** 开户许可证号 */
	@Excel(name = "开户许可证号")
	private java.lang.String citpCfba;
	/** 统一社会信用代码 */
	@Excel(name = "统一社会信用代码")
	private java.lang.String citpUscc;
	/** 特殊机构代码 */
	@Excel(name = "特殊机构代码")
	private java.lang.String citpOscc;
	/** 关系人类型 */
	@Excel(name = "关系人类型")
	private java.lang.String relatetype;
	/** 关系人姓名 */
	@Excel(name = "关系人姓名")
	private java.lang.String relatename;
	/** 法人代表姓名 */
	@Excel(name = "法人代表姓名")
	private java.lang.String crnm;
	/** 法人证件类型 */
	@Excel(name = "法人证件类型")
	private java.lang.String crit;
	/** 法人证件号码 */
	@Excel(name = "法人证件号码")
	private java.lang.String crid;
	/** 代码证更新日期 */
	@Excel(name = "代码证更新日期")
	private java.util.Date enupdate;
	/** 组织机构类型 */
	@Excel(name = "组织机构类型")
	private java.lang.String entyp;
	/** 营业执照 */
	@Excel(name = "营业执照")
	private java.lang.String buslicense;
	/** 营业执照有效期 */
	@Excel(name = "营业执照有效期")
	private java.util.Date orgexpdate;
	/** 经营范围 */
	@Excel(name = "经营范围")
	private java.lang.String busscope;
	/** 成立日期 */
	@Excel(name = "成立日期")
	private java.util.Date regdate;
	/** 所属行业 */
	@Excel(name = "所属行业")
	private java.lang.String industrycode;
	/** 企业登记注册类型 */
	@Excel(name = "企业登记注册类型")
	private java.lang.String regtype;
	/** 贷款卡编号 */
	@Excel(name = "贷款卡编号")
	private java.lang.String lncardid;
	/** 上市公司标志 */
	@Excel(name = "上市公司标志")
	private java.lang.String listcompanyflag;
	/** 是否为银行股东 */
	@Excel(name = "是否为银行股东")
	private java.lang.String isbanksh;
	/** 投资人国别 */
	@Excel(name = "投资人国别")
	private java.lang.String invcountrycode;
	/** 集团客户标志 */
	@Excel(name = "集团客户标志")
	private java.lang.String pcutp;
	/** 集团客户编号 */
	@Excel(name = "集团客户编号")
	private java.lang.String parn;
	/** 外部信用评级 */
	@Excel(name = "外部信用评级")
	private java.lang.String excreditass;
	/** 风险等级 */
	@Excel(name = "风险等级")
	private java.lang.String rishrank;
	/** 国税证号 */
	@Excel(name = "国税证号")
	private java.lang.String nationaltaxlic;
	/** 地税证号 */
	@Excel(name = "地税证号")
	private java.lang.String localtaxlic;
	/** 联系人 */
	@Excel(name = "联系人")
	private java.lang.String contactor;
	/** 是否特殊经济区内企业 */
	@Excel(name = "是否特殊经济区内企业")
	private java.lang.String istaxfree;
	/** 特殊经济区类型 */
	@Excel(name = "特殊经济区类型")
	private java.lang.String taxfreecode;
	/** 邮政编码 */
	@Excel(name = "邮政编码")
	private java.lang.String zipcode;
	/** 是否为黑名单客户 */
	@Excel(name = "是否为黑名单客户")
	private java.lang.String blcl;
	/** 黑名单原因 */
	@Excel(name = "黑名单原因")
	private java.lang.String cklr;
	/** 注册资本币种 */
	@Excel(name = "注册资本币种")
	private java.lang.String recpccy;
	/** 注册资本金额 */
	@Excel(name = "注册资本金额")
	private java.math.BigDecimal rgcp;
	/** 实收资本金额 */
	@Excel(name = "实收资本金额")
	private java.math.BigDecimal actcp;
	/** 总资产 */
	@Excel(name = "总资产")
	private java.math.BigDecimal totalassets;
	/** 年营业收入 */
	@Excel(name = "年营业收入")
	private java.math.BigDecimal annrevenue;
	/** 员工人数 */
	@Excel(name = "员工人数")
	private java.lang.Integer empnumber;
	/** 地区编号 */
	@Excel(name = "地区编号")
	private java.lang.String regc;
	/** 开户日期 */
	@Excel(name = "开户日期")
	private java.util.Date opdt;
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
	/** 开票频率 */
	@Excel(name = "开票频率")
	private java.lang.String invFreq;
	/** 注册（登记）地行政区划 */
	@Excel(name = "注册（登记）地行政区划")
	private java.lang.String city;
	/** 绩效行 */
	@Excel(name = "绩效行")
	private java.lang.String pfmUnit;
	/** 最后修改时间 */
	@Excel(name = "最后修改时间")
	private java.lang.String lastTime;

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 法人标志
	 */
	@Column(name = "MLPR", nullable = true, length = 10)
	public java.lang.String getMlpr() {
		return this.mlpr;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 法人标志
	 */
	public void setMlpr(java.lang.String mlpr) {
		this.mlpr = mlpr;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 母公司客户名称
	 */
	@Column(name = "PCTNM", nullable = true, length = 255)
	public java.lang.String getPctnm() {
		return this.pctnm;
	}

	

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 母公司客户名称
	 */
	public void setPctnm(java.lang.String pctnm) {
		this.pctnm = pctnm;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 母公司注册国家
	 */
	@Column(name = "PCTNT", nullable = true, length = 10)
	public java.lang.String getPctnt() {
		return this.pctnt;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 母公司注册国家
	 */
	public void setPctnt(java.lang.String pctnt) {
		this.pctnt = pctnt;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 国内注册地址
	 */
	@Column(name = "REGADDRESS", nullable = true, length = 255)
	public java.lang.String getRegaddress() {
		return this.regaddress;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 国内注册地址
	 */
	public void setRegaddress(java.lang.String regaddress) {
		this.regaddress = regaddress;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 企业出资人经济成分
	 */
	@Column(name = "ATTCODE", nullable = true, length = 10)
	public java.lang.String getAttcode() {
		return this.attcode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 企业出资人经济成分
	 */
	public void setAttcode(java.lang.String attcode) {
		this.attcode = attcode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 企业规模
	 */
	@Column(name = "CUSTSIZE", nullable = true, length = 10)
	public java.lang.String getCustsize() {
		return this.custsize;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 企业规模
	 */
	public void setCustsize(java.lang.String custsize) {
		this.custsize = custsize;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 关系人类型
	 */
	@Column(name = "RELATETYPE", nullable = true, length = 10)
	public java.lang.String getRelatetype() {
		return this.relatetype;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 关系人类型
	 */
	public void setRelatetype(java.lang.String relatetype) {
		this.relatetype = relatetype;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 关系人姓名
	 */
	@Column(name = "RELATENAME", nullable = true, length = 255)
	public java.lang.String getRelatename() {
		return this.relatename;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 关系人姓名
	 */
	public void setRelatename(java.lang.String relatename) {
		this.relatename = relatename;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 法人代表姓名
	 */
	@Column(name = "CRNM", nullable = true, length = 100)
	public java.lang.String getCrnm() {
		return this.crnm;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 法人代表姓名
	 */
	public void setCrnm(java.lang.String crnm) {
		this.crnm = crnm;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 法人证件类型
	 */
	@Column(name = "CRIT", nullable = true, length = 10)
	public java.lang.String getCrit() {
		return this.crit;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 法人证件类型
	 */
	public void setCrit(java.lang.String crit) {
		this.crit = crit;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 法人证件号码
	 */
	@Column(name = "CRID", nullable = true, length = 30)
	public java.lang.String getCrid() {
		return this.crid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 法人证件号码
	 */
	public void setCrid(java.lang.String crid) {
		this.crid = crid;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 代码证更新日期
	 */
	@Column(name = "ENUPDATE", nullable = true)
	public java.util.Date getEnupdate() {
		return this.enupdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 代码证更新日期
	 */
	public void setEnupdate(java.util.Date enupdate) {
		this.enupdate = enupdate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 组织机构类型
	 */
	@Column(name = "ENTYP", nullable = true, length = 10)
	public java.lang.String getEntyp() {
		return this.entyp;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 组织机构类型
	 */
	public void setEntyp(java.lang.String entyp) {
		this.entyp = entyp;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 营业执照
	 */
	@Column(name = "BUSLICENSE", nullable = true, length = 50)
	public java.lang.String getBuslicense() {
		return this.buslicense;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 营业执照
	 */
	public void setBuslicense(java.lang.String buslicense) {
		this.buslicense = buslicense;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 营业执照有效期
	 */
	@Column(name = "ORGEXPDATE", nullable = true)
	public java.util.Date getOrgexpdate() {
		return this.orgexpdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 营业执照有效期
	 */
	public void setOrgexpdate(java.util.Date orgexpdate) {
		this.orgexpdate = orgexpdate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 经营范围
	 */
	@Column(name = "BUSSCOPE", nullable = true, length = 255)
	public java.lang.String getBusscope() {
		return this.busscope;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 经营范围
	 */
	public void setBusscope(java.lang.String busscope) {
		this.busscope = busscope;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 成立日期
	 */
	@Column(name = "REGDATE", nullable = true)
	public java.util.Date getRegdate() {
		return this.regdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 成立日期
	 */
	public void setRegdate(java.util.Date regdate) {
		this.regdate = regdate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 所属行业
	 */
	@Column(name = "INDUSTRYCODE", nullable = true, length = 10)
	public java.lang.String getIndustrycode() {
		return this.industrycode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 所属行业
	 */
	public void setIndustrycode(java.lang.String industrycode) {
		this.industrycode = industrycode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 企业登记注册类型
	 */
	@Column(name = "REGTYPE", nullable = true, length = 20)
	public java.lang.String getRegtype() {
		return this.regtype;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 企业登记注册类型
	 */
	public void setRegtype(java.lang.String regtype) {
		this.regtype = regtype;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 贷款卡编号
	 */
	@Column(name = "LNCARDID", nullable = true, length = 50)
	public java.lang.String getLncardid() {
		return this.lncardid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 贷款卡编号
	 */
	public void setLncardid(java.lang.String lncardid) {
		this.lncardid = lncardid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 上市公司标志
	 */
	@Column(name = "LISTCOMPANYFLAG", nullable = true, length = 10)
	public java.lang.String getListcompanyflag() {
		return this.listcompanyflag;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 上市公司标志
	 */
	public void setListcompanyflag(java.lang.String listcompanyflag) {
		this.listcompanyflag = listcompanyflag;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否为银行股东
	 */
	@Column(name = "ISBANKSH", nullable = true, length = 10)
	public java.lang.String getIsbanksh() {
		return this.isbanksh;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否为银行股东
	 */
	public void setIsbanksh(java.lang.String isbanksh) {
		this.isbanksh = isbanksh;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 投资人国别
	 */
	public java.lang.String getInvcountrycode() {
		return invcountrycode;
	}
	
	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 投资人国别
	 */
	@Column(name = "INVCOUNTRYCODE", nullable = true, length = 3)
	public void setInvcountrycode(java.lang.String invcountrycode) {
		this.invcountrycode = invcountrycode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 集团客户标志
	 */
	@Column(name = "PCUTP", nullable = true, length = 50)
	public java.lang.String getPcutp() {
		return this.pcutp;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 集团客户标志
	 */
	public void setPcutp(java.lang.String pcutp) {
		this.pcutp = pcutp;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 集团客户编号
	 */
	@Column(name = "PARN", nullable = true, length = 50)
	public java.lang.String getParn() {
		return this.parn;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 集团客户编号
	 */
	public void setParn(java.lang.String parn) {
		this.parn = parn;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 开户许可证号
	 */
	@Column(name = "CITP_CFBA", nullable = true, length = 50)
	public java.lang.String getCitpCfba() {
		return citpCfba;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 开户许可证号
	 */
	public void setCitpCfba(java.lang.String citpCfba) {
		this.citpCfba = citpCfba;
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
	 * @return: java.lang.String 特殊机构代码
	 */
	@Column(name = "CITP_OSCC", nullable = true, length = 50)
	public java.lang.String getCitpOscc() {
		return citpOscc;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 特殊机构代码
	 */
	public void setCitpOscc(java.lang.String citpOscc) {
		this.citpOscc = citpOscc;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 客户税务登记证地址
	 */
	@Column(name = "TAX_ADDRESS", nullable = true, length = 50)
	public java.lang.String getTaxAddress() {
		return taxAddress;
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
		return receiveAddress;
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
		return isInvoice;
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
		return typeInvoice;
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
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 外部信用评级
	 */
	@Column(name = "EXCREDITASS", nullable = true, length = 50)
	public java.lang.String getExcreditass() {
		return this.excreditass;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 外部信用评级
	 */
	public void setExcreditass(java.lang.String excreditass) {
		this.excreditass = excreditass;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 风险等级
	 */
	@Column(name = "RISHRANK", nullable = true, length = 50)
	public java.lang.String getRishrank() {
		return this.rishrank;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 风险等级
	 */
	public void setRishrank(java.lang.String rishrank) {
		this.rishrank = rishrank;
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
	 * @return: java.lang.String 是否特殊经济区内企业
	 */
	@Column(name = "ISTAXFREE", nullable = true, length = 10)
	public java.lang.String getIstaxfree() {
		return this.istaxfree;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否特殊经济区内企业
	 */
	public void setIstaxfree(java.lang.String istaxfree) {
		this.istaxfree = istaxfree;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 特殊经济区类型
	 */
	@Column(name = "TAXFREECODE", nullable = true, length = 10)
	public java.lang.String getTaxfreecode() {
		return this.taxfreecode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 特殊经济区类型
	 */
	public void setTaxfreecode(java.lang.String taxfreecode) {
		this.taxfreecode = taxfreecode;
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
	 * @return: java.lang.String 是否为黑名单客户
	 */
	@Column(name = "BLCL", nullable = true, length = 10)
	public java.lang.String getBlcl() {
		return this.blcl;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否为黑名单客户
	 */
	public void setBlcl(java.lang.String blcl) {
		this.blcl = blcl;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 黑名单原因
	 */
	@Column(name = "CKLR", nullable = true, length = 100)
	public java.lang.String getCklr() {
		return this.cklr;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 黑名单原因
	 */
	public void setCklr(java.lang.String cklr) {
		this.cklr = cklr;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 注册资本币种
	 */
	@Column(name = "RECPCCY", nullable = true, length = 10)
	public java.lang.String getRecpccy() {
		return this.recpccy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 注册资本币种
	 */
	public void setRecpccy(java.lang.String recpccy) {
		this.recpccy = recpccy;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 注册资本金额
	 */
	@Column(name = "RGCP", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getRgcp() {
		return this.rgcp;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 注册资本金额
	 */
	public void setRgcp(java.math.BigDecimal rgcp) {
		this.rgcp = rgcp;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 实收资本金额
	 */
	@Column(name = "ACTCP", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getActcp() {
		return this.actcp;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 实收资本金额
	 */
	public void setActcp(java.math.BigDecimal actcp) {
		this.actcp = actcp;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 总资产
	 */
	@Column(name = "TOTALASSETS", nullable = true, scale = 4, length = 50)
	public java.math.BigDecimal getTotalassets() {
		return this.totalassets;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 总资产
	 */
	public void setTotalassets(java.math.BigDecimal totalassets) {
		this.totalassets = totalassets;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 年营业收入
	 */
	@Column(name = "ANNREVENUE", nullable = true, scale = 4, length = 50)
	public java.math.BigDecimal getAnnrevenue() {
		return this.annrevenue;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 年营业收入
	 */
	public void setAnnrevenue(java.math.BigDecimal annrevenue) {
		this.annrevenue = annrevenue;
	}

	/**
	 * 方法: 取得java.lang.Integer
	 * 
	 * @return: java.lang.Integer 员工人数
	 */
	@Column(name = "EMPNUMBER", nullable = true, length = 10)
	public java.lang.Integer getEmpnumber() {
		return this.empnumber;
	}

	/**
	 * 方法: 设置java.lang.Integer
	 * 
	 * @param: java.lang.Integer 员工人数
	 */
	public void setEmpnumber(java.lang.Integer empnumber) {
		this.empnumber = empnumber;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 地区编号
	 */
	@Column(name = "REGC", nullable = true, length = 50)
	public java.lang.String getRegc() {
		return this.regc;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 地区编号
	 */
	public void setRegc(java.lang.String regc) {
		this.regc = regc;
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
	 * @return: java.lang.String 注册（登记）地行政区划
	 */
	@Column(name = "CITY", nullable = true, length = 50)
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 注册（登记）地行政区划
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 绩效行
	 */
	@Column(name = "PFM_UNIT", nullable = true, length = 50)
	public java.lang.String getPfmUnit() {
		return pfmUnit;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 绩效行
	 */
	public void setPfmUnit(java.lang.String pfmUnit) {
		this.pfmUnit = pfmUnit;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 最后修改时间
	 */
	@Column(name = "LAST_TIME", nullable = true, length = 50)
	public java.lang.String getLastTime() {
		return lastTime;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 最后修改时间
	 */
	public void setLastTime(java.lang.String lastTime) {
		this.lastTime = lastTime;
	}
}
