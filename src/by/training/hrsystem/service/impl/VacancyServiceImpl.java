package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.VacancyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.service.VacancyService;
import by.training.hrsystem.service.exeption.ServiceException;

public class VacancyServiceImpl implements VacancyService {
	private static final Logger logger = LogManager.getRootLogger();

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
