package com.lzsoft.aml.dao.base.impl;

/************************* 版权声明 *********************************
 * 
 * 版权所有：百洋软件
 * Copyright (c) 2009 by Pearl Ocean.
 * 
 ************************* 变更记录 *********************************
 *
 * 创建者：yongtree   创建日期： 2009-5-31
 * 创建记录：创建类结构。
 * 
 * 修改者：宋黎晓       修改日期：2010-1-12
 * 修改记录：修改了DAO接口,同时修改了此实现类.
 ************************* 随   笔 *********************************
 *
 * 这里可以写写感想，感慨，疑问什么的。
 * 
 ******************************************************************
 */

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lzsoft.aml.dao.QLBuilder;
import com.lzsoft.aml.dao.QueryResult;
import com.lzsoft.aml.dao.base.IObjectDao;
import com.lzsoft.aml.entity.base.BaseEO;

/**
 * 封装常用增删改查操作
 * 
 * @author yongtree
 * @date 2009-5-31 上午11:09:01
 * @version 2.0
 * @since 2.0 泛型T挪到方法声明出,声明对象时不需要指定泛型.
 */
@Repository ("objectDao")
public abstract class ObjectDaoImpl implements IObjectDao{

	private QLBuilder sqlBuilder = new QLBuilder();
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void clear() {
		getEntityManager().clear();
	}

	@Transactional
	public <T extends BaseEO> void create(T entity) {
		getEntityManager().persist(entity);
	}

	public <T extends BaseEO> void createBatch(List<T> entitys) {
		for (T entity : entitys) {
			create(entity);
		}
	}

	@Transactional
	public <T extends BaseEO> void update(T entity) {
		getEntityManager().merge(entity);
	}

	@Transactional
	public <T extends BaseEO> void saveAll(List<T> entitys) {
		for (int i = 0; i < entitys.size(); i++) {
			T entity = entitys.get(i);
			save(entity);
		}
	}

	@Transactional
	public <T extends BaseEO> void save(T entity) {
		if (entity.getPrimaryKey() == null) {
			this.create(entity);
		} else {
			this.update(entity);
		}
	}

	@Transactional
	public <T extends BaseEO> void delete(Class<T> entityClass, Object entityid) {
		delete(entityClass, new Object[] { entityid });
	}

	@Transactional
	public <T extends BaseEO> void delete(Class<T> entityClass,
			Object[] entityids) {
		// StringBuffer sf_QL = new StringBuffer(" DELETE FROM ").append(
		// sqlBuilder.getEntityName(entityClass)).append(" o WHERE ")
		// .append(sqlBuilder.getPkField(entityClass, "o")).append("=? ");
		// Query query = getEntityManager().createQuery(sf_QL.toString());
		for (Object id : entityids) {
			getEntityManager().remove(getEntityManager().find(entityClass, id));
			// query.setParameter(1, id).executeUpdate();
		}
	}

	@Transactional
	public <T extends BaseEO> void deleteByWhere(Class<T> entityClass,
			String where, Object[] delParams) {
		StringBuffer sf_QL = new StringBuffer("DELETE FROM ").append(
				sqlBuilder.getEntityName(entityClass)).append(" o WHERE 1=1 ");
		if (where != null && where.length() != 0) {
			sf_QL.append(" AND ").append(where);
		}
		Query query = getEntityManager().createQuery(sf_QL.toString());
		this.setQueryParams(query, delParams);

		query.executeUpdate();
	}

	public <T extends BaseEO> T find(Class<T> entityClass, Object entityId) {
		return getEntityManager().find(entityClass, entityId);
	}

	public <T extends BaseEO> long getCount(Class<T> entityClass) {
		return getCountByWhere(entityClass, null, null);
	}

	public <T extends BaseEO> long getCountByWhere(Class<T> entityClass,
			String whereql, Object[] queryParams) {
		StringBuffer sf_QL = new StringBuffer("SELECT COUNT(")
				.append(sqlBuilder.getPkField(entityClass, "o"))
				.append(") FROM ")
				.append(sqlBuilder.getEntityName(entityClass))
				.append(" o WHERE 1=1 ");
		if (whereql != null && whereql.length() != 0) {
			sf_QL.append(" AND ").append(whereql);
		}
		Query query = getEntityManager().createQuery(sf_QL.toString());
		this.setQueryParams(query, queryParams);
		return (Long) query.getSingleResult();
	}

	public <T extends BaseEO> boolean isExistedByWhere(Class<T> entityClass,
			String whereql, Object[] queryParams) {
		long count = getCountByWhere(entityClass, whereql, queryParams);
		return count > 0 ? true : false;
	}

	public <T extends BaseEO> QueryResult<T> getScrollData(
			Class<T> entityClass, int firstindex, int maxresult,
			String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		return scroll(entityClass, firstindex, maxresult, wherejpql,
				queryParams, orderby);
	}

