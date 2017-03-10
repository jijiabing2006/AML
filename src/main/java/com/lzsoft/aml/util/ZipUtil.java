package com.lzsoft.aml.util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lzsoft.aml.common.Constants;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.UnzipParameters;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

public class ZipUtil {


	public static File toZipOneFile(String sourceFile, String downPathAndFileName,
			String password) throws Exception {
		ZipFile zipFile = null;

		zipFile = new ZipFile(new File(downPathAndFileName));
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		// parameters.setEncryptFiles(true);
		// parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
		// parameters.setPassword("" + password);

		zipFile.addFile(new File(sourceFile), parameters);
		return zipFile.getFile();
	}
	public static File toZipBySourcePath(String sourcePath, String downPathAndFileName,
			String password,boolean hasFolders) throws Exception {
		ZipFile zipFile = null;

		zipFile = new ZipFile(new File(downPathAndFileName));
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);

		// parameters.setEncryptFiles(true);
		// parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
		// parameters.setPassword("" + password);
		File sdir = new File(sourcePath.toString());
		if (sdir.isDirectory()) {
			for (File file : sdir.listFiles()) {
				parameters.setIncludeRootFolder(false);
				if (hasFolders&&file.isDirectory()) {
					parameters.setIncludeRootFolder(true);
					zipFile.addFolder(file, parameters);	
				}
				zipFile.addFile(file, parameters);
			}
		}
		return zipFile.getFile();
	}
	public static File toZipByFolder(String sourceFile, String downPathAndFileName,
			String password) throws Exception {
		ZipFile zipFile = null;
		
		zipFile = new ZipFile(new File(downPathAndFileName));
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		
		// parameters.setEncryptFiles(true);
		// parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
		// parameters.setPassword("" + password);
		
		zipFile.addFolder(new File(sourceFile), parameters);
		return zipFile.getFile();
	}
	public static File toZipByFolderNoRootFolder(String sourceFile, String downPathAndFileName,
			String password) throws Exception {
		ZipFile zipFile = null;
		
		zipFile = new ZipFile(new File(downPathAndFileName));
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		parameters.setIncludeRootFolder(false);
		// parameters.setEncryptFiles(true);
		// parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
		// parameters.setPassword("" + password);
		
		zipFile.addFolder(new File(sourceFile), parameters);
		return zipFile.getFile();
	}
	public static File extZipByFolderNoRootFolder(String zipPathAndName, String destPath,
			String password) throws Exception {
		ZipFile zipFile = null;
		zipFile = new ZipFile(new File(zipPathAndName));
		UnzipParameters unzipParameters = new UnzipParameters();
		unzipParameters.setIgnoreAllFileAttributes(true);
		// parameters.setEncryptFiles(true);
		// parameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_STANDARD);
		// parameters.setPassword("" + password);
		 zipFile.extractAll(destPath, unzipParameters);
		return zipFile.getFile();
	}

	public static void main(String args[]) {
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("start..");
		 List<Integer> list = new ArrayList<Integer>();
		    for (int i = 1; i < 55; i++)	//55是一个动态变量 测试的时候先写死
		      list.add(i);
		   ArrayUtil.separateList(list, Constants.EXCEL_EXPORT_LINES);

		System.out.println("end..");
	}

}
