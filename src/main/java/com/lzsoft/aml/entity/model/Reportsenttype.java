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
@Table(name="reportsenttype")
@Repository("reportsenttype")
public class Reportsenttype extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	@Column(name = "TYPE", nullable = false)
	private String type;	
	
	@Column(name = "SENTTYPE", nullable = false)
	private String senttype;	
	@Column(name = "SERVERADDRESS", nullable = false)
	private String serveraddress;	

	@Column(name = "PORT", nullable = false)
	private Integer port;
	
	@Column(name = "USERNAME", nullable = false)
	private String username;
	
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	
	@Column(name = "READYTOSENDDIRPATH", nullable = false)
	private String readytosenddirpath;
	
	@Column(name = "UPLOADDIRPATH", nullable = false)
	private String uploaddirpath;
	
	@Column(name = "HISTORYDIRPATH", nullable = false)
	private String historydirpath;
	
	@Column(name = "ERRORFILEDIRPATH", nullable = false)
	private String errorfiledirpath;
	
	@Column(name = "FEEDBACKDIRPATH", nullable = false)
	private String feedbackdirpath;
	
	@Column(name = "LOGDIRPATH", nullable = false)
	private String logdirpath;
	
	@Column(name = "CONTORLDIRPATH", nullable = false)
	private String contorldirpath;
	
	@Column(name = "DOWNLOADDIRPATH", nullable = false)
	private String downloaddirpath;
	
	@Column(name = "STATE", nullable = false)
	private String state;// 状态

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSenttype() {
		return senttype;
	}

	public void setSenttype(String senttype) {
		this.senttype = senttype;
	}

	public String getServeraddress() {
		return serveraddress;
	}

	public void setServeraddress(String serveraddress) {
		this.serveraddress = serveraddress;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReadytosenddirpath() {
		return readytosenddirpath;
	}

	public void setReadytosenddirpath(String readytosenddirpath) {
		this.readytosenddirpath = readytosenddirpath;
	}

	public String getUploaddirpath() {
		return uploaddirpath;
	}

	public void setUploaddirpath(String uploaddirpath) {
		this.uploaddirpath = uploaddirpath;
	}

	public String getHistorydirpath() {
		return historydirpath;
	}

	public void setHistorydirpath(String historydirpath) {
		this.historydirpath = historydirpath;
	}

	public String getErrorfiledirpath() {
		return errorfiledirpath;
	}

	public void setErrorfiledirpath(String errorfiledirpath) {
		this.errorfiledirpath = errorfiledirpath;
	}

	public String getFeedbackdirpath() {
		return feedbackdirpath;
	}

	public void setFeedbackdirpath(String feedbackdirpath) {
		this.feedbackdirpath = feedbackdirpath;
	}

	public String getLogdirpath() {
		return logdirpath;
	}

	public void setLogdirpath(String logdirpath) {
		this.logdirpath = logdirpath;
	}

	public String getContorldirpath() {
		return contorldirpath;
	}

	public void setContorldirpath(String contorldirpath) {
		this.contorldirpath = contorldirpath;
	}

	public String getDownloaddirpath() {
		return downloaddirpath;
	}

	public void setDownloaddirpath(String downloaddirpath) {
		this.downloaddirpath = downloaddirpath;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
	
}
