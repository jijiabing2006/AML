package com.lzsoft.aml.util;


public  class Rootpath {
	private static Rootpath rootpath=null;
	
	
	private Rootpath() {
		super();
	}


	public static String getRootPath() {
		if(null==rootpath){
			rootpath=new Rootpath();
		}
		String filePath = null;
		String rootPath =rootpath.getClass().getProtectionDomain()
				.getCodeSource().getLocation().getFile();
		if (rootPath.indexOf("bin") != -1) {
			filePath = rootPath;
		} else if (rootPath.toLowerCase().indexOf(".exe") != -1) {
			filePath = rootPath.substring(0, rootPath.lastIndexOf("/") + 1);
		} else {
			if (rootPath.indexOf("classes") != -1) {
				rootPath = rootPath.substring(0, rootPath.indexOf("classes"));
			}
			if (rootPath.indexOf("WEB-INF") != -1) {
				rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
			}
			filePath = rootPath + "WEB-INF/classes/";
		}
		filePath = filePath.replaceAll("%20", " ");
		return filePath;

	}
	public static String getAppPath() {
		if(null==rootpath){
			rootpath=new Rootpath();
		}
		String rootPath =rootpath.getClass().getProtectionDomain()
				.getCodeSource().getLocation().getFile();
		if (rootPath.indexOf("bin") != -1) {
			
		} else if (rootPath.toLowerCase().indexOf(".exe") != -1) {
			rootPath = rootPath.substring(0, rootPath.lastIndexOf("/") + 1);
		} else {
			if (rootPath.indexOf("classes") != -1) {
				rootPath = rootPath.substring(0, rootPath.indexOf("classes"));
			}
			if (rootPath.indexOf("WEB-INF") != -1) {
				rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
			}
//			filePath = rootPath + "WEB-INF/classes/";
		}
		rootPath = rootPath.replaceAll("%20", " ");
		return rootPath;
		
	}
}
