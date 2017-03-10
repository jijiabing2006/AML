package com.lzsoft.aml.paras.managerbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.paras.model.Para_SpecialEconomicAreas;


@ManagedBean
@ApplicationScoped
public class InplaceSelectSpecialEconomicAreasBean {
    @ManagedProperty(value = "#{para_SpecialEconomicAreasParser.seasList}")
    private List<Para_SpecialEconomicAreas> areas;
    private List<SelectItem> areaOptions = null;

    @PostConstruct
    public void init() {
        areaOptions = new ArrayList<SelectItem>();
        for (Para_SpecialEconomicAreas area : areas) {
            areaOptions.add(new SelectItem(area.getCode(), area.getCode()+"-"+area.getCnname()));
        }
    }

	public List<Para_SpecialEconomicAreas> getAreas() {
		return areas;
	}

	public void setAreas(List<Para_SpecialEconomicAreas> areas) {
		this.areas = areas;
	}

	public List<SelectItem> getAreaOptions() {
		return areaOptions;
	}

	public void setAreaOptions(List<SelectItem> areaOptions) {
		this.areaOptions = areaOptions;
	}


}
