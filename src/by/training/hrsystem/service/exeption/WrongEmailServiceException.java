package by.training.hrsystem.service.exeption;

public class WrongEmailServiceException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public WrongEmailServiceException(String message) {
		super(message);
	}

	public WrongEmailServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
