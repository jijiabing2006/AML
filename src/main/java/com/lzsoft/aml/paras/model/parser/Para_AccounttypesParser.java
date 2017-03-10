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
import com.lzsoft.aml.paras.model.Para_Accountttype;


@ManagedBean
@ApplicationScoped
public class Para_AccounttypesParser {
    private List<Para_Accountttype> accounttypesList;

    @XmlRootElement(name = "accounttypes")
    private static final class AccounttypesHolder {
        private List<Para_Accountttype> accounttypes;

        @XmlElement(name = "accounttype")
        public List<Para_Accountttype> getAccounttypes() {
            return accounttypes;
        }

        @SuppressWarnings("unused")
        public void setAccounttypes(List<Para_Accountttype> accounttypes) {
            this.accounttypes = accounttypes;
        }
    }

    public synchronized List<Para_Accountttype> getAccounttypesList() {
        if (accounttypesList == null) {
            ClassLoader ccl = Thread.currentThread().getContextClassLoader();
            URL resource = ccl.getResource(Constants.ACCOUNTTYPE_PATH);
            
            JAXBContext context;
            try {
                context = JAXBContext.newInstance(AccounttypesHolder.class);
                AccounttypesHolder accounttypesHolder = (AccounttypesHolder) context.createUnmarshaller().unmarshal(resource);
                accounttypesList = accounttypesHolder.getAccounttypes();
            } catch (JAXBException e) {
            	e.printStackTrace();
                throw new FacesException(e.getMessage(), e);
            }
        }

        return accounttypesList;
    }
}
