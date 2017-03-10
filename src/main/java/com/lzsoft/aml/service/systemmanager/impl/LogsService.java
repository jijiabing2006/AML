package com.lzsoft.aml.service.systemmanager.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.entity.model.Logs;
import com.lzsoft.aml.entity.model.querymodel.LogsQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.ILogsService;

@ManagedBean
@ViewScoped
public class LogsService extends BaseService implements
		ILogsService {

	@Override
	public List<Logs> findAll() throws ManagerException {
		return dao.queryByWhere(Logs.class, "",
				null);
	}

	@Override
	public List<Logs> findByQuerybean(LogsQueryBean querybean)
			throws ManagerException, Exception {
		return dao.queryByWhere(Logs.class, generateQuerySql(querybean));
	}

}
