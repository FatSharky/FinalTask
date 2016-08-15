package by.training.hrsystem.service.impl;

import java.util.List;

import by.training.hrsystem.dao.EducationDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Education;
import by.training.hrsystem.service.EducationService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.education.EducationServiceException;
import by.training.hrsystem.service.exeption.education.ListEducationIsEmptyServiceException;
import by.training.hrsystem.service.exeption.education.WrongCourseServiceException;
import by.training.hrsystem.service.exeption.education.WrongDepartmentServiceException;
import by.training.hrsystem.service.exeption.education.WrongEducationServiceException;
import by.training.hrsystem.service.exeption.education.WrongFacultyServiceException;
import by.training.hrsystem.service.exeption.education.WrongGradYearServiceException;
import by.training.hrsystem.service.exeption.education.WrongInstitutionServiceException;
import by.training.hrsystem.service.exeption.education.WrongPostGraduateServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class EducationServiceImpl implements EducationService {

	@Override
	public void addEducation(String institution, String faculty, String department, String education, String course,
			String gradYear, String postgraduate, String idResume)
			throws WrongInstitutionServiceException, WrongFacultyServiceException, WrongDepartmentServiceException,
			WrongEducationServiceException, WrongCourseServiceException, WrongGradYearServiceException,
			WrongPostGraduateServiceException, EducationServiceException, ServiceException {

		if (!Validation.validateStringField(institution)) {
			throw new WrongInstitutionServiceException("Wrong institution");
		}
		if (!Validation.validateStringField(faculty)) {
			throw new WrongFacultyServiceException("Wrong faculty");
		}
		if (!Validation.validateStringField(department)) {
			throw new WrongDepartmentServiceException("Wrong department");
		}
		if (education == null) {
			throw new WrongEducationServiceException("Wrong education");
		}
		if (!Validation.validateCourseField(course)) {
			throw new WrongCourseServiceException("Wong course");
		}
		if (!Validation.validateShortDateField(gradYear)) {
			throw new WrongGradYearServiceException("Wrong gradeYear");
		}
		if (postgraduate == null) {
			throw new WrongPostGraduateServiceException("WrongPostGraduate");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();

			Education newEducation = new Education();
			newEducation.setInstitution(institution);
			newEducation.setFaculty(faculty);
			newEducation.setDepartment(department);
			newEducation.setEducation(Parser.fromStringToEducType(education));
			newEducation.setCourse(Parser.parseStringtoInt(course));
			newEducation.setGradYear(Parser.parseToShorterForm(gradYear));
			newEducation.setPostGraduate(Parser.fromStringToPostGradType(postgraduate));
			newEducation.setIdResume(Parser.parseStringtoInt(idResume));
			educationDAO.addEducation(newEducation);

		} catch (DAOException e) {
			throw new EducationServiceException("Service layer: cannot make a new registrarion", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: can not parse date");
		}
	}

	@Override
	public void updateEducation(String institution, String faculty, String department, String education, String course,
			String gradYear, String postgraduate, String idEducation)
			throws WrongInstitutionServiceException, WrongFacultyServiceException, WrongDepartmentServiceException,
			WrongEducationServiceException, WrongCourseServiceException, WrongGradYearServiceException,
			WrongPostGraduateServiceException, EducationServiceException, ServiceException {

		if (!Validation.validateStringField(institution)) {
			throw new WrongInstitutionServiceException("Wrong institution");
		}
		if (!Validation.validateStringField(faculty)) {
			throw new WrongFacultyServiceException("Wrong faculty");
		}
		if (!Validation.validateStringField(department)) {
			throw new WrongDepartmentServiceException("Wrong department");
		}
		if (education == null) {
			throw new WrongEducationServiceException("Wrong education");
		}
		if (!Validation.validateCourseField(course)) {
			throw new WrongCourseServiceException("Wong course");
		}
		if (!Validation.validateShortDateField(gradYear)) {
			throw new WrongGradYearServiceException("Wrong gradeYear");
		}
		if (postgraduate == null) {
			throw new WrongPostGraduateServiceException("WrongPostGraduate");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();

			Education updateEducation = new Education();
			updateEducation.setInstitution(institution);
			updateEducation.setFaculty(faculty);
			updateEducation.setDepartment(department);
			updateEducation.setEducation(Parser.fromStringToEducType(education));
			updateEducation.setCourse(Parser.parseStringtoInt(course));
			updateEducation.setGradYear(Parser.parseToShorterForm(gradYear));
			updateEducation.setPostGraduate(Parser.fromStringToPostGradType(postgraduate));
			updateEducation.setIdResume(Parser.parseStringtoInt(idEducation));
			educationDAO.updateEducation(updateEducation);

		} catch (DAOException e) {
			throw new EducationServiceException("Service layer: cannot update education", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: can not parse date");
		}
	}

	@Override
	public void deleteEducation(String idEducation) throws EducationServiceException {
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();
			educationDAO.deleteEducation(Parser.parseStringtoInt(idEducation));
		} catch (DAOException e) {
			throw new EducationServiceException("Service layer: can not delete education");
		}

	}

	@Override
	public List<Education> selectEducationbyIdResume(String idResume, String lang)
			throws ListEducationIsEmptyServiceException, EducationServiceException {
		List<Education> listEducation = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();
			try {
				listEducation = educationDAO.getEducationByIdResume(Parser.parseStringtoInt(idResume), lang);
			} catch (DataDoesNotExistException e) {
				throw new ListEducationIsEmptyServiceException("list is empty");
			}
		} catch (DAOException e) {
			throw new EducationServiceException("Service laye: can not show list of education");
		}
		return listEducation;
	}

}
