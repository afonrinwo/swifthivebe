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
	
	@Column(name = "functionName", nullable = false)
	private String functionName;
	
	@Column(name = "roleName", nullable = false)
	private String roleName;
	
	@Column(name = "selectedMenuList", nullable = false)
	private String selectedMenuList;
	
	@Column(name = "userId", nullable = false)
	private String userId;

	

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
	 * @param userId
	 */
	public MapMenuRequest(Long clientId, String functionName, String roleName, String selectedMenuList,
			String userId) {
		super();
		this.clientId = clientId;
		this.functionName = functionName;
		this.roleName = roleName;
		this.selectedMenuList = selectedMenuList;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
}
