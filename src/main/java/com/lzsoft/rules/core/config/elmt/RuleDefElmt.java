
package com.lzsoft.rules.core.config.elmt;

import java.util.List;

public class RuleDefElmt {
	protected String name;
	protected String desc;
	protected String propertylogic;
	
	protected List<ConditionElmt> conditionElmts;

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

	public List<ConditionElmt> getConditionElmts() {
		return conditionElmts;
	}

	public void setConditionElmts(List<ConditionElmt> conditionElmts) {
		this.conditionElmts = conditionElmts;
	}


}
