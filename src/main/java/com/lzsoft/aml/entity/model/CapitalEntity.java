package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 注册资本金表
 * @author onlineGenerator
 * @date 2015-09-25 15:52:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_capital", schema = "")
@SuppressWarnings("serial")
public class CapitalEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**科目编号*/
	private java.lang.String glcode;
	/**账户币种*/
	private java.lang.String ccy;
	/**上一级机构代码*/
	private java.lang.String parentbrca;
	/**分支机构代码*/
	private java.lang.String brca;
	/**账户会计余额*/
	private java.math.BigDecimal balance;
	/**账户会计余额折人民币*/
	private java.math.BigDecimal balancecny;
	/**账户会计余额折美金*/
	private java.math.BigDecimal balanceusd;
	/**账户会计余额等值人民币*/
	private java.math.BigDecimal balanceCnyEqv;
	/**系统日期*/
	private java.util.Date sysDate;
	/**营业日期*/
	private java.util.Date importdate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  科目编号
	 */
	@Column(name ="GLCODE",nullable=true,length=50)
	public java.lang.String getGlcode(){
		return this.glcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  科目编号
	 */
	public void setGlcode(java.lang.String glcode){
		this.glcode = glcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账户币种
	 */
	@Column(name ="CCY",nullable=true,length=3)
	public java.lang.String getCcy(){
		return this.ccy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户币种
	 */
	public void setCcy(java.lang.String ccy){
		this.ccy = ccy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上一级机构代码
	 */
	@Column(name ="PARENTBRCA",nullable=true,length=50)
	public java.lang.String getParentbrca(){
		return this.parentbrca;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上一级机构代码
	 */
	public void setParentbrca(java.lang.String parentbrca){
		this.parentbrca = parentbrca;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分支机构代码
	 */
	@Column(name ="BRCA",nullable=true,length=50)
	public java.lang.String getBrca(){
		return this.brca;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分支机构代码
	 */
	public void setBrca(java.lang.String brca){
		this.brca = brca;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  账户会计余额
	 */
	@Column(name ="BALANCE",nullable=true, scale = 4, length = 20)
	public java.math.BigDecimal getBalance(){
		return this.balance;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  账户会计余额
	 */
	public void setBalance(java.math.BigDecimal balance){
		this.balance = balance;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  账户会计余额折人民币
	 */
	@Column(name ="BALANCECNY",nullable=true, scale = 4, length = 20)
	public java.math.BigDecimal getBalancecny(){
		return this.balancecny;
	}
	
	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  账户会计余额折人民币
	 */
	public void setBalancecny(java.math.BigDecimal balancecny){
		this.balancecny = balancecny;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  账户会计余额折美金
	 */
	@Column(name ="BALANCEUSD",nullable=true, scale = 4, length = 20)
	public java.math.BigDecimal getBalanceusd(){
		return this.balanceusd;
	}
	
	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  账户会计余额折美金
	 */
	public void setBalanceusd(java.math.BigDecimal balanceusd){
		this.balanceusd = balanceusd;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  账户会计余额等值人民币
	 */
	@Column(name ="BALANCE_CNY_EQV",nullable=true, scale = 4, length = 20)
	public java.math.BigDecimal getBalanceCnyEqv(){
		return this.balanceCnyEqv;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  账户会计余额等值人民币
	 */
	public void setBalanceCnyEqv(java.math.BigDecimal balanceCnyEqv){
		this.balanceCnyEqv = balanceCnyEqv;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  系统日期
	 */
	@Column(name ="SYS_DATE",nullable=false)
	public java.util.Date getSysDate(){
		return this.sysDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  系统日期
	 */
	public void setSysDate(java.util.Date sysDate){
		this.sysDate = sysDate;
	}
	
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  营业日期
	 */
	@Column(name ="IMPORTDATE",nullable=false)
	public java.util.Date getImportdate(){
		return this.importdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  营业日期
	 */
	public void setImportdate(java.util.Date importdate){
		this.importdate = importdate;
	}
}
