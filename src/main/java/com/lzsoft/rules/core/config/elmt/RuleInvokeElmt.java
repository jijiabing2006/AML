

package com.lzsoft.rules.core.config.elmt;


public class RuleInvokeElmt {
	protected String name;
	  protected boolean orNextRule = false;
	  protected boolean inverse=false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOrNextRule() {
		return orNextRule;
	}
	public void setOrNextRule(boolean orNextRule) {
		this.orNextRule = orNextRule;
	}
	public boolean isInverse() {
		return inverse;
	}
	public void setInverse(boolean inverse) {
		this.inverse = inverse;
	}


}
