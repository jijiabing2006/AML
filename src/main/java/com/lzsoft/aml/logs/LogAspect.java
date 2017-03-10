package com.lzsoft.aml.logs;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
public class LogAspect {

	@Before(value = "execution(public * com.lzsoft.aml.service..*.*(..))")
	public void beforeShow() {

		System.out.println("before show.");

	}

	@After(value = "execution(public * com.lzsoft.aml.service..*.*(..))")
	public void afterShow() {

		System.out.println("after show.");

	}

}

/*
 * 一、最简单的打印一些东西出来
 * 步骤：
 * 1.创建一个Aspect类
 * 
 * 解释：
 * 
 * 在LogAspect的类声明上加上@Aspect注解
 * 
 * 在LogAspect类中的方法上加上@Before注解,
 * 
 * (value = "execution(public * com.lzsoft.aml.service..*.*(..))" )
 * 
 * 上面括号指定了所监视的类中的方法，上面代码中监视了com.lzsoft.aml.service包中的所有类的所有方法
 */