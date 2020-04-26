/**
 * EasyMessage.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.core.vo;

/**
 * @author Fantasy Lan
 * @since 2019年12月4日 : 下午10:47:14
 */
public class EasyMessage {

	private int code;
	private String errorCode;
	private String message;
	private Object data;
	
	private static final int SUCCESS_CODE = 20000;
	private static final int FAIL_CODE = 5000;
	
	/**
	 * 
	 */
	public EasyMessage(int code, Object data) {
		this.code = code;
		this.data = data;
	}
	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}
	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}
	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	public static EasyMessage successMessage(Object data) {
		return new EasyMessage(SUCCESS_CODE, data);
	}
	
	public static EasyMessage failMessage(String errorCode, String message, Object data) {
		EasyMessage msg =  new EasyMessage(FAIL_CODE, data);
		msg.setMessage(message);
		msg.setErrorCode(errorCode);
		return msg;
	}
	/**
	 * @param data 字符类型的返回值
	 * @return
	 */
	public static Object successStringMessage(Object data) {
		EasyMessage m = new EasyMessage(SUCCESS_CODE, data);
		if(data != null) {
			m.setMessage(data.toString());
		}
		return m;
	}
}
