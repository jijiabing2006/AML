package com.lzsoft.aml.service.report.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.Bankinfo;

public class AmlBigXmlUtil2 {

	public boolean writeXML(String reporttype, Bankinfo bankinfo,
			List<AmlBigAmount> list, String fileName, String oldPostDate)
			throws Exception {
		Map<String, Map<String, List<AmlBigAmount>>> amls = getAmlMaps(list);

		Element root = new Element("HVTR");
		Document doc = new Document(root);
		Element RBIF = new Element("RBIF");
		Element CATIs = new Element("CATIs");
		root.addContent(RBIF);
		root.addContent(CATIs);

		setRBIF(reporttype, bankinfo, amls.size(), RBIF, oldPostDate);

		Set<String> csnms = amls.keySet();
		int i = 0;
		for (String key : csnms) {
			setCATIs(amls, CATIs, i, key);
			i++;
		}
		// 写xml文件头
		OutpuyXMLFile(fileName, doc);
		return true;

	}

	private void OutpuyXMLFile(String fileName, Document doc)
			throws FileNotFoundException, IOException {
		Format format = Format.getCompactFormat();
		format.setEncoding("gb18030");// 设置xml文件的字符为gb18030
		format.setIndent("    "); // 设置xml文件的缩进为4个空格
		XMLOutputter XMLOut = new XMLOutputter(format);// 元素后换行一层元素缩四格
		FileOutputStream fos = new FileOutputStream(fileName);
		XMLOut.output(doc, fos);
		fos.close();
	}

	protected void setCATIs(Map<String, Map<String, List<AmlBigAmount>>> amls,
			Element CATIs, int i, String key) throws Exception {
		AmlBigAmount t = new AmlBigAmount();
		Element CATI = new Element("CATI");
		CATI.setAttribute("seqno", i + 1 + "");
		Element CTIF = new Element("CTIF");
		Element CTNM = new Element("CTNM");
		Element CITP = new Element("CITP");
		Element CTID = new Element("CTID");
		Element CSNM = new Element("CSNM");
		Element CTNT = new Element("CTNT");
		Element HTDT = new Element("HTDT");
		Element HTCRs = new Element("HTCRs");

		Map<String, List<AmlBigAmount>> a = amls.get(key);
		Set<String> crcds = a.keySet();
		int j = 0;
		for (String crcd : crcds) {
			setHTCRs(HTCRs, a, j, crcd, t);
			j++;

		}
		CTNM.setText(t.getCtnm());
		CITP.setText(t.getCitp());
		CTID.setText(t.getCtid());
		CSNM.setText(t.getCsnm());
		CTNT.setText(t.getCtnt());
		HTDT.setText(t.getHtdt());
		CATI.addContent(CTIF);
		CTIF.addContent(CTNM);
		CTIF.addContent(CITP);
		CTIF.addContent(CTID);
		CTIF.addContent(CSNM);
		CTIF.addContent(CTNT);
		CATI.addContent(HTDT);
		CATI.addContent(HTCRs);
		CATIs.addContent(CATI);
	}

	protected void setHTCRs(Element HTCRs, Map<String, List<AmlBigAmount>> a,
			int j, String crcd, AmlBigAmount t) throws Exception {
		List<AmlBigAmount> bs = a.get(crcd);
		Element HTCR = new Element("HTCR");
		HTCR.setAttribute("seqno", j + 1 + "");

		Element CRCD = new Element("CRCD");
		CRCD.setText(crcd);
		Element TTNM = new Element("TTNM");
		TTNM.setText(String.valueOf(bs.size()));
		Element TSDTs = new Element("TSDTs");
		HTCR.addContent(CRCD);
		HTCR.addContent(TTNM);
		HTCR.addContent(TSDTs);

		int k = 0;
		for (AmlBigAmount amlBigAmount : bs) {
			if (null == t || null == t.getCsnm()) {
				BeanUtils.copyProperties(t, amlBigAmount);
			}
			setTSTs(TSDTs, k, amlBigAmount);
			k++;
		}
		HTCRs.addContent(HTCR);
	}

