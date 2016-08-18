package by.training.hrsystem.command.constant;

public final class Attribute {
	private Attribute() {
	}

	// FOR USER
	public static final String EMAIL = "email";
	public static final String PASSWORD = "password";
	public static final String COPY_PASSWORD = "copypassword";
	public static final String SURNAME = "surname";
	public static final String NAME = "name";
	public static final String SECOND_NAME = "secondname";
	public static final String SKYPE = "skype";
	public static final String CONTACT_PHONE = "phone";
	public static final String BIRHT_DATE = "birthDate";
	public static final String ROLE = "role";

	// FOR RESUME
	public static final String RESUME_NAME = "resumeName";
	public static final String RESUME_MILITARY = "military";

	// FOR LOCALE
	public static final String LOCALE = "locale";

	// FOR PREV_QUERY
	public static final String SESSION_PREV_QUERY = "prevQuery";
	public static final char QUERY_SEPARATOR = '?';

	// FOR VACANCY
	public static final String VACANCY_NAME = "vacancyName";
	public static final String SALARY = "salary";
	public static final String CURRENCY = "currency";
	public static final String DESCRIPTION = "description";
	public static final String CONDITIONS = "conditions";
	public static final String EMPLOYMENT_TYPE = "employmentType";

	public static final String REGISTRATION_SUCCESS = "regSuccess";
	public static final String ERROR_EMAIL = "errorEmail";
	public static final String ERROR_ALREADY_EXIST = "errorAlreadyExist";
	public static final String ERROR_PASSWORD = "errorPassword";
	public static final String ERROR_PASSWORD_NOT_EQUALS = "errorPasswordNotEquals";
	public static final String ERROR_SURNAME = "errorSurname";
	public static final String ERROR_NAME = "errorName";
	public static final String ERROR_SECONDNAME = "errorSecondname";
	public static final String ERROR_SKYPE = "errorSkype";
	public static final String ERROR_PHONE = "errorPhone";
	public static final String ERROR_DATE = "errorDate";

	public static final String ADD_RESUME_SUCCESS = "addResSuccess";
	public static final String ERROR_RESUME_NAME = "errorResumeName";

	public static final String LIST_RESUME_EMPTY = "listResumeEmpty";
	public static final String LIST_RESUME_BY_EMAIL = "listResumeByEmail";
	public static final String USER = "user";
	public static final String PREV_QUERY = "prev-query";

	public static final String ADD_VACANCY_SUCCESS = "addVacancySuccess";
	public static final String ERROR_VACANCY_NAME = "errorVacancyName";
	public static final String ERROR_SALARY = "errorSalary";
	public static final String ERROR_DESCRIPTION = "errorDescription";
	public static final String ERROR_CONDITIONS = "errorConditions";
}
