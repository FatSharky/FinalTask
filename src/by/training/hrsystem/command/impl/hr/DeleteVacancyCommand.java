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
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.VacancyService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class DeleteVacancyCommand implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("delteteVacancyCommand:execute() start");
		int vacancyId = Integer.parseInt(request.getParameter(Attribute.ID_VACANCY));
		User user = (User) request.getSession().getAttribute(Attribute.USER);

		if (user != null) {

			if (user.getRole() == Role.HR) {
				ServiceFactory serviceFactory = ServiceFactory.getInstance();
				VacancyService vacancyService = serviceFactory.getVacancyService();
				try {
					vacancyService.deleteVacancy(vacancyId);
				} catch (ServiceException e) {

				}
			}
			HttpSession session = request.getSession(true);
			String prevQuery = (String) session.getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PageName.ERROR_ACCESS_PAGE).forward(request, response);
		}

		logger.debug("deleteVacancyCommand:execute() stop");
	}
}
