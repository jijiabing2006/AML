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

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

import com.lzsoft.rules.core.config.RulesConfig;
import com.lzsoft.rules.core.config.elmt.ConditionElmt;
import com.lzsoft.rules.core.config.elmt.ParameterElmt;
import com.lzsoft.rules.core.config.elmt.PropertyElmt;
import com.lzsoft.rules.core.config.elmt.RuleCallElmt;
import com.lzsoft.rules.core.config.elmt.RuleConfigElmt;
import com.lzsoft.rules.core.config.elmt.RuleDefElmt;
import com.lzsoft.rules.core.config.elmt.RuleImplElmt;
import com.lzsoft.rules.core.config.elmt.RuleInvokeElmt;
import com.lzsoft.rules.core.factory.RulesConfigFactory;
import com.lzsoft.rules.core.util.MUtil;

public class RulesEngine {

	protected final RulesConfig rulesConfig;

	// protected final RuleFactory ruleFactory;
	//
	// protected final RuleEvaluator ruleEvaluator;

	// protected static final InstanceFactory<RuleFactory> ruleFactoryFactory =
	// new InstanceFactory<RuleFactory>();
	//
	// protected static final InstanceFactory<RuleEvaluator>
	// ruleEvaluatorFactory = new InstanceFactory<RuleEvaluator>();

	public RulesEngine(String configURI) {
		this.rulesConfig = RulesConfigInitializer.initRulesConfig(configURI);
		// this.ruleFactory = initRuleFactory(this.rulesConfig);
		// this.ruleEvaluator = initRuleEvaluator(this.rulesConfig);
	}

	public RulesEngine(File configFile) {
		this.rulesConfig = RulesConfigInitializer.initRulesConfig(configFile);
		// this.ruleFactory = initRuleFactory(this.rulesConfig);
		// this.ruleEvaluator = initRuleEvaluator(this.rulesConfig);
	}

	public RulesEngine(InputStream configInputStream) {
		this.rulesConfig = RulesConfigInitializer
				.initRulesConfig(configInputStream);
		// this.ruleFactory = initRuleFactory(this.rulesConfig);
		// this.ruleEvaluator = initRuleEvaluator(this.rulesConfig);
	}

	public RulesEngine(InputSource configInputSource) {
		this.rulesConfig = RulesConfigInitializer
				.initRulesConfig(configInputSource);
		// this.ruleFactory = initRuleFactory(this.rulesConfig);
		// this.ruleEvaluator = initRuleEvaluator(this.rulesConfig);
	}

	public RulesEngine(Document configDcument) {
		this.rulesConfig = RulesConfigInitializer
				.initRulesConfig(configDcument);
		// this.ruleFactory = initRuleFactory(this.rulesConfig);
		// this.ruleEvaluator = initRuleEvaluator(this.rulesConfig);
	}

	public RulesEngine(Node configNode) {
		this.rulesConfig = RulesConfigInitializer.initRulesConfig(configNode);
		// this.ruleFactory = initRuleFactory(this.rulesConfig);
		// this.ruleEvaluator = initRuleEvaluator(this.rulesConfig);
	}

