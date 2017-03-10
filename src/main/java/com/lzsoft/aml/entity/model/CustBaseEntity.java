package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 客户基础信息
 * @author zhangdaihao
 * @date 2016-03-02 17:00:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_cust_base", schema = "")
@SuppressWarnings("serial")
@Inheritance(strategy = InheritanceType.JOINED)
public class CustBaseEntity extends IdEntity implements java.io.Serializable {

	/**客户编号*/
	@Excel(name="客户编号")
	private java.lang.String csnm;
	/**客户名称*/
	@Excel(name="客户名称")
	private java.lang.String ctnm;
	/**分行机构代码*/
	@Excel(name="分行机构代码")
	private java.lang.String brca;
	/**上级机构代码*/
	@Excel(name="上级机构代码")
	private java.lang.String parentbrca;
	/**国籍*/
	@Excel(name="国籍")
	private java.lang.String ctnt;
	/**客户类型*/
	@Excel(name="客户类型")
	private java.lang.String cs;
	/**客户英文名称*/
	@Excel(name="客户英文名称")
	private java.lang.String ctnmen;
	/**证件号码*/
	@Excel(name="证件号码")
	private java.lang.String encode;
	/**客户标识*/
	@Excel(name="客户标识")
	private java.lang.String islocal;
	/**联系方式-电话*/
	@Excel(name="联系方式-电话")
	private java.lang.String phone;
	/**联系方式-传真*/
	@Excel(name="联系方式-传真")
	private java.lang.String fax;
	/**联系方式-短信*/
	@Excel(name="联系方式-短信")
	private java.lang.String sms;
	/**联系方式-email*/
	@Excel(name="联系方式-email")
	private java.lang.String email;
	/**联系方式-通信地址*/
	@Excel(name="联系方式-通信地址")
	private java.lang.String caddress;
	/**地址*/
	@Excel(name="地址")
	private java.lang.String address;
	/**纳税人类型*/
	@Excel(name="纳税人类型")
	private java.lang.String taxpayerType;
	/**基本户开户行*/
	@Excel(name="基本户开户行")
	private java.lang.String basicAcBank;
	/**基本户号*/
	@Excel(name="基本户号")
	private java.lang.String basicAc;
	/**客户状态*/
	@Excel(name="客户状态")
	private java.lang.String status;
	/**国民经济代码（FTZ）*/
	@Excel(name="国民经济代码（FTZ）")
	private java.lang.String nescft;
	/**国民经济代码（大类）*/
	@Excel(name="国民经济代码（大类）")
	private java.lang.String nesclv1;
	/**国民经济代码（小类）*/
	@Excel(name="国民经济代码（小类）")
	private java.lang.String nesclv2;
	/**客户分类*/
	@Excel(name="客户分类")
	private java.lang.String attribute;
	/**数据来源*/
	@Excel(name="数据来源")
	private java.lang.String source;
	/**系统日期*/
	@Excel(name="系统日期")
	private java.util.Date sysDate;
	/**营业日期*/
	@Excel(name="营业日期")
	private java.util.Date importdate;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户编号
	 */
	@Column(name ="CSNM",nullable=true,length=20)
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
	@Column(name ="CTNM",nullable=true,length=100)
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
	 *@return: java.lang.String  分行机构代码
	 */
	@Column(name ="BRCA",nullable=true,length=20)
	public java.lang.String getBrca(){
		return this.brca;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分行机构代码
	 */
	public void setBrca(java.lang.String brca){
		this.brca = brca;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上级机构代码
	 */
	@Column(name ="PARENTBRCA",nullable=true,length=20)
	public java.lang.String getParentbrca(){
		return this.parentbrca;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上级机构代码
	 */
	public void setParentbrca(java.lang.String parentbrca){
		this.parentbrca = parentbrca;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国籍
	 */
	@Column(name ="CTNT",nullable=true,length=10)
	public java.lang.String getCtnt(){
		return this.ctnt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国籍
	 */
	public void setCtnt(java.lang.String ctnt){
		this.ctnt = ctnt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户类型
	 */
	@Column(name ="CS",nullable=true,length=10)
	public java.lang.String getCs(){
		return this.cs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户类型
	 */
	public void setCs(java.lang.String cs){
		this.cs = cs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户英文名称
	 */
	@Column(name ="CTNMEN",nullable=true,length=100)
	public java.lang.String getCtnmen(){
		return this.ctnmen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户英文名称
	 */
	public void setCtnmen(java.lang.String ctnmen){
		this.ctnmen = ctnmen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证件号码
	 */
	@Column(name ="ENCODE",nullable=true,length=100)
	public java.lang.String getEncode(){
		return this.encode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证件号码
	 */
	public void setEncode(java.lang.String encode){
		this.encode = encode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户标识
	 */
	@Column(name ="ISLOCAL",nullable=true,length=1)
	public java.lang.String getIslocal(){
		return this.islocal;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户标识
	 */
	public void setIslocal(java.lang.String islocal){
		this.islocal = islocal;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=255)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  营业日期
	 */
	@Column(name ="IMPORTDATE",nullable=true)
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  caddresss
	 */
	@Column(name ="CADDRESS",nullable=true,length=255)
	public java.lang.String getCaddress(){
		return this.caddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  caddresss
	 */
	public void setCaddress(java.lang.String caddress){
		this.caddress = caddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  email
	 */
	@Column(name ="EMAIL",nullable=true,length=100)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  email
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  fax
	 */
	@Column(name ="FAX",nullable=true,length=20)
	public java.lang.String getFax(){
		return this.fax;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  fax
	 */
	public void setFax(java.lang.String fax){
		this.fax = fax;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  phone
	 */
	@Column(name ="PHONE",nullable=true,length=20)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  phone
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  sms
	 */
	@Column(name ="SMS",nullable=true,length=20)
	public java.lang.String getSms(){
		return this.sms;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  sms
	 */
	public void setSms(java.lang.String sms){
		this.sms = sms;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  纳税人类型
	 */
	@Column(name ="TAXPAYER_TYPE",nullable=true,length=50)
	public java.lang.String getTaxpayerType(){
		return this.taxpayerType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  纳税人类型
	 */
	public void setTaxpayerType(java.lang.String taxpayerType){
		this.taxpayerType = taxpayerType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本户开户行
	 */
	@Column(name ="BASIC_AC_BANK",nullable=true,length=255)
	public java.lang.String getBasicAcBank(){
		return this.basicAcBank;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本户开户行
	 */
	public void setBasicAcBank(java.lang.String basicAcBank){
		this.basicAcBank = basicAcBank;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本户号
	 */
	@Column(name ="BASIC_AC",nullable=true,length=50)
	public java.lang.String getBasicAc(){
		return this.basicAc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本户号
	 */
	public void setBasicAc(java.lang.String basicAc){
		this.basicAc = basicAc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户状态
	 */
	@Column(name ="STATUS",nullable=true,length=1)
	public java.lang.String getStatus(){
		return this.status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户状态
	 */
	public void setStatus(java.lang.String status){
		this.status = status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国民经济代码（FTZ）
	 */
	@Column(name ="NESCFT",nullable=true,length=50)
	public java.lang.String getNescft(){
		return this.nescft;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国民经济代码（FTZ）
	 */
	public void setNescft(java.lang.String nescft){
		this.nescft = nescft;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国民经济代码（大类）
	 */
	@Column(name ="NESCLV1",nullable=true,length=50)
	public java.lang.String getNesclv1(){
		return this.nesclv1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国民经济代码（大类）
	 */
	public void setNesclv1(java.lang.String nesclv1){
		this.nesclv1 = nesclv1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国民经济代码（小类）
	 */
	@Column(name ="NESCLV2",nullable=true,length=50)
	public java.lang.String getNesclv2(){
		return this.nesclv2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国民经济代码（小类）
	 */
	public void setNesclv2(java.lang.String nesclv2){
		this.nesclv2 = nesclv2;
	}
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户分类
	 */
	@Column(name ="ATTRIBUTE",nullable=true,length=50)
	public java.lang.String getAttribute() {
		return attribute;
	}
	
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户分类
	 */
	public void setAttribute(java.lang.String attribute) {
		this.attribute = attribute;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  数据来源
	 */
	@Column(name ="SOURCE",nullable=true,length=50)
	public java.lang.String getSource() {
		return source;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  数据来源
	 */
	public void setSource(java.lang.String source) {
		this.source = source;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  系统日期
	 */
	@Column(name ="SYS_DATE",nullable=true)
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
}
