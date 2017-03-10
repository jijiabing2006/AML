package com.lzsoft.aml.util.temp;

import java.io.UnsupportedEncodingException;

public class EncodingUtil {
	/**   
	 *   ��getBytes(encoding)�������ַ��һ��byte����   
	 *   ��b[0]Ϊ   63ʱ��Ӧ����ת�����   
	 *   A��������ĺ����ַ�   
	 *   1��encoding��GB2312ʱ��ÿbyte�Ǹ���   
	 *   2��encoding��ISO8859_1ʱ��b[i]ȫ��63��   
	 *   B������ĺ����ַ�   
	 *   1��encoding��ISO8859_1ʱ��ÿbyteҲ�Ǹ���   
	 *   2��encoding��GB2312ʱ��b[i]�󲿷���63��   
	 *   C��Ӣ���ַ�   
	 *   1��encoding��ISO8859_1��GB2312ʱ��ÿbyte������0��   
	 *   <p/>   
	 *   �ܽ᣺��һ���ַ���getBytes("iso8859_1")   
	 *   1�����b[i]��63������ת�룻   A-2   
	 *   2�����b[i]ȫ����0����ôΪӢ���ַ�����ת�룻   B-1   
	 *   3�����b[i]��С��0�ģ���ô�Ѿ����룬Ҫת�롣   C-1   
	 * @throws UnsupportedEncodingException 
	 */
	public static String toGb2312(String str)
			throws UnsupportedEncodingException {
		if (str == null)
			return null;
		String retStr = str;
		byte b[];
		try {
			b = str.getBytes("ISO8859_1");

			for (int i = 0; i < b.length; i++) {
				byte b1 = b[i];
				if (b1 == 63)
					break; //1   
				else if (b1 > 0)
					continue;//2   
				else if (b1 < 0) { //������Ϊ0��0Ϊ�ַ�����   
					retStr = new String(b, "GB18030");
					break;
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace(); //To   change   body   of   catch   statement   use   File   |   Settings   |   File   Templates.
			throw e;
		}
		return retStr;
	}
}
