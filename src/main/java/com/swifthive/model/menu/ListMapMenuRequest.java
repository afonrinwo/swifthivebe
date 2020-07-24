/**
 * 
 */
package com.swifthive.model.menu;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author Emmanuel Afonrinwo
 *
 */
public class ListMapMenuRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;

	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "functionName", nullable = false)
	private String functionName;
	
	@Column(name = "roleName", nullable = false)
	private String roleName;

	/**
	 * 
	 */
	public ListMapMenuRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param merchantId
	 * @param userName
	 * @param functionName
	 * @param roleName
	 */
	public ListMapMenuRequest(Long clientId, String merchantId, String userName, String functionName, String roleName) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.functionName = functionName;
		this.roleName = roleName;
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
}
