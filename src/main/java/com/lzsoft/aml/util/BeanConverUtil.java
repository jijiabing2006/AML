package com.lzsoft.aml.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;

import com.lzsoft.aml.common.Constants;
import com.mysql.jdbc.StringUtils;


/**
 * 
 * @author Lawrence
 *
 */
public class BeanConverUtil {

	/**
	 * 日志记录对象
	 */
	private Logger log = Logger.getLogger(this.getClass());

	private String dbChar;

	private String pageCharset;

	public BeanConverUtil() throws ConfigurationException {
		String rootPath = this.getClass().getResource("/").getPath();
		rootPath = rootPath.substring(1, rootPath.length());
		String filePath = rootPath + Constants.CHARSETCONFIGFILEPATH;
		filePath = filePath.replaceAll("%20", " ");
		dbChar = FileUtil.getMapByPorpFile(filePath).get(Constants.DBCHARSET);
		pageCharset = FileUtil.getMapByPorpFile(filePath).get(Constants.PAGECHARSET);
	}

	public String getDataFormPage(String str) throws UnsupportedEncodingException {
		// if ("gbk".equalsIgnoreCase(pageCharset) || "gb2312".equalsIgnoreCase(pageCharset))
		// pageCharset = "GBK";
		// else
		// pageCharset = "UTF-8";
		pageCharset = "GBK";
		if ("gbk".equalsIgnoreCase(dbChar) || "gb2312".equalsIgnoreCase(dbChar)||"UTF-8".equalsIgnoreCase(dbChar))
			dbChar = "GBK";
		else if("UTF-8".equalsIgnoreCase(dbChar)){
			//dbChar="UTF-8";
			//return str;
			return new String (str.getBytes(),"GBK");
		}
		else
			dbChar = "ISO-8859-1";
		return new String(str.getBytes("GBK"), dbChar);

	}

	public String getDataFormDB(String str) throws UnsupportedEncodingException {
		// if ("gbk".equalsIgnoreCase(pageCharset) ||
		// "gb2312".equalsIgnoreCase(pageCharset))
		// pageCharset = "GBK";
		// else
		// pageCharset = "UTF-8";
		pageCharset = "GBK";
		if ("gbk".equalsIgnoreCase(dbChar) || "GB2312".equalsIgnoreCase(dbChar) )
			dbChar = "GBK";
		else if("UTF-8".equalsIgnoreCase(dbChar)){
			//dbChar="UTF-8";
			//return str;
			return new String (str.getBytes(),"GBK");
		}
		else
			dbChar = "ISO-8859-1";

		String result = new String(str.getBytes(dbChar), pageCharset);
		return result;
	}

	/**
	 * 转换字符编码
	 * 
	 * @param object
	 *            要转换的对象,
	 * @converFlag 转换的类型.一种是从数据库到页面的转换converFlag=false.另一种是从页面到数据库的转换converFlag=true.
	 * @return 转换后的对象
	 * @throws UnsupportedEncodingException
	 *             转换异常
	 */
	public Object converObject(Object object, boolean converFlag) {
		Method[] methods = object.getClass().getMethods();
		String fieldName = null;
		for (Method method : methods) {
			if (method.getName().indexOf("get") >= 0) {
				//fieldName = method.getName().substring(3).toLowerCase();
				//获得当前类底下的字段名,john 2009/08/08
				String temp = method.getName().substring(3);
				fieldName = temp.substring(0,1).toLowerCase()+temp.substring(1);
				if (method.getReturnType().toString().indexOf("java.lang.String") != -1) {
					converStringCharset(object, fieldName, converFlag);
				}
				if (method.getReturnType().toString().indexOf("java.util.Date") != -1) {
					converDate(object, fieldName, converFlag);
				}
			}
		}

		return object;

	}

	/**
	 * 指定对象的属性进行转换字符编码
	 * 
	 * @param object
	 *            要转换的对象,
	 * @converFlag 转换的类型.一种是从数据库到页面的转换converFlag=false.另一种是从页面到数据库的转换converFlag=true.
	 * @param propertyName
	 *            属性名称
	 * @return 转换后的对象
	 * @throws UnsupportedEncodingException
	 *             转换异常
	 */
	public Object converObject(Object object, boolean converFlag, String propertyName) {
		if (StringUtils.isNullOrEmpty(propertyName))
			converObject(object, converFlag);
		Method[] methods = object.getClass().getMethods();
		String fieldName = null;
		for (Method method : methods) {
			if (method.getName().indexOf("get") >= 0) {
				fieldName = method.getName().substring(3).toLowerCase();
				if (propertyName.equalsIgnoreCase(fieldName)) {
					if (method.getReturnType().toString().indexOf("java.lang.String") != -1) {
						converStringCharset(object, fieldName, converFlag);
					}
					if (method.getReturnType().toString().indexOf("java.util.Date") != -1) {
						converDate(object, fieldName, converFlag);
					}
				}

			}
		}

		return object;

	}

	/**
	 * 对日期类型的转换
	 * 
	 * @param object
	 *            POJO类
	 * @param fieldName
	 *            字段
	 * @param converFlag
	 *            转换的类型.一种是从数据库到页面的转换converFlag=false.另一种是从页面到数据库的转换converFlag=true.
	 */
	private void converDate(Object object, String fieldName, boolean converFlag) {
	}

	/**
	 * 对字符串的编码转换
	 * 
	 * @param object
	 *            POJO类
	 * @param fieldName
	 *            字段
	 * @param converFlag
	 *            转换的类型.一种是从数据库到页面的转换converFlag=false.另一种是从页面到数据库的转换converFlag=true.
	 */
	private void converStringCharset(Object object, String fieldName, boolean converFlag) {
		try {
			String str = BeanUtils.getProperty(object, fieldName);
			if (null != str && !"".equalsIgnoreCase(str.trim())) {
				if (converFlag)
					str = getDataFormPage(str);
				else
					str = getDataFormDB(str);
				BeanUtils.setProperty(object, fieldName, str);
			}
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			log
					.error("com.lzsoft.aml.util.BeanConverUtil.converStringCharset(Object object, String fieldName, boolean converFlag)\n"
							+ e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			log
					.error("com.lzsoft.aml.util.BeanConverUtil.converStringCharset(Object object, String fieldName, boolean converFlag)\n"
							+ e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			log
					.error("com.lzsoft.aml.util.BeanConverUtil.converStringCharset(Object object, String fieldName, boolean converFlag)\n"
							+ e.getMessage());
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log
					.error("com.lzsoft.aml.util.BeanConverUtil.converStringCharset(Object object, String fieldName, boolean converFlag)\n"
							+ e.getMessage());
		}

	}

}
