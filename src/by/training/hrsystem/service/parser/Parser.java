package by.training.hrsystem.service.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.training.hrsystem.service.parser.exception.ParserException;

public final class Parser {

	private static final String DATE_PATTERN = "dd.MM.yyyy";

	private Parser() {
	}

	public static Date parseStringtoDate(String field) throws ParserException {
		Date date = null;
		try {
			DateFormat df = new SimpleDateFormat(DATE_PATTERN);
			date = df.parse(field);
		} catch (ParseException e) {
			throw new ParserException("Can't parse string to date");
		}
		return date;
	}

	public static Integer parseStringtoInt(String field) {
		int number;
		number = Integer.parseInt(field);
		return number;

	}
}
