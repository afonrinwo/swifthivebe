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
public class ProfileRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "userId", nullable = false)
	private String userId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;
	
	@Column(name = "functionName", nullable = false)
	private String functionName;
	
	@Column(name = "roleName", nullable = false)
	private String roleName;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;

	/**
	 * 
	 */
	public ProfileRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param userId
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNumber
	 * @param functionName
	 * @param roleName
	 * @param merchantId
	 */
	public ProfileRequest(Long clientId, String userId, String userName, String firstName, String lastName,
			String email, String mobileNumber, String functionName, String roleName, String merchantId) {
		super();
		this.clientId = clientId;
		this.userId = userId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.functionName = functionName;
		this.roleName = roleName;
		this.merchantId = merchantId;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
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

	
}
