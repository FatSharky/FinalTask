package by.training.hrsystem.service.exeption.educationexception;


public class WrongInstitutionServiceException extends EducationServiceException {

	private static final long serialVersionUID = 1L;

	public WrongInstitutionServiceException(String message) {
		super(message);
	}

	public WrongInstitutionServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
