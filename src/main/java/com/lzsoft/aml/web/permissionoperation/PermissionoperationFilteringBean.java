package com.lzsoft.aml.web.permissionoperation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "opFilteringBean")
@ViewScoped
public class PermissionoperationFilteringBean  {
	private String opname;
	private String opdesc;
	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	public String getOpdesc() {
		return opdesc;
	}
	public void setOpdesc(String opdesc) {
		this.opdesc = opdesc;
	}



}
