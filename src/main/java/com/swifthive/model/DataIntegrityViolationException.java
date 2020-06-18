/**
 * 
 */
package com.swifthive.model;

/**
 * @author emmanuel.afonrinwo
 *
 */
public class DataIntegrityViolationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8312347785057433665L;
	private String status;

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

}
