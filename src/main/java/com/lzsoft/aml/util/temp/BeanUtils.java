package com.lzsoft.aml.util.temp;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BeanUtils {

	public static Property getProperty(Object targetObj, String propertiesName)
			throws Exception {

		Property properties = new Property();

		properties.setParentClass(targetObj.getClass());

		properties.setName(propertiesName);

		String getName = "get" + propertiesName.substring(0, 1).toUpperCase()
				+ propertiesName.substring(1);

		Method[] methods = targetObj.getClass().getMethods();

		Method method = null;

		for (Method m : methods) {

			if (m.getName().equalsIgnoreCase(getName)) {

				method = m;

				break;

			}

		}

		if (null == method)

			return null;

		properties.setType(method.getReturnType().getName());

		try {

			properties.setValue(method.invoke(targetObj, new Object[] {}));

		} catch (Exception e) {
			throw e;
		}

		return properties;

	}

	public static void copyProperty(Object targetObj, String propertyName,
			Object value) throws Exception {

		org.apache.commons.beanutils.BeanUtils.copyProperty(targetObj,
				propertyName, value);

	}

	public static void copyProperties(Object targetObj, Object sourceObj)
			throws Exception {

		org.apache.commons.beanutils.BeanUtils.copyProperties(targetObj,
				sourceObj);

	}

	public static String getPropertyValue(Object targetObj, String propertyName)
			throws Exception {

		return org.apache.commons.beanutils.BeanUtils.getProperty(targetObj,
				propertyName);

	}

	@SuppressWarnings("unchecked")
	public static List getPropertyCollection(Object obj) {
		List list = new ArrayList();
		Field[] f = obj.getClass().getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			list.add(f[i]);
		}
		return list;
	}

}
