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
import com.lzsoft.aml.paras.model.Para_Country;


@ManagedBean
@ApplicationScoped
public class Para_CountryParser {
    private List<Para_Country> countryList;

    @XmlRootElement(name = "countrys")
    private static final class CountryHolder {
        private List<Para_Country> countrys;
        
        @XmlElement(name = "country")
		public List<Para_Country> getCountrys() {
			return countrys;
		}

		@SuppressWarnings("unused")
		public void setCountrys(List<Para_Country> countrys) {
			this.countrys = countrys;
		}
      
    }

    public synchronized List<Para_Country> getCountryList() {
        if (countryList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource(Constants.COUNTRYCODE_PATH);
            
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(CountryHolder.class);
                CountryHolder countryHolder = (CountryHolder) context.createUnmarshaller().unmarshal(resource);
                countryList = countryHolder.getCountrys();
            } catch (JAXBException e) {
            	e.printStackTrace();
                throw new FacesException(e.getMessage(), e);
            }
        }

        return countryList;
    }
}
