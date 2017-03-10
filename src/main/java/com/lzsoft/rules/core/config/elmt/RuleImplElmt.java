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

package com.lzsoft.rules.core.config.elmt;

import java.util.List;

public class RuleImplElmt {
	protected String name;
	protected String desc;
	protected String propertylogic;
	protected String clazz;
	protected List<PropertyElmt> propertyElmts;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPropertylogic() {
		return propertylogic;
	}

	public void setPropertylogic(String propertylogic) {
		this.propertylogic = propertylogic;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public List<PropertyElmt> getPropertyElmts() {
		return propertyElmts;
	}

	public void setPropertyElmts(List<PropertyElmt> propertyElmts) {
		this.propertyElmts = propertyElmts;
	}



}
