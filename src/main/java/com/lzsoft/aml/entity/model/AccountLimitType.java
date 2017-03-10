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

import com.lzsoft.aml.entity.base.BaseEO;

@Entity
@Table(name="para_accountlimittype")
@Repository("accountLimitType")
public class AccountLimitType extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	private String typecode;
	private String typenamecn;
	private String typenameen;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name="type_code", nullable = true)
	 public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	
	 @Column(name="type_namecn", nullable = true)
	public String getTypenamecn() {
		return typenamecn;
	}
	public void setTypenamecn(String typenamecn) {
		this.typenamecn = typenamecn;
	}
	 @Column(name="type_nameen", nullable = true)
	public String getTypenameen() {
		return typenameen;
	}

	public void setTypenameen(String typenameen) {
		this.typenameen = typenameen;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
