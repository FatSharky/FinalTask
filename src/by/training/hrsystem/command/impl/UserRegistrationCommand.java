package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.CommandField;
import by.training.hrsystem.command.constant.Message;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.userexception.PasswordNotEqualsServiceException;
import by.training.hrsystem.service.exeption.userexception.UserWithThisEmailExistServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongBirthDateServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongNameServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongPasswordServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongPhoneServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSecondnameServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSkypeServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSurnameServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class UserRegistrationCommand implements Command {
	private static final Logger logger = Logger.getLogger(UserRegistrationCommand.class);

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
		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();
			HttpSession httpSession = request.getSession(true);
			userService.registration(email, password, copyPassword, surname, name, secondName, skype,
					contactPhone, birthDate, Role.APPLICNAT);
		} catch (WrongEmailServiceException e) {
			request.setAttribute(Attribute.ERROR_EMAIL, Message.WRONG_EMAIL);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (UserWithThisEmailExistServiceException e) {
			request.setAttribute(Attribute.ERROR_ALREDI_EXIST, Message.USER_ALREDY_EXIST);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongPasswordServiceException e) {
			request.setAttribute(Attribute.ERROR_PASSWORD, Message.WRONG_PASSWORD);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (PasswordNotEqualsServiceException e) {
			request.setAttribute(Attribute.ERROR_PASSWORD_NOT_EQUALS, Message.PASSWORD_NOT_EQUALS);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongSurnameServiceException e) {
			request.setAttribute(Attribute.ERROR_SURNAME, Message.WRONG_SURNAME);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongNameServiceException e) {
			request.setAttribute(Attribute.ERROR_NAME, Message.WRONG_NAME);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongSecondnameServiceException e) {
			request.setAttribute(Attribute.ERROR_SECONDNAME, Message.WRONG_SECONDNAME);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongSkypeServiceException e) {
			request.setAttribute(Attribute.ERROR_SKYPE, Message.WRONG_SKYPE);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongPhoneServiceException e) {
			request.setAttribute(Attribute.ERROR_PHONE, Message.WRONG_PHONE);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (WrongBirthDateServiceException e) {
			request.setAttribute(Attribute.ERROR_DATE, Message.WRONG_BIRHT_DATE);
			request.getRequestDispatcher(CommandField.REGISTRATION_PAGE).forward(request, response);
		} catch (ServiceException e) {
			logger.error("Something goes wrong");
		}
	}
}
