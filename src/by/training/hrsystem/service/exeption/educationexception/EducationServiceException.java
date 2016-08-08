package by.training.hrsystem.service.exeption.educationexception;

import by.training.hrsystem.service.exeption.ServiceException;

public class EducationServiceException extends ServiceException {

	private static final long serialVersionUID = 1L;

	public EducationServiceException(String message) {
		super(message);
	}

	public EducationServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
