package com.swifthive.model.menu;

import javax.persistence.Column;
import javax.persistence.Id;

public class MenuRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userId", nullable = false)
	private String userId;
	
	@Column(name = "menuName", nullable = false)
	private String menuName;
	

	/**
	 * 
	 */
	public MenuRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MenuRequest(Long clientId, String merchantId, String userId, String menuName) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userId = userId;
		this.menuName = menuName;
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


	public String getMenuName() {
		return menuName;
	}


	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

}
