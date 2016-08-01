package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.CommandField;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.WrongPasswordServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class UserLoginCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter(CommandField.LOGIN);
		String password = request.getParameter(CommandField.PASSWORD);

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		User user = null;
		HttpSession httpSession = request.getSession(false);
		if (httpSession != null && httpSession.getAttribute(CommandField.USER_ATTRIBUTE) != null) {
			request.getRequestDispatcher(CommandField.WELCOME_PAGE).forward(request, response);
			return;
		}
		try {
			user = userService.login(login, password);
		} catch (WrongEmailServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WrongPasswordServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		httpSession = request.getSession(true);
		httpSession.setAttribute(CommandField.USER_ATTRIBUTE, user);

	}
}