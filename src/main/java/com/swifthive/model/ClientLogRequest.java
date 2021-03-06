/**
 * 
 */
package com.swifthive.model;

import javax.persistence.Column;

/**
 * @author emmanuel.afonrinwo
 *
 */

public class ClientLogRequest {
	
	@Column(name = "logType", nullable = false)
	private String logType;
	
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "functionCalled", nullable = false)
	private String functionCalled;
	
	@Column(name = "activity", nullable = false)
	private String activity;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "logTime", nullable = false)
	private String logTime;

	/**
	 * 
	 */
	public ClientLogRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param logType
	 * @param clientId
	 * @param merchantId
	 * @param userId
	 * @param functionCalled
	 * @param activity
	 * @param status
	 * @param message
	 * @param logTime
	 */
	public ClientLogRequest(String logType, Long clientId, String merchantId, String userName, String functionCalled,
			String activity, String status, String message, String logTime) {
		super();
		this.logType = logType;
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.functionCalled = functionCalled;
		this.activity = activity;
		this.status = status;
		this.message = message;
		this.logTime = logTime;
	}

	/**
	 * @return the logType
	 */
	public String getLogType() {
		return logType;
	}

	/**
	 * @param logType the logType to set
	 */
	public void setLogType(String logType) {
		this.logType = logType;
	}

	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the userId
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the functionCalled
	 */
	public String getFunctionCalled() {
		return functionCalled;
	}

	/**
	 * @param functionCalled the functionCalled to set
	 */
	public void setFunctionCalled(String functionCalled) {
		this.functionCalled = functionCalled;
	}

	/**
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(String activity) {
		this.activity = activity;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the logTime
	 */
	public String getLogTime() {
		return logTime;
	}

	/**
	 * @param logTime the logTime to set
	 */
	public void setLogTime(String logTime) {
		this.logTime = logTime;
	}

	
}
