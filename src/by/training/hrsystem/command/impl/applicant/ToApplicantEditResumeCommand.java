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
import by.training.hrsystem.domain.Education;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.ResumeLanguage;
import by.training.hrsystem.domain.Skill;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.WorkPlace;
import by.training.hrsystem.service.EducationService;
import by.training.hrsystem.service.ResumeLanguageService;
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.SkillService;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.WorkPlaceService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class ToApplicantEditResumeCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("ToApplicantEditResumeCommand:execute() start");

		int idResume = Integer.valueOf(request.getParameter(Attribute.ID_RESUME));
		String lang = (String) request.getSession().getAttribute(Attribute.LOCALE);
		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ResumeService resumeService = serviceFactory.getResumeService();
			UserService userService = serviceFactory.getUserService();
			EducationService educationService = serviceFactory.getEducationService();
			ResumeLanguageService resumeLanguageService = serviceFactory.getResumeLanguageService();
			SkillService skillService = serviceFactory.getSkillService();
			WorkPlaceService workPlaceService = serviceFactory.getWorkPlaceService();

			Resume resume = resumeService.selectResumeById(idResume, lang);
			User applicant = userService.selectUserByIdVacancy(idResume);
			List<Education> listEducation = educationService.selectEducationbyIdResume(idResume, lang);
			List<ResumeLanguage> listResumeLanguage = resumeLanguageService.selectLanguageByIdResume(idResume, lang);
			List<Skill> listSkill = skillService.selectSkillByIdResume(idResume, lang);
			List<WorkPlace> listWorkPlace = workPlaceService.selectWorkPlaceByIdResume(idResume, lang);

			request.setAttribute(Attribute.RESUME, resume);
			request.setAttribute(Attribute.APPLICANT, applicant);
			request.setAttribute(Attribute.EDUCATION_LIST, listEducation);
			request.setAttribute(Attribute.LANGUAGE_LIST, listResumeLanguage);
			request.setAttribute(Attribute.SKILL_LIST, listSkill);
			request.setAttribute(Attribute.WORKPLACE_LIST, listWorkPlace);

			request.getRequestDispatcher(PageName.APPLICANT_EDIT_RESUME_PAGE).forward(request, response);
			
		} catch (ServiceException e) {
			throw new CommandException("Command layer");
		}
		QueryUtil.saveHttpQuery(request);
		logger.debug("ToApplicantEditResumeCommand:execute() end");

	}

}
