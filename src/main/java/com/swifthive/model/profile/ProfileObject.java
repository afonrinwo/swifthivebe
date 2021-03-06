/**
 * 
 */
package com.swifthive.model.profile;

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
@Table(name = "UserProfile", uniqueConstraints={@UniqueConstraint(columnNames={"userName", "email", "mobileNumber", "merchantId"})})
public class ProfileObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5690891055617498863L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
	
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
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
	
	@Column(name = "createdBy", nullable = false)
	private String createdBy;
	
	@Column(name = "dateCreated", nullable = false)
	private LocalDateTime dateCreated;
	
	@Column(name = "status", nullable = false)
	private int status;
	
	@Column(name = "approvedClientId")
	private Long approvedClientId;
	
	@Column(name = "approvedBy")
	private String approvedBy;
	
	@Column(name = "dateApproved")
	private LocalDateTime dateApproved;

	/**
	 * 
	 */
	public ProfileObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param userName
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param mobileNumber
	 * @param functionName
	 * @param roleName
	 * @param merchantId
	 * @param createdBy
	 * @param dateCreated
	 * @param status
	 * @param approvedClientId
	 * @param approvedBy
	 * @param dateApproved
	 */
	public ProfileObject(Long uniqueId, Long clientId, String userName, String firstName, String lastName, String email,
			String mobileNumber, String functionName, String roleName, String merchantId, String createdBy,
			LocalDateTime dateCreated, int status, Long approvedClientId, String approvedBy,
			LocalDateTime dateApproved) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.functionName = functionName;
		this.roleName = roleName;
		this.merchantId = merchantId;
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
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
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
