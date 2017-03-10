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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DocumentFactory
{
  protected static final DocumentFactory instance = new DocumentFactory();
  
  protected DocumentFactory()
  {
    super();
  }

  public static DocumentFactory getInstance()
  {
    return instance;
  }

  public Document getDocument(String url)
    throws ParserConfigurationException, SAXException, IOException
  {
    DocumentBuilder docBuilder = getDocumentBuilder();
    Document doc = docBuilder.parse(url);
    return doc;
  }

  public Document getDocument(File file)
    throws ParserConfigurationException, SAXException, IOException
  {
    DocumentBuilder docBuilder = getDocumentBuilder();
    Document doc = docBuilder.parse(file);
    return doc;
  }

  public Document getDocument(InputStream inputStream)
    throws ParserConfigurationException, SAXException, IOException
  {
    try
    {
      DocumentBuilder docBuilder = getDocumentBuilder();
      Document doc = docBuilder.parse(inputStream);
      return doc;
    }
    finally
    {
      if (null != inputStream)
      {
        inputStream.close();
      }
    }
  }

  public Document getDocument(InputSource inputSource)
    throws ParserConfigurationException, SAXException, IOException
  {
    try
    {
      DocumentBuilder docBuilder = getDocumentBuilder();
      Document doc = docBuilder.parse(inputSource);
      return doc;
    }
    finally
    {
      InputStream is = inputSource.getByteStream();
      if (null != is)
      {
       is.close();
      }
    }
  }

  protected static DocumentBuilder getDocumentBuilder()
    throws ParserConfigurationException
  {
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    return docBuilder;
  }
}
