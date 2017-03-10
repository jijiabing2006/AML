package com.lzsoft.aml.service.systemmanager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.model.Operation;
import com.lzsoft.aml.entity.model.OperationRoleRelation;
import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.RoleUserRelation;
import com.lzsoft.aml.entity.model.querymodel.OpQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IOpService;

@ManagedBean(name = "opService")
@ViewScoped
public class OpService extends BaseService implements IOpService {

	@Override
	public Operation find(Class<? extends Operation> role, int id)
			throws ManagerException {
		return dao.find(Operation.class, id);
	}

	@Override
	public List<Operation> findAll() throws ManagerException {

		return dao.queryByWhere(Operation.class, "1=1 order by id", null);
	}

	@Override
	public void delete(Operation role) throws ManagerException {
		dao.delete(Operation.class, role.getId());
	}

	@Override
	public void update(Operation role) throws ManagerException {
		dao.update(role);
	}

	@Override
	public void save(Operation role) throws ManagerException {
		dao.save(role);
	}

	@Override
	public void saveAll(List<Operation> roles) throws ManagerException {
		dao.saveAll(roles);
	}

	@Override
	public List<Operation> findByQuerybean(OpQueryBean querybean)
			throws ManagerException, Exception {
		return dao.queryByWhere(Operation.class, generateQuerySql(querybean));
	}

	/**
	 * 根据Userid,返回所有可操作的权限
	 * 
	 * @param user
	 * @return menuids
	 */
	@Override
	public List<Object[]> getPermissionOpIds(int userid) {
		// List<RoleUserRelation> roleuserrelationList =
		// permissionDao.queryByWhere(RoleUserRelation.class,
		// " userid = ? ",
		// new Object[] { user.getId() });
		String[] fields = new String[] { "roleid" };
		List<Object[]> roleids = dao.queryFieldValues(RoleUserRelation.class,
				fields, " userid = ? ", new Object[] { userid });
		//
		// List<TopMenuRoleRelation> topmenurolerelationList =
		// permissionDao.queryByWhere(TopMenuRoleRelation.class,
		// " roleid in (?1) ",
		// new Object[] {roleids});
		if (null == roleids || roleids.isEmpty()) {
			return null;
		}
		String[] menuids = new String[] { "opid" };
		List<Object[]> opids = dao.queryFieldValues(
				OperationRoleRelation.class, menuids, " roleid in (?1) ",
				new Object[] { roleids });

		return opids;
	}
	/**
	 * 根据Roleid,返回所有可操作的权限
	 * 
	 * @param roleid
	 * @return menuids
	 */
	@Override
	public List<Object[]> getPermissionOpIdsByRoleid(int roleid) {
		
		String[] ops = new String[] { "opid" };
		List<Object[]> opids = dao.queryFieldValues(
				OperationRoleRelation.class, ops, " roleid=? ",
				new Object[] { roleid });
		
		return opids;
	}

	@Override
	public Role findRoleByRoleid(int currentId) {
		return dao.find(Role.class, currentId);
	}

	@Override
	public int saveRoleandRelation(int currentId, List<Operation> ops) {
		List<OperationRoleRelation> oprelations = new ArrayList<OperationRoleRelation>();
		OperationRoleRelation orr = null;
		for (Operation operation : ops) {
			if (operation.isSelected()) {
				orr = new OperationRoleRelation();
				orr.setCdate(new Date());
				orr.setOpid(operation.getId());
				orr.setRoleid(currentId);
				oprelations.add(orr);
				operation.setSelected(false);
			}

		}
		
		dao.saveAll(oprelations);
		return 1;

	}

	@Override
	public void deleteOpsByRoleid(int currentId) {
		dao.deleteByWhere(OperationRoleRelation.class, "roleid=?",
				new Object[] { currentId });
		
	}
}