	public <T extends BaseEO> QueryResult<T> getScrollData(
			Class<T> entityClass, int firstindex, int maxresult,
			String wherejpql, List<Object> queryParams,
			LinkedHashMap<String, String> orderby) {
		Object[] ps = null;
		if (queryParams != null) {
			ps = queryParams.toArray();
		}
		return getScrollData(entityClass, firstindex, maxresult, wherejpql, ps,
				orderby);
	}

	@Override
	public <T extends BaseEO> QueryResult<T> getScrollData(
			Class<T> entityClass, int firstindex, int maxresult,
			String wherejpql, Map<String, Object> queryParams,
			LinkedHashMap<String, String> orderby) {
		return scroll(entityClass, firstindex, maxresult, wherejpql,
				queryParams, orderby);
	}

	/**
	 * 根据条件查询某个实体的列表
	 * 
	 * @author slx
	 * @param <T>
	 * @param entityClass
	 *            实体类型
	 * @param firstindex
	 *            开始行
	 * @param maxresult
	 *            结束行
	 * @param wherejpql
	 *            where条件
	 * @param queryParams
	 *            参数
	 * @param orderby
	 *            排序条件
	 * @return
	 */
	private <T extends BaseEO> QueryResult<T> scroll(Class<T> entityClass,
			int firstindex, int maxresult, String wherejpql,
			Object queryParams, LinkedHashMap<String, String> orderby) {
		QueryResult<T> qr = new QueryResult<T>();
		String entityname = sqlBuilder.getEntityName(entityClass);
		Query query = getEntityManager()
				.createQuery(
						"SELECT o FROM "
								+ entityname
								+ " o "
								+ (StringUtils.isEmpty(wherejpql) ? ""
										: "WHERE " + wherejpql)
								+ sqlBuilder.buildOrderby(orderby));
		setQueryParams(query, queryParams);
		if (firstindex != -1 && maxresult != -1)
			query.setFirstResult(firstindex).setMaxResults(maxresult)
					.setHint("org.hibernate.cacheable", true);
		qr.setResultlist(query.getResultList());
		query = getEntityManager().createQuery(
				"SELECT COUNT("
						+ sqlBuilder.getPkField(entityClass, "o")
						+ ") FROM "
						+ entityname
						+ " o "
						+ (StringUtils.isEmpty(wherejpql) ? "" : "WHERE "
								+ wherejpql));
		setQueryParams(query, queryParams);
		qr.setTotalrecord((Long) query.getSingleResult());
		return qr;
	}

	/**
	 * 根据条件查询实体指定字段的值并回填到实体内. <br/>
	 * <b>注意:</b> <br/>
	 * 实体必须有包括要查询的字段为参数的构造函数.
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param queryfields
	 * @param firstindex
	 * @param maxresult
	 * @param wherejpql
	 * @param queryParams
	 * @param orderby
	 * @return
	 */
	private <T extends BaseEO> QueryResult<T> scroll(Class<T> entityClass,
			String[] queryfields, int firstindex, int maxresult,
			String wherejpql, Object queryParams,
			LinkedHashMap<String, String> orderby) {
		QueryResult<T> qr = new QueryResult<T>();
		String entityname = sqlBuilder.getEntityName(entityClass);
		Query query = getEntityManager()
				.createQuery(
						(sqlBuilder.buildSelect(entityname, queryfields, "o")
								+ "FROM "
								+ entityname
								+ " o "
								+ (StringUtils.isEmpty(wherejpql) ? ""
										: "WHERE " + wherejpql) + sqlBuilder
								.buildOrderby(orderby)));
		setQueryParams(query, queryParams);
		if (firstindex != -1 && maxresult != -1)
			query.setFirstResult(firstindex).setMaxResults(maxresult)
					.setHint("org.hibernate.cacheable", true);
		qr.setResultlist(query.getResultList());
		query = getEntityManager().createQuery(
				"SELECT COUNT("
						+ sqlBuilder.getPkField(entityClass, "o")
						+ ") FROM "
						+ entityname
						+ " o "
						+ (StringUtils.isEmpty(wherejpql) ? "" : "WHERE "
								+ wherejpql));
		setQueryParams(query, queryParams);
		qr.setTotalrecord((Long) query.getSingleResult());
		return qr;
	}

	@Override
	public <T extends BaseEO> QueryResult<T> getScrollData(
			Class<T> entityClass, String[] queryfields, int firstindex,
			int maxresult, String wherejpql, List<Object> queryParams,
			LinkedHashMap<String, String> orderby) {
		return this.scroll(entityClass, queryfields, firstindex, maxresult,
				wherejpql, queryParams, orderby);
	}

