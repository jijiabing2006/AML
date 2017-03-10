package com.lzsoft.aml.entity.model.querymodel;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.base.BaseEO;


/**
 * @author cn60243
 *
 */
@SuppressWarnings("serial")

@ManagedBean(name="outlineQueryBean")
@ViewScoped
public class OutlineQueryBean  extends BaseEO{
    private Date importdate;//源数据导入日期（相当于营业日期），报文生成日期

	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
