package com.lzsoft.aml.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.entity.annotation.FieldDisplayName;

/**
 * 导出数据到Excel文件
 * 
 * @author john
 * 
 * @time 2009/07/18
 * 
 */
public class ExcelExport {

	private HSSFWorkbook allWorkbook = null;

	public ExcelExport() {

	}

	/**
	 * 导出数据库数据到Excel文件
	 * 
	 * @param list
	 *            需要导出的数据
	 * @param sheetname
	 *            Excel里sheet的名称
	 * @param fileName
	 *            Excel文件的名称
	 * @param savePath
	 *            文件存放的路径,指定到某一文件夹下
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IOException
	 */
	public static void exportDataToExcel(List<Object> list, String sheetname,
			String fileName, String savePath, boolean byfdn)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();

		ExcelExport.writeExcel(workbook, list, sheetname, byfdn);

		try {
			// 保存文件
			saveExcelFile(workbook, savePath + File.separator + fileName
					+ ".xls");
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			workbook = null;
		}

	}

	/**
	 * 导出数据到Excel文件
	 * 
	 * @param map
	 *            需要导出的数据
	 * @param fileName
	 *            Excle文件名
	 * @param savePath
	 *            文件存放路径,指定某一个文件夹下
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("rawtypes")
	public static void exportDataToExcel(Map<String, List> map,
			String fileName, String savePath, boolean byfdn)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		try {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				ExcelExport.writeExcel(workbook, map.get(key), key, byfdn);
			}
			// 保存文件
			saveExcelFile(workbook, savePath + File.separator + fileName
					+ ".xls");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			workbook = null;
		}

	}

	/**
	 * 保存Excel文件
	 * 
	 * @param workbook
	 *            Excel表对象
	 * @param saveFilePath
	 *            文件存放的路径（完整路径，包括文件名）
	 * @throws IOException
	 */
	public static void saveExcelFile(HSSFWorkbook workbook, String saveFilePath)
			throws IOException {
		FileOutputStream fos = new FileOutputStream(saveFilePath);
		workbook.write(fos);
		fos.close();
	}

	/**
	 * 把一个list的数据保存成excel文件（针对单个表数据的导出）
	 * 
	 * @param list需要保存的数据
	 * @param userName当前用户的名称
	 * @param rootPath系统的根目录
	 * @return 文件的下载路径
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String export(List list, String userName, String rootPath,
			boolean byfdn) throws Exception {

		String folderPathName = rootPath + Constants.EXCEL_FILE_EXPORT
				+ userName;
		FileUtil.newFolder(folderPathName);
		FileUtils.cleanDirectory(new File(folderPathName));

		String currentClassName = "";
		// 获得当前类的名称
		if (StringHelper.isNullOrEmpty(currentClassName)) {
			currentClassName = list.get(0).getClass().getSimpleName()
					.toUpperCase();
		}
		// 用于存放有多个文件的excel
		String zipFolderPathName = "";
		boolean f=list.size() > Constants.EXCEL_EXPORT_LINES;
		if (f) {//拆分为多个Excel

			zipFolderPathName = folderPathName + File.separator
					+ currentClassName;
			FileUtil.newFolder(zipFolderPathName);
			FileUtils.cleanDirectory(new File(zipFolderPathName));
			List slist = ArrayUtil.separateList(list,
					Constants.EXCEL_EXPORT_LINES);
			for (int i = 1; i < slist.size(); i++) {
				List sslist = (List) slist.get(i);
				ExcelExport.exportDataToExcel(sslist, currentClassName,
						currentClassName + i, zipFolderPathName, byfdn);
			}
		} else {
			ExcelExport.exportDataToExcel(list, currentClassName,
					currentClassName, folderPathName, byfdn);
		}
		/*
		// 每10000条数据，保存成一个excel文件
		List<Object> newlist = new ArrayList<Object>();
		int count = 1;
		int i = 0;
		for (Object object : list) {
			i++;
			newlist.add(object);

			// 当数据到达10000条是，保存当前的数据到一excel文件里
			if (i >= Constants.EXCEL_EXPORT_LINES) {
				// 当需要分成多个文件时，创建一个专门放多个excel的文件夹
				if (count == 1) {
					zipFolderPathName = folderPathName + File.separator
							+ currentClassName;
					FileUtil.newFolder(zipFolderPathName);
				}
				// 保存到指定目录的excel文件
				ExcelExport.exportDataToExcel(newlist, currentClassName,
						currentClassName + count, zipFolderPathName, byfdn);
				i = 0;
				newlist.clear();
				count++;
			}
		}

		// 如果循环后还有剩余的记录，保存到另一个文件
		if (newlist.size() > 0) {
			if (count == 1) {
				ExcelExport.exportDataToExcel(newlist, currentClassName,
						currentClassName, folderPathName, byfdn);
			} else {
				ExcelExport.exportDataToExcel(newlist, currentClassName,
						currentClassName + count, zipFolderPathName, byfdn);
			}
		}
*/
		// 如果总记录数小于10000，则保存成一个文件，反之则把生成的多个excel文件压缩成zip压缩文件，并返回下载文件的路径
		if (!f) {
			return rootPath + Constants.EXCEL_FILE_EXPORT + userName
					+ File.separator + currentClassName + ".xls";
		} else {
			String newFolderPath = rootPath + Constants.EXCEL_FILE_EXPORT
					+ "zip" + File.separator;
			FileUtil.newFolder(newFolderPath);
			FileUtils.cleanDirectory(new File(newFolderPath));
			String downPathAndFileName = newFolderPath + userName + ".zip";
			ZipUtil.toZipByFolderNoRootFolder(folderPathName + File.separator,
					downPathAndFileName, "");
			return downPathAndFileName;
		}
	}

	/**
	 * 把一个list的数据保存成excel文件(针对批量导出，每个表对应一个文件)
	 * 
	 * @param list需要保存的数据
	 * @param userName当前用户的名称
	 * @param rootPath系统的根目录
	 * @param isCompression
	 *            是否压缩存放生成EXCEL的文件夹
	 * @return 文件的下载路径
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static String exportAll(List list, String userName, String rootPath,
			boolean isCompression, boolean byfdn) throws Exception {

		String folderPathName = rootPath + Constants.EXCEL_FILE_EXPORT
				+ userName + "_all" + File.separator + "datasource"
				+ File.separator;
		// 如果文件夹不存在，创建文件夹
		FileUtil.newFolder(folderPathName);

		// 每20000条数据，保存成一个excel文件
		List<Object> newlist = new ArrayList<Object>();
		int count = 1;
		int i = 0;
		String currentClassName = "";
		for (Object object : list) {
			i++;
			newlist.add(object);
			// 获得当前类的名称
			if (StringHelper.isNullOrEmpty(currentClassName)) {
				currentClassName = object.getClass().getSimpleName()
						.toUpperCase();
			}
			// 当数据到达20000条是，保存当前的数据到一excel文件里
			if (i >= 20000) {

				// 保存到指定目录的excel文件
				ExcelExport.exportDataToExcel(newlist, currentClassName,
						currentClassName + count, folderPathName, byfdn);
				i = 0;
				newlist.clear();
				count++;
			}
		}

		// 如果循环后还有剩余的记录，保存到另一个文件
		if (newlist.size() > 0) {
			String fileName = "";
			if (count == 1) {
				fileName = currentClassName;
			} else {
				fileName = currentClassName + i;
			}
			ExcelExport.exportDataToExcel(newlist, currentClassName,
					currentClassName, folderPathName, byfdn);

		}

		// 判断是否需要将文件压缩成zip压缩文件，并返回下载文件的路径
		if (isCompression) {
			String newFolderPath = rootPath + Constants.EXCEL_FILE_EXPORT
					+ userName + "_all" + File.separator + "datasource.zip";
			FileUtil.newFolder(newFolderPath);
			// 参数一：需要压缩的文件夹，参数二：是否是目录，参数三：压缩好的文件存放位置
			ZipUtil.toZipByFolderNoRootFolder(folderPathName, newFolderPath, "");
			return newFolderPath;
		} else {
			return "";
		}

	}

	/**
	 * 把一个list的数据保存成excel文件(针对批量导出，导出到一个文件分多个sheet)
	 * 
	 * @param list需要保存的数据
	 * @param userName当前用户的名称
	 * @param rootPath系统的根目录
	 * @param isCompression
	 *            是否压缩存放生成EXCEL的文件夹
	 * @return 文件的下载路径
	 * @throws Exception
	 */

	@SuppressWarnings("rawtypes")
	public String exportAll2(List list, String sourceFolder,
			String xlsFilePath, String zipFilePath, boolean isEnd, boolean byfdn)
			throws Exception {
		/*
		 * HSSFWorkbook allWorkbook; File excelfile = new File(xlsFilePath);
		 * if(excelfile.exists()){ allWorkbook = openExcel(excelfile); }else{
		 * allWorkbook = new HSSFWorkbook(); }
		 */
		if (allWorkbook == null) {
			allWorkbook = new HSSFWorkbook();
		}

		if (list != null && !list.isEmpty()) {
			// 每20000条数据，保存成一个sheet
			List<Object> newlist = new ArrayList<Object>();
			int count = 1;
			int i = 0;
			String currentClassName = "";
			for (Object object : list) {
				i++;
				newlist.add(object);
				// 获得当前类的名称
				if (StringHelper.isNullOrEmpty(currentClassName)) {
					currentClassName = object.getClass().getSimpleName()
							.toUpperCase();
				}
				// 当数据到达20000条是，保存当前的数据到一excel文件里
				if (i >= 20000) {

					// 保存到指定目录的excel文件
					writeExcel(allWorkbook, newlist, currentClassName + count,
							byfdn);
					i = 0;
					newlist.clear();
					count++;
				}
			}

			// 如果循环后还有剩余的记录，保存到另一个文件
			if (newlist.size() > 0) {
				String sheetName = "";
				if (count == 1) {
					sheetName = currentClassName;
				} else {
					sheetName = currentClassName + count;
				}
				writeExcel(allWorkbook, newlist, sheetName, byfdn);
				newlist.clear();
			}

			// 到达最后一个文件时，压缩
			if (isEnd) {
				try {
					saveExcelFile(allWorkbook, xlsFilePath);
					// 压缩文件
					ZipUtil.toZipByFolderNoRootFolder(sourceFolder,
							zipFilePath, "");
				} catch (IOException e) {
					e.printStackTrace();
					throw e;
				} finally {
					allWorkbook = null;
				}
				return zipFilePath;
			} else {
				list.clear();
				return "";
			}
		} else {
			return "";
		}

	}

	/**
	 * 向excel写入数据
	 * 
	 * @param workbook
	 *            工作部
	 * @param list
	 *            待写入的数据
	 * @param sheetname
	 *            工作表名称
	 * @param byfdn
	 *            是否按照FieldDisplayName进行输出
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	@SuppressWarnings("rawtypes")
	private static void writeExcel(HSSFWorkbook workbook, List list,
			String sheetname, boolean byfdn) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		Class clazz = list.get(0).getClass();
		Field[] fields = getOutputFields(clazz, byfdn);

		int colindex = 0;
		int rowIndex = 0;
		HSSFSheet sheet = workbook.createSheet(sheetname);

		creatFirstRowWithFieldNames(fields, colindex, rowIndex, sheet);

		createOtherRowsAfterFirst(list, fields, rowIndex, sheet);

	}

	/**
	 * 从rowIndex后一行开始写入数据
	 * 
	 * @param list
	 * @param fields
	 * @param rowIndex
	 * @param sheet
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	private static void createOtherRowsAfterFirst(List list, Field[] fields,
			int rowIndex, HSSFSheet sheet) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		int colindex;
		rowIndex++;// 第二行开始写数据
//		Object object = null;
//		for (Iterator<Object> iter = list.iterator(); iter.hasNext();) {
//			object = iter.next();
//			colindex = 0;
//			colindex = writeCell(fields, object, colindex, rowIndex, sheet);
//			rowIndex++;
//			iter.remove();
//		}
		for (Object object : list) {
			
			colindex = 0;
			colindex = writeCell(fields, object, colindex, rowIndex, sheet);
			rowIndex++;
		}
	}

	private static Field[] getOutputFields(Class<? extends Object> clazz,
			boolean byfdn) {
		Field[] fields = clazz.getDeclaredFields();
		Field[] sfields = clazz.getSuperclass().getDeclaredFields();// 有父类，没有父类。。？如何处理
		if (sfields.length > 0) {
			fields = ArrayUtil.concat(fields, sfields);
		}
		if (byfdn) {
			fields = getOutFields(fields);// 输出有FeildDisplay
		}
		return fields;
	}

	/**
	 * 写第一行的字段名
	 * 
	 * @param fields
	 * @param colindex
	 * @param rowIndex
	 * @param sheet
	 */
	private static void creatFirstRowWithFieldNames(Field[] fields,
			int colindex, int rowIndex, HSSFSheet sheet) {
		FieldDisplayName fieldDisplayName = null;
		HSSFCell lblcell;
		HSSFRow row = sheet.createRow(rowIndex);
		for (Field field : fields) {
			if (null != field && !field.getName().equals("serialVersionUID")) {
				lblcell = row.createCell(colindex++);
				fieldDisplayName = field.getAnnotation(FieldDisplayName.class);
				if (null != fieldDisplayName
						&& StringUtils.isNotEmpty(fieldDisplayName.value())) {
					lblcell.setCellValue(fieldDisplayName.value() + "/"
							+ field.getName().toUpperCase());
				} else {
					lblcell.setCellValue(field.getName().toUpperCase());
				}
			}
		}
	}

	private static Field[] getOutFields(Field[] fields) {
		Field[] t = new Field[fields.length];

		int i = 0;
		for (Field field : fields) {
			if (null != field
					&& field.isAnnotationPresent(FieldDisplayName.class)
					&& !field.getName().equals("serialVersionUID")) {
				t[i] = field;
				i++;
			}
		}

		return t;
	}

	/**
	 * 打开excel文件，获得工作表
	 * 
	 * @throws IOException
	 */
	public static HSSFWorkbook openExcel(File file) throws IOException {

		FileInputStream fs = null;

		try {
			// 创建文件流
			fs = new FileInputStream(file);
			// 创建POIFSFileSystem读取excel的对象
			POIFSFileSystem poifs = new POIFSFileSystem(fs);
			// 获得工作簿
			HSSFWorkbook work = new HSSFWorkbook(poifs);

			return work;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public static int writeCell(Field[] fields, Object obj, int colIndex,
			int rowIndex, HSSFSheet sheet) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		HSSFCell lblcell = null;
		HSSFCell numcell = null;
		HSSFRow row = sheet.createRow(rowIndex);
		for (Field field : fields) {
			if (null != field && !field.getName().equals("serialVersionUID")) {
				if (field.getType().getSimpleName().equals("Double")
						|| field.getType().getSimpleName().equals("Integer")
						|| field.getType().getSimpleName().equals("Long")) {
					Object value = PropertyUtils.getProperty(obj,
							field.getName());
					if (null != value) {
						numcell = row.createCell(colIndex);
						numcell.setCellValue(Double.parseDouble(value
								.toString()));
					}
				} else {
					Object value = PropertyUtils.getProperty(obj,
							field.getName());
					if (null != value) {
						lblcell = row.createCell(colIndex);
						lblcell.setCellValue(value.toString());
					}
				}
				colIndex++;
			}
		}
		return colIndex;
	}

	/**
	 * 把一个Map中的数据保存成excel文件（以Map的key为sheetname）
	 * 
	 * @param map需要保存的数据
	 * @param userName当前用户的名称
	 * @param rootPath系统的根目录
	 * @return 文件的下载路径
	 * @throws Exception
	 */

	@SuppressWarnings("rawtypes")
	public static String export(Map<String, List> map, String fileName,
			String userName, String rootPath, boolean byfdn) throws Exception {

		String folderPathName = rootPath + Constants.EXCEL_FILE_EXPORT
				+ userName;
		FileUtil.newFolder(folderPathName);
		// 用于存放有多个文件的excel
		String zipFolderPathName = "";
		int splitCount = 10000;
		Set<String> keys = map.keySet();
		for (String key : keys) {
			List dataList = (List) map.get(key);// 得到为Key的List
			List tempList = null;
			int count = dataList.size() / splitCount;// 得到List大于splitcount的倍数
			for (int i = 0; i < count; i++) {
				int fromIndex = i * splitCount;// 开始拆分的下标
				int toIndex = (i + 1) * splitCount - 1;// 结束拆分的下标
				if (toIndex > dataList.size())
					toIndex = dataList.size();// 如果结束拆分的下标已经大于list的size,以list的size为最终下标
				tempList = dataList.subList(fromIndex, toIndex);// 得到拆分后的list
				map.put(key + i, tempList);// 将新得到的list放入到map中
			}
			if (count > 0) {// count大于0,说明最少被拆分成2个tempList,并放入map中
				map.remove(key);// 将原有的list从Map中移除
			}
		}

		ExcelExport.exportDataToExcel(map, fileName, folderPathName, byfdn);

		String newFolderPath = rootPath + Constants.EXCEL_FILE_EXPORT + "zip"
				+ File.separator;
		FileUtil.newFolder(newFolderPath);
		zipFolderPathName = newFolderPath + fileName + ".zip";
		ZipUtil.toZipByFolderNoRootFolder(folderPathName + File.separator,
				zipFolderPathName, "");
		return zipFolderPathName;
	}
}
