package com.lzsoft.aml.util.temp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SingletonApplicationContext {

	private static SingletonApplicationContext instance = null;
	private static ApplicationContext applicationContext;

	protected static final String[] getConfigLocations() {
		 String path[] = {"classpath:config/applicationContext-dao-commons.xml","classpath:config/applicationContext.xml", };
		return path;
	}

	@SuppressWarnings("unchecked")
	private static final ThreadLocal threadCtx = new ThreadLocal();	
	
	private SingletonApplicationContext() {

		applicationContext = (ApplicationContext) threadCtx
				.get();
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext(
					getConfigLocations());
			threadCtx.set(applicationContext);
		}

	}

	public static SingletonApplicationContext getInstance() {
		if (instance == null) {
			instance = new SingletonApplicationContext();
		}
		return instance;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
}
