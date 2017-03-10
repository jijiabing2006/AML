package com.lzsoft.aml.entity.model.querymodel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.base.BaseEO;


/**
 * @author cn60243
 *
 */
@SuppressWarnings("serial")

@ManagedBean(name="roleQueryBean")
@ViewScoped
public class RoleQueryBean  extends BaseEO{
	private String rolename; //角色名称

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
