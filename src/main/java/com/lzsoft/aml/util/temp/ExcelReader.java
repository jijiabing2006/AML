package com.lzsoft.aml.util.temp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;

public class ExcelReader {
	private POIFSFileSystem fs;
	private HSSFWorkbook workBook;
	private HSSFSheet sheet;

	public void openExcel(String fileName, String sheetName) {
		try {
			fs = new POIFSFileSystem(new FileInputStream(fileName));
			workBook = new HSSFWorkbook(fs);
			if (StringUtils.isEmpty(sheetName))
				sheet = workBook.getSheetAt(0);
			else
				sheet = workBook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getSheetName(String fileName,int i){
		String sheetname=null;
		try {
			fs = new POIFSFileSystem(new FileInputStream(fileName));
			workBook = new HSSFWorkbook(fs);
			sheetname=workBook.getSheetName(i);
			this.closeExcel();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sheetname;
		
	}

	public HSSFSheet openSheet(String sheetName) {
		if (StringUtils.isEmpty(sheetName))
			sheet = workBook.getSheetAt(0);
		else
			sheet = workBook.getSheet(sheetName);
		return sheet;
	}

	public void closeExcel() {
		sheet = null;
		workBook = null;
		fs = null;
	}

	public String getStringCellValue(int rowNumber, int colNumber) {
//		HSSFRow row = sheet.createRow(rowNumber);
		HSSFRow row = sheet.getRow(rowNumber);
		if(null==row){
			row = sheet.createRow(rowNumber);
		}
		HSSFCell cell = row.getCell((short) colNumber, Row.CREATE_NULL_AS_BLANK);
		return cell.getStringCellValue();
	}
	
	public double getDouble(int rowNumber, int colNumber){
//		HSSFRow row = sheet.createRow(rowNumber);
		HSSFRow row = sheet.getRow(rowNumber);
		if(null==row){
			row = sheet.createRow(rowNumber);
		}
		HSSFCell cell = row.getCell((short) colNumber, Row.CREATE_NULL_AS_BLANK);
		return cell.getNumericCellValue();
	}

	public HSSFWorkbook getWorkBook() {
		return workBook;
	}

	public void setWorkBook(HSSFWorkbook workBook) {
		this.workBook = workBook;
	}

	public HSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(HSSFSheet sheet) {
		this.sheet = sheet;
	}
}
