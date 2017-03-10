package com.lzsoft.aml.web.systemmanager;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import com.lzsoft.aml.entity.model.Logs;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.LogsQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemmanager.ILogsService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean
@ViewScoped
public class LogsBean extends BaseBean {
	@ManagedProperty("#{logsQueryBean}")
	private LogsQueryBean querybean;
	@ManagedProperty("#{logsService}")
	private ILogsService logsService;
	private List<Logs> logs;
	public List<Logs> getLogs() {
		synchronized (this) {
			UserInfo user = getUsersInSession();
			if (null == user) {
				addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
				return null;
			}
			if (querybean.isSelected()) {
				try {
					logs = this.logsService.findByQuerybean(querybean);
					querybean.setSelected(false);
				} catch (ManagerException e) {
					e.printStackTrace();
					addWorningMessage("", "查询日志信息失败", false, 2);
				} catch (Exception e) {
					e.printStackTrace();
					addWorningMessage("", "查询日志信息失败" + e.getMessage(),
							false, 3);
				}
			} else if (null == logs||logs.isEmpty()) {
			//	logs = this.logsService.findAll();
			}
		}
		return logs;
	}

	public void onEdit(RowEditEvent event) {
//		FacesMessage msg = new FacesMessage("Car Edited",
//				.getModel());
	}

	public void onCancel(RowEditEvent event) {
//		FacesMessage msg = new FacesMessage("Car Cancelled",
//				((日志entities) event.getObject()).getModel());
//
//		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	public void reset() {
		try {
			reset(querybean);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("", "reseterror", true, 2);
			addWorningMessage("", e.getMessage(), false, 2);
		}
	}

	public LogsQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(LogsQueryBean querybean) {
		this.querybean = querybean;
	}

	public ILogsService getLogsService() {
		return logsService;
	}

	public void setLogsService(ILogsService logsService) {
		this.logsService = logsService;
	}

	public void setLogs(List<Logs> logs) {
		this.logs = logs;
	}


}
