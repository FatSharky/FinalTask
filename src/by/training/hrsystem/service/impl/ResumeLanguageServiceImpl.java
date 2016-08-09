package by.training.hrsystem.service.impl;

import by.training.hrsystem.dao.ResumeLangugaeDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.ResumeLanguage;
import by.training.hrsystem.domain.type.LanguageLevelType;
import by.training.hrsystem.service.ResumeLanguageService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resumelanguage.LanguageLevelServiceException;
import by.training.hrsystem.service.exeption.resumelanguage.LanguageNameServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.validation.Validation;

public class ResumeLanguageServiceImpl implements ResumeLanguageService {

	@Override
	public void addLanguage(String name, LanguageLevelType skillLevel, String idResume)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException {
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
			language.setRaiting(skillLevel);
			language.setIdResume(Parser.parseStringtoInt(idResume));

			resumeLangugaeDAO.addResumeLang(language);

		} catch (DAOException e) {
			throw new ServiceException("Service layer: cannot make a new resumeLanguage", e);
		}

	}

	@Override
	public void updateLanguage(String name, LanguageLevelType skillLevel, String idLanguage)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException {
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
			language.setRaiting(skillLevel);
			language.setIdResume(Parser.parseStringtoInt(idLanguage));

			resumeLangugaeDAO.updateResumeLang(language);

		} catch (DAOException e) {
			throw new ServiceException("Service layer: cannot update new ResumeLanguage", e);
		}

	}

	@Override
	public void deleteLanguage(String idLanguage) {
		// TODO Auto-generated method stub

	}

}
