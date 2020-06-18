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
@Table(name = "ClientErrorLog")
public class ClientErrorLogObject implements Serializable {
	
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
	private String userId;
	
	@Column(name = "functionCalled", nullable = false)
	private String functionCalled;
	
	@Column(name = "activity", nullable = false)
	private String activity;
	
	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "message", nullable = false)
	private String message;
	
	@Column(name = "logTime", nullable = false)
	private String logTime;
	
    @Column(name="timeStamp", nullable = false)
    private Date timeStamp = new Date();

	/**
	 * 
	 */
	public ClientErrorLogObject() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param uniqueId
	 * @param clientId
	 * @param userId
	 * @param fuctionCalled
	 * @param activity
	 * @param status
	 * @param message
	 * @param logTime
	 * @param timeStamp
	 */
	public ClientErrorLogObject(Long uniqueId, Long clientId, String userId, String functionCalled, String activity,
			String status, String message, String logTime, Date timeStamp) {
		super();
		this.uniqueId = uniqueId;
		this.clientId = clientId;
		this.userId = userId;
		this.functionCalled = functionCalled;
		this.activity = activity;
		this.status = status;
		this.message = message;
		this.logTime = logTime;
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
	 * @return the fuctionCalled
	 */
	public String getFunctionCalled() {
		return functionCalled;
	}

	/**
	 * @param fuctionCalled the fuctionCalled to set
	 */
	public void setFunctionCalled(String functionCalled) {
		this.functionCalled = functionCalled;
	}

	/**
	 * @return the activity
	 */
	public String getActivity() {
		return activity;
	}

	/**
	 * @param activity the activity to set
	 */
	public void setActivity(String activity) {
		this.activity = activity;
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
	 * @return the logTime
	 */
	public String getLogTime() {
		return logTime;
	}

	/**
	 * @param logTime the logTime to set
	 */
	public void setLogTime(String logTime) {
		this.logTime = logTime;
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
