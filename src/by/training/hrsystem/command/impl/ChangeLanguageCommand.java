package by.training.hrsystem.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.CommandField;

public class ChangeLanguageCommand implements Command {
	private ArrayList<String> availableLanguages = new ArrayList<>();
	private static final String ENGLISH = "EN";
	private static final String RUSSIAN = "RU";

	public ChangeLanguageCommand() {
		availableLanguages.add(ENGLISH);
		availableLanguages.add(RUSSIAN);
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String lang = request.getParameter(CommandField.CHANGE_LANGUAGE_PARAMETER);

		HttpSession session = request.getSession(true);
		if (lang != null) {
			if (!availableLanguages.contains(lang)) {
				lang = RUSSIAN;
			}

			session.setAttribute(CommandField.SESSION_LANGUAGE, lang);
		}

		String prevQuery = (String) session.getAttribute(CommandField.SESSION_PREV_QUERY);
		if (prevQuery == null) {
			prevQuery = CommandField.WELCOME_PAGE;
		}
		response.sendRedirect(prevQuery);
	}

}
