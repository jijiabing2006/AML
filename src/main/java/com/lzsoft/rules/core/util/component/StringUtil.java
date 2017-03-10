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

public class StringUtil
{
  public static String defaultIfNull(String string, String defaultString)
  {
    String returnString = defaultString;
    if (null != string)
    {
      returnString = string;
    }
    return returnString;
  }

  public static String trimToEmpty(String string)
  {
    String s = "";
    if (null != string)
    {
      s = string.trim();
    }
    return s;
  }

  public static String trimToNull(String string)
  {
    String s = null;
    if (null != string)
    {
      string = string.trim();
    }
    if (string.length() > 0)
    {
      s = string;
    }
    return s;
  }

  public static boolean isNullOrEmpty(String string)
  {
    boolean isNullOrEmpty = true;
    String s = trimToNull(string);
    if (null != s)
    {
      isNullOrEmpty = false;
    }
    return isNullOrEmpty;
  }

  public static boolean isNotNullOrEmpty(String string)
  {
    return ! isNullOrEmpty(string);
  }

  public static boolean parseBoolean(String s, boolean defaultValue)
  {
    boolean b = defaultValue;
    s = trimToEmpty(s);
    s = s.toLowerCase();
    try
    {
      b = Boolean.parseBoolean(s);
    }
    catch(Throwable t)
    {
      // Ignore parse errors
    }
    return b;
  }

  public static boolean parseBoolean(String s)
  {
    return parseBoolean(s, false);
  }
}
