package by.training.hrsystem.command.impl.applicant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.CommandField;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.ListResumeIsEmptyServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class ViewApplicantResumeCommand implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("ViewApplicantResume:execute() start");

		User applicant = (User) request.getSession().getAttribute(CommandField.USER_ATTRIBUTE);
		String lang = (String) request.getSession().getAttribute(CommandField.LOCALE);

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ResumeService resumeService = serviceFactory.getResumeService();
			resumeService.selectResumeByEmail(applicant.getEmail(), lang);
			request.getRequestDispatcher(PageName.APPLICANT_LIST_RESUME_PAGE).forward(request, response);
		} catch (ListResumeIsEmptyServiceException e) {
			request.setAttribute(Attribute.LIST_RESUME_EMPTY, true);
			request.getRequestDispatcher(PageName.APPLICANT_LIST_RESUME_PAGE).forward(request, response);
			logger.error("wrong resume name");
		} catch (ServiceException e) {
			throw new CommandException("Command layer");
		}

		logger.debug("ViewApplicantResume:execute() end");
	}

}
