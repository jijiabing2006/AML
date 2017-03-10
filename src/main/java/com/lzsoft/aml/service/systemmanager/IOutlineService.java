package com.lzsoft.aml.service.systemmanager;

import com.lzsoft.aml.entity.model.OutlineAML;
import com.lzsoft.aml.entity.model.OutlineImport;
import com.lzsoft.aml.entity.model.UserInfo;
import com.lzsoft.aml.entity.model.querymodel.OutlineQueryBean;



public interface IOutlineService {


	
	OutlineAML getOutlineAml( OutlineQueryBean querybean, UserInfo user);

	void getOutlineImport(OutlineImport outlineImport,
			OutlineQueryBean querybean) throws Exception;
	

}
