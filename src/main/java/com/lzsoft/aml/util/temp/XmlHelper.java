package com.lzsoft.aml.util.temp;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import org.dom4j.*;
import org.dom4j.io.*;

/**
 * XML��ȡ�İ�����
 * 
 * @author 
 * 
 */
public class XmlHelper {

	/**
	 * ��ȡXML������һ��Document
	 * 
	 * @param filePath
	 *            Ҫ��ȡ��ָ�����ļ���
	 * @param fileName
	 *            Ҫ��ȡ��ָ�����ļ����µ��ļ����
	 * @return XML�ļ���Document����
	 * @throws DocumentException 
	 */
	public static Document getDocument(String filePath, String fileName) throws DocumentException {

		return getDocument((new StringBuilder(String.valueOf(filePath)))
				.append(File.separator).append(fileName).toString());

	}

	/**
	 * ��ȡXML������һ��Document
	 * 
	 * @param in
	 *            һ����ȡXML��InputStream
	 * @return XML�ļ���Document����
	 */
	public static Document getDocument(InputStream in) throws DocumentException {

		SAXReader reader = new SAXReader();

		return reader.read(in);
	}

	/**
	 * ��ȡXML������һ��Document
	 * 
	 * @param fileName
	 *            Ҫ��ȡ��XML�ļ���·��
	 * @return XML�ļ���Document����
	 * @throws DocumentException 
	 */
	public static Document getDocument(String fileName) throws DocumentException {

		SAXReader reader = new SAXReader();

		Document document;

		File file = new File(fileName);

		try {

			document = reader.read(file);

			return document;

		} catch (DocumentException e) {

			e.printStackTrace();
			throw e;

		}
	}

	/**
	 * ��ȡָ��Ԫ���µ�ָ���ڵ�
	 * 
	 * @param e
	 *            ָ����Ԫ��
	 * @param name
	 *            ָ���Ľڵ����
	 * @return һ��ElementԪ��
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
	 * ��ȡָ��Ԫ���µ�ָ���ڵ�
	 * 
	 * @param e
	 *            ָ����Ԫ��
	 * @param name
	 *            ָ���Ľڵ����
	 * @return һ��ElementԪ�صļ���
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
			String encoding) throws IOException {

		OutputFormat format = OutputFormat.createPrettyPrint();

		format.setEncoding(defaultEncoding);

		XMLWriter output = null;

		try {

			output = new XMLWriter(os, format);

			output.write(document);

			output.close();

		} catch (UnsupportedEncodingException e) {

			e.printStackTrace();
			throw e;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
			throw e;

		} catch (IOException e) {

			e.printStackTrace();
			throw e;

		}
	}

	public static void saveXml(Document document, OutputStream os) throws IOException {

		saveXml(document, os, defaultEncoding);

	}

	public static void saveXml(Element element, OutputStream os) throws IOException {

		Document document = DocumentHelper.createDocument();

		document.add(element);

		saveXml(document, os, defaultEncoding);

	}

	private static String defaultEncoding = "GBK";

}
