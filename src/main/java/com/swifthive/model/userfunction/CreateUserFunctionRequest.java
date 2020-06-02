package com.swifthive.model.userfunction;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreateUserFunctionRequest {

	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "functionName", nullable = false)
	private String functionName;
	
	@Column(name = "userId", nullable = false)
	private String userId;
	

		
	/**
	 * 
	 */
	public CreateUserFunctionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param clientId
	 * @param functionName
	 * @param userId
	 */
	public CreateUserFunctionRequest(Long clientId, String functionName, String userId) {
		super();
		this.clientId = clientId;
		this.functionName = functionName;
		this.userId = userId;
	}
	
	

	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientRequestId the clientRequestId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the functionName
	 */
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * @param functionName the functionName to set
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
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
