package by.training.hrsystem.dao.exception;

public class DataDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataDoesNotExistException(String message) {
		super(message);
	}

	public DataDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
