package com.lzsoft.aml.paras.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Para_SpecialEconomicAreas implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String code;
    private String number;
    private String cnname;
    private String fullcnname;
    private String enname;
    private String fullenname;

    public Para_SpecialEconomicAreas() {
    }

    @XmlElement
    public String getNumber() {
    	return number;
    }
    
    public void setNumber(String number) {
    	this.number = number;
    }

    @XmlElement
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    @XmlElement
	public String getCnname() {
		return cnname;
	}

	public void setCnname(String cnname) {
		this.cnname = cnname;
	}
	 @XmlElement
	public String getFullcnname() {
		return fullcnname;
	}

	public void setFullcnname(String fullcnname) {
		this.fullcnname = fullcnname;
	}
	 @XmlElement
	public String getEnname() {
		return enname;
	}

	public void setEnname(String enname) {
		this.enname = enname;
	}
	 @XmlElement
	public String getFullenname() {
		return fullenname;
	}

	public void setFullenname(String fullenname) {
		this.fullenname = fullenname;
	}



   

}
