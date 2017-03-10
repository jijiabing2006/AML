package com.lzsoft.aml.service.login;


import java.util.Map;

import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.exception.ManagerException;

public interface ILoginService {
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
	/**
	 * 保存SessionID
	 * @param id
	 * @param ip 
	 * @param string 
	 */
	public void saveUserSession(UserInfo user,String id, String ip, String string);
	/**
	 *更新当前User是否登录状态
	 * @param id
	 */
	public void updateUserSession(String id);
	
	public boolean findSessionIdByid(String id);
	public Map<String,String> getPermissionopByUserid(UserInfo user);
}
