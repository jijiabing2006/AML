package com.lzsoft.aml.entity.model.querymodel;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.base.BaseEO;


/**
 * @author cn60243
 *
 */
@SuppressWarnings("serial")

@ManagedBean
@ViewScoped
public class LogsQueryBean  extends BaseEO{
	private String userid;
	private String username;
	private String events;
	private Date eventdatestart;
	private Date eventdateend;


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEvents() {
		return events;
	}


	public void setEvents(String events) {
		this.events = events;
	}

	public Date getEventdatestart() {
		return eventdatestart;
	}


	public void setEventdatestart(Date eventdatestart) {
		this.eventdatestart = eventdatestart;
	}


	public Date getEventdateend() {
		return eventdateend;
	}


	public void setEventdateend(Date eventdateend) {
		this.eventdateend = eventdateend;
	}


	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
