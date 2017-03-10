package com.lzsoft.aml.util;

import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

/**
 * 文件名过滤器
 * 
 * @author Sanwu
 * 
 * @version 1
 *
 */
@Component
public class WildcardFilenameFilter implements java.io.FilenameFilter {

	public static final String WINDOWS_WILDCARD = "WindowsWildcard";
	public static final String REGEX_WILDCARD = "RegexWildcard";

	private String patternStringType = WINDOWS_WILDCARD;
	private String patternString = "*.jpg;*.jpeg;*.png";
	
	private transient Set<Pattern> patterns = new HashSet<Pattern>();

	@Override
	public boolean accept(File path, String filename) {
		if (patternString == null) {
			return true;
		}
		String longFilename = path.getAbsolutePath() + File.separator + filename;
		File file = new File(longFilename);
		if (file.exists() && file.isDirectory()) {
			return true;
		}

		String shortFilenameUpperCase = filename.toUpperCase();

		for (Pattern pattern : patterns) {
			boolean match = pattern.matcher(shortFilenameUpperCase).matches();
			if (match) {
				return true;
			}
		}

		return false;
	}

	/**
	 * 支持windows、正则表达式格式，默认为windows格式
	 * @return 文件名通配字符串的格式。
	 */
	public String getPatternStringType() {
		return patternStringType;
	}

	/**
	 * 设置文件名通配字符串
	 * 格式：*.jpg;*.jpeg;*.png
	 * 
	 * @param patternStringType
	 */
	public void setPatternStringType(String patternStringType) {
		if (patternStringType.equals(WINDOWS_WILDCARD) || patternStringType.equals(REGEX_WILDCARD)) {
			this.patternStringType = patternStringType;
		}
	}

	/**
	 * 
	 * @return 已设置的文件名通配字符串
	 */
	public String getPatternString() {
		return patternString;
	}

	/**
	 * 设置文件名通配字符串
	 * 未设置时，默认值：*.jpg;*.jpeg;*.png
	 * 
	 * @param patternString
	 */
	public void setPatternString(String patternString) {
		this.patternString = patternString;
		parsePatternString();
	}

	/**
	 * 解析设置的通配符字符串
	 * 
	 */
	private void parsePatternString() {
		String[] extendsnames = patternString.split(File.pathSeparator);
		
		for (String extendsname : extendsnames) {
			if (patternStringType.equals(WINDOWS_WILDCARD)) {
				extendsname = extendsname.toUpperCase().replace(".", "\\.");
				extendsname = extendsname.replace("*", ".*");
			}
			Pattern pettern = Pattern.compile(extendsname);
			patterns.add(pettern);
		}

	}

}
