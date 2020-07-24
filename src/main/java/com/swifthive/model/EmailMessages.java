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
	private String userCreationApprovalHeading;
	private String userCreationApprovalMessage;
	
	
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
	 * @param userCreationApprovalHeading
	 * @param userCreationApprovalMessage
	 */
	public EmailMessages(String notificationSender, String pendingNotificationHeading,
			String pendingNotificationMessage, String approvalNotificationHeading, String approvalNotificationMessage,
			String userCreationHeading, String userCreationMessage, String passwordChangeHeading,
			String passwordChangeMessage, String userCreationApprovalHeading, String userCreationApprovalMessage) {
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
		this.userCreationApprovalHeading = userCreationApprovalHeading;
		this.userCreationApprovalMessage = userCreationApprovalMessage;
	}


	public String getNotificationSender() {
		return notificationSender;
	}


	public void setNotificationSender(String notificationSender) {
		this.notificationSender = notificationSender;
	}


	public String getPendingNotificationHeading() {
		return pendingNotificationHeading;
	}


	public void setPendingNotificationHeading(String pendingNotificationHeading) {
		this.pendingNotificationHeading = pendingNotificationHeading;
	}


	public String getPendingNotificationMessage() {
		return pendingNotificationMessage;
	}


	public void setPendingNotificationMessage(String pendingNotificationMessage) {
		this.pendingNotificationMessage = pendingNotificationMessage;
	}


	public String getApprovalNotificationHeading() {
		return approvalNotificationHeading;
	}


	public void setApprovalNotificationHeading(String approvalNotificationHeading) {
		this.approvalNotificationHeading = approvalNotificationHeading;
	}


	public String getApprovalNotificationMessage() {
		return approvalNotificationMessage;
	}


	public void setApprovalNotificationMessage(String approvalNotificationMessage) {
		this.approvalNotificationMessage = approvalNotificationMessage;
	}


	public String getUserCreationHeading() {
		return userCreationHeading;
	}


	public void setUserCreationHeading(String userCreationHeading) {
		this.userCreationHeading = userCreationHeading;
	}


	public String getUserCreationMessage() {
		return userCreationMessage;
	}


	public void setUserCreationMessage(String userCreationMessage) {
		this.userCreationMessage = userCreationMessage;
	}


	public String getPasswordChangeHeading() {
		return passwordChangeHeading;
	}


	public void setPasswordChangeHeading(String passwordChangeHeading) {
		this.passwordChangeHeading = passwordChangeHeading;
	}


	public String getPasswordChangeMessage() {
		return passwordChangeMessage;
	}


	public void setPasswordChangeMessage(String passwordChangeMessage) {
		this.passwordChangeMessage = passwordChangeMessage;
	}


	public String getUserCreationApprovalHeading() {
		return userCreationApprovalHeading;
	}


	public void setUserCreationApprovalHeading(String userCreationApprovalHeading) {
		this.userCreationApprovalHeading = userCreationApprovalHeading;
	}


	public String getUserCreationApprovalMessage() {
		return userCreationApprovalMessage;
	}


	public void setUserCreationApprovalMessage(String userCreationApprovalMessage) {
		this.userCreationApprovalMessage = userCreationApprovalMessage;
	}
	
	
}
