package com.lzsoft.aml.autoexecute.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.autoexecute.service.IExtractService;
import com.lzsoft.aml.dao.DAO;
import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.CustBaseEntity;
import com.lzsoft.aml.entity.model.TranDetailEntity;
import com.lzsoft.aml.entity.model.Logs;
import com.lzsoft.aml.entity.model.TaskSchedule;
import com.lzsoft.aml.exception.ManagerException;

public class ExtractServiceImpl implements IExtractService{

	protected static PropertiesConfiguration pc = null;
	protected static String logPath = null;

	@Resource(name = "dao")
	protected DAO dao;

	@Resource(name = "logs")
	protected Logs logs;

	/**
	 * result 1:正常返回 2:没有符合账户性质的外汇账号 3:没有交易数据,也没有开关户数据 4:有交易数据但是没有账户信息
	 * 5:没有与外汇账号关联的主体信息
	 * */
	public void execute() throws Exception {
	}
	public String extractAmlReport(Date reportdate,String bkid,String subbkid) throws ManagerException,
	Exception{
		return null;
		
	}
	protected Bankinfo getBankInfoByBkid(List<Bankinfo> bankinfos, String bkid,
			String subbkid) {
		for (Bankinfo bankinfo : bankinfos) {
			if (bankinfo.getBkid().equals(bkid)
					&& bankinfo.getSubbkid().equals(subbkid)) {
				return bankinfo;
			}

		}
		return null;
	}

	protected List<Bankinfo> getAllBankinfos() {
		return dao.queryByWhere(Bankinfo.class, "", null);
	}

	/**
	 * 提取maximportdate日期下，客户编号在csnms范围内的客户
	 * 
	 * @param maxImportdate
	 * @param csnms
	 * @return
	 */
	protected List<CustBaseEntity> getCustinfos(Date maxImportdate, List<String> csnms) {
		return dao.queryByWhere(CustBaseEntity.class,
				" importdate=? and csnm in (?2)", new Object[] { maxImportdate,
						csnms });
	}

	/**
	 * 根据传入日期，返回taskSchedule
	 * 
	 * @param maxImportdate
	 * @return
	 */
	protected TaskSchedule queryTaskSchedule(Date maxImportdate, String taskname) {
		return dao.findByWhere(TaskSchedule.class,
				" importdate=? and taskname=?", new Object[] { maxImportdate,
						taskname });

	}
	/**
	 * 设置客户类型和客户证件号码
	 * TODO 设置客户类型和客户证件号码
	 * @param obj
	 * @param ifxtran
	 * @param ifxcust
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	protected void setCustypeAndIdnumber(Object obj, TranDetailEntity ifxtran,
			CustBaseEntity ifxcust) throws Exception {
		if (StringUtils.equals("1460", ifxcust.getInstitutioncode())
				|| StringUtils.equals("1461", ifxcust.getInstitutioncode())) {
			PropertyUtils.setProperty(obj, "custype", "D");
			PropertyUtils.setProperty(obj, "idcode", ifxtran.getEncode());
		} else if (StringUtils.equals("1690", ifxcust.getInstitutioncode())
				|| StringUtils.equals("1691", ifxcust.getInstitutioncode())) {
			PropertyUtils.setProperty(obj, "custype", "F");
			PropertyUtils.setProperty(obj, "idcode", ifxtran.getEncode());
		} else {
			PropertyUtils.setProperty(obj, "custype", "C");
			PropertyUtils.setProperty(obj, "custcod", ifxtran.getEncode());
		}
	}
	public Logs getLogs() {
		return logs;
	}

	public void setLogs(Logs logs) {
		this.logs = logs;
	}

	protected Date getMaxImportDate(String taskname) {
		return (Date) dao.getMaxByWhere(TaskSchedule.class, "importdate",
				"taskname=?", new Object[] { taskname });
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
}
