package com.swifthive.model.role;

import javax.persistence.Column;
import javax.persistence.Id;

public class RoleRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "roleName")
	private String roleName;


	/**
	 * 
	 */
	public RoleRequest() {
		super();
	}


	public RoleRequest(Long clientId, String merchantId, String userName, String roleName) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.roleName = roleName;
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


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
}
