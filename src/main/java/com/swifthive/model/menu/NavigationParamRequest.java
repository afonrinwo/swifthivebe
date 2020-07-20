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
public class NavigationParamRequest {
	
	@Id
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "navItem", nullable = false)
	private String navItem;
	
	@Column(name = "navIcon", nullable = false)
	private String navIcon;
	
	@Column(name = "navText", nullable = false)
	private String navText;

	public NavigationParamRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param clientId
	 * @param merchantId
	 * @param userName
	 * @param navItem
	 * @param navIcon
	 * @param navText
	 */
	public NavigationParamRequest(Long clientId, String merchantId, String userName, String navItem, String navIcon,
			String navText) {
		super();
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.navItem = navItem;
		this.navIcon = navIcon;
		this.navText = navText;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNavItem() {
		return navItem;
	}

	public void setNavItem(String navItem) {
		this.navItem = navItem;
	}

	public String getNavIcon() {
		return navIcon;
	}

	public void setNavIcon(String navIcon) {
		this.navIcon = navIcon;
	}

	public String getNavText() {
		return navText;
	}

	public void setNavText(String navText) {
		this.navText = navText;
	}

}
