package com.lzsoft.rules.core.config.elmt;

import java.util.List;

public class RuleConfigElmt {
	protected String name;
	protected String desc;
	protected List<RuleCallElmt> ruleCallElmts;

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

	public List<RuleCallElmt> getRuleCallElmts() {
		return ruleCallElmts;
	}

	public void setRuleCallElmts(List<RuleCallElmt> ruleCallElmts) {
		this.ruleCallElmts = ruleCallElmts;
	}



}
