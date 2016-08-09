package by.training.hrsystem.service;

import by.training.hrsystem.domain.type.LanguageLevelType;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resumelanguage.LanguageLevelServiceException;
import by.training.hrsystem.service.exeption.resumelanguage.LanguageNameServiceException;

public interface ResumeLanguageService {
	void addLanguage(String name, LanguageLevelType skillLevel, String idResume)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException;

	void updateLanguage(String name, LanguageLevelType skillLevel, String idLanguage)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException;

	void deleteLanguage(String idLanguage) throws ServiceException;

}
