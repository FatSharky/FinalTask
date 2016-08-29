package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.ResumeLangugaeDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.ResumeLanguage;
import by.training.hrsystem.service.ResumeLanguageService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.languagelevel.LanguageLevelServiceException;
import by.training.hrsystem.service.exeption.languagelevel.LanguageNameServiceException;
import by.training.hrsystem.service.exeption.languagelevel.ListLanguageLevelIsEmptyServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class ResumeLanguageServiceImpl implements ResumeLanguageService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addLanguage(String name, String skillLevel, int idResume)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException {
		logger.debug("ResumeLanguageImpl: addLanguage() : user's data is valid (name = {}, skillLevel={}, idResume={}",
				name, skillLevel, idResume);

		if (!Validation.validateStringField(name)) {
			throw new LanguageNameServiceException("wrong language");
		}
		if (skillLevel == null) {
			throw new LanguageLevelServiceException("wrong level");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeLangugaeDAO resumeLangugaeDAO = daoFactory.getResumeLanguageDAO();

			ResumeLanguage language = new ResumeLanguage();
			language.setName(name);
			language.setRaiting(Parser.fromStringToLanguageLevel(skillLevel));
			language.setIdResume(idResume);

			resumeLangugaeDAO.addResumeLang(language);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new resumeLanguage", e);
		}

	}

	@Override
	public void updateLanguage(String name, String skillLevel, int idLanguage)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException {
		logger.debug(
				"ResumeLanguageImpl: updateLanguage() : user's data is valid (name = {}, skillLevel={}, idLanguage={}",
				name, skillLevel, idLanguage);
		if (!Validation.validateStringField(name)) {
			throw new LanguageNameServiceException("wrong language");
		}
		if (skillLevel == null) {
			throw new LanguageLevelServiceException("wrong level");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeLangugaeDAO resumeLangugaeDAO = daoFactory.getResumeLanguageDAO();

			ResumeLanguage language = new ResumeLanguage();
			language.setName(name);
			language.setRaiting(Parser.fromStringToLanguageLevel(skillLevel));
			language.setIdResume(idLanguage);

			resumeLangugaeDAO.updateResumeLang(language);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot update new ResumeLanguage", e);
		}

	}

	@Override
	public void deleteLanguage(int idLanguage) throws ServiceException {
		logger.debug("ResumeLanguageImpl: deleteLanguage() : user's data is valid (idLanguage={}", idLanguage);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeLangugaeDAO resumeLangugaeDAO = daoFactory.getResumeLanguageDAO();
			resumeLangugaeDAO.deleteResumeLang(idLanguage);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not delete resumeLanguage");
		}

	}

	@Override
	public List<ResumeLanguage> selectLanguageByIdResume(String idResume, String lang)
			throws ListLanguageLevelIsEmptyServiceException, LanguageLevelServiceException {
		logger.debug("ResumeLanguageImpl: selectLanguageByIdResume() : user's data is valid (idResume={},lang={}",
				idResume, lang);
		List<ResumeLanguage> listResumeLanguage = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeLangugaeDAO resumeLanguageDAO = daoFactory.getResumeLanguageDAO();
			try {
				listResumeLanguage = resumeLanguageDAO.getResumeLangByIdResume(Parser.parseStringtoInt(idResume), lang);
			} catch (DataDoesNotExistException e) {
				throw new ListLanguageLevelIsEmptyServiceException("list is empty");
			}
		} catch (DAOException e) {
			throw new LanguageLevelServiceException("Service laye: can not show list of education");
		}
		return listResumeLanguage;

	}

}
