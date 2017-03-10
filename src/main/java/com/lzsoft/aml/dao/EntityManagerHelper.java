package com.lzsoft.aml.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Level;

public class EntityManagerHelper {

	// 实体化私有静态实体管理器变量emf
	private static final EntityManagerFactory emf;
	// 实体化私有静态本地线程变量threadLocal
	private static final ThreadLocal<EntityManager> threadLocal;

	// 用来给两个变量赋初值的静态块
	static {
		emf = Persistence.createEntityManagerFactory("entityManagerFactory");
		threadLocal = new ThreadLocal<EntityManager>();
	}

	// 得到实体管理器的方法
	public static EntityManager getEntityManager() {
		EntityManager manager = threadLocal.get();
		if (manager == null || !manager.isOpen()) {
			manager = emf.createEntityManager();
			threadLocal.set(manager);
		}
		return manager;
	}

	// 关闭实体管理器的方法
	public static void closeEntityManager() {
		EntityManager em = threadLocal.get();
		threadLocal.set(null);
		if (em != null)
			em.close();
	}

	// 开始事务的方法
	public static void beginTransaction() {
		getEntityManager().getTransaction().begin();
	}

	// 提交事务的方法
	public static void commit() {
		getEntityManager().getTransaction().commit();
	}

	// 回滚事务的方法
	public static void rollback() {
		getEntityManager().getTransaction().rollback();
	}

	// 生成查找的方法
	public static Query createQuery(String query) {
		return getEntityManager().createQuery(query);
	}

	public static void log(String string, Level info, Object object)

	{
		// TODO Auto-generated method stub

	}
}
