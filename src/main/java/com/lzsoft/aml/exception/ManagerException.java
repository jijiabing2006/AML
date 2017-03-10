package com.lzsoft.aml.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Lawrence
 *
 */
@Service(value = "managerException")
public class ManagerException extends RuntimeException {
	/**
	 * 日志记录对象
	 */
	protected Logger log = Logger.getLogger(this.getClass());
	private static final long serialVersionUID = 1L;

	public ManagerException() {

	}

	public ManagerException(String message) {
		super(message);
	}

	public ManagerException(Throwable cause) {
		//super(cause);
		log.error(cause.getMessage());
	}
}
