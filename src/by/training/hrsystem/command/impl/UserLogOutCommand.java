package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;

public class UserLogOutCommand implements Command {

	private static final Logger LOGGER = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		LOGGER.debug("UserLogOutCommand: execute() - start");

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
			try {
				request.getRequestDispatcher(PageName.FIRST_PAGE).forward(request, response);
			} catch (IOException | ServletException ex) {
				throw new CommandException(ex);
			}
		}
		LOGGER.debug("UserLogOutCommand:: execute() - end");
	}

}
