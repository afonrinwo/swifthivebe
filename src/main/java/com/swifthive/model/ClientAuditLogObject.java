/**
 * 
 */
package com.swifthive.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author emmanuel.afonrinwo
 *
 */

@Entity
@Table(name = "ClientAuditLog")
public class ClientAuditLogObject implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5687922067186039340L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uniqueId", nullable = false)
	private Long uniqueId;
		
	@Column(name = "clientId", nullable = false)
	private Long clientId;
	
	@Column(name = "userId", nullable = false)
	private Long userId;
	
	@Column(name = "fuctionCalled", nullable = false)
	private String fuctionCalled;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "currentDateTime", nullable = false)
	private String currentDateTime;
	
    @Column(name="timeStamp", columnDefinition = "datetime default getdate()")
    private Date timeStamp;

	/**
	 * 
	 */
	public ClientAuditLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param userId
	 * @param fuctionCalled
	 * @param status
	 * @param message
	 * @param currentDateTime
	 * @param timeStamp
	 */
	public ClientAuditLogObject(Long uniqueId, Long clientId, Long userId, String fuctionCalled, String status,
			String message, String currentDateTime, Date timeStamp) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.userId = userId;
		this.fuctionCalled = fuctionCalled;
		this.status = status;
		this.message = message;
		this.currentDateTime = currentDateTime;
		this.timeStamp = timeStamp;
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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the fuctionCalled
	 */
	public String getFuctionCalled() {
		return fuctionCalled;
	}

	/**
	 * @param fuctionCalled the fuctionCalled to set
	 */
	public void setFuctionCalled(String fuctionCalled) {
		this.fuctionCalled = fuctionCalled;
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
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the currentDateTime
	 */
	public String getCurrentDateTime() {
		return currentDateTime;
	}

	/**
	 * @param currentDateTime the currentDateTime to set
	 */
	public void setCurrentDateTime(String currentDateTime) {
		this.currentDateTime = currentDateTime;
	}

	/**
	 * @return the timeStamp
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * @param timeStamp the timeStamp to set
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
