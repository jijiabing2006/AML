package com.lzsoft.aml.service.systemmanager.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.RoleUserRelation;
import com.lzsoft.aml.entity.model.querymodel.RoleQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IRoleService;
import com.lzsoft.aml.util.DateUtil;

@ManagedBean(name = "roleService")
@ViewScoped
public class RoleService extends BaseService implements IRoleService {

	@Override
	public Role find(Class<? extends Role> role, int id)
			throws ManagerException {
		return dao.find(Role.class, id);
	}
	
	@Override
	public List<Role> findAll() throws ManagerException {
		
		return dao.queryByWhere(Role.class, "",
				null);
	}
	@Override
	public void delete(Role role)
			throws ManagerException {
		dao.delete(Role.class,
				role.getId());
	}
	@Override
	public void update(Role role)
			throws ManagerException {
		dao.update(role);
	}
	
	@Override
	public void save(Role role)
			throws ManagerException {
		dao.save(role);
	}
	
	@Override
	public void saveAll(List<Role> roles)
			throws ManagerException {
		dao.saveAll(roles);
	}

	
	@Override
	public List<Role> findByQuerybean(RoleQueryBean querybean)throws ManagerException,Exception {
		return dao.queryByWhere(Role.class, generateQuerySql(querybean));
	}
	@Override
	public List<RoleUserRelation> findByUserId(int userId)throws ManagerException,Exception {
		return dao.queryByWhere(RoleUserRelation.class, "userid=?",new Object[]{userId});
	}

	@Override
	public void deleteRolesByUserid(int currentId)  {
		    dao.deleteByWhere(RoleUserRelation.class, "userid=?",new Object[]{currentId});
		
	}

	@Override
	public void saveRoleRelation2User(int currentId, int id){
		RoleUserRelation rur=new RoleUserRelation();
		rur.setCdate(DateUtil.getCurrentDate("yyyy-MM-dd"));
		rur.setRoleid(id);
		rur.setUserid(currentId);
		dao.save(rur);
	}

}
