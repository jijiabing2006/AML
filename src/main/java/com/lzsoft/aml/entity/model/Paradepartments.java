package com.lzsoft.aml.entity.model;

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
@Table(name="para_departments")
@Repository("paradepartments")
public class Paradepartments extends BaseEO {

	private static final long serialVersionUID = 1L;

	private int id;
	

	private String code;

	private String namecn;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNamecn() {
		return namecn;
	}

	public void setNamecn(String namecn) {
		this.namecn = namecn;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
