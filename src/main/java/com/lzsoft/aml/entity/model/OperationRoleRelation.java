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
@Table(name="core_op_role_relation")
@Repository("oprolerelation")
public class OperationRoleRelation extends BaseEO {
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	
	private int id;
	private int opid;
	private int roleid;
	private Date cdate;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	 @Column(name="OPID", nullable = true)
	public int getOpid() {
		return opid;
	}

	public void setOpid(int opid) {
		this.opid = opid;
	}

	 @Column(name="ROLEID", nullable = true)
	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	 @Column(name="CDATE", nullable = true)
	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
