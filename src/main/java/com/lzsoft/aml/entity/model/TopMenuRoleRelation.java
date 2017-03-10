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
@Table(name="core_topmenu_role_relation")
@Repository("topmenurolerelation")
public class TopMenuRoleRelation extends BaseEO {
	/**
	 * 
	 */
private static final long serialVersionUID = 1L;
	
	
	private int id;
	private int menuid;
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


	 @Column(name="MENUID", nullable = true)
	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
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
