package com.swifthive.model.usermenu;

import javax.persistence.Column;
import javax.persistence.Id;

public class CreateUserMenuRequest {
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "menuName", nullable = false)
	private String menuName;
	
	@Column(name = "userId", nullable = false)
	private String userId;

	/**
	 * 
	 */
	public CreateUserMenuRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param menuName
	 * @param userId
	 */
	public CreateUserMenuRequest(Long clientId, String menuName, String userId) {
		super();
		this.clientId = clientId;
		this.menuName = menuName;
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
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
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
