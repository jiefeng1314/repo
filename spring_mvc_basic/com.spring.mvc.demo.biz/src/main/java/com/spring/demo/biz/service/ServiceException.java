package com.spring.demo.biz.service;

/**
 * @author cissalc    liuxiangfei
 */
public class ServiceException extends Exception {

	/**
     * 
     */
	private static final long serialVersionUID = -8835425309459978851L;

	/**
     * 
     */
	public ServiceException() {
	}

	/**
	 * @param message
	 */
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public ServiceException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
