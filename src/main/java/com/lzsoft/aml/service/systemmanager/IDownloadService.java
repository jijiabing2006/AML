package com.lzsoft.aml.service.systemmanager;

import java.util.Date;

import com.lzsoft.aml.entity.model.Download;



public interface IDownloadService {

	String download(String type, Date importdate, String userid) throws Exception;

	int download(String type, Date importdate, Download download) throws Exception;

	

}
