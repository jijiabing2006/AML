package com.lzsoft.aml.web.systemmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.apache.commons.lang.StringUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.service.systemmanager.IDownloadService;
import com.lzsoft.aml.util.temp.DateUtil;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean
@RequestScoped
public class DownloadManagerBean extends BaseBean {
	private StreamedContent file;
	private StreamedContent suspiciousfile;
	Date importdate;
	String type;
	@ManagedProperty("#{downloadService}")
	private IDownloadService service;
	InputStream stream = null;
	String path = null;

	public StreamedContent getSuspiciousfile() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);

		} else {
			try {
				path = this.service.download("Sus", importdate,user.getUserid());
				if (null != path && !"".equals(path)) {

					stream = new FileInputStream(path);

					suspiciousfile = new DefaultStreamedContent(stream,
							"DOS/PC - Pkzipped archive","Downdate-"+ StringUtils.substringAfterLast(path, File.separator));
					addWorningMessage("exportform",
							"下载[" + DateUtil.dateToStr(importdate, "yyyyMMdd")
									+ "]文件完成", false, 0);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				addWorningMessage("exportform", "下载文件失败." + e.getMessage(),
						false, 2);
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("exportform", "下载文件失败." + e.getMessage(),
						false, 2);
			}

		}
		if (null == suspiciousfile) {
			addWorningMessage("exportform", "无可下载文件，请与上海分行确认是否还未提取.", false, 1);
			return null;
		}
		return suspiciousfile;
	

	}

	public StreamedContent getFile() {
		UserInfo user = getUsersInSession();
		if (null == user) {
			addWorningMessage("exportform", "请登录后再进行操作.", false, 1);

		} else {
			try {
				path = this.service.download(type, importdate,user.getUserid());
				if (null != path && !"".equals(path)) {

					stream = new FileInputStream(path);

					file = new DefaultStreamedContent(stream,
							"DOS/PC - Pkzipped archive", DateUtil.dateToStr(
									importdate, "yyyyMMdd") + ".zip");
					addWorningMessage("exportform",
							"下载[" + DateUtil.dateToStr(importdate, "yyyyMMdd")
									+ "]文件完成", false, 0);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				addWorningMessage("exportform", "下载文件失败." + e.getMessage(),
						false, 2);
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("exportform", "下载文件失败." + e.getMessage(),
						false, 2);
			}

		}
		if (null == file) {
			addWorningMessage("exportform", "没有可下载文件.", false, 1);
			return null;
		}
		return file;
	}

	public void download() {

	}

	public Date getImportdate() {
		return importdate;
	}

	public void setImportdate(Date importdate) {
		this.importdate = importdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IDownloadService getService() {
		return service;
	}

	public void setService(IDownloadService service) {
		this.service = service;
	}

}
