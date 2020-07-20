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
public class PasswordChangeRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "oldPassword", nullable = false)
	private String oldPassword;
	
	@Column(name = "newPassword", nullable = false)
	private String newPassword;

	/**
	 * 
	 */
	public PasswordChangeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param merchantId
	 * @param userName
	 * @param oldPassword
	 * @param newPassword
	 */
	public PasswordChangeRequest(Long clientId, String merchantId, String userName, String oldPassword,
			String newPassword) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.oldPassword = oldPassword;
		this.newPassword = newPassword;
	}

	/**
	 * @return the uniqueId
	 */
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param uniqueId the uniqueId to set
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
	 * @return the oldPassword
	 */
	public String getOldPassword() {
		return oldPassword;
	}

	/**
	 * @param oldPassword the oldPassword to set
	 */
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

}
