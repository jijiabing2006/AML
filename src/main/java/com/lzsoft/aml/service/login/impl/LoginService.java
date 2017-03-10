package com.lzsoft.aml.service.login.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.lzsoft.aml.entity.model.Operation;
import com.lzsoft.aml.entity.model.OperationRoleRelation;
import com.lzsoft.aml.entity.model.RoleUserRelation;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.UserSession;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.login.ILoginService;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.util.PasswordDESUtil;

@ManagedBean(name="loginService")
@RequestScoped
public class LoginService extends BaseService implements ILoginService{
	
	
	@ManagedProperty("#{userinfo}")
	private UserInfo userInfo;
	@ManagedProperty("#{userSession}")
	private UserSession userSession;
	@Override
	public UserInfo checkLogin(UserInfo user) throws Exception {

		if (null == user) {
			System.out.println("USER is null");
			return null;
		}
//		user.setId(0);
//		loginDao.save(user);
		String pw=PasswordDESUtil.getEncrypt(user.getPassword());
	    UserInfo loadUse= dao.findByWhere(user.getClass(), " userid = ? and password=?", new Object[]{user.getUserid(),pw});
      
      	if (null != loadUse) {
//      		loginDao.delete(loadUse.getClass(),loadUse.getId());
      		loadUse.setPassword(PasswordDESUtil.getDecrypt(loadUse.getPassword()));
      		return loadUse;
		} else {
			return null;
		}

	}
	

	@Override
	public UserInfo findUser(UserInfo user) throws ManagerException {
		return dao.findByWhere(UserInfo.class, "userid=?", new Object[]{user.getUserid()});
	}
	public UserSession findUserSession(String id) throws ManagerException {
		return dao.findByWhere(UserSession.class, "sessionid=?", new Object[]{id});
	}
	
	@Override
	public void saveUserSession(UserInfo user,String id,String ip,String localHostName) {
		userSession.setSessionid(id);
		userSession.setIp(ip);
		userSession.setKickedout("0");
//		userSession.setPcname(System.getProperty("user.name"));
		userSession.setPcname(localHostName);
		userSession.setMdate(DateUtil.getCurrentDate("yyyy-MM-dd HH:mm:ss.SSS"));
		userSession.setUserid(user.getUserid());
		dao.save(userSession);
		
	}
	@Override
	public void updateUserSession(String id) {
		userSession.setKickedout("1");
		dao.save(userSession);
		
	}
	public void updateUserSession(UserSession us) {
		dao.save(us);
	}
	
	@Override
	public boolean findSessionIdByid(String id) {
		return null==dao.findByWhere(UserSession.class, "sessionid=?", new Object[]{id})?false:true;
	}
	
	@Override
	public Map<String,String> getPermissionopByUserid(UserInfo user) {
		String[] fields = new String[] { "roleid" };
		List<Object[]> roleids = dao.queryFieldValues(
				RoleUserRelation.class, fields, " userid = ? ",
				new Object[] { user.getId() });
		if (null == roleids || roleids.isEmpty()) {
			return null;
		}
		fields = new String[] { "opid" };
		List<Object[]> use_opids = dao.queryFieldValues(
				OperationRoleRelation.class, fields, " roleid in (?1) ",
				new Object[] { roleids });
		if (null == use_opids || use_opids.isEmpty()) {
			return null;
		}
		Map<String,String> opMaps=new HashMap<String, String>();
		List<Operation> ops = dao.queryByWhere(
				Operation.class, " state = ? ",
				new Object[] { 1 });
		for (Operation operation : ops) {
			if(use_opids.contains(operation.getId())){
//				System.out.println(operation.getId()+"==1");
				opMaps.put(String.valueOf(operation.getId()), "1");
			}else{
//				System.out.println(operation.getId()+"==0");
				opMaps.put(String.valueOf(operation.getId()), "0");
			}
		}
		return opMaps;

	}


	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserSession getUserSession() {
		return userSession;
	}
	public void setUserSession(UserSession userSession) {
		this.userSession = userSession;
	}
}
