/************************* 版权声明 *********************************
 * 
 * 版权所有：百洋软件
 * Copyright (c) 2009 by Pearl Ocean.
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：slx   创建日期： 2009-6-24
 * 创建记录：创建类结构。
 * 
 * 修改者：       修改日期：
 * 修改记录：
 ************************* 随   笔 *********************************
 *
 * 这里可以写写感想，感慨，疑问什么的。
 * 
 ******************************************************************
 */    

package com.lzsoft.aml.dao;

import java.io.Serializable;

/**
 * 条件对象
 * @author slx
 * @date 2009-6-24 上午10:53:46
 * @version 1.0
 */
public class QueryCondition implements Serializable,Cloneable{

	private static final long serialVersionUID = 1L;

	/** 字段名（表名.列名） **/
	private String field ;
	
	/** 操作符 **/
	private String operator ;
	
	/** 值 **/
	private Object value ;
	
	public QueryCondition() {
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public QueryCondition(String field , String operator , Object value) {
		this.field = field ;
		this.operator = operator ;
		this.value = value ;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
