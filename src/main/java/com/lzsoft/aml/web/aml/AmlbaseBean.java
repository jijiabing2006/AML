package com.lzsoft.aml.web.aml;

import java.math.BigDecimal;

import org.apache.commons.beanutils.PropertyUtils;

import com.lzsoft.aml.entity.base.BaseEO;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.web.BaseBean;

public class AmlbaseBean extends BaseBean {

	public AmlbaseBean() {
		super();
	}

	protected <T extends BaseEO> void setAmountDefaults(T entity)
			throws ManagerException, Exception {

		
		if (null != PropertyUtils.getProperty(entity, "crat")
				&& PropertyUtils.getProperty(entity, "crat").equals(
						new BigDecimal(0))) {
			PropertyUtils.setProperty(entity, "crat", null);
		}

	}

	/**
	 * User进行更新保存时，对数据状态进行变动更新
	 * @param entity
	 * @throws ManagerException
	 * @throws Exception
	 */
	protected <T extends BaseEO> void setDefalutValueForUpdate(T entity)throws ManagerException, Exception {
		
			PropertyUtils.setProperty(entity, "isedit", "1");
			PropertyUtils.setProperty(entity, "isvalidation", "0");
//			if(!"2".equals(PropertyUtils.getProperty(entity, "isexport" ))){
//				PropertyUtils.setProperty(entity, "isexport", "0");	
//			}
			PropertyUtils.setProperty(entity, "isinpboc", "0");
	}
}