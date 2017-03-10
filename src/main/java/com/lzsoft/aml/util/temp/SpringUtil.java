package com.lzsoft.aml.util.temp;



public class SpringUtil {
	public SpringUtil() {
	}

	
	public static Object getBean(String beanId) throws Exception {
		
//		String[] names=SingletonApplicationContext.getInstance()
//		.getApplicationContext().getBeanDefinitionNames();
//		String name=SingletonApplicationContext.getInstance()
//		.getApplicationContext().getBean("accntab").getClass().getName();
//		System.out.println(name);
		
		
		return SingletonApplicationContext.getInstance()
		.getApplicationContext().getBean(beanId);

	}
}
