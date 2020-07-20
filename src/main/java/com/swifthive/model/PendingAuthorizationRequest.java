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
	
	@Column(name = "merchantId", nullable = false)
    private String merchantId;
	
	@Column(name = "userName", nullable = false)
    private String userName;
	
	@Column(name = "status", nullable = false)
    private String status;
	
	@Column(name = "actionCall", nullable = false)
    private String actionCall;
	
	@Column(name = "actionValue", nullable = false)
    private String actionValue;
	

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
	 * @param merchantId
	 * @param userName
	 * @param status
	 * @param actionCall
	 * @param actionValue
	 */
	public PendingAuthorizationRequest(Long uniqueId, Long clientId, String merchantId, String userName, String status,
			String actionCall, String actionValue) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.status = status;
		this.actionCall = actionCall;
		this.actionValue = actionValue;
	}


	public Long getUniqueId() {
		return uniqueId;
	}


	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}


	public Long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public String getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getActionCall() {
		return actionCall;
	}


	public void setActionCall(String actionCall) {
		this.actionCall = actionCall;
	}


	public String getActionValue() {
		return actionValue;
	}


	public void setActionValue(String actionValue) {
		this.actionValue = actionValue;
	}

}