	protected void setTSTs(Element TSDTs, int k, AmlBigAmount amlBigAmount) {
		Element TSDT = new Element("TSDT");
		TSDT.setAttribute("seqno", k + 1 + "");
		Element RINI = new Element("RINI");
		Element TBIF = new Element("TBIF");
		Element TSIF = new Element("TSIF");
		Element TCIF = new Element("TCIF");
		setRINI(amlBigAmount, RINI);
		setTBIF(amlBigAmount, TBIF);
		setTSIF(amlBigAmount, TSIF);
		setTCIF(amlBigAmount, TCIF);
		TSDT.addContent(RINI);
		TSDT.addContent(TBIF);
		TSDT.addContent(TSIF);
		TSDT.addContent(TCIF);
		TSDTs.addContent(TSDT);
	}

	protected void setTCIF(AmlBigAmount amlBigAmount, Element TCIF) {
		Element CFIN = new Element("CFIN");
		CFIN.setText(amlBigAmount.getCfin());
		Element CFCT = new Element("CFCT");
		CFCT.setText(amlBigAmount.getCfct());
		Element CFIC = new Element("CFIC");
		CFIC.setText(amlBigAmount.getCfic());
		Element TCNM = new Element("TCNM");
		TCNM.setText(amlBigAmount.getTcnm());
		Element TCIT = new Element("TCIT");
		TCIT.setText(amlBigAmount.getTcit());
		Element TCID = new Element("TCID");
		TCID.setText(amlBigAmount.getTcid());
		Element TCAT = new Element("TCAT");
		TCAT.setText(amlBigAmount.getTcat());
		Element TCAC = new Element("TCAC");
		TCAC.setText(amlBigAmount.getTcac());

		TCIF.addContent(CFIN);
		TCIF.addContent(CFCT);
		TCIF.addContent(CFIC);
		TCIF.addContent(TCNM);
		TCIF.addContent(TCIT);
		TCIF.addContent(TCID);
		TCIF.addContent(TCAT);
		TCIF.addContent(TCAC);
	}

	protected void setTSIF(AmlBigAmount amlBigAmount, Element TSIF) {
		Element TSTM = new Element("TSTM");
		TSTM.setText(amlBigAmount.getTstm());
		Element TICD = new Element("TICD");
		TICD.setText(amlBigAmount.getTicd());
		Element TSTP = new Element("TSTP");
		TSTP.setText(amlBigAmount.getTstp());
		Element TSCT = new Element("TSCT");
		TSCT.setText(amlBigAmount.getTsct());
		Element TSDR = new Element("TSDR");
		TSDR.setText(amlBigAmount.getTsdr());
		Element TDRC = new Element("TDRC");
		TDRC.setText(amlBigAmount.getTdrc());
		Element TRCD = new Element("TRCD");
		TRCD.setText(amlBigAmount.getTrcd());
		Element CRPP = new Element("CRPP");
		CRPP.setText(amlBigAmount.getCrpp());
		Element CRTP = new Element("CRTP");
		CRTP.setText(amlBigAmount.getCrtp());
		Element CRAT = new Element("CRAT");
		CRAT.setText(String.valueOf(amlBigAmount.getCrat()));

		TSIF.addContent(TSTM);
		TSIF.addContent(TICD);
		TSIF.addContent(TSTP);
		TSIF.addContent(TSCT);
		TSIF.addContent(TSDR);
		TSIF.addContent(TDRC);
		TSIF.addContent(TRCD);
		TSIF.addContent(CRPP);
		TSIF.addContent(CRTP);
		TSIF.addContent(CRAT);
	}

