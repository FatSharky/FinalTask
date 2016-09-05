package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.ResumeLanguage;


public interface ResumeLangugaeDAO {
	void addResumeLang(ResumeLanguage resumeLang) throws DAOException;

	void updateResumeLang(ResumeLanguage resumeLang) throws DAOException;

	void deleteResumeLang(int idLanguage) throws DAOException;

	void addTranslateResumeLang(ResumeLanguage resumeLang, String lang) throws DAOException;

	void updateTranslateResumeLang(ResumeLanguage resumeLang, String lang) throws DAOException;

	void deleteTranslateResumeLang(int idResumeLang, String lang) throws DAOException;

	List<ResumeLanguage> getResumeLangByIdResume(int idResume, String lang) throws DAOException;

}
