package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.ResumeLanguage;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.languagelevel.LanguageLevelServiceException;
import by.training.hrsystem.service.exeption.languagelevel.LanguageNameServiceException;
import by.training.hrsystem.service.exeption.languagelevel.ListLanguageLevelIsEmptyServiceException;

public interface ResumeLanguageService {
	void addLanguage(String name, String skillLevel, int idResume)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException;

	void updateLanguage(String name, String skillLevel, int idLanguage)
			throws LanguageNameServiceException, LanguageLevelServiceException, ServiceException;

	void deleteLanguage(int idLanguage) throws ServiceException;

	List<ResumeLanguage> selectLanguageByIdResume(int idResume, String lang)
			throws ListLanguageLevelIsEmptyServiceException, LanguageLevelServiceException;

}