	protected void setTBIF(AmlBigAmount amlBigAmount, Element TBIF) {
		Element TBNM = new Element("TBNM");
		TBNM.setText(amlBigAmount.getTbnm());
		Element TBIT = new Element("TBIT");
		TBIT.setText(amlBigAmount.getTbit());
		Element TBID = new Element("TBID");
		TBID.setText(amlBigAmount.getTbid());
		Element TBNT = new Element("TBNT");
		TBNT.setText(amlBigAmount.getTbnt());
		TBIF.addContent(TBNM);
		TBIF.addContent(TBIT);
		TBIF.addContent(TBID);
		TBIF.addContent(TBNT);
	}

	protected void setRINI(AmlBigAmount amlBigAmount, Element RINI) {
		Element FINN = new Element("FINN");
		FINN.setText(amlBigAmount.getFinn());
		Element FIRC = new Element("FIRC");
		FIRC.setText(amlBigAmount.getFirc());
		Element RLTP = new Element("RLTP");
		RLTP.setText(amlBigAmount.getRltp());
		Element FICT = new Element("FICT");
		FICT.setText(amlBigAmount.getFict());
		Element FINC = new Element("FINC");
		FINC.setText(amlBigAmount.getFinc());
		Element CATP = new Element("CATP");
		CATP.setText(amlBigAmount.getCatp());
		Element CTAC = new Element("CTAC");
		CTAC.setText(amlBigAmount.getCtac());

		RINI.addContent(FINN);
		RINI.addContent(FIRC);
		RINI.addContent(RLTP);
		RINI.addContent(FICT);
		RINI.addContent(FINC);
		RINI.addContent(CATP);
		RINI.addContent(CTAC);
	}

	protected void setRBIF(String reporttype, Bankinfo bankinfo,
			int i, Element RBIF,
			String oldPostDate) {
		Element RINM, RICD, RPDT, CTTN;
		RINM = new Element("RINM");// 报告机构名称
		RINM.setText(bankinfo.getFullcnname());
		RBIF.addContent(RINM);
		RICD = new Element("RICD");// 报告机构编码
		RICD.setText(bankinfo.getAmlbankcode());
		RBIF.addContent(RICD);

		RPDT = setRPDT(reporttype, oldPostDate);
		RBIF.addContent(RPDT);
		CTTN = setCTTN(reporttype, i);
		RBIF.addContent(CTTN);

	}

	private Element setCTTN(String reporttype, int i) {
		Element CTTN;
		String cttn="";
		if ("N".equals(reporttype) || "R".equals(reporttype)
				|| "A".equals(reporttype)) {
			cttn="CTTN";
		}
		if (StringUtils.equals("C", reporttype)||StringUtils.equals("I", reporttype)) {
			cttn = "TSTN";
		}
		if (StringUtils.equals("D", reporttype)) {
			cttn = "DTNT";
		}
		CTTN = new Element(cttn);
		CTTN.setText(String.valueOf(i));
		return CTTN;
	}

	private Element setRPDT(String reporttype, String oldPostDate) {
		Element RPDT;
		String rpdt = "";
		if ("N".equals(reporttype) || "R".equals(reporttype)
				|| "A".equals(reporttype)) {
			rpdt = "RPDT";
		}
		if (StringUtils.equals("C", reporttype)) {
			rpdt = "CRDT";
		}
		if (StringUtils.equals("D", reporttype)) {
			rpdt = "DRDT";// DTTN TSTN
		}
		if (StringUtils.equals("I", reporttype)) {
			rpdt = "IRDT";
		}
		RPDT = new Element(rpdt);// 报告生成日期
		if ("R".equals(reporttype)) {// 要严格与欲重新报送的原大额交易报告文件名称的报送日期、报送批次相一致，而区别于当前的报送时间
			RPDT.setText(oldPostDate);
		} else {
			RPDT.setText(DateFormatUtils.format(new Date(), "yyyyMMdd"));
		}
		return RPDT;
	}

