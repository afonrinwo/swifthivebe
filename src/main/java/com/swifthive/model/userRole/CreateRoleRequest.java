package com.swifthive.model.userRole;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreateRoleRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "roleName", nullable = false)
	private String roleName;
	
	@Column(name = "userId", nullable = false)
	private String userId;

	/**
	 * 
	 */
	public CreateRoleRequest() {
		super();
	}

	/**
	 * @param clientId
	 * @param functionName
	 * @param userId
	 */
	public CreateRoleRequest(Long clientId, String roleName, String userId) {
		super();
		this.clientId = clientId;
		this.roleName = roleName;
		this.userId = userId;
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
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
