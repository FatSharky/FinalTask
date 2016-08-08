package by.training.hrsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import by.training.hrsystem.dao.VacancyDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.domain.type.ActiveType;
import by.training.hrsystem.domain.type.CurrencyType;

public class DBVacancyDAO implements VacancyDAO {
	private static final Logger logger = Logger.getLogger(DBUserDAO.class);
	private static final String SQL_ADD_VACANCY = "INSERT INTO vacancy (name, salary, currency, publish_date, description, conditions, employment_type, email) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE_VACANCY = "UPDATE vacancy SET name=?, salary=?, currency=?, description=?, conditions=?, employment_type=? "
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
	private static final String SQL_SELECT_VACANCY_BY_HREMAIL = "SELECT * FROM vacancy WHERE email=?;";
	private static final String SQL_SELECT_TRANSL_VAC_BY_HREMAIL = "SELECT v.id_vacancy, coalesce(tv.name, v.name) AS name, "
			+ "v.salary, v.currency, v. publish_date, coalesce(tv.description, v.description) AS description, "
			+ "coalesce(tv.conditions, v.conditions) AS conditions, v.employment_type, v.active, v.email "
			+ "FROM vacancy AS v LEFT JOIN (SELECT * FROM tvacancy WHERE lang = ?) AS tv USING(id_vacancy)  WHERE v.email=?;";
	private static final String SQL_SELECT_VACANCY_LIKE = "SELECT * FROM vacancy WHERE name LIKE ?;";
	private static final String SQL_SELECT_TRASL_VACANCY_LIKE = "?";

	@Override
	public void addVacancy(Vacancy vacancy) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_VACANCY);
			ps.setString(1, vacancy.getName());
			ps.setInt(2, vacancy.getSalary());
			ps.setString(3, vacancy.getCurrency().getCurrencyType());
			ps.setDate(4, new java.sql.Date(Calendar.getInstance()
					.getTimeInMillis()));
			ps.setString(5, vacancy.getDescription());
			ps.setString(6, vacancy.getCondition());
			ps.setString(7, vacancy.getEmploymentType().getCurrencyType());
			ps.setString(8, vacancy.getHr().getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create Vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

	}

	@Override
	public void updateVacancy(Vacancy vacancy) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_VACANCY);
			ps.setString(1, vacancy.getName());
			ps.setInt(2, vacancy.getSalary());
			ps.setString(3, vacancy.getCurrency().getCurrencyType());
			ps.setString(5, vacancy.getDescription());
			ps.setString(6, vacancy.getCondition());
			ps.setString(7, vacancy.getEmploymentType().getCurrencyType());
			ps.setInt(8, vacancy.getIdVacancy());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild to update Vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

	}

	@Override
	public void deleteVacancy(int idVacancy) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_VACANCY);
			ps.setInt(1, idVacancy);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete Vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

	}

	@Override
	public void addTranslateVacancy(Vacancy vacancy, String lang)
			throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_TRANSLATION_VACANCY);
			ps.setInt(1, vacancy.getIdVacancy());
			ps.setString(2, lang);
			ps.setString(3, vacancy.getName());
			ps.setString(4, vacancy.getDescription());
			ps.setString(5, vacancy.getCondition());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translation of Vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

	}

	@Override
	public void updateTranslateVacancy(Vacancy vacancy, String lang)
			throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_TRANSLATION_VACANCY);
			ps.setString(1, vacancy.getName());
			ps.setString(2, vacancy.getDescription());
			ps.setString(3, vacancy.getCondition());
			ps.setInt(4, vacancy.getIdVacancy());
			ps.setString(5, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild update translation of Vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

	}

	@Override
	public void deleteTranslateVacancy(int idVacancy, String lang)
			throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_TRANSLATION_VACANCY);
			ps.setInt(1, idVacancy);
			ps.setString(2, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete translation of Vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

	}

	@Override
	public int selectCountVacancy() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vacancy selectVacancyById(int idVacancy, String lang)
			throws DAOException, DataDoesNotExistException {
		Vacancy vacancy = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_VACANCY_BY_ID);
				ps.setInt(1, idVacancy);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSLATE_VACANCY_BY_ID);
				ps.setString(1, lang);
				ps.setInt(2, idVacancy);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				vacancy = getVacacnyFromResultSet(rs);
			} else {
				throw new DataDoesNotExistException("Vacancy not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find vacancy: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
				rs.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}
		return vacancy;

	}

	@Override
	public List<Vacancy> selectAllVacancy(String lang) throws DAOException,
			DataDoesNotExistException {
		List<Vacancy> vacancy = new ArrayList<Vacancy>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_ALL_VACANCY);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_ALL_TRANSL_VACANCY);
				ps.setString(1, lang);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				vacancy.add(getVacacnyFromResultSet(rs));
			} else {
				throw new DataDoesNotExistException("Vacancy not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find resume: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
				rs.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

		return vacancy;
	}

	@Override
	public List<Vacancy> selectVacancyByHrEmail(String hrEmail, String lang)
			throws DAOException, DataDoesNotExistException {
		List<Vacancy> vacancy = new ArrayList<Vacancy>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_VACANCY_BY_HREMAIL);
				ps.setString(1, hrEmail);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_VAC_BY_HREMAIL);
				ps.setString(1, lang);
				ps.setString(2, hrEmail);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				vacancy.add(getVacacnyFromResultSet(rs));
			} else {
				throw new DataDoesNotExistException("Vacancy not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find resume: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
				rs.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

		return vacancy;
	}

	@Override
	public List<Vacancy> selectVacancyLike(String name, String lang)
			throws DAOException, DataDoesNotExistException {
		List<Vacancy> vacancy = new ArrayList<Vacancy>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_VACANCY_LIKE);
				ps.setString(1, name);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRASL_VACANCY_LIKE);
				ps.setString(1, lang);
				ps.setString(2, name);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				vacancy.add(getVacacnyFromResultSet(rs));
			} else {
				throw new DataDoesNotExistException("Vacancy not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find resume: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
				rs.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps", e);
			}
		}

		return vacancy;
	}

	private Vacancy getVacacnyFromResultSet(ResultSet set) throws SQLException {
		Vacancy vacancy = new Vacancy();
		vacancy.setIdVacancy(set.getInt(SQLField.VACANCY_ID));
		vacancy.setName(set.getString(SQLField.VACANCY_NAME));
		vacancy.setSalary(set.getInt(SQLField.VACANCY_SALARY));
		vacancy.setCurrency(CurrencyType.valueOf(set
				.getString(SQLField.VACANCY_CURRENCY)));
		vacancy.setPublishDate(set.getDate(SQLField.VACANCY_PUBLISH_DATE));
		vacancy.setDescription(set.getString(SQLField.VACANCY_DESCRIPTION));
		vacancy.setCondition(set.getString(SQLField.VACANCY_CONDITIONS));
		vacancy.setActive(ActiveType.valueOf(set
				.getString(SQLField.VACANCY_ACTIVE_TYPE)));
		User hr = new User();
		hr.setEmail(set.getString(SQLField.VACANCY_HR_EMAIL));
		return vacancy;
	}

}
