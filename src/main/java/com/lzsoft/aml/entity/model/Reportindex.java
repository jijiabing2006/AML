package com.lzsoft.aml.entity.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.lzsoft.aml.entity.base.BaseEO;

@Entity
@Table(name = "reportindex")
@Repository("reportindex")
public class Reportindex extends BaseEO {

	private static final long serialVersionUID = 1L;
	private int id;

	private String bkid;

	private String subbkid;

	private String apptype;

	private String reporttype;

	private String subjection;

	private String fileindex;

	private Date importdate;

	// Constructors

	/** default constructor */
	public Reportindex() {
	}

	public Reportindex(String bkid, String subbkid, String apptype,
			String reporttype, Date importdate) {
		super();
		this.bkid = bkid;
		this.subbkid = subbkid;
		this.apptype = apptype;
		this.reporttype = reporttype;
		this.importdate = importdate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getSubbkid() {
		return subbkid;
	}

	public void setSubbkid(String subbkid) {
		this.subbkid = subbkid;
	}

	public String getReporttype() {
		return reporttype;
	}

	public void setReporttype(String reporttype) {
		this.reporttype = reporttype;
	}

	public String getSubjection() {
		return subjection;
	}

	public void setSubjection(String subjection) {
		this.subjection = subjection;
	}

	public String getApptype() {
		return apptype;
	}

	public void setApptype(String apptype) {
		this.apptype = apptype;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFileindex() {
		return fileindex;
	}

	public void setFileindex(String fileindex) {
		this.fileindex = fileindex;
	}

	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}

	// Property accessors

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
}