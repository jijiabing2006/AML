package com.lzsoft.aml.service.systemmanager.impl;

import java.io.File;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.NameFileFilter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;

import com.lzsoft.aml.autoexecute.commons.Constants;
import com.lzsoft.aml.entity.model.Download;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IDownloadService;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.util.ZipUtil;

@ManagedBean(name = "downloadService")
@ViewScoped
public class DownloadService extends BaseService implements IDownloadService {

	private PropertiesConfiguration pc = null;
	@SuppressWarnings("unused")
	private String filePath = null;
	private String backPath = null;
	@SuppressWarnings("unused")
	private String errorfile = null;
	private String debtfile = null;
	private String suspiciousfile = null;

	@PostConstruct
	public void init()  {
			try {
				pc = new PropertiesConfiguration(Constants.DATA_FILES_PATH);
				filePath = pc.getString("filepath");
				backPath = pc.getString("history");
				errorfile = pc.getString("errorfile");
				suspiciousfile = pc.getString("suspiciousfile");
				debtfile = pc.getString("debtfile");
			} catch (ConfigurationException e) {
				e.printStackTrace();
				saveLogs("", "@PostConstruct", "com.lzsoft.aml.service.systemmanager.impl.DownloadService new PropertiesConfiguration(Constants.DATA_FILES_PATH)发生异常");
			}
			

	}

	@Override
	public int download(String type, Date importdate, Download download)
			throws Exception {

		if (StringUtils.equals("S", type)) {
			return downloadFile(importdate, download);

		} else if (StringUtils.equals("E", type)) {
			// download = downloadDebtFile();
		}
		return 0;
	}

	public int downloadFile(Date importdate, Download download)
			throws Exception {
		File dirfile = new File(backPath);
		NameFileFilter namefilter = new NameFileFilter(DateUtil.dateToStr(
				importdate, "yyyyMMdd"));
		String path = null;
		if (dirfile.exists() || dirfile.isDirectory()) {
			for (File file : dirfile.listFiles()) {
				if (namefilter.accept(file)) {
					path = getRootPath() + "download";
					File pathfile = new File(path);
					FileUtils.forceMkdir(pathfile);
					path += File.separator
							+ DateFormatUtils.format(importdate, "yyyyMMdd")
							+ ".zip";
					ZipUtil.toZipByFolderNoRootFolder(
							dirfile.getAbsolutePath(), path, "");
				}
			}
			if (null != path) {
				File file = new File(path);
				if (file.isFile()) {
					download.setFileName(path + ".zip");
					download.setFileDesc(DateFormatUtils.format(importdate,
							"yyyyMMdd") + ".zip");
					download.setAbsolutePath(true);
					download.setFlag(true);
					return 1;
				}
			} else {
				return -1;
			}
		}
		return 0;
	}

	@Override
	public String download(String type, Date importdate, String userid)
			throws Exception {

		if (StringUtils.equals("S", type)) {
			return downloadFile(importdate);

		} else if (StringUtils.equals("E", type)) {
			return downloadDebtFile(importdate);
		}
		if (StringUtils.equals("Sus", type)) {
			return downloadSusFile(importdate);
		} else if (StringUtils.equals("BigAmount", type)) {
			return downloadBigAmountFile(userid);
		}
		return "";
	}

	private String downloadFile(Date importdate) throws Exception {
		File dirfile = new File(backPath);
		NameFileFilter namefilter = new NameFileFilter(DateUtil.dateToStr(
				importdate, "yyyyMMdd"));
		String path = null;
		if (dirfile.exists() || dirfile.isDirectory()) {
			for (File file : dirfile.listFiles()) {
				if (namefilter.accept(file)) {
					path = getRootPath() + "download";
					File pathfile = new File(path);
					FileUtils.forceMkdir(pathfile);
					path += File.separator
							+ DateFormatUtils.format(importdate, "yyyyMMdd")
							+ ".zip";
					ZipUtil.toZipByFolderNoRootFolder(
							dirfile.getAbsolutePath(), path, "");

				}
			}

		}
		return path;
	}

	private String downloadDebtFile(Date importdate) throws Exception {
		File dirfile = new File(debtfile);

		String path = null;
		if (dirfile.exists() || dirfile.isDirectory()) {
			path = getRootPath() + "download";
			File pathfile = new File(path);

			FileUtils.forceMkdir(pathfile);
			path += File.separator
					+ DateFormatUtils.format(importdate, "yyyy-MM-dd") + ".zip";
			ZipUtil.toZipByFolderNoRootFolder(dirfile.getAbsolutePath(), path,
					"");

		}
		return path;
	}

	private String downloadSusFile(Date importdate) throws Exception {
		File dirfile = new File(suspiciousfile);

		String path = null;
		if (dirfile.exists() || dirfile.isDirectory()) {
			File[] fs = dirfile.listFiles();

			for (File f : fs) {
				if (DateUtil.isSameDay(DateUtil.strToDate(f.getName(),"yyyyMMddHHmmss"),importdate)) {
					path = getRootPath() + "download";
					File pathfile = new File(path);

					FileUtils.forceMkdir(pathfile);
					path += File.separator
							+ DateFormatUtils.format(new Date(), "yyyyMMdd")
							+ ".zip";
					// ZipUtil.toZipByFolder(dirfile.getAbsolutePath(), path,
					// "");
					ZipUtil.toZipByFolderNoRootFolder(f.getAbsolutePath(), path, "");
					// ZipUtil.toZipBySourcePath(dirfile.getAbsolutePath(),
					// path, "",true);
				}
			}

		}
		return path;
	}

	private String downloadBigAmountFile(String userid) throws Exception {
		File dirfile = new File(
				com.lzsoft.aml.common.Constants.AMLBIGAMOUNTZIPPATHNAME);

		String path = null;
		if (dirfile.exists() || dirfile.isDirectory()) {
			path = getRootPath() + "download" + File.separator + userid
					+ File.separator;
			File pathfile = new File(path);

			FileUtils.forceMkdir(pathfile);
			path += File.separator
					+ DateFormatUtils.format(new Date(), "yyyyMMdd") + ".zip";
			ZipUtil.toZipByFolderNoRootFolder(dirfile.getAbsolutePath(), path,
					"");

		}
		return path;
	}
}
