package com.lzsoft.aml.service.systemmanager.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.UserQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IUserService;

@ManagedBean(name = "userService")
@ViewScoped
public class UserService extends BaseService implements IUserService {

	@Override
	public UserInfo find(Class<? extends UserInfo> user, int id)
			throws ManagerException {
		return dao.find(UserInfo.class, id);
	}
	
	@Override
	public List<UserInfo> findAll() throws ManagerException {
		return dao.queryByWhere(UserInfo.class, "",
				null);
	}
	@Override
	public void delete(UserInfo user)
			throws ManagerException {
		dao.delete(UserInfo.class,
				user.getId());
	}
	@Override
	public void update(UserInfo user)
			throws ManagerException {
		dao.update(user);
	}
	
	@Override
	public void save(UserInfo user)
			throws ManagerException {
		dao.save(user);
	}
	
	@Override
	public void saveAll(List<UserInfo> users)
			throws ManagerException {
		dao.saveAll(users);
	}
	
	@Override
	public List<UserInfo> findByQuerybean(UserQueryBean querybean)throws ManagerException,Exception {
		return dao.queryByWhere(UserInfo.class, generateQuerySql(querybean));
	}

}
