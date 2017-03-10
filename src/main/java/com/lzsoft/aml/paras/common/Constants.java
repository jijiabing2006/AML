package com.lzsoft.aml.paras.common;

import java.io.File;

/**
 * 
 * @author Lawrence
 * 
 */

public class Constants {
	/**
	 * 账户性质 资源路径
	 */
	public static final String ACCOUNTTYPE_PATH = "config"+ File.separator +"paras" + File.separator
			+ "accounttype" + File.separator + "para_accounttype.xml";
	/**
	 * AML 账户性质 资源路径
	 */
	public static final String AML_ACCOUNTTYPE_PATH = "config"+ File.separator +"paras" + File.separator
			+ "accounttype" + File.separator + "para_aml_accounttype.xml";
	/**
	 * 货币代码 资源路径
	 */
	public static final String CURRENCY_PATH = "config"+ File.separator +"paras" + File.separator
			+ "currencycode" + File.separator + "para_currency.xml";
	/**
	 * 国家代码 资源路径
	 */
	public static final String COUNTRYCODE_PATH = "config"+ File.separator +"paras" + File.separator
			+ "countrycode" + File.separator + "para_countrycode.xml";
	/**
	 * 特殊经济区代码 资源路径
	 */
	public static final String SPECIAL_ECONOMAIC_AREA_PATH ="config"+ File.separator + "paras"
			+ File.separator + "seacode" + File.separator
			+ "para_specialeconomicareas.xml";
	/**
	 * 交易编码 资源路径
	 */
	public static final String TRANSACTIONCODE_PATH = "config"+ File.separator +"paras" + File.separator
			+ "transactioncode" + File.separator + "safe" + File.separator
			+ "para_transactioncode.xml";
	/**
	 * AML交易编码 资源路径
	 */
	public static final String AMLTRANSACTIONCODE_PATH = "config"+ File.separator +"paras"
			+ File.separator + "transactioncode" + File.separator + "aml"
			+ File.separator + "para_transactioncode.xml";

	/**
	 * 结汇用途代码表 资源路径
	 */
	public static final String SETTLEMENTEXCHANGEUSINGCODE_PATH ="config"+ File.separator + "paras"
			+ File.separator + "settlementexchangeusingcode" + File.separator
			+ "para_settlementexchangeusingcode.xml";
	/**
	 * 行政区划代码 资源路径
	 */
	public static final String AREACODE_PATH = "config"+ File.separator +"paras" + File.separator
			+ "areacode" + File.separator + "para_areacode.xml";
}
