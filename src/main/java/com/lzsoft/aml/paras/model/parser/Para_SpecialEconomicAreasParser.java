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
import com.lzsoft.aml.paras.model.Para_SpecialEconomicAreas;


@ManagedBean
@ApplicationScoped
public class Para_SpecialEconomicAreasParser {
    private List<Para_SpecialEconomicAreas> seasList;

    @XmlRootElement(name = "areas")
    private static final class SeasHolder {
        private List<Para_SpecialEconomicAreas> areas;
        
        @XmlElement(name = "area")
		public List<Para_SpecialEconomicAreas> getAreas() {
			return areas;
		}

		@SuppressWarnings("unused")
		public void setAreas(List<Para_SpecialEconomicAreas> areas) {
			this.areas = areas;
		}
      
    }

    public synchronized List<Para_SpecialEconomicAreas> getSeasList() {
        if (seasList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource(Constants.SPECIAL_ECONOMAIC_AREA_PATH);
            
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(SeasHolder.class);
                SeasHolder areaHolder = (SeasHolder) context.createUnmarshaller().unmarshal(resource);
                seasList = areaHolder.getAreas();
            } catch (JAXBException e) {
            	e.printStackTrace();
                throw new FacesException(e.getMessage(), e);
            }
        }

        return seasList;
    }
}
