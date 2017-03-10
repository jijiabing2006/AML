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
@Table(name="core_op")
@Repository("operation")
public class Operation extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private Date cdate;
	private Date mdate;
	private String opname;
	private String opdesc;
	private int state;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	 @Column(name="CDATE", nullable = true)
	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	 @Column(name="MDATE", nullable = true)
	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	 @Column(name="OPNAME", nullable = true)
	public String getOpname() {
		return opname;
	}


	public void setOpname(String opname) {
		this.opname = opname;
	}

	 @Column(name="OPDESC", nullable = true)
	public String getOpdesc() {
		return opdesc;
	}


	public void setOpdesc(String opdesc) {
		this.opdesc = opdesc;
	}

	@Column(name = "STATE", nullable = true)
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
