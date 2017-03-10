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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.Node;

import com.lzsoft.rules.common.Constants.XML;
import com.lzsoft.rules.core.config.RulesConfig;
import com.lzsoft.rules.core.config.elmt.ConditionElmt;
import com.lzsoft.rules.core.config.elmt.ParameterElmt;
import com.lzsoft.rules.core.config.elmt.PropertyElmt;
import com.lzsoft.rules.core.config.elmt.RuleCallElmt;
import com.lzsoft.rules.core.config.elmt.RuleConfigElmt;
import com.lzsoft.rules.core.config.elmt.RuleDefElmt;
import com.lzsoft.rules.core.config.elmt.RuleDefinitionsElmt;
import com.lzsoft.rules.core.config.elmt.RuleImplElmt;
import com.lzsoft.rules.core.config.elmt.RuleImplementationsElmt;
import com.lzsoft.rules.core.config.elmt.RuleInvokeElmt;
import com.lzsoft.rules.core.config.elmt.RuleParametersElmt;
import com.lzsoft.rules.core.util.RUtil;

public class RulesConfigParser {

	protected static RulesConfigParser instance = new RulesConfigParser();

	protected RulesConfigParser() {
		super();
	}

	public static RulesConfigParser getInstance() {
		return instance;
	}

	public RulesConfig parseRulesConfig(Node configNode)
			throws XPathExpressionException {
		// Validate the document
		validateDocument(configNode);

		// Create a new RulesConfig
		RulesConfig rulesConfig = new RulesConfig();

		// Get the root node
		Node rulesRoot = RUtil.findRequiredSingleNode(configNode,
				XML.NODE.RULES);

		// Init rule-config
		Node ruleConfigNode = RUtil.findSingleNode(rulesRoot,
				XML.NODE.RULE_CONFIG);
		initRuleConfig(ruleConfigNode, rulesConfig);

		// Init rule-implementations
		Node ruleImplementationsNode = RUtil.findRequiredSingleNode(
				rulesRoot, XML.NODE.RULE_IMPLEMENTATIONS);
		initRuleImplementations(ruleImplementationsNode, rulesConfig);

		// Init rule-definitions
		Node ruleDefinitionsNode = RUtil.findRequiredSingleNode(
				rulesRoot, XML.NODE.RULE_DEFINITIONS);
		initRuleDefinitions(ruleDefinitionsNode, rulesConfig);

		Node ruleParametersNode = RUtil.findSingleNode(rulesRoot,
				XML.NODE.RULE_PARAMETERS);
		initRuleParameters(ruleParametersNode, rulesConfig);
		
		
        validateRulesConfig(rulesConfig);
		return rulesConfig;
	}


	protected void initRuleConfig(Node ruleConfig,
			RulesConfig rulesConfig) throws XPathExpressionException {
		// Create a new RoolieConfigElmt
		RuleConfigElmt ruleConfigElmt = new RuleConfigElmt();
		

		// List to hold the RuleCallElmt's
		List<RuleCallElmt> ruleCallElmts = new ArrayList<RuleCallElmt>();

		// Get the rule-Call nodes
		List<Node> ruleCallNodes = RUtil.getChildren(ruleConfig,
				XML.NODE.RULE_CALL);

		for (Node ruleCallNode : ruleCallNodes) {
			RuleCallElmt ruleCallElmt = createRuleCallElmt(ruleCallNode);
			ruleCallElmts.add(ruleCallElmt);
		}

		// Set the ruleCallElmts in the ruleConfigElmt
		ruleConfigElmt.setRuleCallElmts(ruleCallElmts);
		// Set the RoolieConfigElmt in rulesConfig
		rulesConfig.setRuleConfigElmt(ruleConfigElmt);
	}

