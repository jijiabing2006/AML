package com.lzsoft.aml.util;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
public class StringHelper {

	/**
	 * 判断字符是否为空或NULL
	 * 
	 * @param param
	 *            要检查的字符
	 * @return 是空或NULL返回true，否则返回false;
	 */
	public static boolean isNullOrEmpty(String param) {

		return param == null || "".equals(param.trim());

	}

	/**
	 * 数组转换为字符串
	 * 
	 * @param strArray
	 *            要转换的数组
	 * @return 返回已","间隔的字符串
	 */
	public static String arrayToString(String strArray[]) {

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < strArray.length; i++)

			if ("".equals(buffer.toString()))

				buffer.append(strArray[i]);

			else

				buffer.append((new StringBuilder(",")).append(strArray[i])
						.toString());

		return buffer.toString();

	}

	/**
	 * 字符串转换字符数组一
	 * 
	 * @param str
	 *            要转换的字符串
	 * @param sep_str
	 *            分隔符号
	 * @return 分隔后的字符数组
	 */
	public static String[] stringToArray(String str, String sep_str) {

		StringTokenizer strToken = new StringTokenizer(str, sep_str);

		int tokenCount = strToken.countTokens();

		String str_array[] = new String[tokenCount];

		for (int i = 0; i < tokenCount; i++)

			str_array[i] = strToken.nextToken();

		return str_array;

	}

	/**
	 * 字符串转换字符数组二
	 * 
	 * @param str
	 *            要转换的字符串
	 * @param sep_str
	 *            分隔符号
	 * @return 分隔后的字符数组
	 */
	public static String[] getArrayByStr(String str, String sep_str) {

		if (null == str || null == sep_str)

			return null;

		return str.split(sep_str);

	}

	/**
	 * 校验一个字符是否为NULL
	 * 
	 * @param checkObject
	 *            校验对象
	 * @return 为空返回NULL,否则返回该对象的值
	 */
	public static String checkNull(String checkObject) {

		return null == checkObject || "" == checkObject.trim() ? null
				: checkObject;

	}

	/**
	 * 校验一个字符是否为NULL
	 * 
	 * @param checkObject
	 *            校验对象
	 * @return 为空返回true,否则false
	 */
	public static boolean checkIsNull(String checkObject) {

		return null == checkObject || "".equalsIgnoreCase(checkObject.trim()) ? true
				: false;

	}

	/**
	 * 判断一个字符串是否在一个字符数组中存在
	 * 
	 * @param strArray
	 *            字符数组
	 * @param seaStr
	 *            要判断是否在数组中存在的字符串
	 * @return 存在返回true,两个参数为NULL或数组的长度为0均返回false;
	 */
	public static boolean isInStrArray(String[] strArray, String seaStr) {

		if (null == strArray || null == seaStr || strArray.length == 0) {

			return false;

		}

		for (int i = 0; i < strArray.length; i++) {

			if (strArray[i].equalsIgnoreCase(seaStr))

				return true;

		}

		return false;

	}

	/**
	 * 一个字符串是否是布尔值
	 * 
	 * @param booleanValue
	 * @return
	 */
	public static Boolean isBoolean(String booleanValue) {

		if ("FALSE".equalsIgnoreCase(booleanValue))

			return false;

		if ("TRUE".equalsIgnoreCase(booleanValue))

			return true;

		return null;

	}

	/**
	 * 将MAP的KEY已字符串的形式返回
	 * 
	 * @param map
	 * @param spiltchar
	 *            分隔字符串的字符
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getStringByMap(Map map, String spiltchar) {
		if (null == map || map.isEmpty())
			return null;
		Set keys = map.keySet();
		StringBuffer strBuf = new StringBuffer();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			strBuf.append("'" + iter.next() + "'" + spiltchar);
		}
		return strBuf.substring(0, strBuf.length() - 1);
	}

	public static String ISO2GBK(String s) {
		String result = s;
		if (s == null)
			return "";
		try {
			result = new String(s.getBytes("iso-8859-1"), "GBK");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;
	}

	public static String GBK2ISO(String s) {
		String result = s;
		if (s == null) {
			return "";
		}
		try {
			result = new String(s.getBytes("GBK"), "ISO-8859-1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static String UTF82ISO(String s) {
		String result = s;
		if (s == null)
			return "";
		try {
			result = new String(s.getBytes("UTF-8"), "ISO-8859-1");
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return result;

	}

	/**
	 * 判断字符串长度是否超过预定义的，超过的截取预定义的长度 （包括了中文字符、中英文混合的判断） john add 2010/03/02
	 * 
	 * @param sourceString
	 *            源字符串
	 * @param targetLength
	 *            预定义的长度
	 * @return
	 */
	public static String subStringByUserLength(String sourceString, int targetLength) {
		if (null == sourceString) {
			return null;
		}
		String result = "";
		try {
			int length = new String(sourceString.getBytes(), "iso-8859-1")
					.length();
			if (length > targetLength) {
				if (length % 2 != targetLength % 2) {
					targetLength -= 1;
				}
				char[] chars = sourceString.toCharArray();
				for (int i = 0; i < chars.length; i++) {
					if (targetLength == 0) {
						break;
					}
					if (chars[i] > 256) {
						targetLength -= 2;
					} else {
						targetLength -= 1;
					}
					result += chars[i];
				}
			} else {
				result = sourceString;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}

}
