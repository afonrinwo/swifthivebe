package com.swifthive.model.function;

import javax.persistence.Column;
import javax.persistence.Id;

public class FunctionRequest {

	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userId", nullable = false)
	private String userId;
	
	@Column(name = "functionName", nullable = false)
	private String functionName;
		

		
	/**
	 * 
	 */
	public FunctionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FunctionRequest(Long clientId, String merchantId, String userId, String functionName) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userId = userId;
		this.functionName = functionName;
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


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFunctionName() {
		return functionName;
	}


	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

}
