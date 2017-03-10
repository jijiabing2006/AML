package com.lzsoft.aml.web.permissionmenu.treenode;

import java.util.List;

import org.primefaces.model.TreeNode;

public class MyTreeNode implements TreeNode {
public boolean leaf;
	public void setLeaf(boolean leaf) {
	this.leaf = leaf;
}

	@Override
	public int getChildCount() {
		return 0;
	}

	@Override
	public List<TreeNode> getChildren() {
		return null;
	}

	@Override
	public Object getData() {
		return null;
	}

	@Override
	public TreeNode getParent() {
		return null;
	}

	@Override
	public String getType() {
		return null;
	}

	@Override
	public boolean isExpanded() {
		return false;
	}

	@Override
	public boolean isLeaf() {
		return false;
	}

	
	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	public boolean isSelected() {
		return false;
	}

	@Override
	public void setExpanded(boolean arg0) {
		System.out.println("");

	}

	@Override
	public void setParent(TreeNode arg0) {
		System.out.println("");

	}

	@Override
	public void setSelectable(boolean arg0) {
		System.out.println("");

	}

	@Override
	public void setSelected(boolean arg0) {
		System.out.println("");

	}

	@Override
	public String getRowKey() {
		return null;
	}

	@Override
	public boolean isPartialSelected() {
		return false;
	}

	@Override
	public void setPartialSelected(boolean arg0) {
		System.out.println("");
	}

	@Override
	public void setRowKey(String arg0) {
		System.out.println("");
	}

}
