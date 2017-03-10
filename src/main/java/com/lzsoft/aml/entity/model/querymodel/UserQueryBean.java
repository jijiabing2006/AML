package com.lzsoft.aml.entity.model.querymodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.base.BaseEO;

/**
 * @author cn60243
 *
 */
@SuppressWarnings("serial")

@ManagedBean(name="userQueryBean")
@ViewScoped
public class UserQueryBean  extends BaseEO{
	private String userid; //UserID
	private String username; //Username
	private String bkid; //
	private String subbkid; //


	public String getUsername() {
		return username;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public void setUsername(String username) {
		this.username = username;
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


	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
