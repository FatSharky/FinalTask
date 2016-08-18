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
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.WrongResumeNameServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class AddResumeCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("addResumeCommand:execute() start");

		User applicant = (User) request.getSession().getAttribute(Attribute.USER);

		String resumeName = request.getParameter(Attribute.RESUME_NAME);
		String resumeMilitary = request.getParameter(Attribute.RESUME_MILITARY);

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ResumeService resumeService = serviceFactory.getResumeService();
			resumeService.addResume(resumeName, resumeMilitary, applicant.getEmail());
			request.setAttribute(Attribute.ADD_RESUME_SUCCESS, true);
			request.getRequestDispatcher(PageName.APPLICANT_ADD_RESUME_PAGE).forward(request, response);
		} catch (WrongResumeNameServiceException e) {
			request.setAttribute(Attribute.ERROR_RESUME_NAME, true);
			request.getRequestDispatcher(PageName.APPLICANT_ADD_RESUME_PAGE).forward(request, response);
			logger.error("wrong resume name");
		} catch (ServiceException e) {
			throw new CommandException("Command layer");
		}

		logger.debug("addResumeCommand:execute() end");
	}

}
