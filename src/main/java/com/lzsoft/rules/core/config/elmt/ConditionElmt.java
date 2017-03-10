
package com.lzsoft.rules.core.config.elmt;

import java.util.List;
import java.util.Map;

public class ConditionElmt {
	protected String name;
	protected String parameter;
	protected String groupcondition;
	protected List<RuleInvokeElmt> ruleInvokes;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getGroupcondition() {
		return groupcondition;
	}
	public void setGroupcondition(String groupcondition) {
		this.groupcondition = groupcondition;
	}
	public List<RuleInvokeElmt> getRuleInvokes() {
		return ruleInvokes;
	}
	public void setRuleInvokes(List<RuleInvokeElmt> ruleInvokes) {
		this.ruleInvokes = ruleInvokes;
	}

	

}
