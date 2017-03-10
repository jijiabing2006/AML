package com.lzsoft.aml.autoexecute.commons;

import java.io.File;

public class Constants {

	public static final String DATEFORMAT = "yyyy-MM-dd";

	public static final String HQBANKCODE = "000000";


	public static final int DEFAULT_CCY_LENGTH = 3;

	
	public static final String DATEFORMAT_YYYYMMDD = "yyyyMMdd";

	public static final String[] DATEFORMATS = { DATEFORMAT,
			DATEFORMAT_YYYYMMDD };
	
	public static final String ROOT_PATH = null;

	public static final int NUM_ZERO = 0;

	public static final int SUBSTRING_FIRST_INDEX = 0;

	public static final int NUM_ONE = 1;

	/**
	 * 日期类型
	 */
	public static final String JAVA_DATE_TYPE = "java.util.Date";
	/**
	 * 数字类型
	 */
	public static final String JAVA_DOUBLE_TYPE = "java.lang.Double";
	/**
	 * 数字类型
	 */
	public static final String JAVA_BIGDECIMAL_TYPE = "java.math.BigDecimal";

	public static final String DATA_FILES_PATH = "config"+File.separator+"importdata"+File.separator+"filepath.properties";

	public static final String AUDITIMPORT_PATH = "config"+File.separator+"importdata"+File.separator+"etlmapping.properties";

	/**
	 * 
	 */

	public static final String ACCOUNTTYPEPATH =  "config"+File.separator+"accounttype"+File.separator+"accounttype.properties";

	public static final String AML_RULE_PATH = "config"+File.separator+"aml"+File.separator+"rules-config.xml";

	
}
