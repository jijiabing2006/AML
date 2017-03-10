package com.lzsoft.aml.service.report.util;

import java.io.FileOutputStream;

import org.apache.commons.beanutils.BeanUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.lzsoft.aml.exception.ManagerException;

public class BopXmlUtil  extends SafeXmlUtil{
	
	public BopXmlUtil(String type){
		super(type);
	}

	// 根据传入的文件类型和数据动态得到REC节点
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
		Element CUSTYPE = new Element("CUSTYPE");// 收款人类型
		CUSTYPE.setText(BeanUtils.getProperty(data, "custype"));
		REC.addContent(CUSTYPE);
		Element IDCODE = new Element("IDCODE");// 个人身份证件号码
		IDCODE.setText(BeanUtils.getProperty(data, "idcode"));
		REC.addContent(IDCODE);
		Element CUSTCOD = new Element("CUSTCOD");// 组织机构代码
		CUSTCOD.setText(BeanUtils.getProperty(data, "custcod"));
		REC.addContent(CUSTCOD);
		Element CUSTNM = new Element("CUSTNM");// 收款人名称
		CUSTNM.setText(BeanUtils.getProperty(data, "custnm"));
		REC.addContent(CUSTNM);
		Element OPPUSER = new Element("OPPUSER");// 付款人名称
		OPPUSER.setText(BeanUtils.getProperty(data, "oppuser"));
		REC.addContent(OPPUSER);
		if ("E".equalsIgnoreCase(fileType)) {
			Element OPPACC = new Element("OPPACC");// 付款人账号
			OPPACC.setText(BeanUtils.getProperty(data, "oppacc"));
			REC.addContent(OPPACC);
		}
		Element TXCCY = new Element("TXCCY");// 收入款币种
		TXCCY.setText(BeanUtils.getProperty(data, "txccy"));
		REC.addContent(TXCCY);
		Element TXAMT = new Element("TXAMT");// 收入款金额
		TXAMT.setText(BeanUtils.getProperty(data, "txamt"));
		REC.addContent(TXAMT);
		Element EXRATE = new Element("EXRATE");// 结汇汇率
		EXRATE.setText(BeanUtils.getProperty(data, "exrate"));
		REC.addContent(EXRATE);
		Element LCYAMT = new Element("LCYAMT");// 结汇金额
		LCYAMT.setText(BeanUtils.getProperty(data, "lcyamt"));
		REC.addContent(LCYAMT);
		Element LCYACC = new Element("LCYACC");// 人民币帐号/银行卡号
		LCYACC.setText(BeanUtils.getProperty(data, "lcyacc"));
		REC.addContent(LCYACC);
		Element FCYAMT = new Element("FCYAMT");// 现汇金额
		FCYAMT.setText(BeanUtils.getProperty(data, "fcyamt"));
		REC.addContent(FCYAMT);
		Element FCYACC = new Element("FCYACC");// 外汇帐号/银行卡号
		FCYACC.setText(BeanUtils.getProperty(data, "fcyacc"));
		REC.addContent(FCYACC);
		Element OTHAMT = new Element("OTHAMT");// 其它金额
		OTHAMT.setText(BeanUtils.getProperty(data, "othamt"));
		REC.addContent(OTHAMT);
		Element OTHACC = new Element("OTHACC");// 其它账号/银行卡号
		OTHACC.setText(BeanUtils.getProperty(data, "othacc"));
		REC.addContent(OTHACC);
		Element METHOD = new Element("METHOD");// 结算方式
		METHOD.setText(BeanUtils.getProperty(data, "method"));
		REC.addContent(METHOD);
		Element BUSCODE = new Element("BUSCODE");// 银行业务编号
		BUSCODE.setText(BeanUtils.getProperty(data, "buscode"));
		REC.addContent(BUSCODE);
		Element ACTUCCY = new Element("ACTUCCY");// 实际付款币种
		/** *************************************************** */
		// if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType))
		// {
		//
		// ACTUCCY.setText("");
		//
		// REC.addContent(ACTUCCY);
		//
		// }
		//
		// Element ACTUAMT = new Element("ACTUAMT");// 实际付款金额
		//
		// if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType))
		// {
		//
		// ACTUAMT.setText("");
		//
		// REC.addContent(ACTUAMT);
		//
		// }
		if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType)) {
			ACTUCCY.setText(BeanUtils.getProperty(data, "actuccy"));
			REC.addContent(ACTUCCY);
		}
		Element ACTUAMT = new Element("ACTUAMT");// 实际付款金额
		if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType)) {
			ACTUAMT.setText(BeanUtils.getProperty(data, "actuamt"));
			REC.addContent(ACTUAMT);
		}
		/** *************************************************** */
		Element INCHARGECCY = new Element("INCHARGECCY");// 国内银行扣费币种
		if ("A".equalsIgnoreCase(fileType) || "D".equalsIgnoreCase(fileType)) {
			INCHARGECCY
					.setText(BeanUtils.getProperty(data, "inchargeccy"));
			REC.addContent(INCHARGECCY);
		}
		Element INCHARGEAMT = new Element("INCHARGEAMT");// 国内银行扣费金额
		if ("A".equalsIgnoreCase(fileType) || "D".equalsIgnoreCase(fileType)) {
			INCHARGEAMT
					.setText(BeanUtils.getProperty(data, "inchargeamt"));
			REC.addContent(INCHARGEAMT);
		}
		Element OUTCHARGECCY = new Element("OUTCHARGECCY");// 国外银行扣费币种
		if ("A".equalsIgnoreCase(fileType) || "C".equalsIgnoreCase(fileType)
				|| "F".equalsIgnoreCase(fileType)) {
		OUTCHARGECCY.setText(BeanUtils.getProperty(data,
					"outchargeccy"));
			REC.addContent(OUTCHARGECCY);
		}
		Element OUTCHARGEAMT = new Element("OUTCHARGEAMT");// 国外银行扣费金额
		if ("A".equalsIgnoreCase(fileType) || "C".equalsIgnoreCase(fileType)
				|| "F".equalsIgnoreCase(fileType)) {
			OUTCHARGEAMT.setText(BeanUtils.getProperty(data,
					"outchargeamt"));
			REC.addContent(OUTCHARGEAMT);
		}
		Element LCBGNO = new Element("LCBGNO");// 信用证编号
		if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType)) {
			LCBGNO.setText(BeanUtils.getProperty(data, "lcbgno"));
			REC.addContent(LCBGNO);
		}
		Element ISSDATE = new Element("ISSDATE");// 开证日期
		if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType)) {
			ISSDATE.setText(BeanUtils.getProperty(data, "issdate"));
			REC.addContent(ISSDATE);
		}
		Element TENOR = new Element("TENOR");// 期限
		if ("C".equalsIgnoreCase(fileType) || "F".equalsIgnoreCase(fileType)) {
			TENOR.setText(BeanUtils.getProperty(data, "tenor"));
			REC.addContent(TENOR);
		}
		return REC;
	}
	
	/**
	 * 生成空报文
	 * 
	 * @param pbocCode
	 * @param rptdate
	 * @param sequence
	 * @return
	 */
	@Override
	public String generateEmptyReport(String pbocBankCode, String reportDate,int parseInt) {

		try {

			String fileName =getRootPath()
					+ xmlpathname+generateSafeReportFileName("T", pbocBankCode, reportDate,
							generateSequence(parseInt));

			Element root = new Element("MSG");
			Document document = new Document(root);
			Element APPTYPE = new Element("APPTYPE");
			APPTYPE.setText("BOP");
			root.addContent(APPTYPE);
			Element CURRENTFILE = new Element("CURRENTFILE");
			CURRENTFILE.setText("BOPT");
			root.addContent(CURRENTFILE);
			Element INOUT = new Element("INOUT");
			INOUT.setText("IN");
			root.addContent(INOUT);
			Element TOTALFILES = new Element("TOTALFILES");
			TOTALFILES.setText("0");
			root.addContent(TOTALFILES);
			Element FILES = new Element("FILES");
			FILES.setText(null);
			root.addContent(FILES);
			// 写xml文件头
			Format format = Format.getCompactFormat();
			format.setEncoding("gb18030");// 设置xml文件的字符为gb18030
			format.setIndent("    "); // 设置xml文件的缩进为4个空格
			XMLOutputter XMLOut = new XMLOutputter(format);// 元素后换行一层元素缩四格
			FileOutputStream fos = new FileOutputStream(fileName);
			XMLOut.output(document, fos);
			fos.close();
			return fileName;
		} catch (Exception e) {
			throw new ManagerException(e.getCause());
		}
	}

	/**
	 * 自动生成下一个序号
	 * 
	 * @param sequence
	 *            上一个序号
	 * @return
	 */
	private String generateSequence(int sequence) {
		if (String.valueOf(sequence).length() == 1) {
			return "0" + sequence;
		} else {
			return String.valueOf(sequence);
		}
	}

}
