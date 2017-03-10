package com.lzsoft.aml.util.temp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @function introduce<���ڴ��?����>
 * @author 
 * @time May 31, 2008
 * @last modification by  at May 31, 2008
 * @version 1.0
 */
public class DateUtil {

	/**
	 * ��ʽ������
	 * 
	 * @param sdate
	 *            �����ַ�
	 * @param format
	 *            Ҫ��ʽ�������ڸ�ʽ
	 * @return ��ʽ����������ַ�
	 * @throws ParseException
	 */
	public static java.lang.String format(String sdate, java.lang.String format)
			throws ParseException {

		Date date = new Date();

		SimpleDateFormat df = new SimpleDateFormat(format);

		try {

			date = df.parse(sdate);

		} catch (ParseException e) {

			e.printStackTrace();
			throw e;
		}

		return df.format(date);

	}

	/**
	 * һ�������Ƿ���ָ�������ڸ�ʽ
	 * 
	 * @param dateStr
	 *            �����ַ�
	 * @param pattern
	 *            ��֤�����ڸ�ʽ
	 * @return �Ƿ���ָ�������ڸ�ʽ
	 * @throws ParseException
	 */
	public static boolean isValidDate(String dateStr, String pattern)
			throws ParseException {

		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(pattern);

		try {

			df.setLenient(false);

			df.parse(dateStr);

			return true;

		} catch (ParseException e) {

			throw e;

		}
	}

	/**
	 * ���ַ�ָ���ĸ�ʽת��Ϊ��������
	 * 
	 * @param str
	 *            �����ַ�
	 * @param format
	 *            ָ����ʽ
	 * @return ��ʽ��������ڶ���
	 * @throws Exception
	 */
	public static Date strToDate(String str, String format) throws Exception {

		SimpleDateFormat dtFormat = null;
		try {
			dtFormat = new SimpleDateFormat(format);

			return dtFormat.parse(str);

		} catch (Exception e) {

			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * ��һ�����ڽ���ƫ��
	 * 
	 * @param date
	 *            ����
	 * @param offset
	 *            ƫ����
	 * @return ƫ�ƺ������
	 */
	public static Date addDayByDate(Date date, int offset) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int day = cal.get(Calendar.DAY_OF_YEAR);
		cal.set(Calendar.DAY_OF_YEAR, day + offset);
		return cal.getTime();
	}

	/**
	 * �����ڸ�ʽ��Ϊ<�ַ�����>
	 * 
	 * @param Ҫ��ʽ��������
	 * @param dateFormat
	 *            ���ڸ�ʽ
	 * @return ��ǰ����<�ַ�����>
	 */
	public static String dateToStr(Date date, String dateFormat) {
		if (null == date)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}

	/**
	 * �õ���ǰ����<�ַ�����>
	 * 
	 * @param dateFormat
	 *            ���ڸ�ʽ
	 * @return ��ǰ����<�ַ�����>
	 */
	public static String getCurrDate(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(new Date());
	}

	/**
	 * �õ���ǰ����<java.util.Date����>
	 * 
	 * @param dateFormat
	 *            ���ڸ�ʽ
	 * @return ��ǰ����<java.util.Date����>
	 * @throws Exception
	 */
	public static Date getCurrentDate(String dateFormat) throws Exception {
		return strToDate(getCurrDate(dateFormat), dateFormat);
	}

	/**
	 * ��һ������ת��Ϊָ����ʽ����������
	 * 
	 * @param date
	 *            Ҫת��������
	 * @param dateFormat
	 *            ���ڸ�ʽ
	 * @return ת��������ڶ���
	 * @throws Exception
	 */
	public static Date formatDate(Date date, String dateFormat)
			throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return strToDate(sdf.format(date), dateFormat);
	}

