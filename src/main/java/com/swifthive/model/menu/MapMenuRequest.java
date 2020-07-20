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
	
	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	

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
	 */
	public MapMenuRequest(Long clientId, String functionName, String roleName, String selectedMenuList, String userName,
			String merchantId) {
		super();
		this.clientId = clientId;
		this.functionName = functionName;
		this.roleName = roleName;
		this.selectedMenuList = selectedMenuList;
		this.userName = userName;
		this.merchantId = merchantId;
	}


	public Long getClientId() {
		return clientId;
	}


	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}


	public String getFunctionName() {
		return functionName;
	}


	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getSelectedMenuList() {
		return selectedMenuList;
	}


	public void setSelectedMenuList(String selectedMenuList) {
		this.selectedMenuList = selectedMenuList;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMerchantId() {
		return merchantId;
	}


	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
