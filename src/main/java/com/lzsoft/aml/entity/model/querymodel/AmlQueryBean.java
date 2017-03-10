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
@ManagedBean(name = "amlQueryBean")
@ViewScoped
public class AmlQueryBean extends BaseEO {
	private Date importdate;// 源数据导入日期（相当于营业日期（生效日期），
	private Date extractdate;// 提取数据日期（相当于营业日期（生效日期），
	private Date exportdate;// 数据导出日期，

	private Date importdateStart;// 业务发生日期（查询区间开始）。外汇账号开户用
	private Date importdateEnd;// 业务发生日期（查询区间结束）
	private String csnm;// 客户名称
	private String buscode;// 业务编号
	private String state;// 状态 
	private String bkid;// 分行代码 
	private String subbkid;// 支行代码（分行级就是分行代码） 
	private String type;// 报文类型(NRICAD)
	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}

	public Date getImportdateStart() {
		return importdateStart;
	}

	public void setImportdateStart(Date importdateStart) {
		this.importdateStart = importdateStart;
	}

	public Date getImportdateEnd() {
		return importdateEnd;
	}

	public void setImportdateEnd(Date importdateEnd) {
		this.importdateEnd = importdateEnd;
	}


	public String getBuscode() {
		return buscode;
	}

	public void setBuscode(String buscode) {
		this.buscode = buscode;
	}


	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	public Date getExtractdate() {
		return extractdate;
	}

	public void setExtractdate(Date extractdate) {
		this.extractdate = extractdate;
	}

	public Date getExportdate() {
		return exportdate;
	}

	public void setExportdate(Date exportdate) {
		this.exportdate = exportdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCsnm() {
		return csnm;
	}

	public void setCsnm(String csnm) {
		this.csnm = csnm;
	}

	public String getBkid() {
		return bkid;
	}

	public void setBkid(String bkid) {
		this.bkid = bkid;
	}

	public String getSubbkid() {
		return subbkid;
	}

	public void setSubbkid(String subbkid) {
		this.subbkid = subbkid;
	}

	@Override
	public Object getPrimaryKey() {
		// TODO Auto-generated method stub
		return null;
	}
}
