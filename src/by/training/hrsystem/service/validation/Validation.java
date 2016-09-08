package by.training.hrsystem.service.validation;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {
	private Validation() {

	}

	private static final String EMAIL_PATTERN = "^[A-Za-z0-9\\-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}$";
	private static final String PASSWORD_PATTERN = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
	private static final String FIFTEEM_LETTERS_PATTERN = "^[�-��-߸�a-zA-Z\\-]{1,15}$";
	private static final String PHONE_PATTERN = "\\d{7}";
	private static final String COURSE_PATTER = "[0-5]{1}";
	private static final String DATE_FULL_PATTERN = "(19|20)\\d\\d-((0[1-9]|1[012])-(0[1-9]|[12]\\d)|(0[13-9]|1[012])-30|(0[13578]|1[02])-31)";
	private static final String DATE_SHORT = "\\d{5}";
	private static final String SALARY_PATTERN = "[0-9]{0,15}";
	private static final String TEXT_PATTERN = "^[�-��-߸�a-zA-Z0-9]+$";
	private static final String DATE_TIME_PATTERN = "^[\\d]{4}-[\\d]{2}-[\\d]{2} [\\d]{2}:[\\d]{2}:[\\d]{2}$";

	private static boolean checkStringField(String patternStr, String field) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(field);
		return matcher.matches();
	}

	public static boolean validateEmail(String email) {
		return checkStringField(EMAIL_PATTERN, email);
	}

	public static boolean validatePassword(String password) {
		return checkStringField(PASSWORD_PATTERN, password);
	}

	public static boolean validateStringField(String value) {
		return checkStringField(FIFTEEM_LETTERS_PATTERN, value);
	}

	public static boolean validatePhoneField(String value) {
		return checkStringField(PHONE_PATTERN, value);
	}

	public static boolean validateFullDateField(String value) {
		return checkStringField(DATE_FULL_PATTERN, value);

	}

	public static boolean validateShortDateField(String value) {
		return checkStringField(DATE_SHORT, value);
	}

	public static boolean validateCourseField(String value) {
		return checkStringField(COURSE_PATTER, value);
	}

	public static boolean validateSalaryField(String value) {
		return checkStringField(SALARY_PATTERN, value);
	}

	public static boolean validateTextField(String value) {
		return checkStringField(TEXT_PATTERN, value);
	}

	public static boolean validateDateTime(String value) {
		return checkStringField(DATE_TIME_PATTERN, value);
	}

	public static boolean validateDate(Date checkStartDate, Date checkTillDate) {
		return checkTillDate.getTime() - checkStartDate.getTime() > 0;
	}
}
