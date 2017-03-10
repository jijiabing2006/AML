package com.lzsoft.aml.entity.model;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "download")
@ViewScoped
public class Download implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;

	private String fileDesc;

	private String fromView;
	
	private boolean isAbsolutePath; 
	
	private boolean flag=false; 



	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public boolean isAbsolutePath() {
		return isAbsolutePath;
	}

	public void setAbsolutePath(boolean isAbsolutePath) {
		this.isAbsolutePath = isAbsolutePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFromView() {
		return fromView;
	}

	public void setFromView(String fromView) {
		this.fromView = fromView;
	}

}
