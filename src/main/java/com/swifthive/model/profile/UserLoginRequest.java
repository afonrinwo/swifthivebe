/**
 * 
 */
package com.swifthive.model.profile;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author emmanuel.afonrinwo
 *
 */
public class UserLoginRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * 
	 */
	public UserLoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param merchantId
	 * @param userName
	 * @param password
	 */
	public UserLoginRequest(Long clientId, String merchantId, String userName, String password) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.password = password;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
