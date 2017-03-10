

package com.lzsoft.rules.core.config.elmt;


public class PropertyElmt {
	protected String field;
	protected String relation;
	protected String value;
	protected String start;
	protected String end;



	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}


	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}
}
