package com.lzsoft.aml.service.systemmanager;


import java.util.List;

import com.lzsoft.aml.entity.model.Logs;
import com.lzsoft.aml.entity.model.querymodel.LogsQueryBean;
import com.lzsoft.aml.exception.ManagerException;

public interface ILogsService {
	List<Logs> findAll() throws ManagerException;

	List<Logs> findByQuerybean(LogsQueryBean querybean) throws ManagerException, Exception;

}
