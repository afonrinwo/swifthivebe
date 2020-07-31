/**
 * 
 */
package com.swifthive.model.menu;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author emmanuel.afonrinwo
 *
 */
public class MapMenuRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4283641180301841922L;
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "functionName")
	private String functionName;
	
	@Column(name = "roleName")
	private String roleName;
	
	@Column(name = "selectedMenuList")
	private String selectedMenuList;
	
	@Column(name = "action")
	private String action;
	

	/**
	 * 
	 */
	public MapMenuRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param clientId
	 * @param functionName
	 * @param roleName
	 * @param selectedMenuList
	 * @param userName
	 * @param merchantId
	 * @param action
	 */
	public MapMenuRequest(Long clientId, String functionName, String roleName, String selectedMenuList, String userName,
			String merchantId, String action) {
		super();
		this.clientId = clientId;
		this.functionName = functionName;
		this.roleName = roleName;
		this.selectedMenuList = selectedMenuList;
		this.userName = userName;
		this.merchantId = merchantId;
		this.action = action;
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
	 * @return the selectedMenuList
	 */
	public String getSelectedMenuList() {
		return selectedMenuList;
	}


	/**
	 * @param selectedMenuList the selectedMenuList to set
	 */
	public void setSelectedMenuList(String selectedMenuList) {
		this.selectedMenuList = selectedMenuList;
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
	 * @return the action
	 */
	public String getAction() {
		return action;
	}


	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}


	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
