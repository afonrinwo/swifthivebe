package com.swifthive.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("file:D:\\Workspace-spring-tool-suite\\swifthivebe\\emailMessages.properties")
public class EmailMessages {
	
	private String notificationSender;
	private String pendingNotificationHeading;
	private String pendingNotificationMessage;
	private String approvalNotificationHeading;
	private String approvalNotificationMessage;
	private String userCreationHeading;
	private String userCreationMessage;
	private String passwordChangeHeading;
	private String passwordChangeMessage;
	/**
	 * 
	 */
	public EmailMessages() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param notificationSender
	 * @param pendingNotificationHeading
	 * @param pendingNotificationMessage
	 * @param approvalNotificationHeading
	 * @param approvalNotificationMessage
	 * @param userCreationHeading
	 * @param userCreationMessage
	 * @param passwordChangeHeading
	 * @param passwordChangeMessage
	 */
	public EmailMessages(String notificationSender, String pendingNotificationHeading,
			String pendingNotificationMessage, String approvalNotificationHeading, String approvalNotificationMessage,
			String userCreationHeading, String userCreationMessage, String passwordChangeHeading,
			String passwordChangeMessage) {
		super();
		this.notificationSender = notificationSender;
		this.pendingNotificationHeading = pendingNotificationHeading;
		this.pendingNotificationMessage = pendingNotificationMessage;
		this.approvalNotificationHeading = approvalNotificationHeading;
		this.approvalNotificationMessage = approvalNotificationMessage;
		this.userCreationHeading = userCreationHeading;
		this.userCreationMessage = userCreationMessage;
		this.passwordChangeHeading = passwordChangeHeading;
		this.passwordChangeMessage = passwordChangeMessage;
	}
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
	 * @return the pendingNotificationHeading
	 */
	public String getPendingNotificationHeading() {
		return pendingNotificationHeading;
	}
	/**
	 * @param pendingNotificationHeading the pendingNotificationHeading to set
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
	/**
	 * @return the passwordChangeHeading
	 */
	public String getPasswordChangeHeading() {
		return passwordChangeHeading;
	}
	/**
	 * @param passwordChangeHeading the passwordChangeHeading to set
	 */
	public void setPasswordChangeHeading(String passwordChangeHeading) {
		this.passwordChangeHeading = passwordChangeHeading;
	}
	/**
	 * @return the passwordChangeMessage
	 */
	public String getPasswordChangeMessage() {
		return passwordChangeMessage;
	}
	/**
	 * @param passwordChangeMessage the passwordChangeMessage to set
	 */
	public void setPasswordChangeMessage(String passwordChangeMessage) {
		this.passwordChangeMessage = passwordChangeMessage;
	}
	
}
