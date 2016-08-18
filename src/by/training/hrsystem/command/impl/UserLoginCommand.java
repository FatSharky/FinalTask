package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.user.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.user.WrongPasswordServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class UserLoginCommand implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, CommandException {
		logger.debug("UserLoginCommand:execute() start");
		String email = request.getParameter(Attribute.EMAIL);
		String password = request.getParameter(Attribute.PASSWORD);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		HttpSession session = request.getSession(true);

		try {
			UserService userService = serviceFactory.getUserService();
			User user = userService.login(email, password);
			session.setAttribute(Attribute.USER, user);

			String prevQuery = (String) request.getSession(false).getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null && !prevQuery.isEmpty()) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}
		} catch (WrongEmailServiceException e) {
			request.setAttribute(Attribute.ERROR_EMAIL, true);
			String prevQuery = (String) request.getSession(false).getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null && !prevQuery.isEmpty()) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}
			logger.error("Wrong email");
		} catch (WrongPasswordServiceException e) {
			request.setAttribute(Attribute.ERROR_PASSWORD, true);
			String prevQuery = (String) request.getSession(false).getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null && !prevQuery.isEmpty()) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}
			logger.error("Wrong password");
		} catch (ServiceException e) {
			throw new CommandException(e);
		}
		logger.debug("UserLoginCommand:execute() end");
	}
}