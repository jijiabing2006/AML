package com.lzsoft.aml.service.aml;

import java.util.Date;
import java.util.List;

import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.Download;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.AmlQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface IAmlReportService {




	public String extractAmlReport(Date reportdate,String bkid,String subbkid) throws ManagerException,
			Exception ;

	public int exportAmlBigAmountReport(List<AmlBigAmount> amlbigs, String type,
			Download download, UserInfo user) throws Exception;


	public void addTashSchdule(AmlQueryBean querybean, UserInfo user)throws ManagerException, Exception;

	public List<AmlBigAmount> getAmlBigamountByDate(Date reportdate)throws Exception;
	
	public List<AmlBigAmount> getAmlBigamountByDate(AmlQueryBean querybean,String type)throws Exception;
	public List<AmlBigAmount> getAmlBigamountByDate(AmlQueryBean querybean)throws Exception;

	public String saveReportIndex(UserInfo user);

	public String export2Excle(List<AmlBigAmount> amlbigs, String userid) throws Exception;



}
