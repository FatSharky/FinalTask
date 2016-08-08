package by.training.hrsystem.service.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.training.hrsystem.service.parser.exception.ParserException;

public final class Parser {

	private static final String DATE_FULL_PATTERN = "dd.MM.yyyy";
	private static final String DATE_YEAR_PATTERN = "yyyy";

	private Parser() {
	}

	private static Date parseStringtoDate(String field, String datePattern) throws ParserException {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat(datePattern);
			date = df.parse(field);
		} catch (ParseException e) {
			throw new ParserException("Can't parse string to date");
		}
		return date;
	}

	public static Date parseToFullDate(String field) throws ParserException {
		return parseStringtoDate(field, DATE_FULL_PATTERN);
	}

	public static Date parseToShorterForm(String field) throws ParserException {
		return parseStringtoDate(field, DATE_YEAR_PATTERN);
	}

	public static Integer parseStringtoInt(String field) {
		int number;
		number = Integer.parseInt(field);
		return number;

	}
}
