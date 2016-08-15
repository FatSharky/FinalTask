package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Education;
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

public interface EducationService {
	void addEducation(String institution, String faculty, String department, String education, String course,
			String grandYer, String postgraduate, String idResume)
			throws WrongInstitutionServiceException, WrongFacultyServiceException, WrongDepartmentServiceException,
			WrongEducationServiceException, WrongCourseServiceException, WrongGradYearServiceException,
			WrongPostGraduateServiceException, EducationServiceException, ServiceException;

	void updateEducation(String institution, String faculty, String department, String education, String course,
			String gradYear, String postgraduate, String idEducation)
			throws WrongInstitutionServiceException, WrongFacultyServiceException, WrongDepartmentServiceException,
			WrongEducationServiceException, WrongCourseServiceException, WrongGradYearServiceException,
			WrongPostGraduateServiceException, EducationServiceException, ServiceException;

	void deleteEducation(String idEducation) throws EducationServiceException;

	List<Education> selectEducationbyIdResume(String idResume, String lang)
			throws ListEducationIsEmptyServiceException, EducationServiceException;

}
