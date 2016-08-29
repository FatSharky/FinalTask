package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongConditionsServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongDescriptionServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongSalaryServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongVacancyNameServiceException;

public interface VacancyService {

	void addVacancy(String vacancyName, String slary, String currency, String description, String conditions,
			String employmentType, String hrEmail) throws WrongVacancyNameServiceException, WrongSalaryServiceException,
			WrongDescriptionServiceException, WrongConditionsServiceException, ServiceException;

	void updateVacancy(String vacancyName, String slary, String currency, String description, String conditions,
			String employmentType, String idVacancy);

	void deleteVacancy(int idVacancy) throws ServiceException;

	List<Vacancy> selectAllVacancy(String lang) throws ServiceException;

	List<Vacancy> selectAllActiveVacancy(String lang, int first, int perPage) throws ServiceException;

	int countAllActiveVacancy() throws ServiceException;

	Vacancy selectVacancyById(int idVacancy, String lang) throws ServiceException;

	List<Vacancy> selectVacancyByHrEmail(String hrEmail, String lang, int first, int perPage)
			throws ServiceException;

	int countVacancyByHrEmail(String hrEmail) throws ServiceException;
	

	void activateVacancy(int idVacancy) throws ServiceException;

	void deactivateVacancy(int idVacancy) throws ServiceException;
	
	void hotVacancy(int idVacancy) throws ServiceException;

	List<Vacancy> selectHotVacancy(String lang) throws ServiceException;
	
}
