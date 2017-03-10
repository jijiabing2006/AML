package com.lzsoft.aml.service.report.util;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.jdom2.Element;

public class JshXmlUtil extends SafeXmlUtil {

	public JshXmlUtil(String type) {
		super(type);
	}

	@Override
	public Element getRec(String fileType, Object data) throws Exception {

		Element REC = new Element("REC");

		Element ACTIONTYPE = new Element("ACTIONTYPE");// 操作类型

		ACTIONTYPE.setText(BeanUtils.getProperty(data, "actiontype"));

		REC.addContent(ACTIONTYPE);

		Element ACTIONDESC = new Element("ACTIONDESC");// 修改 删除原因

		ACTIONDESC.setText(BeanUtils.getProperty(data, "actiondesc"));

		REC.addContent(ACTIONDESC);

		Element RPTNO = new Element("RPTNO");// 申报号码

		RPTNO.setText(BeanUtils.getProperty(data, "rptno"));

		REC.addContent(RPTNO);

		if (StringUtils.equals("D", fileType)
				|| StringUtils.equals("E", fileType)) {

			Element BUSCODE = new Element("BUSCODE");// 银行业务编号

			BUSCODE.setText(BeanUtils.getProperty(data, "buscode"));

			REC.addContent(BUSCODE);

			Element CUSTYPE = new Element("CUSTYPE");// 收款人类型

			CUSTYPE.setText(BeanUtils.getProperty(data, "custype"));

			REC.addContent(CUSTYPE);

			Element CUSTCOD = new Element("CUSTCOD");// 组织机构代码

			CUSTCOD.setText(BeanUtils.getProperty(data, "custcod"));

			REC.addContent(CUSTCOD);

			Element IDCODE = new Element("IDCODE");// 个人身份证件号码

			IDCODE.setText(BeanUtils.getProperty(data, "idcode"));

			REC.addContent(IDCODE);

			Element CUSTNM = new Element("CUSTNM");// 收款人名称

			CUSTNM.setText(BeanUtils.getProperty(data, "custnm"));

			REC.addContent(CUSTNM);

			if (StringUtils.equals("E", fileType)) {
				Element LCYACC = new Element("LCYACC");// 人民币帐号/银行卡号

				LCYACC.setText(BeanUtils.getProperty(data, "lcyacc"));

				REC.addContent(LCYACC);

				Element FCYACC = new Element("FCYACC");// 外汇帐号/银行卡号

				FCYACC.setText(BeanUtils.getProperty(data, "fcyacc"));

				REC.addContent(FCYACC);

			} else if (StringUtils.equals("D", fileType)) {

				Element FCYACC = new Element("FCYACC");// 外汇帐号/银行卡号

				FCYACC.setText(BeanUtils.getProperty(data, "fcyacc"));

				REC.addContent(FCYACC);

				Element LCYACC = new Element("LCYACC");// 人民币帐号/银行卡号

				LCYACC.setText(BeanUtils.getProperty(data, "lcyacc"));

				REC.addContent(LCYACC);

			}

			Element OPPUSER = new Element("OPPUSER");// 付/收款人名称

			OPPUSER.setText(BeanUtils.getProperty(data, "oppuser"));

			REC.addContent(OPPUSER);

			Element OPPBANK = new Element("OPPBANK");// 人民币账户开户行

			OPPBANK.setText(BeanUtils.getProperty(data, "oppbank"));

			REC.addContent(OPPBANK);

			if (StringUtils.equals("E", fileType)) {
				Element LCYAMT = new Element("LCYAMT");// 现汇金额

				LCYAMT.setText(BeanUtils.getProperty(data, "lcyamt"));

				REC.addContent(LCYAMT);

				Element LCYCCY = new Element("LCYCCY");// 币种

				LCYCCY.setText(BeanUtils.getProperty(data, "lcyccy"));

				REC.addContent(LCYCCY);
			} else if (StringUtils.equals("D", fileType)) {
				Element FCYAMT = new Element("FCYAMT");// 现汇金额

				FCYAMT.setText(BeanUtils.getProperty(data, "fcyamt"));

				REC.addContent(FCYAMT);

				Element FCYCCY = new Element("FCYCCY");// 币种

				FCYCCY.setText(BeanUtils.getProperty(data, "fcyccy"));

				REC.addContent(FCYCCY);
			}
			Element EXRATE = new Element("EXRATE");// 结汇汇率

			EXRATE.setText(BeanUtils.getProperty(data, "exrate"));

			REC.addContent(EXRATE);

		} else if (StringUtils.equals("F", fileType)
				|| StringUtils.equals("G", fileType)) {
			Element REGNO = new Element("REGNO");// 外汇局批件号/备案表号/业务编号
			REGNO.setText(BeanUtils.getProperty(data, "regno"));
			REC.addContent(REGNO);
			Element TXCODE = new Element("TXCODE");// 交易编码
			TXCODE.setText(BeanUtils.getProperty(data, "txcode"));
			REC.addContent(TXCODE);
			if (StringUtils.equals("F", fileType)) {
				Element USETYPE = new Element("USETYPE");// 结汇用途
				USETYPE.setText(BeanUtils.getProperty(data, "usetype"));
				REC.addContent(USETYPE);
				Element USEDETAIL = new Element("USEDETAIL");// 结汇详细用途
				USEDETAIL.setText(BeanUtils.getProperty(data, "usedetail"));
				REC.addContent(USEDETAIL);
			}
			Element CRTUSER = new Element("CRTUSER");// 填报人
			CRTUSER.setText(BeanUtils.getProperty(data, "crtuser"));
			REC.addContent(CRTUSER);
			Element INPTELC = new Element("INPTELC");// 填报人电话
			INPTELC.setText(BeanUtils.getProperty(data, "inptelc"));
			REC.addContent(INPTELC);
			Element RPTDATE = new Element("RPTDATE");// 申报日期
			RPTDATE.setText(BeanUtils.getProperty(data, "rptdate"));
			REC.addContent(RPTDATE);
		}
		return REC;
	}

	@Override
	public String generateEmptyReport(String pbocBankCode, String reportDate,
			int parseInt) {
		return null;
	}

}