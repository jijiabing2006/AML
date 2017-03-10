package com.lzsoft.aml.service.systemmanager.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.ISuperadditionService;

@ManagedBean
@ViewScoped
public class SuperadditionService extends BaseService implements
		ISuperadditionService {/*

	@Override
	public int save(UserInfo user, Date importdate, Ifxacct ifxacct,
			Ifxtran ifxtran, Ifxcust ifxcust, boolean hascust,
			boolean hasaccount) throws ManagerException {

		if (null != importdate) {
			setImportdate(importdate, ifxacct, ifxtran, ifxcust);

			setBkidAndSubbkid(user, ifxacct, ifxtran, ifxcust);

			ifxacct.setCsnm(ifxcust.getCsnm());
			ifxtran.setCsnm(ifxcust.getCsnm());

			ifxtran.setAccount(ifxacct.getAcod());
			ifxtran.setBook(ifxacct.getBook());
			ifxtran.setAcod(ifxacct.getAcod());
			ifxtran.setCcy(ifxacct.getCcy());

			ifxcust.setIshandadd("1");
			ifxacct.setIshandadd("1");
			ifxtran.setIshandadd("1");

			if (!hascust) {// 已经存在客户信息时，不用再保存客户
				Ifxcust cust = dao.findByWhere(
						Ifxcust.class,
						"csnm=? and importdate=?",
						new Object[] { ifxcust.getCsnm(),
								ifxcust.getImportdate() });
				if (null == cust) {
					dao.save(ifxcust);
				}
			}
			if (!hasaccount) {// 已经存在账户信息时，不用不规则保存账户
				Ifxacct acct = dao.findByWhere(
						Ifxacct.class,
						"csnm=? and importdate=? and acod=? and ccy=?",
						new Object[] { ifxacct.getCsnm(),
								ifxacct.getImportdate(), ifxacct.getAcod(),
								ifxacct.getCcy() });
				if (null == acct) {
					dao.save(ifxacct);
				}
			}
			dao.save(ifxtran);
			return 1;

		}

		return 0;
	}

	protected void setBkidAndSubbkid(UserInfo user, Ifxacct ifxacct,
			Ifxtran ifxtran, Ifxcust ifxcust) {
		ifxcust.setBkid(user.getBkid());
		ifxacct.setBkid(user.getBkid());
		ifxtran.setBkid(user.getBkid());

		ifxcust.setSubbkid(user.getSubbkid());
		ifxacct.setSubbkid(user.getSubbkid());
		ifxtran.setSubbkid(user.getSubbkid());
	}

	protected void setImportdate(Date importdate, Ifxacct ifxacct,
			Ifxtran ifxtran, Ifxcust ifxcust) {
		ifxcust.setImportdate(importdate);
		ifxacct.setImportdate(importdate);
		ifxtran.setImportdate(importdate);
		ifxtran.setPstd(importdate);
		ifxtran.setVald(importdate);
	}

//	@ManagedProperty("#{autoImportData}")
//	private AutoImportDataImpl autoImportData;
//	
	//@ManagedProperty("#{summitImportData}")
	//private SummitImportDataImpl summitImportData;

//	@Override
//	public void importdb() throws Exception {
//		autoImportData.importData();
//	}

	
	@Override
	public void importSummit2Db(Date importdate) throws Exception {
	//	summitImportData.autoImportDataToDB(importdate);
	}

	@Override
	public void importdb() throws Exception {
		// TODO Auto-generated method stub
		
	}

	//public AutoImportDataImpl getAutoImportData() {
	//	return autoImportData;
	//}

	//public void setAutoImportData(AutoImportDataImpl autoImportData) {
	//	this.autoImportData = autoImportData;
	//}

	//public SummitImportDataImpl getSummitImportData() {
	//	return summitImportData;
	//}

	//public void setSummitImportData(SummitImportDataImpl summitImportData) {
	//	this.summitImportData = summitImportData;
	//}

*/}
