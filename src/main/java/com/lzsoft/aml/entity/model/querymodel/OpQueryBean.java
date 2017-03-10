package com.lzsoft.aml.entity.model.querymodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.base.BaseEO;


/**
 * @author cn60243
 *
 */
@SuppressWarnings("serial")

@ManagedBean(name="opQueryBean")
@ViewScoped
public class OpQueryBean  extends BaseEO{
	private String opname; //权限名称

	public String getOpname() {
		return opname;
	}
	public void setOpname(String opname) {
		this.opname = opname;
	}
	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