	protected void initRuleImplementations(Node ruleImplementationsNode,
			RulesConfig rulesConfig) throws XPathExpressionException {
		// Create a new RuleImplementationsElmt
		RuleImplementationsElmt ruleImplementationsElmt = new RuleImplementationsElmt();

		// Map to hold the RuleImpleElmt's
		Map<String, RuleImplElmt> ruleImplElmts = new HashMap<String, RuleImplElmt>();

		// Get the rule-impl nodes
		List<Node> ruleImplNodes = RUtil.getChildren(ruleImplementationsNode,
				XML.NODE.RULE_IMPL);

		for (Node ruleImplNode : ruleImplNodes) {
			RuleImplElmt ruleImplElmt = createRuleImplElmt(ruleImplNode);
			ruleImplElmts.put(ruleImplElmt.getName(), ruleImplElmt);
		}

		// Set the ruleImplElmts in the ruleImplementationsElmt
		ruleImplementationsElmt.setRuleImplElmts(ruleImplElmts);

		// Set the RuleImplementationsElmt in rulesConfig
		rulesConfig.setRuleImplementationsElmt(ruleImplementationsElmt);
	}

	protected RuleImplElmt createRuleImplElmt(Node ruleImplNode)
			throws XPathExpressionException {
		// Create a new RuleImplElmt
		RuleImplElmt ruleImplElmt = new RuleImplElmt();

		// Set the rule name
		final String ruleName = RUtil.getRequiredAttributeValue(ruleImplNode,
				XML.ATTRIB.NAME);
		ruleImplElmt.setName(ruleName);
		
		// Set the rule desc
		final String ruleDesc = RUtil.getRequiredAttributeValue(ruleImplNode,
				XML.ATTRIB.DESC);
		ruleImplElmt.setDesc(ruleDesc);
		// Set the rule propertylogic
		final String rulePropertylogic = RUtil.getRequiredAttributeValue(ruleImplNode,
				XML.ATTRIB.PROPERTYLOGIC);
		ruleImplElmt.setPropertylogic(rulePropertylogic);
		// Set the rule clazz
		final String clazz = RUtil.getRequiredAttributeValue(ruleImplNode,
				XML.ATTRIB.CLAZZ);
		ruleImplElmt.setClazz(clazz);

		// Set properties (if any)
		List<PropertyElmt> propertyElmts = createPropertyElmts(ruleImplNode);
		ruleImplElmt.setPropertyElmts(propertyElmts);

		return ruleImplElmt;
	}

	protected List<PropertyElmt> createPropertyElmts(Node ruleImplNode)
			throws XPathExpressionException {
		List<PropertyElmt> propertyElmts = null;
		List<Node> propertyNodes = RUtil.getChildren(ruleImplNode,
				XML.NODE.PROPERTY);
		if (RUtil.isNullOrEmpty(propertyNodes)) {
			return propertyElmts;
		}
		propertyElmts = new LinkedList<PropertyElmt>();
		for (Node propertyNode : propertyNodes) {
			// Create a new PropertyElmt
			PropertyElmt propertyElmt = new PropertyElmt();

			// Set field
			final String field = RUtil.getRequiredAttributeValue(propertyNode,
					XML.ATTRIB.FIELD);
			propertyElmt.setField(field);

			// Set value
			final String value = RUtil.getAttributeValue(propertyNode,
					XML.ATTRIB.VALUE);
			propertyElmt.setValue(value);
			
			// Set  relation;
			final String relation = RUtil.getAttributeValue(propertyNode,
					XML.ATTRIB.RELATION);
			propertyElmt.setRelation(relation);
			// Set start
			final String start = RUtil.getAttributeValue(propertyNode,
					XML.ATTRIB.START_POSITION);
			propertyElmt.setStart(start);
			// Set end
			final String end = RUtil.getAttributeValue(propertyNode,
					XML.ATTRIB.END_POSITION);
			propertyElmt.setEnd(end);

			// Set list items
//			final List<ListItemElmt> listItems = createListItemElmts(propertyNode);
//			propertyElmt.setListItems(listItems);

			// Make sure there is either listItems or a value, but not both
//			RUtil.assertExclusiveOR((null == value), (null == listItems),
//					"Either " + XML.ATTRIB.VALUE + " or " + XML.NODE.LIST
//							+ " are required, but not both");

			// Add propertyElmt to list
			propertyElmts.add(propertyElmt);
		}
		return propertyElmts;
	}

//	protected List<ListItemElmt> createListItemElmts(Node propertyNode)
//			throws XPathExpressionException {
//		List<ListItemElmt> listItemElmts = null;
//		Node listNode = RUtil.getChild(propertyNode, XML.NODE.LIST);
//		if (null != listNode) {
//			listItemElmts = new LinkedList<ListItemElmt>();
//			List<Node> listItemNodes = RUtil.getChildren(listNode,
//					XML.NODE.LIST_ITEM);
//			for (Node listItemNode : listItemNodes) {
//				ListItemElmt listItemElmt = createListItemElmt(listItemNode);
//				listItemElmts.add(listItemElmt);
//			}
//		}
//		return listItemElmts;
//	}
	protected RuleCallElmt createRuleCallElmt(Node ruleCallNode)
			throws XPathExpressionException {
		// Create a new RuleImplElmt
		RuleCallElmt ruleCallElmt = new RuleCallElmt();

		// Set the rule name
		final String callName = RUtil.getRequiredAttributeValue(ruleCallNode,
				XML.ATTRIB.NAME);
		ruleCallElmt.setName(callName);
		


		return ruleCallElmt;
	}

