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

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.lzsoft.rules.core.util.RUtil;

public class IOUtil
{
  public static void closeInputStream(InputStream is)
  {
    if (null != is)
    {
      try
      {
        is.close();
      }
      catch (IOException e)
      {
        Logger.getLogger(IOUtil.class.getName()).log(
          Level.SEVERE, RUtil.getRoolieMessage(
          "Error closing input Stream."), e);
      }
    }
  }

}
