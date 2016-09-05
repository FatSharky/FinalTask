package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.ResumeDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DAODataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.WrongResumeNameServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class ResumeServiceImpl implements ResumeService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addResume(String name, String military, String email)
			throws WrongResumeNameServiceException, ServiceException {

		logger.debug("ResumeServiceImpl: addResume() : user's data is valid (name = {}, military={}, email={}", name,
				military, email);

		if (!Validation.validateStringField(name)) {
			throw new WrongResumeNameServiceException("wrong resume name");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			Resume resume = new Resume();
			resume.setName(name);
			resume.setMilitatyType(Parser.fromStringToMilitaryType(military));
			User applicant = new User();
			applicant.setEmail(email);
			resume.setApplicant(applicant);

			resumeDAO.addResume(resume);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new resume", e);
		}

	}

	@Override
	public void updateResume(String name, String military, int idResume)
			throws WrongResumeNameServiceException, ServiceException {

		logger.debug("ResumeServiceImpl: updateResume() : user's data is valid (name = {}, military={}, idResume={}",
				name, military, idResume);

		if (!Validation.validateStringField(name)) {
			throw new WrongResumeNameServiceException("wrong resume name");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			Resume resume = new Resume();

			resume.setName(name);
			resume.setMilitatyType(Parser.fromStringToMilitaryType(military));
			resume.setIdResume(idResume);
			resumeDAO.updateResume(resume);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new resume", e);
		}

	}

	@Override
	public void deleteResume(String idResume) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Resume> selectResumeByEmail(String email, String lang, int first, int perPage) throws ServiceException {
		logger.debug("ResumeServiceImpl: selectResumeByEmail() : email = {}, lang={} first={} perpage={}", email, lang,
				first, perPage);
		List<Resume> listResume = null;

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			listResume = resumeDAO.selectResumeByApplicant(email, lang, first, perPage);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: ");
		}

		return listResume;
	}

	@Override
	public int countAllResume() throws ServiceException {

		int countResume = 0;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			countResume = resumeDAO.selectCountResume();
		} catch (DAOException | DAODataDoesNotExistException e) {

			throw new ServiceException("Service layer: cant show count resume");
		}
		return countResume;
	}

	@Override
	public int countVacancyByEmail(String hrEmail) throws ServiceException {
		int countResume = 0;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			countResume = resumeDAO.selectCountResumeByEmail(hrEmail);
		} catch (DAOException | DAODataDoesNotExistException e) {

			throw new ServiceException("Service layer: cant show count of vacancy");
		}
		logger.debug("ResumeServiceImpl: countResumeByEmail() : count={}", countResume);
		return countResume;

	}

	@Override
	public Resume selectResumeById(int idResume, String lang) throws ServiceException {
		logger.debug("ResumeServiceImpl : selectResumeById() : idResume = {}, lang={}", idResume, lang);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			Resume resume = resumeDAO.selectResumeById(idResume, lang);
			return resume;
		} catch (DAOException | DAODataDoesNotExistException e) {
			throw new ServiceException("Service layer: cannot make a selectUserByEmail operation", e);
		}
	}

	@Override
	public List<Resume> selectResumeForVacancy(String applicantEmail, String lang) throws ServiceException {
		logger.debug("ResumeServiceImpl:  selectResumeForVacancy() : email = {}, lang={}", applicantEmail, lang);
		List<Resume> listResume = null;

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			listResume = resumeDAO.selectResumeForVacancy(applicantEmail, lang);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: ");
		}

		return listResume;
	}

	@Override
	public List<Resume> selectListResumeByVacancy(int idVacancy) throws ServiceException {
		logger.debug("ResumeServiceImpl: selectListResumeByVacancy() : idVacancy", idVacancy);
		List<Resume> listResume = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			listResume = resumeDAO.selectListResumeByVacancy(idVacancy);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: ");
		}
		
		return listResume;
	}

}
