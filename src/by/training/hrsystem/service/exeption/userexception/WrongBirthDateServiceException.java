package by.training.hrsystem.service.exeption.userexception;

public class WrongBirthDateServiceException extends UserServiceException {

	private static final long serialVersionUID = 1L;

	public WrongBirthDateServiceException(String message) {
		super(message);
	}

	public WrongBirthDateServiceException(String message, Throwable cause) {
		super(message, cause);
	}

}
