package com.lzsoft.aml.service.aml.impl;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.beanutils.PropertyUtils;

import com.lzsoft.aml.entity.base.BaseEO;
import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.querymodel.AmlQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.aml.IAmlService;

@ManagedBean(name = "amlService")
@ViewScoped
public class AmlService extends BaseService implements IAmlService {

	@Override
	@SuppressWarnings({ "unchecked"})
	public <T extends BaseEO> List<T> findAll(T entity) throws ManagerException {

		return (List<T>) dao.queryByWhere(entity.getClass(), "", null);
	}

	@Override
	public <T extends BaseEO> void delete(T entity) throws ManagerException,
			Exception {
		dao.delete(entity.getClass(), PropertyUtils.getProperty(entity, "id"));
	}

	@Override
	public <T extends BaseEO> void update(T entity) throws ManagerException {
		dao.update(entity);
	}

	@Override
	public <T extends BaseEO> void save(T entity) throws ManagerException {
		dao.save(entity);
	}

	@Override
	public <T extends BaseEO> void saveAll(List<T> entitys)
			throws ManagerException {
		dao.saveAll(entitys);
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public <T extends BaseEO> List<T> queryByQuerybean(T entity,
			AmlQueryBean querybean,String bkid,String subbkid) throws ManagerException, Exception {
		String sql=generateQuerySql(querybean);
		sql=sql.length()<3?"bkid=? and subbkid=? order by crcd,csnm,crtp,tsdr":sql+" and bkid=? and subbkid=? order by crcd,csnm,crtp,tsdr";
		return (List<T>) dao.queryByWhere(entity.getClass(),sql,new Object[]{bkid,subbkid});
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T extends BaseEO> List<T> queryVerifiedByDate(String key,
			Date date) throws ManagerException {
		if("bigamount".equals(key)){
			return (List<T>) dao.queryByWhere(AmlBigAmount.class,
					"isexport=? and isinpboc=?  and isedit=? and isvalidation=?", new Object[] { "0", "0","1","1" });
		}else if("suspicious".equals(key)){
			return (List<T>) dao.queryByWhere(null,
					"isexport=? and isinpboc=?  and isedit=? and isvalidation=?", new Object[] { "0", "0","1","1" });
		}
			
		return null;
	}

	@Override
	@SuppressWarnings({ "unchecked"  })
	public <T extends BaseEO> T find(T entity) throws ManagerException,
			Exception {
		return (T) dao
				.find(entity.getClass(), PropertyUtils.getProperty(entity, "id"));
	}

	@Override
	public <T extends BaseEO> Date getMaxImportDate(T entity)
			throws ManagerException {
		return (Date) dao.getMaxByWhere(entity.getClass(), "importdate", "",
				null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends BaseEO> List<T> queryNonExport(T entity,String bkid,String subbkid)
			throws ManagerException {
		return (List<T>) dao.queryByWhere(entity.getClass(),
				"(isexport=? ) and bkid=? and subbkid=? order by crcd,csnm,crtp,tsdr", new Object[] { "0", bkid,subbkid });
	}

}