	protected void initRuleParameters(Node ruleParametersNode,
			RulesConfig rulesConfig) throws XPathExpressionException {
		RuleParametersElmt ruleParametersElmt = new RuleParametersElmt();
		
		 Map<String,ParameterElmt> parameters = new HashMap<String, ParameterElmt>();
		
		List<ParameterElmt> parameterElmts = createParameterElmts(ruleParametersNode);
		for (ParameterElmt parameterElmt : parameterElmts) {
			parameters.put(parameterElmt.getName(), parameterElmt);
		}
		ruleParametersElmt.setParameters(parameters);
		rulesConfig.setRuleParametersElmt(ruleParametersElmt);
	}
	protected List<ParameterElmt> createParameterElmts(Node ruleParametersNode)
			throws XPathExpressionException {
		List<Node> parameterNodes = RUtil.getRequiredChildren(
				ruleParametersNode, XML.NODE.PARAMETER);
		List<ParameterElmt> ruleParameterElmts = new LinkedList<ParameterElmt>();
		for (Node parameterNode : parameterNodes) {
			ParameterElmt parameterElmt = createParameterElmt(parameterNode);
			ruleParameterElmts.add(parameterElmt);
		}
		return ruleParameterElmts;
	}
	protected ParameterElmt createParameterElmt(Node parameterNode)
			throws XPathExpressionException {
		
		// Create ParameterNode
		ParameterElmt parameter = new ParameterElmt();
		// name
		final String name = RUtil.getRequiredAttributeValue(parameterNode,
				XML.ATTRIB.NAME);
		parameter.setName(name);
		// desc
		final String desc = RUtil.getRequiredAttributeValue(parameterNode,
				XML.ATTRIB.DESC);
		parameter.setDesc(desc);
		// value
		final String value = RUtil.getRequiredAttributeValue(parameterNode,
				XML.ATTRIB.VALUE);
		parameter.setValue(value);
		// type
		final String type = RUtil.getRequiredAttributeValue(parameterNode,
				XML.ATTRIB.TYPE);
		parameter.setType(type);
		// class
		final String clazz = RUtil.getRequiredAttributeValue(parameterNode,
				XML.ATTRIB.CLAZZ);
		parameter.setClazz(clazz);
		return parameter;
	}
	
	protected void initRuleDefinitions(Node ruleDefinitionsNode,
			RulesConfig rulesConfig) throws XPathExpressionException {
		RuleDefinitionsElmt ruleDefinitionsElmt = new RuleDefinitionsElmt();

		Map<String, RuleDefElmt> ruleDefElmtsMap = new HashMap<String, RuleDefElmt>();
		
		List<RuleDefElmt> ruleDefElmts = createRuleDefElmts(ruleDefinitionsNode);
		for (RuleDefElmt ruleDefElmt : ruleDefElmts) {
			ruleDefElmtsMap.put(ruleDefElmt.getName(), ruleDefElmt);
		}
		ruleDefinitionsElmt.setRuleDefElmts(ruleDefElmtsMap);
		rulesConfig.setRuleDefinitionElmts(ruleDefinitionsElmt);
	}

