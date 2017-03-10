package com.lzsoft.aml.web.aml;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.Amlbase;
import com.lzsoft.aml.entity.model.Download;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.AmlQueryBean;
import com.lzsoft.aml.service.aml.IAmlReportService;
import com.lzsoft.aml.util.temp.DateUtil;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "amlReportBean")
@ViewScoped
public class AmlReportBean extends BaseBean {

	@ManagedProperty("#{amlQueryBean}")
	private AmlQueryBean querybean;

	@ManagedProperty("#{amlReportService}")
	private IAmlReportService amlReportService;

	@ManagedProperty("#{download}")
	private Download download;

	List<AmlBigAmount> amlbigs = null;

	public boolean exportReport() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
			return false;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("download");
		download.setFlag(false);

		String type = querybean.getType();
		if (null == type || "".equals(type)) {
			addWorningMessage("exportform", "上报文件类型不能为空.", false, 1);
			return false;
		}
		Date reportdate = querybean.getExportdate();
		if (null == reportdate || "".equalsIgnoreCase(reportdate.toString())) {
			addWorningMessage("exportform", "请选择要导出上报数据的日期.", false, 1);
			return false;
		}
		try {

			List<AmlBigAmount> amlbigs = amlReportService
					.getAmlBigamountByDate(reportdate);

			if (amlbigs.isEmpty()) {
				addWorningMessage("exportform",
						DateUtil.dateToStr(reportdate, "yyyy-MM-dd")
								+ "没有可上报数据.", false, 1);
				return false;
			}

			boolean flag = checkAmlBigs(amlbigs, type);
			if (!flag) {

				// String type = FacesContext.getCurrentInstance()
				// .getExternalContext().getRequestParameterMap()
				// .get("type");

				// 2 预校验完成，上报内容有错误 1 预校验完成，上报内容正确 3 预校验发生异常 0无数据
				int result = amlReportService.exportAmlBigAmountReport(amlbigs,
						type, download, user);
				setWorningMessage(result);

				type = "";

			}
		} catch (Exception e) {
			addWorningMessage("exportform", "生成AML上报文件失败." + e.getMessage(),
					false, 2);
			log.error("生成AML上报文件失败.", e);
		}
		return true;

	}

	public boolean updateReportIndex() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
			return false;
		}

		try {

			String result = amlReportService.saveReportIndex(user);
			addWorningMessage("exportform", result, false, 0);

		} catch (Exception e) {
			addWorningMessage("exportform", "确认AML上报状态失败." + e.getMessage(),
					false, 2);
			log.error("确认AML上报状态失败.", e);
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("download");
		download.setFlag(false);
		return true;

	}

	private void setWorningMessage(int result) {
		if (1 == result) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("download", download);
			addWorningMessage("exportform", "大额上报文件已经生成，请下载后上报。", false, 0);

		} else if (2 == result) {
			FacesContext.getCurrentInstance().getExternalContext()
					.getSessionMap().put("download", download);
			addWorningMessage("exportform", "预校验不通过，请查看反馈后重新导出上报。", false, 2);

		} else if (3 == result) {
			addWorningMessage("exportform",
					"所选重发/补正数据，原上报日期并非同一天。，请重新选择数据再导出上报。", false, 2);
		} else if (4 == result) {
			addWorningMessage("exportform", "所选重发/补正数据，并非全部上报过。请重新选择数据再导出上报。",
					false, 2);
		}
	}

	protected boolean checkAmlBigs(List<AmlBigAmount> amlbigs, String type) {
		boolean flag = false;
		int i = 0;
		for (Amlbase amlBigAmount : amlbigs) {
			if (!"1".equals(amlBigAmount.getIsedit())) {
				addWorningMessage("exportform",
						"银行业务编号" + amlBigAmount.getTicd() + "没有完成编辑，不能导出上报文件.",
						false, 1);
				flag = true;
				break;
			}

			if (!"1".equals(amlBigAmount.getIsvalidation())) {
				addWorningMessage("exportform",
						"银行业务编号" + amlBigAmount.getTicd() + "没有完成审核，不能导出上报文件.",
						false, 1);
				flag = true;
				break;
			}
			if (StringUtils.equals("R", type) || StringUtils.equals("I", type)) {
				if (!"1".equals(amlBigAmount.getIsexport())) {
					addWorningMessage("exportform",
							"银行业务编号" + amlBigAmount.getTicd()
									+ "选择重发或补正报文，数据必须已经导出过.", false, 1);
					flag = true;
					break;
				}
			} else if (StringUtils.equals("A", type)) {
				if ("1".equals(amlBigAmount.getIsexport())) {
					i++;
				}
				if (i == amlbigs.size()) {
					addWorningMessage(
							"exportform",
							DateUtil.dateToStr(amlBigAmount.getImportdate(),
									"yyyyMMdd") + "下的记录已经全部导出过，没有大额记录可以补报.",
							false, 1);
					flag = true;
					break;
				}

			} else {
				if ("1".equals(amlBigAmount.getIsexport())) {
					addWorningMessage("exportform",
							"银行业务编号" + amlBigAmount.getTicd()
									+ "已经上报过，(除重发或补正外)不能再次导出.", false, 1);
					flag = true;
					break;
				}
			}

		}
		return flag;
	}

	@SuppressWarnings("unused")
	private void updateIsexportStatus(String message, Date reportdate,
			String[] allTypeList) throws Exception {
		// String tfilename = StringUtils.substringBetween(
		// StringUtils.substringAfter(message, "]"), "[", "]");
		// String updatemessage = amlReportService.updateAMLStatus(allTypeList,
		// tfilename, reportdate);
		// if (updatemessage.length() > 1) {
		// addWorningMessage("exportform", updatemessage, false, 1);
		// }
	}

	public boolean extractAmlData() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
			return false;
		}
		Date reportdate = querybean.getExtractdate();
		if (null == reportdate || "".equalsIgnoreCase(reportdate.toString())) {
			addWorningMessage("exportform", "请选择要提取上报数据的日期.", false, 1);
			return false;
		}
		try {
			String message = this.amlReportService.extractAmlReport(reportdate,
					user.getBkid(), user.getSubbkid());

			addWorningMessage("exportform", message, false, 0);

		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("exportform", "提取AML失败." + e.getMessage(), false,
					2);
			log.error("提取AML失败.", e);
		}

		return true;
	}

	public void reset() {
		try {
			reset(querybean);
		} catch (Exception e) {
			addWorningMessage("", "reseterror", true, 2);
			addWorningMessage("", e.getMessage(), false, 2);
			log.error("reseterror", e);
		}
	}

	public boolean getAmlBigAmounts() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
			return false;
		}
		Date importdateStart = querybean.getImportdateStart();
		Date importdateEnd = querybean.getImportdateEnd();

		if ((null == importdateStart && null == importdateEnd)
				|| ("".equalsIgnoreCase(importdateStart.toString()) && ""
						.equalsIgnoreCase(importdateEnd.toString()))) {
			addWorningMessage("exportform", "请选择要导出数据的开始和结束日期.", false, 1);
			return false;
		}

		String type = querybean.getType();
		querybean.setType(null);
		try {
			if (null == type || "".equals(type)) {
				addWorningMessage("exportform", "导出类型不能为空.", false, 1);
				return false;
			} else if (!"9".equals(type)) {
				amlbigs = amlReportService.getAmlBigamountByDate(querybean,
						type);

			} else {
				amlbigs = amlReportService.getAmlBigamountByDate(querybean);
			}
		} catch (Exception e) {
			addWorningMessage("exportform", "生成反洗钱Excel文件失败." + e.getMessage(),
					false, 2);
			e.printStackTrace();
			log.error("生成AML上报文件失败.", e);
		}
		if (amlbigs.isEmpty()) {
			addWorningMessage("exportform",
					DateUtil.dateToStr(importdateStart, "yyyy-MM-dd") + "到"
							+ DateUtil.dateToStr(importdateEnd, "yyyy-MM-dd")
							+ "没有可数据可以导出.", false, 1);
			return false;
		}
		return true;
	}

	public boolean exportReportExcel() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
			return false;
		}
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove("download");
		download.setFlag(false);
		if (null == amlbigs) {
			boolean f = getAmlBigAmounts();
			if (!f) {
				return false;
			}
		}

		try {
			String downloadfile = amlReportService.export2Excle(amlbigs,
					user.getUserid());
			download.setFileName(downloadfile);
			download.setFileDesc("AML Excel Export");
			download.setAbsolutePath(true);
			download.setFlag(true);
			addWorningMessage("exportform", "反洗钱Excel文件已经生成.", false, 0);
		} catch (Exception e) {
			addWorningMessage("exportform", "生成反洗钱Excel文件失败." + e.getMessage(),
					false, 2);
			e.printStackTrace();
			log.error("生成AML上报文件失败.", e);
		}
		return true;
	}

	public AmlQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(AmlQueryBean querybean) {
		this.querybean = querybean;
	}

	public IAmlReportService getAmlReportService() {
		return amlReportService;
	}

	public void setAmlReportService(IAmlReportService amlReportService) {
		this.amlReportService = amlReportService;
	}

	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

	public List<AmlBigAmount> getAmlbigs() {
		getAmlBigAmounts();
		return amlbigs;
	}

	public void setAmlbigs(List<AmlBigAmount> amlbigs) {
		this.amlbigs = amlbigs;
	}

}
