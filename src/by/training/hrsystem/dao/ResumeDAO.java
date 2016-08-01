package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.Resume;

public interface ResumeDAO {
	void addResume(Resume resume) throws DAOException;

	void updateResume(Resume resume) throws DAOException;

	void deleteResume(int idResume) throws DAOException;

	void addTranlateResume(Resume resume, String lang) throws DAOException;

	void updateTranslateResume(Resume resume, String lang) throws DAOException;

	void deleteTranslateResume(int Idresume, String lang) throws DAOException;

	int selectCountResume() throws DAOException, DataDoesNotExistException ;

	void activateResume(Resume resume) throws DAOException;

	Resume selectResumeById(int idResume, String lang) throws DAOException, DataDoesNotExistException;

	List<Resume> selectResumeByApplicant(String applicantEmail, String lang)
			throws DAOException, DataDoesNotExistException;

}
