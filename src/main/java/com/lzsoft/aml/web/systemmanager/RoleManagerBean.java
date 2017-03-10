package com.lzsoft.aml.web.systemmanager;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.RoleUserRelation;
import com.lzsoft.aml.entity.model.querymodel.RoleQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemmanager.IRoleService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "roleMBean")
@ViewScoped
public class RoleManagerBean extends BaseBean {
	@ManagedProperty("#{role}")
	private Role role;

	@ManagedProperty("#{roleQueryBean}")
	private RoleQueryBean querybean;

	@ManagedProperty("#{roleService}")
	private IRoleService roleService;

	private List<Role> roles;
	int i = 0;

	private Collection<Object> selection;

	public void selectionListener(AjaxBehaviorEvent event) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		Object originalKey = dataTable.getRowKey();
		role = null;
		for (Object selectionKey : selection) {
			dataTable.setRowKey(selectionKey);
			if (dataTable.isRowAvailable()) {
				role = (Role) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(originalKey);
	}

	public List<Role> getRoles() {

		// System.out.println(i++);//datatables会多次预加载（这个问题比较麻烦，还没真正有办法解决）
		synchronized (this) {

			if (querybean.isSelected()) {
				try {
					roles = this.roleService.findByQuerybean(this.querybean);
					querybean.setSelected(false);
				} catch (ManagerException e) {
					e.printStackTrace();
					addWorningMessage("", "查询角色失败", false, 2);
				} catch (Exception e) {
					e.printStackTrace();
					addWorningMessage("", "查询角色失败" + e.getMessage(), false, 3);
				}
			} else if (null == roles) {
				roles = this.roleService.findAll();

			}
		}
		for (Role role : roles) {
			role.setSelected(false);
		}
		if (0 != currentId) {
			selectRoleIdByUserId();
		}
		return roles;
	}

	protected void selectRoleIdByUserId() {
		try {
			List<RoleUserRelation> rurs = this.roleService
					.findByUserId(currentId);
			if (null != rurs && !rurs.isEmpty() && null != roles) {
				
				for (RoleUserRelation roleUserRelation : rurs) {
					for (Role role : roles) {
						if (role.getId() == roleUserRelation.getRoleid()) {
							role.setSelected(true);
						}
					}
				}
			}
		} catch (ManagerException e) {
			e.printStackTrace();
			addWorningMessage("", "通过UserId查询角色失败" + e.getMessage(), false, 3);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("", "通过UserId查询角色失败" + e.getMessage(), false, 3);
		}
	}

	public void deleteRecord(Role role) {
		this.roleService.delete(role);
		this.roles.remove(role);// 同步(roles)
	}

	public void deleteRecordByID() {
	}

	public void add() {
		if (role.getId() == 0) {
			this.roleService.save(role);
			querybean.setSelected(true);
			addWorningMessage("dataForm", "角色名称为：" + role.getRolename()
					+ "的角色创建完成！", false, 0);
		} else {
			updateRole();
		}
	}

	public void removeRecord() {
		for (Role role : roles) {
			if (currentId == role.getId()) {
				this.roleService.delete(role);
				this.roles.remove(role);// 同步(roles)
				addWorningMessage("dataForm", "角色名称为：" + role.getRolename()
						+ "的角色已经删除！", false, 0);
				break;
			}
		}
	}

	public void goEdit(Role role) {
		this.role = role;
	}

	public void updateRole() {
		this.roleService.update(this.role);
		this.role = this.roleService.find(role.getClass(), role.getId());
		addWorningMessage("dataForm", "角色名称为：" + role.getRolename()
				+ "的内容已经保存！", false, 0);
	}

	public void reset() {
		querybean.setRolename(null);
	}

	public void saveRoleidByUserid() {
		synchronized (this) {
			StringBuffer r = new StringBuffer();
			this.roleService.deleteRolesByUserid(currentId);

			for (Role role : roles) {
				if (role.isSelected()) {
					r.append(role.getRolename()).append(",");
					this.roleService.saveRoleRelation2User(currentId,
							role.getId());
				} else {
					role.setSelected(false);
				}
			}
			addWorningMessage("dataForm", "角色：" + r.toString() + "已经分配给指定用户！",
					false, 0);
		}
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public RoleQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(RoleQueryBean querybean) {
		this.querybean = querybean;
	}

	public IRoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Collection<Object> getSelection() {
		return selection;
	}

	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}

}
