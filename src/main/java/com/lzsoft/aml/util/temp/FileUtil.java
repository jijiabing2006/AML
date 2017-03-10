package com.lzsoft.aml.util.temp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.io.FileUtils;


public class FileUtil {

	public static Map<String, String> getMapByPorpFile(String filePath) throws ConfigurationException{

		Configuration config;
		config = new PropertiesConfiguration(filePath);
		Iterator<String> iter = config.getKeys();

		Map<String, String> map = new HashMap<String, String>();

		while (iter.hasNext()) {

			String key = iter.next().toString();

			map.put(key, config.getString(key));

		}
		return map;

	}


	public static boolean newFolder(String folderPath) throws Exception {
		try {
			String splitStr = "";
			if (folderPath.indexOf("/") != -1)
				splitStr = "/";
			else
				splitStr = "\\";
			StringTokenizer st = new StringTokenizer(folderPath, splitStr);
			String folder = st.nextToken() + splitStr;
			String subFolder = folder;
			while (st.hasMoreTokens()) {
				folder = st.nextToken() + splitStr;
				subFolder += folder;
				File myFilePath = new File(subFolder);
				if (!myFilePath.exists())
					myFilePath.mkdir();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


	public static boolean delDir(String path) throws Exception {
		boolean bIsSuccess = false;
		File dir = new File(path);
		if (dir.exists()) {
			File[] tmp = dir.listFiles();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].isDirectory()) {
					delDir(path + "/" + tmp[i].getName());
				} else {
					tmp[i].delete();
				}
			}
			bIsSuccess = dir.delete();
		} else {
			bIsSuccess = false;
		}
		return bIsSuccess;
	}

	public static boolean deleteDir(String path) throws Exception {
		boolean bIsSuccess = false;
		File dir = new File(path);
		if (dir.exists()) {
			File[] tmp = dir.listFiles();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].isDirectory()) {
					delDir(path + "/" + tmp[i].getName());
				} else {
					tmp[i].delete();
				}
			}
		} else {
			bIsSuccess = false;
		}
		return bIsSuccess;
	}

	public static List<File> getFiles(File file, String pattern) {

		File[] files = null;

		List<File> result = new ArrayList<File>();

		if (file.isDirectory()) {
			files = file.listFiles();
			if (null != files && files.length != 0) {
				for (int i = 0; i < files.length; i++) {
					File f = files[i];
					if (pattern.equals("")) {
						result.add(f);
					} else {
						if (f.getPath().indexOf("复件") == -1
								&& f.getPath().substring(
										f.getPath().lastIndexOf(".") + 1)
										.equalsIgnoreCase(pattern))
							result.add(f);
					}
				}
			}
		}

		return result;

	}
	
	public static boolean isExists(String filePath,boolean flag){
		File file=new File(filePath);
		if(file.exists()){
			if(flag){
				if(file.isDirectory())
					return true;
				else
					return false;
			}
			return true;
		}else{
			return false;
		}
	}

	public static boolean copyDirectory(File sourceDir, File destDir) throws IOException {
		try {
			FileUtils.copyDirectory(sourceDir, destDir);
		} catch (IOException e) {
			throw e;
		}
		return true;
	}
}
