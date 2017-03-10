package com.lzsoft.aml.web.systemmanager;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemmanager.IUserMaintainService;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "userMaintainBean")
@RequestScoped
public class UserMaintainBean extends BaseBean {

	private String outcome = "";

	@ManagedProperty("#{userinfo}")
	private UserInfo userInfo;

	@ManagedProperty("#{userMaintainService}")
	private IUserMaintainService userMaintainService;

	public UserMaintainBean() {
	}

	public String checkPassword() {
		if (!"".equals(userInfo.getNewpassword())) {
			userInfo.setPassword(userInfo.getNewpassword());
			try {
				UserInfo checkUser = userMaintainService.checkLogin(userInfo);
				if (null == checkUser) {
					addWorningMessage("", "oldpasswordincorrect", true, 1);
					userInfo.setState("3");// 旧密码不正确
					userInfo.setPassword("");
					userInfo.setNewpassword("");
				} else {
					userInfo.setState("1");
				}
			} catch (ManagerException e) {
				e.printStackTrace();
				addWorningMessage("", "用户[" + userInfo.getUserid() + "]密码检测失败."
						+ e.getMessage(), false, 2);
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("", "用户[" + userInfo.getUserid() + "]密码检测失败."
						+ e.getMessage(), false, 2);
			}
		}
		return outcome;
	}

	public String checkConfirmPassword() {
		// if
		// (!"".equals(userInfo.getNewpassword())&&!"".equals(userInfo.getConfirmpassword()))
		// {
		// if(!userInfo.getNewpassword().equals(userInfo.getConfirmpassword())){
		// addWorningMessage("","confirmpasswordnotequalsnewpassword",true,2);
		// }
		// }
		return outcome;
	}

	public String changePassword() {
		if (null == userInfo.getPassword()
				|| "0".equals(userInfo.getPassword())
				|| "null".equals(userInfo.getPassword())) {
			addWorningMessage("", "oldpasswordincorrect", true, 1);
			return null;
		}
		// if("3".equals(userInfo.getState())){
		// addWorningMessage("","oldpasswordincorrect",true,1);
		// return null;
		// }
		if ("".equals(userInfo.getUserid())
				|| "".equals(userInfo.getNewpassword())) {
			addWorningMessage("", "newpasswordcannotspace", true, 1);
			outcome = Constants.LOGIN;
		} else {
			if (!isAvailablePW(userInfo.getNewpassword())) {
				addWorningMessage("", "pwstrength_alert", true, 1);
				return null;
			}

			UserInfo ut = userMaintainService.findUser(userInfo);
			ut.setPassword(userInfo.getNewpassword());
			ut.setLastmofdate(new Date());
			ut.setExpire(DateUtil.addDay(ut.getLastmofdate(),
					Constants.PWD_EXPIRE_DAYS));
			ut.setState("1");
			ut.setHistorypwd(ut.getHistorypwd() + userInfo.getPassword() + "|");
			try {
				userMaintainService.save(ut);
			} catch (Exception e) {
				e.printStackTrace();
				addWorningMessage("", "用户[" + userInfo.getUserid() + "]修改密码失败."
						+ e.getMessage(), false, 2);
				userInfo.setPassword(null);
			}

			addWorningMessage("", "yourpasswordhasbeenupdated", true, 0);
			// addWorningMessage("","下次密码到期时间"+DateUtil.dateToStr(userInfo.getExpire(),
			// "yyyy-MM-dd"),false,0);

		}
		return outcome;
	}

	public String changeUserinfo() {
		try {
			userMaintainService.save(userInfo);
			addWorningMessage("", "userinforhasbeenupdated", true, 0);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage(null, "用户[" + userInfo.getUserid() + "]修改用户信息失败."
					+ e.getMessage(), false, 3);
			userInfo.setPassword(null);
		}
		return outcome;
	}

	public UserInfo getUserInfo() {
		if (null == userInfo || userInfo.getId() == 0) {
			userInfo = null != getUsersInSession() ? getUsersInSession()
					: userInfo;
		}

		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public IUserMaintainService getuserMaintainService() {
		return userMaintainService;
	}

	public void setuserMaintainService(IUserMaintainService userMaintainService) {
		this.userMaintainService = userMaintainService;
	}

}
