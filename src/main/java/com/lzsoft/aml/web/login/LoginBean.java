package com.lzsoft.aml.web.login;

import java.io.IOException;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.login.ILoginService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean extends BaseBean {

	private String outcome = "";

	@ManagedProperty("#{userinfo}")
	private UserInfo userInfo;

	@ManagedProperty("#{loginService}")
	private ILoginService loginService;

	private String isHQ = "0";

	public String getIsHQ() {
		return isHQ;
	}

	public void setIsHQ(String isHQ) {
		this.isHQ = isHQ;
	}

	public LoginBean() {
		super();
	}

	public String autoLogin(String username) {
		HttpSession session = getSession();
		if (null != session.getAttribute("user")) {
			return "";
		}
		String domainname = (String) session.getAttribute("domainname");
		String domainuser = (String) session.getAttribute("domainuser");
		if (null != domainuser) {
			UserInfo u = new UserInfo();
			u.setUserid(domainuser);
			userInfo = loginService.findUser(u);
			if (userInfo != null) {
				setCorrespondingPermissions();
			}
		}
		return outcome;
	}

	private void redirectURL(String redirectUrl) {
		try {
			FacesContext fc = FacesContext.getCurrentInstance();

			fc.getExternalContext().redirect(
					getHttpServletRequest().getContextPath() + redirectUrl);

		} catch (IOException e) {
			e.printStackTrace();
			addWorningMessage("", "用户[" + userInfo.getUserid() + "]登录跳转页面失败."
					+ e.getMessage(), false, 2);
		}
	}

	public String login() {
		// if (null==getSession(false)) {
		System.out.println(getSession().getId());
		if (this.loginService.findSessionIdByid(getSession().getId())) {
			logout();
			return outcome;
		}
		if ("".equals(userInfo.getUserid())
				|| "".equals(userInfo.getPassword())) {
			addWorningMessage("", "usernameorpasswordnoempty", true, 1);
			outcome = Constants.LOGIN;
			return outcome;
		}
		try {
			userInfo = loginService.checkLogin(userInfo);
			if (userInfo != null) {
				setCorrespondingPermissions();
			} else {
				addWorningMessage("", "usernameorpasswordincorrect", true, 1);
				outcome = Constants.LOGIN;
			}
		} catch (ManagerException e) {
			e.printStackTrace();
			addWorningMessage("",
					"用户[" + userInfo.getUserid() + "]登录失败." + e.getMessage(),
					false, 2);
			outcome = Constants.LOGIN;
			userInfo = null;
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("",
					"用户[" + userInfo.getUserid() + "]登录失败." + e.getMessage(),
					false, 2);
			outcome = Constants.LOGIN;
			userInfo = null;
		}
		// }
		return outcome;

	}

	private void setCorrespondingPermissions() {
		if (StringUtils.equals(Constants.NOTENABLE, userInfo.getState())) {
			addWorningMessage("", "用户[" + userInfo.getUserid() + "]已被禁止登陆.",
					false, 1);
			return;
		}
		setSession("op", this.loginService.getPermissionopByUserid(userInfo));

		String basePath = getRootURL();
		setSession("user", userInfo);
		setSession("basePath", basePath);
		setSession("rows", Constants.DEFAULT_ROWS);
		if (null == getSession("myLocale")) {
			setLocaleinSession("myLocale");
		}
		this.loginService.saveUserSession(userInfo, getSession().getId(),
				getIp(), getRemoteHostName());
		redirectURL(Constants.FORWRD_MAIN);
	}

	public String logout() {
		String userName = userInfo.getUserid();
		removeSession(userName);
		invalidate();
		this.loginService.updateUserSession(getSession().getId());
		userInfo.setUserid(null);
		userInfo.setPassword(null);
		userInfo = null;
		redirectURL(Constants.LOGIN);
		return outcome;

	}

	public String checkUser() {
		if (!"".equals(userInfo.getUserid())) {
			UserInfo ut = loginService.findUser(userInfo);

			if (null != ut) {
				if (null == ut.getExpire()) {
					userInfo.setExpire(new Date());
					ut.setExpire(new Date());
				}
				if (new Date().compareTo(ut.getExpire()) >= 0) {
					userInfo.setState("2");// 密码过期，需要修改
					addWorningMessage("loginform", "密码已经到期，请修改密码后再登录。", false,
							1);
					return outcome;
				}
			}
		}
		userInfo.setState("1");

		return null;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}

}
