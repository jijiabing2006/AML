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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InstanceFactory<T> {
	protected final Map<String, T> cache = new ConcurrentHashMap<String, T>();

	public T cachedInstance(String qualifiedClassName) {
		T t = cache.get(qualifiedClassName);
		if (((T) null) == t) {
			t = (T) newInstance(qualifiedClassName);
			cache.put(qualifiedClassName, t);
		}
		return t;
	}

	@SuppressWarnings("unchecked")
	public T newInstance(String qualifiedClassName) {
		T t = null;
		try {
			t = (T) Class.forName(qualifiedClassName).newInstance();
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		return t;
	}
}
