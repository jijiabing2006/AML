package com.lzsoft.rules.core.util;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.lzsoft.rules.core.config.elmt.PropertyElmt;
import com.lzsoft.rules.core.util.component.DateUtil;

public class MUtil {
	/**
	 * 
	 * @param fieldValue
	 *            待过滤的POJO的值
	 * @param fieldType
	 *            字段类型（简称）
	 * @param propertyElmt
	 *            过滤条件
	 * @return
	 * @throws Exception
	 */
	public static boolean matchField(Object objectValue, String fieldType,
			PropertyElmt propertyElmt) throws Exception {

		if (null == objectValue || null == fieldType || null == propertyElmt) {
			return false;
		}

		String fieldValue = propertyElmt.getValue();

		if (StringUtils.length(fieldValue) > 2
				&& StringUtils.indexOf(fieldValue, "|:") != StringUtils.INDEX_NOT_FOUND) {// 判断field的value是否是|:开头<!--
																							// '|'说明或关系，每个：分割的值只要一个满足就可以
																							// -->
			String[] values = StringUtils.split(
					StringUtils.substring(fieldValue, 2), ":");
			boolean currentRule = false;
			for (String value : values) {
				currentRule = isMatchField(objectValue, fieldType,
						propertyElmt, value);
				if (currentRule) {
					return true;
				}
			}
			return false;

		} else if (StringUtils.length(fieldValue) > 2
				&& StringUtils.indexOf(fieldValue, "^:") != StringUtils.INDEX_NOT_FOUND) {// 判断field的value是否^开头<!--
																							// '^'说明全匹配，每个：分割的值都要
																							// -->
			String[] values = StringUtils.split(
					StringUtils.substring(fieldValue, 2), ":");
			int num = 0;
			for (String value : values) {
				// if (StringUtils.indexOf(value, "=") !=
				// StringUtils.INDEX_NOT_FOUND) {
				// String index = StringUtils.substring(value, 0,
				// StringUtils.indexOf(value, "="));
				// String index_value = StringUtils.substring(value,
				// StringUtils.indexOf(value, "=") + 1);
				if (isMatchField(objectValue, fieldType, propertyElmt, value)) {
					num++;
				}
				// }
			}
			if (num == values.length) {
				return true;
			}
			return false;
		} else {
			return isMatchField(objectValue, fieldType, propertyElmt,
					propertyElmt.getValue());
		}

	}

	private static boolean isMatchField(Object objectValue, String fieldType,
			PropertyElmt propertyElmt, String fieldValue) {
		String relation = propertyElmt.getRelation();

		if ("String".equals(fieldType)) {
			return matchStringValue(objectValue, propertyElmt, fieldValue,
					relation);
		} else if ("Date".equals(fieldType)) {
            return matchDateValue(objectValue, fieldValue,relation);
		} else if ("Long".equals(fieldType)) {
			return matchDoubleValue(((Long) objectValue).doubleValue(), fieldValue, relation);
			
		} else if ("Double".equals(fieldType)) {
			return matchDoubleValue(objectValue, fieldValue, relation);

		} else if ("BigDecimal".equals(fieldType)) {
			return matchDoubleValue(((BigDecimal) objectValue).doubleValue(),
					fieldValue, relation);

		}

		return false;
	}

	private static boolean matchDateValue(Object objectValue,
			String fieldValue, String relation) {
		if (relation != null && StringUtils.equalsIgnoreCase("equal", relation)) {// equals
			if (((Date) objectValue).compareTo(DateUtil.strToDate(fieldValue,"yyyy-MM-dd"))==0) {
				return true;
			}
		}else if (relation != null
				&& StringUtils.equalsIgnoreCase("ge", relation)) {// greaterOrequal
			if (((Date) objectValue).compareTo(DateUtil.strToDate(fieldValue,"yyyy-MM-dd"))>=0) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("gt", relation)) {// greater
			if (((Date) objectValue).compareTo(DateUtil.strToDate(fieldValue,"yyyy-MM-dd"))>0) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("le", relation)) {// lesserOrequal
			if (((Date) objectValue).compareTo(DateUtil.strToDate(fieldValue,"yyyy-MM-dd"))<=0) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("lt", relation)) {// lesser
			if (((Date) objectValue).compareTo(DateUtil.strToDate(fieldValue,"yyyy-MM-dd"))<0) {
				return true;
			}
		}
		return false;
	}

	private static boolean matchDoubleValue(Object objectValue,
			String fieldValue, String relation) {
		if (relation != null && StringUtils.equalsIgnoreCase("equal", relation)) {// equals
			if ((Double) objectValue == Double.valueOf(fieldValue)) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("ge", relation)) {// greaterOrequal
			if ((Double) objectValue >= Double.valueOf(fieldValue)) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("gt", relation)) {// greater
			if ((Double) objectValue > Double.valueOf(fieldValue)) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("le", relation)) {// lesserOrequal
			if ((Double) objectValue <= Double.valueOf(fieldValue)) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("lt", relation)) {// lesser
			if ((Double) objectValue < Double.valueOf(fieldValue)) {
				return true;
			}
		}
		return false;
	}

