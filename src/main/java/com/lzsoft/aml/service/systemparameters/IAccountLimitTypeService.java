package com.lzsoft.aml.service.systemparameters;

import java.util.List;

import javax.faces.model.SelectItem;

import com.lzsoft.aml.entity.model.AccountLimitType;
import com.lzsoft.aml.exception.ManagerException;

public interface IAccountLimitTypeService {

	List<AccountLimitType> findAll() throws ManagerException;

	void delete(AccountLimitType accountlimittype) throws ManagerException;

	void update(AccountLimitType accountlimittype) throws ManagerException;

	List<SelectItem> findAllSelectItems(String language);

}
