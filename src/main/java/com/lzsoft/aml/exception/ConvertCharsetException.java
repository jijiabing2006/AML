package com.lzsoft.aml.exception;

/**
 * 
 * @author Lawrence
 *
 */
public class ConvertCharsetException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConvertCharsetException() {

	}

	public ConvertCharsetException(String message) {
		super(message);
	}

	public ConvertCharsetException(Throwable cause) {
		super(cause);
	}

}
