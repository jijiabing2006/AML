package com.lzsoft.aml.service.systemmanager;


import java.util.List;

import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.RoleUserRelation;
import com.lzsoft.aml.entity.model.querymodel.RoleQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface IRoleService {
	List<Role> findAll() throws ManagerException;

	void delete(Role role) throws ManagerException;

	void update(Role role) throws ManagerException;
	void save(Role role) throws ManagerException;
    void saveAll(List<Role> roles) throws ManagerException;
	List<Role> findByQuerybean(RoleQueryBean querybean) throws ManagerException, Exception;

	Role find(Class<? extends Role> role, int id) throws ManagerException;

	void deleteRolesByUserid(int currentId);

	void saveRoleRelation2User(int currentId, int id);

	List<RoleUserRelation> findByUserId(int currentId) throws ManagerException, Exception;


}
