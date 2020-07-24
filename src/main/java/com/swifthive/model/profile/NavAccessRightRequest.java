/**
 * 
 */
package com.swifthive.model.profile;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class NavAccessRightRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;

	@Column(name = "merchantId", nullable = false)
	private String merchantId;

	@Column(name = "userName", nullable = false)
	private String userName;

	/**
	 * 
	 */
	public NavAccessRightRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param merchantId
	 * @param userName
	 */
	public NavAccessRightRequest(Long clientId, String merchantId, String userName) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
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
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
