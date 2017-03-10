package com.lzsoft.aml.dao.base.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.lzsoft.aml.dao.base.IDaoSupport;
import com.lzsoft.aml.exception.ConvertCharsetException;
import com.lzsoft.aml.exception.DaoException;
import com.lzsoft.aml.util.BeanConverUtil;

public class DaoSupport<T, PK extends Serializable> extends HibernateDaoSupport
		implements IDaoSupport<T, PK> {

	private Logger log = Logger.getLogger(this.getClass());

	/**
	 * pojo
	 */
	private Class<T> type;

	/**
	 * 利用spring构造注入 注入需要的pojo
	 * 
	 * @param type
	 */
	public DaoSupport(Class<T> type) {
		this.type = type;
	}

	/**
	 * 删除
	 */
	public synchronized boolean delete(T entity) throws DaoException {
		boolean result = false;
		try {
			getHibernateTemplate().delete(entity);
			result = true;
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		log.info(entity.getClass().getName() + "已被删除");
		return result;
	}

	/**
	 * 批量删除
	 */
	public synchronized boolean deleteAll(Collection<T> entities)
			throws DaoException {
		boolean result = false;
		try {
			getHibernateTemplate().deleteAll(entities);
			result = true;
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		log.info(entities.getClass().getName() + "已被删除");
		return result;
	}

	/**
	 * 根据hql语句查询,不带参数
	 */
	@SuppressWarnings("unchecked")
	public List find(String query) throws DaoException {
		log.info("hql查询语句为" + query);
		List list = null;
		try {
			list = getHibernateTemplate().find(query);
			if (null != list && list.size() != 0) {
				for (Object obj : list) {
					try {
						if (null == obj)
							continue;
						BeanConverUtil beanConvertUtil = new BeanConverUtil();
						beanConvertUtil.converObject(obj, false);
					} catch (ConfigurationException e) {
						e.printStackTrace();
						throw new ConvertCharsetException(e.getCause());
					}
				}
			}
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (!list.isEmpty())
			log.info("加载了所需的集合");
		return list;

	}

	/**
	 * 根据hql语句查询,带一个?参数
	 */
	@SuppressWarnings("unchecked")
	public List find(String query, Object parameter) throws DaoException {
		log.info("hql查询语句为" + query);
		List list = null;
		try {
			list = getHibernateTemplate().find(query, parameter);
			for (Object obj : list) {
				try {
					BeanConverUtil beanConvertUtil = new BeanConverUtil();
					beanConvertUtil.converObject(obj, false);
				} catch (ConfigurationException e) {
					e.printStackTrace();
					throw new ConvertCharsetException(e.getCause());
				}
			}
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (!list.isEmpty())
			log.info("加载了所需的集合");
		return list;
	}

	/**
	 * 根据hql语句查询,带多个?参数
	 */
	@SuppressWarnings("unchecked")
	public List find(String query, Object[] args) throws DaoException {
		log.info("hql查询语句为" + query);
		List list = null;
		try {
			list = getHibernateTemplate().find(query, args);
			if (null != list && list.size() > 0) {
				for (Object obj : list) {
					if (obj != null) {
						try {
							BeanConverUtil beanConvertUtil = new BeanConverUtil();
							beanConvertUtil.converObject(obj, false);
						} catch (ConfigurationException e) {
							e.printStackTrace();
							throw new ConvertCharsetException(e.getCause());
						}
					}
				}
			}
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (!list.isEmpty())
			log.info("加载了所需的集合");
		return list;
	}

	/**
	 * 查询所有
	 */
	@SuppressWarnings("unchecked")
	public List findAll() throws DaoException {
		List list = null;
		try {
			list = getHibernateTemplate().find(
					"from " + type.getName() + " order by id");
			for (Object obj : list) {
				try {
					BeanConverUtil beanConvertUtil = new BeanConverUtil();
					beanConvertUtil.converObject(obj, false);
				} catch (ConfigurationException e) {
					e.printStackTrace();
					throw new ConvertCharsetException(e.getCause());
				}
			}
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (!list.isEmpty())
			log.info("加载了所有" + type.getName());
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List findAllByOrderBy(String orderbyCol) throws DaoException{

		List list = null;
		try {
			list = getHibernateTemplate().find(
					"from " + type.getName() + " order by "+orderbyCol);
			for (Object obj : list) {
				try {
					BeanConverUtil beanConvertUtil = new BeanConverUtil();
					beanConvertUtil.converObject(obj, false);
				} catch (ConfigurationException e) {
					e.printStackTrace();
					throw new ConvertCharsetException(e.getCause());
				}
			}
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (!list.isEmpty())
			log.info("加载了所有" + type.getName()+",并按"+orderbyCol+"排序.");
		return list;
	
	}

	/**
	 * 根据DetachedCriteria组合的条件进行查询
	 */
	@SuppressWarnings("unchecked")
	public List findByCriteria(final DetachedCriteria detachedCriteria)
			throws DaoException {
//		getHibernateTemplate().setCacheQueries(true);
		List list = null;
//		try {
//			list = (List) getHibernateTemplate().execute(
//					new HibernateCallback() {
//						public Object doInHibernate(Session session)
//								throws HibernateException {
//							Criteria criteria = detachedCriteria
//									.getExecutableCriteria(session);
//
//							return criteria.list();
//						}
//					}, true);
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//			throw new DaoException(e.getCause());
//		}
//
//		for (Object obj : list) {
//			try {
//				BeanConverUtil beanConvertUtil = new BeanConverUtil();
//				beanConvertUtil.converObject(obj, false);
//			} catch (ConfigurationException e) {
//				e.printStackTrace();
//				throw new ConvertCharsetException(e.getCause());
//			}
//		}

		return list;
	}

	/**
	 * 根据DetachedCriteria组合的条件和需要分页的行数进行查询
	 * 
	 * @param detachedCriteria
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List findByCriteria(final DetachedCriteria detachedCriteria,
			final int startRow, final int pageSize) throws DaoException {
//		getHibernateTemplate().setCacheQueries(true);
		List list = null;
//		try {
//			list = (List) getHibernateTemplate().execute(
//					new HibernateCallback() {
//						public Object doInHibernate(Session session)
//								throws HibernateException {
//							Criteria criteria = detachedCriteria
//									.getExecutableCriteria(session);
//							criteria.setFirstResult(startRow);
//							criteria.setMaxResults(pageSize);
//							return criteria.list();
//						}
//					}, true);
//		} catch (DataAccessException e) {
//			throw new DaoException(e.getCause());
//		}
//
//		for (Object obj : list) {
//			try {
//				BeanConverUtil beanConvertUtil = new BeanConverUtil();
//				beanConvertUtil.converObject(obj, false);
//			} catch (ConfigurationException e) {
//				e.printStackTrace();
//				throw new ConvertCharsetException(e.getCause());
//			}
//		}

		return list;
	}

	/**
	 * 根据DetachedCriteria得到查询的结果总条数
	 * 
	 * @param detachedCriteria
	 * @return 查询的结果总条数
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public int findCountByCriteria(final DetachedCriteria detachedCriteria)
			throws DaoException {
//		getHibernateTemplate().setCacheQueries(true);
		List list = null;
//		try {
//			list = (List) getHibernateTemplate().execute(
//					new HibernateCallback() {
//						public Object doInHibernate(Session session)
//								throws HibernateException {
//							Criteria criteria = detachedCriteria
//									.getExecutableCriteria(session);
//							return criteria.list();
//						}
//					}, true);
//		} catch (DataAccessException e) {
//			e.printStackTrace();
//			throw new DaoException(e.getCause());
//		}
//		if (null == list || list.isEmpty())
//			return 0;
		return list.size();
	}

	/**
	 * 根据id取得一个实例
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) throws DaoException {
		T t = null;
		try {
			t = (T) getHibernateTemplate().get(type, id);
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (t != null)
			log.info("根据" + id + "加载了一个" + type.getName());
		return t;
	}

	@SuppressWarnings("unchecked")
	public synchronized boolean save(T entity) throws DaoException {
		boolean result = false;
		try {
			BeanConverUtil beanConvertUtil = new BeanConverUtil();
			entity = (T) beanConvertUtil.converObject(entity, true);
			getHibernateTemplate().save(entity);
			result = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e.getCause());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new ConvertCharsetException(e.getCause());
		}
		log.info(entity.getClass().getName() + "已被保存");
		return result;
	}

	@SuppressWarnings("unchecked")
	public synchronized boolean save(List<T> entityList) throws DaoException {
		boolean result = false;
		String entityName = "";
		try {
			if (null == entityList || entityList.isEmpty())
				return true;
			// BeanConverUtil beanConvertUtil = new BeanConverUtil();
			for (T entity : entityList) {
				entityName = entity.getClass().getName();
				// entity = (T) beanConvertUtil.converObject(entity, true);
				save(entity);
			}
			// getHibernateTemplate().saveOrUpdateAll(entityList);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException(e.getCause());
		}
		log.info(entityName + " 已被保存.共" + entityList.size() + "条");
		return result;
	}

	/**
	 * 保存或修改
	 */
	@SuppressWarnings("unchecked")
	public synchronized void saveOrUpdate(T entity) throws DaoException {
		try {
			BeanConverUtil beanConvertUtil = new BeanConverUtil();
			entity = (T) beanConvertUtil.converObject(entity, true);
			getHibernateTemplate().saveOrUpdate(entity);
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new ConvertCharsetException(e.getCause());
		}
		log.info(entity.getClass().getName() + "已被保存或修改");

	}

	/**
	 * 修改
	 */
	@SuppressWarnings("unchecked")
	public synchronized boolean update(T entity) throws DaoException {
		boolean result = false;
		try {
			BeanConverUtil beanConvertUtil = new BeanConverUtil();
			entity = (T) beanConvertUtil.converObject(entity, true);
			getHibernateTemplate().update(entity);
			result = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new DaoException(e.getCause());
		} catch (ConfigurationException e) {
			e.printStackTrace();
			throw new ConvertCharsetException(e.getCause());
		}
		log.info(entity.getClass().getName() + "已被修改");
		return result;
	}

	@SuppressWarnings("unchecked")
	public synchronized boolean saveOrUpdateAll(Collection<T> entitys)
			throws DaoException {
		boolean flag = false;
		try {
			/*for (Iterator iterator = entitys.iterator(); iterator.hasNext(); save((T) iterator
					.next()))
				;*/
			getHibernateTemplate().saveOrUpdateAll(entitys);
			flag = true;
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		return flag;
	}

	@SuppressWarnings("unchecked")
	public List find(final String query, final int count) throws DaoException {

		List list = getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				return session.createQuery(query).setMaxResults(count).list();

			}

		});

		return list;

	}

	public boolean delete(final String hql, final Object[] args)
			throws DaoException {
		try {
			getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Transaction tran = session.getTransaction();
					tran.begin();
					Query query = session.createQuery(hql);
					for (int i = 0; i < args.length; i++) {
						query.setParameter(i, args[i]);
					}
					query.executeUpdate();
					tran.commit();
					return null;
				}
			});
			return true;
		} catch (DataAccessException e) {
			throw new DaoException(e.getMessage());
		}
	}

	public boolean update(final String hql, final Object[] args)
			throws DaoException {
		try {
			getHibernateTemplate().execute(new HibernateCallback() {
				public Object doInHibernate(Session session)
						throws HibernateException, SQLException {
					Transaction tran = session.getTransaction();
					tran.begin();
					Query query = session.createQuery(hql);
					for (int i = 0; i < args.length; i++) {
						query.setParameter(i, args[i]);
					}
					query.executeUpdate();
					tran.commit();
					return null;
				}
			});
			return true;
		} catch (DataAccessException e) {
			throw new DaoException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public boolean updateAll(Collection<T> entitys) throws DaoException {
		boolean flag = false;
		try {
			for (Iterator iterator = entitys.iterator(); iterator.hasNext(); update((T) iterator
					.next()))
				;
			flag = true;
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		return flag;
	}
	
	
	/**
	 * 根据SQL和参数和需要分页的行数进行查询
	 * 
	 * @param detachedCriteria
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List findByHQL(final String hql,
			final int startRow, final int pageSize) throws DaoException {
//		getHibernateTemplate().setCacheQueries(true);
		List list = null;
		try {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			Query q = session.createQuery(hql);
			q.setFirstResult(startRow);
			q.setMaxResults(pageSize);
			list= q.list();
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}

		for (Object obj : list) {
			try {
				BeanConverUtil beanConvertUtil = new BeanConverUtil();
				beanConvertUtil.converObject(obj, false);
			} catch (ConfigurationException e) {
				e.printStackTrace();
				throw new ConvertCharsetException(e.getCause());
			}
		}

		return list;
	}

	/**
	 * 根据HQL得到查询的结果总条数
	 * 
	 * @param detachedCriteria
	 * @return 查询的结果总条数
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public int findCountByHQL(final String hql)
			throws DaoException {
//		getHibernateTemplate().setCacheQueries(true);
		List list = null;
		try {
			Session session=getHibernateTemplate().getSessionFactory().openSession();
			Query q = session.createQuery(hql);
			list= q.list();
		} catch (DataAccessException e) {
			throw new DaoException(e.getCause());
		}
		if (null == list || list.isEmpty())
			return 0;
		return list.size();
	}
	
	/**
	 * 根据传入的HQL执行操作
	 * @param query
	 * @return
	 */
	public boolean executeQuery(final String query,final Object[] params) {
		int rs=0;
		rs = (Integer)getHibernateTemplate().execute(new HibernateCallback(){

			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query queryHQL = session.createQuery(query);
				
				for (int i = 0; i < params.length; i++) {
					queryHQL.setParameter(i, params[i]);
				}
				return queryHQL.executeUpdate();
			}
			
		});
		
		if(rs>0){
			return true;
		}else{
			return false;
		}
		
	}
	
	
}
