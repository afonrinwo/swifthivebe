/**
 * 
 */
package com.swifthive.model.createMenu;

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
 * @author emmanuel.afonrinwo
 *
 */
@Entity
@Table(name = "Menu", uniqueConstraints = @UniqueConstraint(columnNames= {"menuName"}))
public class CreateMenuObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9075553277449854133L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;

	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "menuName", nullable = false)
	private String menuName;
	
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	
	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "approvedBy")
	private String approvedBy;
	
	@Column(name = "dateApproved")
	private LocalDateTime dateApproved;

	/**
	 * 
	 */
	public CreateMenuObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param menuName
	 * @param createdBy
	 * @param dateCreated
	 * @param approvedBy
	 * @param dateApproved
	 */
	public CreateMenuObject(Long uniqueId, Long clientId, String menuName, String createdBy, LocalDateTime dateCreated,
			String approvedBy, LocalDateTime dateApproved) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.menuName = menuName;
		this.createdBy = createdBy;
		this.dateCreated = dateCreated;
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