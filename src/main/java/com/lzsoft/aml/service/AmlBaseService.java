package com.lzsoft.aml.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.entity.base.BaseEO;
import com.lzsoft.aml.entity.model.Reportindex;
import com.lzsoft.aml.entity.model.TaskSchedule;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.util.FileUtil;

public class AmlBaseService extends BaseService {

	protected String amlXmlPath = getRootPath()
			+ Constants.AMLBIGAMOUNTXMLPATHNAME;
	protected String amlZipPath = getRootPath()
			+ Constants.AMLBIGAMOUNTZIPPATHNAME;
	protected String amlExclePath = excelExportPath;

	protected void clearAmlFolder() throws Exception, IOException {
		FileUtil.delDir(amlXmlPath.replaceAll("/", "\\\\"));
		FileUtil.newFolder(amlXmlPath.replaceAll("/", "\\\\"));
		FileUtils.cleanDirectory(new File(amlXmlPath.replaceAll("/", "\\\\")));
		FileUtil.newFolder(amlZipPath.replaceAll("/", "\\\\"));
		FileUtils.cleanDirectory(new File(amlZipPath.replaceAll("/", "\\\\")));
		
		FileUtil.delDir(amlExclePath.replaceAll("/", "\\\\"));
		FileUtil.newFolder(amlExclePath.replaceAll("/", "\\\\"));
		FileUtils.cleanDirectory(new File(amlExclePath.replaceAll("/", "\\\\")));
	}

	/**
	 * 
	 * @param reporttype 
	 * @param apptype 
	 * @param class 实体类
	 * @param querybean
	 *            查询类
	 * @param reportindex
	 *            报表序列类
	 */
	protected String getZipindex(String bkid, String subbkid, String apptype, String reporttype) {
		int size = getAmlReportIndexSize(bkid, subbkid,apptype,reporttype);
		if(size>0){
		return getNextIndex(String.valueOf(size));
		}
		return "0001";
	}

	protected int getAmlReportIndexSize(String bkid, String subbkid,String apptype, String reporttype) {
		String wheresql = "";
		Object[] paramter = null;
		wheresql = " bkid=? and subbkid=? and importdate=? and apptype =? and reporttype=?";
		paramter = new Object[] { bkid, subbkid, 
				DateUtil.getCurrentDate("yyyy-MM-dd"),  "AML","BH"  };
		List<Reportindex> list = dao.queryByWhere(Reportindex.class, wheresql,
				paramter);
		int size=0;
		if (null != list && !list.isEmpty()){
			size=list.size();
			
		}
		return size;
	}

	protected String getNextIndex(String reportIndex) {
		if (null != reportIndex && !"".equals(reportIndex)) {
			int index = Integer.parseInt(reportIndex);
			int nextIndex = index + 10001;
			return String.valueOf(nextIndex).substring(1);
		}
		return "0001";
	}

	protected String getAMLFileName(String reporttype, String amlbankcode,
			String fileType, String zipbatch, String xmlbatch, String nowdates,
			String oldfilename) {

		// 正常报文N 补报报文A 纠错报文C 删除报文D
		if (StringUtils.equals("N", fileType)
				|| StringUtils.equals("A", fileType)
				|| StringUtils.equals("C", fileType)
				|| StringUtils.equals("D", fileType)) {
			if ("BS".equals(reporttype) && "D".equals(fileType)) {
				return "BS hasn't Delete file";
			}
			return fileType + reporttype + amlbankcode + "-" + nowdates + "-"
					+ zipbatch + "-" + xmlbatch + ".XML";
		}
		// 重发报文R 补正报文 I
		if (StringUtils.equals("R", fileType)
				|| StringUtils.equals("I", fileType)) {
			return fileType + StringUtils.substring(oldfilename, 1) + ".XML";
		}

		return null;

	}

	protected String getZipName(String reporttype, String amlbankcode,
			String exporttype, String zipbatch) {

		// 正常报文N 补报报文A 纠错报文C 删除报文D 重发报文R 补正报文 I
		if ("BS".equals(reporttype) && "D".equals(exporttype)) {
			return "BS hasn't Delete file";
		}
		String nowdates = DateUtil.getCurrDate("yyyyMMdd");
		if ("N".equals(exporttype)) {
			return exporttype + reporttype + amlbankcode + "-" + nowdates + "-"
					+ zipbatch + ".ZIP";
		} else {
			return "S" + reporttype + amlbankcode + "-" + nowdates + "-"
					+ zipbatch + ".ZIP";
		}
	}

	protected void addTashSchdule(Date exportdate, String bkid, String subbkid,
			String type) {
		TaskSchedule ts = new TaskSchedule();
		ts.setImportdate(exportdate);
		ts.setBkid(bkid);
		ts.setSubbkid(subbkid);
		ts.setExecutable(true);
		ts.setTaskdesc(type + "Waitting Feedback");
		ts.setTaskname(type.toLowerCase() + "WF");
		dao.deleteByWhere(TaskSchedule.class,
				"importdate=? and bkid=? and subbkid=?", new Object[] {
						exportdate, bkid, subbkid });
		dao.save(ts);
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

	protected <T extends BaseEO> void saveAll(List<T> entitys) {
		dao.saveAll(entitys);
	}
	protected <T extends BaseEO> void save(T entity) {
		dao.save(entity);
	}

	protected void saveReportIndex(Reportindex reportindex) {
		dao.update(reportindex);
	}

}