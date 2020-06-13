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
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	
	@Column(name = "fuctionCalled", nullable = false)
	private String fuctionCalled;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "currentDateTime", nullable = false)
	private String currentDateTime;

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
	 * @param userId
	 * @param fuctionCalled
	 * @param status
	 * @param message
	 * @param currentDateTime
	 */
	public ClientLogRequest(String logType, Long clientId, Long userId, String fuctionCalled, String status,
			String message, String currentDateTime) {
		super();
		this.logType = logType;
		this.clientId = clientId;
		this.userId = userId;
		this.fuctionCalled = fuctionCalled;
		this.status = status;
		this.message = message;
		this.currentDateTime = currentDateTime;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the fuctionCalled
	 */
	public String getFuctionCalled() {
		return fuctionCalled;
	}

	/**
	 * @param fuctionCalled the fuctionCalled to set
	 */
	public void setFuctionCalled(String fuctionCalled) {
		this.fuctionCalled = fuctionCalled;
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
	 * @return the currentDateTime
	 */
	public String getCurrentDateTime() {
		return currentDateTime;
	}

	/**
	 * @param currentDateTime the currentDateTime to set
	 */
	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	
}
