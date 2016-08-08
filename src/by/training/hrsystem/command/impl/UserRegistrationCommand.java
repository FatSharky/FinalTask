package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.CommandField;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class UserRegistrationCommand implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter(CommandField.EMAIL);
		String password = request.getParameter(CommandField.PASSWORD);
		String copyPassword = request.getParameter(CommandField.COPY_PASSWORD);
		String surname = request.getParameter(CommandField.SURNAME);
		String name = request.getParameter(CommandField.NAME);
		String secondName = request.getParameter(CommandField.SECOND_NAME);
		String skype = request.getParameter(CommandField.SKYPE);
		String contactPhone = request.getParameter(CommandField.CONTACT_PHONE);
		String birthDate = request.getParameter(CommandField.BIRHT_DATE);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();
		
		User user = null;
		
		HttpSession httpSession = request.getSession(false);
		
		try {
			user= userService.registration(email, password, copyPassword, surname, name, secondName, skype, contactPhone, birthDate, Role.APPLICNAT);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
