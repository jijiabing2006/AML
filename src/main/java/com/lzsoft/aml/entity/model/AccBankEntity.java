package com.lzsoft.aml.entity.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: 账户信息表
 * @author onlineGenerator
 * @date 2015-08-26 15:14:50
 * @version V1.0
 * 
 */
@Entity
@Table(name = "t_acc_bank", schema = "")
@SuppressWarnings("serial")
public class AccBankEntity implements java.io.Serializable {

	/** 主键 */
	private java.lang.String id;
	/** 账号 */
	private java.lang.String acod;
	/** 客户代码 */
	private java.lang.String csnm;
	/** 账户Category */
	private java.lang.String category;
	/** 账户属性 */
	private java.lang.String accounttype;
	/** 账户币种 */
	private java.lang.String ccy;
	/** 上一级机构代码 */
	private java.lang.String parentbrca;
	/** 分支机构代码 */
	private java.lang.String brca;
	/** 开户日期 */
	private java.util.Date opendate;
	/** 取现标志 */
	private java.lang.String echam;
	/** 账户生效日 */
	private java.util.Date effdate;
	/** 销户日期 */
	private java.util.Date closedate;
	/** 账户到期日 */
	private java.util.Date matdate;
	/** 起息日期 */
	private java.util.Date valdate;
	/** 账户余额 */
	private java.math.BigDecimal balance;
	/** 账户余额折人民币 */
	private java.math.BigDecimal balancecny;
	/** 账户余额折美金 */
	private java.math.BigDecimal balanceusd;
	/** 上日余额 */
	private java.math.BigDecimal clsBal;
	/** 计息周期 */
	private java.lang.String intPrd;
	/** 结息周期 */
	private java.lang.String intStmt;
	/** 核准件编码 */
	private java.lang.String fileNumber;
	/** 最后交易日期 */
	private java.util.Date lmdt;
	/** 账户状态(T24) */
	private java.lang.String status;
	/** 账户状态 */
	private java.lang.String accountstat;
	/** 账户类别 */
	private java.lang.String accountcata;
	/** 限额类型 */
	private java.lang.String limittype;
	/** 账户限额 */
	private java.math.BigDecimal accountlimit;
	/**开户主体类型*/
	private java.lang.String amtype;
	/** 自由贸易账户类型 */
	private java.lang.String ftType;
	/** 主账号代码 */
	private java.lang.String mainacod;
	/** 申报账号 */
	private java.lang.String bpacod;
	/** 系统日期 */
	private java.util.Date sysDate;
	/** 营业日期 */
	private java.util.Date importdate;

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name = "ID", nullable = false, length = 32)
	public java.lang.String getId() {
		return this.id;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 主键
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账号
	 */
	@Column(name = "ACOD", nullable = false, length = 20)
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
	 * @return: java.lang.String 客户代码
	 */
	@Column(name = "CSNM", nullable = false, length = 20)
	public java.lang.String getCsnm() {
		return this.csnm;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 客户代码
	 */
	public void setCsnm(java.lang.String csnm) {
		this.csnm = csnm;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账户CATEGORY
	 */
	@Column(name = "CATEGORY", nullable = true, length = 10)
	public java.lang.String getCategory() {
		return category;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账户CATEGORY
	 */
	public void setCategory(java.lang.String category) {
		this.category = category;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账户属性
	 */
	@Column(name = "ACCOUNTTYPE", nullable = true, length = 10)
	public java.lang.String getAccounttype() {
		return this.accounttype;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账户属性
	 */
	public void setAccounttype(java.lang.String accounttype) {
		this.accounttype = accounttype;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账户币种
	 */
	@Column(name = "CCY", nullable = false, length = 10)
	public java.lang.String getCcy() {
		return this.ccy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账户币种
	 */
	public void setCcy(java.lang.String ccy) {
		this.ccy = ccy;
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
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 开户日期
	 */
	@Column(name = "OPENDATE", nullable = true)
	public java.util.Date getOpendate() {
		return this.opendate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 开户日期
	 */
	public void setOpendate(java.util.Date opendate) {
		this.opendate = opendate;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 取现标志
	 */
	@Column(name = "ECHAM", nullable = true, length = 50)
	public java.lang.String getEcham() {
		return this.echam;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 取现标志
	 */
	public void setEcham(java.lang.String echam) {
		this.echam = echam;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 账户生效日
	 */
	@Column(name = "EFFDATE", nullable = true)
	public java.util.Date getEffdate() {
		return this.effdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 账户生效日
	 */
	public void setEffdate(java.util.Date effdate) {
		this.effdate = effdate;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 销户日期
	 */
	@Column(name = "CLOSEDATE", nullable = true)
	public java.util.Date getClosedate() {
		return this.closedate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 销户日期
	 */
	public void setClosedate(java.util.Date closedate) {
		this.closedate = closedate;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 账户到期日
	 */
	@Column(name = "MATDATE", nullable = true)
	public java.util.Date getMatdate() {
		return this.matdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 账户到期日
	 */
	public void setMatdate(java.util.Date matdate) {
		this.matdate = matdate;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 起息日期
	 */
	@Column(name = "VALDATE", nullable = true)
	public java.util.Date getValdate() {
		return this.valdate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 起息日期
	 */
	public void setValdate(java.util.Date valdate) {
		this.valdate = valdate;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 账户余额
	 */
	@Column(name = "BALANCE", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getBalance() {
		if(null == this.balance) {
			return new BigDecimal(0.00);
		} else {
			return this.balance;
		}
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 账户余额
	 */
	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 账户余额折人民币
	 */
	@Column(name = "BALANCECNY", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getBalancecny() {
		return balancecny;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 账户余额折人民币
	 */
	public void setBalancecny(java.math.BigDecimal balancecny) {
		this.balancecny = balancecny;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 账户余额折美金
	 */
	@Column(name = "BALANCEUSD", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getBalanceusd() {
		return balanceusd;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 账户余额折美金
	 */
	public void setBalanceusd(java.math.BigDecimal balanceusd) {
		this.balanceusd = balanceusd;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 上日余额
	 */
	@Column(name = "CLS_BAL", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getClsBal() {
		if(null == this.clsBal) {
			return new BigDecimal(0.00);
		} else {
			return this.clsBal;
		}
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 上日余额
	 */
	public void setClsBal(java.math.BigDecimal clsBal) {
		this.clsBal = clsBal;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 计息周期
	 */
	@Column(name = "INT_PRD", nullable = true, length = 50)
	public java.lang.String getIntPrd() {
		return this.intPrd;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 计息周期
	 */
	public void setIntPrd(java.lang.String intPrd) {
		this.intPrd = intPrd;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 结息周期
	 */
	@Column(name = "INT_STMT", nullable = true, length = 50)
	public java.lang.String getIntStmt() {
		return this.intStmt;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 结息周期
	 */
	public void setIntStmt(java.lang.String intStmt) {
		this.intStmt = intStmt;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  核准件号码
	 */
	@Column(name ="FILE_NUMBER",nullable=true,length=50)
	public java.lang.String getFileNumber(){
		return this.fileNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  核准件号码
	 */
	public void setFileNumber(java.lang.String fileNumber){
		this.fileNumber = fileNumber;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 最后交易日期
	 */
	@Column(name = "LMDT", nullable = true)
	public java.util.Date getLmdt() {
		return this.lmdt;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 最后交易日期
	 */
	public void setLmdt(java.util.Date lmdt) {
		this.lmdt = lmdt;
	}
	
	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账户T24状态
	 */
	@Column(name = "STATUS", nullable = true, length = 50)
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账户T24状态
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账户状态
	 */
	@Column(name = "ACCOUNTSTAT", nullable = true, length = 50)
	public java.lang.String getAccountstat() {
		return this.accountstat;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账户状态
	 */
	public void setAccountstat(java.lang.String accountstat) {
		this.accountstat = accountstat;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户类别
	 */
	@Column(name ="ACCOUNTCATA",nullable=true,length=10)
	public java.lang.String getAccountcata(){
		return this.accountcata;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户类别
	 */
	public void setAccountcata(java.lang.String accountcata){
		this.accountcata = accountcata;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 限额类型
	 */
	@Column(name = "LIMITTYPE", nullable = true, length = 10)
	public java.lang.String getLimittype() {
		return this.limittype;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 限额类型
	 */
	public void setLimittype(java.lang.String limittype) {
		this.limittype = limittype;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 账户限额
	 */
	@Column(name = "ACCOUNTLIMIT", nullable = true, scale = 2, length = 19)
	public java.math.BigDecimal getAccountlimit() {
		return this.accountlimit;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 账户限额
	 */
	public void setAccountlimit(java.math.BigDecimal accountlimit) {
		this.accountlimit = accountlimit;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户主体类型
	 */
	@Column(name ="AMTYPE",nullable=true,length=10)
	public java.lang.String getAmtype(){
		return this.amtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户主体类型
	 */
	public void setAmtype(java.lang.String amtype){
		this.amtype = amtype;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 自由贸易账户类型
	 */
	@Column(name = "FT_TYPE", nullable = true, length = 10)
	public java.lang.String getFtType() {
		return this.ftType;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 自由贸易账户类型
	 */
	public void setFtType(java.lang.String ftType) {
		this.ftType = ftType;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 主账号代码
	 */
	@Column(name = "MAINACOD", nullable = true, length = 50)
	public java.lang.String getMainacod() {
		return this.mainacod;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 主账号代码
	 */
	public void setMainacod(java.lang.String mainacod) {
		this.mainacod = mainacod;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 系统日期
	 */
	@Column(name = "SYS_DATE", nullable = false)
	public java.util.Date getSysDate() {
		return sysDate;
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
	 * @return: java.lang.String 申报账号
	 */
	@Column(name = "BPACOD", nullable = true, length = 50)
	public java.lang.String getBpacod() {
		return bpacod;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 申报账号
	 */
	public void setBpacod(java.lang.String bpacod) {
		this.bpacod = bpacod;
	}
}
