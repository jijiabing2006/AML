package com.lzsoft.aml.common;

public class JshConstants {
	/**
	 * T 接口控制文件  D   外汇账户内结汇－基础信息数据  E  外汇账户内购汇－基础信息数据
	 * 
	 */
	//所有的静态字符数组的第一个"S"或"E"用来标识是字符在前，还是字符在后.出口收汇核销则是全数字
	public static final int RPTNO_PART_LENGTH = 4;

	/**
	 * 外汇账户内结汇－基础信息 对公,私客户取值
	 */
	public static final String[] D_RPTNO_RANG = new String[] {"E", "U", "V", "W" };

	/**
	 * 外汇账户内购汇－基础信息 对公,私客户取值
	 */
	public static final String[] E_RPTNO_RANG = new String[] {"E", "X", "Y"};
}
