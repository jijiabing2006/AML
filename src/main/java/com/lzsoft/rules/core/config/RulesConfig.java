
package com.lzsoft.rules.core.config;

import com.lzsoft.rules.core.config.elmt.RuleConfigElmt;
import com.lzsoft.rules.core.config.elmt.RuleDefinitionsElmt;
import com.lzsoft.rules.core.config.elmt.RuleImplementationsElmt;
import com.lzsoft.rules.core.config.elmt.RuleParametersElmt;

public class RulesConfig {
	protected RuleDefinitionsElmt ruleDefinitionElmts;
	protected RuleImplementationsElmt ruleImplementationsElmt;
	protected RuleConfigElmt ruleConfigElmt;
	protected RuleParametersElmt ruleParametersElmt;
	public RuleDefinitionsElmt getRuleDefinitionElmts() {
		return ruleDefinitionElmts;
	}
	public void setRuleDefinitionElmts(RuleDefinitionsElmt ruleDefinitionElmts) {
		this.ruleDefinitionElmts = ruleDefinitionElmts;
	}
	public RuleImplementationsElmt getRuleImplementationsElmt() {
		return ruleImplementationsElmt;
	}
	public void setRuleImplementationsElmt(
			RuleImplementationsElmt ruleImplementationsElmt) {
		this.ruleImplementationsElmt = ruleImplementationsElmt;
	}
	public RuleConfigElmt getRuleConfigElmt() {
		return ruleConfigElmt;
	}
	public void setRuleConfigElmt(RuleConfigElmt ruleConfigElmt) {
		this.ruleConfigElmt = ruleConfigElmt;
	}
	public RuleParametersElmt getRuleParametersElmt() {
		return ruleParametersElmt;
	}
	public void setRuleParametersElmt(RuleParametersElmt ruleParametersElmt) {
		this.ruleParametersElmt = ruleParametersElmt;
	}

	
	
	
}
