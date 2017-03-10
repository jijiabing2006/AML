package com.lzsoft.aml.common;

import java.io.File;

/**
 * 
 * @author Lawrence
 * 
 */

public class Constants {

	/**
	 * WEB name
	 */
	public static final String WEB_NAME = "AML";
	/**
	 * 总行的代码引用
	 */
	public static final String HQBANKCODE = "000000";

	/**
	 * 资源或状态不可用的标志
	 */
	public static final String NOTENABLE = "0";

	/**
	 * 登陆界面的跳转字符串
	 */
	public static final String LOGIN = "/login.jsf";
	/**
	 * 登陆界面的跳转字符串
	 */
	public static final String AUTO_LOGIN = "/autologin.jsf";

	/**
	 * 主界面跳转 "/ui/index"
	 */
	public static final String FORWRD_MAIN = "/ui/index.jsf";

	/**
	 * 数据库编码配置文件路径
	 */
	public static final String CHARSETCONFIGFILEPATH = "config"
			+ File.separator + "charsetConfig.properties";
	/**
	 * 数据库编码属性的Key
	 */
	public static final String DBCHARSET = "databaseCharset";

	/**
	 * 页面编码属性的Key
	 */
	public static final String PAGECHARSET = "pageCharset";

	/**
	 * ACC报表路径
	 */
	public static final String ACCXMLPATHNAME = "report" + File.separator
			+ "acc" + File.separator + "output" + File.separator + "xml"
			+ File.separator;
	/**
	 * BOP报表路径
	 */
	public static final String BOPXMLPATHNAME = "report" + File.separator
			+ "bop" + File.separator + "output" + File.separator + "xml"
			+ File.separator;
	/**
	 * JSH报表路径
	 */
	public static final String JSHXMLPATHNAME = "report" + File.separator
			+ "jsh" + File.separator + "output" + File.separator + "xml"
			+ File.separator;
	/**
	 * AML报表路径
	 */
	public static final String AMLBIGAMOUNTXMLPATHNAME = "report"
			+ File.separator + "aml" + File.separator + "bigamount"
			+ File.separator + "output" + File.separator + "xml"
			+ File.separator;
	/**
	 * ACC报表路径
	 */
	public static final String ACCZIPPATHNAME = "report" + File.separator
			+ "acc" + File.separator + "output" + File.separator + "zip"
			+ File.separator;
	/**
	 * BOP报表路径
	 */
	public static final String BOPZIPPATHNAME = "report" + File.separator
			+ "bop" + File.separator + "output" + File.separator + "zip"
			+ File.separator;
	/**
	 * JSH报表路径
	 */
	public static final String JSHZIPPATHNAME = "report" + File.separator
			+ "jsh" + File.separator + "output" + File.separator + "zip"
			+ File.separator;
	/**
	 * AML报表路径
	 */
	public static final String AMLBIGAMOUNTZIPPATHNAME = "report"
			+ File.separator + "aml" + File.separator + "bigamount"
			+ File.separator + "output" + File.separator + "zip"
			+ File.separator;

	/**
	 * ACC令牌文件目录
	 */
	public static final String ACCTOKENFILEPATH = "report" + File.separator
			+ "acc" + File.separator + "output" + File.separator + "token"
			+ File.separator;
	/**
	 * BOP令牌文件目录
	 */
	public static final String BOPTOKENFILEPATH = "report" + File.separator
			+ "bop" + File.separator + "output" + File.separator + "token"
			+ File.separator;
	/**
	 * JSH令牌文件目录
	 */
	public static final String JSHTOKENFILEPATH = "report" + File.separator
			+ "jsh" + File.separator + "output" + File.separator + "token"
			+ File.separator;

	/**
	 * ACC报送文件目录
	 */
	public static final String ACCRENDERPATH = "report" + File.separator
			+ "acc" + File.separator + "output" + File.separator + "render"
			+ File.separator;
	/**
	 * BOP报送文件目录
	 */
	public static final String BOPRENDERPATH = "report" + File.separator
			+ "bop" + File.separator + "output" + File.separator + "render"
			+ File.separator;
	/**
	 * JSH报送文件目录
	 */
	public static final String JSHRENDERPATH = "report" + File.separator
			+ "jsh" + File.separator + "output" + File.separator + "render"
			+ File.separator;

	/**
	 * 存款/贷款数据报表模板路径
	 */
	public static final String 	AOPERFORMANCEMANAGERMENT_TEMPLATE_PATHNAME = "report"
			+ File.separator + "template" + File.separator + "marketing"
			+ File.separator + "performance" + File.separator;
	
	/**
	 * 人民币存款数据报表模板路径
	 */
	public static final String 	PISA_REPORT_TEMPLATE_PATHNAME = "report"
			+ File.separator + "template" + File.separator + "drdp"+ File.separator;
	/**
	 * 存款/贷款数据报表路径
	 */
	public static final String 	AOPERFORMANCEMANAGERMENT_REPORT_PATHNAME =  "report"
			+ File.separator + "marketing"	+ File.separator + "performance" + File.separator;
	
	
	/**
	 * 数据导出到Excel，Excel文件存放的路径
	 */
	public static final String EXCEL_FILE_EXPORT="report"+ File.separator+"excelfile"+ File.separator;
	public static final int EXCEL_EXPORT_LINES =10000;
	
	public static final String 	AO_MONTH_REPORT_NAME =  "Performance.xlsx" ;
	public static final String 	AO_SHMONTH_REPORT_NAME =  "Performance_shm.xlsx" ;
	public static final String 	AO_SHDAILY_REPORT_NAME =  "Performance_daily.xlsx" ;
	
	public static final String 	PISA_MONTH_REPORT_NAME =  "pisa_cscnytr.xlsx" ;
	public static final String DATEFORMAT = "yyyy-MM-dd";

	public static final String ROOT_PATH = null;

	public static final int PWD_EXPIRE_DAYS = 90;
	public static final String BOP_LAST_FOUR = "****";
	public static final String JSH_LAST_FOUR = "****";

	public static final String BOP_RPTNO_DATEFORMAT = "yyMMdd";

	public static final String DEFAULT_PASSWORD = "000000";
	
	public static final String DEFAULT_ROWS = "12";
	public static final String AML_XMLFILE_DEFALUT_INDEX = "0001";
	public static final String eMAIL_IMAGE = "images"+ File.separator;;
	public static final String eMAIL_HOST = "10.128.2.37";
	public static final int eMAIL_PORT = 25;
	public static final String eMAIL_FROM = "MTS@cathaybk.com.cn";
	
	public static final String DATA_FILES_PATH = "config" + File.separator
			+ "importdata" + File.separator + "filepath.properties";
	
	public static final int DEFAULT_SCALE = 8;
}
