package by.training.hrsystem.service.impl;

import java.util.List;

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

	@Override
	public void addLanguage(String name, String skillLevel, String idResume)
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
			language.setRaiting(Parser.fromStringToLanguageLevel(skillLevel));
			language.setIdResume(Parser.parseStringtoInt(idResume));

			resumeLangugaeDAO.addResumeLang(language);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new resumeLanguage", e);
		}

	}

	@Override
	public void updateLanguage(String name, String skillLevel, String idLanguage)
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
			language.setRaiting(Parser.fromStringToLanguageLevel(skillLevel));
			language.setIdResume(Parser.parseStringtoInt(idLanguage));

			resumeLangugaeDAO.updateResumeLang(language);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot update new ResumeLanguage", e);
		}

	}

	@Override
	public void deleteLanguage(String idLanguage) throws ServiceException {
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeLangugaeDAO resumeLangugaeDAO = daoFactory.getResumeLanguageDAO();
			resumeLangugaeDAO.deleteResumeLang(Parser.parseStringtoInt(idLanguage));
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not delete resumeLanguage");
		}

	}

	@Override
	public List<ResumeLanguage> selectLanguageByIdResume(String idResume, String lang)
			throws ListLanguageLevelIsEmptyServiceException, LanguageLevelServiceException {
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
