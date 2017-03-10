package com.lzsoft.aml.service.report.util;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.util.FileUtil;


public abstract class SafeXmlUtil {
	
	protected String xmlpathname ;
	protected String zippathname ;
	protected String safetype;
	
	protected SafeXmlUtil(String type){
		if(type.equalsIgnoreCase("ACC")){
			xmlpathname = Constants.ACCXMLPATHNAME;
			zippathname = Constants.ACCZIPPATHNAME;
			safetype = "ACC";
		}
		if(type.equalsIgnoreCase("JSH")){
			xmlpathname = Constants.JSHXMLPATHNAME;
			zippathname = Constants.JSHZIPPATHNAME;
			safetype = "JSH";
		}
		if(type.equalsIgnoreCase("Bop")){
			xmlpathname = Constants.BOPXMLPATHNAME;
			zippathname = Constants.BOPZIPPATHNAME;
			safetype = "BOP";
		}
	}
	
	public String writeSafeXml(String fileType, Map<String, String> fileNameMap,
			String pbocBankCode, String reportDate, String index,
			boolean reportType) throws Exception {
		FileUtil.newFolder(getRootPath() + xmlpathname);
		FileUtil.newFolder(getRootPath() + zippathname);
		Document doc = null;
		doc = getDocumentForControlFile(fileType, fileNameMap, reportType);
		if (null == doc)
			return null;
		String fileName = getRootPath()
				+ xmlpathname
				+ generateSafeReportFileName(fileType, pbocBankCode, reportDate,
						index);
		// 写xml文件头
		Format format = Format.getCompactFormat();
		format.setEncoding("gb18030");//  设置xml文件的字符为gb18030
		format.setIndent("    "); // 设置xml文件的缩进为4个空格
		XMLOutputter XMLOut = new XMLOutputter(format);// 元素后换行一层元素缩四格
		FileOutputStream out=new FileOutputStream(fileName);
		XMLOut.output(doc, out);
		out.close();
		return fileName;
	}

	public String writeSafeXml(String fileType, @SuppressWarnings("rawtypes") List dataList, String index,
			String pbocBankCode, String reportDate) throws Exception {
		Document doc = null;
		doc = getDocument(fileType, dataList);
		if (null == doc)
			return null;
		String fileName = getRootPath()
				+ xmlpathname
				+ generateSafeReportFileName(fileType, pbocBankCode, reportDate,
						index);
		// 写xml文件头
		Format format = Format.getCompactFormat();
		format.setEncoding("gb18030");// 设置xml文件的字符为gb18030
		format.setIndent("    "); // 设置xml文件的缩进为4个空格
		XMLOutputter XMLOut = new XMLOutputter(format);// 元素后换行一层元素缩四格
		FileOutputStream out=new FileOutputStream(fileName);
		XMLOut.output(doc,out );
		out.close();
		return fileName;
	}

	/**
	 * 自动生成上报文件的文件名
	 * 
	 * @param fileType
	 *            文件类型
	 * @param pbocBankCode
	 *            机构号
	 * @param reportDate
	 *            报表日期
	 * @param sequence
	 *            序号
	 * @return 上报文件的文件名
	 */
	protected String generateSafeReportFileName(String fileType,
			String pbocBankCode, String reportDate, String sequence) {
		return safetype + fileType + pbocBankCode + reportDate + sequence + ".XML";
	}

