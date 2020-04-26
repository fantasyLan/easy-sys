/**
 * EasyApplicationException.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.core.exception;

/**
 * @author Fantasy Lan
 * @since 2019年12月4日 : 下午10:39:00
 */
public class EasyApplicationException extends Exception {

	private String errorCode;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public EasyApplicationException() {
		super();
	}
	
	/**
	 * 
	 */
	public EasyApplicationException(String errorCode) {
		super(errorCode);
		this.errorCode = errorCode;
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
	
}
