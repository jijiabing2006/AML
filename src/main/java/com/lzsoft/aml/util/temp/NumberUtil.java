package com.lzsoft.aml.util.temp;

import java.math.BigDecimal;
import java.text.DecimalFormat;


/**
 * 
 * @function introduce<���ֲ���������>
 * @author 
 * @time Jun 13, 2008
 * @last modification by  at Jun 13, 2008
 * @version 1.0
 */
public class NumberUtil {

	/**
	 * ��ʽ��Double
	 * 
	 * @param d
	 *            Ҫ��ʽ����Double
	 * @param format
	 *            ��ʽ
	 * @return ��ʽ�����Double
	 */
	public static Double formatDouble(Double d, String format) {
		DecimalFormat df = new DecimalFormat(format);
		return Double.parseDouble(df.format(d));
	}

	/**
	 * ��ʽ��DoubleΪ�ַ�
	 * 
	 * @param d
	 *            Ҫ��ʽ����Double
	 * @param format
	 *            ��ʽ��
	 * @return ��ʽ������ַ�
	 */
	public static String formatDoubleToStr(Double d, String format) {
		DecimalFormat df = new DecimalFormat(format);
		return df.format(d);
	}
	
	public static BigDecimal div(BigDecimal d1, BigDecimal d2, int scale) {
		if (scale < 0) {

			throw new IllegalArgumentException(

			"The scale must be a positive integer or zero");

		}
		return d1.divide(d2, scale, BigDecimal.ROUND_HALF_UP);
	}
}
