package com.lzsoft.aml.paras.model.parser;

import java.net.URL;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.lzsoft.aml.paras.common.Constants;
import com.lzsoft.aml.paras.model.Para_Currency;


@ManagedBean
@ApplicationScoped
public class Para_CurrencyParser {
    private List<Para_Currency> currencyList;

    @XmlRootElement(name = "currencys")
    private static final class CurrencyHolder {
        private List<Para_Currency> currencys;

        @XmlElement(name = "currency")
        public List<Para_Currency> getCurrencys() {
            return currencys;
        }
        @SuppressWarnings("unused")
		public void setCurrencys(List<Para_Currency> currencys) {
			this.currencys = currencys;
		}
    }

    public synchronized List<Para_Currency> getCurrencyList() {
        if (currencyList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource(Constants.CURRENCY_PATH);
            
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(CurrencyHolder.class);
                CurrencyHolder currencyHolder = (CurrencyHolder) context.createUnmarshaller().unmarshal(resource);
                currencyList = currencyHolder.getCurrencys();
            } catch (JAXBException e) {
            	e.printStackTrace();
                throw new FacesException(e.getMessage(), e);
            }
        }

        return currencyList;
    }
}
