package com.lzsoft.aml.autoexecute.service;

import java.util.Date;

import com.lzsoft.aml.autoexecute.service.base.IBaseInterface;
import com.lzsoft.aml.exception.ManagerException;

public interface IExtractService extends IBaseInterface {

	public void execute() throws Exception ;
	public String extractAmlReport(Date reportdate,String bkid,String subbkid) throws ManagerException,
	Exception;
}
