package de.exxcellent.challenge.exceptions;

/**
 * A general exception for the case that all application 
 * specific exceptions need to be caught.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class AppException extends Exception {
	private static final long serialVersionUID = -179598161912985978L;
	
	public AppException() {
		super();
	}
	
	public AppException(Throwable cause) {
		super(cause);
	}
}