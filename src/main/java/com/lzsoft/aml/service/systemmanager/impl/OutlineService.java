package com.lzsoft.aml.service.systemmanager.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.configuration.PropertiesConfiguration;

import com.lzsoft.aml.common.Constants;

import com.lzsoft.aml.entity.model.AmlBigAmount;
import com.lzsoft.aml.entity.model.OutlineAML;
import com.lzsoft.aml.entity.model.OutlineImport;
import com.lzsoft.aml.entity.model.TaskSchedule;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.OutlineQueryBean;
import com.lzsoft.aml.service.BaseService;
import com.lzsoft.aml.service.systemmanager.IOutlineService;
import com.lzsoft.aml.util.DateUtil;

@ManagedBean(name = "outlineService")
@ViewScoped
public class OutlineService extends BaseService implements IOutlineService {

	@Override
	public void getOutlineImport(OutlineImport outlineImport,
			OutlineQueryBean querybean) throws Exception {
		Date maxIfxImportdate = (Date) dao.getMaxByWhere(TaskSchedule.class,
				"importdate", "", new Object[] {});
		String ifxImportdate = DateUtil.dateToStr(maxIfxImportdate, Constants.DATEFORMAT);
		outlineImport.setLastifximportdate(ifxImportdate);
		// TODO  修改导数提醒
		PropertiesConfiguration pc = new PropertiesConfiguration("");
				//com.lzsoft.aml.autoimport.commons.Constants.DATA_FILES_PATH);
		String sourcePath = pc.getString("sourcepath");
		String msg = "";
		File pbcdir = new File(sourcePath.toString());
		File[] datedirs = pbcdir.listFiles();
		if (null != datedirs && datedirs.length != 0) {
			File datedir = datedirs[0];
			String datestr = datedir.getName();
			msg = "营业日期为:" + datestr
					+ "的源文件还没有导入，请等待或者与IT联系。待数据正常导入后，再进行报表上报工作。";
			outlineImport.setImportmessage(msg);

		} else {
			msg = "未发现。";
			outlineImport.setImportmessage(msg);

			TaskSchedule task = queryTaskSchedule(maxIfxImportdate,
					"autoExtractAcc");
			if (null != task) {
				if (task.isExecutable()) {
					outlineImport.setAccextractstate("营业日期为:" + ifxImportdate
							+ "的ACC数据还没有提取过，请等待系统自动提取或者选择手工提取后，再继续后续工作。");
				} else {
					outlineImport.setAccextractstate("营业日期为:" + ifxImportdate
							+ "的ACC数据已经提取过。");
				}
			}
			task = queryTaskSchedule(maxIfxImportdate, "autoExtractBop");
			if (null != task) {
				if (task.isExecutable()) {
					outlineImport.setBopextractstate("营业日期为:" + ifxImportdate
							+ "的BOP数据还没有提取过，请等待系统自动提取或者选择手工提取后，再继续后续工作。");
				} else {
					outlineImport.setBopextractstate("营业日期为:" + ifxImportdate
							+ "的BOP数据已经提取过。");
				}
			}
			task = queryTaskSchedule(maxIfxImportdate, "autoExtractJsh");
			if (null != task) {
				if (task.isExecutable()) {
					outlineImport.setJshextractstate("营业日期为:" + ifxImportdate
							+ "的JSH数据还没有提取过，请等待系统自动提取或者选择手工提取后，再继续后续工作。");
				} else {
					outlineImport.setJshextractstate("营业日期为:" + ifxImportdate
							+ "的JSH数据已经提取过。");
				}
			}
		}

		long countSuspiciousDeals = dao.getCountByWhere(TaskSchedule.class,
				"importdate=? and  taskname='hasSuspicious' ",
				new Object[] { maxIfxImportdate });
		if (countSuspiciousDeals > 0) {
			outlineImport.setHasexceptiondeal("1");
		} else {
			outlineImport.setHasexceptiondeal(null);
		}

	}

	/**
	 * 根据传入日期，返回taskSchedule
	 * 
	 * @param maxImportdate
	 * @return
	 */
	private TaskSchedule queryTaskSchedule(Date maxImportdate, String taskname) {
		return dao.findByWhere(TaskSchedule.class,
				" importdate=? and taskname=?", new Object[] { maxImportdate,
						taskname });

	}


	@Override
	public OutlineAML getOutlineAml(
			OutlineQueryBean querybean, UserInfo user) {
		Date maxImportdate = null;
		if (null != querybean.getImportdate()) {
			maxImportdate = querybean.getImportdate();
		} else {
			maxImportdate = (Date) dao.getMaxByWhere(TaskSchedule.class,
					"importdate", "", new Object[] {});

		}
	
		
		
		OutlineAML outlineaml=new OutlineAML();
		if(null!=maxImportdate){
			outlineaml.setImportdate(DateUtil.dateToStr(maxImportdate,
					Constants.DATEFORMAT));
			String sql = "";
			Object[] parma = null;
			sql = "importdate=?";
			parma = new Object[] { maxImportdate };
			// }
			List<AmlBigAmount> abs = dao.queryByWhere(AmlBigAmount.class, sql,
					parma);

			Map<String, List<AmlBigAmount>> ams = new HashMap<String, List<AmlBigAmount>>();
			List<AmlBigAmount> amt = null;
			for (AmlBigAmount a : abs) {
				if (null == ams.get(a.getSubbkid())) {
					amt = new ArrayList<AmlBigAmount>();
					amt.add(a);
					ams.put(a.getSubbkid(), amt);
				} else {
					ams.get(a.getSubbkid()).add(a);
				}
			}
	        defalutAmlOutline();
			setAmlOutline(outlineaml, ams);
		}
		
		return outlineaml;

	}

