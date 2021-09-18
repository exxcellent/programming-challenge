package de.exxcellent.challenge.exceptions;

/**
 * If there is a problem reading the input file, we need to handle it separately.
 * We need that also because we read the CSV files from the class loader.
 * 
 * @author Ralph Löwe <ralph.loewe@gmail.com>
 */
public class CouldNotReadInputFileException extends AppException {
	private static final long serialVersionUID = -6385263451824067383L;

	public CouldNotReadInputFileException() {
		super();
	}
	
	public CouldNotReadInputFileException(Throwable cause) {
		super(cause);
	}
}