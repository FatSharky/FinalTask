package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.Education;

public interface EducationDAO {
	void addEducation(Education education) throws DAOException;

	void updateEducation(Education education) throws DAOException;

	void deleteEducation(int idEducation) throws DAOException;

	void addTranslateEduc(Education education, String lang) throws DAOException;

	void updateTranslateEduc(Education education, String lang) throws DAOException;

	void deleteTranslateEduc(int idEducation, String lang) throws DAOException;

	List<Education> getEducationByIdResume(int idResume, String lang) throws DAOException;

}
