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
import com.lzsoft.aml.paras.model.Para_SettlementExchangeUsingcode;


@ManagedBean
@ApplicationScoped
public class Para_SettlementExchangeUsingcodeParser {
    private List<Para_SettlementExchangeUsingcode> usingcodeList;

    @XmlRootElement(name = "usingcodes")
    private static final class UsingcodeHolder {
        private List<Para_SettlementExchangeUsingcode> usingcodes;

        @XmlElement(name = "usingcode")
        public List<Para_SettlementExchangeUsingcode> getUsingcodes() {
            return usingcodes;
        }

        @SuppressWarnings("unused")
        public void setUsingcodes(List<Para_SettlementExchangeUsingcode> usingcodes) {
            this.usingcodes = usingcodes;
        }
    }

    public synchronized List<Para_SettlementExchangeUsingcode> getUsingcodeList() {
        if (usingcodeList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource(Constants.SETTLEMENTEXCHANGEUSINGCODE_PATH);
            
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(UsingcodeHolder.class);
                UsingcodeHolder usingcodeHolder = (UsingcodeHolder) context.createUnmarshaller().unmarshal(resource);
                usingcodeList = usingcodeHolder.getUsingcodes();
            } catch (JAXBException e) {
            	e.printStackTrace();
                throw new FacesException(e.getMessage(), e);
            }
        }

        return usingcodeList;
    }
}
