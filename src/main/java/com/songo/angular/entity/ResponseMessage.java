/**
 * 
 */
package com.songo.angular.entity;

/**
 * <p>decription:</p>
 * <p>date:2014年7月30日 上午11:36:56</p>
 * @author gsu·napoleon
 */
public class ResponseMessage {

	private boolean success;
	private String message;
	
	public ResponseMessage() {}
	
	public ResponseMessage(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
}
