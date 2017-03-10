package com.lzsoft.aml.service.permission.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.lzsoft.aml.dao.DAO;
import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.RoleUserRelation;
import com.lzsoft.aml.entity.model.TopMenu;
import com.lzsoft.aml.entity.model.TopMenuRoleRelation;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.service.permission.IPermissionService;

@ManagedBean(name = "permissionService")
@RequestScoped
public class PermissionService implements IPermissionService {

	@ManagedProperty("#{topmenu}")
	private TopMenu topmenu;

	@ManagedProperty("#{topmenurolerelation}")
	private TopMenuRoleRelation topmenurolerelation;

	@ManagedProperty("#{roleuserrelation}")
	private RoleUserRelation roleuserrelation;

	@ManagedProperty("#{dao}")
	private DAO permissionDao;

	public PermissionService() {
		super();
	}

	@Override
	public List<TreeNode> getPermissionmenuItems(UserInfo user,
			List<TreeNode> nodes) {
		if (null == user) {
			System.out.println("USER is null");
			return null;
		}
		return nodes;
	}

	private void addNodes(TreeNode topnode) {
		for (TopMenu subMenu : this.topmenus) {
			if (subMenu.getParentid() == ((TopMenu) topnode.getData()).getId()) {// 增加子结点
				TreeNode subnode = null;
				if (parentids.indexOf(String.valueOf(subMenu.getId())) >= 0) {// 如果id在parentids中出现，说明下面有结点。
					subnode=new DefaultTreeNode(subMenu, topnode);
					addNodes(subnode);// 递归增加结点
				}else{
					subnode=new DefaultTreeNode("leaf",subMenu, topnode);
				}
			}
		}

	}

	/**
	 * 
	 * @param topnode
	 * @param isSelectd
	 *            角色对此菜单有权限，将结节设置为Selected
	 */
	private void addNodes(TreeNode topnode, boolean isSelectd) {
		for (TopMenu subMenu : this.topmenus) {
			if (subMenu.getParentid() == ((TopMenu) topnode.getData()).getId()) {// 增加子结点
				TreeNode subnode = new DefaultTreeNode(subMenu, topnode);
				setSelected(subMenu, subnode);
				if (parentids.indexOf(String.valueOf(subMenu.getId())) >= 0) {// 如果id在parentids中出现，说明下面有结点。
					addNodes(subnode, true);// 递归增加结点
				}
			}
		}

	}

	/**
	 * 根据角色权限（可操作菜单）设置Tree节点为已选择
	 * 
	 * @param subMenu
	 * @param subnode
	 */
	private void setSelected(TopMenu subMenu, TreeNode subnode) {

		if (null != topmenuids && topmenuids.contains(subMenu.getId())) {// 被选角色可操作的菜单ids中，包括当前时，selected设置为True
			subnode.setSelected(true);
		}
	}

	@Override
	public TreeNode getPermissionmenuItems(UserInfo user, TreeNode rootnode) {
		if (null == user) {
			System.out.println("USER is null");
			return null;
		}
		init(user.getId());
		rootnode = new DefaultTreeNode("Root", null);
		for (TopMenu topMenu : this.topmenus) {

			if (0 == topMenu.getParentid()) {
				TreeNode topNode = new DefaultTreeNode(topMenu, rootnode);
				if (parentids.indexOf(String.valueOf(topMenu.getId())) >= 0)// 如果id在parentids中出现，说明下面有结点。
					addNodes(topNode);
			}
		}
		return rootnode;
	}

	@Override
	public TreeNode getPermissionmenuItems(int currentId, TreeNode rootnode) {
		rootnode = new DefaultTreeNode("Root", null);
		// if (0 != currentId) {
		// if(null==topmenus){
		// if (0 != currentId) {
		// System.out.println();
		// }
		topmenuids = null == topmenuids || topmenuids.isEmpty() ? getPermissionMenuIdsByRoleid(currentId)
				: topmenuids;

		topmenus = null == topmenus || topmenus.isEmpty() ? getTopmenus()
				: topmenus;
		parentids = null == parentids || parentids.length() == 0 ? getParentidsByTopmenus()
				: parentids;
		for (TopMenu topMenu : this.topmenus) {

			if (0 == topMenu.getParentid()) {// 一级菜单
				TreeNode topNode = new DefaultTreeNode(topMenu, rootnode);
				setSelected(topMenu, topNode);
				if (parentids.indexOf(String.valueOf(topMenu.getId())) >= 0)// 如果id在parentids中出现，说明下面有结点。
					addNodes(topNode, true);

			}
		}
		// }
		// }

		return rootnode;
	}

	List<Object[]> topmenuids = null;
	StringBuffer parentids = null;
	List<TopMenu> topmenus = null;

	/**
	 * 通过User及相应Role得到Menu集合
	 * 
	 * @param user
	 * @return
	 */
	private void init(int currentId) {
		if (null == topmenuids)
			topmenuids = getPermissionMenuIds(currentId);
		if (null == topmenus)
			topmenus = getTopmenusByTopmenuids();
		if (null == parentids)
			parentids = getParentidsByTopmenus();
	}

	/**
	 * 遍历topmenus，得到parentids. 同时，对topmenus进行排序，（parentid+sequence)
	 * 
	 * @return
	 */
	private StringBuffer getParentidsByTopmenus() {
		parentids = new StringBuffer();
		for (TopMenu topmenu : topmenus) {
			parentids.append(String.valueOf(topmenu.getParentid()) + "|");
		}
		return parentids;
	}

