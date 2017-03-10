package com.lzsoft.aml.entity.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: 存款信息表
 * @author zhangdaihao
 * @date 2016-04-12 16:25:59
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_deposit", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class DepositEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**交易序号(核心账号)*/
	private java.lang.String dlno;
	/**客户号*/
	private java.lang.String csnm;
	/**币种*/
	private java.lang.String ccy;
	/**利率是否固定*/
	private java.lang.String rftp;
	/**存款合同期限*/
	private java.lang.String dctc;
	/**存款剩余期限*/
	private java.lang.String dttc;
	/**产品类别Category*/
	private java.lang.String dtyp;
	/**产品类别Mapping编号(自加)*/
	private java.lang.String productcode;
	/**存款利率重新定价期限*/
	private java.lang.String drrt;
	/**计息期限*/
	private java.lang.String bearPrd;
	/**计息方式*/
	private java.lang.String insBearMtd;
	/**结息方式*/
	private java.lang.String insStmt;
	/**组织机构代码*/
	private java.lang.String orgc;
	/**申报账号*/
	private java.lang.String bpacod;
	/**通知存款提前通知天数*/
	private java.lang.String acdd;
	/**定存起始日期*/
	private java.util.Date depoAgrStdt;
	/**定存到期日期*/
	private java.util.Date depoAgrEddt;
	/**到期天数（定存到期日期-营业日期自加）*/
	private java.lang.Integer matreportday;
	/**到期月数（定存到期日期-营业日期自加）*/
	private java.lang.Integer matreportmonth;
	/**到期天数（定存起始日期-定存到期日期自加）*/
	private java.lang.Integer stdteddtday;
	/**到期月数（定存起始日期-定存到期日期自加）*/
	private java.lang.Integer stdteddtmonth;
	/**存款余额*/
	private BigDecimal workingbalance;
	/**存款余额折人民币(自加)*/
	private BigDecimal workingbalancecny;
	/**存款余额折美金(自加)*/
	private BigDecimal workingbalanceusd;
	/**存款利率重新定价日*/
	private java.util.Date drtd;
	/**执行利率*/
	private BigDecimal strikeRate;
	/**是否有单*/
	private java.lang.String certDepo;
	/**存单类型*/
	private java.lang.String certDepoType;
	/**存单号*/
	private java.lang.String certDepoNo;
	/**转存标志*/
	private java.lang.String rollMk;
	/**续存方式*/
	private java.lang.String renewMet;
	/**转存后到期日*/
	private java.util.Date autoRenewdt;
	/**下个到期天数（转存后到期日-营业日期自加）*/
	private java.lang.Integer nmatreportday;
	/**下个到期月数（转存后到期日-营业日期自加）*/
	private java.lang.Integer nmatreportmonth;
	/**分支机构代码*/
	private java.lang.String brca;
	/**上一级机构代码*/
	private java.lang.String parentbrca;
	/**交易经办行*/
	private java.lang.String brcaCo;
	/**交易日期*/
	private java.util.Date ddat;
	/**本金*/
	private BigDecimal pcpl;
	/**本金折人民币(自加)*/
	private BigDecimal pcplcny;
	/**本金折美金(自加)*/
	private BigDecimal pcplusd;
	/**下次付息日*/
	private java.util.Date nidt;
	/**下次付息到期天数（下次付息日-营业日期自加）*/
	private java.lang.Integer nidtreportday;
	/**下次付息到期月数（下次付息日-营业日期自加）*/
	private java.lang.Integer nidtreportmonth;
	/**上次付息日到当前应付利息*/
	private BigDecimal aipd;
	/**上次付息日到当前应付利息折人民币(自加)*/
	private BigDecimal aipdcny;
	/**上次付息日到当前应付利息折美金(自加)*/
	private BigDecimal aipdusd;
	/**利息税率*/
	private BigDecimal taxrate;
	/**最低支取金额*/
	private BigDecimal minPay;
	/**系统日期*/
	private java.util.Date sysDate;
	/**营业日期*/
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
	 *@return: java.lang.String  交易序号(核心账号)
	 */
	@Column(name ="DLNO",nullable=true,length=50)
	public java.lang.String getDlno(){
		return this.dlno;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易序号(核心账号)
	 */
	public void setDlno(java.lang.String dlno){
		this.dlno = dlno;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  客户号
	 */
	@Column(name ="CSNM",nullable=false,length=20)
	public java.lang.String getCsnm(){
		return this.csnm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户号
	 */
	public void setCsnm(java.lang.String csnm){
		this.csnm = csnm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  币种
	 */
	@Column(name ="CCY",nullable=false,length=50)
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
	 *@return: java.lang.String  利率是否固定
	 */
	@Column(name ="RFTP",nullable=true,length=10)
	public java.lang.String getRftp(){
		return this.rftp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  利率是否固定
	 */
	public void setRftp(java.lang.String rftp){
		this.rftp = rftp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存款合同期限
	 */
	@Column(name ="DCTC",nullable=true,length=50)
	public java.lang.String getDctc(){
		return this.dctc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存款合同期限
	 */
	public void setDctc(java.lang.String dctc){
		this.dctc = dctc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存款剩余期限
	 */
	@Column(name ="DTTC",nullable=true,length=50)
	public java.lang.String getDttc(){
		return this.dttc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存款剩余期限
	 */
	public void setDttc(java.lang.String dttc){
		this.dttc = dttc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品类别Category
	 */
	@Column(name ="DTYP",nullable=true,length=50)
	public java.lang.String getDtyp(){
		return this.dtyp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品类别Category
	 */
	public void setDtyp(java.lang.String dtyp){
		this.dtyp = dtyp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品类别Mapping编号(自加)
	 */
	@Column(name ="PRODUCTCODE",nullable=true,length=50)
	public java.lang.String getProductcode(){
		return this.productcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品类别Mapping编号(自加)
	 */
	public void setProductcode(java.lang.String productcode){
		this.productcode = productcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存款利率重新定价期限
	 */
	@Column(name ="DRRT",nullable=true,length=50)
	public java.lang.String getDrrt(){
		return this.drrt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存款利率重新定价期限
	 */
	public void setDrrt(java.lang.String drrt){
		this.drrt = drrt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计息期限
	 */
	@Column(name ="BEAR_PRD",nullable=true,length=20)
	public java.lang.String getBearPrd(){
		return this.bearPrd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计息期限
	 */
	public void setBearPrd(java.lang.String bearPrd){
		this.bearPrd = bearPrd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  计息方式
	 */
	@Column(name ="INS_BEAR_MTD",nullable=true,length=20)
	public java.lang.String getInsBearMtd(){
		return this.insBearMtd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  计息方式
	 */
	public void setInsBearMtd(java.lang.String insBearMtd){
		this.insBearMtd = insBearMtd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结息方式
	 */
	@Column(name ="INS_STMT",nullable=true,length=20)
	public java.lang.String getInsStmt(){
		return this.insStmt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结息方式
	 */
	public void setInsStmt(java.lang.String insStmt){
		this.insStmt = insStmt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  组织机构代码
	 */
	@Column(name ="ORGC",nullable=true,length=50)
	public java.lang.String getOrgc(){
		return this.orgc;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  组织机构代码
	 */
	public void setOrgc(java.lang.String orgc){
		this.orgc = orgc;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申报账号
	 */
	@Column(name ="BPACOD",nullable=true,length=50)
	public java.lang.String getBpacod(){
		return this.bpacod;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申报账号
	 */
	public void setBpacod(java.lang.String bpacod){
		this.bpacod = bpacod;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通知存款提前通知天数
	 */
	@Column(name ="ACDD",nullable=true,length=10)
	public java.lang.String getAcdd(){
		return this.acdd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通知存款提前通知天数
	 */
	public void setAcdd(java.lang.String acdd){
		this.acdd = acdd;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  定存起始日期
	 */
	@Column(name ="DEPO_AGR_STDT",nullable=true)
	public java.util.Date getDepoAgrStdt(){
		return this.depoAgrStdt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  定存起始日期
	 */
	public void setDepoAgrStdt(java.util.Date depoAgrStdt){
		this.depoAgrStdt = depoAgrStdt;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  定存到期日期
	 */
	@Column(name ="DEPO_AGR_EDDT",nullable=true)
	public java.util.Date getDepoAgrEddt(){
		return this.depoAgrEddt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  定存到期日期
	 */
	public void setDepoAgrEddt(java.util.Date depoAgrEddt){
		this.depoAgrEddt = depoAgrEddt;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期天数（定存到期日期-营业日期自加）
	 */
	@Column(name ="MATREPORTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMatreportday(){
		return this.matreportday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期天数（定存到期日期-营业日期自加）
	 */
	public void setMatreportday(java.lang.Integer matreportday){
		this.matreportday = matreportday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期月数（定存到期日期-营业日期自加）
	 */
	@Column(name ="MATREPORTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMatreportmonth(){
		return this.matreportmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期月数（定存到期日期-营业日期自加）
	 */
	public void setMatreportmonth(java.lang.Integer matreportmonth){
		this.matreportmonth = matreportmonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期天数（定存起始日期-定存到期日期自加）
	 */
	@Column(name ="STDTEDDTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getStdteddtday(){
		return this.stdteddtday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期天数（定存起始日期-定存到期日期自加）
	 */
	public void setStdteddtday(java.lang.Integer stdteddtday){
		this.stdteddtday = stdteddtday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期月数（定存起始日期-定存到期日期自加）
	 */
	@Column(name ="STDTEDDTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getStdteddtmonth(){
		return this.stdteddtmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期月数（定存起始日期-定存到期日期自加）
	 */
	public void setStdteddtmonth(java.lang.Integer stdteddtmonth){
		this.stdteddtmonth = stdteddtmonth;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  存款余额
	 */
	@Column(name ="WORKINGBALANCE",nullable=true,precision=20,scale=4)
	public BigDecimal getWorkingbalance(){
		return this.workingbalance;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  存款余额
	 */
	public void setWorkingbalance(BigDecimal workingbalance){
		this.workingbalance = workingbalance;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  存款余额折人民币(自加)
	 */
	@Column(name ="WORKINGBALANCECNY",nullable=true,precision=20,scale=4)
	public BigDecimal getWorkingbalancecny(){
		return this.workingbalancecny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  存款余额折人民币(自加)
	 */
	public void setWorkingbalancecny(BigDecimal workingbalancecny){
		this.workingbalancecny = workingbalancecny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  存款余额折美金(自加)
	 */
	@Column(name ="WORKINGBALANCEUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getWorkingbalanceusd(){
		return this.workingbalanceusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  存款余额折美金(自加)
	 */
	public void setWorkingbalanceusd(BigDecimal workingbalanceusd){
		this.workingbalanceusd = workingbalanceusd;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  存款利率重新定价日
	 */
	@Column(name ="DRTD",nullable=true)
	public java.util.Date getDrtd(){
		return this.drtd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  存款利率重新定价日
	 */
	public void setDrtd(java.util.Date drtd){
		this.drtd = drtd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  执行利率
	 */
	@Column(name ="STRIKE_RATE",nullable=true,precision=20,scale=8)
	public BigDecimal getStrikeRate(){
		return this.strikeRate;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  执行利率
	 */
	public void setStrikeRate(BigDecimal strikeRate){
		this.strikeRate = strikeRate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否有单
	 */
	@Column(name ="CERT_DEPO",nullable=true,length=50)
	public java.lang.String getCertDepo(){
		return this.certDepo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否有单
	 */
	public void setCertDepo(java.lang.String certDepo){
		this.certDepo = certDepo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存单类型
	 */
	@Column(name ="CERT_DEPO_TYPE",nullable=true,length=50)
	public java.lang.String getCertDepoType(){
		return this.certDepoType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存单类型
	 */
	public void setCertDepoType(java.lang.String certDepoType){
		this.certDepoType = certDepoType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  存单号
	 */
	@Column(name ="CERT_DEPO_NO",nullable=true,length=50)
	public java.lang.String getCertDepoNo(){
		return this.certDepoNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  存单号
	 */
	public void setCertDepoNo(java.lang.String certDepoNo){
		this.certDepoNo = certDepoNo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  转存标志
	 */
	@Column(name ="ROLL_MK",nullable=true,length=50)
	public java.lang.String getRollMk(){
		return this.rollMk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  转存标志
	 */
	public void setRollMk(java.lang.String rollMk){
		this.rollMk = rollMk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  续存方式
	 */
	@Column(name ="RENEW_MET",nullable=true,length=50)
	public java.lang.String getRenewMet(){
		return this.renewMet;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  续存方式
	 */
	public void setRenewMet(java.lang.String renewMet){
		this.renewMet = renewMet;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  转存后到期日
	 */
	@Column(name ="AUTO_RENEWDT",nullable=true)
	public java.util.Date getAutoRenewdt(){
		return this.autoRenewdt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  转存后到期日
	 */
	public void setAutoRenewdt(java.util.Date autoRenewdt){
		this.autoRenewdt = autoRenewdt;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  下个到期天数（转存后到期日-营业日期自加）
	 */
	@Column(name ="NMATREPORTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNmatreportday(){
		return this.nmatreportday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下个到期天数（转存后到期日-营业日期自加）
	 */
	public void setNmatreportday(java.lang.Integer nmatreportday){
		this.nmatreportday = nmatreportday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  下个到期月数（转存后到期日-营业日期自加）
	 */
	@Column(name ="NMATREPORTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNmatreportmonth(){
		return this.nmatreportmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下个到期月数（转存后到期日-营业日期自加）
	 */
	public void setNmatreportmonth(java.lang.Integer nmatreportmonth){
		this.nmatreportmonth = nmatreportmonth;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上一级机构代码
	 */
	@Column(name ="PARENTBRCA",nullable=false,length=50)
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
	 *@return: java.lang.String  交易经办行
	 */
	@Column(name ="BRCA_CO",nullable=false,length=50)
	public java.lang.String getBrcaCo(){
		return this.brcaCo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易经办行
	 */
	public void setBrcaCo(java.lang.String brcaCo){
		this.brcaCo = brcaCo;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  交易日期
	 */
	@Column(name ="DDAT",nullable=true)
	public java.util.Date getDdat(){
		return this.ddat;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  交易日期
	 */
	public void setDdat(java.util.Date ddat){
		this.ddat = ddat;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  本金
	 */
	@Column(name ="PCPL",nullable=true,precision=20,scale=4)
	public BigDecimal getPcpl(){
		return this.pcpl;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  本金
	 */
	public void setPcpl(BigDecimal pcpl){
		this.pcpl = pcpl;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  本金折人民币(自加)
	 */
	@Column(name ="PCPLCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getPcplcny(){
		return this.pcplcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  本金折人民币(自加)
	 */
	public void setPcplcny(BigDecimal pcplcny){
		this.pcplcny = pcplcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  本金折美金(自加)
	 */
	@Column(name ="PCPLUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getPcplusd(){
		return this.pcplusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  本金折美金(自加)
	 */
	public void setPcplusd(BigDecimal pcplusd){
		this.pcplusd = pcplusd;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下次付息日
	 */
	@Column(name ="NIDT",nullable=true)
	public java.util.Date getNidt(){
		return this.nidt;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下次付息日
	 */
	public void setNidt(java.util.Date nidt){
		this.nidt = nidt;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  下次付息到期天数（下次付息日-营业日期自加）
	 */
	@Column(name ="NIDTREPORTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNidtreportday(){
		return this.nidtreportday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下次付息到期天数（下次付息日-营业日期自加）
	 */
	public void setNidtreportday(java.lang.Integer nidtreportday){
		this.nidtreportday = nidtreportday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  下次付息到期月数（下次付息日-营业日期自加）
	 */
	@Column(name ="NIDTREPORTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNidtreportmonth(){
		return this.nidtreportmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下次付息到期月数（下次付息日-营业日期自加）
	 */
	public void setNidtreportmonth(java.lang.Integer nidtreportmonth){
		this.nidtreportmonth = nidtreportmonth;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  上次付息日到当前应付利息
	 */
	@Column(name ="AIPD",nullable=true,precision=20,scale=4)
	public BigDecimal getAipd(){
		return this.aipd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  上次付息日到当前应付利息
	 */
	public void setAipd(BigDecimal aipd){
		this.aipd = aipd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  上次付息日到当前应付利息折人民币(自加)
	 */
	@Column(name ="AIPDCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getAipdcny(){
		return this.aipdcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  上次付息日到当前应付利息折人民币(自加)
	 */
	public void setAipdcny(BigDecimal aipdcny){
		this.aipdcny = aipdcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  上次付息日到当前应付利息折美金(自加)
	 */
	@Column(name ="AIPDUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getAipdusd(){
		return this.aipdusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  上次付息日到当前应付利息折美金(自加)
	 */
	public void setAipdusd(BigDecimal aipdusd){
		this.aipdusd = aipdusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  利息税率
	 */
	@Column(name ="TAXRATE",nullable=true,precision=20,scale=4)
	public BigDecimal getTaxrate(){
		return this.taxrate;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  利息税率
	 */
	public void setTaxrate(BigDecimal taxrate){
		this.taxrate = taxrate;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  最低支取金额
	 */
	@Column(name ="MIN_PAY",nullable=true,precision=20,scale=4)
	public BigDecimal getMinPay(){
		return this.minPay;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  最低支取金额
	 */
	public void setMinPay(BigDecimal minPay){
		this.minPay = minPay;
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
