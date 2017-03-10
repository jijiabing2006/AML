///////////////////////////////////////////////////////////////////////////////
//  Copyright 2010 Ryan Kennedy <rallyredevo AT users DOT sourceforge DOT net>
//
//  This file is part of Roolie.
//
//  Roolie is free software: you can redistribute it and/or modify
//  it under the terms of the GNU Lesser General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or any later
//  version.
//
//  Roolie is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU Lesser General Public License for more details.
//
//  You should have received a copy of the GNU Lesser General Public License
//  along with Roolie.  If not, see <http://www.gnu.org/licenses/>.
///////////////////////////////////////////////////////////////////////////////

package com.lzsoft.rules.core.util;


import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Node;

import com.lzsoft.rules.core.util.component.AssertionUtil;
import com.lzsoft.rules.core.util.component.CollectionUtils;
import com.lzsoft.rules.core.util.component.IOUtil;
import com.lzsoft.rules.core.util.component.MessageUtil;
import com.lzsoft.rules.core.util.component.ObjectUtil;
import com.lzsoft.rules.core.util.component.StringUtil;
import com.lzsoft.rules.core.util.component.XmlUtil;

public class RUtil {

	public static String getRoolieMessage(String msg) {
		return MessageUtil.getRoolieMessage(msg);
	}

	public static void closeInputStream(InputStream is) {
		IOUtil.closeInputStream(is);
	}

	public static Node findSingleNode(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().findSingleNode(parent, nodeName);
	}

	public static List<Node> findAllNodes(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().findAllNodes(parent, nodeName);
	}

	public static Node getChild(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getChild(parent, nodeName);
	}

	public static List<Node> getChildren(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getChildren(parent, nodeName);
	}

	public static List<Node> getChildren(Node parent)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getChildren(parent);
	}

	public static String getAttributeValue(Node node, String attributeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getAttributeValue(node, attributeName);
	}

	public static Node findRequiredSingleNode(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().findRequiredSingleNode(parent, nodeName);
	}

	public static List<Node> findRequiredAllNodes(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().findRequiredAllNodes(parent, nodeName);
	}

	public static Node getRequiredChild(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getRequiredChild(parent, nodeName);
	}

	public static List<Node> getRequiredChildren(Node parent, String nodeName)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getRequiredChildren(parent, nodeName);
	}

	public static List<Node> getRequiredChildren(Node parent)
			throws XPathExpressionException {
		return XmlUtil.getInstance().getRequiredChildren(parent);
	}

	public static String getRequiredAttributeValue(Node node,
			String attributeName) throws XPathExpressionException {
		return XmlUtil.getInstance().getRequiredAttributeValue(node,
				attributeName);
	}

	public static String defaultIfNull(String string, String defaultString) {
		return StringUtil.defaultIfNull(string, defaultString);
	}

	public static String trimToEmpty(String string) {
		return StringUtil.trimToEmpty(string);
	}

	public static String trimToNull(String string) {
		return StringUtil.trimToNull(string);
	}

	public static boolean isNullOrEmpty(String string) {
		return StringUtil.isNullOrEmpty(string);
	}

	public static boolean isNotNullOrEmpty(String string) {
		return StringUtil.isNotNullOrEmpty(string);
	}

	public static boolean parseBoolean(String s, boolean defaultValue) {
		return StringUtil.parseBoolean(s, defaultValue);
	}

	public static boolean parseBoolean(String s) {
		return StringUtil.parseBoolean(s);
	}

	public static boolean isNullOrEmpty(Collection<?> c) {
		return CollectionUtils.isNullOrEmpty(c);
	}

	public static boolean isNotNullOrEmpty(Collection<?> c) {
		return CollectionUtils.isNotNullOrEmpty(c);
	}

	public static void assertTrue(boolean condition, String message) {
		AssertionUtil.assertTrue(condition, message);
	}

	public static void assertFalse(boolean condition, String message) {
		AssertionUtil.assertFalse(condition, message);
	}

	public static void assertNotNull(Object o, String message) {
		AssertionUtil.assertNotNull(o, message);
	}

	public static void assertNull(Object o, String message) {
		AssertionUtil.assertNull(o, message);
	}

	public static void assertNullOrEmpty(Collection<?> c, String message) {
		AssertionUtil.assertNullOrEmpty(c, message);
	}

	public static void assertNotNullOrEmpty(Collection<?> c, String message) {
		AssertionUtil.assertNotNullOrEmpty(c, message);
	}

	public static void assertExclusiveOR(boolean b1, boolean b2, String message) {
		AssertionUtil.assertExclusiveOR(b1, b2, message);
	}

	// Object util
	public static void setProperty(Object o, String propName, Object propValue) {
		ObjectUtil.setProperty(o, propName, propValue);
	}

}
