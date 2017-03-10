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
@Table(name = "core_mail_receipter")
@Repository
public class MessageReceipter extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	/**
	 * E-Mail Address
	 */
	private String userid;
	private String type;
	private boolean state;
	private String bkid;
	private String subbkid;
	private String msend;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
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

	public String getMsend() {
		return msend;
	}

	public void setMsend(String msend) {
		this.msend = msend;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
}
