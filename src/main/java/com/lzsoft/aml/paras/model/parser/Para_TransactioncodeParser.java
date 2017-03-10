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
import com.lzsoft.aml.paras.model.Para_Transactioncode;

@ManagedBean
@ApplicationScoped
public class Para_TransactioncodeParser {
	private List<Para_Transactioncode> transactioncodeList;

	@XmlRootElement(name = "transactioncodes")
	private static final class TransactioncodeHolder {
		private List<Para_Transactioncode> transactioncodes;

		@XmlElement(name = "transactioncode")
		public List<Para_Transactioncode> getTransactioncodes() {
			return transactioncodes;
		}

		@SuppressWarnings("unused")
		public void setTransactioncodes(
				List<Para_Transactioncode> transactioncodes) {
			this.transactioncodes = transactioncodes;
		}

	}

	public synchronized List<Para_Transactioncode> getTransactioncodeList() {
		if (transactioncodeList == null) {
			ClassLoader ccl = Thread.currentThread().getContextClassLoader();
			URL resource = ccl.getResource(Constants.TRANSACTIONCODE_PATH);
			JAXBContext context;
			try {
				context = JAXBContext.newInstance(TransactioncodeHolder.class);
				TransactioncodeHolder transactionHolder = (TransactioncodeHolder) context
						.createUnmarshaller().unmarshal(resource);
				transactioncodeList = transactionHolder.getTransactioncodes();
			} catch (JAXBException e) {
				e.printStackTrace();
				throw new FacesException(e.getMessage(), e);
			}
		}

		return transactioncodeList;
	}
}
