package by.training.hrsystem.command.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.training.hrsystem.command.constant.CommandField;

public class LanguageUtil {
	public static String getLanguageId(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String sessionLanguage = (session == null) ? CommandField.DEFAULT_LANGUAGE
				: (String) session.getAttribute(CommandField.SESSION_LANGUAGE);
		String lang = (sessionLanguage == null) ? CommandField.DEFAULT_LANGUAGE : sessionLanguage;
		return lang;
	}
}
