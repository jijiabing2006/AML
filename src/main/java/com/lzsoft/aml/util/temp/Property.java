package com.lzsoft.aml.util.temp;

public class Property {

	@SuppressWarnings("unchecked")
	private Class parentClass;

	private String name;

	private String type;

	private Object value;

	@SuppressWarnings("unchecked")
	public Class getParentClass() {
		return parentClass;
	}

	@SuppressWarnings("unchecked")
	public void setParentClass(Class parentClass) {
		this.parentClass = parentClass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
