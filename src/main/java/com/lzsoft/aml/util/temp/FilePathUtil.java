package com.lzsoft.aml.util.temp;

import java.io.File;
import java.net.URL;

import org.apache.commons.lang.StringUtils;

public class FilePathUtil {

	public static File getClassFilePath() {
		File targetfile = new File(getClassPath());
		return targetfile;
	}

	public static String getClassPath() {
		URL fileurl = Thread.currentThread().getContextClassLoader()
				.getResource("");
		String targetpath = fileurl.getFile();
		targetpath = targetpath.substring(1);
		targetpath = StringUtils.replace(targetpath, "\\", File.separator);
		targetpath = StringUtils.replace(targetpath, "/", File.separator);
		return targetpath;
	}

	/**
	 * �õ���Ŀ��Ŀ¼
	 * 
	 * @return
	 */
	public static String getRootPath() {
		String rootPath = Thread.currentThread().getContextClassLoader()
				.getResource("").getFile();
		rootPath = rootPath.substring(1);
		if (rootPath.indexOf("WEB-INF") != -1) {
			rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
		} else if (rootPath.indexOf("bin") != -1) {
			rootPath = rootPath.substring(0, rootPath.indexOf("bin"));
		} else if (rootPath.indexOf("classes") != -1) {
			rootPath = rootPath.substring(0, rootPath.indexOf("classes"));
		}
		return rootPath;
	}
}
