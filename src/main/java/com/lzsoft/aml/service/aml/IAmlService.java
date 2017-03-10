package com.lzsoft.aml.service.aml;

import java.util.Date;
import java.util.List;

import com.lzsoft.aml.entity.base.BaseEO;
import com.lzsoft.aml.entity.model.querymodel.AmlQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface IAmlService{

	public <T extends BaseEO>List<T> findAll(T entity) throws ManagerException;

	public <T extends BaseEO>  void delete(T entity) throws ManagerException,Exception;

	public <T extends BaseEO> void update(T entity) throws ManagerException;

	public <T extends BaseEO> void save(T entity) throws ManagerException;

	public <T extends BaseEO> void saveAll(List<T> entitys) throws ManagerException;

	public <T extends BaseEO> List<T> queryByQuerybean(T entity,AmlQueryBean querybean,String bkid,String subbkid)
			throws ManagerException, Exception;

	public <T extends BaseEO> T find(T entity)throws ManagerException, Exception;

	public <T extends BaseEO> Date getMaxImportDate(T entity) throws ManagerException;

	public <T extends BaseEO> List<T> queryNonExport(T entity,String bkid,String subbkid) throws ManagerException;
	public <T extends BaseEO> List<T> queryVerifiedByDate(String key,Date date) throws ManagerException;

}
