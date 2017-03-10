package com.lzsoft.aml.autoexecute.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class FileUtil {
	/**
	 * 读取配置文件的属性到Map
	 * 
	 * @param filePath
	 *            配置文件的路径
	 * @return 各种属性配置的Map
	 * @throws ConfigurationException
	 *             解析文件异常
	 */
	public static Map<String, String> getMapByPorpFile(String filePath)
			throws ConfigurationException {

		Configuration config;
		config = new PropertiesConfiguration(filePath);
		Iterator<String> iter = config.getKeys();

		Map<String, String> map = new HashMap<String, String>();

		while (iter.hasNext()) {

			String key = iter.next().toString();

			map.put(key, config.getString(key));

		}
		return map;

	}
	
	public static List<String> getStringByList(Map map) {
		if (null == map || map.isEmpty())
			return null;
		Set keys = map.keySet();
		List<String> strs = new ArrayList<String>();
		for (Iterator iter = keys.iterator(); iter.hasNext();) {
			strs.add(iter.next().toString());
		}
		return strs;
	}
}
