package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.lzsoft.aml.entity.annotation.FieldDisplayName;

@Entity
@Table(name="aml_bigamount")
@Repository("amlBigAmount")
public class AmlBigAmount extends Amlbase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	
	@Column(name="RINM", nullable = true)
	@FieldDisplayName(value="报告机构名称")
	private String rinm;
	
	@Column(name="RICD", nullable = true)
	@FieldDisplayName(value="报告机构编码")
	private String ricd;
	@FieldDisplayName(value="大额交易发生日期")
	@Column(name="HTDT", nullable = true)
	private String htdt;
	
	@Column(name="CRCD", nullable = true)
	@FieldDisplayName(value="大额交易特征代码")
	private String crcd;
	
	@Column(name="FINN", nullable = true)
	@FieldDisplayName(value="金融机构网点名称")
	private String finn;
	@Column(name="RLTP", nullable = true)
	@FieldDisplayName(value="金融机构网点与大额交易的关系")
	private String rltp;
	@Column(name="FINC", nullable = true)
	@FieldDisplayName(value="金融机构网点所在地区行政区划代码")
	private String finc;
	@Column(name="TBNM", nullable = true)
	@FieldDisplayName(value="代办人姓名")
	private String tbnm;
	@Column(name="TBIT", nullable = true)
	@FieldDisplayName(value="代办人身份证件/证明文件类型")
	private String tbit;
	@Column(name="TBID", nullable = true)
	@FieldDisplayName(value="代办人身份证件/证明文件号码")
	private String tbid;
	@Column(name="TBNT", nullable = true)
	@FieldDisplayName(value="代办人国籍")
	private String tbnt;
	@Column(name="TDRC", nullable = true)
	@FieldDisplayName(value="交易去向")
	private String tdrc;
	private String tdrcfirst;
	private String tdrcsecond;
	
	@Column(name="CRPP", nullable = true)
	@FieldDisplayName(value="资金用途")
	private String crpp;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getHtdt() {
		return htdt;
	}

	public void setHtdt(String htdt) {
		this.htdt = htdt;
	}

	public String getCrcd() {
		return crcd;
	}

	public void setCrcd(String crcd) {
		this.crcd = crcd;
	}

	public String getFinn() {
		return finn;
	}

	public void setFinn(String finn) {
		this.finn = finn;
	}

	public String getRltp() {
		return rltp;
	}

	public void setRltp(String rltp) {
		this.rltp = rltp;
	}

	public String getFinc() {
		return finc;
	}

	public void setFinc(String finc) {
		this.finc = finc;
	}

	public String getTbnm() {
		return tbnm;
	}

	public void setTbnm(String tbnm) {
		this.tbnm = tbnm;
	}

	public String getTbit() {
		return tbit;
	}

	public void setTbit(String tbit) {
		this.tbit = tbit;
	}

	public String getRinm() {
		return rinm;
	}

	public void setRinm(String rinm) {
		this.rinm = rinm;
	}

	public String getRicd() {
		return ricd;
	}

	public void setRicd(String ricd) {
		this.ricd = ricd;
	}

	public String getTbid() {
		return tbid;
	}

	public void setTbid(String tbid) {
		this.tbid = tbid;
	}

	public String getTbnt() {
		return tbnt;
	}

	public void setTbnt(String tbnt) {
		this.tbnt = tbnt;
	}

	public String getTdrc() {
		return tdrc;
	}

	public void setTdrc(String tdrc) {
		this.tdrc = tdrc;
	}

	public String getCrpp() {
		return crpp;
	}

	public void setCrpp(String crpp) {
		this.crpp = crpp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Transient
	public String getTdrcfirst() {
		return tdrcfirst;
	}

	public void setTdrcfirst(String tdrcfirst) {
		this.tdrcfirst = tdrcfirst;
	}
	@Transient
	public String getTdrcsecond() {
		return tdrcsecond;
	}

	public void setTdrcsecond(String tdrcsecond) {
		this.tdrcsecond = tdrcsecond;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
