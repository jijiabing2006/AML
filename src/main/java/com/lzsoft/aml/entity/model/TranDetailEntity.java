package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * @Title: Entity
 * @Description: 交易流水表
 * @author onlineGenerator
 * @date 2015-08-26 15:26:14
 * @version V1.0
 * 
 */
@Entity
@Table(name = "t_tran_detail", schema = "")
@SuppressWarnings("serial")
public class TranDetailEntity extends IdEntity implements java.io.Serializable {

	/** 明细科目编号 */
	@Excel(name = "明细科目编号")
	private java.lang.String num;
	/** consolKey */
	@Excel(name = "consolKey")
	private java.lang.String consolKey;
	/** category */
	@Excel(name = "category")
	private java.lang.String category;
	/** sector */
	@Excel(name = "sector")
	private java.lang.String sector;
	/** tenor */
	@Excel(name = "tenor")
	private java.lang.String tenor;
	/** prodcode */
	@Excel(name = "prodcode")
	private java.lang.String prodcode;
	/** 交易流水号 */
	@Excel(name = "交易流水号")
	private java.lang.String tid;
	/** 客户号 */
	@Excel(name = "客户号")
	private java.lang.String csnm;
	/** 交易币种 */
	@Excel(name = "交易币种")
	private java.lang.String ccy;
	/** 账号 */
	@Excel(name = "账号")
	private java.lang.String acod;
	/** 主账号 */
	@Excel(name = "主账号")
	private java.lang.String mainacod;
	/** 申报账号 */
	@Excel(name = "申报账号")
	private java.lang.String bpacod;
	/** 上一级机构代码 */
	@Excel(name = "上一级机构代码")
	private java.lang.String parentbrca;
	/** 分支机构代码 */
	@Excel(name = "分支机构代码")
	private java.lang.String brca;
	/** 经办行 */
	@Excel(name = "经办行")
	private java.lang.String brcaCo;
	/** 交易日期 */
	@Excel(name = "交易日期")
	private java.util.Date pstd;
	/** 生效日期 */
	@Excel(name = "生效日期")
	private java.util.Date vald;
	/** 交易金额 */
	@Excel(name = "交易金额")
	private java.math.BigDecimal psta;
//	/** 交易金额折美金 */
//	@Excel(name = "交易金额折美金")
//	private java.math.BigDecimal pstausd;
//	/** 交易金额折人民币 */
//	@Excel(name = "交易金额折人民币")
//	private java.math.BigDecimal pstacny;
	/** 借/贷标记 */
	@Excel(name = "借/贷标记")
	private java.lang.String drcr;
	/** 银行业务编号 */
	@Excel(name = "银行业务编号")
	private java.lang.String dlref;
	/** 交易类别. */
	@Excel(name = "交易类别.")
	private java.lang.String trat;
	/** 交易编号（SAFE 6位） */
	@Excel(name = "交易编号（SAFE 6位）")
	private java.lang.String strcode;
	/** 交易编号（PBOC 6位） */
	@Excel(name = "交易编号（PBOC 6位）")
	private java.lang.String ptrcode;
	/** 是否提交申报 */
	@Excel(name = "是否提交申报")
	private java.lang.String inbop;
	/** 交易对手名称 */
	@Excel(name = "交易对手名称")
	private java.lang.String opname;
	/** 交易对手账号 */
	@Excel(name = "交易对手账号")
	private java.lang.String opaccount;
	/** 现汇金额 */
	@Excel(name = "现汇金额")
	private java.math.BigDecimal fcyamt;
	/** 结/购汇汇率 */
	@Excel(name = "结/购汇汇率")
	private java.math.BigDecimal exrate;
	/** 结/购汇金额 */
	@Excel(name = "结/购汇金额")
	private java.math.BigDecimal examt;
	/** 人民币账号 */
	@Excel(name = "人民币账号")
	private java.lang.String rmbaccount;
	/** 其它金额 */
	@Excel(name = "其它金额")
	private java.math.BigDecimal othamt;
	/** 其它账号/银行卡号 */
	@Excel(name = "其它账号/银行卡号")
	private java.lang.String othaccount;
	/** 结算方式. */
	@Excel(name = "结算方式.")
	private java.lang.String paymethodone;
	/** 适用于AML */
	@Excel(name = "适用于AML")
	private java.lang.String paymethodtwo;
	/** 审批件号码,核准件编号 */
	@Excel(name = "审批件号码,核准件编号")
	private java.lang.String authorityCode;
	/** 交易发生地 */
	@Excel(name = "交易发生地")
	private java.lang.String tdlc;
	/** 交易附言 / 资金用途 */
	@Excel(name = "交易附言 / 资金用途")
	private java.lang.String pnar;
	/** 境内收入类型/付汇性质 */
	@Excel(name = "境内收入类型/付汇性质")
	private java.lang.String incomtype;
	/** 收款性质/付款类型 */
	@Excel(name = "收款性质/付款类型")
	private java.lang.String paytype;
	/** 是否为保税货物项下收入 */
	@Excel(name = "是否为保税货物项下收入")
	private java.lang.String incomtaxfree;
	/** 填报人 */
	@Excel(name = "填报人")
	private java.lang.String appl;
	/** 填报人电话 */
	@Excel(name = "填报人电话")
	private java.lang.String applphone;
	/** 国内银行扣费金额 */
	@Excel(name = "国内银行扣费金额")
	private java.math.BigDecimal localBankFee;
	/** 国内银行扣费币种 */
	@Excel(name = "国内银行扣费币种")
	private java.lang.String localBankFeeCcy;
	/** 国外银行扣费金额 */
	@Excel(name = "国外银行扣费金额")
	private java.math.BigDecimal forebchar;
	/** 国外银行扣费币种 */
	@Excel(name = "国外银行扣费币种")
	private java.lang.String ccyforebchar;
	/** 信用证/保函编号 */
	@Excel(name = "信用证/保函编号")
	private java.lang.String lclgno;
	/** 信用证/保函开证日期 */
	@Excel(name = "信用证/保函开证日期")
	private java.lang.String lclgopendate;
	/** 信用证/保函期限 */
	@Excel(name = "信用证/保函期限")
	private java.lang.String lclgtenor;
	/** BOP申报币种(实际收/付款币种) */
	@Excel(name = "BOP申报币种(实际收/付款币种)")
	private java.lang.String bopccy;
	/** BOP申报金额(实际收/付款金额) */
	@Excel(name = "BOP申报金额(实际收/付款金额)")
	private java.math.BigDecimal bopamt;
	/** 交易对手类型. */
	@Excel(name = "交易对手类型.")
	private java.lang.String counpartyTyp;
	/** 交易去向 (交易对手银行所在地) */
	@Excel(name = "交易去向  (交易对手银行所在地)")
	private java.lang.String counpartyAeracode;
	/** 交易对手证件类型 */
	@Excel(name = "交易对手证件类型")
	private java.lang.String counpartyIdtyp;
	/** 交易对手证件号 */
	@Excel(name = "交易对手证件号")
	private java.lang.String counpartyIdno;
	/** 交易对手帐号类型. */
	@Excel(name = "交易对手帐号类型.")
	private java.lang.String counpartyActyp;
	/** 交易对手客户身份证件/证明文件号码 */
	@Excel(name = "交易对手客户身份证件/证明文件号码")
	private java.lang.String counpartyCusidno;
	/** 交易对手常驻国家 */
	@Excel(name = "交易对手常驻国家")
	private java.lang.String counpartyCountry;
	/** 交易对手/交易对手银行国内行政区代码 */
	@Excel(name = "交易对手/交易对手银行国内行政区代码")
	private java.lang.String counpartyBankregionco;
	/** 交易对手银行名称 */
	@Excel(name = "交易对手银行名称")
	private java.lang.String counpartyBankco;
	/** 交易对手银行机构代码 */
	@Excel(name = "交易对手银行机构代码")
	private java.lang.String counpartyRegion;
	/** 结售汇用途 */
	@Excel(name = "结售汇用途")
	private java.lang.String fxPurpose;
	/** 结售汇详细用途 */
	@Excel(name = "结售汇详细用途")
	private java.lang.String fxDePur;
	/** 冲正标记 */
	@Excel(name = "冲正标记")
	private java.lang.String psmk;
	/** 交易流入的渠道 */
	@Excel(name = "交易流入的渠道")
	private java.lang.String cnlsc;
	/** 交易性质代码 */
	@Excel(name = "交易性质代码")
	private java.lang.String trno;
	/** FT账号交易类型 */
	@Excel(name = "FT账号交易类型")
	private java.lang.String fttrtp;
	/** 系统日期 */
	@Excel(name = "系统日期")
	private java.util.Date sysDate;
	/** 营业日期 */
	@Excel(name = "营业日期")
	private java.util.Date importdate;
	/** 存入（2C）代表资本项下，给申报管理用 */
	@Excel(name = "存入（2C）代表资本项下，给申报管理用")
	private java.lang.String transactionremark;
	/** 合同号 */
	@Excel(name = "合同号")
	private java.lang.String contrno;
	/** 发票号 */
	@Excel(name = "发票号")
	private java.lang.String invoino;
	/** 提运单号 */
	@Excel(name = "提运单号")
	private java.lang.String billno;
	/** 合同金额 */
	@Excel(name = "合同金额")
	private java.math.BigDecimal contamt;
	/** 交易渠道*/
	@Excel(name = "交易渠道")
	private java.lang.String inputter;

