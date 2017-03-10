package com.lzsoft.aml.service.aml.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lzsoft.aml.entity.model.AmlPaymethod;
import com.lzsoft.aml.service.BaseService;


@ManagedBean
@SessionScoped
public class AmlPaymethodService extends BaseService{
	
    private List<AmlPaymethod> amlPaymethodList;

    public synchronized List<AmlPaymethod> getAmlPaymethodList() throws Exception {
        if (amlPaymethodList == null) {
          return   dao.queryByWhere(AmlPaymethod.class, "1=1 order by id");
        }

        return amlPaymethodList;
    }

	public void setAmlPaymethodList(List<AmlPaymethod> amlPaymethodList) {
		this.amlPaymethodList = amlPaymethodList;
	}
   
}
