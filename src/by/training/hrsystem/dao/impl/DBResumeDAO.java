package by.training.hrsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.ResumeDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.type.ActiveType;
import by.training.hrsystem.domain.type.MilitaryType;

public class DBResumeDAO implements ResumeDAO {
	private static final Logger logger = LogManager.getRootLogger();

	private static final String SQL_ADD_RESUME = "INSERT INTO resume (name, publish_date, military, email) VALUES (?, ?, ?, ?);";
	private static final String SQL_UPDATE_RESUME = "UPDATE resume SET name=?, publish_date=?, military=? WHERE id_resume=?;";
	private static final String SQL_DELETE_RESUME = "DELETE FROM resume WHERE id_resume=?;";
	private static final String SQL_ADD_TRANSLATION_RESUME = "INSERT INTO tresume (id_resume, lang, name) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE_TRANSLATION_RESUME = "UPDATE tresume SET name=? WHERE id_resume=? and lang=?;";
	private static final String SQL_DELETE_TRANSLATION_RESUME = "DELETE FROM tresume WHERE id_resume=? and lang=?;";
	private static final String SQL_SELECT_COUNT_RESUME = "SELECT count(id_resume) AS resume_count FROM resume;";
	private static final String SQL_ACTIVATE_RESUME = "UPDATE resume SET active=active WHERE id_resume=?;";
	private static final String SQL_SELECT_RESUME_BY_ID = "SELECT * FROM resume WHERE id_resume=?;";
	private static final String SQL_SELECT_TRANSL_RESUME_BY_ID = "SELECT r.id_resume, coalesce(tr.name, r.name) AS name, r.publish_date, r.military, r.active, r.email "
			+ "FROM resume AS r LEFT JOIN (SELECT * FROM tresume WHERE lang = ?) AS tr USING(id_resume) WHERE id_resume=?;";
	private static final String SQL_SELECT_RESUME_BY_APPLICANT = "SELECT * FROM resume WHERE email=?;";
	private static final String SQL_SELECT_TRANSL_RESUME_BY_APPLICANT = "SELECT r.id_resume, coalesce(tr.name, r.name) AS name, r.publish_date, r.military, r.active, r.email "
			+ "FROM resume AS r LEFT JOIN (SELECT * FROM tresume WHERE lang = ?) AS tr USING(id_resume) WHERE email=?;";

	@Override
	public void addResume(Resume resume) throws DAOException {
		logger.debug("DBResumeDAO.addResume() - resume = {}", resume);
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_RESUME);
			ps.setString(1, resume.getName());
			ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			ps.setString(3, resume.getMilitatyType().getMillatryType());
			ps.setString(4, resume.getApplicant().getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create Resume: ", e);
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
	public void updateResume(Resume resume) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_RESUME);
			ps.setString(1, resume.getName());
			ps.setDate(2, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
			ps.setString(3, resume.getMilitatyType().getMillatryType());
			ps.setInt(4, resume.getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild update Resume: ", e);
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
	public void deleteResume(int idResume) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_RESUME);
			ps.setInt(1, idResume);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete Resume: ", e);
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
	public void addTranlateResume(Resume resume, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_TRANSLATION_RESUME);
			ps.setInt(1, resume.getIdResume());
			ps.setString(2, lang);
			ps.setString(3, resume.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translation of resume: ", e);
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
	public void updateTranslateResume(Resume resume, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_TRANSLATION_RESUME);
			ps.setString(1, resume.getName());
			ps.setInt(2, resume.getIdResume());
			ps.setString(3, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild to update translation of resume: ", e);
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
	public void deleteTranslateResume(int Idresume, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_TRANSLATION_RESUME);
			ps.setInt(1, Idresume);
			ps.setString(2, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete translation skill ", e);
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
	// TO DO
	public int selectCountResume() throws DAOException, DataDoesNotExistException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_SELECT_COUNT_RESUME);
			rs = ps.executeQuery();
			if (rs.next()) {
				// countResume;
			} else {
				throw new DataDoesNotExistException("User not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find count: ", e);
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

		return 0;
	}

	@Override
	public void activateResume(Resume resume) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ACTIVATE_RESUME);
			ps.setString(1, resume.getActiveType().getCurrencyType());
			ps.setInt(2, resume.getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild activate Resume: ", e);
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
	public Resume selectResumeById(int idResume, String lang) throws DAOException, DataDoesNotExistException {

		Resume resume = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_RESUME_BY_ID);
				ps.setInt(1, idResume);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_RESUME_BY_ID);
				ps.setString(1, lang);
				ps.setInt(2, idResume);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				resume = getResumeFromResultSet(rs);
			} else {
				throw new DataDoesNotExistException("User not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find user: ", e);
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
		return resume;

	}

	@Override
	public List<Resume> selectResumeByApplicant(String applicantEmail, String lang)
			throws DAOException, DataDoesNotExistException {
		List<Resume> resume = new ArrayList<Resume>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_RESUME_BY_APPLICANT);
				ps.setString(1, applicantEmail);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_RESUME_BY_APPLICANT);
				ps.setString(1, lang);
				ps.setString(2, applicantEmail);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				resume.add(getResumeFromResultSet(rs));
			} else {
				throw new DataDoesNotExistException("Company not found!");
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

		return resume;
	}

	private Resume getResumeFromResultSet(ResultSet set) throws SQLException {
		Resume resume = new Resume();
		resume.setIdResume(set.getInt(SQLField.RESUME_ID));
		resume.setName(set.getString(SQLField.RESUME_NAME));
		resume.setPublishDate(set.getDate(SQLField.RESUME_PUBLISH_DATE));
		resume.setMilitatyType(MilitaryType.valueOf(set.getString(SQLField.RESUME_MILLATRY_TYPE)));
		resume.setActiveType(ActiveType.valueOf(set.getString(SQLField.RESUME_ACTIVE_TYPE)));
		User applicant = new User();
		applicant.setEmail(set.getString(SQLField.RESUME_APPLICANT_EMAIL));
		return resume;

	}

}