	protected Map<String, Map<String, List<AmlBigAmount>>> getAmlMaps(
			List<AmlBigAmount> list) {
		Map<String, Map<String, List<AmlBigAmount>>> amls = new HashMap<String, Map<String, List<AmlBigAmount>>>();

		for (AmlBigAmount amlBigAmount : list) {
			if (null == amls.get(amlBigAmount.getCsnm())) {
				Map<String, List<AmlBigAmount>> m = new HashMap<String, List<AmlBigAmount>>();
				List<AmlBigAmount> a = new ArrayList<AmlBigAmount>();
				a.add(amlBigAmount);
				m.put(amlBigAmount.getCrcd(), a);
				amls.put(amlBigAmount.getCsnm(), m);

			} else {
				Map<String, List<AmlBigAmount>> m = amls.get(amlBigAmount
						.getCsnm());
				if (null == m.get(amlBigAmount.getCrcd())) {
					List<AmlBigAmount> a = new ArrayList<AmlBigAmount>();
					a.add(amlBigAmount);
					m.put(amlBigAmount.getCrcd(), a);
				} else {
					m.get(amlBigAmount.getCrcd()).add(amlBigAmount);
				}

			}
		}
		return amls;
	}

	/**
	 * 纠错报文 补正报文
	 */
	public boolean writeXMLCI(String reporttype, Bankinfo bankinfo,
			List<AmlBigAmount> amls, String fileName, String oldPostDate)
			throws Exception {
		Element root = new Element("CHTR");
		Document doc = new Document(root);
		// 报告基本信
		Element RBIF = new Element("RBIF");
		setRBIF(reporttype, bankinfo, amls.size(), RBIF, oldPostDate);
		root.addContent(RBIF);
		
		// 报告主体和交易信息 CTIFs
		Element TSDTs = new Element("TSDTs");
		root.addContent(TSDTs);

		for (int i = 0; i < amls.size(); i++) {
			Element TSDT = new Element("TSDT");
			TSDT = this.getTSDTCDI(amls.get(i), i);
			TSDTs.addContent(TSDT);
		}
		OutpuyXMLFile(fileName, doc);
		return true;
	}


	private Element getTSDTCDI(AmlBigAmount _amlBgmt, int i) {

		Element TDST, OCMN, OTDT, OTCD, OTIC, RINI, TBIF, TSIF, TCIF;

		TDST = new Element("TSDT");
		OCMN = new Element("OCNM");
		OTDT = new Element("OTDT");
		OTCD = new Element("OTCD");
		OTIC = new Element("OTIC");
		RINI = new Element("RINI");
		TBIF = new Element("TBIF");
		TSIF = new Element("TSIF");
		int seqno = i + 1;
		TCIF = new Element("TCIF");
		TDST.setAttribute("seqno", seqno + "");
		OCMN.setText(_amlBgmt.getCsnm());
		OTDT.setText(_amlBgmt.getHtdt());
		OTCD.setText(_amlBgmt.getCrcd());
		OTIC.setText(_amlBgmt.getTicd());
		RINI = this.setRINI(_amlBgmt);
		TBIF = this.setTBIF(_amlBgmt);
		TSIF = this.setTSIF(_amlBgmt);
		TCIF = this.setTCIF(_amlBgmt);
		TDST.addContent(OCMN);
		TDST.addContent(OTDT);
		TDST.addContent(OTCD);
		TDST.addContent(OTIC);
		TDST.addContent(RINI);
		TDST.addContent(TBIF);
		TDST.addContent(TSIF);
		TDST.addContent(TCIF);

		return TDST;

	}

