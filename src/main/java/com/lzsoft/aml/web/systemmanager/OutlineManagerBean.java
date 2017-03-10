package com.lzsoft.aml.web.systemmanager;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

import com.lzsoft.aml.entity.model.OutlineAML;
import com.lzsoft.aml.entity.model.OutlineImport;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.OutlineQueryBean;
import com.lzsoft.aml.service.systemmanager.IOutlineService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "outlineMBean")
@ViewScoped
public class OutlineManagerBean extends BaseBean {

	@ManagedProperty("#{outlineQueryBean}")
	private OutlineQueryBean querybean;

	@ManagedProperty("#{outlineService}")
	private IOutlineService outlineService;

	@ManagedProperty("#{outlineImport}")
	private OutlineImport outlineImport;
	@ManagedProperty("#{outlineAml}")
	private OutlineAML outlineAml;

	public void onTabChange(TabChangeEvent event) {
		
		FacesMessage msg = new FacesMessage("Tab Changed", "Active Tab:"
				+ event.getTab().getId());

		FacesContext.getCurrentInstance().addMessage(null, msg);
		getAbstractInfos(event.getTab().getId());
	}
	private boolean getAbstractInfos(String id) {
		
		if ("abstractImport".equals(id)) {
			getOutlineImport();
		} else if ("abstractAcc".equals(id)) {
		} else if ("abstractBop".equals(id)) {
		} else if ("abstractJsh".equals(id)) {
		}
		return true;
		
	}

	public void onTabClose(TabCloseEvent event) {
		FacesMessage msg = new FacesMessage("Tab Closed", "Closed tab: "
				+ event.getTab().getTitle());

		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public OutlineImport getOutlineImport() {
		try {
			
				this.outlineService.getOutlineImport(outlineImport, querybean);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("", "查询数据导入及提取信息时发生异常" + e.getMessage(), false, 3);
		}
		return outlineImport;
	}

	public OutlineAML getOutlineAml() {
		UserInfo user = getUsersInSession();
		if (null!=user) {
			outlineAml=this.outlineService.getOutlineAml(querybean,user);
		}
		return outlineAml;
	}


	public void reset() {
		try {
			reset(querybean);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("", "reseterror", true, 2);
			addWorningMessage("", e.getMessage(), false, 2);
		}
	}
	public OutlineQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(OutlineQueryBean querybean) {
		this.querybean = querybean;
	}

	public IOutlineService getOutlineService() {
		return outlineService;
	}

	public void setOutlineService(IOutlineService outlineService) {
		this.outlineService = outlineService;
	}

	public void setOutlineImport(OutlineImport outlineImport) {
		this.outlineImport = outlineImport;
	}

	public void setOutlineAml(OutlineAML outlineAml) {
		this.outlineAml = outlineAml;
	}

}
