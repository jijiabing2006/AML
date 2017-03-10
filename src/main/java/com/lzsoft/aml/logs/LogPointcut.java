package com.lzsoft.aml.logs;

import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
@Aspect
public class LogPointcut {

	@Pointcut("execution(public * com.lzsoft.aml.dao..*.*(..)))")
	public void inServiceLayer() {
	}

}

/*
 * 二、将Pointcut和Advice分开，并将方法名和参数打印出来
 * 
 * 步骤：
 * 
 * 1.创建Pointcut 2.创建Advice
 * 
 * 解释：
 * 
 * 加上@Aspect注解
 * 
 * @Pointcut是切入点，指定需要注入代码的位置，如上面代码中指定在com.demo.service包下的所有类的所有方法中
 * 
 * 下面只需要定义一个方法签名
 */