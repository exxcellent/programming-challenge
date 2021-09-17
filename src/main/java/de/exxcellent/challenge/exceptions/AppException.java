package de.exxcellent.challenge.exceptions;

public class AppException extends Exception {
	private static final long serialVersionUID = -179598161912985978L;
	
	public AppException() {
		super();
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}
}