	private List<TopMenu> getTopmenusByTopmenuids() {

		getTopMenus(getTopmenus());

		// topmenus = permissionDao.queryByWhere(TopMenu.class,
		// " state=? and id in (?2)", new Object[] { 1, topmenuids });
		if (null != topmenus) {
			Collections.sort(topmenus, TopMenu.comparator);
		}
		return topmenus;
	}

	private void getTopMenus(List<TopMenu> totalTopmenus) {
		topmenus = new ArrayList<TopMenu>();
		for (TopMenu topmenu : totalTopmenus) {
			if (topmenuids.contains(topmenu.getId())) {
				topmenus.add(topmenu);
				addParentMenu(totalTopmenus, topmenu);
			}
		}
	}

	/**
	 * 递归增加父菜单
	 * 
	 * @param totalTopmenus
	 * @param topmenu
	 */
	private void addParentMenu(List<TopMenu> totalTopmenus, TopMenu topmenu) {
		if (!topmenuids.contains(topmenu.getParentid())) {
			for (TopMenu topmenu2 : totalTopmenus) {
				if (topmenu2.getId() == topmenu.getParentid()) {
					if (!topmenus.contains(topmenu2)) {
						topmenus.add(topmenu2);
						if (topmenu2.getParentid() != 0) {
							addParentMenu(totalTopmenus, topmenu2);
						}
					}

				}
			}
		}
	}

	private List<TopMenu> getTopmenus() {
		List<TopMenu> topmenus = permissionDao.queryByWhere(TopMenu.class,
				" state=?", new Object[] { 1 });
		if (null != topmenus) {
			Collections.sort(topmenus, TopMenu.comparator);
		}
		return topmenus;
	}

	/**
	 * 根据Roleid,返回所有可操作的菜单ids
	 * 
	 * @param user
	 * @return menuids
	 */
	private List<Object[]> getPermissionMenuIdsByRoleid(int roleid) {
		String[] menuids = new String[] { "menuid" };
		List<Object[]> topmenuids = permissionDao.queryFieldValues(
				TopMenuRoleRelation.class, menuids, " roleid = ? ",
				new Object[] { roleid });
		return topmenuids;
	}

	/**
	 * 根据User权限,返回所有可操作的菜单
	 * 
	 * @param user
	 * @return menuids
	 */
	private List<Object[]> getPermissionMenuIds(int userid) {
		// List<RoleUserRelation> roleuserrelationList =
		// permissionDao.queryByWhere(RoleUserRelation.class,
		// " userid = ? ",
		// new Object[] { user.getId() });
		String[] fields = new String[] { "roleid" };
		List<Object[]> roleids = permissionDao.queryFieldValues(
				RoleUserRelation.class, fields, " userid = ? ",
				new Object[] { userid });
		//
		// List<TopMenuRoleRelation> topmenurolerelationList =
		// permissionDao.queryByWhere(TopMenuRoleRelation.class,
		// " roleid in (?1) ",
		// new Object[] {roleids});
		if (null == roleids || roleids.isEmpty()) {
			return null;
		}
		String[] menuids = new String[] { "menuid" };
		List<Object[]> topmenuids = permissionDao.queryFieldValues(
				TopMenuRoleRelation.class, menuids, " roleid in (?1) ",
				new Object[] { roleids });

		return topmenuids;
	}

	public TopMenu getTopmenu() {
		return topmenu;
	}

	public void setTopmenu(TopMenu topmenu) {
		this.topmenu = topmenu;
	}

	public TopMenuRoleRelation getTopmenurolerelation() {
		return topmenurolerelation;
	}

	public void setTopmenurolerelation(TopMenuRoleRelation topmenurolerelation) {
		this.topmenurolerelation = topmenurolerelation;
	}

	public RoleUserRelation getRoleuserrelation() {
		return roleuserrelation;
	}

	public void setRoleuserrelation(RoleUserRelation roleuserrelation) {
		this.roleuserrelation = roleuserrelation;
	}

	public DAO getPermissionDao() {
		return permissionDao;
	}

	public void setPermissionDao(DAO permissionDao) {
		this.permissionDao = permissionDao;
	}

	// @Override
	// public int saveRoleandRelation(int currentId, TreeNode[] selectedNodes) {
	// List<String> relationmenuids = new ArrayList<String>();
	// List<TopMenuRoleRelation> removes = new ArrayList<TopMenuRoleRelation>();
	// List<TopMenuRoleRelation> rolerelations = getExistMenuRelationsByRoleid(
	// currentId, relationmenuids);
	//
	// combinSelectMenuToExistMenu(currentId, selectedNodes, relationmenuids,
	// rolerelations);
	// removeMenuIds(relationmenuids, removes, rolerelations);
	// if (rolerelations.size() == selectedNodes.length) {
	// permissionDao.saveAll(rolerelations);
	// return 1;
	// } else {
	// return 0;
	// }
	// }
	@Override
	public int saveRoleandRelation(int currentId, TreeNode[] selectedNodes) {
		List<TopMenuRoleRelation> rolerelations = new ArrayList<TopMenuRoleRelation>();
		TopMenuRoleRelation tmr = null;
		for (TreeNode treeNode : selectedNodes) {
			int selectedMenuid = ((TopMenu) treeNode.getData()).getId();
			tmr = new TopMenuRoleRelation();
			tmr.setCdate(new Date());
			tmr.setMenuid(selectedMenuid);
			tmr.setRoleid(currentId);
			rolerelations.add(tmr);

		}
		if (rolerelations.size() == selectedNodes.length) {
			permissionDao.deleteByWhere(TopMenuRoleRelation.class, "roleid=?",
					new Object[] { currentId });
			permissionDao.saveAll(rolerelations);
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public Role findRoleByRoleid(int currentId) {
		return permissionDao.find(Role.class, currentId);
	}

}
