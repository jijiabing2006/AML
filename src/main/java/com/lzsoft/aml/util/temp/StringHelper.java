package com.lzsoft.aml.util.temp;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @function introduce<�ַ�ͨ����>
 * @author 
 * @time May 17, 2008
 * @last modification by  at May 17, 2008
 * @version 1.0
 */
public class StringHelper {

	/**
	 * �ж��ַ��Ƿ�Ϊ�ջ�NULL
	 * 
	 * @param param
	 *            Ҫ�����ַ�
	 * @return �ǿջ�NULL����true�����򷵻�false;
	 */
	public static boolean isNullOrEmpty(String param) {

		return param == null || "".equals(param.trim());

	}

	/**
	 * ����ת��Ϊ�ַ�
	 * 
	 * @param strArray
	 *            Ҫת��������
	 * @return ������","������ַ�
	 */
	public static String arrayToString(String strArray[]) {

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < strArray.length; i++)

			if ("".equals(buffer.toString()))

				buffer.append(strArray[i]);

			else

				buffer.append((new StringBuilder(",")).append(strArray[i]).toString());

		return buffer.toString();

	}

	/**
	 * �ַ�ת���ַ�����һ
	 * 
	 * @param str
	 *            Ҫת�����ַ�
	 * @param sep_str
	 *            �ָ����
	 * @return �ָ�����ַ�����
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
	 * �ַ�ת���ַ������
	 * 
	 * @param str
	 *            Ҫת�����ַ�
	 * @param sep_str
	 *            �ָ����
	 * @return �ָ�����ַ�����
	 */
	public static String[] getArrayByStr(String str, String sep_str) {

		if (null == str || null == sep_str)

			return null;

		return str.split(sep_str);

	}

	/**
	 * У��һ���ַ��Ƿ�ΪNULL
	 * 
	 * @param checkObject
	 *            У�����
	 * @return Ϊ�շ���NULL,���򷵻ظö����ֵ
	 */
	public static String checkNull(String checkObject) {

		return null == checkObject || "" == checkObject.trim() ? null : checkObject;

	}

	/**
	 * У��һ���ַ��Ƿ�ΪNULL
	 * 
	 * @param checkObject
	 *            У�����
	 * @return Ϊ�շ���true,����false
	 */
	public static boolean checkIsNull(String checkObject) {

		return null == checkObject || "".equalsIgnoreCase(checkObject.trim()) ? true : false;

	}

	/**
	 * �ж�һ���ַ��Ƿ���һ���ַ������д���
	 * 
	 * @param strArray
	 *            �ַ�����
	 * @param seaStr
	 *            Ҫ�ж��Ƿ��������д��ڵ��ַ�
	 * @return ���ڷ���true,��������ΪNULL������ĳ���Ϊ0���false;
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
	 * һ���ַ��Ƿ��ǲ���ֵ
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
	 * ��MAP��KEY���ַ����ʽ����
	 * @param map 
	 * @param spiltchar �ָ��ַ���ַ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getStringByMap(Map map, String spiltchar) {
		if (null == map || map.isEmpty())
			return null;
		Set keys = map.keySet();
		StringBuffer strBuf = new StringBuffer();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			strBuf.append("'" + iter.next() + "'"+spiltchar);
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


}
