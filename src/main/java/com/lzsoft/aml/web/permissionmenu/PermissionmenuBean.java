package com.lzsoft.aml.web.permissionmenu;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.TreeNode;

import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.service.permission.IPermissionService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "menuBean")
@RequestScoped
public class PermissionmenuBean extends BaseBean {

	/**
	 * 树形菜单：分角色权限
	 */
	private TreeNode selectedNode = null;
	private TreeNode root = null;
	private TreeNode relationRoot = null;

	private TreeNode[] selectedNodes;
	/**
	 * 导航菜单的Service
	 */
	@ManagedProperty("#{permissionService}")
	private IPermissionService permissionService;

	/**
	 * 根据登陆角色设置该角色所拥有的导航菜单
	 * 
	 * @return 登陆用户的权限导航菜单
	 */
	public TreeNode getPermissionmenuItems() {
		if (null == getSession("usermenulist")) {
			UserInfo user = getUsersInSession();
			TreeNode userMenuList = permissionService.getPermissionmenuItems(
					user, root);
			setSession("usermenulist", userMenuList);
			return userMenuList;
		} else {
			return getSession("usermenulist");
		}
	}

	private TreeNode getPermissionmenuItems(int currentId) {
		TreeNode userMenuList = null;
		if (null == userMenuList) {
			userMenuList = permissionService.getPermissionmenuItems(
					this.currentId, relationRoot);
		}
		return userMenuList;
	}

	public void saveMenuidByUserid(ActionEvent event) {
		if (selectedNodes != null && selectedNodes.length > 0) {
			StringBuilder builder = new StringBuilder();

			for (TreeNode node : selectedNodes) {
				builder.append(node.getData().toString());
				builder.append("<br />");
			}

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Selected", builder.toString());

			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void displaySelectedSingle() {
		if (selectedNode != null) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Selected", selectedNode.getData().toString());

			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void deleteNode() {
		selectedNode.getChildren().clear();
		selectedNode.getParent().getChildren().remove(selectedNode);
		selectedNode.setParent(null);
		selectedNode = null;
	}

	public IPermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}

	public TreeNode getRoot() {
		return root = getPermissionmenuItems();
	}

	public void setRoot(TreeNode root) {

		this.root = root;
	}

	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}

	public TreeNode getRelationRoot() {
		return relationRoot = getPermissionmenuItems(this.currentId);
	}

	public void setRelationRoot(TreeNode relationRoot) {
		this.relationRoot = relationRoot;
	}

	public void displaySelectedMultiple(ActionEvent event) {
		System.out.println(this.currentId);
		if (selectedNodes != null && selectedNodes.length > 0) {
			StringBuilder builder = new StringBuilder();

			for (TreeNode node : selectedNodes) {
				builder.append(node.getData().toString());
				builder.append("<br />");
			}

			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Selected", builder.toString());

			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void saveMenuidByUserid() {
		if (selectedNodes != null && selectedNodes.length > 0) {
			int count = this.permissionService.saveRoleandRelation(
					this.currentId, selectedNodes);
			if (count == 1) {
				Role currRole = permissionService
						.findRoleByRoleid(this.currentId);
				addWorningMessage("", "角色名称为：" + currRole.getRolename()
						+ "的菜单已经更新完成！", false, 0);
			} else {
				addWorningMessage("", "菜单更新发生问题，请管理员解决后再进行相关操作！", false, 3);
			}

		}
	}

}
