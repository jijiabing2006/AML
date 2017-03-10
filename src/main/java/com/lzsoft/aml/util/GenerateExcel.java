package com.lzsoft.aml.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 生成Excel示例，2003和2007
 * 
 * @author Nanlei
 * 
 */
public class GenerateExcel {
	private static String xls2003 = "d:\\student.xls";
	private static String xlsx2007 = "d:\\student.xlsx";

	/**
	 * 创建2003文件的方法
	 * 
	 * @param filePath
	 * @throws Exception
	 */
	public static void createExcel2003(String filePath) throws Exception {
		// 先创建工作簿对象
		HSSFWorkbook workbook2003 = new HSSFWorkbook();
		// 创建工作表对象并命名
		HSSFSheet sheet = workbook2003.createSheet("学生信息统计表");
		// 遍历集合对象创建行和单元格
		// for (int i = 0; i < studentList.size(); i++) {
		// // 取出Student对象
		// Aodeposit student = studentList.get(i);
		// // 创建行
		// HSSFRow row = sheet.createRow(i);
		// // 开始创建单元格并赋值
		// HSSFCell nameCell = row.createCell(0);
		// nameCell.setCellValue(student.getName());
		// HSSFCell genderCell = row.createCell(1);
		// genderCell.setCellValue(student.getAcno());
		// HSSFCell ageCell = row.createCell(2);
		// ageCell.setCellValue(student.getAoname());
		// HSSFCell sclassCell = row.createCell(3);
		// sclassCell.setCellValue(student.getBalm().doubleValue());
		// }
		// 生成文件
		File file = new File(filePath);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			workbook2003.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void generateExcel2007(String template, String sheetName,
			String filePath, List<Object> datas) throws Exception {
		InputStream in = new FileInputStream(template);
		// 先创建工作簿对象
		XSSFWorkbook workbook2007 = new XSSFWorkbook(in);
		// 创建工作表对象并命名
		XSSFSheet sheet = workbook2007.getSheet(sheetName);
		// 遍历集合对象创建行和单元格
		for (int i = 0; i < datas.size(); i++) {
			// 取出Student对象
			Object o = datas.get(i);
//			if (o.getClass().equals(Aodeposit.class)) {
//				createDepositRow(sheet, i, o);
//			} else if (o.getClass().equals(Aoloan.class)) {
//				createLoanRow(sheet, i, o);
//			}
		}
		// 生成文件
		writeFile(filePath, workbook2007);
	}

	protected static void writeFile(String filePath, XSSFWorkbook workbook2007)
			throws Exception {
		File file = new File(filePath);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);
			workbook2007.write(fos);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 创建行
	private static void createLoanRow(XSSFSheet sheet, int i, Object o) {

	}

	// 创建行
	private static void createDepositRow(XSSFSheet sheet, int i, Object o)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
//		XSSFRow row = sheet.createRow(i + 1);
		XSSFRow row = sheet.getRow(i + 1);
		if(null==row){
			row = sheet.createRow(i + 1);
		}
		// 开始创建单元格并赋值
		XSSFCell custid = row.createCell(0);
		custid.setCellValue((String) PropertyUtils.getProperty(o, "custid"));// 客戶ID
		XSSFCell name = row.createCell(1);
		name.setCellValue((String) PropertyUtils.getProperty(o, "name"));// 客戶戶名
		XSSFCell aocode = row.createCell(2);
		aocode.setCellValue((String) PropertyUtils.getProperty(o, "aocode"));// AOCODE
		XSSFCell kycid = row.createCell(3);
		kycid.setCellValue((String) PropertyUtils.getProperty(o, "kycid"));// 存款KYCAO
		XSSFCell balm = row.createCell(4);
		balm.setCellValue((Double) PropertyUtils.getProperty(o, "balm"));// 月平均餘額
		XSSFCell period = row.createCell(5);
		period.setCellValue((String) PropertyUtils.getProperty(o, "period"));// 期限
		XSSFCell avgintrate = row.createCell(6);
		avgintrate.setCellValue((String) PropertyUtils.getProperty(o,
				"avgintrate"));// 當月平均利率
	}

	public static void createExcel2007(String filePath) throws Exception {
		// 先创建工作簿对象
		XSSFWorkbook workbook2007 = new XSSFWorkbook();
		// 创建工作表对象并命名
		XSSFSheet sheet = workbook2007.createSheet("学生信息统计表");
		writeFile(filePath, workbook2007);
	}

	/**
	 * 主函数
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			generateExcel2007(xls2003, xls2003, xls2003, null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + " ms done!");
	}
}