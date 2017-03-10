package com.lzsoft.aml.web.systemmanager;

import java.util.Collection;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.component.UIExtendedDataTable;

import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.querymodel.BankInfoQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.systemmanager.IBankInfoService;
import com.lzsoft.aml.web.BaseBean;

@ManagedBean(name = "bankMBean")
@ViewScoped
public class BankManagerBean extends BaseBean {
	@ManagedProperty("#{bankinfo}")
	private Bankinfo bank;

	@ManagedProperty("#{bankQueryBean}")
	private BankInfoQueryBean querybean;

	@ManagedProperty("#{bankService}")
	private IBankInfoService bankService;

	private List<Bankinfo> banks;
	int i = 0;

	private Collection<Object> selection;

	public void selectionListener(AjaxBehaviorEvent event) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		Object originalKey = dataTable.getRowKey();
		bank = null;
		for (Object selectionKey : selection) {
			dataTable.setRowKey(selectionKey);
			if (dataTable.isRowAvailable()) {
				bank = (Bankinfo) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(originalKey);
	}

	public List<Bankinfo> getBanks() {

		// System.out.println(i++);//datatables会多次预加载（这个问题比较麻烦，还没真正有办法解决）
		synchronized (this) {

			if (querybean.isSelected()) {
				try {
					banks = this.bankService.findByQuerybean(this.querybean);
					querybean.setSelected(false);
				} catch (ManagerException e) {
					e.printStackTrace();
					addWorningMessage("", "查询用户失败", false, 2);
				} catch (Exception e) {
					e.printStackTrace();
					addWorningMessage("", "查询用户失败" + e.getMessage(), false, 3);
				}
			} else if (null == banks) {
				banks = this.bankService.findAll();
			}
		}
		return banks;
	}

	public void deleteRecord(Bankinfo bank) {
		this.bankService.delete(bank);
		this.banks.remove(bank);// 同步(banks)
	}

	public void deleteRecordByID() {
	}

	public void add() {
		if (bank.getId() == 0) {
			this.bankService.save(bank);
			querybean.setSelected(true);
			addWorningMessage("dataForm", "银行代码为：" + bank.getBranchcode()
					+ "的银行信息创建完成！", false, 0);
		} else {
			updateBank();
		}
	}

	public void removeRecord() {
		for (Bankinfo bank : banks) {
			if (currentId == bank.getId()) {
				this.bankService.delete(bank);
				this.banks.remove(bank);// 同步(banks)
				addWorningMessage("dataForm", "银行代码为：" + bank.getBranchcode()
						+ "的银行信息已经删除！", false, 0);
				break;
			}
		}
	}

	public void goEdit(Bankinfo bank) {
		this.bank = bank;
	}

	public void updateBank() {
		this.bankService.update(this.bank);
		this.bank = this.bankService.find(bank.getClass(), bank.getId());
		addWorningMessage("dataForm", "银行代码为：" + bank.getBranchcode()
				+ "的内容已经保存！", false, 0);
	}

	public void reset() {
		// querybean.setUsername(null);
	}

	public Bankinfo getBank() {
		return bank;
	}

	public void setBank(Bankinfo bank) {
		this.bank = bank;
	}

	public BankInfoQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(BankInfoQueryBean querybean) {
		this.querybean = querybean;
	}

	public IBankInfoService getBankService() {
		return bankService;
	}

	public void setBankService(IBankInfoService bankService) {
		this.bankService = bankService;
	}

	public void setBanks(List<Bankinfo> banks) {
		this.banks = banks;
	}

	public void showBankNameByBkidAndSubbkid(ValueChangeEvent event) {
		try {

			String bkid = FacesContext.getCurrentInstance()
					.getExternalContext().getRequestParameterMap().get("bkid");
			@SuppressWarnings("unused")
			String bkid2 =FacesContext.getCurrentInstance().
					getExternalContext().getRequestParameterMap().get("_bkid");
			@SuppressWarnings("unused")
			String subbkid2 =FacesContext.getCurrentInstance().
			 getExternalContext().getRequestParameterMap().get("_subbkid");
			String subbkid = (String) event.getNewValue();
			System.out.println(bank);
			if (null != bkid && bkid != "" && null != subbkid && subbkid != "") {
				List<Bankinfo> bs = bankService.queryByWhere(" bkid= '" + bkid
						+ "' and subbkid='" + subbkid + "'");
				if (null != bs&&!bs.isEmpty()) {
					bank = bs.get(0);
				} else {
					bank.setFullcnname("");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
