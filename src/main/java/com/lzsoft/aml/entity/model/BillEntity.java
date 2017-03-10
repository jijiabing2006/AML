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
 * @Description: 票据业务
 * @author onlineGenerator
 * @date 2015-08-26 15:21:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_bill", schema = "")
@SuppressWarnings("serial")
public class BillEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**票据号码*/
	@Excel(name="票据号码")
	private java.lang.String biln;
	/**出票人名称*/
	@Excel(name="出票人名称")
	private java.lang.String payen;
	/**出票人账号*/
	@Excel(name="出票人账号")
	private java.lang.String drac;
	/**付款行全称*/
	@Excel(name="付款行全称")
	private java.lang.String payb;
	/**出票日期*/
	@Excel(name="出票日期")
	private java.util.Date dais;
	/**票面到期日*/
	@Excel(name="票面到期日")
	private java.util.Date matd;
	/**票据出票人类型*/
	@Excel(name="票据出票人类型")
	private java.lang.String bptp;
	/**票面金额*/
	@Excel(name="票面金额")
	private java.math.BigDecimal fcvu;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String note;
	/**商业汇票形式*/
	@Excel(name="商业汇票形式")
	private java.lang.String cmdt;
	/**承兑人名称*/
	@Excel(name="承兑人名称")
	private java.lang.String acpn;
	/**承兑人类型*/
	@Excel(name="承兑人类型")
	private java.lang.String acpt;
	/**收款人全称*/
	@Excel(name="收款人全称")
	private java.lang.String pefn;
	/**收款人账号*/
	@Excel(name="收款人账号")
	private java.lang.String peac;
	/**收款人开户行*/
	@Excel(name="收款人开户行")
	private java.lang.String peob;
	/**贴现利率*/
	@Excel(name="贴现利率")
	private java.math.BigDecimal dicr;
	/**币种*/
	@Excel(name="币种")
	private java.lang.String ccy;
	/**担保类型*/
	@Excel(name="担保类型")
	private java.lang.String wart;
	/**贷款或表外业务合同号*/
	@Excel(name="贷款或表外业务合同号")
	private java.lang.String cnlobs;
	/**担保合同号*/
	@Excel(name="担保合同号")
	private java.lang.String grtc;
	/**授信编号*/
	@Excel(name="授信编号")
	private java.lang.String lineCode;
	/**授信类型*/
	@Excel(name="授信类型")
	private java.lang.String fact;
	/**授信币种*/
	@Excel(name="授信币种")
	private java.lang.String fccy;
	/**授信金额*/
	@Excel(name="授信金额")
	private java.math.BigDecimal famt;
	/**分支机构代码*/
	@Excel(name="分支机构代码")
	private java.lang.String brca;
	/**上一级机构代码*/
	@Excel(name="上一级机构代码")
	private java.lang.String parentbrca;
	/**交易分支机构代码*/
	@Excel(name="交易分支机构代码")
	private java.lang.String brcaCo;
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
	 *@return: java.lang.String  票据号码
	 */
	@Column(name ="BILN",nullable=true,length=50)
	public java.lang.String getBiln(){
		return this.biln;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  票据号码
	 */
	public void setBiln(java.lang.String biln){
		this.biln = biln;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出票人名称
	 */
	@Column(name ="PAYEN",nullable=true,length=50)
	public java.lang.String getPayen(){
		return this.payen;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出票人名称
	 */
	public void setPayen(java.lang.String payen){
		this.payen = payen;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出票人账号
	 */
	@Column(name ="DRAC",nullable=true,length=50)
	public java.lang.String getDrac(){
		return this.drac;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出票人账号
	 */
	public void setDrac(java.lang.String drac){
		this.drac = drac;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  付款行全称
	 */
	@Column(name ="PAYB",nullable=true,length=50)
	public java.lang.String getPayb(){
		return this.payb;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  付款行全称
	 */
	public void setPayb(java.lang.String payb){
		this.payb = payb;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出票日期
	 */
	@Column(name ="DAIS",nullable=true)
	public java.util.Date getDais(){
		return this.dais;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  出票日期
	 */
	public void setDais(java.util.Date dais){
		this.dais = dais;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  票面到期日
	 */
	@Column(name ="MATD",nullable=true)
	public java.util.Date getMatd(){
		return this.matd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  票面到期日
	 */
	public void setMatd(java.util.Date matd){
		this.matd = matd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  票据出票人类型
	 */
	@Column(name ="BPTP",nullable=true,length=10)
	public java.lang.String getBptp(){
		return this.bptp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  票据出票人类型
	 */
	public void setBptp(java.lang.String bptp){
		this.bptp = bptp;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  票面金额
	 */
	@Column(name ="FCVU",nullable=true,scale=4,length=20)
	public java.math.BigDecimal getFcvu(){
		return this.fcvu;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  票面金额
	 */
	public void setFcvu(java.math.BigDecimal fcvu){
		this.fcvu = fcvu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="NOTE",nullable=true,length=255)
	public java.lang.String getNote(){
		return this.note;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setNote(java.lang.String note){
		this.note = note;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商业汇票形式
	 */
	@Column(name ="CMDT",nullable=true,length=50)
	public java.lang.String getCmdt(){
		return this.cmdt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商业汇票形式
	 */
	public void setCmdt(java.lang.String cmdt){
		this.cmdt = cmdt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承兑人名称
	 */
	@Column(name ="ACPN",nullable=true,length=255)
	public java.lang.String getAcpn(){
		return this.acpn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承兑人名称
	 */
	public void setAcpn(java.lang.String acpn){
		this.acpn = acpn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承兑人类型
	 */
	@Column(name ="ACPT",nullable=true,length=20)
	public java.lang.String getAcpt(){
		return this.acpt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承兑人类型
	 */
	public void setAcpt(java.lang.String acpt){
		this.acpt = acpt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款人全称
	 */
	@Column(name ="PEFN",nullable=true,length=255)
	public java.lang.String getPefn(){
		return this.pefn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款人全称
	 */
	public void setPefn(java.lang.String pefn){
		this.pefn = pefn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款人账号
	 */
	@Column(name ="PEAC",nullable=true,length=50)
	public java.lang.String getPeac(){
		return this.peac;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款人账号
	 */
	public void setPeac(java.lang.String peac){
		this.peac = peac;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收款人开户行
	 */
	@Column(name ="PEOB",nullable=true,length=50)
	public java.lang.String getPeob(){
		return this.peob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收款人开户行
	 */
	public void setPeob(java.lang.String peob){
		this.peob = peob;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  贴现利率
	 */
	@Column(name ="DICR",nullable=true,scale=4,length=20)
	public java.math.BigDecimal getDicr(){
		return this.dicr;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  贴现利率
	 */
	public void setDicr(java.math.BigDecimal dicr){
		this.dicr = dicr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币种
	 */
	@Column(name ="CCY",nullable=false,length=10)
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
	 *@return: java.lang.String  担保类型
	 */
	@Column(name ="WART",nullable=true,length=20)
	public java.lang.String getWart(){
		return this.wart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  担保类型
	 */
	public void setWart(java.lang.String wart){
		this.wart = wart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款或表外业务合同号
	 */
	@Column(name ="CNLOBS",nullable=true,length=50)
	public java.lang.String getCnlobs(){
		return this.cnlobs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款或表外业务合同号
	 */
	public void setCnlobs(java.lang.String cnlobs){
		this.cnlobs = cnlobs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  担保合同号
	 */
	@Column(name ="GRTC",nullable=true,length=50)
	public java.lang.String getGrtc(){
		return this.grtc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  担保合同号
	 */
	public void setGrtc(java.lang.String grtc){
		this.grtc = grtc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  授信编号
	 */
	@Column(name ="LINE_CODE",nullable=true,length=50)
	public java.lang.String getLineCode(){
		return this.lineCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  授信编号
	 */
	public void setLineCode(java.lang.String lineCode){
		this.lineCode = lineCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  授信类型
	 */
	@Column(name ="FACT",nullable=true,length=10)
	public java.lang.String getFact(){
		return this.fact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  授信类型
	 */
	public void setFact(java.lang.String fact){
		this.fact = fact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  授信币种
	 */
	@Column(name ="FCCY",nullable=true,length=10)
	public java.lang.String getFccy(){
		return this.fccy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  授信币种
	 */
	public void setFccy(java.lang.String fccy){
		this.fccy = fccy;
	}
	/**
	 *方法: 取得java.math.BigDecimal
	 *@return: java.math.BigDecimal  授信金额
	 */
	@Column(name ="FAMT",nullable=true,scale=4,length=20)
	public java.math.BigDecimal getFamt(){
		return this.famt;
	}

	/**
	 *方法: 设置java.math.BigDecimal
	 *@param: java.math.BigDecimal  授信金额
	 */
	public void setFamt(java.math.BigDecimal famt){
		this.famt = famt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上一级机构代码
	 */
	@Column(name ="PARENTBRCA",nullable=false,length=10)
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
	 *@return: java.lang.String  开户分支机构代码
	 */
	@Column(name ="BRCA",nullable=false,length=10)
	public java.lang.String getBrca(){
		return this.brca;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户分支机构代码
	 */
	public void setBrca(java.lang.String brca){
		this.brca = brca;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交易分支机构代码
	 */
	@Column(name ="BRCA_CO",nullable=false,length=10)
	public java.lang.String getBrcaCo(){
		return this.brcaCo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易分支机构代码
	 */
	public void setBrcaCo(java.lang.String brcaCo){
		this.brcaCo = brcaCo;
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
