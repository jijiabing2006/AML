package com.lzsoft.aml.service.aml.impl;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.autoexecute.service.IExtractService;
import com.lzsoft.aml.common.Constants;
import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.Bankinfo;
import com.lzsoft.aml.entity.model.Download;
import com.lzsoft.aml.entity.model.Reportindex;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.AmlQueryBean;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.service.AmlBaseService;
import com.lzsoft.aml.service.aml.IAmlReportService;
import com.lzsoft.aml.service.report.util.AmlBigXmlUtil2;
import com.lzsoft.aml.util.DateUtil;
import com.lzsoft.aml.util.ExcelExport;
import com.lzsoft.aml.util.ZipUtil;

@ManagedBean(name = "amlReportService")
@ViewScoped
public class AmlReportService extends AmlBaseService implements
		IAmlReportService {
	@ManagedProperty("#{amlExtractServiceImpl}")
	private IExtractService amlExtractServiceImpl;

	@Override
	public int exportAmlBigAmountReport(List<AmlBigAmount> amlbigs,
			String type, Download download, UserInfo user) throws Exception {
		StringBuilder oldfilename = new StringBuilder();
		StringBuilder oldpostdate = new StringBuilder();
		int i = getOldfilename(amlbigs, type, oldfilename, oldpostdate);
		if (i != 1) {
			return i;
		}
		clearAmlFolder();

		Bankinfo bankinfo = dao.findByWhere(Bankinfo.class,
				"bkid=? and subbkid=?",
				new Object[] { user.getBkid(), user.getSubbkid() });
		String zipbatch = getZipindex(
				user.getBkid(), user.getSubbkid(),"AML","BH");
		String xmlbatch = Constants.AML_XMLFILE_DEFALUT_INDEX;
		String nowdates = DateUtil.getCurrDate("yyyyMMdd");
		String zipName = getZipName("BH", bankinfo.getAmlbankcode(), type,
				zipbatch);// zip上报文件的文件名
		String fileName = getAMLFileName("BH", bankinfo.getAmlbankcode(), type,
				zipbatch, xmlbatch, nowdates, oldfilename.toString());

		String downPathAndFileName = amlZipPath + zipName;// zip文件的相对路径

		boolean flag = generateXML(bankinfo, type, amlbigs, amlXmlPath
				+ fileName, nowdates, oldpostdate.toString());
		if (flag) {
			ZipUtil.toZipOneFile(amlXmlPath + fileName, downPathAndFileName, "");
			download.setFileName(downPathAndFileName);
			download.setFileDesc(zipName);
			download.setAbsolutePath(true);
			download.setFlag(true);

			// 更新AML上报数据的状态
			for (AmlBigAmount amlBigAmount : amlbigs) {
				amlBigAmount.setZipfname(StringUtils.substringBetween(
						StringUtils.substringBefore(zipName, "."), "-"));
				amlBigAmount.setFilename(StringUtils.substringBefore(fileName,
						"."));
				amlBigAmount.setIsexport("1");
			}
			saveAll(amlbigs);

			return 1;
		}
		return 0;

	}

	public boolean generateXML(Bankinfo bankinfo, String reporttype,
			List<AmlBigAmount> list, String generatePathAndFileName,
			String nowdates, String oldpostdate) throws Exception {
		AmlBigXmlUtil2 xmlUtil = new AmlBigXmlUtil2();
		// 正常报文//重发报文// 补报报文
		if (StringUtils.equals("N", reporttype)
				|| StringUtils.equals("R", reporttype)
				|| StringUtils.equals("A", reporttype)) {
			return xmlUtil.writeXML(reporttype, bankinfo, list,
					generatePathAndFileName, oldpostdate);
		}
		// 补正报文
		// if (StringUtils.equals("I", reporttype)) {
		// return xmlUtil.writeXMLIBH(bankinfo, list, generatePathAndFileName,
		// oldpostdate);
		// }

		// 纠错报文
		/**
		 * if (StringUtils.equals("C", reporttype)) { return
		 * xmlUtil.writeXMLCBH(bankinfo, list, generatePathAndFileName,
		 * nowdates); } // 补报报文 if (StringUtils.equals("A", reporttype)) {
		 * return xmlUtil.writeXML(bankinfo, list, generatePathAndFileName,
		 * nowdates); } // 删除报文 if (StringUtils.equals("D", reporttype)) {
		 * return xmlUtil.writeXMLDBH(bankinfo, list, generatePathAndFileName,
		 * nowdates); } // 补正报文 if (StringUtils.equals("I", reporttype)) {
		 * return xmlUtil.writeXMLIBH(bankinfo, list, generatePathAndFileName,
		 * nowdates); }
		 */
		return false;
	}

	private int getOldfilename(List<AmlBigAmount> amlbigs, String type,
			StringBuilder oldfilename, StringBuilder oldpostdate) {
		if (StringUtils.equals("R", type) || StringUtils.equals("I", type)) {
			for (AmlBigAmount amlBigAmount : amlbigs) {
				if (null == amlBigAmount.getFilename()
						|| amlBigAmount.getFilename().length() == 0
						|| amlBigAmount.getFilename().length() != 37) {
					return 4;
				}
				if (oldfilename.indexOf(amlBigAmount.getFilename()) == -1) {
					oldfilename.append(amlBigAmount.getFilename());
					if (oldfilename.length() > 38) {
						return 3;
					}
				}
				if (oldpostdate.indexOf(amlBigAmount.getZipfname()) == -1) {
					oldpostdate.append(amlBigAmount.getZipfname());
					if (oldpostdate.length() > 8) {
						return 3;
					}
				}
			}
		}
		return 1;
	}

	@Override
	public String extractAmlReport(Date reportdate, String bkid, String subbkid)
			throws ManagerException, Exception {
		return this.amlExtractServiceImpl.extractAmlReport(reportdate, bkid,
				subbkid);
	}

	public IExtractService getAmlExtractServiceImpl() {
		return amlExtractServiceImpl;
	}

	public void setAmlExtractServiceImpl(IExtractService amlExtractServiceImpl) {
		this.amlExtractServiceImpl = amlExtractServiceImpl;
	}

	@Override
	public void addTashSchdule(AmlQueryBean querybean, UserInfo user)
			throws ManagerException, Exception {
	
	}

	@Override
	public List<AmlBigAmount> getAmlBigamountByDate(Date reportdate)
			throws Exception {
		return dao.queryByWhere(AmlBigAmount.class,
				"importdate=? and isexport<>'2'", new Object[] { reportdate });
	}
	@Override
	public List<AmlBigAmount> getAmlBigamountByDate(AmlQueryBean querybean)
			throws Exception {
		String sql=generateQuerySql(querybean);
		return dao.queryByWhere(AmlBigAmount.class,sql);
	}
	@Override
	public List<AmlBigAmount> getAmlBigamountByDate(AmlQueryBean querybean,String type)
			throws Exception {
		String sql=generateQuerySql(querybean);
		sql=sql.length()<3?"isexport=? ":sql+" and isexport=?";
		return dao.queryByWhere(AmlBigAmount.class,sql,new Object[]{type});
	}

	@Override
	public String saveReportIndex(UserInfo user) {
		int size=getAmlReportIndexSize(user.getBkid(),user.getSubbkid(),"AML","BH");
		String nextindex=getNextIndex(String.valueOf(size));
		Reportindex r=new Reportindex(user.getBkid(), user.getSubbkid(), "AML", "BH", DateUtil.getCurrentDate("yyyy-MM-dd"));
		r.setFileindex(nextindex);
		save(r);
		return DateUtil.dateToStr(DateUtil.getCurrentDate("yyyy-MM-dd"),"yyyy-MM-dd")+"日期下，大额报文的ZIP批:。"+nextindex+"已经上传成功";
	}

	@Override
	public String export2Excle(List<AmlBigAmount> amlbigs, String userid)
			throws Exception {
		return ExcelExport.export(amlbigs, userid, getRootPath(),true);
		
	}

}
