/**
 * 
 */
package com.swifthive.model;

import javax.persistence.Column;

/**
 * @author emmanuel.afonrinwo
 *
 */
public class PendingAuthorizationRequest {
	
	@Column(name = "uniqueId", nullable = false)
    private Long uniqueId;
	
	@Column(name = "clientId", nullable = false)
    private Long clientId;
	
	@Column(name = "status", nullable = false)
    private String status;
	
	@Column(name = "actionCall", nullable = false)
    private String actionCall;
	
	@Column(name = "actionValue", nullable = false)
    private String actionValue;
	
	@Column(name = "userId", nullable = false)
    private String userId;

	/**
	 * 
	 */
	public PendingAuthorizationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param status
	 * @param actionCall
	 * @param actionValue
	 * @param userId
	 */
	public PendingAuthorizationRequest(Long uniqueId, Long clientId, String status, String actionCall,
			String actionValue, String userId) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.status = status;
		this.actionCall = actionCall;
		this.actionValue = actionValue;
		this.userId = userId;
	}

	/**
	 * @return the uniqueId
	 */
	public Long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
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
	 * @return the actionCall
	 */
	public String getActionCall() {
		return actionCall;
	}

	/**
	 * @param actionCall the actionCall to set
	 */
	public void setActionCall(String actionCall) {
		this.actionCall = actionCall;
	}

	/**
	 * @return the actionValue
	 */
	public String getActionValue() {
		return actionValue;
	}

	/**
	 * @param actionValue the actionValue to set
	 */
	public void setActionValue(String actionValue) {
		this.actionValue = actionValue;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	
}
