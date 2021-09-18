package de.exxcellent.challenge.exceptions;

/**
 * If the arguments are not useable, this exception is thrown.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class ArgumentsNotUseableException extends AppException {
	private static final long serialVersionUID = -2616143912030359545L;
	
	public ArgumentsNotUseableException(Throwable cause) {
		super(cause);
	}
}