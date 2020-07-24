package com.swifthive.model.menu;

import javax.persistence.Column;
import javax.persistence.Id;

public class MenuRequest {

	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;

	@Column(name = "merchantId", nullable = false)
	private String merchantId;

	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "menuCategory", nullable = false)
	private String menuCategory;
	
	@Column(name = "menuName", nullable = false)
	private String menuName;
	
	@Column(name = "menuPath", nullable = false)
	private String menuPath;

	@Column(name = "menuComponent", nullable = false)
	private String menuComponent;
	
	@Column(name = "navItem", nullable = false)
	private String navItem;
	
	@Column(name = "navIcon", nullable = false)
	private String navIcon;
	

	/**
	 * 
	 */
	public MenuRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param clientId
	 * @param merchantId
	 * @param userName
	 * @param menuCategory
	 * @param menuName
	 * @param menuPath
	 * @param menuComponent
	 * @param navItem
	 * @param navIcon
	 */
	public MenuRequest(Long clientId, String merchantId, String userName, String menuCategory, String menuName,
			String menuPath, String menuComponent, String navItem, String navIcon) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.menuCategory = menuCategory;
		this.menuName = menuName;
		this.menuPath = menuPath;
		this.menuComponent = menuComponent;
		this.navItem = navItem;
		this.navIcon = navIcon;
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
	 * @return the menuCategory
	 */
	public String getMenuCategory() {
		return menuCategory;
	}


	/**
	 * @param menuCategory the menuCategory to set
	 */
	public void setMenuCategory(String menuCategory) {
		this.menuCategory = menuCategory;
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
	 * @return the menuPath
	 */
	public String getMenuPath() {
		return menuPath;
	}


	/**
	 * @param menuPath the menuPath to set
	 */
	public void setMenuPath(String menuPath) {
		this.menuPath = menuPath;
	}


	/**
	 * @return the menuComponent
	 */
	public String getMenuComponent() {
		return menuComponent;
	}


	/**
	 * @param menuComponent the menuComponent to set
	 */
	public void setMenuComponent(String menuComponent) {
		this.menuComponent = menuComponent;
	}


	/**
	 * @return the navItem
	 */
	public String getNavItem() {
		return navItem;
	}


	/**
	 * @param navItem the navItem to set
	 */
	public void setNavItem(String navItem) {
		this.navItem = navItem;
	}


	/**
	 * @return the navIcon
	 */
	public String getNavIcon() {
		return navIcon;
	}


	/**
	 * @param navIcon the navIcon to set
	 */
	public void setNavIcon(String navIcon) {
		this.navIcon = navIcon;
	}


}
