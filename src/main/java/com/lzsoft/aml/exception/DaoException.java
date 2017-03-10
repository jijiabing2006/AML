/*
 * @(#)DaoException.java 1.00, Nov 27, 2007 9:10:24 AM.
 *
 * 
 */
package com.lzsoft.aml.exception;

/**
 * 
 * @author Lawrence
 *
 */
public class DaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DaoException(){
		
	}
	
	public DaoException(String message){
		super(message);
	}
	
	public DaoException(Throwable cause){
		super(cause);
	}
	
}
