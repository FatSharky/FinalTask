package by.training.hrsystem.command.impl.hr;

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
import by.training.hrsystem.service.InterviewService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.interview.InterviewServiceException;
import by.training.hrsystem.service.exeption.interview.WrongDateInterviewServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class AddInterviewToApplicantCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("AddInterviewToApplicantCommand:execute() start");

		String interviewType = request.getParameter(Attribute.TYPE_INTERVIEW);
		String dateInterview = request.getParameter(Attribute.DATE_INTERVIEW);
		String idVerify = request.getParameter(Attribute.ID_VERIFY);

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			InterviewService interviewService = serviceFactory.getInterviewService();
			interviewService.addInterviewService(interviewType, dateInterview, idVerify);
			HttpSession session = request.getSession(true);
			String prevQuery = (String) session.getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}
		} catch (WrongDateInterviewServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterviewServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