	private Element setRINI(AmlBigAmount _amlbig) {
		Element FIRC, RLTP, FICT, FINC, CATP, CTAC;

		Element RINI = new Element("RINI");// RINI 金融机构网点信息
		// RINI 金融机构网点信息
		Element FINN = new Element("FINN");
		FIRC = new Element("FIRC");
		RLTP = new Element("RLTP");
		FICT = new Element("FICT");
		FINC = new Element("FINC");
		CATP = new Element("CATP");
		CTAC = new Element("CTAC");

		FINN.setText(_amlbig.getFinn() == null ? "" : _amlbig.getFinn());
		FIRC.setText(_amlbig.getFirc() == null ? "" : _amlbig.getFirc());
		RLTP.setText(_amlbig.getRltp() == null ? "" : _amlbig.getRltp());
		FICT.setText(_amlbig.getFict() == null ? "" : _amlbig.getFict());// "金融机构网点代码类型"
		FINC.setText(_amlbig.getFinc() == null ? "" : _amlbig.getFinc());
		CATP.setText(_amlbig.getCatp() == null ? "" : _amlbig.getCatp());
		CTAC.setText(_amlbig.getCtac() == null ? "" : _amlbig.getCtac());

		RINI.addContent(FINN);
		RINI.addContent(FIRC);
		RINI.addContent(RLTP);
		RINI.addContent(FICT);
		RINI.addContent(FINC);
		RINI.addContent(CATP);
		RINI.addContent(CTAC);

		return RINI;

	}

	private Element setTBIF(AmlBigAmount _amlbig) {
		Element TBNM, TBIT, TBID, TBNT;
		Element TBIF = new Element("TBIF");// TBIF 代办人信息
		// TBIF 代办人信息
		TBNM = new Element("TBNM");
		TBIT = new Element("TBIT");
		TBID = new Element("TBID");
		TBNT = new Element("TBNT");

		TBNM.setText(_amlbig.getTbnm() == null ? "" : _amlbig.getTbnm());
		TBIT.setText(_amlbig.getTbit() == null ? "" : _amlbig.getTbit());
		TBID.setText(_amlbig.getTbid() == null ? "" : _amlbig.getTbid());
		TBNT.setText(_amlbig.getTbnt() == null ? "" : _amlbig.getTbnt());

		TBIF.addContent(TBNM);
		TBIF.addContent(TBIT);
		TBIF.addContent(TBID);
		TBIF.addContent(TBNT);

		return TBIF;
	}

	private Element setTSIF(AmlBigAmount _amlbig) {
		Element TSTM, TICD, TSTP, TSCT, TSDR, TDRC, CRPP;
		Element CRTP, CRAT, TRCD;

		Element TSIF = new Element("TSIF");// TSIF 交易信息
		// TSIF 交易信息
		TSTM = new Element("TSTM");
		TICD = new Element("TICD");
		TSTP = new Element("TSTP");
		TSCT = new Element("TSCT");
		TSDR = new Element("TSDR");
		TDRC = new Element("TDRC");
		TRCD = new Element("TRCD");
		CRPP = new Element("CRPP");
		CRTP = new Element("CRTP");
		CRAT = new Element("CRAT");

		TSTM.setText(_amlbig.getTstm() == null ? "" : _amlbig.getTstm());
		TICD.setText(_amlbig.getTicd() == null ? "" : _amlbig.getTicd());
		TSTP.setText(_amlbig.getTstp() == null ? "" : _amlbig.getTstp());
		TSCT.setText(_amlbig.getTsct() == null ? "" : _amlbig.getTsct());
		TSDR.setText(_amlbig.getTsdr() == null ? "" : _amlbig.getTsdr());
		TDRC.setText(_amlbig.getTdrc() == null ? "" : _amlbig.getTdrc());
		TRCD.setText(_amlbig.getTrcd() == null ? "" : _amlbig.getTrcd());
		CRPP.setText(_amlbig.getCrpp() == null ? "" : _amlbig.getCrpp());
		CRTP.setText(_amlbig.getCrtp() == null ? "" : _amlbig.getCrtp());
		// CRAT.setText(BigDecimal.valueOf((_amlbig.getCrat())).toString());
		// 为了防止在页面和导出时使用科学记数法,需要格式化金额
		DecimalFormat df = new DecimalFormat("####.###");
		CRAT.setText(df.format(_amlbig.getCrat()));

		TSIF.addContent(TSTM);
		TSIF.addContent(TICD);
		TSIF.addContent(TSTP);
		TSIF.addContent(TSCT);
		TSIF.addContent(TSDR);
		TSIF.addContent(TDRC);
		TSIF.addContent(TRCD);
		TSIF.addContent(CRPP);
		TSIF.addContent(CRTP);
		TSIF.addContent(CRAT);

		return TSIF;

	}