	private void defalutAmlOutline() {
		
	}

	private void setAmlOutline(OutlineAML outlineaml,
			Map<String, List<AmlBigAmount>> ams) {
		Set<String> keys = ams.keySet();
		for (String key : keys) {
			setAmlOutline(outlineaml, ams.get(key), key);
		}
	}

	private void setAmlOutline(OutlineAML outlineAml, List<AmlBigAmount> list,
			String key) {

		int cNum = 0;
		int editNum = 0;
		int vNum = 0;
		int unvNum = 0;
		int exNum = 0;
		int unexNum = 0;
		cNum = list.size();
		AmlBigAmount aml;
		for (Object obj : list) {
			aml = (AmlBigAmount) obj;
			if ("1".equals(aml.getIsedit())) {
				editNum++;
			}
			if ("1".equals(aml.getIsvalidation())) {
				vNum++;
			}
			if ("0".equals(aml.getIsvalidation())
					&& "1".equals(aml.getIsedit())) {
				unvNum++;
			}
			if ("1".equals(aml.getIsexport())) {
				exNum++;
			}
			if ("2".equals(aml.getIsexport())) {
				unexNum++;
			}
		}
		if ("606".equals(key)) {
			outlineAml.setCounts606(String.valueOf(cNum));
			if (cNum > 0) {
				outlineAml.setEditnum606(editNum > 0 ? String.valueOf(editNum)
						: "");
				outlineAml.setUneditnum606(cNum - editNum > 0 ? String
						.valueOf(cNum - editNum) : "");
				outlineAml.setVnum606(vNum > 0 ? String.valueOf(vNum) : "");
				outlineAml.setUnvnum606(unvNum > 0 ? String.valueOf(unvNum)
						: "");
				outlineAml.setExportnum606(exNum > 0 ? String.valueOf(exNum)
						: "");
				outlineAml.setUnexportnum606(unexNum > 0 ? String
						.valueOf(unexNum) : "");
			}
		} else if ("607".equals(key)) {
			outlineAml.setCounts607(String.valueOf(cNum));
			if (cNum > 0) {
				outlineAml.setEditnum607(editNum > 0 ? String.valueOf(editNum)
						: "");
				outlineAml.setUneditnum607(cNum - editNum > 0 ? String
						.valueOf(cNum - editNum) : "");
				outlineAml.setVnum607(vNum > 0 ? String.valueOf(vNum) : "");
				outlineAml.setUnvnum607(unvNum > 0 ? String.valueOf(unvNum)
						: "");
				outlineAml.setExportnum607(exNum > 0 ? String.valueOf(exNum)
						: "");
				outlineAml.setUnexportnum607(unexNum > 0 ? String
						.valueOf(unexNum) : "");
			}
		} else if ("609".equals(key)) {
			outlineAml.setCounts609(String.valueOf(cNum));
			if (cNum > 0) {
				outlineAml.setEditnum609(editNum > 0 ? String.valueOf(editNum)
						: "");
				outlineAml.setUneditnum609(cNum - editNum > 0 ? String
						.valueOf(cNum - editNum) : "");
				outlineAml.setVnum609(vNum > 0 ? String.valueOf(vNum) : "");
				outlineAml.setUnvnum609(unvNum > 0 ? String.valueOf(unvNum)
						: "");
				outlineAml.setExportnum609(exNum > 0 ? String.valueOf(exNum)
						: "");
				outlineAml.setUnexportnum609(unexNum > 0 ? String
						.valueOf(unexNum) : "");
			}
		} else if ("608".equals(key)) {
			outlineAml.setCounts608(String.valueOf(cNum));
			if (cNum > 0) {
				outlineAml.setEditnum608(editNum > 0 ? String.valueOf(editNum)
						: "");
				outlineAml.setUneditnum608(cNum - editNum > 0 ? String
						.valueOf(cNum - editNum) : "");
				outlineAml.setVnum608(vNum > 0 ? String.valueOf(vNum) : "");
				outlineAml.setUnvnum608(unvNum > 0 ? String.valueOf(unvNum)
						: "");
				outlineAml.setExportnum608(exNum > 0 ? String.valueOf(exNum)
						: "");
				outlineAml.setUnexportnum608(unexNum > 0 ? String
						.valueOf(unexNum) : "");
			}
		}
	}


}
