/**
 * 
 */
package com.swifthive.model.profile;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author emmanuel.afonrinwo
 *
 */
@Entity
@Table(name = "ProfileKey", uniqueConstraints={@UniqueConstraint(columnNames={"userName", "email", "mobileNumber"})})
public class ProfileKeyObject {
	
	@Id
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
	
	@Column(name = "merchantId", nullable = false)
	private String merchantId;
	
	@Column(name = "userName", nullable = false)
	private String userName;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "mobileNumber", nullable = false)
	private String mobileNumber;

	@Column(name = "offSet", nullable = false)
	private String offSet;
	
	@Column(name = "passwordCount", nullable = false)
	private int passwordCount;
	
	@Column(name = "lastPasswordChangeDate")
	private LocalDateTime lastPasswordChangeDate;

	/**
	 * 
	 */
	public ProfileKeyObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param merchantId
	 * @param userName
	 * @param email
	 * @param mobileNumber
	 * @param offSet
	 * @param passwordCount
	 * @param lastPasswordChange
	 */
	public ProfileKeyObject(Long uniqueId, String merchantId, String userName, String email, String mobileNumber,
			String offSet, int passwordCount, LocalDateTime lastPasswordChangeDate) {
		super();
		this.uniqueId = uniqueId;
		this.merchantId = merchantId;
		this.userName = userName;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.offSet = offSet;
		this.passwordCount = passwordCount;
		this.lastPasswordChangeDate = lastPasswordChangeDate;
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
	 * @return the offSet
	 */
	public String getOffSet() {
		return offSet;
	}

	/**
	 * @param offSet the offSet to set
	 */
	public void setOffSet(String offSet) {
		this.offSet = offSet;
	}

	/**
	 * @return the pinStatus
	 */
	public int getPasswordCount() {
		return passwordCount;
	}

	/**
	 * @param pinStatus the pinStatus to set
	 */
	public void setPasswordCount(int passwordCount) {
		this.passwordCount = passwordCount;
	}

	/**
	 * @return the pinChangeDate
	 */
	public LocalDateTime getLastPasswordChangeDate() {
		return lastPasswordChangeDate;
	}

	/**
	 * @param pinChangeDate the pinChangeDate to set
	 */
	public void setLastPasswordChangeDate(LocalDateTime lastPasswordChangeDate) {
		this.lastPasswordChangeDate = lastPasswordChangeDate;
	}

}
