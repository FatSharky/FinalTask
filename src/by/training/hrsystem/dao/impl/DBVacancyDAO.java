package by.training.hrsystem.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.training.hrsystem.dao.VacancyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.Vacancy;

public class DBVacancyDAO implements VacancyDAO {
	private static final Logger LOGGER = Logger.getLogger(DBUserDAO.class);
	private static final String SQL_ADD_VACANCY = "INSERT INTO vacancy (name, salary, currency, publish_date, description, conditions, employment_type, email) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE_VACANCY = "UPDATE vacancy SET name=?, salary=?, currency=?, publish_date=?, description=?, conditions=?, employment_type=? "
			+ "WHERE id_vacancy=?;";
	private static final String SQL_DELETE_VACANCY = "DELETE FROM vacancy WHERE id_vacancy=?;";
	private static final String SQL_ADD_TRANSLATION_VACANCY = "INSERT INTO tvacancy (id_vacancy, lang, name, description, conditions) VALUES (?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE_TRANSLATION_VACANCY = "UPDATE tvacancy SET name=?, description=?, conditions=? WHERE id_vacancy=? and lang=?;";
	private static final String SQL_DELETE_TRANSLATION_VACANCY = "DELETE FROM tvacancy WHERE id_vacancy=? and lang=?;";
	private static final String SQL_SELECT_COUNT_VACANCY = "SELECT count(id_vacancy) as vacancy_count FROM vacancy;";
	private static final String SQL_SELECT_VACANCY_BY_ID = "SELECT * FROM vacancy WHERE id_vacancy=?;";
	private static final String SQL_SELECT_TRANSLATE_VACANCY_BY_ID = "SELECT v.id_vacancy, coalesce(tv.name, v.name) AS name, "
			+ "v.salary, v.currency, v. publish_date, coalesce(tv.description, v.description) AS description, "
			+ "coalesce(tv.conditions, v.conditions) AS conditions, v.employment_type, v.active, v.email "
			+ "FROM vacancy AS v LEFT JOIN (SELECT * FROM tvacancy WHERE lang = ?) AS tv USING(id_vacancy)  WHERE id_vacancy=?;";
	private static final String SQL_SELECT_ALL_VACANCY = "SELECT * FROM vacancy";
	private static final String SQL_SELECT_ALL_TRANSL_VACANCY = "SELECT v.id_vacancy, coalesce(tv.name, v.name) AS name, "
			+ "v.salary, v.currency, v. publish_date, coalesce(tv.description, v.description) AS description, "
			+ "coalesce(tv.conditions, v.conditions) AS conditions, v.employment_type, v.active, v.email "
			+ "FROM vacancy AS v LEFT JOIN (SELECT * FROM tvacancy WHERE lang = ?) AS tv USING(id_vacancy);";
	private static final String SQL_SELECT_VACANCY_LIKE = "SELECT * FROM vacancy WHERE name LIKE ?;";
	private static final String SQL_SELECT_TRASL_VACANCY_LIKE="?";

	@Override
	public void addVacancy(Vacancy vacancy) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVacancy(Vacancy vacancy) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVacancy(int idVacancy) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addTranslateVacancy(Vacancy vacancy, String lang) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTranslateVacancy(Vacancy vacancy, String lang) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTranslateVacancy(int idVacancy, String lang) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public int selectCountVacancy() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vacancy selectVacancyById(int idVacancy, String lang) throws DAOException, DataDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacancy> selectAllVacancy(String lang) throws DAOException, DataDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacancy> selectVacancyByHrEmail(String hrEmail, String lang)
			throws DAOException, DataDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vacancy> selectVacancyLike(String name, String lang) throws DAOException, DataDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

}
