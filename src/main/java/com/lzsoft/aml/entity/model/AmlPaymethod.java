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
@Table(name = "aml_paymethod")
@Repository("amlPaymethod")
public class AmlPaymethod extends BaseEO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String methodvalue;
	private String methodlabel;
	private String cnymethodvalue;
	private String cnymethodlabel;
	private String cnymethodp2value;
	private String cnymethodp2label;
	private String foreignmethodvalue;
	private String foreignmethodlabel;
	private String agentmethodvalue;
	private String agentmethodlabel;
	private String crosscurrencymethodvalue;
	private String crosscurrencymethodlabel;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Primary
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMethodvalue() {
		return methodvalue;
	}

	public void setMethodvalue(String methodvalue) {
		this.methodvalue = methodvalue;
	}

	public String getMethodlabel() {
		return methodlabel;
	}

	public void setMethodlabel(String methodlabel) {
		this.methodlabel = methodlabel;
	}

	public String getCnymethodvalue() {
		return cnymethodvalue;
	}

	public void setCnymethodvalue(String cnymethodvalue) {
		this.cnymethodvalue = cnymethodvalue;
	}

	public String getCnymethodlabel() {
		return cnymethodlabel;
	}

	public void setCnymethodlabel(String cnymethodlabel) {
		this.cnymethodlabel = cnymethodlabel;
	}

	public String getCnymethodp2value() {
		return cnymethodp2value;
	}

	public void setCnymethodp2value(String cnymethodp2value) {
		this.cnymethodp2value = cnymethodp2value;
	}

	public String getCnymethodp2label() {
		return cnymethodp2label;
	}

	public void setCnymethodp2label(String cnymethodp2label) {
		this.cnymethodp2label = cnymethodp2label;
	}

	public String getForeignmethodvalue() {
		return foreignmethodvalue;
	}

	public void setForeignmethodvalue(String foreignmethodvalue) {
		this.foreignmethodvalue = foreignmethodvalue;
	}

	public String getForeignmethodlabel() {
		return foreignmethodlabel;
	}

	public void setForeignmethodlabel(String foreignmethodlabel) {
		this.foreignmethodlabel = foreignmethodlabel;
	}

	public String getAgentmethodvalue() {
		return agentmethodvalue;
	}

	public void setAgentmethodvalue(String agentmethodvalue) {
		this.agentmethodvalue = agentmethodvalue;
	}

	public String getAgentmethodlabel() {
		return agentmethodlabel;
	}

	public void setAgentmethodlabel(String agentmethodlabel) {
		this.agentmethodlabel = agentmethodlabel;
	}

	public String getCrosscurrencymethodvalue() {
		return crosscurrencymethodvalue;
	}

	public void setCrosscurrencymethodvalue(String crosscurrencymethodvalue) {
		this.crosscurrencymethodvalue = crosscurrencymethodvalue;
	}

	public String getCrosscurrencymethodlabel() {
		return crosscurrencymethodlabel;
	}

	public void setCrosscurrencymethodlabel(String crosscurrencymethodlabel) {
		this.crosscurrencymethodlabel = crosscurrencymethodlabel;
	}

	@Override
	@Transient
	public Object getPrimaryKey() {
		return this.id;
	}
}
