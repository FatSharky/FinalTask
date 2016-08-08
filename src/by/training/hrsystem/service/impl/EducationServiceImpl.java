package by.training.hrsystem.service.impl;

import java.util.List;

import by.training.hrsystem.dao.EducationDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Education;
import by.training.hrsystem.domain.type.EducationType;
import by.training.hrsystem.domain.type.PostgraduateType;
import by.training.hrsystem.service.EducationService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.educationexception.EducationServiceException;
import by.training.hrsystem.service.exeption.educationexception.ListEducationIsEmptyServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongCourseServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongDepartmentServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongEducationServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongFacultyServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongGradYearServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongInstitutionServiceException;
import by.training.hrsystem.service.exeption.educationexception.WrongPostGraduateServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class EducationServiceImpl implements EducationService {

	@Override
	public void addEducation(String institution, String faculty, String department, EducationType education,
			String course, String gradYear, PostgraduateType postgraduate, String idResume)
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
			newEducation.setEducation(education);
			newEducation.setCourse(Parser.parseStringtoInt(course));
			newEducation.setGradYear(Parser.parseToShorterForm(gradYear));
			newEducation.setPostGraduate(postgraduate);
			newEducation.setIdResume(Parser.parseStringtoInt(idResume));
			educationDAO.addEducation(newEducation);

		} catch (DAOException e) {
			throw new EducationServiceException("Service layer: cannot make a new registrarion", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: can not parse date");
		}
	}

	@Override
	public void updateEducation(String institution, String faculty, String department, EducationType education,
			String course, String gradYear, PostgraduateType postgraduate, String idEducation)
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
			updateEducation.setEducation(education);
			updateEducation.setCourse(Parser.parseStringtoInt(course));
			updateEducation.setGradYear(Parser.parseToShorterForm(gradYear));
			updateEducation.setPostGraduate(postgraduate);
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