	/**
	 * �Ը�ʽΪ20080101���͵��ַ�������ڸ�ʽ��
	 * 
	 * @param dateStr
	 *            Ҫ��ʽ�����ַ�
	 * @param formatChar
	 *            �����ַ�
	 * @param dateFormat
	 *            ���ڸ�ʽ
	 * @return ��ʽ��������ַ�
	 * @throws Exception
	 */
	public static String format(String dateStr, String formatChar,
			String dateFormat) throws Exception {
		try {
			dateStr = dateStr.substring(0, 4) + formatChar
					+ dateStr.substring(4, 6) + formatChar
					+ dateStr.substring(6, 8);
			return format(dateStr, dateFormat);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * �Ը�ʽΪ20080101���͵��ַ�������ڸ�ʽ��
	 * 
	 * @param dateStr
	 *            Ҫ��ʽ�����ַ�
	 * @param formatChar
	 *            �����ַ�
	 * @param dateFormat
	 *            ���ڸ�ʽ
	 * @return ��ʽ������ڶ���
	 * @throws Exception
	 */
	public static Date formatDate(String dateStr, String formatChar,
			String dateFormat) throws Exception {
		try {
			dateStr = dateStr.substring(0, 4) + formatChar
					+ dateStr.substring(4, 6) + formatChar
					+ dateStr.substring(6, 8);
			return strToDate(dateStr, dateFormat);
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * ���ĳһ���·ݵĵ�һ��
	 * 
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	public static Date getFirstDayByMonth(Date date) throws Exception {
		GregorianCalendar gc = (GregorianCalendar) Calendar.getInstance();
		gc.setTime(date);
		gc.set(Calendar.DAY_OF_MONTH, 1);
		return formatDate(gc.getTime(), "yyyy-MM-dd");
	}

	/**
	 * ���ĳһ���·ݵ����һ��
	 * 
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("static-access")
	public static Date getLastDayByMonth(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DATE, 1);// ��Ϊ��ǰ�µ�1��
		cal.add(Calendar.MONTH, 1);// ��һ���£���Ϊ���µ�1��
		cal.add(Calendar.DATE, -1);// ��ȥһ�죬��Ϊ�������һ��

		return formatDate(cal.getTime(), "yyyy-MM-dd");
	}

	/**
	 * ���ָ�����ڵ����
	 * 
	 * @param date
	 * @return
	 */
	public static int getYearByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * ���ָ�����ڵ��·�
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonthByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}

	/**
	 * ���ָ�����ڵ������·ݵ�ǰ������
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayInMonthByDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��õ�ǰ�������ڵ���һ���·ݵĵ�ǰ����
	 * 
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	public static Date getPreviousDate(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -1);
		return DateUtil.formatDate(cal.getTime(), "yyyy-MM-dd");
	}

	public static long compareDateDayValue(Date fDate, Date sDate) {
		long l1 = fDate.getTime();
		long l2 = sDate.getTime();
		long diff = (Math.abs(l2 - l1)) / 1000 / 24 / 60 / 60;
		return diff;
	}

	/**
	 * ��õ�ǰ�������ڵ���һ���·ݵĵ�ǰ����
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	public static Date getLastMonthDate(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		return DateUtil.formatDate(cal.getTime(), "yyyy-MM-dd");
	}	
	/**
	 * ��õ�ǰ�������ڵ�ǰ3���·ݵĵ�ǰ����
	 * @param date
	 * @return
	 * @throws Exception 
	 */
	public static Date getDateBefore3Months(Date date) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -3);
		return DateUtil.formatDate(cal.getTime(), "yyyy-MM-dd");
	}

	/**
	 * �����������������������ϸ�ֵ�����Ĳ��
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDiffMonths(Date date1, Date date2) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
					.get(Calendar.DAY_OF_MONTH))
				flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}

	/**
	 * ����������������Ĳ�𣬲�������ϸ������Ĳ��
	 * ���ڴ��Ϊ����һ�����Ϊ����֮Ϊ����
	 * @return
	 */
	public static int getDiffMonth(Date date1, Date date2) {

		Calendar calendar1 = Calendar.getInstance();
		calendar1.setTime(date1);

		Calendar calendar2 = Calendar.getInstance();
		calendar2.setTime(date2);

		int diffyaer = calendar1.get(Calendar.YEAR)
				- calendar2.get(Calendar.YEAR);
		int diffmonth = calendar1.get(Calendar.MONTH)
				- calendar2.get(Calendar.MONTH);

		return diffyaer * 12 + diffmonth;

	}

	public static void main(String[] args) throws Exception {
//		System.out.println(DateUtil.getDiffMonth(DateUtil.strToDate(
//				"2010-02-29", "yyyy-MM-dd"), DateUtil.strToDate("2010-02-26",
//				"yyyy-MM-dd")));
//		
		
		System.out.println(getMonth(DateUtil.strToDate(
				"2013-8-26", "yyyy-MM-dd"), DateUtil.strToDate("2013-9-22",
				"yyyy-MM-dd")));
	}

	public static String getCurrDate24() {
		String time = "";
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String y = String.valueOf(c.get(Calendar.YEAR));
		String m = String.valueOf(c.get(Calendar.MONTH) + 1);
		String d = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String h = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		String minute = String.valueOf(c.get(Calendar.MINUTE));
		String second = String.valueOf(c.get(Calendar.SECOND));
		if (m.length() == 1) {
			m = "0" + m;
		}

		if (d.length() == 1) {
			d = "0" + d;
		}
		if (h.length() == 1) {
			h = "0" + h;
		}
		if (minute.length() == 1) {
			minute = "0" + minute;
		}
		if (second.length() == 1) {
			second = "0" + second;
		}
		time = y + "-" + m + "-" + d + " " + h + ":" + minute + ":" + second;
		return time;
	}

	/**
	 * ������������֮����������
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getMonth(Date start, Date end) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(start);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(end);
			// ��֤objCalendarDate2 after objCalendarDate1
			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			// ���е�һ��
			if (objCalendarDate1.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
					.getActualMaximum(Calendar.DAY_OF_MONTH)) {
				if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) <= objCalendarDate1
						.get(Calendar.DAY_OF_MONTH)) {
					flag = 1;
				} else {
					flag = 0;
				}
			} else {
				// ��ĩ��һ��
				if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) <= objCalendarDate2
						.getActualMaximum(Calendar.DAY_OF_MONTH)) {
					flag = 1;
				} else {
					flag = 0;
				}
			}

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
					.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
						.get(Calendar.YEAR))
						* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH)
						- objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return iMonth;
	}
	
	public static Long getMonths(Date startdate, Date enddate) {
		Calendar calstart = Calendar.getInstance();
		calstart.setTime(startdate);

		Calendar calend = Calendar.getInstance();
		calend.setTime(enddate);

		int endday = calend.get(Calendar.DAY_OF_MONTH);
		int startday = calstart.get(Calendar.DAY_OF_MONTH);
		int month = 0;
		if ((endday == calend.getActualMaximum(Calendar.DAY_OF_MONTH) && startday == calstart
				.getActualMaximum(Calendar.DAY_OF_MONTH))
				|| (endday <= startday)) {
			month = 0;
		} else if (endday > startday) {
			month = 1;
		} 
		int endyear = calend.get(Calendar.YEAR);
		int startyear = calstart.get(Calendar.YEAR);

		long months = (endyear - startyear) * 12;

		int endmonth = calend.get(Calendar.MONTH);
		int startmonth = calstart.get(Calendar.MONTH);

		months += endmonth - startmonth;

		months += month;
		if(0 == months){
			months =1;
		}

		return months;
	}
	public static long getDateDeff(Date startDate, Date endDate)
			throws Exception {
		long intValue = 0;
		try {
			String df = new String("yyyy-MM-dd");
			startDate = DateUtil.strToDate(DateUtil.dateToStr(startDate, df),
					df);
			endDate = DateUtil.strToDate(DateUtil.dateToStr(endDate, df), df);
			intValue = (startDate.getTime() - endDate.getTime()) / 86400000;
		} catch (Exception e) {
			// System.err.println("getDateDeff error");
			throw e;
		}
		return intValue;
	}

	public static String getCurrDate8() {
		String time = "";
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String y = String.valueOf(c.get(Calendar.YEAR));
		String m = String.valueOf(c.get(Calendar.MONTH) + 1);
		String d = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		if (m.length() == 1) {
			m = "0" + m;
		}

		if (d.length() == 1) {
			d = "0" + d;
		}
		time = y + m + d;
		return time;
	}

	public static String getCurrMonth() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String m = String.valueOf(c.get(Calendar.MONTH) + 1);
		return m;
	}

	public static String getCurrYear() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		String y = String.valueOf(c.get(Calendar.YEAR));
		return y;
	}

	// ��ñ����һ�������
	public static Date getCurrentYearFirst() throws ParseException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String startdate = dateFormat.format(date) + "-01-01";
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat2.parse(startdate);
	}

	// ��ñ������һ������� *
	public static Date getCurrentYearEnd() throws ParseException {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
		String enddate = dateFormat.format(date) + "-12-31";
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat2.parse(enddate);
	}

}
