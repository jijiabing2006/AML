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

import java.util.Collection;

import com.lzsoft.rules.core.util.RUtil;

public class AssertionUtil {
	public static void assertTrue(boolean condition, String message) {
		assert condition : RUtil.getRoolieMessage(message);
	}

	public static void assertFalse(boolean condition, String message) {
		assertTrue(!condition, message);
	}

	public static void assertNotNull(Object o, String message) {
		assertTrue(null != o, message);
	}

	public static void assertNull(Object o, String message) {
		assertTrue(null == o, message);
	}

	public static void assertNullOrEmpty(Collection<?> c, String message) {
		assertTrue(RUtil.isNullOrEmpty(c), message);
	}

	public static void assertNotNullOrEmpty(Collection<?> c, String message) {
		assertTrue(RUtil.isNotNullOrEmpty(c), message);
	}

	public static void assertExclusiveOR(boolean b1, boolean b2, String message) {
		assertTrue(b1 ^ b2, message);
	}
}
