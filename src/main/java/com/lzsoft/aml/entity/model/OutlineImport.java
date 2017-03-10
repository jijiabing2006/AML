package com.lzsoft.aml.entity.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="outlineImport")
@ViewScoped
public class OutlineImport {
	
	private String importstate;
	private String accextractstate;
	private String bopextractstate;
	private String jshextractstate;
	private String importfolderdate;
	private String importmessage;
	private String hasexceptiondeal;
	private String lastifximportdate;
	private String lastsummitimportdate;
	
	public String getAccextractstate() {
		return accextractstate;
	}
	public void setAccextractstate(String accextractstate) {
		this.accextractstate = accextractstate;
	}
	public String getBopextractstate() {
		return bopextractstate;
	}
	public void setBopextractstate(String bopextractstate) {
		this.bopextractstate = bopextractstate;
	}
	public String getJshextractstate() {
		return jshextractstate;
	}
	public void setJshextractstate(String jshextractstate) {
		this.jshextractstate = jshextractstate;
	}
	
	public String getImportfolderdate() {
		return importfolderdate;
	}
	public void setImportfolderdate(String importfolderdate) {
		this.importfolderdate = importfolderdate;
	}
	public String getImportmessage() {
		return importmessage;
	}
	public void setImportmessage(String importmessage) {
		this.importmessage = importmessage;
	}
	public String getImportstate() {
		return importstate;
	}
	public void setImportstate(String importstate) {
		this.importstate = importstate;
	}
	public String getHasexceptiondeal() {
		return hasexceptiondeal;
	}
	public void setHasexceptiondeal(String hasexceptiondeal) {
		this.hasexceptiondeal = hasexceptiondeal;
	}
	public String getLastifximportdate() {
		return lastifximportdate;
	}
	public void setLastifximportdate(String lastifximportdate) {
		this.lastifximportdate = lastifximportdate;
	}
	public String getLastsummitimportdate() {
		return lastsummitimportdate;
	}
	public void setLastsummitimportdate(String lastsummitimportdate) {
		this.lastsummitimportdate = lastsummitimportdate;
	}
}
