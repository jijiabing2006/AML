package com.lzsoft.aml.entity.model;

import java.util.Date;

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
@Table(name = "core_mail")
@Repository("message")
public class Message extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	/**
	 * E-Mail Address
	 */
	private String notifyemail;
	private String notifymobil;
	private String mobildata;
	
	private String address;
	private String subject;
	private String att;
	private String message;

	/**
	 * 发送註記,空白-待发,Y-已发
	 */
	private String flag;
	private Date uddate;
	/**
	 * 发送时间
	 */
	private Date senddate;
	private Date lastupdatetime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	

}

	public String getNotifyemail() {
		return notifyemail;
	}

	public void setNotifyemail(String notifyemail) {
		this.notifyemail = notifyemail;
	}

	public String getNotifymobil() {
		return notifymobil;
	}

	public void setNotifymobil(String notifymobil) {
		this.notifymobil = notifymobil;
	}

	public String getMobildata() {
		return mobildata;
	}

	public void setMobildata(String mobildata) {
		this.mobildata = mobildata;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getUddate() {
		return uddate;
	}

	public void setUddate(Date uddate) {
		this.uddate = uddate;
	}

	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}

	public Date getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(Date lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
}
