package com.swifthive.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
@PropertySource("file:F:\\Spring Tool Workspace\\swifthivebe\\emailMessages.properties")
public class EmailMessages {
	
	private String notificationSender;
	private String requestNotificationHeading;
	private String pendingNotificationMessage;
	private String approvalNotificationHeading;
	private String approvalNotificationMessage;
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
	public String getRequestNotificationHeading() {
		return requestNotificationHeading;
	}
	/**
	 * @param requestNotificationHeading the requestNotificationHeading to set
	 */
	public void setRequestNotificationHeading(String requestNotificationHeading) {
		this.requestNotificationHeading = requestNotificationHeading;
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


}
