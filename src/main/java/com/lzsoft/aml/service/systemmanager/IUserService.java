package com.lzsoft.aml.service.systemmanager;


import java.util.List;

import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.UserQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface IUserService {
	List<UserInfo> findAll() throws ManagerException;

	void delete(UserInfo user) throws ManagerException;

	void update(UserInfo user) throws ManagerException;
	void save(UserInfo user) throws ManagerException;
    void saveAll(List<UserInfo> users) throws ManagerException;
	List<UserInfo> findByQuerybean(UserQueryBean querybean) throws ManagerException, Exception;

	UserInfo find(Class<? extends UserInfo> user, int id) throws ManagerException;;


}