	/**
	 * @throws Exception
	 */
	public Map<String, List<?>> passesRule(List<?> objList) throws Exception {
		boolean passesRule = true;

		RuleConfigElmt ruleConfigElmt = rulesConfig.getRuleConfigElmt();

		List<RuleCallElmt> ruleCallElmts = ruleConfigElmt.getRuleCallElmts();
		List<?> resultRuleArgs = null;
		Map<String, List<?>> resultsMap = new HashMap<String, List<?>>();
		for (RuleCallElmt ruleCallElmt : ruleCallElmts) {
			// Get the ruleDef and ensure it is not null
			RuleDefElmt ruleDef = rulesConfig.getRuleDefinitionElmts()
					.getRuleDefElmts().get(ruleCallElmt.getName());
			if (null != ruleDef) {
				resultRuleArgs = filterByRuleDef(ruleDef, objList);
				if (!resultRuleArgs.isEmpty()) {
					resultsMap.put(ruleCallElmt.getName(), resultRuleArgs);
				}
			}
		}

		/*
		 * // List of rule elmts to evaluate List<RuleElmt> ruleElmtsToEvaluate
		 * = new LinkedList<RuleElmt>();
		 * 
		 * // For each RuleElmt... for (RuleElmt ruleElmt : ruleElmts) { // Add
		 * it to ruleElmtsToEvaluate ruleElmtsToEvaluate.add(ruleElmt);
		 * 
		 * // If it is to be OR'd with the next one, continue if
		 * (ruleElmt.isOrNextRule()) { continue; }
		 * 
		 * // If we didn't continue, we are going to evaluate all //
		 * ruleElmtsToEvaluate boolean passesTheseRules =
		 * filterByRuleDef(ruleElmtsToEvaluate, objList);
		 * ruleElmtsToEvaluate.clear(); // clear the list of rules to evaluate
		 * 
		 * passesRule = passesRule & passesTheseRules;
		 * 
		 * // If the rule failed already, there is no reason to keep evaluating
		 * // so break the loop. if (false == passesRule) { break; } }
		 * 
		 * // Someone might have set isOrNextRule on the last rule in a rule
		 * def, // so evaluate any rules still in ruleElmtsToEvaluate if
		 * present. if (!ruleElmtsToEvaluate.isEmpty()) { final boolean
		 * passesTheseRules = filterByRuleDef( ruleElmtsToEvaluate, objList);
		 * passesRule = passesRule & passesTheseRules; }
		 */

		return resultsMap;
	}

	protected List<?> filterByRuleDef(RuleDefElmt ruleDef, List<?> objs)
			throws Exception {
		List<ConditionElmt> conditionElmts = ruleDef.getConditionElmts();
		List<Object> conditionRuleResults = new ArrayList<Object>();
		List<Object> results = new ArrayList<Object>();
		if ("and".equalsIgnoreCase(ruleDef.getPropertylogic())) {
			// 对满足condition的结果再次进行下个condition的过滤
			conditionRuleResults.addAll(objs);
			for (ConditionElmt conditionElmt : conditionElmts) {

				conditionRuleResults = filterconditionElmt(
						conditionRuleResults, conditionElmt);
			}
			results.addAll(conditionRuleResults);
		} else if ("or".equalsIgnoreCase(ruleDef.getPropertylogic())
				|| null == ruleDef.getPropertylogic()) {
			// 对objs进行各个condition的过滤，过滤结果叠加（但是要根据key值去除重复结果）
			for (ConditionElmt conditionElmt : conditionElmts) {

				conditionRuleResults = filterconditionElmt(objs, conditionElmt);
				results.addAll(conditionRuleResults);
			}

		}

		return results;

	}

