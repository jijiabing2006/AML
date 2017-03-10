package com.lzsoft.aml.web.permissionoperation;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.richfaces.component.UIExtendedDataTable;

import com.lzsoft.aml.entity.model.Operation;
import com.lzsoft.aml.entity.model.Role;
import com.lzsoft.aml.entity.model.querymodel.OpQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemmanager.IOpService;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "opBean")
@ViewScoped
public class PermissionoperationBean extends BaseBean {
	@ManagedProperty("#{operation}")
	private Operation op;

	@ManagedProperty("#{opQueryBean}")
	private OpQueryBean querybean;

	@ManagedProperty("#{opService}")
	private IOpService opService;

	private List<Operation> ops;
	int i = 0;

	private Collection<Object> selection;

	public void selectionListener(AjaxBehaviorEvent event) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		Object originalKey = dataTable.getRowKey();
		op = null;
		for (Object selectionKey : selection) {
			dataTable.setRowKey(selectionKey);
			if (dataTable.isRowAvailable()) {
				op = (Operation) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(originalKey);
	}

	public List<Operation> getOps() {
		try {
			// System.out.println(i++);//datatables会多次预加载（这个问题比较麻烦，还没真正有办法解决）
			synchronized (this) {

				if (querybean.isSelected()) {

					ops = this.opService.findByQuerybean(this.querybean);
					querybean.setSelected(false);

				} else if (null == ops) {
					ops = this.opService.findAll();
				}
				if(0!=currentId){
						List<Object[]>  tops = this.opService.getPermissionOpIdsByRoleid(this.currentId);
						if(null!=ops&&!ops.isEmpty()&&null!=tops&&!tops.isEmpty()){
							for (Operation tempop : ops) {
								if(tops.contains(tempop.getId())){
									tempop.setSelected(true);
								}else{
									tempop.setSelected(false);
								}
							}
						}
				}
			}
		} catch (ManagerException e) {
			e.printStackTrace();
			addWorningMessage("", "查询权限失败", false, 2);
		} catch (Exception e) {
			e.printStackTrace();
			addWorningMessage("", "查询权限失败" + e.getMessage(), false, 3);
		}
		return ops;
	}

	public void deleteRecord(Operation op) {
		this.opService.delete(op);
		this.ops.remove(op);// 同步(ops)
	}

	public void deleteRecordByID() {
	}

	public void add() {
		if (op.getId() == 0) {
			op.setCdate(DateUtil.getCurrentDate("yyyy-MM-dd"));
			op.setState(1);
			this.opService.save(op);
			querybean.setSelected(true);
			addWorningMessage("dataForm", "权限名称为：" + op.getOpname()
					+ "的权限创建完成！", false, 0);
		} else {
			updateOp();
		}
	}

	public void removeRecord() {
		for (Operation op : ops) {
			if (currentId == op.getId()) {
				this.opService.delete(op);
				this.ops.remove(op);// 同步(ops)
				addWorningMessage("dataForm", "权限名称为：" + op.getOpname()
						+ "的权限已经删除！", false, 0);
				break;
			}
		}
	}

	public void goEdit(Operation op) {
		this.op = op;
	}

	public void updateOp() {
		op.setState(1);
		this.opService.update(this.op);
		this.op = this.opService.find(op.getClass(), op.getId());
		addWorningMessage("dataForm", "权限名称为：" + op.getOpname() + "的内容已经保存！",
				false, 0);
	}
	public void saveOpidByUserid() {
		synchronized (this) {
			this.opService.deleteOpsByRoleid(currentId);
			int count = this.opService.saveRoleandRelation(
					this.currentId, ops);
			if (count == 1) {
				Role currRole = opService
						.findRoleByRoleid(this.currentId);
				addWorningMessage("", "角色名称为：" + currRole.getRolename()
						+ "的权限已经更新完成！", false, 0);
			} else {
				addWorningMessage("", "权限更新发生问题，请管理员解决后再进行相关操作！", false, 1);
			}
		}
	}

	public void reset() {
		querybean.setOpname(null);
	}

	public Operation getOp() {
		return op;
	}

	public void setOp(Operation op) {
		this.op = op;
	}

	public OpQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(OpQueryBean querybean) {
		this.querybean = querybean;
	}

	public IOpService getOpService() {
		return opService;
	}

	public void setOpService(IOpService opService) {
		this.opService = opService;
	}

	public void setOps(List<Operation> ops) {
		this.ops = ops;
	}

	public Collection<Object> getSelection() {
		return selection;
	}

	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}

}
