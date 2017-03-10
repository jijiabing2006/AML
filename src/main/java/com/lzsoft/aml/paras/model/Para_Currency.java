package com.lzsoft.aml.paras.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Para_Currency implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String code;
    private String number;
    private String name;

    public Para_Currency() {
    }

    @XmlElement
    public String getNumber() {
    	return number;
    }
    
    public void setNumber(String number) {
    	this.number = number;
    }
    @XmlElement
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

   

}
