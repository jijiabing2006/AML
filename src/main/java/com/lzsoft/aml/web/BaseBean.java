package com.lzsoft.aml.web;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.lzsoft.aml.entity.model.Download;
import com.lzsoft.aml.entity.model.UserInfo;

public class BaseBean {
	Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
	ResourceBundle messages = ResourceBundle.getBundle("i18n.resource", locale);
	/**
	 * 日志记录对象
	 */
	protected Logger log = Logger.getLogger(this.getClass());
	protected int currentId;

	/**
	 * 在Session中设置myLocale
	 * 
	 * @param key
	 */
	protected void setLocaleinSession(String key) {
		// System.out.println("locale====="+locale);
		setSession(key, locale);
	}

	/**
	 * 
	 * @param message
	 *            资源文件中的Key
	 * @param flag
	 *            是否到资源文件中查找资源
	 */
	/**
	 * 
	 * @param uiname
	 * @param message
	 *            资源文件中的Key
	 * @param flag
	 *            是否到资源文件中查找资源
	 * @param ordinal
	 *            message level : info=0; warn=1 ;error=2; fatal=3
	 */
	// FacesContext.getCurrentInstance().addMessage("form", new
	// FacesMessage(FacesMessage.SEVERITY_ERROR, "这里是消息","这里是消息明细"));
	// 这里有三个参数,第一个引号的地方应该填message标签for属性的内容,记住不要填ID,我没看过源码,但是我猜测这个消息应该是发给一个UI组件,然后由组件来派发消息的,
	// FacesMessage 里面后面两个参数一个是消息内容,一个是消息明细说明(这个显示与否是由showDetail="true"来决定的 ),
	protected void addWorningMessage(String uiname, String message,
			boolean flag, int ordinal) {
		String msg = "";
		if (flag) {
			msg = messages.getString(message);// find resource from sourcefiles.
		} else {
			msg = message;
		}
		switch (ordinal) {
		case 0:
			FacesContext.getCurrentInstance().addMessage(uiname,
					new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
			break;
		case 1:
			FacesContext.getCurrentInstance().addMessage(uiname,
					new FacesMessage(FacesMessage.SEVERITY_WARN, msg, null));
			break;
		case 2:
			FacesContext.getCurrentInstance().addMessage(uiname,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
			break;
		case 3:
			FacesContext.getCurrentInstance().addMessage(uiname,
					new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, null));
			break;
		default:
			break;
		}

	}

	protected <T> void setSession(String key, T value) {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		if (null != session) {
			session.setAttribute(key, value);
		}
	}

	protected String getRootURL() {
		HttpServletRequest request = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath();
		return basePath;
	}

	@SuppressWarnings("unchecked")
	protected <T> T getSession(String key) {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		if (null != session) {
			Object value = session.getAttribute(key);
			if (null != value) {
				return (T) value;
			}
		}
		return null;
	}

	protected HttpSession getSession(boolean flag) {
		return ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest()).getSession(flag);
	}
	protected HttpServletRequest getHttpServletRequest() {
		return ((HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest());
	}
	protected HttpServletResponse getHttpServletResponse() {
		return ((HttpServletResponse) FacesContext.getCurrentInstance()
				.getExternalContext().getResponse());
	}

	protected HttpSession getSession() {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		if (null != session) {
			return session;
		}
		return null;
	}

	protected void removeSession(String key) {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		if (null != session) {
			session.removeAttribute(key);
		}
	}

	protected void invalidate() {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		if (null != session) {
			session.invalidate();
		}
	}

	protected UserInfo getUsersInSession() {
		HttpSession session = ((HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest())
				.getSession();
		if (null == session.getAttribute("user")) {
			return null;
		}
		Object obj = session.getAttribute("user");
		if (null != obj) {
			return (UserInfo) obj;
		}
		return null;
	}

	public void reset(Object querybean) throws Exception {
		Field[] fields = querybean.getClass().getDeclaredFields();
		for (Field field : fields) {
			// System.out.println(field.getName());
			Object p = PropertyUtils.getProperty(querybean, field.getName());
			if (field.getType().equals(String.class) && null != p
					&& !"".equals(p.toString())) {
				PropertyUtils.setProperty(querybean, field.getName(), "");
			} else if (field.getType().equals(Date.class) && null != p) {
				// ConvertUtils.register(new DateConverter(null),
				// java.util.Date.class);
				PropertyUtils.setProperty(querybean, field.getName(), null);
			} else if (field.getType().equals(BigDecimal.class) && null != p) {
				PropertyUtils.setProperty(querybean, field.getName(),
						new BigDecimal(0));
			} else if (field.getType().equals(Double.class) && null != p) {
				PropertyUtils.setProperty(querybean, field.getName(), 0d);
			}
		}

	}

	protected void downloadBean(String filename, String filedesc) {
		Download download = new Download();
		download.setFileName(filename);
		download.setFileDesc(filedesc);
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put("download", download);
	}

	protected String getIp() {
		String ip = "";
		try {
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();

			ip = request.getHeader("x-forwarded-for");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("Proxy-Client-IP");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("WL-Proxy-Client-IP");
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip))
				ip = request.getRemoteAddr();
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip))
				ip = request.getHeader("via");
			if (ip == null || ip.length() == 0)
				ip = "unknown";
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ip;
	}

	public String getMACAddress(String ip) {
		String str = "";
		String macAddress = "";
		try {
			Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
			InputStreamReader ir = new InputStreamReader(p.getInputStream());
			LineNumberReader input = new LineNumberReader(ir);
			for (int i = 1; i < 100; i++) {
				str = input.readLine();
				if (str != null) {
					if (str.indexOf("MAC Address") > 1) {
						macAddress = str.substring(
								str.indexOf("MAC Address") + 14, str.length());
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		return macAddress;
	}
	/*
	 * get the local host ip
	 */

	protected String getLocalHostIP() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostAddress();
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * get the local host name
	 */
	protected String getLocalHostName() {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (Exception e) {
			return "";
		}
	}

	/*
	 * get the Remote host name
	 */
	protected String getRemoteHostName() {
		try {
			String rhn = "";
			HttpServletRequest request = (HttpServletRequest) FacesContext
					.getCurrentInstance().getExternalContext().getRequest();

			rhn = request.getRemoteHost();
			String username=request.getRemoteUser();
			return rhn;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public static boolean isPhoneNum(String str) {
		if (str == null)
			return false;
		Pattern pattern = Pattern
				.compile("\\d{3}-\\d{8}|\\d{4}-\\d{7}|\\d{11}",
						Pattern.CASE_INSENSITIVE);
		return pattern.matcher(str).matches();
	}

	public static boolean isAvailablePW(String str) {
		if (str == null)
			return false;
		// 一个好用的检查密码强度的正则表达式,可以检查至少有一个大写,一个小写, 一个特殊字符,长度要是6:
		Pattern pattern = Pattern
				.compile("^(?=.*\\d+)(?=.*[a-z]+)(?=.*[A-Z]+).*.{6,}$");
		return pattern.matcher(str).matches();
	}

	public int getCurrentId() {
		return currentId;
	}

	public void setCurrentId(int currentId) {
		this.currentId = currentId;
	}
}
