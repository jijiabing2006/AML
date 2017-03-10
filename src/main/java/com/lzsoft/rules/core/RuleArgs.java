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

package com.lzsoft.rules.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 * Arguments passed to rules to evaluate.
 * </p>
 * <p>
 * You will likely subclass this class and wrap getters and setters around the
 * properties your rules care about.
 * </p>
 */
public class RuleArgs {
	/**
	 * The arguments.
	 */
	protected Map<Object, Object> argMap;

	/**
	 * Constructs an instance with an empty <code>argMap</code>.
	 */
	public RuleArgs() {
		this.argMap = new HashMap<Object, Object>();
	}

	/**
	 * Constructs an instance with <code>argMap</code> set to
	 * <code>arguments</code>.
	 * 
	 * @param arguments
	 */
	public RuleArgs(Map<Object, Object> arguments) {
		this.argMap = arguments;
	}

	/**
	 * Returns the <code>argMap</code>.
	 */
	public Map<Object, Object> getArgMap() {
		return argMap;
	}

	/**
	 * Sets the <code>argMap</code>
	 * 
	 * @param argMap
	 */
	public void setArgMap(Map<Object, Object> argMap) {
		this.argMap = argMap;
	}

	/**
	 * Gets a String arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>, or null if
	 *         <code>argMap</code> value is null.
	 */
	public String getString(Object key) {
		return getString(key, null);
	}

	/**
	 * Gets a String arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public String getString(Object key, String defaultValue) {
		String value = defaultValue;
		String foundValue = (String) getArgMap().get(key);
		if (null != foundValue) {
			value = foundValue;
		}
		return value;
	}

	/**
	 * Sets a String arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setString(Object key, String value) {
		getArgMap().put(key, value);
	}

	/**
	 * Gets an int arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public int getInt(Object key, int defaultValue) {
		int value = defaultValue;
		Integer oValue = (Integer) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.intValue();
		}
		return value;
	}

	/**
	 * Gets an int arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public int getInt(Object key) {
		Integer oValue = (Integer) getArgMap().get(key);
		int value = oValue.intValue();
		return value;
	}

	/**
	 * Sets an int arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setInt(Object key, int value) {
		Integer oValue = new Integer(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets a long arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public long getLong(Object key, long defaultValue) {
		long value = defaultValue;
		Long oValue = (Long) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.longValue();
		}
		return value;
	}

	/**
	 * Gets a long arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public long getLong(Object key) {
		Long oValue = (Long) getArgMap().get(key);
		long value = oValue.longValue();
		return value;
	}

	/**
	 * Sets a long arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setLong(Object key, long value) {
		Long oValue = new Long(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets a byte arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public byte getByte(Object key, byte defaultValue) {
		byte value = defaultValue;
		Byte oValue = (Byte) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.byteValue();
		}
		return value;
	}

	/**
	 * Gets a byte arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public byte getByte(Object key) {
		Byte oValue = (Byte) getArgMap().get(key);
		byte value = oValue.byteValue();
		return value;
	}

	/**
	 * Sets a byte arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setByte(Object key, byte value) {
		Byte oValue = new Byte(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets a float arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public float getFloat(Object key, float defaultValue) {
		float value = defaultValue;
		Float oValue = (Float) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.floatValue();
		}
		return value;
	}

	/**
	 * Gets a float arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public float getFloat(Object key) {
		Float oValue = (Float) getArgMap().get(key);
		float value = oValue.floatValue();
		return value;
	}

	/**
	 * Sets a float arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setFloat(Object key, float value) {
		Float oValue = new Float(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets a double arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public double getDouble(Object key, double defaultValue) {
		double value = defaultValue;
		Double oValue = (Double) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.doubleValue();
		}
		return value;
	}

	/**
	 * Gets a double arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public double getDouble(Object key) {
		Double oValue = (Double) getArgMap().get(key);
		double value = oValue.doubleValue();
		return value;
	}

	/**
	 * Sets a double arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setDouble(Object key, double value) {
		Double oValue = new Double(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets a boolean arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public boolean getBoolean(Object key, boolean defaultValue) {
		boolean value = defaultValue;
		Boolean oValue = (Boolean) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.booleanValue();
		}
		return value;
	}

	/**
	 * Gets a boolean arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public boolean getBoolean(Object key) {
		Boolean oValue = (Boolean) getArgMap().get(key);
		boolean value = oValue.booleanValue();
		return value;
	}

	/**
	 * Sets a boolean arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setBoolean(Object key, boolean value) {
		Boolean oValue = new Boolean(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets a char arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public char getChar(Object key, char defaultValue) {
		char value = defaultValue;
		Character oValue = (Character) getArgMap().get(key);
		if (null != oValue) {
			value = oValue.charValue();
		}
		return value;
	}

	/**
	 * Gets a char arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>.
	 * @throws NullPointerException
	 *             If value in <code>argMap</code> is null.
	 */
	public char getChar(Object key) {
		Character oValue = (Character) getArgMap().get(key);
		char value = oValue.charValue();
		return value;
	}

	/**
	 * Sets a char arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setChar(Object key, char value) {
		Character oValue = new Character(value);
		getArgMap().put(key, oValue);
	}

	/**
	 * Gets an Object arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param defaultValue
	 *            Value to return if <code>argMap</code> value is null.
	 * @return Corresponding value in <code>argMap</code>, or
	 *         <code>defaultValue</code> if <code>argMap</code> value is null.
	 */
	public Object getObject(Object key, Object defaultValue) {
		Object value = defaultValue;
		Object oValue = getArgMap().get(key);
		if (null != oValue) {
			value = oValue;
		}
		return value;
	}

	/**
	 * Gets an Object arg from <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @return Corresponding value in <code>argMap</code>, or null if
	 *         <code>argMap</code> value is null.
	 */
	public Object getObject(Object key) {
		return getObject(key, null);
	}

	/**
	 * Sets an Object arg in <code>argMap</code>.
	 * 
	 * @param key
	 *            Key for this value in <code>argMap</code>.
	 * @param value
	 *            Corresponding value in <code>argMap</code>.
	 */
	public void setObject(Object key, Object value) {
		getArgMap().put(key, value);
	}

	/**
	 * Whether an argument is set in <code>argMap</code>, testing the value
	 * against null.
	 * 
	 * @param key
	 *            Key for the value in <code>argMap</code>.
	 * @return Whether an argument is set in <code>argMap</code>.
	 */
	public boolean isArgSet(Object key) {
		boolean isArgSet = false;
		Object value = getArgMap().get(key);
		if (null != value) {
			isArgSet = true;
		}
		return isArgSet;
	}
}
