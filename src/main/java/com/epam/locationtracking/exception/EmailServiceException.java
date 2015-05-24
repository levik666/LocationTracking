package com.epam.locationtracking.exception;

public class EmailServiceException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 8641248110444013835L;

	public EmailServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmailServiceException(String message) {
        super(message);
    }
}
