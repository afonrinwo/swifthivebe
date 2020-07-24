package com.swifthive.model.function;

import javax.persistence.Column;
import javax.persistence.Id;

public class FunctionRequest {

	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "functionName", nullable = false)
	private String functionName;
		

		
	/**
	 * 
	 */
	public FunctionRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public FunctionRequest(Long clientId, String merchantId, String userName, String functionName) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
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


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getFunctionName() {
		return functionName;
	}


	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

}
