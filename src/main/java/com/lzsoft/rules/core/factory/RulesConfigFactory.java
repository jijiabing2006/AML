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

package com.lzsoft.rules.core.factory;

import javax.xml.xpath.XPathExpressionException;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.lzsoft.rules.common.Constants;
import com.lzsoft.rules.core.config.RulesConfig;
import com.lzsoft.rules.core.exception.RulesEngineException;

public class RulesConfigFactory implements Constants {

	/** Singleton instance */
	protected static RulesConfigFactory instance = new RulesConfigFactory();

	protected RulesConfigFactory() {
		super();
	}

	/** Gets the singleton instance */
	public static RulesConfigFactory getInstance() {
		return instance;
	}

	public RulesConfig buildRulesConfig(String url)
			throws ParserConfigurationException, SAXException, IOException,
			RulesEngineException, XPathExpressionException {
		Document document = DocumentFactory.getInstance().getDocument(url);
		RulesConfig rulesConfig = buildRulesConfig(document);
		return rulesConfig;
	}

	public RulesConfig buildRulesConfig(File file)
			throws ParserConfigurationException, SAXException, IOException,
			RulesEngineException, XPathExpressionException {
		Document document = DocumentFactory.getInstance().getDocument(file);
		RulesConfig rulesConfig = buildRulesConfig(document);
		return rulesConfig;
	}

	public RulesConfig buildRulesConfig(InputStream inputStream)
			throws ParserConfigurationException, SAXException, IOException,
			RulesEngineException, XPathExpressionException {
		Document document = DocumentFactory.getInstance().getDocument(
				inputStream);
		RulesConfig rulesConfig = buildRulesConfig(document);
		return rulesConfig;
	}

	public RulesConfig buildRulesConfig(InputSource inputSource)
			throws ParserConfigurationException, SAXException, IOException,
			RulesEngineException, XPathExpressionException {
		Document document = DocumentFactory.getInstance().getDocument(
				inputSource);
		RulesConfig rulesConfig = buildRulesConfig(document);
		return rulesConfig;
	}

	public RulesConfig buildRulesConfig(Node node) throws RulesEngineException,
			XPathExpressionException {
		RulesConfig rulesConfig = RulesConfigParser.getInstance()
				.parseRulesConfig(node);
		return rulesConfig;
	}

}
