package com.lzsoft.aml.paras.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;

public class Para_SettlementExchangeUsingcode implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private String code;
    private String name;

    public Para_SettlementExchangeUsingcode() {
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
