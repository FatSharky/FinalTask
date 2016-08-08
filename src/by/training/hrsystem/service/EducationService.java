package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Education;
import by.training.hrsystem.domain.type.EducationType;
import by.training.hrsystem.domain.type.PostgraduateType;
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

public interface EducationService {
	void addEducation(String institution, String faculty, String department, EducationType education, String course,
			String grandYer, PostgraduateType postgraduate, String idResume)
			throws WrongInstitutionServiceException, WrongFacultyServiceException, WrongDepartmentServiceException,
			WrongEducationServiceException, WrongCourseServiceException, WrongGradYearServiceException,
			WrongPostGraduateServiceException, EducationServiceException, ServiceException;

	void updateEducation(String institution, String faculty, String department, EducationType education, String course,
			String gradYear, PostgraduateType postgraduate, String idEducation)
			throws WrongInstitutionServiceException, WrongFacultyServiceException, WrongDepartmentServiceException,
			WrongEducationServiceException, WrongCourseServiceException, WrongGradYearServiceException,
			WrongPostGraduateServiceException, EducationServiceException, ServiceException;

	void deleteEducation(String idEducation) throws EducationServiceException;

	List<Education> selectEducationbyIdResume(String idResume, String lang)
			throws ListEducationIsEmptyServiceException, EducationServiceException;

}
