package com.swifthive.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("file:F:\\Spring Tool Workspace\\swifthivebe\\emailMessages.properties")
public class EmailMessages {
	
	private String notificationSender;
	private String pendingNotificationHeading;
	private String pendingNotificationMessage;
	private String approvalNotificationHeading;
	private String approvalNotificationMessage;
	private String userCreationHeading;
	private String userCreationMessage;
	
	
	/**
	 * @return the notificationSender
	 */
	public String getNotificationSender() {
		return notificationSender;
	}
	
	/**
	 * @param notificationSender the notificationSender to set
	 */
	public void setNotificationSender(String notificationSender) {
		this.notificationSender = notificationSender;
	}
	
	/**
	 * @return the requestNotificationHeading
	 */
	public String getPendingNotificationHeading() {
		return pendingNotificationHeading;
	}
	
	/**
	 * @param requestNotificationHeading the requestNotificationHeading to set
	 */
	public void setPendingNotificationHeading(String pendingNotificationHeading) {
		this.pendingNotificationHeading = pendingNotificationHeading;
	}
	
	/**
	 * @return the pendingNotificationMessage
	 */
	public String getPendingNotificationMessage() {
		return pendingNotificationMessage;
	}
	
	/**
	 * @param pendingNotificationMessage the pendingNotificationMessage to set
	 */
	public void setPendingNotificationMessage(String pendingNotificationMessage) {
		this.pendingNotificationMessage = pendingNotificationMessage;
	}
	
	/**
	 * @return the approvalNotificationHeading
	 */
	public String getApprovalNotificationHeading() {
		return approvalNotificationHeading;
	}
	
	/**
	 * @param approvalNotificationHeading the approvalNotificationHeading to set
	 */
	public void setApprovalNotificationHeading(String approvalNotificationHeading) {
		this.approvalNotificationHeading = approvalNotificationHeading;
	}
	
	/**
	 * @return the approvalNotificationMessage
	 */
	public String getApprovalNotificationMessage() {
		return approvalNotificationMessage;
	}
	
	/**
	 * @param approvalNotificationMessage the approvalNotificationMessage to set
	 */
	public void setApprovalNotificationMessage(String approvalNotificationMessage) {
		this.approvalNotificationMessage = approvalNotificationMessage;
	}

	/**
	 * @return the userCreationHeading
	 */
	public String getUserCreationHeading() {
		return userCreationHeading;
	}

	/**
	 * @param userCreationHeading the userCreationHeading to set
	 */
	public void setUserCreationHeading(String userCreationHeading) {
		this.userCreationHeading = userCreationHeading;
	}

	/**
	 * @return the userCreationMessage
	 */
	public String getUserCreationMessage() {
		return userCreationMessage;
	}

	/**
	 * @param userCreationMessage the userCreationMessage to set
	 */
	public void setUserCreationMessage(String userCreationMessage) {
		this.userCreationMessage = userCreationMessage;
	}

}
