package com.lzsoft.aml.entity.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.lzsoft.aml.entity.base.BaseEO;
@MappedSuperclass
public abstract class IdEntity extends BaseEO {
	private String id;

	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
