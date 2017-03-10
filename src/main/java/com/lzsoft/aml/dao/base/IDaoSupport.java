package com.lzsoft.aml.dao.base;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.lzsoft.aml.exception.DaoException;

public interface IDaoSupport<T, PK extends Serializable> {
	/**
	 * 保存实例
	 * 
	 * @param 实例
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public boolean save(final T entity) throws DaoException;

	/**
	 * 批量保存实例
	 * 
	 * @param 批量实例
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public boolean save(final List<T> entityList) throws DaoException;

	/**
	 * 修改实例
	 * 
	 * @param 实例
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public boolean update(final T entity) throws DaoException;

	/**
	 * 保存或修改实例
	 * 
	 * @param 实例
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public void saveOrUpdate(final T entity) throws DaoException;

	/**
	 * 删除实例
	 * 
	 * @param 实例
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public boolean delete(final T entity) throws DaoException;

	/**
	 * 批量删除实例
	 * 
	 * @param 实例
	 * @throws DaoException
	 */
	public boolean deleteAll(final Collection<T> entities) throws DaoException;

	/**
	 * 根据主键加载一个实例
	 * 
	 * @param 实例
	 * @param 主键
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) throws DaoException;

	/**
	 * 查找所有实例
	 * 
	 * @param 实例
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List findAll() throws DaoException;

	/**
	 * 根据hql语句查找实例(不带?参数)
	 * 
	 * @param hql语句
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List find(final String query) throws DaoException;

	/**
	 * 根据hql语句查找实例(带一个?参数)
	 * 
	 * @param hql语句
	 * @param 参数
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List find(final String query, final Object parameter)
			throws DaoException;

	/**
	 * 根据hql语句查找实例(带多个?参数)
	 * 
	 * @param hql语句
	 * @param 参数列表
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List find(final String query, final Object[] args)
			throws DaoException;

	/**
	 * 传递DetachedCriteria查询
	 * 
	 * @param detachedCriteria
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List findByCriteria(final DetachedCriteria detachedCriteria)
			throws DaoException;

	/**
	 * 根据DetachedCriteria和分页的参数进行查询
	 * 
	 * @param detachedCriteria
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List findByCriteria(final DetachedCriteria detachedCriteria,
			final int startRow, final int pageSize) throws DaoException;

	/**
	 * 根据DetachedCriteria得到查询的总条数
	 * 
	 * @param detachedCriteria
	 * @return
	 * @throws DaoException
	 */
	public int findCountByCriteria(final DetachedCriteria detachedCriteria)
			throws DaoException;

	/**
	 * 批量增加或修改
	 * 
	 * @param entitys
	 * @return
	 * @throws DaoException
	 */
	public boolean saveOrUpdateAll(Collection<T> entitys) throws DaoException;

	/**
	 * 查询count条数据
	 * 
	 * @param query
	 *            hql语句
	 * @param args
	 *            hql语句?的值集合
	 * @param count
	 *            需要返回的结果集的数量
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List find(final String query, final int count) throws DaoException;

	/**
	 * 根据hql语句删除数据
	 * 
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	public boolean delete(String hql, Object[] args) throws DaoException;

	/**
	 * 根据hql语句修改数据
	 * 
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	public boolean update(String hql, Object[] args) throws DaoException;

	/**
	 * 批量修改
	 * 
	 * @param entitys
	 * @return
	 * @throws DaoException
	 */
	public boolean updateAll(Collection<T> entitys) throws DaoException;


	/**
	 * 根据HQL语句进行分页查询
	 * 
	 * @param hql
	 * @param startRow
	 * @param pageSize
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unchecked")
	public List findByHQL(final String hql, final int startRow,
			final int pageSize) throws DaoException;

	/**
	 * 根据HQL语句得到总记录数
	 * 
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	public int findCountByHQL(final String hql) throws DaoException;
	
	/**
	 * 根据传入的HQL执行操作
	 * @param query
	 * @return
	 */
	public boolean executeQuery(String query,Object[] params);

}
