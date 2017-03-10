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
@Table(name = "core_user_session")
@Repository("userSession")
public class UserSession extends BaseEO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4574372416231421382L;
	private int id;
	private String sessionid;
	private String ip;
	private String kickedout;
	private String pcname;
	private String userid;
	private Date mdate;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "SESSIONID", nullable = true)
	public String getSessionid() {
		return sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	@Column(name = "IP", nullable = true)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Column(name = "KICKEDOUT", nullable = true)
	public String getKickedout() {
		return kickedout;
	}

	public void setKickedout(String kickedout) {
		this.kickedout = kickedout;
	}
	@Column(name = "PCNAME", nullable = true)
	public String getPcname() {
		return pcname;
	}
	public void setPcname(String pcname) {
		this.pcname = pcname;
	}
	@Column(name = "MDATE", nullable = true)
	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	@Column(name = "USERID", nullable = true)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	public String toString() {
		StringBuffer strBuff = new StringBuffer();
		strBuff.append("id : ").append(getId());
		strBuff.append(", sessionid : ").append(getSessionid());
		strBuff.append(", ip : ").append(getIp());
		strBuff.append(", kickedout : ").append(getKickedout());
		return strBuff.toString();
	}



	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
}
