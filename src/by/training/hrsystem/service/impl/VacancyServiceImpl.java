package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.VacancyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.service.VacancyService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongConditionsServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongDescriptionServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongSalaryServiceException;
import by.training.hrsystem.service.exeption.vacancy.WrongVacancyNameServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class VacancyServiceImpl implements VacancyService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addVacancy(String vacancyName, String salary, String currency, String description, String conditions,
			String employmentType, String hrEmail) throws WrongVacancyNameServiceException, WrongSalaryServiceException,
			WrongDescriptionServiceException, WrongConditionsServiceException, ServiceException {
		logger.debug(
				"VacancyServiceImpl: addVacancy() : user's data is valid (vacancyName = {}, salary={}, currency = {}, "
						+ "description = {}, conditions={}, employmantType={}, hrEmail={})",
				vacancyName, salary, currency, description, conditions, employmentType, hrEmail);
		if (!Validation.validateStringField(vacancyName)) {
			throw new WrongVacancyNameServiceException("wrong vacancy name");
		}
		if (!Validation.validateSalaryField(salary)) {
			throw new WrongSalaryServiceException("wrong salary");
		}
		if (!Validation.validateTextField(description)) {
			throw new WrongDescriptionServiceException("wrong description");
		}
		if (!Validation.validateTextField(conditions)) {
			throw new WrongConditionsServiceException("wrong conditions");

		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();

			Vacancy vacancy = new Vacancy();
			vacancy.setName(vacancyName);
			vacancy.setSalary(Parser.parseStringtoInt(salary));
			vacancy.setCurrency(Parser.fromStringToCurrencyType(currency));
			vacancy.setDescription(description);
			vacancy.setCondition(conditions);
			vacancy.setEmploymentType(Parser.fromStringToEmplType(employmentType));
			User hr = new User();
			hr.setEmail(hrEmail);
			vacancy.setHr(hr);

			vacancyDAO.addVacancy(vacancy);

		} catch (DAOException e) {
			throw new ServiceException("Service layer: cannot make a new registrarion", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: can not parse date");
		}

	}

	@Override
	public void updateVacancy(String vacancyName, String slary, String currency, String description, String conditions,
			String employmentType, String idVacancy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVacancy(String idVacancy) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Vacancy> selectAllVacancy(String lang) throws ServiceException {
		logger.debug("VacancyServiceImpl: selectAllVacancy() : user's data is valid (lang={}", lang);
		List<Vacancy> listVacancy = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			try {
				listVacancy = vacancyDAO.selectAllVacancy(lang);
			} catch (DataDoesNotExistException e) {
				throw new ServiceException("list is empty");
			}
		} catch (DAOException e) {
			throw new ServiceException("Service laye: can not show list of education");
		}
		return listVacancy;
	}

}
