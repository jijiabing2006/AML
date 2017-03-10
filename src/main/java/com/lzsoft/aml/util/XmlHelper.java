package com.lzsoft.aml.util;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.*;

/**
 * XML读取的帮助类
 *
 */
public class XmlHelper {

	/**
	 * 读取XML并返回一个Document
	 * @param filePath 要读取的指定的文件夹
	 * @param fileName 要读取的指定的文件夹下的文件名称
	 * @return XML文件的Document对象
	 */
	public static Document getDocument(String filePath, String fileName) {
		
		return getDocument((new StringBuilder(String.valueOf(filePath)))
				.append(File.separator).append(fileName).toString());
		
	}

	/**
	 * 读取XML并返回一个Document
	 * @param in 一个读取XML的InputStream
	 * @return XML文件的Document对象
	 */
	public static Document getDocument(InputStream in) throws DocumentException {
		
		SAXReader reader = new SAXReader();
		
		return reader.read(in);
	}

	/**
	 * 读取XML并返回一个Document
	 * @param fileName 要读取的XML文件的路径
	 * @return XML文件的Document对象
	 */
	public static Document getDocument(String fileName) {
		
		SAXReader reader = new SAXReader();
		
		Document document;
		
		File file = new File(fileName);
		
		try {
			
			document = reader.read(file);
			
			return document;
			
		} catch (DocumentException e) {
			
			e.printStackTrace();
			
		}
		return null;
	}

	/**
	 * 	读取指定元素下的指定节点
	 * @param e 指定的元素
	 * @param name 指定的节点名称
	 * @return 一个Element元素
	 */
	@SuppressWarnings("unchecked")
	public static Element getElementByName(Element e, String name) {
		
		Iterator iterator = e.elementIterator(name);
		
		if (iterator.hasNext())
			
			return (Element) iterator.next();
		
		else
			
			return null;
		
	}

	/**
	 * 	读取指定元素下的指定节点
	 * @param e 指定的元素
	 * @param name 指定的节点名称
	 * @return 一个Element元素的集合
	 */
	@SuppressWarnings("unchecked")
	public static List getElementsByName(Element e, String name) {
		
		return e.elements(name);
		
	}

	@SuppressWarnings("unchecked")
	public static Element getElementByNameAndAttribute(Element e, String name,
			String attribute, String value) {
		
		for (Iterator iterator = e.elementIterator(name); iterator.hasNext();) {
			
			Element element = (Element) iterator.next();
			
			if (value.equals(element.attribute(attribute).getValue()))
				
				return element;
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public static String getElementValueByName(Element e, String name) {
		
		Iterator iterator = e.elementIterator(name);
		
		if (iterator.hasNext())
			
			return ((Element) iterator.next()).getText();
		
		else
			
			return "";
		
	}

	@SuppressWarnings("unchecked")
	public static String getElementAttributeByName(Element e, String name,
			String attribute) {
		
		Iterator iterator = e.elementIterator(name);
		
		if (iterator.hasNext())
			
			return ((Element) iterator.next()).attribute(attribute).getValue();
		
		else
			
			return "";
		
	}

	@SuppressWarnings("unchecked")
	public static String[] getElementValuesByName(Element e, String name) {
		
		Iterator iterator = e.elementIterator(name);
		
		StringBuffer buffer = new StringBuffer();
		
		while (iterator.hasNext())
			
			if ("".equals(buffer.toString()))
				
				buffer.append(((Element) iterator.next()).getText());
			else
				
				buffer.append((new StringBuilder(String
						.valueOf(((Element) iterator.next()).getText())))
						.append(",").toString());
		
		return StringHelper.stringToArray(buffer.toString(), ",");
		
	}

	public static Document createDocument() {
		
		Document document = DocumentHelper.createDocument();
		
		return document;
		
	}

	public static Element createRootElement(Document document, String rootName) {
		
		if (document != null)
			
			return document.addElement(rootName);
		
		else
			
			return null;
		
	}

	public static Element createElement(Element pElement, String elementName,
			String elmentText) {
		
		if (pElement != null && !StringHelper.isNullOrEmpty(elmentText)) {
			
			Element nElement = pElement.addElement(elementName);
			
			if (!StringHelper.isNullOrEmpty(elmentText))
				
				nElement.addText(elmentText);
			
			return nElement;
			
		} else {
			
			return null;
			
		}
		
	}

	public static void saveXml(Document document, OutputStream os,
			String encoding) {
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		
		format.setEncoding(defaultEncoding);
		
		XMLWriter output = null;
		
		try {
			
			output = new XMLWriter(os, format);
			
			output.write(document);
			
			output.close();
			
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
	}

	public static void saveXml(Document document, OutputStream os) {
		
		saveXml(document, os, defaultEncoding);
		
	}

	public static void saveXml(Element element, OutputStream os) {
		
		Document document = DocumentHelper.createDocument();
		
		document.add(element);
		
		saveXml(document, os, defaultEncoding);
		
	}

	private static String defaultEncoding = "GBK";

}
