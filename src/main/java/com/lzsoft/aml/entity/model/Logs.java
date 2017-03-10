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
@Table(name = "core_logs")
@Repository("logs")
public class Logs extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;

	private Date eventdate;
	private String events;
	private String username;
	private String objects;
	private String userid;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "EVENTDATE", nullable = true)
	public Date getEventdate() {
		return eventdate;
	}

	public void setEventdate(Date eventdate) {
		this.eventdate = eventdate;
	}

	@Column(name = "EVENTS", nullable = true)
	public String getEvents() {
		return events;
	}

	public void setEvents(String events) {
		this.events = events;
	}

	@Column(name = "USERNAME", nullable = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "OBJECTS", nullable = true)
	public String getObjects() {
		return objects;
	}

	public void setObjects(String objects) {
		this.objects = objects;
	}

	@Column(name = "USERID", nullable = true)
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}

}