	protected List<RuleDefElmt> createRuleDefElmts(Node ruleDefinitionsNode)
			throws XPathExpressionException {
		List<Node> ruleDefNodes = RUtil.getRequiredChildren(
				ruleDefinitionsNode, XML.NODE.RULE_DEF);
		List<RuleDefElmt> ruleDefElmts = new LinkedList<RuleDefElmt>();
		for (Node ruleDefNode : ruleDefNodes) {
			RuleDefElmt ruleDefElmt = createRuleDefElmt(ruleDefNode);
			ruleDefElmts.add(ruleDefElmt);
		}
		return ruleDefElmts;
	}

	protected RuleDefElmt createRuleDefElmt(Node ruleDefNode)
			throws XPathExpressionException {
		
		// Create RuleDefElmt
		RuleDefElmt ruleDefElmt = new RuleDefElmt();

		// name
		final String ruleDefName = RUtil.getRequiredAttributeValue(ruleDefNode,
				XML.ATTRIB.NAME);
		ruleDefElmt.setName(ruleDefName);
		// desc
		final String ruleDefDesc = RUtil.getRequiredAttributeValue(ruleDefNode,
				XML.ATTRIB.DESC);
		ruleDefElmt.setDesc(ruleDefDesc);
		// propertylogic
		final String ruleDefPropertylogic = RUtil.getRequiredAttributeValue(ruleDefNode,
				XML.ATTRIB.PROPERTYLOGIC);
		ruleDefElmt.setPropertylogic(ruleDefPropertylogic);
		
		// Get the rule nodes
		List<Node> conditionNodes = RUtil.getRequiredChildren(ruleDefNode,
				XML.NODE.CONDITION);
		
		// ConditionElmt's
		List<ConditionElmt> conditionElmts= new LinkedList<ConditionElmt>();
		
		for (Node conditionNode : conditionNodes) {
			ConditionElmt conditionElmt= createConditionElmt(conditionNode);
			conditionElmts.add(conditionElmt);
		}
		
		
		ruleDefElmt.setConditionElmts(conditionElmts);
		return ruleDefElmt;
	}
	
	protected ConditionElmt createConditionElmt(Node conditionNode)
			throws XPathExpressionException {
		
		// Create ConditionElmt
		ConditionElmt conditionElmt = new ConditionElmt();

		// name
		final String name = RUtil.getRequiredAttributeValue(conditionNode,
				XML.ATTRIB.NAME);
		conditionElmt.setName(name);
		// parameter
		final String parameter = RUtil.getRequiredAttributeValue(conditionNode,
				XML.ATTRIB.PARAMETER);
		conditionElmt.setParameter(parameter);
		
		// groupcondition
		final String groupcondition = RUtil.getRequiredAttributeValue(conditionNode,
				XML.ATTRIB.GROUPCONDITION);
		conditionElmt.setGroupcondition(groupcondition);
		
		
		// Get the rule nodes
		List<Node> ruleInvokeNodes = RUtil.getRequiredChildren(conditionNode,
				XML.NODE.RULE_INVOKE);
		
		
		List<RuleInvokeElmt> ruleInvokeElmts = new LinkedList<RuleInvokeElmt>();		
		
		for (Node ruleInvokeNode : ruleInvokeNodes) {
			RuleInvokeElmt ruleInvokeElmt = createRuleInvokeElmt(ruleInvokeNode);
			ruleInvokeElmts.add(ruleInvokeElmt);
		}
		conditionElmt.setRuleInvokes(ruleInvokeElmts);
		return conditionElmt;
	}


	private RuleInvokeElmt createRuleInvokeElmt(Node ruleInvokeNode)
			throws XPathExpressionException {
		RuleInvokeElmt ruleElmt = new RuleInvokeElmt();

		// name
		final String name = RUtil.getRequiredAttributeValue(ruleInvokeNode,
				XML.ATTRIB.NAME);
		ruleElmt.setName(name);

		// or-next-rule
		final String sOrNextRule = RUtil.getAttributeValue(ruleInvokeNode,
				XML.ATTRIB.OR_NEXT_RULE);
		final boolean orNextRule = RUtil.parseBoolean(sOrNextRule);
		ruleElmt.setOrNextRule(orNextRule);

		// inverse
		final String sInverse = RUtil.getAttributeValue(ruleInvokeNode,
				XML.ATTRIB.INVERSE);
		final boolean inverse = RUtil.parseBoolean(sInverse);
		ruleElmt.setInverse(inverse);

		return ruleElmt;
	}


