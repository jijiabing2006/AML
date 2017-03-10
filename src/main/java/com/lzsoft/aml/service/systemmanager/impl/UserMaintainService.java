package com.lzsoft.aml.service.systemmanager.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IUserMaintainService;
import com.lzsoft.aml.util.PasswordDESUtil;

@ManagedBean(name = "userMaintainService")
@RequestScoped
public class UserMaintainService extends BaseService implements
		IUserMaintainService {

	@ManagedProperty("#{userinfo}")
	private UserInfo userInfo;

	@Override
	public UserInfo checkLogin(UserInfo user) throws Exception {

		if (null == user) {
			System.out.println("USER is null");
			return null;
		}
		// user.setId(0);
		// loginDao.save(user);
		String pw = PasswordDESUtil.getEncrypt(user.getPassword());
		UserInfo loadUse = dao.findByWhere(user.getClass(),
				" userid = ? and password=?", new Object[] { user.getUserid(),
						pw });

		if (null != loadUse) {
			// loginDao.delete(loadUse.getClass(),loadUse.getId());
			loadUse.setPassword(PasswordDESUtil.getDecrypt(loadUse
					.getPassword()));
			return loadUse;
		} else {
			return null;
		}

	}

	@Override
	public UserInfo findUser(UserInfo user) throws ManagerException {
		return dao.findByWhere(UserInfo.class, "userid=?",
				new Object[] { user.getUserid() });
	}

	@Override
	public void save(UserInfo user) throws Exception {
		user.setPassword(PasswordDESUtil.getEncrypt(user.getPassword()));
		dao.save(user);
		user.setPassword(PasswordDESUtil.getDecrypt(user.getPassword()));
//		saveLogs(user.getUserid(), "修改密码","修改密码。");
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

}
