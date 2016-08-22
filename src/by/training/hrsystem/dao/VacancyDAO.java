package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.Vacancy;

public interface VacancyDAO {
	void addVacancy(Vacancy vacancy) throws DAOException;

	void updateVacancy(Vacancy vacancy) throws DAOException;

	void deleteVacancy(int idVacancy) throws DAOException;

	void addTranslateVacancy(Vacancy vacancy, String lang) throws DAOException;

	void updateTranslateVacancy(Vacancy vacancy, String lang) throws DAOException;

	void deleteTranslateVacancy(int idVacancy, String lang) throws DAOException;

	int selectCountVacancy() throws DAOException, DataDoesNotExistException;
	
	int selectCountActiveVacancy() throws DAOException, DataDoesNotExistException;
	
	Vacancy selectVacancyById(int idVacancy, String lang) throws DAOException, DataDoesNotExistException;

	List<Vacancy> selectAllVacancy(String lang) throws DAOException, DataDoesNotExistException;
	
	List<Vacancy> selectAllActiveVacancy(String lang, int pageNum, int amountPerPage) throws DataDoesNotExistException, DAOException;

	List<Vacancy> selectVacancyByHrEmail(String hrEmail, String lang) throws DAOException, DataDoesNotExistException;

	List<Vacancy> selectVacancyLike(String name, String lang) throws DAOException, DataDoesNotExistException;

}
