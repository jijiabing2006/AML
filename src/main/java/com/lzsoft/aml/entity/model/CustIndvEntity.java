package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 个人客户信息表
 * @author onlineGenerator
 * @date 2015-08-26 15:22:32
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_cust_indv", schema = "")
@SuppressWarnings("serial")
@PrimaryKeyJoinColumn(name = "id")
public class CustIndvEntity extends CustBaseEntity implements java.io.Serializable {
	/**是否出生在美国*/
	@Excel(name="是否出生在美国")
	private java.lang.String piabi;
	/**居住地国别代码*/
	@Excel(name="居住地国别代码")
	private java.lang.String resi;
	/**居住所在省市*/
	@Excel(name="居住所在省市")
	private java.lang.String pro;
	/**居住所在城市区*/
	@Excel(name="居住所在城市区")
	private java.lang.String city;
	/**行业*/
	@Excel(name="行业")
	private java.lang.String industrycode;
	/**出生日期*/
	@Excel(name="出生日期")
	private java.util.Date dob;
	/**是否为本行员工*/
	@Excel(name="是否为本行员工")
	private java.lang.String isem;
	/**是否为股东*/
	@Excel(name="是否为股东")
	private java.lang.String shod;
	/**个人证件类型*/
	@Excel(name="个人证件类型")
	private java.lang.String citp;
	/**性别*/
	@Excel(name="性别")
	private java.lang.String gend;
	/**婚姻状况*/
	@Excel(name="婚姻状况")
	private java.lang.String mars;
	/**职业*/
	@Excel(name="职业")
	private java.lang.String job;
	/**发证机关代码*/
	@Excel(name="发证机关代码")
	private java.lang.String issa;
	/**邮编*/
	@Excel(name="邮编")
	private java.lang.String zipcode;
	/**个人年收入*/
	@Excel(name="个人年收入")
	private java.lang.String income;
	/**是否为黑名单客户*/
	@Excel(name="是否为黑名单客户")
	private java.lang.String isbl;
	/**黑名单原因*/
	@Excel(name="黑名单原因")
	private java.lang.String blre;
	/**居住情况*/
	@Excel(name="居住情况")
	private java.lang.String lvst;
	/**地区编号*/
	@Excel(name="地区编号")
	private java.lang.String regc;
	/**开户日期*/
	@Excel(name="开户日期")
	private java.util.Date opdt;
	/**民族*/
	@Excel(name="民族")
	private java.lang.String nation;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否出生在美国
	 */
	@Column(name ="PIABI",nullable=true,length=10)
	public java.lang.String getPiabi(){
		return this.piabi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否出生在美国
	 */
	public void setPiabi(java.lang.String piabi){
		this.piabi = piabi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住地国别代码
	 */
	@Column(name ="RESI",nullable=true,length=10)
	public java.lang.String getResi(){
		return this.resi;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住地国别代码
	 */
	public void setResi(java.lang.String resi){
		this.resi = resi;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住所在省市
	 */
	@Column(name ="PRO",nullable=true,length=10)
	public java.lang.String getPro(){
		return this.pro;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住所在省市
	 */
	public void setPro(java.lang.String pro){
		this.pro = pro;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住所在城市区
	 */
	@Column(name ="CITY",nullable=true,length=100)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住所在城市区
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行业
	 */
	@Column(name ="INDUSTRYCODE",nullable=true,length=10)
	public java.lang.String getIndustrycode(){
		return this.industrycode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行业
	 */
	public void setIndustrycode(java.lang.String industrycode){
		this.industrycode = industrycode;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出生日期
	 */
	@Column(name ="DOB",nullable=true)
	public java.util.Date getDob(){
		return this.dob;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出生日期
	 */
	public void setDob(java.util.Date dob){
		this.dob = dob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否为本行员工
	 */
	@Column(name ="ISEM",nullable=true,length=10)
	public java.lang.String getIsem(){
		return this.isem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否为本行员工
	 */
	public void setIsem(java.lang.String isem){
		this.isem = isem;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否为股东
	 */
	@Column(name ="SHOD",nullable=true,length=10)
	public java.lang.String getShod(){
		return this.shod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否为股东
	 */
	public void setShod(java.lang.String shod){
		this.shod = shod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人证件类型
	 */
	@Column(name ="CITP",nullable=true,length=10)
	public java.lang.String getCitp(){
		return this.citp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人证件类型
	 */
	public void setCitp(java.lang.String citp){
		this.citp = citp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="GEND",nullable=true,length=10)
	public java.lang.String getGend(){
		return this.gend;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setGend(java.lang.String gend){
		this.gend = gend;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  婚姻状况
	 */
	@Column(name ="MARS",nullable=true,length=10)
	public java.lang.String getMars(){
		return this.mars;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  婚姻状况
	 */
	public void setMars(java.lang.String mars){
		this.mars = mars;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职业
	 */
	@Column(name ="JOB",nullable=true,length=100)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职业
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发证机关代码
	 */
	@Column(name ="ISSA",nullable=true,length=100)
	public java.lang.String getIssa(){
		return this.issa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发证机关代码
	 */
	public void setIssa(java.lang.String issa){
		this.issa = issa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮编
	 */
	@Column(name ="ZIPCODE",nullable=true,length=35)
	public java.lang.String getZipcode(){
		return this.zipcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮编
	 */
	public void setZipcode(java.lang.String zipcode){
		this.zipcode = zipcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人年收入
	 */
	@Column(name ="INCOME",nullable=true,length=100)
	public java.lang.String getIncome(){
		return this.income;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人年收入
	 */
	public void setIncome(java.lang.String income){
		this.income = income;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否为黑名单客户
	 */
	@Column(name ="ISBL",nullable=true,length=10)
	public java.lang.String getIsbl(){
		return this.isbl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否为黑名单客户
	 */
	public void setIsbl(java.lang.String isbl){
		this.isbl = isbl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  黑名单原因
	 */
	@Column(name ="BLRE",nullable=true,length=100)
	public java.lang.String getBlre(){
		return this.blre;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  黑名单原因
	 */
	public void setBlre(java.lang.String blre){
		this.blre = blre;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  居住情况
	 */
	@Column(name ="LVST",nullable=true,length=100)
	public java.lang.String getLvst(){
		return this.lvst;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  居住情况
	 */
	public void setLvst(java.lang.String lvst){
		this.lvst = lvst;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地区编号
	 */
	@Column(name ="REGC",nullable=true,length=10)
	public java.lang.String getRegc(){
		return this.regc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地区编号
	 */
	public void setRegc(java.lang.String regc){
		this.regc = regc;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开户日期
	 */
	@Column(name ="OPDT",nullable=true)
	public java.util.Date getOpdt(){
		return this.opdt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开户日期
	 */
	public void setOpdt(java.util.Date opdt){
		this.opdt = opdt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族
	 */
	@Column(name ="NATION",nullable=true,length=10)
	public java.lang.String getNation(){
		return this.nation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setNation(java.lang.String nation){
		this.nation = nation;
	}
}