	/**
	 * 方法: 取得java.lang.String
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 明细科目编号
	 */
	@Column(name = "NUM", nullable = true, length = 100)
	public java.lang.String getNum() {
		return num;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 明细科目编号
	 */
	public void setNum(java.lang.String num) {
		this.num = num;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易流水号
	 */
	@Column(name = "TID", nullable = true, length = 100)
	public java.lang.String getTid() {
		return this.tid;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易流水号
	 */
	public void setTid(java.lang.String tid) {
		this.tid = tid;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 客户号
	 */
	@Column(name = "CSNM", nullable = false, length = 20)
	public java.lang.String getCsnm() {
		return this.csnm;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 客户号
	 */
	public void setCsnm(java.lang.String csnm) {
		this.csnm = csnm;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易币种
	 */
	@Column(name = "CCY", nullable = false, length = 10)
	public java.lang.String getCcy() {
		return this.ccy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易币种
	 */
	public void setCcy(java.lang.String ccy) {
		this.ccy = ccy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账号
	 */
	@Column(name = "ACOD", nullable = false, length = 50)
	public java.lang.String getAcod() {
		return this.acod;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账号
	 */
	public void setAcod(java.lang.String acod) {
		this.acod = acod;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 上一级机构代码
	 */
	@Column(name = "PARENTBRCA", nullable = false, length = 10)
	public java.lang.String getParentbrca() {
		return this.parentbrca;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 上一级机构代码
	 */
	public void setParentbrca(java.lang.String parentbrca) {
		this.parentbrca = parentbrca;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 分支机构代码
	 */
	@Column(name = "BRCA", nullable = false, length = 10)
	public java.lang.String getBrca() {
		return this.brca;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 分支机构代码
	 */
	public void setBrca(java.lang.String brca) {
		this.brca = brca;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 经办行
	 */
	@Column(name = "BRCA_CO", nullable = false, length = 10)
	public java.lang.String getBrcaCo() {
		return this.brcaCo;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 经办行
	 */
	public void setBrcaCo(java.lang.String brcaCo) {
		this.brcaCo = brcaCo;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 交易日期
	 */
	@Column(name = "PSTD", nullable = false)
	public java.util.Date getPstd() {
		return this.pstd;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 交易日期
	 */
	public void setPstd(java.util.Date pstd) {
		this.pstd = pstd;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 生效日期
	 */
	@Column(name = "VALD", nullable = false)
	public java.util.Date getVald() {
		return this.vald;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 生效日期
	 */
	public void setVald(java.util.Date vald) {
		this.vald = vald;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 交易金额
	 */
	@Column(name = "PSTA", nullable = false, scale = 4, length = 20)
	public java.math.BigDecimal getPsta() {
		return this.psta;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 交易金额
	 */
	public void setPsta(java.math.BigDecimal psta) {
		this.psta = psta;
	}

//	/**
//	 * 方法: 取得java.math.BigDecimal
//	 * 
//	 * @return: java.math.BigDecimal 交易金额折美金
//	 */
//	@Column(name = "PSTAUSD", nullable = false, scale = 4, length = 20)
//	public java.math.BigDecimal getPstausd() {
//		return pstausd;
//	}
//
//	/**
//	 * 方法: 设置java.math.BigDecimal
//	 * 
//	 * @param: java.math.BigDecimal 交易金额折美金
//	 */
//	public void setPstausd(java.math.BigDecimal pstausd) {
//		this.pstausd = pstausd;
//	}
//	/**
//	 * 方法: 取得java.math.BigDecimal
//	 * 
//	 * @return: java.math.BigDecimal 交易金额折人民币
//	 */
//	@Column(name = "PSTACNY", nullable = false, scale = 4, length = 20)
//	public java.math.BigDecimal getPstacny() {
//		return pstacny;
//	}
//
//	/**
//	 * 方法: 设置java.math.BigDecimal
//	 * 
//	 * @param: java.math.BigDecimal 交易金额折人民币
//	 */
//	public void setPstacny(java.math.BigDecimal pstacny) {
//		this.pstacny = pstacny;
//	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 借/贷标记
	 */
	@Column(name = "DRCR", nullable = false, length = 10)
	public java.lang.String getDrcr() {
		return this.drcr;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 借/贷标记
	 */
	public void setDrcr(java.lang.String drcr) {
		this.drcr = drcr;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 银行业务编号
	 */
	@Column(name = "DLREF", nullable = false, length = 100)
	public java.lang.String getDlref() {
		return this.dlref;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 银行业务编号
	 */
	public void setDlref(java.lang.String dlref) {
		this.dlref = dlref;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易类别.
	 */
	@Column(name = "TRAT", nullable = true, length = 10)
	public java.lang.String getTrat() {
		return this.trat;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易类别.
	 */
	public void setTrat(java.lang.String trat) {
		this.trat = trat;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易编号（SAFE 6位）
	 */
	@Column(name = "STRCODE", nullable = true, length = 10)
	public java.lang.String getStrcode() {
		return this.strcode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易编号（SAFE 6位）
	 */
	public void setStrcode(java.lang.String strcode) {
		this.strcode = strcode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易编号（PBOC 6位）
	 */
	@Column(name = "PTRCODE", nullable = true, length = 10)
	public java.lang.String getPtrcode() {
		return this.ptrcode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易编号（PBOC 6位）
	 */
	public void setPtrcode(java.lang.String ptrcode) {
		this.ptrcode = ptrcode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否提交申报
	 */
	@Column(name = "INBOP", nullable = true, length = 10)
	public java.lang.String getInbop() {
		return this.inbop;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否提交申报
	 */
	public void setInbop(java.lang.String inbop) {
		this.inbop = inbop;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手名称
	 */
	@Column(name = "OPNAME", nullable = true, length = 255)
	public java.lang.String getOpname() {
		return this.opname;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手名称
	 */
	public void setOpname(java.lang.String opname) {
		this.opname = opname;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手账号
	 */
	@Column(name = "OPACCOUNT", nullable = true, length = 50)
	public java.lang.String getOpaccount() {
		return this.opaccount;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手账号
	 */
	public void setOpaccount(java.lang.String opaccount) {
		this.opaccount = opaccount;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 现汇金额
	 */
	@Column(name = "FCYAMT", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getFcyamt() {
		return this.fcyamt;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 现汇金额
	 */
	public void setFcyamt(java.math.BigDecimal fcyamt) {
		this.fcyamt = fcyamt;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 结/购汇汇率
	 */
	@Column(name = "EXRATE", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getExrate() {
		return this.exrate;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 结/购汇汇率
	 */
	public void setExrate(java.math.BigDecimal exrate) {
		this.exrate = exrate;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 结/购汇金额
	 */
	@Column(name = "EXAMT", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getExamt() {
		return this.examt;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 结/购汇金额
	 */
	public void setExamt(java.math.BigDecimal examt) {
		this.examt = examt;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 人民币账号
	 */
	@Column(name = "RMBACCOUNT", nullable = true, length = 50)
	public java.lang.String getRmbaccount() {
		return this.rmbaccount;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 人民币账号
	 */
	public void setRmbaccount(java.lang.String rmbaccount) {
		this.rmbaccount = rmbaccount;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 其它金额
	 */
	@Column(name = "OTHAMT", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getOthamt() {
		return this.othamt;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 其它金额
	 */
	public void setOthamt(java.math.BigDecimal othamt) {
		this.othamt = othamt;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 其它账号/银行卡号
	 */
	@Column(name = "OTHACCOUNT", nullable = true, length = 50)
	public java.lang.String getOthaccount() {
		return this.othaccount;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 其它账号/银行卡号
	 */
	public void setOthaccount(java.lang.String othaccount) {
		this.othaccount = othaccount;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 结算方式.
	 */
	@Column(name = "PAYMETHODONE", nullable = true, length = 10)
	public java.lang.String getPaymethodone() {
		return this.paymethodone;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 结算方式.
	 */
	public void setPaymethodone(java.lang.String paymethodone) {
		this.paymethodone = paymethodone;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 适用于AML
	 */
	@Column(name = "PAYMETHODTWO", nullable = true, length = 10)
	public java.lang.String getPaymethodtwo() {
		return this.paymethodtwo;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 适用于AML
	 */
	public void setPaymethodtwo(java.lang.String paymethodtwo) {
		this.paymethodtwo = paymethodtwo;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 审批件号码,核准件编号
	 */
	@Column(name = "AUTHORITY_CODE", nullable = true, length = 50)
	public java.lang.String getAuthorityCode() {
		return this.authorityCode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 审批件号码,核准件编号
	 */
	public void setAuthorityCode(java.lang.String authorityCode) {
		this.authorityCode = authorityCode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易发生地
	 */
	@Column(name = "TDLC", nullable = true, length = 50)
	public java.lang.String getTdlc() {
		return this.tdlc;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易发生地
	 */
	public void setTdlc(java.lang.String tdlc) {
		this.tdlc = tdlc;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易附言 / 资金用途
	 */
	@Column(name = "PNAR", nullable = true, length = 255)
	public java.lang.String getPnar() {
		return this.pnar;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易附言 / 资金用途
	 */
	public void setPnar(java.lang.String pnar) {
		this.pnar = pnar;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 境内收入类型/付汇性质
	 */
	@Column(name = "INCOMTYPE", nullable = true, length = 50)
	public java.lang.String getIncomtype() {
		return this.incomtype;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 境内收入类型/付汇性质
	 */
	public void setIncomtype(java.lang.String incomtype) {
		this.incomtype = incomtype;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 收款性质/付款类型
	 */
	@Column(name = "PAYTYPE", nullable = true, length = 50)
	public java.lang.String getPaytype() {
		return this.paytype;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 收款性质/付款类型
	 */
	public void setPaytype(java.lang.String paytype) {
		this.paytype = paytype;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 是否为保税货物项下收入
	 */
	@Column(name = "INCOMTAXFREE", nullable = true, length = 50)
	public java.lang.String getIncomtaxfree() {
		return this.incomtaxfree;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 是否为保税货物项下收入
	 */
	public void setIncomtaxfree(java.lang.String incomtaxfree) {
		this.incomtaxfree = incomtaxfree;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 填报人
	 */
	@Column(name = "APPL", nullable = true, length = 50)
	public java.lang.String getAppl() {
		return this.appl;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 填报人
	 */
	public void setAppl(java.lang.String appl) {
		this.appl = appl;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 填报人电话
	 */
	@Column(name = "APPLPHONE", nullable = true, length = 50)
	public java.lang.String getApplphone() {
		return this.applphone;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 填报人电话
	 */
	public void setApplphone(java.lang.String applphone) {
		this.applphone = applphone;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 国内银行扣费金额
	 */
	@Column(name = "LOCAL_BANK_FEE", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getLocalBankFee() {
		return this.localBankFee;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 国内银行扣费金额
	 */
	public void setLocalBankFee(java.math.BigDecimal localBankFee) {
		this.localBankFee = localBankFee;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 国内银行扣费币种
	 */
	@Column(name = "LOCAL_BANK_FEE_CCY", nullable = true, length = 50)
	public java.lang.String getLocalBankFeeCcy() {
		return this.localBankFeeCcy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 国内银行扣费币种
	 */
	public void setLocalBankFeeCcy(java.lang.String localBankFeeCcy) {
		this.localBankFeeCcy = localBankFeeCcy;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 国外银行扣费金额
	 */
	@Column(name = "FOREBCHAR", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getForebchar() {
		return this.forebchar;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 国外银行扣费金额
	 */
	public void setForebchar(java.math.BigDecimal forebchar) {
		this.forebchar = forebchar;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 国外银行扣费币种
	 */
	@Column(name = "CCYFOREBCHAR", nullable = true, length = 50)
	public java.lang.String getCcyforebchar() {
		return this.ccyforebchar;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 国外银行扣费币种
	 */
	public void setCcyforebchar(java.lang.String ccyforebchar) {
		this.ccyforebchar = ccyforebchar;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 信用证/保函编号
	 */
	@Column(name = "LCLGNO", nullable = true, length = 50)
	public java.lang.String getLclgno() {
		return this.lclgno;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 信用证/保函编号
	 */
	public void setLclgno(java.lang.String lclgno) {
		this.lclgno = lclgno;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 信用证/保函开证日期
	 */
	@Column(name = "LCLGOPENDATE", nullable = true, length = 50)
	public java.lang.String getLclgopendate() {
		return this.lclgopendate;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 信用证/保函开证日期
	 */
	public void setLclgopendate(java.lang.String lclgopendate) {
		this.lclgopendate = lclgopendate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 信用证/保函期限
	 */
	@Column(name = "LCLGTENOR", nullable = true, length = 50)
	public java.lang.String getLclgtenor() {
		return this.lclgtenor;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 信用证/保函期限
	 */
	public void setLclgtenor(java.lang.String lclgtenor) {
		this.lclgtenor = lclgtenor;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String BOP申报币种(实际收/付款币种)
	 */
	@Column(name = "BOPCCY", nullable = true, length = 10)
	public java.lang.String getBopccy() {
		return this.bopccy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String BOP申报币种(实际收/付款币种)
	 */
	public void setBopccy(java.lang.String bopccy) {
		this.bopccy = bopccy;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal BOP申报金额(实际收/付款金额)
	 */
	@Column(name = "BOPAMT", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getBopamt() {
		return this.bopamt;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal BOP申报金额(实际收/付款金额)
	 */
	public void setBopamt(java.math.BigDecimal bopamt) {
		this.bopamt = bopamt;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手类型.
	 */
	@Column(name = "COUNPARTY_TYP", nullable = true, length = 10)
	public java.lang.String getCounpartyTyp() {
		return this.counpartyTyp;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手类型.
	 */
	public void setCounpartyTyp(java.lang.String counpartyTyp) {
		this.counpartyTyp = counpartyTyp;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易去向 (交易对手银行所在地)
	 */
	@Column(name = "COUNPARTY_AERACODE", nullable = true, length = 10)
	public java.lang.String getCounpartyAeracode() {
		return this.counpartyAeracode;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易去向 (交易对手银行所在地)
	 */
	public void setCounpartyAeracode(java.lang.String counpartyAeracode) {
		this.counpartyAeracode = counpartyAeracode;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手证件类型
	 */
	@Column(name = "COUNPARTY_IDTYP", nullable = true, length = 50)
	public java.lang.String getCounpartyIdtyp() {
		return this.counpartyIdtyp;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手证件类型
	 */
	public void setCounpartyIdtyp(java.lang.String counpartyIdtyp) {
		this.counpartyIdtyp = counpartyIdtyp;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手证件号
	 */
	@Column(name = "COUNPARTY_IDNO", nullable = true, length = 50)
	public java.lang.String getCounpartyIdno() {
		return this.counpartyIdno;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手证件号
	 */
	public void setCounpartyIdno(java.lang.String counpartyIdno) {
		this.counpartyIdno = counpartyIdno;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手帐号类型.
	 */
	@Column(name = "COUNPARTY_ACTYP", nullable = true, length = 10)
	public java.lang.String getCounpartyActyp() {
		return this.counpartyActyp;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手帐号类型.
	 */
	public void setCounparty_actyp(java.lang.String counpartyActyp) {
		this.counpartyActyp = counpartyActyp;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手客户身份证件/证明文件号码
	 */
	@Column(name = "COUNPARTY_CUSIDNO", nullable = true, length = 50)
	public java.lang.String getCounpartyCusidno() {
		return this.counpartyCusidno;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手客户身份证件/证明文件号码
	 */
	public void setCounpartyCusidno(java.lang.String counpartyCusidno) {
		this.counpartyCusidno = counpartyCusidno;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手常驻国家
	 */
	@Column(name = "COUNPARTY_COUNTRY", nullable = true, length = 10)
	public java.lang.String getCounpartyCountry() {
		return this.counpartyCountry;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手常驻国家
	 */
	public void setCounpartyCountry(java.lang.String counpartyCountry) {
		this.counpartyCountry = counpartyCountry;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手/交易对手银行国内行政区代码
	 */
	@Column(name = "COUNPARTY_BANKREGIONCO", nullable = true, length = 255)
	public java.lang.String getCounpartyBankregionco() {
		return counpartyBankregionco;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手/交易对手银行国内行政区代码
	 */
	public void setCounpartyBankregionco(java.lang.String counpartyBankregionco) {
		this.counpartyBankregionco = counpartyBankregionco;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手银行名称
	 */
	@Column(name = "COUNPARTY_BANKCO", nullable = true, length = 255)
	public java.lang.String getCounpartyBankco() {
		return this.counpartyBankco;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手银行名称
	 */
	public void setCounpartyBankco(java.lang.String counpartyBankco) {
		this.counpartyBankco = counpartyBankco;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易对手银行机构代码
	 */
	@Column(name = "COUNPARTY_REGION", nullable = true, length = 50)
	public java.lang.String getCounpartyRegion() {
		return this.counpartyRegion;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易对手银行机构代码
	 */
	public void setCounpartyRegion(java.lang.String counpartyRegion) {
		this.counpartyRegion = counpartyRegion;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 结售汇用途
	 */
	@Column(name = "FX_PURPOSE", nullable = true, length = 50)
	public java.lang.String getFxPurpose() {
		return this.fxPurpose;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 结售汇用途
	 */
	public void setFxPurpose(java.lang.String fxPurpose) {
		this.fxPurpose = fxPurpose;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 结售汇详细用途
	 */
	@Column(name = "FX_DE_PUR", nullable = true, length = 255)
	public java.lang.String getFxDePur() {
		return this.fxDePur;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 结售汇详细用途
	 */
	public void setFxDePur(java.lang.String fxDePur) {
		this.fxDePur = fxDePur;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 冲正标记
	 */
	@Column(name = "PSMK", nullable = true, length = 20)
	public java.lang.String getPsmk() {
		return this.psmk;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 冲正标记
	 */
	public void setPsmk(java.lang.String psmk) {
		this.psmk = psmk;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 系统日期
	 */
	@Column(name = "SYS_DATE", nullable = false)
	public java.util.Date getSysDate() {
		return this.importdate;
	}
	
	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 系统日期
	 */
	public void setSysDate(java.util.Date sysDate) {
		this.sysDate = sysDate;
	}
	
	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 营业日期
	 */
	@Column(name = "IMPORTDATE", nullable = false)
	public java.util.Date getImportdate() {
		return this.importdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 营业日期
	 */
	public void setImportdate(java.util.Date importdate) {
		this.importdate = importdate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 存入(2C)代表资本项下，给申报管理用
	 */
	@Column(name = "TRANSACTIONREMARK", nullable = true, length = 255)
	public java.lang.String getTransactionremark() {
		return this.transactionremark;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 存入(2C)代表资本项下，给申报管理用
	 */
	public void setTransactionremark(java.lang.String transactionremark) {
		this.transactionremark = transactionremark;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 交易渠道
	 */
	@Column(name = "INPUTTER", nullable = true, length = 50)
	public java.lang.String getInputter() {
		return this.inputter;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 交易渠道
	 */
	public void setInputter(java.lang.String inputter) {
		this.inputter = inputter;
	}

	@Column(name = "consol_key", nullable = true, length = 255)
	public java.lang.String getConsolKey() {
		return consolKey;
	}

	public void setConsolKey(java.lang.String consolKey) {
		this.consolKey = consolKey;
	}

	@Column(name = "category", nullable = true, length = 255)
	public java.lang.String getCategory() {
		return category;
	}

	public void setCategory(java.lang.String category) {
		this.category = category;
	}

	@Column(name = "sector", nullable = true, length = 255)
	public java.lang.String getSector() {
		return sector;
	}

	public void setSector(java.lang.String sector) {
		this.sector = sector;
	}

	@Column(name = "tenor", nullable = true, length = 255)
	public java.lang.String getTenor() {
		return tenor;
	}

	public void setTenor(java.lang.String tenor) {
		this.tenor = tenor;
	}

	@Column(name = "prodcode", nullable = true, length = 255)
	public java.lang.String getProdcode() {
		return prodcode;
	}

	public void setProdcode(java.lang.String prodcode) {
		this.prodcode = prodcode;
	}
	
	public java.lang.String getCnlsc() {
		return cnlsc;
	}

	public void setCnlsc(java.lang.String cnlsc) {
		this.cnlsc = cnlsc;
	}

	public java.lang.String getTrno() {
		return trno;
	}

	public void setTrno(java.lang.String trno) {
		this.trno = trno;
	}

	public java.lang.String getFttrtp() {
		return fttrtp;
	}

	public void setFttrtp(java.lang.String fttrtp) {
		this.fttrtp = fttrtp;
	}

	public void setCounpartyActyp(java.lang.String counpartyActyp) {
		this.counpartyActyp = counpartyActyp;
	}

	public java.lang.String getMainacod() {
		return mainacod;
	}

	public void setMainacod(java.lang.String mainacod) {
		this.mainacod = mainacod;
	}

	public java.lang.String getBpacod() {
		return bpacod;
	}

	public void setBpacod(java.lang.String bpacod) {
		this.bpacod = bpacod;
	}

	public java.lang.String getContrno() {
		return contrno;
	}

	public void setContrno(java.lang.String contrno) {
		this.contrno = contrno;
	}

	public java.lang.String getInvoino() {
		return invoino;
	}

	public void setInvoino(java.lang.String invoino) {
		this.invoino = invoino;
	}

	public java.lang.String getBillno() {
		return billno;
	}

	public void setBillno(java.lang.String billno) {
		this.billno = billno;
	}

	public java.math.BigDecimal getContamt() {
		return contamt;
	}

	public void setContamt(java.math.BigDecimal contamt) {
		this.contamt = contamt;
	}

}
