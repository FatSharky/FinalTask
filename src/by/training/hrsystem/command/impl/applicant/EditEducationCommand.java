package by.training.hrsystem.command.impl.applicant;

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
import by.training.hrsystem.service.EducationService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.education.EducationServiceException;
import by.training.hrsystem.service.exeption.education.WrongCourseServiceException;
import by.training.hrsystem.service.exeption.education.WrongDepartmentServiceException;
import by.training.hrsystem.service.exeption.education.WrongEducationServiceException;
import by.training.hrsystem.service.exeption.education.WrongFacultyServiceException;
import by.training.hrsystem.service.exeption.education.WrongGradYearServiceException;
import by.training.hrsystem.service.exeption.education.WrongInstitutionServiceException;
import by.training.hrsystem.service.exeption.education.WrongPostGraduateServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class EditEducationCommand implements Command {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("addEducationCommand:execute() start");
		int idEducation = Integer.parseInt(request.getParameter(Attribute.ID_EDUCATION));
		User user = (User) request.getSession().getAttribute(Attribute.USER);

		String institution = request.getParameter(Attribute.INSTITUTION);
		String faculty = request.getParameter(Attribute.FACULTY);
		String department = request.getParameter(Attribute.DEPARTMENT);
		String educationField = request.getParameter(Attribute.EDUCATION_FIELD);
		String course = request.getParameter(Attribute.COURSE);
		String gradYear = request.getParameter(Attribute.GRAD_YEAR);
		String postGrad = request.getParameter(Attribute.POSTGRAD);
		if (user != null) {

			if (user.getRole() == Role.APPLICANT) {
				ServiceFactory serviceFactory = ServiceFactory.getInstance();
				EducationService educationService = serviceFactory.getEducationService();
				try {
					educationService.updateEducation(institution, faculty, department, educationField, course, gradYear,
							postGrad, idEducation);
				} catch (WrongInstitutionServiceException e) {

				} catch (WrongFacultyServiceException e) {

				} catch (WrongDepartmentServiceException e) {

				} catch (WrongEducationServiceException e) {

				} catch (WrongCourseServiceException e) {

				} catch (WrongGradYearServiceException e) {

				} catch (WrongPostGraduateServiceException e) {

				} catch (EducationServiceException e) {

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

		logger.debug("editResumeCommand:execute() stop");
	}

}
