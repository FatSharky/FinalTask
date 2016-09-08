package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.VerifyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.domain.Verify;
import by.training.hrsystem.service.VerifyService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.education.EducationServiceException;

public class VerifyServiceImpl implements VerifyService {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addResumeToVacancy(int idVacancy, int idResume) throws ServiceException {

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VerifyDAO verifyDAO = daoFactory.getVerifyDAO();
			Verify verify = new Verify();
			Vacancy vacancy = new Vacancy();
			Resume resume = new Resume();
			resume.setIdResume(idResume);
			vacancy.setIdVacancy(idVacancy);
			verify.setResume(resume);
			verify.setVacancy(vacancy);
			verifyDAO.addResumeToVacancy(verify);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: ");
		}

	}

	@Override
	public List<Verify> verifyList(int idVacancy) throws ServiceException {
		logger.debug("VerifyServiceImpl: verifyList() : idVacancy = {}", idVacancy);
		List<Verify> listVerify = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VerifyDAO verifyDAO = daoFactory.getVerifyDAO();
			listVerify = verifyDAO.verifyList(idVacancy);
		} catch (DAOException e) {
			throw new EducationServiceException("Service laye: can not show list of education");
		}
		return listVerify;
	}

	@Override
	public List<Verify> passVerifyList(int idVacancy) throws ServiceException {
		logger.debug("VerifyServiceImpl: passVerifyList() : idVacancy = {}", idVacancy);
		List<Verify> listVerify = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VerifyDAO verifyDAO = daoFactory.getVerifyDAO();
			listVerify = verifyDAO.passVerifyList(idVacancy);
		} catch (DAOException e) {
			throw new EducationServiceException("Service laye: can not show list of education");
		}
		return listVerify;
	}

	@Override
	public Verify selectVerifyById(int idVerify) throws ServiceException {
		logger.debug("VerifyServiceImpl : selectVerifyById() : idVerify = {}", idVerify);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			VerifyDAO verifyDAO = daoFactory.getVerifyDAO();
			Verify verify = verifyDAO.getVerifyById(idVerify);
			return verify;
		} catch (DAOException e) {
			throw new ServiceException("Service layer: cannot make a selectVerifyById operation", e);
		}
	}
}
