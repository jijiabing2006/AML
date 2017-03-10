package com.lzsoft.aml.entity.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 汇率表
 * @author zhangdaihao
 * @date 2016-02-16 10:15:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_exchange_rate", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ExchangeRateEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**币种*/
	private java.lang.String ccy;
	/**折算类型*/
	private java.lang.String exchangemethod;
	/**汇率类型 */
	private java.lang.String ratetype;
	/**导入日期*/
	private java.util.Date importdate;
	/**买入汇率*/
	private BigDecimal exchangerateBuy;
	/**中间汇率*/
	private BigDecimal exchangerateMid;
	/**卖出汇率*/
	private BigDecimal exchangerateSell;
	/**日期*/
	private java.util.Date date;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
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
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币种
	 */
	@Column(name ="CCY",nullable=false,length=3)
	public java.lang.String getCcy(){
		return this.ccy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  币种
	 */
	public void setCcy(java.lang.String ccy){
		this.ccy = ccy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  折算类型
	 */
	@Column(name ="EXCHANGEMETHOD",nullable=false,length=1)
	public java.lang.String getExchangemethod(){
		return this.exchangemethod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  折算类型
	 */
	public void setExchangemethod(java.lang.String exchangemethod){
		this.exchangemethod = exchangemethod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  汇率类型 
	 */
	@Column(name ="RATETYPE",nullable=false,length=2)
	public java.lang.String getRatetype(){
		return this.ratetype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  汇率类型 
	 */
	public void setRatetype(java.lang.String ratetype){
		this.ratetype = ratetype;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  导入日期
	 */
	@Column(name ="IMPORTDATE",nullable=false)
	public java.util.Date getImportdate(){
		return this.importdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  导入日期
	 */
	public void setImportdate(java.util.Date importdate){
		this.importdate = importdate;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  买入汇率
	 */
	@Column(name ="EXCHANGERATE_BUY",nullable=false,precision=19,scale=8)
	public BigDecimal getExchangerateBuy(){
		return this.exchangerateBuy;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  买入汇率
	 */
	public void setExchangerateBuy(BigDecimal exchangerateBuy){
		this.exchangerateBuy = exchangerateBuy;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  中间汇率
	 */
	@Column(name ="EXCHANGERATE_MID",nullable=false,precision=19,scale=8)
	public BigDecimal getExchangerateMid(){
		return this.exchangerateMid;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  中间汇率
	 */
	public void setExchangerateMid(BigDecimal exchangerateMid){
		this.exchangerateMid = exchangerateMid;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  卖出汇率
	 */
	@Column(name ="EXCHANGERATE_SELL",nullable=false,precision=19,scale=8)
	public BigDecimal getExchangerateSell(){
		return this.exchangerateSell;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  卖出汇率
	 */
	public void setExchangerateSell(BigDecimal exchangerateSell){
		this.exchangerateSell = exchangerateSell;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  日期
	 */
	@Column(name ="DATE",nullable=false)
	public java.util.Date getDate(){
		return this.date;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  日期
	 */
	public void setDate(java.util.Date date){
		this.date = date;
	}
}
