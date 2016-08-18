package by.training.hrsystem.command.impl.applicant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.user.PasswordNotEqualsServiceException;
import by.training.hrsystem.service.exeption.user.WrongBirthDateServiceException;
import by.training.hrsystem.service.exeption.user.WrongNameServiceException;
import by.training.hrsystem.service.exeption.user.WrongPasswordServiceException;
import by.training.hrsystem.service.exeption.user.WrongPhoneServiceException;
import by.training.hrsystem.service.exeption.user.WrongSecondnameServiceException;
import by.training.hrsystem.service.exeption.user.WrongSkypeServiceException;
import by.training.hrsystem.service.exeption.user.WrongSurnameServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class ApplicantEditProfileCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {

		logger.debug("ApplicantEditProfileCommand:execute() start");

		User applicant = (User) request.getSession().getAttribute(Attribute.USER);
		String password = request.getParameter(Attribute.PASSWORD);
		String copyPassword = request.getParameter(Attribute.COPY_PASSWORD);
		String surname = request.getParameter(Attribute.SURNAME);
		String name = request.getParameter(Attribute.NAME);
		String secondName = request.getParameter(Attribute.SECOND_NAME);
		String skype = request.getParameter(Attribute.SKYPE);
		String contactPhone = request.getParameter(Attribute.CONTACT_PHONE);
		String birthDate = request.getParameter(Attribute.BIRHT_DATE);

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			UserService userService = serviceFactory.getUserService();
			userService.updateProfile(password, copyPassword, surname, name, secondName, skype, contactPhone, birthDate,
					applicant.getEmail());
			request.setAttribute(Attribute.REGISTRATION_SUCCESS, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
		} catch (WrongPasswordServiceException e) {
			request.setAttribute(Attribute.ERROR_PASSWORD, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("Wrong password");
		} catch (PasswordNotEqualsServiceException e) {
			request.setAttribute(Attribute.ERROR_PASSWORD_NOT_EQUALS, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("Passwod must be equals");
		} catch (WrongSurnameServiceException e) {
			request.setAttribute(Attribute.ERROR_SURNAME, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("Wrong surname");
		} catch (WrongNameServiceException e) {
			request.setAttribute(Attribute.ERROR_NAME, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("wrong name");
		} catch (WrongSecondnameServiceException e) {
			request.setAttribute(Attribute.ERROR_SECONDNAME, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("wrong secondname");
		} catch (WrongSkypeServiceException e) {
			request.setAttribute(Attribute.ERROR_SKYPE, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("wrong skype");
		} catch (WrongPhoneServiceException e) {
			request.setAttribute(Attribute.ERROR_PHONE, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("wrong contcat phone");
		} catch (WrongBirthDateServiceException e) {
			request.setAttribute(Attribute.ERROR_DATE, true);
			request.getRequestDispatcher(PageName.APPLICANT_EDIT_PROFILE_PAGE).forward(request, response);
			logger.error("wrong date");
		} catch (ServiceException e) {
			throw new CommandException("command layer");
		}
		logger.debug("EditProfileCommand:execute() end");
	}

}
