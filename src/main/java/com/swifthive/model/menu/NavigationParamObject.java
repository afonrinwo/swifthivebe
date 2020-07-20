/**
 * 
 */
package com.swifthive.model.menu;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@Entity
@Table(name = "NavigationParam", uniqueConstraints = @UniqueConstraint(columnNames= {"navItem", "navIcon", "navText"}))
public class NavigationParamObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6689618261844033987L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;

	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "navItem", nullable = false)
	private String navItem;
	
	@Column(name = "navIcon", nullable = false)
	private String navIcon;
	
	@Column(name = "navText", nullable = false)
	private String navText;
	
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	
	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "approvedClientId")
	private Long approvedClientId;
	
	@Column(name = "approvedBy")
	private String approvedBy;
	
	@Column(name = "dateApproved")
	private LocalDateTime dateApproved;

	/**
	 * 
	 */
	public NavigationParamObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param merchantId
	 * @param navItem
	 * @param navIcon
	 * @param navText
	 * @param createdBy
	 * @param dateCreated
	 * @param status
	 * @param approvedClientId
	 * @param approvedBy
	 * @param dateApproved
	 */
	public NavigationParamObject(Long uniqueId, Long clientId, String merchantId, String navItem, String navIcon,
			String navText, String createdBy, LocalDateTime dateCreated, String status, Long approvedClientId,
			String approvedBy, LocalDateTime dateApproved) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.merchantId = merchantId;
		this.navItem = navItem;
		this.navIcon = navIcon;
		this.navText = navText;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
		this.status = status;
		this.approvedClientId = approvedClientId;
		this.approvedBy = approvedBy;
		this.dateApproved = dateApproved;
	}

	/**
	 * @return the uniqueId
	 */
	public Long getUniqueId() {
		return uniqueId;
	}

	/**
	 * @param uniqueId the uniqueId to set
	 */
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
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

	/**
	 * @return the navText
	 */
	public String getNavText() {
		return navText;
	}

	/**
	 * @param navText the navText to set
	 */
	public void setNavText(String navText) {
		this.navText = navText;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the dateCreated
	 */
	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the approvedClientId
	 */
	public Long getApprovedClientId() {
		return approvedClientId;
	}

	/**
	 * @param approvedClientId the approvedClientId to set
	 */
	public void setApprovedClientId(Long approvedClientId) {
		this.approvedClientId = approvedClientId;
	}

	/**
	 * @return the approvedBy
	 */
	public String getApprovedBy() {
		return approvedBy;
	}

	/**
	 * @param approvedBy the approvedBy to set
	 */
	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	/**
	 * @return the dateApproved
	 */
	public LocalDateTime getDateApproved() {
		return dateApproved;
	}

	/**
	 * @param dateApproved the dateApproved to set
	 */
	public void setDateApproved(LocalDateTime dateApproved) {
		this.dateApproved = dateApproved;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
