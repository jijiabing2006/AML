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
@Table(name="core_role")
@Repository("role")
public class Role extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private Date cdate;
	private Date mdate;
	private String rolename;
	private String roledesc;
	
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

	 @Column(name="ROLENAME", nullable = true)
	public String getRolename() {
		return rolename;
	}
	
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	 @Column(name="ROLEDESC", nullable = true)
	public String getRoledesc() {
		return roledesc;
	}


	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
