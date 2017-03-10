package com.lzsoft.aml.service.permission;

import java.util.List;

import org.primefaces.model.TreeNode;

import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.UserInfo;

public interface IPermissionService {

	/**
	 * 根据登陆用户设置该用户所拥有的导航菜单
	 * 
	 * @return 登陆用户的权限导航菜单
	 */

	List<TreeNode> getPermissionmenuItems(UserInfo user, List<TreeNode> rootNodes);

	TreeNode getPermissionmenuItems(UserInfo user, TreeNode nodes);

	int saveRoleandRelation(int currentId, TreeNode[] selectedNodes);

	Role findRoleByRoleid(int currentId);

	TreeNode getPermissionmenuItems(int currentId, TreeNode root);


}
