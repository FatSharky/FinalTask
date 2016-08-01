package by.training.hrsystem.command.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.training.hrsystem.command.constant.CommandField;

public class QueryUtill {
	
	public static void saveCurrentQueryToSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);

		String requestURI = request.getRequestURI();
		String queryString = request.getQueryString();

		if (queryString == null) {
			session.setAttribute(CommandField.SESSION_PREV_QUERY, requestURI);
		} else {
			session.setAttribute(CommandField.SESSION_PREV_QUERY,
					requestURI + CommandField.QUERY_SEPARATOR + queryString);
		}
	}
}
