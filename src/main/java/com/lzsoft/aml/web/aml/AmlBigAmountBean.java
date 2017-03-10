package com.lzsoft.aml.web.aml;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.apache.commons.lang.StringUtils;
import org.richfaces.component.UIExtendedDataTable;

import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.AmlQueryBean;
import com.lzsoft.aml.service.aml.IAmlService;
import com.lzsoft.aml.util.temp.DateUtil;

@ManagedBean
@ViewScoped
public class AmlBigAmountBean extends AmlbaseBean {
	private String activeTabname = "tab1";
	@ManagedProperty("#{amlBigAmount}")
	private AmlBigAmount amlBigAmount;

	@ManagedProperty("#{amlQueryBean}")
	private AmlQueryBean querybean;

	@ManagedProperty("#{amlService}")
	private IAmlService amlService;

	private List<AmlBigAmount> amlBigAmounts;

	private Collection<Object> selection;
	@ManagedProperty("#{amlSelectBean}")
	private AmlSelectBean amlSelectBean;

	public void selectionListener(AjaxBehaviorEvent event) {
		UIExtendedDataTable dataTable = (UIExtendedDataTable) event
				.getComponent();
		Object originalKey = dataTable.getRowKey();
		amlBigAmount = null;
		for (Object selectionKey : selection) {
			dataTable.setRowKey(selectionKey);
			if (dataTable.isRowAvailable()) {
				amlBigAmount = (AmlBigAmount) dataTable.getRowData();
			}
		}
		dataTable.setRowKey(originalKey);
	}

	public List<AmlBigAmount> getAmlBigAmounts() {

		// System.out.println(i++);//datatables会多次预加载（这个问题比较麻烦，还没真正有办法解决）
		synchronized (this) {
			UserInfo user = getUsersInSession();
			if (null == user) {
				addWorningMessage("exportform", "请登录后再进行操作.", false, 1);
				return null;
			}
			if (querybean.isSelected()) {
				try {
					amlBigAmounts = this.amlService.queryByQuerybean(
							amlBigAmount, this.querybean, user.getBkid(),
							user.getSubbkid());
					querybean.setSelected(false);
					this.activeTabname = "tab1";
				} catch (Exception e) {
					// e.printStackTrace();
					addWorningMessage("", "查询反洗钱—大额数据失败" + e.getMessage(),
							false, 3);
					log.error("查询反洗钱—大额数据失败", e);
				}
			} else if (null == amlBigAmounts) {
				amlBigAmounts = this.amlService.queryNonExport(amlBigAmount,
						user.getBkid(), user.getSubbkid());
			}
		}
		return amlBigAmounts;
	}

	public void deleteRecord(AmlBigAmount amlBigAmount) {
		try {
			this.amlService.delete(amlBigAmount);
		} catch (Exception e) {
			// e.printStackTrace();
			addWorningMessage("", "删除反洗钱大额数据失败" + e.getMessage(), false, 3);
			log.error("删除反洗钱大额数据失败", e);
		}
		this.amlBigAmounts.remove(amlBigAmount);// 同步()
	}

	public void deleteRecordByID() {
	}

	public void verify(ActionEvent event) {
		StringBuffer r = new StringBuffer();
		StringBuffer f = new StringBuffer();
		int count = 0;
		for (AmlBigAmount amlBigAmount : amlBigAmounts) {
			if (amlBigAmount.isSelected()) {
				if ("1".equals(amlBigAmount.getIsedit())) {
					r.append(amlBigAmount.getTicd()).append(",");
					amlBigAmount.setIsvalidation("1");
					count++;

				} else {
					f.append(amlBigAmount.getTicd()).append(",");

				}
			}
		}
		if (count > 0) {
			this.amlService.saveAll(amlBigAmounts);
			if (r.toString().length() > 1) {
				addWorningMessage("dataForm", r.toString() + "审核完成。", false, 0);
			}
		}
		if (f.toString().length() > 1) {
			addWorningMessage("dataForm", f.toString() + "需要编辑完成后才能进行审核。",
					false, 1);
		}
	}

	public void resetExportstatus(ActionEvent event) {
		StringBuffer r = new StringBuffer();
		String _exportstatus = FacesContext.getCurrentInstance()
				.getExternalContext().getRequestParameterMap()
				.get("_exportstatus");

		if (null != _exportstatus) {
			List<AmlBigAmount> bigs = getSelectedBigAmounts();
			changeStatusByRequest(r, _exportstatus, bigs);
			if (r.toString().length() > 1) {
				this.amlService.saveAll(bigs);
				addWorningMessage("dataForm", r.toString() + "的状态重置完成。", false,
						0);
			}
		} else {
			addWorningMessage("dataForm", "请选择需要重置状态的记录。", false, 0);
		}

	}

	protected void changeStatusByRequest(StringBuffer r, String _exportstatus,
			List<AmlBigAmount> bigs) {
		for (AmlBigAmount amlBigAmount : bigs) {
			r.append(amlBigAmount.getTicd()).append(",");
			switch (Integer.parseInt(_exportstatus)) {
			case 1:
				amlBigAmount.setIsexport("0");
				break;
			case 2:
				amlBigAmount.setIsedit("0");
				amlBigAmount.setIsvalidation("0");
				break;
			case 3:
				amlBigAmount.setIsvalidation("0");
				break;
			case 4:
				amlBigAmount.setIsedit("1");
				amlBigAmount.setIsvalidation("1");
				amlBigAmount.setIsexport("2");
				break;
			default:
				break;
			}
		}
	}

