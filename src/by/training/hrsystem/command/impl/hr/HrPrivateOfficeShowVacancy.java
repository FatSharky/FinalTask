package by.training.hrsystem.command.impl.hr;

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
import by.training.hrsystem.command.util.QueryUtil;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.VacancyService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class HrPrivateOfficeShowVacancy implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("HrPrivateOfficeShowVacancy:execute() start");

		int idVacancy = Integer.valueOf(request.getParameter(Attribute.ID_VACANCY));
		String lang = (String) request.getSession().getAttribute(Attribute.LOCALE);
		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			VacancyService vacancyService = serviceFactory.getVacancyService();
			UserService userService = serviceFactory.getUserService();

			Vacancy vacnacy = vacancyService.selectVacancyById(idVacancy, lang);
			User hr = userService.selectUserByIdVacancy(idVacancy);

			request.setAttribute(Attribute.VACANCY, vacnacy);
			request.setAttribute(Attribute.HR, hr);
			request.getRequestDispatcher(PageName.HR_VACANCY_PAGE).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Command layer");
		}
		QueryUtil.saveHttpQuery(request);
		logger.debug("HrPrivateOfficeShowVacancy:execute() end");

	}

}
