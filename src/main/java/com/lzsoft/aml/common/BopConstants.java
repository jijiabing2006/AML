package com.lzsoft.aml.common;

public class BopConstants {
	/**
	 * T 接口控制文件 A 涉外收入申报单—基础信息 B 境外汇款申请书—基础信息 C 对外付款/承兑通知书—基础信息 D
	 * 出口收汇核销专用联（境内收入）—基础信息 E 境内汇款申请书—基础信息 F 境内付款/承兑通知书—基础信息
	 * 
	 * G 涉外收入申报单—申报信息 H 境外汇款申请书—申报信息 K 对外付款/承兑通知书—申报信息
	 * 
	 * M 出口收汇核销专用联（境外收入）—核销专用信息 N 境外汇款申请书—核销专用信息 P 对外付款/承兑通知书—核销专用信息 Q
	 * 境内汇款申请书—核销专用信息 R 出口收汇核销专用联（境内收入）—核销专用信息 S 境内付款/承兑通知书—核销专用信息
	 */
	//所有的静态字符数组的第一个"S"或"E"用来标识是字符在前，还是字符在后.出口收汇核销则是全数字
	public static final int RPTNO_PART_LENGTH = 4;
	/**
	 * 涉外收入申报单—基础信息对公客户取值
	 */
	public static final String[] A_RPTNO_RANG_FOR_C = new String[] { "S", "N",
			"P", "Q", "R", "S", "T" };

	/**
	 * 涉外收入申报单—基础信息对私客户取值
	 */
	public static final String[] A_RPTNO_RANG_FOR_I = new String[] { "S", "U",
			"V", "W" };

	/**
	 * 境外汇款申请书—基础信息 对公客户取值
	 */
	public static final String[] B_RPTNO_RANG_FOR_C = new String[] { "S", "A",
			"B", "C", "D" };

	/**
	 * 境外汇款申请书—基础信息 对私客户取值
	 */
	public static final String[] B_RPTNO_RANG_FOR_I = new String[] { "S", "J",
			"K" };

	/**
	 * 对外付款/承兑通知书—基础信息 对公客户取值
	 */
	public static final String[] C_RPTNO_RANG_FOR_C = new String[] { "S", "E",
			"F", "G", "H" };

	/**
	 * 对外付款/承兑通知书—基础信息 对私客户取值
	 */
	public static final String[] C_RPTNO_RANG_FOR_I = new String[] { "S", "L",
			"M" };

	/**
	 * 出口收汇核销专用联（境内收入）—基础信息 对公,私客户取值
	 */
	public static final String[] D_RPTNO_RANG = null;

	/**
	 * 境内汇款申请书—基础信息 对公,私客户取值
	 */
	public static final String[] E_RPTNO_RANG = new String[] { "E", "A", "B",
			"C", "D", "E", "F", "G", "H", "J" };

	/**
	 * 境内付款/承兑通知书—基础信息 对公,私客户取值
	 */
	public static final String[] F_RPTNO_RANG = new String[] { "E", "K", "L",
			"M", "N", "P", "Q", "R", "S", "T" };
}
