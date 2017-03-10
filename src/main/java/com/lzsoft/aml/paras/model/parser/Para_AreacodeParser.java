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
import com.lzsoft.aml.paras.model.Para_Areacode;


@ManagedBean
@ApplicationScoped
public class Para_AreacodeParser {
    private List<Para_Areacode> areacodeList;

    @XmlRootElement(name = "areacodes")
    private static final class CountryHolder {
        private List<Para_Areacode> areacodes;
        
        @XmlElement(name = "areacode")
		
		public List<Para_Areacode> getAreacodes() {
			return areacodes;
		}

		@SuppressWarnings("unused")
		public void setAreacodes(List<Para_Areacode> areacodes) {
			this.areacodes = areacodes;
		}
    }
    public synchronized List<Para_Areacode> getAreacodeList() {
        if (areacodeList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource(Constants.AREACODE_PATH);
            
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(CountryHolder.class);
                CountryHolder countryHolder = (CountryHolder) context.createUnmarshaller().unmarshal(resource);
                areacodeList = countryHolder.getAreacodes();
            } catch (JAXBException e) {
            	e.printStackTrace();
                throw new FacesException(e.getMessage(), e);
            }
        }

        return areacodeList;
    }
}
