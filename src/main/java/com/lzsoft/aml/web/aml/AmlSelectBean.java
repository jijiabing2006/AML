package com.lzsoft.aml.web.aml;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.entity.model.AmlPaymethod;

@ManagedBean
@ViewScoped
public class AmlSelectBean {
	private List<SelectItem> firstList;
	private List<SelectItem> secondList;
	private List<SelectItem> thirdList;

	@ManagedProperty(value = "#{amlPaymethodService.amlPaymethodList}")
	private List<AmlPaymethod> amlPaymethodList;

	@PostConstruct
	public void init() {
		firstList = new ArrayList<SelectItem>();
		secondList = new ArrayList<SelectItem>();
		thirdList = new ArrayList<SelectItem>();
		for (AmlPaymethod amlpaymethod : amlPaymethodList) {
			if (null != amlpaymethod.getMethodvalue()) {
				SelectItem	item = new SelectItem(amlpaymethod.getMethodvalue(),
						amlpaymethod.getMethodlabel());
				firstList.add(item);
			}
		}
	}

	public void valueChanged(ValueChangeEvent event) {
		if (null != event.getNewValue()) {
			String methodfirst=(String) event.getNewValue();
			initAmlMethodSelect(methodfirst);
		}
	}
   public void initAmlMethodSelect(String methodfirst){
	   secondList.clear();
		thirdList.clear();
		if (null != methodfirst) {
			if (methodfirst.equals("00")) {
				for (AmlPaymethod amlpaymethod : amlPaymethodList) {
                   if(null!=amlpaymethod.getCnymethodvalue()){
                  	 SelectItem item = new SelectItem(amlpaymethod.getCnymethodvalue(),
       						amlpaymethod.getCnymethodlabel());
       				secondList.add(item);
                   }
                   if(null!=amlpaymethod.getCnymethodp2value()){
                   	SelectItem item = new SelectItem(amlpaymethod.getCnymethodp2value(),
                   			amlpaymethod.getCnymethodp2label());
                   	thirdList.add(item);
                   }
				}
			} else if (methodfirst.equals("01")) {
				for (AmlPaymethod amlpaymethod : amlPaymethodList) {
                    if(null!=amlpaymethod.getForeignmethodvalue()){
                   	 SelectItem item = new SelectItem(amlpaymethod.getForeignmethodvalue(),
        						amlpaymethod.getForeignmethodlabel());
        				secondList.add(item);
                    }
				}
			} else if (methodfirst.equals("02")) {
				for (AmlPaymethod amlpaymethod : amlPaymethodList) {
                   if(null!=amlpaymethod.getAgentmethodvalue()){
                  	 SelectItem item = new SelectItem(amlpaymethod.getAgentmethodvalue(),
       						amlpaymethod.getAgentmethodlabel());
       				secondList.add(item);
                   }
				}
			} else if (methodfirst.equals("03")) {
				for (AmlPaymethod amlpaymethod : amlPaymethodList) {
                   if(null!=amlpaymethod.getCrosscurrencymethodvalue()){
                  	 SelectItem item = new SelectItem(amlpaymethod.getCrosscurrencymethodvalue(),
       						amlpaymethod.getCrosscurrencymethodlabel());
//                  	System.out.println(amlpaymethod.getCrosscurrencymethodlabel());
       				secondList.add(item);
                   }
				}
			}
		} 
   }
	public List<SelectItem> getFirstList() {
		return firstList;
	}

	public List<SelectItem> getSecondList() {
		return secondList;
	}

	public List<SelectItem> getThirdList() {
		return thirdList;
	}

	public List<AmlPaymethod> getAmlPaymethodList() {
		return amlPaymethodList;
	}

	public void setAmlPaymethodList(List<AmlPaymethod> amlPaymethodList) {
		this.amlPaymethodList = amlPaymethodList;
	}

}
