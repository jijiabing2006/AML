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
 * @Description: 贷款业务表
 * @author zhangdaihao
 * @date 2016-08-23 14:26:24
 * @version V1.0   
 *
 */
@Entity
@Table(name = "t_loan", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class LoanEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**客户代码*/
	private java.lang.String csnm;
	/**客户名称*/
	private java.lang.String ctnm;
	/**交易序号*/
	private java.lang.String tradeId;
	/**分支机构代码*/
	private java.lang.String brca;
	/**上一级机构代码*/
	private java.lang.String parentbrca;
	/**交易分支机构代码*/
	private java.lang.String brcaCo;
	/**产品类别*/
	private java.lang.String dtyp;
	/**贷款合同编号*/
	private java.lang.String lnrf;
	/**个人证件类型*/
	private java.lang.String cidt;
	/**个人证件号码*/
	private java.lang.String cidn;
	/**行业*/
	private java.lang.String cuin;
	/**地区*/
	private java.lang.String city;
	/**企业规模*/
	private java.lang.String custsize;
	/**贷款合同号*/
	private java.lang.String lano;
	/**资产负债类型*/
	private java.lang.String alTp;
	/**贷款产品类别*/
	private java.lang.String loantype;
	/**贷款经营类型*/
	private java.lang.String loanbustype;
	/**贷款实际境内外投向*/
	private java.lang.String useLoan;
	/**贷款合同期限*/
	private java.lang.String loanPrd;
	/**个人经营贷款用途*/
	private java.lang.String useOprloan;
	/**授信编号*/
	private java.lang.String lineCode;
	/**授信类型*/
	private java.lang.String fact;
	/**授信币种*/
	private java.lang.String fccy;
	/**授信金额*/
	private BigDecimal famt;
	/**利率区间*/
	private BigDecimal realIntrateCode;
	/**贷款发放日期*/
	private java.util.Date dealdate;
	/**贷款一开始放款设定到期日期*/
	private java.util.Date matdate;
	/**贷款实际终止日期*/
	private java.util.Date actEndLoan;
	/**展期贷款标识*/
	private java.lang.String loanExt;
	/**贷款展期起始日期*/
	private java.util.Date stdtLoanext;
	/**贷款展期到期日期*/
	private java.util.Date endtLoanext;
	/**贷款币种*/
	private java.lang.String ccy;
	/**贷款借据金额*/
	private BigDecimal notesellAm;
	/**贷款借据金额折人民币(自加)*/
	private BigDecimal notesellAmcny;
	/**贷款借据金额折美金(自加)*/
	private BigDecimal notesellAmusd;
	/**贷款借据余额*/
	private BigDecimal notesellBl;
	/**贷款借据余额折人民币(自加)*/
	private BigDecimal notesellBlcny;
	/**贷款借据余额折美金(自加)*/
	private BigDecimal notesellBlusd;
	/**利率是否固定*/
	private java.lang.String rftp;
	/**利率期限单位*/
	private java.lang.String tmInsrate;
	/**利率水平*/
	private java.lang.String lvlInsrate;
	/**贷款利率重新定价期限*/
	private java.lang.String reprLoanInsrate;
	/**贷款利率重新定价日*/
	private java.util.Date dateInsRepr;
	/**贷款担保方式*/
	private java.lang.String loanGarMtd;
	/**贷款逾期天数*/
	private java.lang.String ovdueLoan;
	/**贷款逾期期限*/
	private java.lang.String ovdueLoanPrd;
	/**贷款风险分类*/
	private java.lang.String loanRisk;
	/**贷款质量*/
	private java.lang.String loangrade;
	/**贷款状态*/
	private java.lang.String loanStat;
	/**年初贷款质量状态*/
	private java.lang.String begLoanQul;
	/**重组日期*/
	private java.util.Date restrDate;
	/**重组贷款标识*/
	private java.lang.String restrLoan;
	/**重组贷款类型*/
	private java.lang.String tpRestrLoan;
	/**是否地方政府融资平台贷款*/
	private java.lang.String govPltfLoan;
	/**支付方式*/
	private java.lang.String payTerm;
	/**下次付息日*/
	private java.util.Date nxPay;
	/**上次付息日到当前应收利息*/
	private BigDecimal curInsRecv;
	/**上次付息日到当前应收利息折人民币（自加）*/
	private BigDecimal curInsRecvcny;
	/**上次付息日到当前应收利息折美金（自加）*/
	private BigDecimal curInsRecvusd;
	/**基准利率*/
	private BigDecimal basicRate;
	/**实际利率*/
	private BigDecimal realIntrate;
	/**贷款承诺是否可撤销*/
	private java.lang.String revCdtCom;
	/**借新还旧*/
	private java.lang.String refn;
	/**最长逾期天数*/
	private java.lang.String ovdueDay;
	/**还款日期（下一次最近还款日期）*/
	private java.util.Date blingDate;
	/**还本帐户帐号*/
	private java.lang.String acRepayPrin;
	/**还息帐户帐号*/
	private java.lang.String acRepayIns;
	/**贷款还款方式*/
	private java.lang.String loanPat;
	/**逾期本金罚息*/
	private BigDecimal oveDefpIns;
	/**逾期利息罚息*/
	private BigDecimal oveDefiIns;
	/**重组前贷款编号*/
	private java.lang.String orloanId;
	/**贷款减值准备_一般准备金额*/
	private BigDecimal generalPro;
	/**贷款减值准备_一般准备金额折人民币（自加）*/
	private BigDecimal generalProcny;
	/**贷款减值准备_一般准备金额折美金（自加）*/
	private BigDecimal generalProusd;
	/**贷款减值准备_专项准备金额*/
	private BigDecimal specialPro;
	/**贷款减值准备_专项准备金额折人民币（自加）*/
	private BigDecimal specialProcny;
	/**贷款减值准备_专项准备金额折美金（自加）*/
	private BigDecimal specialProusd;
	/**贷款减值准备_特种准备金额*/
	private BigDecimal specificPro;
	/**贷款减值准备_特种准备金额折人民币（自加）*/
	private BigDecimal specificProcny;
	/**贷款减值准备_特种准备金额折美金（自加）*/
	private BigDecimal specificProusd;
	/**贷款的初始金额*/
	private BigDecimal issuePrice;
	/**支付账号*/
	private java.lang.String drawdownAccount;
	/**放款编号*/
	private java.lang.String sellNum;
	/**逾期本金*/
	private BigDecimal oveDefp;
	/**逾期本金折人民币（自加）*/
	private BigDecimal oveDefpcny;
	/**逾期本金折美金（自加）*/
	private BigDecimal oveDefpusd;
	/**逾期利息*/
	private BigDecimal oveDefi;
	/**逾期利息折人民币（自加）*/
	private BigDecimal oveDeficny;
	/**逾期利息折美金（自加）*/
	private BigDecimal oveDefiusd;
	/**贷款用途*/
	private java.lang.String loanPurpose;
	/**票据号码*/
	private java.lang.String biln;
	/**最高层额度编号*/
	private java.lang.String creditLine;
	/**预收利息余额*/
	private BigDecimal unearnIns;
	/**预收费用余额*/
	private BigDecimal unearnFee;
	/**借据编号*/
	private java.lang.String loanNo;
	/**贷款合同生效日期*/
	private java.util.Date startDate;
	/**贷款合同终止日期*/
	private java.util.Date expiryDate;
	/**合同有效状态*/
	private java.lang.String availalbe;
	/**系统日期*/
	private java.util.Date sysDate;
	/**营业日期*/
	private java.util.Date importdate;
	/**到期日-报表日（相差天数）*/
	private java.lang.Integer matreportday;
	/**到期日-报表日（相差月数）*/
	private java.lang.Integer matreportmonth;
	/**下次付息日-报表日（相差天数）*/
	private java.lang.Integer nxreportday;
	/**下次付息日-报表日（相差月数）*/
	private java.lang.Integer nxreportmonth;
	/**实际到期日-报表日（相差天数）*/
	private java.lang.Integer actreportday;
	/**实际到期日-报表日（相差月数）*/
	private java.lang.Integer actreportmonth;
	/**到期日-发放日（相差天数）*/
	private java.lang.Integer matdealday;
	/**到期日-发放日（相差月数）*/
	private java.lang.Integer matdealmonth;
	
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
	 *@return: java.lang.String  客户代码
	 */
	@Column(name ="CSNM",nullable=true,length=20)
	public java.lang.String getCsnm(){
		return this.csnm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  客户代码
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
	 *@return: java.lang.String  交易序号
	 */
	@Column(name ="TRADE_ID",nullable=true,length=50)
	public java.lang.String getTradeId(){
		return this.tradeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易序号
	 */
	public void setTradeId(java.lang.String tradeId){
		this.tradeId = tradeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分支机构代码
	 */
	@Column(name ="BRCA",nullable=true,length=10)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品类别
	 */
	@Column(name ="DTYP",nullable=true,length=50)
	public java.lang.String getDtyp(){
		return this.dtyp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品类别
	 */
	public void setDtyp(java.lang.String dtyp){
		this.dtyp = dtyp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款合同编号
	 */
	@Column(name ="LNRF",nullable=true,length=100)
	public java.lang.String getLnrf(){
		return this.lnrf;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款合同编号
	 */
	public void setLnrf(java.lang.String lnrf){
		this.lnrf = lnrf;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人证件类型
	 */
	@Column(name ="CIDT",nullable=true,length=10)
	public java.lang.String getCidt(){
		return this.cidt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人证件类型
	 */
	public void setCidt(java.lang.String cidt){
		this.cidt = cidt;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人证件号码
	 */
	@Column(name ="CIDN",nullable=true,length=50)
	public java.lang.String getCidn(){
		return this.cidn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人证件号码
	 */
	public void setCidn(java.lang.String cidn){
		this.cidn = cidn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行业
	 */
	@Column(name ="CUIN",nullable=true,length=10)
	public java.lang.String getCuin(){
		return this.cuin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行业
	 */
	public void setCuin(java.lang.String cuin){
		this.cuin = cuin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地区
	 */
	@Column(name ="CITY",nullable=true,length=10)
	public java.lang.String getCity(){
		return this.city;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地区
	 */
	public void setCity(java.lang.String city){
		this.city = city;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业规模
	 */
	@Column(name ="CUSTSIZE",nullable=true,length=10)
	public java.lang.String getCustsize(){
		return this.custsize;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业规模
	 */
	public void setCustsize(java.lang.String custsize){
		this.custsize = custsize;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款合同号
	 */
	@Column(name ="LANO",nullable=true,length=50)
	public java.lang.String getLano(){
		return this.lano;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款合同号
	 */
	public void setLano(java.lang.String lano){
		this.lano = lano;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资产负债类型
	 */
	@Column(name ="AL_TP",nullable=true,length=20)
	public java.lang.String getAlTp(){
		return this.alTp;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资产负债类型
	 */
	public void setAlTp(java.lang.String alTp){
		this.alTp = alTp;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款产品类别
	 */
	@Column(name ="LOANTYPE",nullable=true,length=10)
	public java.lang.String getLoantype(){
		return this.loantype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款产品类别
	 */
	public void setLoantype(java.lang.String loantype){
		this.loantype = loantype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款经营类型
	 */
	@Column(name ="LOANBUSTYPE",nullable=true,length=20)
	public java.lang.String getLoanbustype(){
		return this.loanbustype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款经营类型
	 */
	public void setLoanbustype(java.lang.String loanbustype){
		this.loanbustype = loanbustype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款实际境内外投向
	 */
	@Column(name ="USE_LOAN",nullable=true,length=10)
	public java.lang.String getUseLoan(){
		return this.useLoan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款实际境内外投向
	 */
	public void setUseLoan(java.lang.String useLoan){
		this.useLoan = useLoan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款合同期限
	 */
	@Column(name ="LOAN_PRD",nullable=true,length=50)
	public java.lang.String getLoanPrd(){
		return this.loanPrd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款合同期限
	 */
	public void setLoanPrd(java.lang.String loanPrd){
		this.loanPrd = loanPrd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人经营贷款用途
	 */
	@Column(name ="USE_OPRLOAN",nullable=true,length=255)
	public java.lang.String getUseOprloan(){
		return this.useOprloan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人经营贷款用途
	 */
	public void setUseOprloan(java.lang.String useOprloan){
		this.useOprloan = useOprloan;
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
	@Column(name ="FACT",nullable=true,length=20)
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
	@Column(name ="FCCY",nullable=true,length=3)
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
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  授信金额
	 */
	@Column(name ="FAMT",nullable=true,precision=20,scale=4)
	public BigDecimal getFamt(){
		return this.famt;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  授信金额
	 */
	public void setFamt(BigDecimal famt){
		this.famt = famt;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  利率区间
	 */
	@Column(name ="REAL_INTRATE_CODE",nullable=true,precision=20,scale=8)
	public BigDecimal getRealIntrateCode(){
		return this.realIntrateCode;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  利率区间
	 */
	public void setRealIntrateCode(BigDecimal realIntrateCode){
		this.realIntrateCode = realIntrateCode;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款发放日期
	 */
	@Column(name ="DEALDATE",nullable=true)
	public java.util.Date getDealdate(){
		return this.dealdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款发放日期
	 */
	public void setDealdate(java.util.Date dealdate){
		this.dealdate = dealdate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款一开始放款设定到期日期
	 */
	@Column(name ="MATDATE",nullable=true)
	public java.util.Date getMatdate(){
		return this.matdate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款一开始放款设定到期日期
	 */
	public void setMatdate(java.util.Date matdate){
		this.matdate = matdate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款实际终止日期
	 */
	@Column(name ="ACT_END_LOAN",nullable=true)
	public java.util.Date getActEndLoan(){
		return this.actEndLoan;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款实际终止日期
	 */
	public void setActEndLoan(java.util.Date actEndLoan){
		this.actEndLoan = actEndLoan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  展期贷款标识
	 */
	@Column(name ="LOAN_EXT",nullable=true,length=50)
	public java.lang.String getLoanExt(){
		return this.loanExt;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  展期贷款标识
	 */
	public void setLoanExt(java.lang.String loanExt){
		this.loanExt = loanExt;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款展期起始日期
	 */
	@Column(name ="STDT_LOANEXT",nullable=true)
	public java.util.Date getStdtLoanext(){
		return this.stdtLoanext;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款展期起始日期
	 */
	public void setStdtLoanext(java.util.Date stdtLoanext){
		this.stdtLoanext = stdtLoanext;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款展期到期日期
	 */
	@Column(name ="ENDT_LOANEXT",nullable=true)
	public java.util.Date getEndtLoanext(){
		return this.endtLoanext;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款展期到期日期
	 */
	public void setEndtLoanext(java.util.Date endtLoanext){
		this.endtLoanext = endtLoanext;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款币种
	 */
	@Column(name ="CCY",nullable=true,length=3)
	public java.lang.String getCcy(){
		return this.ccy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款币种
	 */
	public void setCcy(java.lang.String ccy){
		this.ccy = ccy;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款借据金额
	 */
	@Column(name ="NOTESELL_AM",nullable=true,precision=20,scale=4)
	public BigDecimal getNotesellAm(){
		return this.notesellAm;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款借据金额
	 */
	public void setNotesellAm(BigDecimal notesellAm){
		this.notesellAm = notesellAm;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款借据金额折人民币(自加)
	 */
	@Column(name ="NOTESELL_AMCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getNotesellAmcny(){
		return this.notesellAmcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款借据金额折人民币(自加)
	 */
	public void setNotesellAmcny(BigDecimal notesellAmcny){
		this.notesellAmcny = notesellAmcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款借据金额折美金(自加)
	 */
	@Column(name ="NOTESELL_AMUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getNotesellAmusd(){
		return this.notesellAmusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款借据金额折美金(自加)
	 */
	public void setNotesellAmusd(BigDecimal notesellAmusd){
		this.notesellAmusd = notesellAmusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款借据余额
	 */
	@Column(name ="NOTESELL_BL",nullable=true,precision=20,scale=4)
	public BigDecimal getNotesellBl(){
		return this.notesellBl;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款借据余额
	 */
	public void setNotesellBl(BigDecimal notesellBl){
		this.notesellBl = notesellBl;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款借据余额折人民币(自加)
	 */
	@Column(name ="NOTESELL_BLCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getNotesellBlcny(){
		return this.notesellBlcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款借据余额折人民币(自加)
	 */
	public void setNotesellBlcny(BigDecimal notesellBlcny){
		this.notesellBlcny = notesellBlcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款借据余额折美金(自加)
	 */
	@Column(name ="NOTESELL_BLUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getNotesellBlusd(){
		return this.notesellBlusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款借据余额折美金(自加)
	 */
	public void setNotesellBlusd(BigDecimal notesellBlusd){
		this.notesellBlusd = notesellBlusd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  利率是否固定
	 */
	@Column(name ="RFTP",nullable=true,length=50)
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
	 *@return: java.lang.String  利率期限单位
	 */
	@Column(name ="TM_INSRATE",nullable=true,length=50)
	public java.lang.String getTmInsrate(){
		return this.tmInsrate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  利率期限单位
	 */
	public void setTmInsrate(java.lang.String tmInsrate){
		this.tmInsrate = tmInsrate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  利率水平
	 */
	@Column(name ="LVL_INSRATE",nullable=true,length=50)
	public java.lang.String getLvlInsrate(){
		return this.lvlInsrate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  利率水平
	 */
	public void setLvlInsrate(java.lang.String lvlInsrate){
		this.lvlInsrate = lvlInsrate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款利率重新定价期限
	 */
	@Column(name ="REPR_LOAN_INSRATE",nullable=true,length=50)
	public java.lang.String getReprLoanInsrate(){
		return this.reprLoanInsrate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款利率重新定价期限
	 */
	public void setReprLoanInsrate(java.lang.String reprLoanInsrate){
		this.reprLoanInsrate = reprLoanInsrate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款利率重新定价日
	 */
	@Column(name ="DATE_INS_REPR",nullable=true)
	public java.util.Date getDateInsRepr(){
		return this.dateInsRepr;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款利率重新定价日
	 */
	public void setDateInsRepr(java.util.Date dateInsRepr){
		this.dateInsRepr = dateInsRepr;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款担保方式
	 */
	@Column(name ="LOAN_GAR_MTD",nullable=true,length=50)
	public java.lang.String getLoanGarMtd(){
		return this.loanGarMtd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款担保方式
	 */
	public void setLoanGarMtd(java.lang.String loanGarMtd){
		this.loanGarMtd = loanGarMtd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款逾期天数
	 */
	@Column(name ="OVDUE_LOAN",nullable=true,length=50)
	public java.lang.String getOvdueLoan(){
		return this.ovdueLoan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款逾期天数
	 */
	public void setOvdueLoan(java.lang.String ovdueLoan){
		this.ovdueLoan = ovdueLoan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款逾期期限
	 */
	@Column(name ="OVDUE_LOAN_PRD",nullable=true,length=50)
	public java.lang.String getOvdueLoanPrd(){
		return this.ovdueLoanPrd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款逾期期限
	 */
	public void setOvdueLoanPrd(java.lang.String ovdueLoanPrd){
		this.ovdueLoanPrd = ovdueLoanPrd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款风险分类
	 */
	@Column(name ="LOAN_RISK",nullable=true,length=50)
	public java.lang.String getLoanRisk(){
		return this.loanRisk;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款风险分类
	 */
	public void setLoanRisk(java.lang.String loanRisk){
		this.loanRisk = loanRisk;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款质量
	 */
	@Column(name ="LOANGRADE",nullable=true,length=50)
	public java.lang.String getLoangrade(){
		return this.loangrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款质量
	 */
	public void setLoangrade(java.lang.String loangrade){
		this.loangrade = loangrade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款状态
	 */
	@Column(name ="LOAN_STAT",nullable=true,length=50)
	public java.lang.String getLoanStat(){
		return this.loanStat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款状态
	 */
	public void setLoanStat(java.lang.String loanStat){
		this.loanStat = loanStat;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年初贷款质量状态
	 */
	@Column(name ="BEG_LOAN_QUL",nullable=true,length=50)
	public java.lang.String getBegLoanQul(){
		return this.begLoanQul;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年初贷款质量状态
	 */
	public void setBegLoanQul(java.lang.String begLoanQul){
		this.begLoanQul = begLoanQul;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  重组日期
	 */
	@Column(name ="RESTR_DATE",nullable=true)
	public java.util.Date getRestrDate(){
		return this.restrDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  重组日期
	 */
	public void setRestrDate(java.util.Date restrDate){
		this.restrDate = restrDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重组贷款标识
	 */
	@Column(name ="RESTR_LOAN",nullable=true,length=50)
	public java.lang.String getRestrLoan(){
		return this.restrLoan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重组贷款标识
	 */
	public void setRestrLoan(java.lang.String restrLoan){
		this.restrLoan = restrLoan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重组贷款类型
	 */
	@Column(name ="TP_RESTR_LOAN",nullable=true,length=50)
	public java.lang.String getTpRestrLoan(){
		return this.tpRestrLoan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重组贷款类型
	 */
	public void setTpRestrLoan(java.lang.String tpRestrLoan){
		this.tpRestrLoan = tpRestrLoan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否地方政府融资平台贷款
	 */
	@Column(name ="GOV_PLTF_LOAN",nullable=true,length=50)
	public java.lang.String getGovPltfLoan(){
		return this.govPltfLoan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否地方政府融资平台贷款
	 */
	public void setGovPltfLoan(java.lang.String govPltfLoan){
		this.govPltfLoan = govPltfLoan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */
	@Column(name ="PAY_TERM",nullable=true,length=50)
	public java.lang.String getPayTerm(){
		return this.payTerm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付方式
	 */
	public void setPayTerm(java.lang.String payTerm){
		this.payTerm = payTerm;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  下次付息日
	 */
	@Column(name ="NX_PAY",nullable=true)
	public java.util.Date getNxPay(){
		return this.nxPay;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  下次付息日
	 */
	public void setNxPay(java.util.Date nxPay){
		this.nxPay = nxPay;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  上次付息日到当前应收利息
	 */
	@Column(name ="CUR_INS_RECV",nullable=true,precision=20,scale=4)
	public BigDecimal getCurInsRecv(){
		return this.curInsRecv;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  上次付息日到当前应收利息
	 */
	public void setCurInsRecv(BigDecimal curInsRecv){
		this.curInsRecv = curInsRecv;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  上次付息日到当前应收利息折人民币（自加）
	 */
	@Column(name ="CUR_INS_RECVCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getCurInsRecvcny(){
		return this.curInsRecvcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  上次付息日到当前应收利息折人民币（自加）
	 */
	public void setCurInsRecvcny(BigDecimal curInsRecvcny){
		this.curInsRecvcny = curInsRecvcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  上次付息日到当前应收利息折美金（自加）
	 */
	@Column(name ="CUR_INS_RECVUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getCurInsRecvusd(){
		return this.curInsRecvusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  上次付息日到当前应收利息折美金（自加）
	 */
	public void setCurInsRecvusd(BigDecimal curInsRecvusd){
		this.curInsRecvusd = curInsRecvusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  基准利率
	 */
	@Column(name ="BASIC_RATE",nullable=true,precision=20,scale=4)
	public BigDecimal getBasicRate(){
		return this.basicRate;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  基准利率
	 */
	public void setBasicRate(BigDecimal basicRate){
		this.basicRate = basicRate;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  实际利率
	 */
	@Column(name ="REAL_INTRATE",nullable=true,precision=20,scale=4)
	public BigDecimal getRealIntrate(){
		return this.realIntrate;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  实际利率
	 */
	public void setRealIntrate(BigDecimal realIntrate){
		this.realIntrate = realIntrate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款承诺是否可撤销
	 */
	@Column(name ="REV_CDT_COM",nullable=true,length=50)
	public java.lang.String getRevCdtCom(){
		return this.revCdtCom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款承诺是否可撤销
	 */
	public void setRevCdtCom(java.lang.String revCdtCom){
		this.revCdtCom = revCdtCom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借新还旧
	 */
	@Column(name ="REFN",nullable=true,length=50)
	public java.lang.String getRefn(){
		return this.refn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借新还旧
	 */
	public void setRefn(java.lang.String refn){
		this.refn = refn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  最长逾期天数
	 */
	@Column(name ="OVDUE_DAY",nullable=true,length=50)
	public java.lang.String getOvdueDay(){
		return this.ovdueDay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最长逾期天数
	 */
	public void setOvdueDay(java.lang.String ovdueDay){
		this.ovdueDay = ovdueDay;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  还款日期（下一次最近还款日期）
	 */
	@Column(name ="BLING_DATE",nullable=true)
	public java.util.Date getBlingDate(){
		return this.blingDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  还款日期（下一次最近还款日期）
	 */
	public void setBlingDate(java.util.Date blingDate){
		this.blingDate = blingDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  还本帐户帐号
	 */
	@Column(name ="AC_REPAY_PRIN",nullable=true,length=50)
	public java.lang.String getAcRepayPrin(){
		return this.acRepayPrin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  还本帐户帐号
	 */
	public void setAcRepayPrin(java.lang.String acRepayPrin){
		this.acRepayPrin = acRepayPrin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  还息帐户帐号
	 */
	@Column(name ="AC_REPAY_INS",nullable=true,length=50)
	public java.lang.String getAcRepayIns(){
		return this.acRepayIns;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  还息帐户帐号
	 */
	public void setAcRepayIns(java.lang.String acRepayIns){
		this.acRepayIns = acRepayIns;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款还款方式
	 */
	@Column(name ="LOAN_PAT",nullable=true,length=50)
	public java.lang.String getLoanPat(){
		return this.loanPat;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款还款方式
	 */
	public void setLoanPat(java.lang.String loanPat){
		this.loanPat = loanPat;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期本金罚息
	 */
	@Column(name ="OVE_DEFP_INS",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefpIns(){
		return this.oveDefpIns;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期本金罚息
	 */
	public void setOveDefpIns(BigDecimal oveDefpIns){
		this.oveDefpIns = oveDefpIns;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期利息罚息
	 */
	@Column(name ="OVE_DEFI_INS",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefiIns(){
		return this.oveDefiIns;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期利息罚息
	 */
	public void setOveDefiIns(BigDecimal oveDefiIns){
		this.oveDefiIns = oveDefiIns;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  重组前贷款编号
	 */
	@Column(name ="ORLOAN_ID",nullable=true,length=50)
	public java.lang.String getOrloanId(){
		return this.orloanId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  重组前贷款编号
	 */
	public void setOrloanId(java.lang.String orloanId){
		this.orloanId = orloanId;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_一般准备金额
	 */
	@Column(name ="GENERAL_PRO",nullable=true,precision=20,scale=4)
	public BigDecimal getGeneralPro(){
		return this.generalPro;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_一般准备金额
	 */
	public void setGeneralPro(BigDecimal generalPro){
		this.generalPro = generalPro;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_一般准备金额折人民币（自加）
	 */
	@Column(name ="GENERAL_PROCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getGeneralProcny(){
		return this.generalProcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_一般准备金额折人民币（自加）
	 */
	public void setGeneralProcny(BigDecimal generalProcny){
		this.generalProcny = generalProcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_一般准备金额折美金（自加）
	 */
	@Column(name ="GENERAL_PROUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getGeneralProusd(){
		return this.generalProusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_一般准备金额折美金（自加）
	 */
	public void setGeneralProusd(BigDecimal generalProusd){
		this.generalProusd = generalProusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_专项准备金额
	 */
	@Column(name ="SPECIAL_PRO",nullable=true,precision=20,scale=4)
	public BigDecimal getSpecialPro(){
		return this.specialPro;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_专项准备金额
	 */
	public void setSpecialPro(BigDecimal specialPro){
		this.specialPro = specialPro;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_专项准备金额折人民币（自加）
	 */
	@Column(name ="SPECIAL_PROCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getSpecialProcny(){
		return this.specialProcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_专项准备金额折人民币（自加）
	 */
	public void setSpecialProcny(BigDecimal specialProcny){
		this.specialProcny = specialProcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_专项准备金额折美金（自加）
	 */
	@Column(name ="SPECIAL_PROUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getSpecialProusd(){
		return this.specialProusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_专项准备金额折美金（自加）
	 */
	public void setSpecialProusd(BigDecimal specialProusd){
		this.specialProusd = specialProusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_特种准备金额
	 */
	@Column(name ="SPECIFIC_PRO",nullable=true,precision=20,scale=4)
	public BigDecimal getSpecificPro(){
		return this.specificPro;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_特种准备金额
	 */
	public void setSpecificPro(BigDecimal specificPro){
		this.specificPro = specificPro;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_特种准备金额折人民币（自加）
	 */
	@Column(name ="SPECIFIC_PROCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getSpecificProcny(){
		return this.specificProcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_特种准备金额折人民币（自加）
	 */
	public void setSpecificProcny(BigDecimal specificProcny){
		this.specificProcny = specificProcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款减值准备_特种准备金额折美金（自加）
	 */
	@Column(name ="SPECIFIC_PROUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getSpecificProusd(){
		return this.specificProusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款减值准备_特种准备金额折美金（自加）
	 */
	public void setSpecificProusd(BigDecimal specificProusd){
		this.specificProusd = specificProusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  贷款的初始金额
	 */
	@Column(name ="ISSUE_PRICE",nullable=true,precision=20,scale=4)
	public BigDecimal getIssuePrice(){
		return this.issuePrice;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  贷款的初始金额
	 */
	public void setIssuePrice(BigDecimal issuePrice){
		this.issuePrice = issuePrice;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付账号
	 */
	@Column(name ="DRAWDOWN_ACCOUNT",nullable=true,length=50)
	public java.lang.String getDrawdownAccount(){
		return this.drawdownAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付账号
	 */
	public void setDrawdownAccount(java.lang.String drawdownAccount){
		this.drawdownAccount = drawdownAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  放款编号
	 */
	@Column(name ="SELL_NUM",nullable=true,length=50)
	public java.lang.String getSellNum(){
		return this.sellNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  放款编号
	 */
	public void setSellNum(java.lang.String sellNum){
		this.sellNum = sellNum;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期本金
	 */
	@Column(name ="OVE_DEFP",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefp(){
		return this.oveDefp;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期本金
	 */
	public void setOveDefp(BigDecimal oveDefp){
		this.oveDefp = oveDefp;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期本金折人民币（自加）
	 */
	@Column(name ="OVE_DEFPCNY",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefpcny(){
		return this.oveDefpcny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期本金折人民币（自加）
	 */
	public void setOveDefpcny(BigDecimal oveDefpcny){
		this.oveDefpcny = oveDefpcny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期本金折美金（自加）
	 */
	@Column(name ="OVE_DEFPUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefpusd(){
		return this.oveDefpusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期本金折美金（自加）
	 */
	public void setOveDefpusd(BigDecimal oveDefpusd){
		this.oveDefpusd = oveDefpusd;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期利息
	 */
	@Column(name ="OVE_DEFI",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefi(){
		return this.oveDefi;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期利息
	 */
	public void setOveDefi(BigDecimal oveDefi){
		this.oveDefi = oveDefi;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期利息折人民币（自加）
	 */
	@Column(name ="OVE_DEFICNY",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDeficny(){
		return this.oveDeficny;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期利息折人民币（自加）
	 */
	public void setOveDeficny(BigDecimal oveDeficny){
		this.oveDeficny = oveDeficny;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  逾期利息折美金（自加）
	 */
	@Column(name ="OVE_DEFIUSD",nullable=true,precision=20,scale=4)
	public BigDecimal getOveDefiusd(){
		return this.oveDefiusd;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  逾期利息折美金（自加）
	 */
	public void setOveDefiusd(BigDecimal oveDefiusd){
		this.oveDefiusd = oveDefiusd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  贷款用途
	 */
	@Column(name ="LOAN_PURPOSE",nullable=true,length=50)
	public java.lang.String getLoanPurpose(){
		return this.loanPurpose;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  贷款用途
	 */
	public void setLoanPurpose(java.lang.String loanPurpose){
		this.loanPurpose = loanPurpose;
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
	 *@return: java.lang.String  最高层额度编号
	 */
	@Column(name ="CREDIT_LINE",nullable=true,length=50)
	public java.lang.String getCreditLine(){
		return this.creditLine;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  最高层额度编号
	 */
	public void setCreditLine(java.lang.String creditLine){
		this.creditLine = creditLine;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  预收利息余额
	 */
	@Column(name ="UNEARN_INS",nullable=true,precision=20,scale=4)
	public BigDecimal getUnearnIns(){
		return this.unearnIns;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  预收利息余额
	 */
	public void setUnearnIns(BigDecimal unearnIns){
		this.unearnIns = unearnIns;
	}
	/**
	 *方法: 取得BigDecimal
	 *@return: BigDecimal  预收费用余额
	 */
	@Column(name ="UNEARN_FEE",nullable=true,precision=20,scale=4)
	public BigDecimal getUnearnFee(){
		return this.unearnFee;
	}

	/**
	 *方法: 设置BigDecimal
	 *@param: BigDecimal  预收费用余额
	 */
	public void setUnearnFee(BigDecimal unearnFee){
		this.unearnFee = unearnFee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  借据编号
	 */
	@Column(name ="LOAN_NO",nullable=true,length=50)
	public java.lang.String getLoanNo(){
		return this.loanNo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  借据编号
	 */
	public void setLoanNo(java.lang.String loanNo){
		this.loanNo = loanNo;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款合同生效日期
	 */
	@Column(name ="START_DATE",nullable=true)
	public java.util.Date getStartDate(){
		return this.startDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款合同生效日期
	 */
	public void setStartDate(java.util.Date startDate){
		this.startDate = startDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  贷款合同终止日期
	 */
	@Column(name ="EXPIRY_DATE",nullable=true)
	public java.util.Date getExpiryDate(){
		return this.expiryDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  贷款合同终止日期
	 */
	public void setExpiryDate(java.util.Date expiryDate){
		this.expiryDate = expiryDate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  合同有效状态
	 */
	@Column(name ="AVAILALBE",nullable=true,length=50)
	public java.lang.String getAvailalbe(){
		return this.availalbe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  合同有效状态
	 */
	public void setAvailalbe(java.lang.String availalbe){
		this.availalbe = availalbe;
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期日-报表日（相差天数）
	 */
	@Column(name ="MATREPORTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMatreportday(){
		return this.matreportday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期日-报表日（相差天数）
	 */
	public void setMatreportday(java.lang.Integer matreportday){
		this.matreportday = matreportday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期日-报表日（相差月数）
	 */
	@Column(name ="MATREPORTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMatreportmonth(){
		return this.matreportmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期日-报表日（相差月数）
	 */
	public void setMatreportmonth(java.lang.Integer matreportmonth){
		this.matreportmonth = matreportmonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  下次付息日-报表日（相差天数）
	 */
	@Column(name ="NXREPORTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNxreportday(){
		return this.nxreportday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下次付息日-报表日（相差天数）
	 */
	public void setNxreportday(java.lang.Integer nxreportday){
		this.nxreportday = nxreportday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  下次付息日-报表日（相差月数）
	 */
	@Column(name ="NXREPORTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getNxreportmonth(){
		return this.nxreportmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  下次付息日-报表日（相差月数）
	 */
	public void setNxreportmonth(java.lang.Integer nxreportmonth){
		this.nxreportmonth = nxreportmonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  实际到期日-报表日（相差天数）
	 */
	@Column(name ="ACTREPORTDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getActreportday(){
		return this.actreportday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  实际到期日-报表日（相差天数）
	 */
	public void setActreportday(java.lang.Integer actreportday){
		this.actreportday = actreportday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  实际到期日-报表日（相差月数）
	 */
	@Column(name ="ACTREPORTMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getActreportmonth(){
		return this.actreportmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  实际到期日-报表日（相差月数）
	 */
	public void setActreportmonth(java.lang.Integer actreportmonth){
		this.actreportmonth = actreportmonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期日-发放日（相差天数）
	 */
	@Column(name ="MATDEALDAY",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMatdealday(){
		return this.matdealday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期日-发放日（相差天数）
	 */
	public void setMatdealday(java.lang.Integer matdealday){
		this.matdealday = matdealday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  到期日-发放日（相差月数）
	 */
	@Column(name ="MATDEALMONTH",nullable=true,precision=10,scale=0)
	public java.lang.Integer getMatdealmonth(){
		return this.matdealmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  到期日-发放日（相差月数）
	 */
	public void setMatdealmonth(java.lang.Integer matdealmonth){
		this.matdealmonth = matdealmonth;
	}
}
