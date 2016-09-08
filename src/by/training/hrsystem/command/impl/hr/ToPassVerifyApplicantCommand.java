package by.training.hrsystem.command.impl.hr;

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
import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.domain.Verify;
import by.training.hrsystem.service.VacancyService;
import by.training.hrsystem.service.VerifyService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class ToPassVerifyApplicantCommand implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("ToPassVerifyApplicantCommand:execute() start");

		int idVacancy = Integer.valueOf(request.getParameter(Attribute.ID_VACANCY));
		String lang = (String) request.getSession().getAttribute(Attribute.LOCALE);

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			VerifyService verifyService = serviceFactory.gerVerifyService();
			VacancyService vacancyService = serviceFactory.getVacancyService();
			Vacancy vacancy = vacancyService.selectVacancyById(idVacancy, lang);
			List<Verify> verifyList = verifyService.passVerifyList(idVacancy);

			request.setAttribute(Attribute.VERIFY_LIST, verifyList);
			request.setAttribute(Attribute.VACANCY, vacancy);
			request.getRequestDispatcher(PageName.HR_APPLICANT_WHO_PASS_PAGE).forward(request, response);
		} catch (ServiceException e) {
			throw new CommandException("Command layer");
		}
		QueryUtil.saveHttpQuery(request);
		logger.debug("ToPassVerifyApplicantCommand:execute() end");

	}

}