	protected RuleImplElmt findRuleImplElmt(RulesConfig rulesConfig, String name) {
		RuleImplElmt ruleImplElmt = rulesConfig.getRuleImplementationsElmt()
				.getRuleImplElmts().get(name);
		return ruleImplElmt;
	}

	private void validateRulesConfig(RulesConfig rulesConfig) {
	// Get the rule-config and ensure it is not null
		
		RuleConfigElmt ruleConfigElmt = rulesConfig.getRuleConfigElmt();
		RUtil.assertNotNull(ruleConfigElmt, "There is no RuleConfigElmt  definition");
	
		List<RuleCallElmt> ruleCallElmts=ruleConfigElmt.getRuleCallElmts();
		RUtil.assertNotNullOrEmpty(ruleCallElmts, "There is no RuleCallElmt  definition for ");
		
		
		for (RuleCallElmt ruleCallElmt : ruleCallElmts) {
			// Get the ruleDef and ensure it is not null
			RuleDefElmt ruleDef = rulesConfig.getRuleDefinitionElmts()
					.getRuleDefElmts().get(ruleCallElmt.getName());
			RUtil.assertNotNull(ruleDef, "There is no rule definition for "
					+ ruleCallElmt.getName());
			
			if(null!=ruleDef){
			
			List<ConditionElmt> conditionElmts	=ruleDef.getConditionElmts();
			RUtil.assertNotNullOrEmpty(conditionElmts, "There is no ConditionElmt  definition for ");
			for (ConditionElmt conditionElmt : conditionElmts) {
				// Get all the RuleElmts of the ruleDef and make sure they aren't null
				// or
				// empty
				List<RuleInvokeElmt> ruleInvokeElmts = conditionElmt.getRuleInvokes();
				RUtil.assertNotNullOrEmpty(ruleInvokeElmts, "There are no RuleInvokeElmt elements for ");
				for (RuleInvokeElmt ruleInvokeElmt : ruleInvokeElmts) {
					RuleImplElmt ruleImplElmt = rulesConfig.getRuleImplementationsElmt().getRuleImplElmts().get(ruleInvokeElmt.getName());
					RUtil.assertNotNull(ruleImplElmt, "There is no ruleImplElmt  definition for"+ruleInvokeElmt.getName());
				}
				
			}
			}
		}		
	}
	/*
	 * Validates conditions in the config document not checked when parsing.
	 */
	protected void validateDocument(Node node) {
		try {
			Set<String> names = new HashSet<String>();

			// Check unique names for rule-def and rule-impl nodes...

			// rule-def
			List<Node> ruleDefNodes = RUtil.findAllNodes(node,
					XML.NODE.RULE_DEF);

			for (Node ruleDefNode : ruleDefNodes) {
				final String name = RUtil.getRequiredAttributeValue(
						ruleDefNode, XML.ATTRIB.NAME);

				RUtil.assertFalse(names.contains(name), "Attribute "
						+ XML.ATTRIB.NAME + " must be unique among all "
						+ XML.NODE.RULE_DEF + " and " + XML.NODE.RULE_IMPL
						+ " nodes");

				names.add(name);
			}

			// rule-impl
			List<Node> ruleImplNodes = RUtil.findAllNodes(node,
					XML.NODE.RULE_IMPL);

			for (Node ruleImpleNode : ruleImplNodes) {
				final String name = RUtil.getRequiredAttributeValue(
						ruleImpleNode, XML.ATTRIB.NAME);

				RUtil.assertFalse(names.contains(name), "Attribute "
						+ XML.ATTRIB.NAME + " must be unique among all "
						+ XML.NODE.RULE_DEF + " and " + XML.NODE.RULE_IMPL
						+ " nodes");

				names.add(name);
			}
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}
}
