package com.lzsoft.aml.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lzsoft.aml.dao.BaseJpaDao;
import com.lzsoft.aml.dao.DAO;
@Transactional
@Service("dao")
public class DaoImpl extends BaseJpaDao implements DAO {
	
	@PersistenceContext(unitName="lzsoft",type=PersistenceContextType.TRANSACTION)
	EntityManager em;
	public DaoImpl() {
		super();
	}

	@Override
	// 得到实体管理器
	public EntityManager getEntityManager() {
//		System.out.println(this.em);
//		 em=EntityManagerHelper.getEntityManager();
		return em;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
