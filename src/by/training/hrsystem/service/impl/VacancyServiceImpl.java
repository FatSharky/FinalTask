package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.VacancyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DAODataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
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
		if (!Validation.validateTextField(vacancyName)) {
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
			vacancy.setHrEmail(hrEmail);
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
	public void deleteVacancy(int idVacancy) throws ServiceException {
		logger.debug("VacancyServiceImpl: deleteVacancy() : idVacancy = {}", idVacancy);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			vacancyDAO.deleteVacancy(idVacancy);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not delete vacancy");
		}

	}

	@Override
	public List<Vacancy> selectAllVacancy(String lang) throws ServiceException {
		logger.debug("VacancyServiceImpl: selectAllVacancy() : user's data is valid (lang={}", lang);
		List<Vacancy> listVacancy = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();

			listVacancy = vacancyDAO.selectAllVacancy(lang);

		} catch (DAOException e) {
			throw new ServiceException("Service laye: can not show list of education");
		}
		return listVacancy;
	}

	@Override
	public List<Vacancy> selectAllActiveVacancy(String lang, int first, int perPage) throws ServiceException {
		logger.debug(
				"VacancyServiceImpl: selectAllActiveVacancy() : user's data is valid (lang={}, first={}, perPage={})",
				lang, first, perPage);
		List<Vacancy> listVacancy;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			listVacancy = vacancyDAO.selectAllActiveVacancy(lang, first, perPage);
		} catch (DAOException e) {
			throw new ServiceException("Service laye: can not show list of education");
		}
		return listVacancy;

	}

	@Override
	public int countAllActiveVacancy() throws ServiceException {
		int countActiveVacancy = 0;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			countActiveVacancy = vacancyDAO.selectCountActiveVacancy();
		} catch (DAOException | DAODataDoesNotExistException e) {

			throw new ServiceException("Service layer: cant show count of vacancy");
		}
		logger.debug("VacancyServiceImpl: countAllActiveVacancy() : count={}", countActiveVacancy);
		return countActiveVacancy;
	}

	@Override
	public Vacancy selectVacancyById(int idVacancy, String lang) throws ServiceException {
		logger.debug("VacancyServiceImpl : selectVacancyById() : idVacancy = {}, lang={}", idVacancy, lang);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			Vacancy vacancy = vacancyDAO.selectVacancyById(idVacancy, lang);
			return vacancy;
		} catch (DAOException | DAODataDoesNotExistException e) {
			throw new ServiceException("Service layer: cannot make a selectUserByEmail operation", e);
		}
	}

	@Override
	public List<Vacancy> selectVacancyByHrEmail(String hrEmail, String lang, int first, int perPage)
			throws ServiceException {
		logger.debug("VacancyServiceImpl: selectVacancyByHrEmail() : hrEmail={} lang={}, first={}, perPage={}", hrEmail,
				lang, first, perPage);
		List<Vacancy> listVacancy;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			listVacancy = vacancyDAO.selectVacancyByHrEmail(hrEmail, lang, first, perPage);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not show list of education");
		}
		return listVacancy;

	}

	@Override
	public int countVacancyByHrEmail(String hrEmail) throws ServiceException {
		int countVacancy = 0;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			countVacancy = vacancyDAO.selectCountVacancyByHrEmail(hrEmail);
		} catch (DAOException | DAODataDoesNotExistException e) {

			throw new ServiceException("Service layer: cant show count of vacancy");
		}
		logger.debug("VacancyServiceImpl: countVacancyByHrEmail() : count={}", countVacancy);
		return countVacancy;

	}

	@Override
	public void activateVacancy(int idVacancy) throws ServiceException {
		logger.debug("VacancyServiceImpl: activateVacancy() : idVacancy = {}", idVacancy);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			vacancyDAO.activateVacancy(idVacancy);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not activate vacancy");
		}

	}

	@Override
	public void deactivateVacancy(int idVacancy) throws ServiceException {
		logger.debug("VacancyServiceImpl: deactivateVacancy() : idVacancy = {}", idVacancy);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			vacancyDAO.deactivateVacancy(idVacancy);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not deactivate vacancy");
		}

	}

	@Override
	public void hotVacancy(int idVacancy) throws ServiceException {
		logger.debug("VacancyServiceImpl: hotVacancy() : idVacancy = {}", idVacancy);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			vacancyDAO.hotVacancy(idVacancy);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not deactivate vacancy");
		}
	}

	@Override
	public List<Vacancy> selectHotVacancy(String lang) throws ServiceException {
		logger.debug("VacancyServiceImpl: selectHotVacancy() : lang={}", lang);
		List<Vacancy> listVacancy;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			listVacancy = vacancyDAO.selectAllHotVacancy(lang);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not show list of education");
		}
		return listVacancy;

	}

	@Override
	public List<Vacancy> selectVacancyLike(String vacancyName) throws ServiceException {
		logger.debug("VacancyServiceImpl: selectVacancyLike() : vacancyName={}", vacancyName);
		List<Vacancy> listVacancy;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VacancyDAO vacancyDAO = daoFactory.getVacancyDAO();
			listVacancy = vacancyDAO.selectVacancyLike(vacancyName);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not show list of vacancy");
		}
		return listVacancy;

	}

}
