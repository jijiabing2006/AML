package com.lzsoft.aml.service;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedProperty;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.dao.DAO;
import com.lzsoft.aml.entity.base.BaseEO;
import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.Logs;
import com.lzsoft.aml.util.DateUtil;

public class BaseService {
	@ManagedProperty("#{dao}")
	protected DAO dao;
	@ManagedProperty("#{logs}")
	protected Logs logs;

	protected String excelExportPath = getRootPath()
	+ Constants.EXCEL_FILE_EXPORT;
	
	
	public BaseService() {
		super();
	}

	public <T> String generateQuerySql(Object querybean) throws Exception {
		Field[] fields = querybean.getClass().getDeclaredFields();
		StringBuffer sql = new StringBuffer("");
		for (Field field : fields) {
			Object p = PropertyUtils.getProperty(querybean, field.getName());
			if (null != p && !"".equals(p)) {
				if (field.getType().equals(String.class)) {
					if (p.toString().contains("*")) {
						sql.append(field.getName() + " like '")
								.append(p.toString().trim().replace("*", "%"))
								.append("' and ");
					}
					// if (p.toString().startsWith("*")
					// && p.toString().endsWith("*")) {
					// sql.append(field.getName() + " like '%")
					// .append(p.toString().trim().replace("*",
					// "")).append("%' and ");
					// } else if (p.toString().startsWith("*")
					// && !p.toString().endsWith("*")) {
					// sql.append(field.getName() + " like '%")
					// .append(p.toString().trim().replace("*",
					// "")).append("' and ");
					// } else if (!p.toString().startsWith("*")
					// && p.toString().endsWith("*")) {
					// sql.append(field.getName() + " like '")
					// .append(p.toString().trim().replace("*",
					// "")).append("%' and ");
					// }
					else {
						sql.append(field.getName() + "='")
								.append(p.toString().trim()).append("' and ");
					}

				} else if (field.getType().equals(Date.class)) {
					if (field.getName().toLowerCase().indexOf("start") >= 0) {
						sql.append(
								field.getName().toLowerCase()
										.replace("start", "")
										+ ">='")
								.append(DateUtil.dateToStr((Date) p,
										"yyyy-MM-dd")).append("' and ");
					} else if (field.getName().toLowerCase().indexOf("end") >= 0) {
						sql.append(
								field.getName().toLowerCase()
										.replace("end", "")
										+ "<='")
								.append(DateUtil.dateToStr((Date) p,
										"yyyy-MM-dd")).append("' and ");
					} else {
						sql.append(field.getName().toLowerCase() + "='")
								.append(DateUtil.dateToStr((Date) p,
										"yyyy-MM-dd")).append("' and ");
					}
				} else if (field.getType().equals(BigDecimal.class)
						|| field.getType().equals(Double.class)) {
					sql.append(field.getName() + "='")
							.append(p.toString().trim()).append("' and ");
				}
			}
		}
		return StringUtils.substringBeforeLast(sql.toString(), "and");
	}

	/**
	 * 得到根目录
	 * 
	 * @return
	 */
	public String getRootPath() {
		String rootPath = this.getClass().getProtectionDomain().getCodeSource()
				.getLocation().getFile();
		rootPath = rootPath.substring(1);
		if (rootPath.indexOf("WEB-INF") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
		else if (rootPath.indexOf("bin") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("bin"));
		else if (rootPath.indexOf("classes") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("classes"));
		rootPath = rootPath.replaceAll("/", "\\\\");
		return rootPath.replaceAll("%20", " ");
	}

	protected String getPbocBankCode(String bkid, String subbkid) {
		Bankinfo bankinfo = dao.findByWhere(Bankinfo.class,
				"bkid =? and subbkid=?", new Object[] { bkid, subbkid });

		if (null != bankinfo) {
			return bankinfo.getBranchcode();
		}
		return "";
	}
	protected <T extends BaseEO> boolean checkRptnoIsUniqu(T entity,String rptno)
			throws Exception {
		@SuppressWarnings("unchecked")
		List<T> datas=(List<T>) dao.queryByWhere(entity.getClass(), "importdate=? and rptno=?",
				new Object[] { (Date) PropertyUtils.getProperty(entity,
						"importdate"),rptno });
		if(datas.size()==1){
			return true;
		}
		return false;
	}

	protected boolean saveLogs(String userid,String event, String log) {
		logs.setEventdate(DateUtil.getCurrentDate("yyyyMMdd hh:mm:ss"));
		logs.setEvents(event);
		logs.setObjects(log);
		logs.setUserid(userid);
		dao.save(logs);
		return true;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public Logs getLogs() {
		return logs;
	}

	public void setLogs(Logs logs) {
		this.logs = logs;
	}

}