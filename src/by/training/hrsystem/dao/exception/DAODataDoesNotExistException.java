package by.training.hrsystem.dao.exception;

public class DAODataDoesNotExistException extends Exception {

	private static final long serialVersionUID = 1L;

	public DAODataDoesNotExistException(String message) {
		super(message);
	}

	public DAODataDoesNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
}
