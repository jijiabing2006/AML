package com.lzsoft.aml.util;

import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	public static XSSFCellStyle getDateByFormat(XSSFWorkbook workbook2007,String format) {

		XSSFCellStyle cellStyle = workbook2007.createCellStyle();


		cellStyle.setDataFormat(workbook2007.createDataFormat().getFormat(format));

		return cellStyle;

	}
}
