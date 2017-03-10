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
 * @Description: 客户关系表
 * @author onlineGenerator
 * @date 2015-08-26 15:22:45
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_cust_relation", schema = "")
@SuppressWarnings("serial")
public class CustRelationEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**客户编号*/
	@Excel(name="客户编号")
	private java.lang.String csnm;
	/**客户名称*/
	@Excel(name="客户名称")
	private java.lang.String ctnm;
	/**关联方客户编号*/
	@Excel(name="关联方客户编号")
	private java.lang.String afcsnm;
	/**关联方客户名称*/
	@Excel(name="关联方客户名称")
	private java.lang.String afctnm;
	/**关联方关系*/
	@Excel(name="关联方关系")
	private java.lang.String repr;
	/**关联人证件类型*/
	@Excel(name="关联人证件类型")
	private java.lang.String apidt;
	/**关联人证件号*/
	@Excel(name="关联人证件号")
	private java.lang.String apidn;
	/**系统日期*/
	@Excel(name="系统日期")
	private java.util.Date sysDate;
	/**营业日期*/
	@Excel(name="营业日期")
	private java.util.Date importdate;
	
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
	 *@return: java.lang.String  客户编号
	 */
	@Column(name ="CSNM",nullable=false,length=20)
	public java.lang.String getCsnm(){
		return this.csnm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户编号
	 */
	public void setCsnm(java.lang.String csnm){
		this.csnm = csnm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户名称
	 */
	@Column(name ="CTNM",nullable=true,length=255)
	public java.lang.String getCtnm(){
		return this.ctnm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户名称
	 */
	public void setCtnm(java.lang.String ctnm){
		this.ctnm = ctnm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联方客户编号
	 */
	@Column(name ="AFCSNM",nullable=true,length=20)
	public java.lang.String getAfcsnm(){
		return this.afcsnm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联方客户编号
	 */
	public void setAfcsnm(java.lang.String afcsnm){
		this.afcsnm = afcsnm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联方客户名称
	 */
	@Column(name ="AFCTNM",nullable=true,length=255)
	public java.lang.String getAfctnm(){
		return this.afctnm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联方客户名称
	 */
	public void setAfctnm(java.lang.String afctnm){
		this.afctnm = afctnm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联方关系
	 */
	@Column(name ="REPR",nullable=true,length=50)
	public java.lang.String getRepr(){
		return this.repr;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联方关系
	 */
	public void setRepr(java.lang.String repr){
		this.repr = repr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联人证件类型
	 */
	@Column(name ="APIDT",nullable=true,length=50)
	public java.lang.String getApidt(){
		return this.apidt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联人证件类型
	 */
	public void setApidt(java.lang.String apidt){
		this.apidt = apidt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联人证件号
	 */
	@Column(name ="APIDN",nullable=true,length=50)
	public java.lang.String getApidn(){
		return this.apidn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联人证件号
	 */
	public void setApidn(java.lang.String apidn){
		this.apidn = apidn;
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
