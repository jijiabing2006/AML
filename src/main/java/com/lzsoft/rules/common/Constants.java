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

package com.lzsoft.rules.common;


public interface Constants {
	public static class CLASS {
//		public static final String DEFAULT_RULE_FACTORY = DefaultRuleFactory.class
//				.getName();
//		public static final String DEFAULT_RULE_EVALUATOR = DefaultRuleEvaluator.class
//				.getName();
	}

	public static class XML {

		public static class NODE {
			/** Configuration file XML Node */
			public static final String RULES = "rules";//
			/** Configuration file XML Node */
			public static final String RULE_DEFINITIONS = "rule-definitions";
			/** Configuration file XML Node */
			public static final String RULE_IMPLEMENTATIONS = "rule-implementations";
			/** Configuration file XML Node */
			public static final String RULE_CONFIG = "rule-config";//
			/** Configuration file XML Node */
			public static final String RULE_PARAMETERS = "rule-parameters";//
			/** Configuration file XML Node */
			public static final String PARAMETER = "parameter";//
			/** Configuration file XML Node */
			public static final String RULE_DEF = "rule-def";
			/** Configuration file XML Node */
			public static final String RULE = "rule";
			/** Configuration file XML Node */
			public static final String RULE_IMPL = "rule-impl";
			/** Configuration file XML Node */
			public static final String PROPERTY = "property";
			/** Configuration file XML Node */
			public static final String RULE_CALL = "rule-call";
			/** Configuration file XML Node */
			public static final String CONDITION = "condition";
			/** Configuration file XML Node */
			public static final String RULE_INVOKE = "rule-invoke";
		}

		public static class ATTRIB {
			/** Configuration file XML Attribute */
			public static final String NAME = "name";
			/** Configuration file XML Attribute */
			public static final String DESC = "desc";//
			/** Configuration file XML Attribute */
			public static final String PROPERTYLOGIC = "propertylogic";//
			/** Configuration file XML Attribute */
			public static final String CLAZZ = "clazz";//
			/** Configuration file XML Attribute */
			public static final String OR_NEXT_RULE = "or-next-rule";
			/** Configuration file XML Attribute */
			public static final String INVERSE = "inverse";
			/** Configuration file XML Attribute */
			public static final String VALUE = "value";
			/** Configuration file XML Attribute */
			public static final String TYPE = "type";
			/** Configuration file XML Attribute */
			public static final String FIELD = "field";
			/** Configuration file XML Attribute */
			public static final String RELATION = "relation";
			/** Configuration file XML Attribute */
			public static final String START_POSITION = "start";
			/** Configuration file XML Attribute */
			public static final String END_POSITION = "end";
			/** Configuration file XML Attribute */
			public static final String PARAMETER = "parameter";
			/** Configuration file XML Attribute */
			public static final String GROUPCONDITION = "groupcondition";
		}
	}
}
