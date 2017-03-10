package com.lzsoft.aml.web.safe;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.StringUtils;

import com.lzsoft.aml.entity.base.BaseEO;
import com.lzsoft.aml.exception.ManagerException;
import com.lzsoft.aml.web.BaseBean;

public class SafebaseBean extends BaseBean {

	public SafebaseBean() {
		super();
	}
	protected <T extends BaseEO> void setCustcodOrIdcodeByIdnumber(T entity)
			throws ManagerException, Exception {
		if (StringUtils.equals(BeanUtils.getProperty(entity, "custype"),"C" )) {
			if (!StringUtils.equals(BeanUtils.getProperty(entity, "custcod"),BeanUtils.getProperty(entity, "idnumber"))) {
				BeanUtils.setProperty(entity, "custcod",
						BeanUtils.getProperty(entity, "idnumber"));
			}
		} else {
			if (!StringUtils.equals(BeanUtils.getProperty(entity, "idcode"),BeanUtils.getProperty(entity, "idnumber"))) {
				BeanUtils.setProperty(entity, "idcode",
						BeanUtils.getProperty(entity, "idnumber"));
			}
		}
	}

	protected <T extends BaseEO> void setIdnumberByCustcodeOrIdcode(T entity) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
			 {
		if (null == BeanUtils.getProperty(entity, "idnumber")
				|| "".equals(BeanUtils.getProperty(entity, "idnumber"))) {
			if (null != BeanUtils.getProperty(entity, "custcod")
					&& !"".equals(BeanUtils.getProperty(entity, "custcod"))) {
				BeanUtils.setProperty(entity, "idnumber",
						BeanUtils.getProperty(entity, "custcod"));
			} else if (null != BeanUtils.getProperty(entity, "idcode")
					&& !"".equals(BeanUtils.getProperty(entity, "idcode"))) {
				BeanUtils.setProperty(entity, "idnumber",
						BeanUtils.getProperty(entity, "idcode"));
			}
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
			PropertyUtils.setProperty(entity, "isexport", "0");
			PropertyUtils.setProperty(entity, "isinsafe", "0");
	}
}