	private List<Object> filterconditionElmt(List<?> objs,
			ConditionElmt conditionElmt) throws Exception,
			IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		List<Object> conditionRuleResults;
		conditionRuleResults = filterUnderConditionHavntParameter(objs,
				conditionElmt);
		/**
		 * After performing the all rule-invoke elements，if the result is null
		 * ,then goto the next condition.
		 */
		if (!conditionRuleResults.isEmpty()) {

			if (null != conditionElmt.getParameter()
					&& !"".equals(conditionElmt.getParameter())) {//
				String parameterValue = conditionElmt.getParameter();
				String[] paras;
				if (parameterValue.startsWith("@")) {
					paras = StringUtils.split(
							StringUtils.substring(parameterValue, 2), ":");
					for (String para : paras) {
						conditionRuleResults = filterResultsByParameterValue(
								conditionRuleResults, conditionElmt, para);
					}

				} else {
					conditionRuleResults = filterResultsByParameterValue(
							conditionRuleResults, conditionElmt, parameterValue);
				}
			}
		}
		return conditionRuleResults;
	}

	private List<Object> filterResultsByParameterValue(
			List<Object> conditionRuleResults, ConditionElmt conditionElmt,
			String para) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, Exception {
		ParameterElmt parameterElmt = rulesConfig.getRuleParametersElmt()
				.getParameters().get(para);
		if ("group".equalsIgnoreCase(parameterElmt.getName())
				&& "groupby".equalsIgnoreCase(parameterElmt.getType())) {// 如果name=group,type=groupby说明
																			// 是要分组处理的。以Value的值进行分组

			conditionRuleResults = groupingAndFilter(conditionRuleResults,
					conditionElmt, parameterElmt);
		} else {
			// 其它条件时再处理
			// ??????
		}
		return conditionRuleResults;
	}

	/**
	 * 分组并进行过滤
	 * 
	 * @param conditionRuleResults
	 *            已经通过rule-invoke过滤的Objs
	 * @param conditionElmt
	 *            rule-Def中的conditionElmt
	 * @param parameterElmt
	 *            conditionElmt关联的ParameterElmt
	 * @return conditionRuleResults 通过Condition后的Objs
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws Exception
	 */
	private List<Object> groupingAndFilter(List<Object> conditionRuleResults,
			ConditionElmt conditionElmt, ParameterElmt parameterElmt)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException, Exception {
		Map<String, List<Object>> groupObjs = groupingObjsByGroupvalue(
				conditionRuleResults, parameterElmt);
		conditionRuleResults.clear();
		conditionRuleResults = filterObjsByGroupcondition(groupObjs,
				conditionElmt.getGroupcondition());
		return conditionRuleResults;
	}

	/**
	 * 根据分组条件对Map进行过滤，
	 * 
	 * @param groupObjs
	 * @param groupcondition
	 * @return 满足Groupcondition的objList
	 * @throws NoSuchMethodException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private List<Object> filterObjsByGroupcondition(
			Map<String, List<Object>> groupObjs, String groupcondition)
			throws Exception {
		RuleImplElmt ruleImplElmt = getRuleImpElmtByName(groupcondition);
		List<PropertyElmt> proElmts = ruleImplElmt.getPropertyElmts();
		List<Object> objResults = new ArrayList<Object>();

		Set<String> keySets = groupObjs.keySet();
		for (String key : keySets) {
			List<Object> objs = groupObjs.get(key);
			Double sumD = 0d;
			int count = 0;
			for (PropertyElmt propertyElmt : proElmts) {

				sumD = sumFiledValuebyFieldName(objs, sumD, propertyElmt,
						ruleImplElmt.getClazz());

				boolean currentRule = false;
				currentRule = MUtil.matchField(sumD, "Double", propertyElmt);

				if ("and".equalsIgnoreCase(ruleImplElmt.getPropertylogic())) {
					if (!currentRule) {
						break;
					} else {
						count++;
					}
				} else if ("or".equalsIgnoreCase(ruleImplElmt
						.getPropertylogic())
						|| null == ruleImplElmt.getPropertylogic()) {
					if (currentRule) {
						count = proElmts.size();
						break;

					}
				}
			}
			if (count == proElmts.size() && count > 0) {
				objResults.addAll(objs);
				count = 0;
			}
		}
		return objResults;

	}

	private Double sumFiledValuebyFieldName(List<Object> objs, Double sumD,
			PropertyElmt propertyElmt, String clazz)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String fieldType;
		String fieldname = propertyElmt.getField();

		if (objs.getClass().getName().toLowerCase().indexOf("list") >= 0) {
			for (Object obj : (List) objs) {
				if (obj.getClass().getName().toLowerCase().indexOf("list") >= 0) {
					for (Object object : (List) obj) {
						if (object.getClass().getName().equals(clazz)) {
							Object objValue = PropertyUtils.getProperty(object,
									fieldname);// 根据mapping中的field的name反射出的值
							fieldType = PropertyUtils.getPropertyType(object,
									fieldname).getSimpleName();// 根据mapping中的field的name反射出的数据类型
							if ("Double".equals(fieldType)) {
								sumD += (Double) objValue;
							} else if ("BigDecimal".equals(fieldType)) {
								sumD += ((BigDecimal) objValue).doubleValue();
							}
						}
					}
				}
			}
		} else {
			for (Object object : objs) {
				Object objValue = PropertyUtils.getProperty(object, fieldname);// 根据mapping中的field的name反射出的值
				fieldType = PropertyUtils.getPropertyType(object, fieldname)
						.getSimpleName();// 根据mapping中的field的name反射出的数据类型
				if ("Double".equals(fieldType)) {
					sumD += (Double) objValue;
				} else if ("BigDecimal".equals(fieldType)) {
					sumD += ((BigDecimal) objValue).doubleValue();
				}
			}
		}
		return sumD;
	}

	/**
	 * 根据分组条件对ObjectList进行分组
	 * 
	 * @param conditionRuleResults
	 * @param parameterElmt
	 * @return
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @return 分组后Map
	 */
	private Map<String, List<Object>> groupingObjsByGroupvalue(
			List<Object> conditionRuleResults, ParameterElmt parameterElmt)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String groupValue = parameterElmt.getValue();
		String[] groupkeys = null;
		if (groupValue.startsWith("@")) {
			groupkeys = StringUtils.split(StringUtils.substring(groupValue, 2),
					":");
		}
		// 将rule-invoke结果集进行分组

		Map<String, List<Object>> groupObjs = new HashMap<String, List<Object>>();
		for (Object objs : conditionRuleResults) {
			combineObjsByGroupkey(groupkeys, groupObjs, objs,
					parameterElmt.getClazz());
		}
		return groupObjs;
	}

	private void combineObjsByGroupkey(String[] groupkeys,
			Map<String, List<Object>> groupObjs, Object objs,
			String parameterElmt) throws IllegalAccessException,
			InvocationTargetException, NoSuchMethodException {
		String key = "";
		if (objs.getClass().getName().toLowerCase().indexOf("list") >= 0) {
			for (Object obj : (List) objs) {
				if (obj.getClass().getName().equals(parameterElmt)) {
					key = getKey(groupkeys, obj);
				}
			}
		} else {
			if (objs.getClass().getName().equals(parameterElmt)) {
				key = getKey(groupkeys, objs);
			}
		}
		if (null == groupObjs.get(key)) {
			groupObjs.put(key, new ArrayList<Object>());
			groupObjs.get(key).add(objs);
		} else {
			groupObjs.get(key).add(objs);
		}
	}

	protected String getKey(String[] groupkeys, Object obj)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		String key = "";
		for (String groupkey : groupkeys) {
			key += PropertyUtils.getProperty(obj, groupkey) + "|";
		}
		return key;
	}

	/**
	 * 直接对ObjList进行过滤，不需要复杂处理
	 * 
	 * @param obj
	 * @param ruleElmt
	 * @return
	 * @return
	 * @throws Exception
	 */
	private List<Object> filterUnderConditionHavntParameter(List<?> objs,
			ConditionElmt conditionElmt) throws Exception {
		List<RuleInvokeElmt> ruleInvokeElmts = conditionElmt.getRuleInvokes();
		List<Object> conditionRuleResults = new ArrayList<Object>();
		for (Object obj : objs) {// 对一个（或者组）Pojo进行过滤，这样多个Pojo就不需要组合成一个单独的Pojo
			boolean passesRule = true;
			for (RuleInvokeElmt ruleInvokeElmt : ruleInvokeElmts) {

				boolean passesThisRule = evaluateRule(obj,
						ruleInvokeElmt.getName());
				if (ruleInvokeElmt.isInverse()) {// 如果RuleInvokeElmt中Inverse的值为true，说明条件要取反
					passesThisRule = !passesThisRule;
				}
				// 当前rule-invoke为false时，说明Condition不成立，直接跳出
				passesRule = passesRule & passesThisRule;
				if (!passesRule) {
					break;
				}
			}
			if (passesRule) {
				conditionRuleResults.add(obj);
			}

		}
		return conditionRuleResults;
	}

	protected boolean evaluateRule(Object objs, String ruleElmtName)
			throws Exception {
		// Get the RuleImplElmt
		RuleImplElmt ruleImplElmt = getRuleImpElmtByName(ruleElmtName);
		List<PropertyElmt> proElmts = ruleImplElmt.getPropertyElmts();
		int c = 0;

		if (objs.getClass().getName().toLowerCase().indexOf("list") >= 0) {
			int c1 = 0;
			for (Object obj : (List) objs) {
				if (obj.getClass().getName().equals(ruleImplElmt.getClazz())) {
					for (PropertyElmt propertyElmt : proElmts) {
						Object objValue = PropertyUtils.getProperty(obj,
								propertyElmt.getField());// 根据mapping中的field的name反射出的值
						Class clazz = PropertyUtils.getPropertyType(obj,
								propertyElmt.getField());// 根据mapping中的field的name反射出的数据类型

						boolean currentRule = MUtil.matchField(objValue,
								clazz.getSimpleName(), propertyElmt);
						if ("and".equalsIgnoreCase(ruleImplElmt
								.getPropertylogic())) {
							if (!currentRule) {
								return false;
							}
							c++;
						} else if ("or".equalsIgnoreCase(ruleImplElmt
								.getPropertylogic())
								|| null == ruleImplElmt.getPropertylogic()) {
							if (currentRule) {
								return true;
							}
						}

					}
				}
			}

		} else {
			if (objs.getClass().getName().equals(ruleImplElmt.getClazz())) {
				for (PropertyElmt propertyElmt : proElmts) {
					Object objValue = PropertyUtils.getProperty(objs,
							propertyElmt.getField());// 根据mapping中的field的name反射出的值
					Class clazz = PropertyUtils.getPropertyType(objs,
							propertyElmt.getField());// 根据mapping中的field的name反射出的数据类型

					boolean currentRule = MUtil.matchField(objValue,
							clazz.getSimpleName(), propertyElmt);
					if ("and".equalsIgnoreCase(ruleImplElmt.getPropertylogic())) {
						if (!currentRule) {
							return false;
						}
						c++;
					} else if ("or".equalsIgnoreCase(ruleImplElmt
							.getPropertylogic())
							|| null == ruleImplElmt.getPropertylogic()) {
						if (currentRule) {
							return true;
						}
					}

				}
			} else {
				// System.out.println(objs+" rule-invoke name="+ruleElmtName);
				return false;
			}

		}

		return c == proElmts.size() ? true : false;

		/*
		 * // Get the rule Rule rule = ruleFactory.getRule(ruleImplElmt);
		 * 
		 * // Evaluate rule boolean evaluation = ruleEvaluator.passesRule(rule,
		 * ruleArgs);
		 * 
		 * // If isInverse, invert the evaluation if (ruleElmt.isInverse()) {
		 * evaluation = !evaluation; }
		 * 
		 * return evaluation;
		 */
	}

	/**
	 * 根据Name返回Rule-Impl对象
	 * 
	 * @param ruleElmtName
	 * @return
	 */
	private RuleImplElmt getRuleImpElmtByName(String ruleElmtName) {
		return rulesConfig.getRuleImplementationsElmt().getRuleImplElmts()
				.get(ruleElmtName);
	}

	// protected RuleFactory initRuleFactory(RulesConfig rulesConfig) {
	// final String ruleFactoryClass = rulesConfig.getRoolieConfigElmt()
	// .getRuleFactoryClass();
	// RuleFactory _ruleFactory = ruleFactoryFactory
	// .cachedInstance(ruleFactoryClass);
	// return _ruleFactory;
	// }
	//
	// protected RuleEvaluator initRuleEvaluator(RulesConfig rulesConfig) {
	// final String ruleEvaluatorClass = rulesConfig.getRoolieConfigElmt()
	// .getRuleEvaluatorClass();
	// RuleEvaluator _ruleEvaluator = ruleEvaluatorFactory
	// .cachedInstance(ruleEvaluatorClass);
	// return _ruleEvaluator;
	// }
}

class RulesConfigInitializer {

	protected static RulesConfig initRulesConfig(String uri) {
		try {
			return RulesConfigFactory.getInstance().buildRulesConfig(uri);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	protected static RulesConfig initRulesConfig(File configFile) {
		try {
			return RulesConfigFactory.getInstance()
					.buildRulesConfig(configFile);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	protected static RulesConfig initRulesConfig(InputStream inputStream) {
		try {
			return RulesConfigFactory.getInstance().buildRulesConfig(
					inputStream);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	protected static RulesConfig initRulesConfig(InputSource inputSource) {
		try {
			return RulesConfigFactory.getInstance().buildRulesConfig(
					inputSource);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

	protected static RulesConfig initRulesConfig(Node node) {
		try {
			return RulesConfigFactory.getInstance().buildRulesConfig(node);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

}