	/**
	 * 组装主控制文件的Document对象
	 * 
	 * @param fileType
	 *            文件类型
	 * @param fileNameMap
	 *            所有要生成上报文件的文件名称
	 * @return
	 */
	private Document getDocumentForControlFile(String fileType,
			Map<String, String> fileNameMap, boolean reportType) {
		Element root = new Element("MSG");
		Document doc = new Document(root);
		Element APPTYPE = new Element("APPTYPE");
		APPTYPE.setText(safetype);
		root.addContent(APPTYPE);
		Element CURRENTFILE = new Element("CURRENTFILE");
		CURRENTFILE.setText(safetype + fileType);
		root.addContent(CURRENTFILE);
		Element INOUT = new Element("INOUT");
		INOUT.setText("IN");
		root.addContent(INOUT);
		Element TOTALFILES = new Element("TOTALFILES");
		if (reportType)
			TOTALFILES.setText(fileNameMap.size() + "");
		else
			TOTALFILES.setText("0");
		root.addContent(TOTALFILES);
		if (reportType) {
			Element FILES = getFiles(fileNameMap);
			root.addContent(FILES);
		} else {
			Element FILES = new Element("FILES");
			FILES.setText(null);
			root.addContent(FILES);
		}
		return doc;
	}

	/**
	 * 设置主控制文件的FILES节点
	 * 
	 * @param fileNameMap
	 *            主控制文件FILES节点所需要的所有的文件名称
	 * @return
	 */
	private Element getFiles(Map<String, String> fileNameMap) {
		Element FILES = new Element("FILES");
		Set<Entry<String, String>> fileNameSet = fileNameMap.entrySet();
		String[] fileNames = new String[fileNameSet.size()];
		int count = 0;
		for (Entry<String, String> entry : fileNameSet) {
			if (!"T".equalsIgnoreCase(entry.getKey()))
				fileNames[count++] = entry.getValue().toString();
		}

		Arrays.sort(fileNames);
		for (String fileName : fileNames) {
			Element FILENAME = new Element("FILENAME");
			FILENAME.setText(fileName);
			FILES.addContent(FILENAME);
		}
		return FILES;
	}

	private Document getDocument(String fileType, @SuppressWarnings("rawtypes") List dataList)
			throws Exception {
		Element root = new Element("MSG");
		Document document = new Document(root);
		setCommonElement(root, fileType, dataList);
		Element RECORDS = getRecords(fileType, dataList);
		root.addContent(RECORDS);
		return document;
	}

	/**
	 * 设置公用的节点
	 * 
	 * @param root
	 *            根节点
	 * @param fileType
	 *            文件类型
	 * @param dataList
	 *            数据集合
	 */
	private void setCommonElement(Element root, String fileType, @SuppressWarnings("rawtypes") List dataList) {
		Element APPTYPE = new Element("APPTYPE");
		APPTYPE.setText(safetype);
		root.addContent(APPTYPE);
		Element CURRENTFILE = new Element("CURRENTFILE");
		CURRENTFILE.setText(safetype + fileType);
		root.addContent(CURRENTFILE);
		Element INOUT = new Element("INOUT");
		INOUT.setText("IN");
		root.addContent(INOUT);
		Element TOTALRECORDS = new Element("TOTALRECORDS");
		TOTALRECORDS.setText(dataList.size() + "");
		root.addContent(TOTALRECORDS);
	}

	private Element getRecords(String fileType, @SuppressWarnings("rawtypes") List dataList) throws Exception {
		Element RECORDS = new Element("RECORDS");
		for (Object data : dataList) {
			Element REC = getRec(fileType, data);
			RECORDS.addContent(REC);
		}
		return RECORDS;
	}

	// 根据传入的文件类型和数据动态得到REC节点
	public abstract Element getRec(String fileType, Object data) throws Exception;

	/**
	 * 得到根目录
	 * 
	 * @return
	 */
	protected String getRootPath() {
		String rootPath = this.getClass().getProtectionDomain().getCodeSource()
				.getLocation().getFile();
		rootPath = rootPath.substring(1);
		if (rootPath.indexOf("WEB-INF") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("WEB-INF"));
		else if (rootPath.indexOf("bin") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("bin"));
		else if (rootPath.indexOf("classes") != -1)
			rootPath = rootPath.substring(0, rootPath.indexOf("classes"));
		rootPath = rootPath.replaceAll("/", "\\\\");
		return rootPath.replaceAll("%20", " ");
	}

	public abstract String generateEmptyReport(String pbocBankCode, String reportDate,int parseInt);
}
