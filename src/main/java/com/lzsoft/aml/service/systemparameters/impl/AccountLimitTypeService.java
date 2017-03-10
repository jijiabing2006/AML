package com.lzsoft.aml.service.systemparameters.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.lzsoft.aml.dao.DAO;
import com.lzsoft.aml.entity.model.AccountLimitType;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemparameters.IAccountLimitTypeService;

@ManagedBean(name = "accountLimitTypeService")
@ViewScoped
public class AccountLimitTypeService implements IAccountLimitTypeService{
	@ManagedProperty("#{dao}")
	private DAO accountLimitTypeDao;

	public DAO getAccountLimitTypeDao() {
		return accountLimitTypeDao;
	}

	public void setAccountLimitTypeDao(DAO accountLimitTypeDao) {
		this.accountLimitTypeDao = accountLimitTypeDao;
	}
	@Override
	public List<AccountLimitType> findAll() throws ManagerException {

		return accountLimitTypeDao.queryByWhere(AccountLimitType.class, "",
				null);
	}
	@Override
	public void delete(AccountLimitType accountlimittype)
			throws ManagerException {
		accountLimitTypeDao.delete(AccountLimitType.class,
				accountlimittype.getId());
	}
	@Override
	public void update(AccountLimitType accountlimittype)
			throws ManagerException {
		accountLimitTypeDao.update(accountlimittype);
	}

	@Override
	public List<SelectItem> findAllSelectItems(String language) {
		List<AccountLimitType> list = findAll();
		if (null == list || list.isEmpty())
			return null;
		List<SelectItem> resultList = new ArrayList<SelectItem>();
		for (AccountLimitType accountlimittype : list) {
			if ("zh".equalsIgnoreCase(language) || "zh_CN".equalsIgnoreCase(language)||language.toUpperCase().indexOf("ZH")>=0)
				resultList.add(new SelectItem(accountlimittype.getTypecode(), accountlimittype.getTypecode() + "-"
						+ accountlimittype.getTypenamecn()));
			else {
				if (null != accountlimittype.getTypenameen() && !"".equalsIgnoreCase(accountlimittype.getTypenameen()))
					resultList.add(new SelectItem(accountlimittype.getTypecode(), accountlimittype.getTypecode() + "-"
							+ accountlimittype.getTypenameen()));
				else
					resultList.add(new SelectItem(accountlimittype.getTypecode(), accountlimittype.getTypecode() + "-"
							+ accountlimittype.getTypenamecn()));
			}
		}
		return resultList;
	}
}
