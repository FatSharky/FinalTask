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
import by.training.hrsystem.service.InterviewMarkService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class AddMarkCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("AddMarkCommand:execute() start");
		String skill = request.getParameter(Attribute.INTERVIEW_SKILL);
		String mark = request.getParameter(Attribute.INTERVIEW_MARK);
		String idInterview = request.getParameter(Attribute.ID_INTERVIEW);

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			InterviewMarkService interviewMarkService = serviceFactory.getInterviewMarkService();
			interviewMarkService.addMark(skill, mark, idInterview);
			HttpSession session = request.getSession(true);
			String prevQuery = (String) session.getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
