package com.lzsoft.aml.service.systemmanager.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.querymodel.BankInfoQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IBankInfoService;

@ManagedBean(name = "bankService")
@ViewScoped
public class BankInfoService  extends BaseService implements IBankInfoService {

	@Override
	public Bankinfo find(Class<? extends Bankinfo> bank, int id)
			throws ManagerException {
		return dao.find(Bankinfo.class, id);
	}
	@Override
	public List<Bankinfo> findAll() throws ManagerException {
		return dao.queryByWhere(Bankinfo.class, "",
				null);
	}
	@Override
	public void delete(Bankinfo user)
			throws ManagerException {
		dao.delete(Bankinfo.class,
				user.getId());
	}
	@Override
	public void update(Bankinfo user)
			throws ManagerException {
		dao.update(user);
	}
	@Override
	public void save(Bankinfo user)
			throws ManagerException {
		dao.save(user);
	}
	@Override
	public void saveAll(List<Bankinfo> bankinfos)
			throws ManagerException {
		dao.saveAll(bankinfos);
	}
	
	@Override
	public List<Bankinfo> findByQuerybean(BankInfoQueryBean querybean)throws ManagerException,Exception {
		return dao.queryByWhere(Bankinfo.class, generateQuerySql(querybean));
	}
	@Override
	public List<Bankinfo> queryByWhere(String sql) throws ManagerException, Exception {
		return dao.queryByWhere(Bankinfo.class, sql);
	}

}
