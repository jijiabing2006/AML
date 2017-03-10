package com.lzsoft.aml.service.systemmanager;


import java.util.List;

import com.lzsoft.aml.entity.model.Operation;
import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.querymodel.OpQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface IOpService {
	List<Operation> findAll() throws ManagerException;

	void delete(Operation operation) throws ManagerException;

	void update(Operation operation) throws ManagerException;
	void save(Operation operation) throws ManagerException;
    void saveAll(List<Operation> operations) throws ManagerException;
	List<Operation> findByQuerybean(OpQueryBean querybean) throws ManagerException, Exception;
	List<Object[]>  getPermissionOpIds(int userid) throws ManagerException, Exception;

	Operation find(Class<? extends Operation> operation, int id) throws ManagerException;;
	Role findRoleByRoleid(int currentId);

	int saveRoleandRelation(int currentId, List<Operation> ops);

	void deleteOpsByRoleid(int currentId);

	List<Object[]> getPermissionOpIdsByRoleid(int roleid);

}