	/**
	 * 交易对手信息
	 * 
	 * @param _amlbig
	 * @return
	 */
	private Element setTCIF(AmlBigAmount _amlbig) {
		Element CFIN, CFCT, CFIC, TCNM, TCIT, TCID, TCAT, TCAC;

		Element TCIF = new Element("TCIF");// TCIF 交易对手信息

		CFIN = new Element("CFIN");
		CFCT = new Element("CFCT");
		CFIC = new Element("CFIC");
		TCNM = new Element("TCNM");
		TCIT = new Element("TCIT");
		TCID = new Element("TCID");
		TCAT = new Element("TCAT");
		TCAC = new Element("TCAC");

		CFIN.setText(_amlbig.getCfin() == null ? "" : _amlbig.getCfin());
		CFCT.setText(_amlbig.getCfct() == null ? "" : _amlbig.getCfct());
		CFIC.setText(_amlbig.getCfic() == null ? "" : _amlbig.getCfic());
		TCNM.setText(_amlbig.getTcnm() == null ? "" : _amlbig.getTcnm());
		TCIT.setText(_amlbig.getTcit() == null ? "" : _amlbig.getTcit());
		TCID.setText(_amlbig.getTcid() == null ? "" : _amlbig.getTcid());
		TCAT.setText(_amlbig.getTcat() == null ? "" : _amlbig.getTcat());
		TCAC.setText(_amlbig.getTcac() == null ? "" : _amlbig.getTcac());

		TCIF.addContent(CFIN);
		TCIF.addContent(CFCT);
		TCIF.addContent(CFIC);
		TCIF.addContent(TCNM);
		TCIF.addContent(TCIT);
		TCIF.addContent(TCID);
		TCIF.addContent(TCAT);
		TCIF.addContent(TCAC);

		return TCIF;
	}
	/**
	 * 删除报文
	 */
	public boolean writeXMLDBH(String reporttype, Bankinfo bankinfo,
			List<AmlBigAmount> amls, String fileName, String oldPostDate)
			throws Exception {

		Element root = new Element("DHTR");
		Document doc = new Document(root);
		// 报告基本信息
		Element RBIF = new Element("RBIF");
		setRBIF(reporttype, bankinfo, amls.size(), RBIF, oldPostDate);
		root.addContent(RBIF);
		// 报告主体和交易信息 CTIFs
		Element DTDTs = new Element("DTDTs");
		root.addContent(DTDTs);
		for (int i = 0; i < amls.size(); i++) {
			Element DTDT = new Element("DTDT");

			DTDT = this.getDTDT(amls.get(i), i);
			DTDTs.addContent(DTDT);
		}

		OutpuyXMLFile(fileName, doc);
			return true;
	}
	private Element getDTDT(AmlBigAmount _amlBgmt, int i) {

		Element DTDT, HTDT, CSNM, CRCD, TICD;
		DTDT = new Element("DTDT");
		HTDT = new Element("HTDT");
		CSNM = new Element("CSNM");
		CRCD = new Element("CRCD");
		TICD = new Element("TICD");
		DTDT.setAttribute("seqno", i + 1 + "");
		HTDT.setText(_amlBgmt.getHtdt());
		CSNM.setText(_amlBgmt.getCsnm());

		CRCD.setText(_amlBgmt.getCrcd());
		TICD.setText(_amlBgmt.getTicd());
		DTDT.addContent(HTDT);
		DTDT.addContent(CSNM);
		DTDT.addContent(CRCD);
		DTDT.addContent(TICD);

		return DTDT;

	}
}