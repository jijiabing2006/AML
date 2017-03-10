package com.lzsoft.aml.entity.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import com.lzsoft.aml.entity.annotation.FieldDisplayName;
import com.lzsoft.aml.entity.base.BaseEO;
@MappedSuperclass
public class Amlbase extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@FieldDisplayName(value="报告生成日期(编辑完成日期)")
	private String rpdt;
	@FieldDisplayName(value="客户名称/姓名")
	private String ctnm;
	@FieldDisplayName(value="客户身份证件/证明文件类型")
	private String citp;
	@FieldDisplayName(value="客户身份证件/证明文件号码")
	private String ctid;
	@FieldDisplayName(value="客户号")
	private String csnm;
	@FieldDisplayName(value="客户国籍")
	private String ctnt;
	@FieldDisplayName(value="金融机构网点所在地区行政区划代码")
	private String firc;
	@FieldDisplayName(value="金融机构网点代码类型")
	private String fict;
	@FieldDisplayName(value="账户类型")
	private String catp;
	@FieldDisplayName(value="账号")
	private String ctac;
	@FieldDisplayName(value="交易日期")
	private String tstm;
	@FieldDisplayName(value="业务标示号")
	private String ticd;
	@FieldDisplayName(value="交易方式")
	private String tstp;
	@FieldDisplayName(value="涉外收支交易分类与代码")
	private String tsct;
	@FieldDisplayName(value="资金收付标志")
	private String tsdr;
	@FieldDisplayName(value="交易发生地")
	private String trcd;
	private String trcdfirst;
	private String trcdsecond;
	@FieldDisplayName(value="币种")
	private String crtp;
	@FieldDisplayName(value="交易金额")
	private BigDecimal crat;
	@FieldDisplayName(value="对方金融机构网点名称")
	private String cfin;
	@FieldDisplayName(value="对方金融机构代码网点类型")
	private String cfct;
	@FieldDisplayName(value="对方金融机构网点代码")
	private String cfic;
	@FieldDisplayName(value="交易对手姓名/名称")
	private String tcnm;
	@FieldDisplayName(value="交易对手身份证件/证明文件类型")
	private String tcit;
	@FieldDisplayName(value="交易对手身份证件/证明文件号码")
	private String tcid;
	@FieldDisplayName(value="交易对手账户类型")
	private String tcat;
	@FieldDisplayName(value="交易对手账号")
	private String tcac;
	@FieldDisplayName(value="分行代码")
	private String bkid;
	@FieldDisplayName(value="支行代码")
	private String subbkid;
	@FieldDisplayName(value="编辑状态")
	private String isedit;

	private String ishandadd;
	@FieldDisplayName(value="审核状态")
	private String isvalidation;

	private String isdel;
	@FieldDisplayName(value="导出状态")
	private String isexport;//导出状态（上报状态，未导出，已经导出，不报送）

	private String isinpboc;

	private String filename;

	private String zipfname;
	@FieldDisplayName(value="业务日期")
	private Date importdate;

	private String remark;

	@Column(name = "RPDT", nullable = false, length = 8)
	public String getRpdt() {
		return rpdt;
	}


	public void setRpdt(String rpdt) {
		this.rpdt = rpdt;
	}

	@Column(name = "CTNM", nullable = true)
	public String getCtnm() {
		return ctnm;
	}


	public void setCtnm(String ctnm) {
		this.ctnm = ctnm;
	}

	@Column(name = "CITP", nullable = true)
	public String getCitp() {
		return citp;
	}


	public void setCitp(String citp) {
		this.citp = citp;
	}

	@Column(name = "CTID", nullable = true)
	public String getCtid() {
		return ctid;
	}
	public void setCtid(String ctid) {
		this.ctid = ctid;
	}

	@Column(name = "CSNM", nullable = true)
	public String getCsnm() {
		return csnm;
	}


	public void setCsnm(String csnm) {
		this.csnm = csnm;
	}

	@Column(name = "CTNT", nullable = true)
	public String getCtnt() {
		return ctnt;
	}


	public void setCtnt(String ctnt) {
		this.ctnt = ctnt;
	}

	@Column(name = "FIRC", nullable = true)
	public String getFirc() {
		return firc;
	}


	public void setFirc(String firc) {
		this.firc = firc;
	}

	@Column(name = "FICT", nullable = true)
	public String getFict() {
		return fict;
	}


	public void setFict(String fict) {
		this.fict = fict;
	}

	@Column(name = "CATP", nullable = true)
	public String getCatp() {
		return catp;
	}


	public void setCatp(String catp) {
		this.catp = catp;
	}

	@Column(name = "CTAC", nullable = true)
	public String getCtac() {
		return ctac;
	}


	public void setCtac(String ctac) {
		this.ctac = ctac;
	}

	@Column(name = "TSTM", nullable = true)
	public String getTstm() {
		return tstm;
	}


	public void setTstm(String tstm) {
		this.tstm = tstm;
	}

	@Column(name = "TICD", nullable = true)
	public String getTicd() {
		return ticd;
	}


	public void setTicd(String ticd) {
		this.ticd = ticd;
	}

	@Column(name = "TSTP", nullable = true)
	public String getTstp() {
		return tstp;
	}


	public void setTstp(String tstp) {
		this.tstp = tstp;
	}

	@Column(name = "TSCT", nullable = true)
	public String getTsct() {
		return tsct;
	}


	public void setTsct(String tsct) {
		this.tsct = tsct;
	}

	@Column(name = "TSDR", nullable = true)
	public String getTsdr() {
		return tsdr;
	}


	public void setTsdr(String tsdr) {
		this.tsdr = tsdr;
	}

	@Column(name = "TRCD", nullable = true)
	public String getTrcd() {
		return trcd;
	}


	public void setTrcd(String trcd) {
		this.trcd = trcd;
	}

	@Column(name = "CRTP", nullable = true)
	public String getCrtp() {
		return crtp;
	}


	public void setCrtp(String crtp) {
		this.crtp = crtp;
	}

	@Column(name = "CRAT", nullable = true)
	public BigDecimal getCrat() {
		return crat;
	}


	public void setCrat(BigDecimal crat) {
		this.crat = crat;
	}

	@Column(name = "CFIN", nullable = true)
	public String getCfin() {
		return cfin;
	}


	public void setCfin(String cfin) {
		this.cfin = cfin;
	}

	@Column(name = "CFCT", nullable = true)
	public String getCfct() {
		return cfct;
	}


	public void setCfct(String cfct) {
		this.cfct = cfct;
	}

	@Column(name = "CFIC", nullable = true)
	public String getCfic() {
		return cfic;
	}


	public void setCfic(String cfic) {
		this.cfic = cfic;
	}


	@Column(name = "TCNM", nullable = true)
	public String getTcnm() {
		return tcnm;
	}


	public void setTcnm(String tcnm) {
		this.tcnm = tcnm;
	}

	@Column(name = "TCIT", nullable = true)
	public String getTcit() {
		return tcit;
	}


	public void setTcit(String tcit) {
		this.tcit = tcit;
	}

	@Column(name = "TCID", nullable = true)
	public String getTcid() {
		return tcid;
	}


	public void setTcid(String tcid) {
		this.tcid = tcid;
	}

	@Column(name = "TCAT", nullable = true)
	public String getTcat() {
		return tcat;
	}


	public void setTcat(String tcat) {
		this.tcat = tcat;
	}

	@Column(name = "TCAC", nullable = true)
	public String getTcac() {
		return tcac;
	}


	public void setTcac(String tcac) {
		this.tcac = tcac;
	}

	@Column(name = "BKID", nullable = false)
	public String getBkid() {
		return bkid;
	}


	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	@Column(name = "SUBBKID", nullable = true)
	public String getSubbkid() {
		return subbkid;
	}


	public void setSubbkid(String subbkid) {
		this.subbkid = subbkid;
	}

	@Column(name = "ISEDIT", nullable = true)
	public String getIsedit() {
		return isedit;
	}


	public void setIsedit(String isedit) {
		this.isedit = isedit;
	}

	@Column(name = "ISHANDADD", nullable = true)
	public String getIshandadd() {
		return ishandadd;
	}


	public void setIshandadd(String ishandadd) {
		this.ishandadd = ishandadd;
	}

	@Column(name = "ISVALIDATION", nullable = true)
	public String getIsvalidation() {
		return isvalidation;
	}


	public void setIsvalidation(String isvalidation) {
		this.isvalidation = isvalidation;
	}

	@Column(name = "ISDEL", nullable = true)
	public String getIsdel() {
		return isdel;
	}


	public void setIsdel(String isdel) {
		this.isdel = isdel;
	}

	@Column(name = "ISEXPORT", nullable = true)
	public String getIsexport() {
		return isexport;
	}


	public void setIsexport(String isexport) {
		this.isexport = isexport;
	}

	@Column(name = "ISINPBOC", nullable = true)
	public String getIsinpboc() {
		return isinpboc;
	}


	public void setIsinpboc(String isinpboc) {
		this.isinpboc = isinpboc;
	}

	@Column(name = "FILENAME", nullable = true)
	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	@Column(name = "IMPORTDATE", nullable = false)
	public Date getImportdate() {
		return importdate;
	}
	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}
	@Column(name = "REMARK", nullable = true)
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "ZIPFNAME", nullable = true)
	public String getZipfname() {
		return zipfname;
	}


	public void setZipfname(String zipfname) {
		this.zipfname = zipfname;
	}

	@Transient
	public String getTrcdfirst() {
		return trcdfirst;
	}


	public void setTrcdfirst(String trcdfirst) {
		this.trcdfirst = trcdfirst;
	}

	@Transient
	public String getTrcdsecond() {
		return trcdsecond;
	}


	public void setTrcdsecond(String trcdsecond) {
		this.trcdsecond = trcdsecond;
	}


	@Override
	@Transient
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
