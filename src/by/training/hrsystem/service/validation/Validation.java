package by.training.hrsystem.service.validation;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Validation {
	private Validation() {

	}

	private static final String EMAIL_PATTERN = "^[A-Za-z0-9\\-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,4}$";
	private static final String PASSWORD_PATTERN = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
	private static final String FIFTEEM_LETTERS_PATTERN = "^[a-zA-Z\\-]{2,15}$";
	private static final String PHONE_PATTERN = "\\d{7}";
	private static final String DATE_PATTERN = "dd.MM.yyyy";

	private static boolean checkStringField(String patternStr, String field) {
		Pattern pattern = Pattern.compile(patternStr);
		Matcher matcher = pattern.matcher(field);
		return matcher.matches();
	}

	public static boolean validateEmail(String email) {
		return checkStringField(EMAIL_PATTERN, email);
	}

	public static boolean validatePassword(String password, String copyPass) {
		if (!password.equals(copyPass)) {
			return false;
		}

		return checkStringField(PASSWORD_PATTERN, password);
	}

	public static boolean validateStringField(String value) {
		return checkStringField(FIFTEEM_LETTERS_PATTERN, value);
	}

	public static boolean validatePhoneField(String value) {
		return checkStringField(PHONE_PATTERN, value);
	}

	public static boolean validateDateField(String value) {

		return checkStringField(DATE_PATTERN, value);

	}

	public static boolean validateDate(Date checkStartDate, Date checkTillDate) {
		return checkTillDate.getTime() - checkStartDate.getTime() > 0;
	}
}