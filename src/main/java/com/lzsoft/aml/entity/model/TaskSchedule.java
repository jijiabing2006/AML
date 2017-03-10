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
@Table(name="taskschedule")
@Repository("taskschedule")
public class TaskSchedule extends BaseEO {

	private static final long serialVersionUID = 1L;

	private int id;
	
	
	@Column(name="BKID", nullable = true)
	private String bkid;
	
	@Column(name="SUBBKID", nullable = false)
	private String subbkid;
	
	@Column(name = "TASKNAME")
	private String taskname;
	
	@Column(name = "TASKDESC")
	private String taskdesc;
	
	@Column(name = "EXECUTALBE")
	private boolean executable;//判断Spring配置的自动运行方法，是否有必要继续执行
	
	@Column(name = "IMPORTDATE", updatable = false)
	private Date importdate;
	
	private int counts=0; 

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskdesc() {
		return taskdesc;
	}

	public void setTaskdesc(String taskdesc) {
		this.taskdesc = taskdesc;
	}

	public boolean isExecutable() {
		return executable;
	}

	public void setExecutable(boolean executable) {
		this.executable = executable;
	}

	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}



	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return  this.id;
	}
}