	@Override
	public <T extends BaseEO> QueryResult<T> getScrollData(
			Class<T> entityClass, String[] queryfields, int firstindex,
			int maxresult, String wherejpql, Map<String, Object> queryParams,
			LinkedHashMap<String, String> orderby) {
		return this.scroll(entityClass, queryfields, firstindex, maxresult,
				wherejpql, queryParams, orderby);
	}

	@Override
	public <T extends BaseEO> QueryResult<T> getScrollData(
			Class<T> entityClass, String[] queryfields, int firstindex,
			int maxresult, String wherejpql, Object[] queryParams,
			LinkedHashMap<String, String> orderby) {
		return this.scroll(entityClass, queryfields, firstindex, maxresult,
				wherejpql, queryParams, orderby);
	}

	protected void setQueryParams(Query query, Object queryParams) {
		sqlBuilder.setQueryParams(query, queryParams);
	}

	public <T extends BaseEO> List<T> queryByWhere(Class<T> entityClass,
			String wheresql, Object[] queryParams) {
		String entityname = sqlBuilder.getEntityName(entityClass);
		Query query = getEntityManager().createQuery(
				"SELECT o FROM "
						+ entityname
						+ " o "
						+ ((wheresql == null || wheresql.length() == 0) ? ""
								: "WHERE " + wheresql));
		setQueryParams(query, queryParams);
		query.setHint("org.hibernate.cacheable", true);
		return query.getResultList();
	}

	public <T extends BaseEO> List<T> queryByWhere(Class<T> entityClass,
			String wheresql, Object[] queryParams, int startRow, int rows) {
		String entityname = sqlBuilder.getEntityName(entityClass);
		Query query = getEntityManager().createQuery(
				"SELECT o FROM "
						+ entityname
						+ " o "
						+ ((wheresql == null || wheresql.length() == 0) ? ""
								: "WHERE " + wheresql));
		setQueryParams(query, queryParams);
		if (startRow >= 0) {
			query.setFirstResult(startRow);
		}
		if (rows > 0) {
			query.setMaxResults(rows);
		}
		query.setHint("org.hibernate.cacheable", true);
		return query.getResultList();
	}

	@Override
	public <T extends BaseEO> List<T> queryByWhere(Class<T> entityClass,
			String[] queryfields, String wheresql, Object[] queryParams) {
		return queryByWhere(entityClass, queryfields, wheresql, queryParams,
				-1, -1);
	}

	@Override
	public <T extends BaseEO> List<T> queryByWhere(Class<T> entityClass,
			String[] queryfields, String wheresql, Object[] queryParams,
			int startRow, int rows) {
		String entityname = sqlBuilder.getEntityName(entityClass);
		Query query = getEntityManager().createQuery(
				sqlBuilder.buildSelect(entityname, queryfields, "o") + " FROM "
						+ entityname + " o "
						+ (wheresql == null ? "" : "WHERE " + wheresql));
		setQueryParams(query, queryParams);
		if (startRow >= 0) {
			query.setFirstResult(startRow);
		}
		if (rows > 0) {
			query.setMaxResults(rows);
		}
		return query.getResultList();
	}

	public <T extends BaseEO> List<Object[]> queryFieldValues(
			Class<T> entityClass, String[] queryfields, String wheresql,
			Object[] queryParams) {
		return queryFieldValues(entityClass, queryfields, wheresql,
				queryParams, -1, -1);
	}

	@Override
	public <T extends BaseEO> List<Object[]> queryFieldValues(
			Class<T> entityClass, String[] queryfields, String wheresql,
			Object[] queryParams, int startRow, int rows) {
		String entityname = sqlBuilder.getEntityName(entityClass);
		Query query = getEntityManager().createQuery(
				sqlBuilder.buildSelect(queryfields, "o") + " FROM "
						+ entityname + " o "
						+ (wheresql == null ? "" : "WHERE " + wheresql));
		setQueryParams(query, queryParams);
		if (startRow >= 0) {
			query.setFirstResult(startRow);
		}
		if (rows > 0) {
			query.setMaxResults(rows);
		}
		return query.getResultList();
	}

	/**
	 * 设置查询参数
	 * 
	 * @author slx
	 * @date 2009-7-8 上午10:02:55
	 * @modifyNote
	 * @param query
	 *            查询
	 * @param queryParams
	 *            查询参数
	 */
	protected void setQueryParams(Query query, Object[] queryParams) {
		sqlBuilder.setQueryParams(query, queryParams);
	}

	@Override
	public <T extends BaseEO> T load(Class<T> entityClass, Object entityId) {
		try {
			return getEntityManager().getReference(entityClass, entityId);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public <T extends BaseEO> T findByWhere(Class<T> entityClass, String where,
			Object[] params) {
		List<T> l = queryByWhere(entityClass, where, params);
		if (l != null && l.size() == 1) {
			return l.get(0);
		} else if (l.size() > 1) {
			throw new RuntimeException("查寻到的结果不止一个.");
		} else {
			return null;
		}
	}

}
