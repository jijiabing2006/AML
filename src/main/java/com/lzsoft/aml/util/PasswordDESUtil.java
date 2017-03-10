package com.lzsoft.aml.util;

import com.lzsoft.aml.common.Constants;

public class PasswordDESUtil {
	
	private static DESUtil desutil=null;
	

	public static String getEncrypt(String password) throws Exception {
		desutil=new DESUtil(Constants.WEB_NAME);
		
		return desutil.encrypt(password);
	}
	public static String getDecrypt(String password) throws Exception {
		desutil=new DESUtil(Constants.WEB_NAME);
		
		return desutil.decrypt(password);
	}
}
