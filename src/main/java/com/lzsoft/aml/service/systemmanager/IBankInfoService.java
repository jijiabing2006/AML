package com.lzsoft.aml.service.systemmanager;


import java.util.List;

import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.querymodel.BankInfoQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface IBankInfoService {
	List<Bankinfo> findAll() throws ManagerException;

	void delete(Bankinfo bank) throws ManagerException;

	void update(Bankinfo bank) throws ManagerException;
	void save(Bankinfo bank) throws ManagerException;
    void saveAll(List<Bankinfo> banks) throws ManagerException;
	List<Bankinfo> findByQuerybean(BankInfoQueryBean querybean) throws ManagerException, Exception;

	Bankinfo find(Class<? extends Bankinfo> bank, int id) throws ManagerException;

	List<Bankinfo> queryByWhere(String bkid) throws ManagerException, Exception;

}