	private static boolean matchStringValue(Object objectValue,
			PropertyElmt propertyElmt, String fieldValue, String relation) {
		int start = null != propertyElmt.getStart() ? Integer
				.parseInt(propertyElmt.getStart()) : -1;
		int end = null != propertyElmt.getEnd() ? Integer.parseInt(propertyElmt
				.getEnd()) : -1;
		String strValue = (String) objectValue;// 转换类型
		if (start > 0 && end > start) {
			strValue = StringUtils.substring(((String) objectValue), start - 1,
					end);
		} else if (start > 0 && end < start) {
			strValue = StringUtils.substring(((String) objectValue), start - 1);
		} else if (end > 0 && start == -1) {
			strValue = StringUtils.substring(((String) objectValue), 0, end);
		}
		objectValue = strValue;
		if (relation != null && StringUtils.equalsIgnoreCase("equal", relation)) {// relation为equal
			if (StringUtils.equalsIgnoreCase((String) objectValue, fieldValue)) {
				return true;
			}
		} else if (relation != null
				&& StringUtils.equalsIgnoreCase("unequal", relation)) {// relation为unequal
			if (!StringUtils.equalsIgnoreCase((String) objectValue, fieldValue)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isMatchField(Object objValue, String fieldType,
			PropertyElmt propertyElmt) throws Exception {
		//
		// String relation = propertyElmt.getRelation();
		//
		// if ("String".equals(fieldType)) {
		//
		//
		// if (relation != null
		// && StringUtils.equalsIgnoreCase("equal", relation)) {//
		// relation为equal
		// if (StringUtils.equalsIgnoreCase(strValue, value)) {
		// return true;
		// }
		// } else if (relation != null
		// && StringUtils.equalsIgnoreCase("unequal", relation)) {//
		// relation为unequal
		// if (!StringUtils.equalsIgnoreCase(strValue, value)) {
		// return true;
		// }
		// }
		// } else if ("Date".equals(fieldType)) {
		//
		// } else if ("Long".equals(fieldType)) {
		//
		// } else if ("Double".equals(fieldType)) {
		//
		// } else if ("BigDecimal".equals(fieldType)) {
		//
		// }

		// if (relation != null && StringUtils.equalsIgnoreCase("indexOf",
		// relation)) {// relation为indexOf
		// if (StringUtils.indexOf(objValue, value) !=
		// StringUtils.INDEX_NOT_FOUND){
		// return true;
		// }
		// } else if (relation != null && StringUtils.equalsIgnoreCase("equal",
		// relation)) {// relation为equal
		// if (StringUtils.equalsIgnoreCase(objValue, value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("unequal", relation)) {//
		// relation为unequal
		// if (!StringUtils.equalsIgnoreCase(objValue, value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("greater", relation)) {//
		// relation为greater
		// if (Math.abs((NumberUtils.toDouble(objValue))) >= NumberUtils
		// .toDouble(value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("startwith", relation)) {//
		// relation为startwith
		// if (StringUtils.startsWithIgnoreCase(objValue, value)){
		// return true;
		// }
		// } else if (relation != null && StringUtils.startsWith(relation,
		// "substring:")) {// relation为substring(如substring:1:10)
		// String[] indexs = StringUtils.split(StringUtils.substring(relation,
		// 10), ":");
		// if (indexs.length == 2) {
		// try {
		// if (StringUtils.equalsIgnoreCase(StringUtils.substring(objValue,
		// Integer.parseInt(indexs[0]),
		// Integer.parseInt(indexs[1])), value)){
		// return true;
		// }
		// } catch (Exception e) {
		// return false;
		// }
		// } else{
		// return false;
		// }
		// } else if (relation != null && StringUtils.equalsIgnoreCase("length",
		// relation)) {// relation为length
		// if (StringUtils.length(objValue) == Integer.parseInt(value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("lengthD", relation)) {//
		// relation为lengthD
		// if (StringUtils.length(objValue) > Integer.parseInt(value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("lengthX", relation)) {//
		// relation为lengthX
		// if (StringUtils.length(objValue) < Integer.parseInt(value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("lengthD=", relation)) {//
		// relation为lengthD=
		// if (StringUtils.length(objValue) >= Integer.parseInt(value)){
		// return true;
		// }
		// } else if (relation != null &&
		// StringUtils.equalsIgnoreCase("lengthX=", relation)) {//
		// relation为lengthX=
		// if (StringUtils.length(objValue) <= Integer.parseInt(value)){
		// return true;
		// }
		// }
		//
		//

		return false;
	}
}
