package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DAODataDoesNotExistException;
import by.training.hrsystem.domain.Vacancy;

public interface VacancyDAO {
	void addVacancy(Vacancy vacancy) throws DAOException;

	void updateVacancy(Vacancy vacancy) throws DAOException;

	void deleteVacancy(int idVacancy) throws DAOException;

	void addTranslateVacancy(Vacancy vacancy, String lang) throws DAOException;

	void updateTranslateVacancy(Vacancy vacancy, String lang) throws DAOException;

	void deleteTranslateVacancy(int idVacancy, String lang) throws DAOException;

	int selectCountVacancy() throws DAOException, DAODataDoesNotExistException;

	int selectCountActiveVacancy() throws DAOException, DAODataDoesNotExistException;

	Vacancy selectVacancyById(int idVacancy, String lang) throws DAOException, DAODataDoesNotExistException;

	Vacancy selectTranslVacancyById(int idVacancy) throws DAOException;

	Vacancy selectNormalVacancyById(int idVacancy) throws DAOException, DAODataDoesNotExistException;
	
	boolean translExist(int idVacancy) throws DAOException;
	
	Vacancy translVacancyExist(int idVacancy)throws DAOException;

	List<Vacancy> selectAllVacancy(String lang) throws DAOException;

	List<Vacancy> selectAllActiveVacancy(String lang, int pageNum, int amountPerPage) throws DAOException;

	List<Vacancy> selectVacancyLike(String name) throws DAOException;

	List<Vacancy> selectVacancyByHrEmail(String hrEmail, String lang, int pageNum, int amountPerPage)
			throws DAOException;

	int selectCountVacancyByHrEmail(String hrEmail) throws DAOException, DAODataDoesNotExistException;

	void activateVacancy(int idVacancy) throws DAOException;

	void deactivateVacancy(int idVacancy) throws DAOException;

	void hotVacancy(int idVacancy) throws DAOException;

	List<Vacancy> selectAllHotVacancy(String lang) throws DAOException;

}
