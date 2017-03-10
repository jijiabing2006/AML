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

package com.lzsoft.rules.core.util.component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.lzsoft.rules.core.util.RUtil;

public class XmlUtil {

	protected final Map<String, XPathExpression> xPathExpressions = new ConcurrentHashMap<String, XPathExpression>();

	protected final XPathFactory xPathFactory = XPathFactory.newInstance();

	protected static XmlUtil instance = new XmlUtil();

	protected XmlUtil() {
		super();
	}

	public static XmlUtil getInstance() {
		return instance;
	}

	protected XPathExpression getXPathExpression(String sExpression)
			throws XPathExpressionException {
		XPathExpression expression = xPathExpressions.get(sExpression);
		if (null == expression) {
			XPath xPath = xPathFactory.newXPath();
			expression = xPath.compile(sExpression);
			xPathExpressions.put(sExpression, expression);
		}
		return expression;
	}

	public Node findSingleNode(Node parent, String nodeName)
			throws XPathExpressionException {
		List<Node> allNodes = findAllNodes(parent, nodeName);
		Node singleNode = null;
		RUtil.assertTrue(allNodes.size() <= 1, moreThanOneSingleNode(nodeName));
		if (allNodes.size() == 1) {
			singleNode = allNodes.get(0);
		}
		return singleNode;
	}

	public List<Node> findAllNodes(Node parent, String nodeName)
			throws XPathExpressionException {
		NodeList nodes = null;
		final String sXPath = "//" + nodeName;
		XPathExpression xPathExpression = getXPathExpression(sXPath);
		nodes = (NodeList) xPathExpression.evaluate(parent,
				XPathConstants.NODESET);
		List<Node> realNodeList = createRealNodeList(nodes);
		return realNodeList;
	}

	public Node getChild(Node parent, String nodeName)
			throws XPathExpressionException {
		Node singleNode = null;
		List<Node> allChildren = getChildren(parent, nodeName);
		RUtil.assertTrue(allChildren.size() <= 1,
				moreThanOneSingleNode(nodeName));
		if (allChildren.size() == 1) {
			singleNode = allChildren.get(0);
		}
		return singleNode;
	}

	public List<Node> getChildren(Node parent, String nodeName)
			throws XPathExpressionException {
		NodeList nodes = null;
		final String sXPath = nodeName;
		XPathExpression xPathExpression = getXPathExpression(sXPath);
		nodes = (NodeList) xPathExpression.evaluate(parent,
				XPathConstants.NODESET);
		List<Node> realNodeList = createRealNodeList(nodes);
		return realNodeList;
	}

	public List<Node> getChildren(Node parent) throws XPathExpressionException {
		NodeList nodes = parent.getChildNodes();
		List<Node> realNodeList = createRealNodeList(nodes);
		return realNodeList;
	}

	public String getAttributeValue(Node node, String attributeName)
			throws XPathExpressionException {
		NamedNodeMap attributes = node.getAttributes();
		Node attributeNode = null;
		if (null != attributes) {
			attributeNode = attributes.getNamedItem(attributeName);
		}
		String attributeValue = null;
		if (null != attributeNode) {
			attributeValue = attributeNode.getNodeValue();
		}
		return attributeValue;
	}

	protected static List<Node> createRealNodeList(NodeList nodeList) {
		List<Node> realNodeList = new LinkedList<Node>();
		if (null != nodeList && nodeList.getLength() > 0) {
			for (int i = 0; i < nodeList.getLength(); ++i) {
				Node nextNode = nodeList.item(i);
				realNodeList.add(nextNode);
			}
		}
		return realNodeList;
	}

	// Required versions
	public Node findRequiredSingleNode(Node parent, String nodeName)
			throws XPathExpressionException {
		Node node = findSingleNode(parent, nodeName);
		RUtil.assertNotNull(node, missingRequiredNodeMsg(nodeName));
		return node;
	}

	public List<Node> findRequiredAllNodes(Node parent, String nodeName)
			throws XPathExpressionException {
		List<Node> nodes = findAllNodes(parent, nodeName);
		RUtil.assertNotNullOrEmpty(nodes, missingRequiredNodeMsg(nodeName));
		return nodes;
	}

	public Node getRequiredChild(Node parent, String nodeName)
			throws XPathExpressionException {
		Node child = getChild(parent, nodeName);
		RUtil.assertNotNull(child, missingRequiredChildNode(nodeName));
		return child;
	}

	public List<Node> getRequiredChildren(Node parent, String nodeName)
			throws XPathExpressionException {
		List<Node> children = getChildren(parent, nodeName);
		RUtil.assertNotNullOrEmpty(children, missingRequiredChildNode(nodeName));
		return children;
	}

	public List<Node> getRequiredChildren(Node parent)
			throws XPathExpressionException {
		List<Node> children = getChildren(parent);
		RUtil.assertNotNullOrEmpty(children, missingRequiredChildNode(""));
		return children;
	}

	public String getRequiredAttributeValue(Node node, String attributeName)
			throws XPathExpressionException {
		String attributeValue = getAttributeValue(node, attributeName);
		RUtil.assertNotNull(attributeValue,
				missingRequiredAttributeMsg(attributeName));
		return attributeValue;
	}

	// Error messages
	protected static String missingRequiredNodeMsg(String nodeName) {
		return "Missing required node(s) " + nodeName;
	}

	protected static String missingRequiredAttributeMsg(String attribName) {
		return "Missing required attribute " + attribName;
	}

	protected static String missingRequiredChildNode(String nodeName) {
		return "Missing required child node(s) " + nodeName;
	}

	protected static String moreThanOneSingleNode(String nodeName) {
		return "More than one " + nodeName + " element was found";
	}
}
