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

import java.lang.reflect.Field;

import com.lzsoft.rules.core.util.RUtil;

public class ObjectUtil
{

  public static void setProperty(Object o, String propName, Object propValue)
  {
    Field[] fields = o.getClass().getDeclaredFields();
    Field targetField = findField(fields, propName);
    targetField.setAccessible(true);
    try
    {
      targetField.set(o, propValue);
    }
    catch (Throwable t)
    {
      throw new RuntimeException(t);
    }
  }

  protected static Field findField(Field[] fields, String fieldName)
  {
    Field targetField = null;
    for (int i = 0; i < fields.length; ++i)
    {
      Field field = fields[i];
      final String name = field.getName();
      if (name.equals(fieldName))
      {
        targetField = field;
        break;
      }
    }
    if (null == targetField)
    {
      throw new RuntimeException(RUtil.getRoolieMessage("Field " + fieldName
        + " not found."));
    }
    return targetField;
  }
}
