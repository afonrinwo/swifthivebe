package com.swifthive.model.userfunction;

import javax.persistence.Column;

public class UserFunctionResponse {
	
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "responseCode", nullable = false)
	private String responseCode;
	
	@Column(name = "responseMessage", nullable = false)
	private String responseMessage;

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param responseCode
	 * @param responseMessage
	 */
	public UserFunctionResponse(Long uniqueId, Long clientId, String responseCode, String responseMessage) {
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public UserFunctionResponse() {
		// TODO Auto-generated constructor stub
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
	 * @param clientRequestId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the responseMessage
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * @param responseMessage the responseMessage to set
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	

}
