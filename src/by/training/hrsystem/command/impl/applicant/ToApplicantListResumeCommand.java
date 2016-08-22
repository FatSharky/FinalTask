package by.training.hrsystem.command.impl.applicant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.command.util.QueryUtil;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.ListResumeIsEmptyServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class ToApplicantListResumeCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("ToApplicantListResume:execute() start");

		User user = (User) request.getSession().getAttribute(Attribute.USER);
		if (user != null && user.getRole() == Role.APPLICANT) {

			User applicant = (User) request.getSession().getAttribute(Attribute.USER);
			String lang = (String) request.getSession().getAttribute(Attribute.LOCALE);

			try {
				ServiceFactory serviceFactory = ServiceFactory.getInstance();
				ResumeService resumeService = serviceFactory.getResumeService();
				List<Resume> resumeList = resumeService.selectResumeByEmail(applicant.getEmail(), lang);
				request.setAttribute(Attribute.LIST_RESUME_BY_EMAIL, resumeList);
				request.getRequestDispatcher(PageName.APPLICANT_LIST_RESUME_PAGE).forward(request, response);
				QueryUtil.saveHttpQuery(request);
			} catch (ListResumeIsEmptyServiceException e) {
				request.setAttribute(Attribute.LIST_RESUME_EMPTY, true);
				request.getRequestDispatcher(PageName.APPLICANT_LIST_RESUME_PAGE).forward(request, response);
				logger.error("wrong resume name");
			} catch (ServiceException e) {
				throw new CommandException("Command layer");
			}
		} else {
			request.getRequestDispatcher(PageName.ERROR_ACCESS_PAGE).forward(request, response);
		}
		logger.debug("ViewApplicantResume:execute() end");
	}

}
