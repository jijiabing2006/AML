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
 * @Description: 总帐表
 * @author onlineGenerator
 * @date 2015-09-25 15:51:38
 * @version V1.0
 * 
 */
@Entity
@Table(name = "t_acc_gl", schema = "")
@SuppressWarnings("serial")
public class AccGLEntity implements java.io.Serializable {
	/** id */
	private java.lang.String id;
	/** 明细科目编号 */
	@Excel(name = "明细科目编号")
	private java.lang.String num;
	/** 科目名称 */
	@Excel(name = "科目名称")
	private java.lang.String name;
	/** 科目币种 */
	@Excel(name = "科目币种")
	private java.lang.String ccy;
	/** 上一级机构代码 */
	@Excel(name = "上一级机构代码")
	private java.lang.String parentbrca;
	/** 分支机构代码 */
	@Excel(name = "分支机构代码")
	private java.lang.String brca;
	/** 科目余额 */
	@Excel(name = "科目余额")
	private java.math.BigDecimal balance;
	/** 科目余额折人民币 */
	@Excel(name = "科目余额折人民币")
	private java.math.BigDecimal balancecny;
	/** 科目余额折美元 */
	@Excel(name = "科目余额折美元")
	private java.math.BigDecimal balanceusd;
	/** 账户分类 */
	@Excel(name = "账户分类")
	private java.lang.String clsfctItem;
	/** 借方发生额 */
	@Excel(name = "借方发生额")
	private java.math.BigDecimal da;
	/** 贷方发生额 */
	@Excel(name = "贷方发生额")
	private java.math.BigDecimal ca;
	/** 账号级别 */
	@Excel(name = "账号级别")
	private java.lang.String level;
	/** 记账时间 */
	@Excel(name = "记账时间")
	private java.util.Date actDate;
	/** 营业日期 */
	@Excel(name = "营业日期")
	private java.util.Date importdate;

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String id
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
	 * @param: java.lang.String id
	 */
	public void setId(java.lang.String id) {
		this.id = id;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 明细科目编号
	 */
	@Column(name = "NUM", nullable = true, length = 50)
	public java.lang.String getNum() {
		return this.num;
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
	 * @return: java.lang.String 科目名称
	 */
	@Column(name = "NAME", nullable = true, length = 100)
	public java.lang.String getName() {
		return this.name;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 科目名称
	 */
	public void setName(java.lang.String name) {
		this.name = name;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 科目币种
	 */
	@Column(name = "CCY", nullable = true, length = 3)
	public java.lang.String getCcy() {
		return this.ccy;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 科目币种
	 */
	public void setCcy(java.lang.String ccy) {
		this.ccy = ccy;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 上一级机构代码
	 */
	@Column(name = "PARENTBRCA", nullable = true, length = 50)
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
	@Column(name = "BRCA", nullable = true, length = 50)
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
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 科目余额
	 */
	@Column(name = "BALANCE", nullable = true, scale = 8, length = 20)
	public java.math.BigDecimal getBalance() {
		return this.balance;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 科目余额
	 */
	public void setBalance(java.math.BigDecimal balance) {
		this.balance = balance;
	}
	
	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 科目余额折人民币
	 */
	@Column(name = "BALANCECNY", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getBalancecny() {
		return balancecny;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 科目余额折人民币
	 */
	public void setBalancecny(java.math.BigDecimal balancecny) {
		this.balancecny = balancecny;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 科目余额折美金
	 */
	@Column(name = "BALANCEUSD", nullable = true, scale = 4, length = 20)
	public java.math.BigDecimal getBalanceusd() {
		return balanceusd;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 科目余额折美金
	 */
	public void setBalanceusd(java.math.BigDecimal balanceusd) {
		this.balanceusd = balanceusd;
	}

	/**
	 * 方法: 取得java.lang.String
	 * 
	 * @return: java.lang.String 账户分类
	 */
	@Column(name = "CLSFCT_ITEM", nullable = true, length = 50)
	public java.lang.String getClsfctItem() {
		return this.clsfctItem;
	}

	/**
	 * 方法: 设置java.lang.String
	 * 
	 * @param: java.lang.String 账户分类
	 */
	public void setClsfctItem(java.lang.String clsfctItem) {
		this.clsfctItem = clsfctItem;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 借方发生额
	 */
	@Column(name = "DA", nullable = true, scale = 8, length = 20)
	public java.math.BigDecimal getDa() {
		return this.da;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 借方发生额
	 */
	public void setDa(java.math.BigDecimal da) {
		this.da = da;
	}

	/**
	 * 方法: 取得java.math.BigDecimal
	 * 
	 * @return: java.math.BigDecimal 贷方发生额
	 */
	@Column(name = "CA", nullable = true, scale = 8, length = 20)
	public java.math.BigDecimal getCa() {
		return this.ca;
	}

	/**
	 * 方法: 设置java.math.BigDecimal
	 * 
	 * @param: java.math.BigDecimal 贷方发生额
	 */
	public void setCa(java.math.BigDecimal ca) {
		this.ca = ca;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 记账时间
	 */
	@Column(name = "ACT_DATE", nullable = true)
	public java.util.Date getActDate() {
		return this.actDate;
	}

	/**
	 * 方法: 设置java.util.Date
	 * 
	 * @param: java.util.Date 记账时间
	 */
	public void setActDate(java.util.Date actDate) {
		this.actDate = actDate;
	}

	/**
	 * 方法: 取得java.util.Date
	 * 
	 * @return: java.util.Date 营业日期
	 */
	@Column(name = "IMPORTDATE", nullable = true)
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

	@Column(name = "LEVEL", nullable = true)
	public java.lang.String getLevel() {
		return level;
	}

	public void setLevel(java.lang.String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "AccGLEntity [num=" + num + ", name=" + name + ", ccy=" + ccy
				+ ", parentbrca=" + parentbrca + ", brca=" + brca
				+ ", balance=" + balance + ", level=" + level + "]";
	}
	
}
