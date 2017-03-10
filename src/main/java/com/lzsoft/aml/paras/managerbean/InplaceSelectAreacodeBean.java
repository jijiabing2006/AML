package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_Areacode;

@ManagedBean
@ApplicationScoped
public class InplaceSelectAreacodeBean {
	@ManagedProperty(value = "#{para_AreacodeParser.areacodeList}")
	private List<Para_Areacode> areacodes;
	private List<SelectItem> areaOptions = null;

	@PostConstruct
	public void init() {
		areaOptions = new ArrayList<SelectItem>();
		for (Para_Areacode area : areacodes) {
			areaOptions.add(new SelectItem(area.getCode(),
					area.getCode() + "-" + area.getName()));
		}
	}

	public List<Para_Areacode> getAreacodes() {
		return areacodes;
	}

	public void setAreacodes(List<Para_Areacode> areacodes) {
		this.areacodes = areacodes;
	}

	public List<SelectItem> getAreaOptions() {
		return areaOptions;
	}

	public void setAreaOptions(List<SelectItem> areaOptions) {
		this.areaOptions = areaOptions;
	}
}
