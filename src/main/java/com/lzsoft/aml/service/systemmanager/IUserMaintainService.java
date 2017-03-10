package com.lzsoft.aml.service.systemmanager;


import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.exception.ManagerException;

public interface IUserMaintainService {
	/**
	 * 登陆验证
	 * 
	 * @param user
	 *            用户输入的信息
	 * @return 对应用户的信息或空
	 * @throws Exception 
	 */
	public UserInfo checkLogin(UserInfo user) throws ManagerException, Exception;
	/**
	 * 登陆验证
	 * 
	 * @param user
	 *            用户输入的信息
	 * @return 对应用户的信息或空
	 */
	public UserInfo findUser(UserInfo user) throws ManagerException;
	public void save(UserInfo userInfo) throws Exception;
}
