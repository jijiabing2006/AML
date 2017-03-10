package com.lzsoft.aml.logs;

import java.lang.reflect.InvocationTargetException;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lzsoft.aml.dao.DAO;
import com.lzsoft.aml.entity.model.Logs;
import com.lzsoft.aml.entity.model.UserSession;
import com.lzsoft.aml.util.DateUtil;

@Component
@Aspect
public class LogAdvice {

	@Resource(name = "dao")
	private DAO dao;
	@Autowired
	private Logs logs;

	/**
	 * 
	 * 在方法开始前纪录
	 * 
	 * @param jp
	 */

	@Before("com.lzsoft.aml.logs.LogPointcut.inServiceLayer()")
	public void logInfo(JoinPoint jp) {
		// System.out.println("====" + jp.getSignature().getName() + "方法-开始！");
	}

	/**
	 * 
	 * 在方法结束后纪录
	 * 
	 * @param jp
	 */

	@After("com.lzsoft.aml.logs.LogPointcut.inServiceLayer()")
	public void logInfoAfter(JoinPoint jp) {

		String className = jp.getThis().toString();

		String methodName = jp.getSignature().getName(); // 获得方法名

		// System.out.println("=====================================");
		// 数据库更新操作日志
		if (Pattern.matches(
				"(save|saveAll|insert|add|delete|remove|del|update)[\\S]*",
				methodName)) {

			StringBuffer sb = new StringBuffer();
			// 获取请求方法
			Class<?> cls = jp.getTarget().getClass();
			sb.append("<p>").append("位于：" + className).append("</p>");
		//	sb.append("<p>").append("指向" + cls.getName() + "类").append("</p>");
		//	sb.append("<p>").append("调用" + methodName + "方法-开始！")
		//			.append("</p>");
			sb.append("<p>").append("方法名: " + jp.getStaticPart() + "！")
					.append("</p>");
			// System.out.println("=====================================");
			// System.out.println("位于：" + className);
			// System.out.println("指向" + cls.getName() + "类");
			// System.out.println("调用" + methodName + "方法-开始！");
			// System.out.println("方法名: " + jp.getStaticPart() + "！");
			Object[] args = jp.getArgs(); // 获得参数列表
			JSONObject msg = new JSONObject();
			boolean flag = false;
			if (args.length <= 0) {
				// System.out.println("====" + methodName + "方法没有参数");
				sb.append("<p>").append("==" + methodName + "方法没有参数")
						.append("</p>");
			} else {
				for (int i = 0; i < args.length; i++) {
					msg.put("参数  " + (i + 1) + "：", args[i]);
					Class<? extends Object> paramClazz = args[i].getClass();
					String classType = paramClazz.getName();
					if (paramClazz.getName().equals(logs.getClass().getName())
							||paramClazz.getName().equals(UserSession.class.getName())) {//是对logs进行操作时，跳过
						flag = true;
						break;
					}
					if (classType.contains("lzsoft")) {
						msg.put("Class" + (i + 1) + "：", args[i].getClass());
					}

				}
				sb.append("<p>").append(msg).append("</p>");
				// System.out.println(msg);
			}
			if (!flag) {
				try {
					FacesContext fc = FacesContext.getCurrentInstance();
					if (null != fc) {
						HttpSession session = ((HttpServletRequest) fc
								.getExternalContext().getRequest())
								.getSession();

						// System.out.println("save===" + session.getId());
						if (null != session.getAttribute("user")) {
							Object obj = session.getAttribute("user");
							String userid = null;
							String username = null;
							userid = (String) PropertyUtils.getProperty(obj,
									"userid");
							// System.out.println("UserID:" + userid);
							username = (String) PropertyUtils.getProperty(obj,
									"username");
							// System.out.println("UserName:" + username);
							if (null != userid) {
								logs.setEventdate(DateUtil
										.getCurrentDate("yyyyMMdd hh:mm:ss"));
								logs.setEvents(methodName);
								logs.setObjects(sb.toString());
								logs.setUserid(userid);
								logs.setUsername(username);
								//dao.save(logs);
							}
						}
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			}
		} else if (Pattern.matches("(query|load|get|select|read|find)[\\S]*",
				methodName)) {
			// 目前查询操作不记录

		}
		// System.out.println("====" + jp.getSignature().getName() + "方法-结束！");
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	public Logs getLogs() {
		return logs;
	}

	public void setLogs(Logs logs) {
		this.logs = logs;
	}

}
/*
 * 
 * 解释：
 * 
 * @Before 使用Pointcut中的方法签名找到切入点
 * 
 * 记录并打印日志
 */
