/**
 * 
 */
package com.swifthive.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author emmanuel.afonrinwo
 *
 */

@Component
@ConfigurationProperties
@PropertySource("file:F:\\Spring Tool Workspace\\swifthivebe\\responseCode.properties")
public class ResponseCode {

	private String[] responseMessage;

	/**
	 * @return the codes
	 */
	public String[] getResponseMessage() {
		return responseMessage;
	}


	/**
	 * @param codes the codes to set
	 */
	public void setResponseMessage(String[] responseMessage) {
		this.responseMessage = responseMessage;
	}
	
	
}