	protected List<AmlBigAmount> getSelectedBigAmounts() {
		List<AmlBigAmount> bigs = new ArrayList<AmlBigAmount>();
		for (AmlBigAmount amlBigAmount : amlBigAmounts) {
			if (amlBigAmount.isSelected()) {
				bigs.add(amlBigAmount);
			}
		}
		return bigs;
	}

	public void removeRecord() {
		try {
			for (AmlBigAmount amlBigAmount : amlBigAmounts) {
				if (currentId == amlBigAmount.getId()) {

					this.amlService.delete(amlBigAmount);

					this.amlBigAmounts.remove(amlBigAmount);// 同步(bopAs)
					addWorningMessage("dataForm",
							"业务编号为：" + amlBigAmount.getTicd() + "的交易记录已经删除！",
							false, 0);
					break;
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			addWorningMessage("", "删除反洗钱—大额数据失败", false, 3);
			log.error("删除反洗钱—大额数据失败", e);
		}
	}

	public void goEdit(AmlBigAmount amlBigAmount) {
		this.amlBigAmount = amlBigAmount;
	}

	public String goBack() {
		this.activeTabname = "tab1";
		addWorningMessage("", amlBigAmount.getTicd() + "并未进行保存", false, 1);
		return "amlbigamount";
	}

	public void updateAmlBigAmount() {
		try {
			setDefalutValueForUpdate(amlBigAmount);
			amlBigAmount.setRpdt(DateUtil.dateToStr(new Date(), "yyyyMMdd"));
			// if(DateUtil.strToDate(amlBigAmount.getHtdt(), "yyyyMMdd")){
			// 5
			// }
			if (amlBigAmount.getId() != 0) {
				this.amlService.update(this.amlBigAmount);
				this.activeTabname = "tab1";
				addWorningMessage("", "大额数据" + amlBigAmount.getTicd() + "保存完成",
						false, 0);
			} else {
				addWorningMessage("", "大额数据" + amlBigAmount.getTicd()
						+ "保存时发生异常，请关闭标签，重新点击菜单导航！", false, 1);
			}
		} catch (Exception e) {
			// e.printStackTrace();
			addWorningMessage("", "更新反洗钱—大额数据失败" + e.getMessage(), false, 3);
			log.error("更新反洗钱—大额数据失败", e);
		}
	}

	public void reset() {
		try {
			reset(querybean);
		} catch (Exception e) {
		//	e.printStackTrace();
			addWorningMessage("", "reset error", true, 2);
			addWorningMessage("", e.getMessage(), false, 2);
			log.error("reseerror",e);
		}
	}

	public AmlBigAmount getAmlBigAmount() {
		try {
			// 初始支付方式
			String method = amlBigAmount.getTstp();
			String fdn=(String)amlBigAmount.getFieldDisplayName("rinm");
			String fdnn=(String)amlBigAmount.getFieldDisplayName("cfin");
			if (null != method) {
				amlSelectBean.initAmlMethodSelect(StringUtils.substring(method,
						0, 2));
			}
			setAmountDefaults(amlBigAmount);

			String tdrc = amlBigAmount.getTdrc();
			if (null != tdrc && tdrc.length() >= 3) {
				amlBigAmount.setTdrcfirst(StringUtils.substring(tdrc, 0, 3));
				amlBigAmount.setTdrcsecond(StringUtils.substring(tdrc, 3));
			} else {
				amlBigAmount.setTdrcfirst(StringUtils.substring(tdrc, 0));
				amlBigAmount.setTdrcsecond("");
			}
			String trcd = amlBigAmount.getTrcd();
			if (null != trcd && trcd.length() >= 3) {
				amlBigAmount.setTrcdfirst(StringUtils.substring(trcd, 0, 3));
				amlBigAmount.setTrcdsecond(StringUtils.substring(trcd, 3));
			} else {
				amlBigAmount.setTrcdfirst(StringUtils.substring(trcd, 0));
				amlBigAmount.setTrcdsecond("");
			}
			this.activeTabname = "tab2";
		} catch (Exception e) {
//			e.printStackTrace();
			addWorningMessage("", "获取反洗钱—大额数据失败" + e.getMessage(), false, 3);
			log.error("获取反洗钱—大额数据失败",e);
		}
		return amlBigAmount;
	}

	public void tdrcValueChanged(ValueChangeEvent event) {
		if (null != event.getNewValue()) {
			@SuppressWarnings("unused")
			String tdrchead = (String) event.getNewValue();
			// System.out.println(tdrchead);
		}
	}

	public Collection<Object> getSelection() {
		return selection;
	}

	public void setSelection(Collection<Object> selection) {
		this.selection = selection;
	}

	public String getActiveTabname() {
		return activeTabname;
	}

	public void setActiveTabname(String activeTabname) {
		this.activeTabname = activeTabname;
	}

	public void setAmlBigAmount(AmlBigAmount amlBigAmount) {
		this.amlBigAmount = amlBigAmount;
	}

	public AmlQueryBean getQuerybean() {
		return querybean;
	}

	public void setQuerybean(AmlQueryBean querybean) {
		this.querybean = querybean;
	}

	public IAmlService getAmlService() {
		return amlService;
	}

	public void setAmlService(IAmlService amlService) {
		this.amlService = amlService;
	}

	public void setAmlBigAmounts(List<AmlBigAmount> amlBigAmounts) {
		this.amlBigAmounts = amlBigAmounts;
	}

	public AmlSelectBean getAmlSelectBean() {
		return amlSelectBean;
	}

	public void setAmlSelectBean(AmlSelectBean amlSelectBean) {
		this.amlSelectBean = amlSelectBean;
	}
}
