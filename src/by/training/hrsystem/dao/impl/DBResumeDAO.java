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
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DAODataDoesNotExistException;
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
	private static final String SQL_SELECT_RESUME_BY_APPLICANT = "SELECT * FROM resume WHERE email=? LIMIT ?,?;";
	private static final String SQL_SELECT_TRANSL_RESUME_BY_APPLICANT = "SELECT r.id_resume, coalesce(tr.name, r.name) AS name, r.publish_date, r.military, r.active, r.email "
			+ "FROM resume AS r LEFT JOIN (SELECT * FROM tresume WHERE lang = ?) AS tr USING(id_resume) WHERE email=? LIMIT ?,?;";
	private static final String SQL_SELECT_RESUME_FOR_VACANCY = "SELECT * FROM resume WHERE email=?;";
	private static final String SQL_SELECT_TRANSL_RESUME_FOR_VACANCY = "SELECT r.id_resume, coalesce(tr.name, r.name) AS name, r.publish_date, r.military, r.active, r.email "
			+ "FROM resume AS r LEFT JOIN (SELECT * FROM tresume WHERE lang = ?) AS tr USING(id_resume) WHERE email=?;";
	private static final String SQL_SELECT_COUNT_RESUME_BY_APPLIC_EMAIL = "SELECT count(id_resume) AS resume_count FROM resume WHERE email=?;";
	private static final String SQL_SELECT_RESUME_BY_ID_VACANCY = "SELECT r.id_resume, r.name, r.publish_date, r.military, r.active, r.email FROM verify as v, resume as r "
			+ "WHERE v.id_vacancy=? and r.id_resume=v.id_resume; ";

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
			throw new DAOException("Faild to create resume: ", e);
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
		logger.debug("DBResumeDAO.updateResume() - resume = {}", resume);
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
			throw new DAOException("Faild update resume: ", e);
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
		logger.debug("DBResumeDAO.deleteResume() - idResume = {}", idResume);
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
	public int selectCountResume() throws DAOException, DAODataDoesNotExistException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		int countResume = 0;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_SELECT_COUNT_RESUME);
			rs = ps.executeQuery();
			if (rs.next()) {
				countResume = rs.getInt(1);
			} else {
				throw new DAODataDoesNotExistException("User not found!");
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

		return countResume;
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
			ps.setInt(1, resume.getIdResume());
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
	public Resume selectResumeById(int idResume, String lang) throws DAOException, DAODataDoesNotExistException {

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
				throw new DAODataDoesNotExistException("User not found!");
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
	public List<Resume> selectResumeByApplicant(String applicantEmail, String lang, int pageNum, int amountPerPage)
			throws DAOException {
		logger.debug("DBResumeDAO.selectResumeByApplicant() - applicantEmail = {}, lang={}, pageNum={},amountPerPage",
				applicantEmail, lang, pageNum, amountPerPage);
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
				ps.setInt(2, pageNum);
				ps.setInt(3, amountPerPage);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_RESUME_BY_APPLICANT);
				ps.setString(1, lang);
				ps.setString(2, applicantEmail);
				ps.setInt(3, pageNum);
				ps.setInt(4, amountPerPage);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				resume.add(getResumeFromResultSet(rs));
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

	@Override
	public int selectCountResumeByEmail(String applicantEmail) throws DAOException, DAODataDoesNotExistException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		int countVacancy = 0;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_SELECT_COUNT_RESUME_BY_APPLIC_EMAIL);
			ps.setString(1, applicantEmail);
			rs = ps.executeQuery();
			if (rs.next()) {
				countVacancy = rs.getInt(1);
			} else {
				throw new DAODataDoesNotExistException("Vacancy not found!");
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
		return countVacancy;

	}

	private Resume getResumeFromResultSet(ResultSet set) throws SQLException {
		Resume resume = new Resume();
		resume.setIdResume(set.getInt(1));
		resume.setName(set.getString(2));
		resume.setPublishDate(set.getDate(3));
		resume.setMilitatyType(MilitaryType.valueOf(set.getString(4).toUpperCase().replace(' ', '_')));
		resume.setActiveType(ActiveType.valueOf(set.getString(5).toUpperCase().replace(' ', '_')));
		User applicant = new User();
		applicant.setEmail(set.getString(6));
		return resume;

	}

	@Override
	public List<Resume> selectResumeForVacancy(String applicantEmail, String lang) throws DAOException {
		logger.debug("DBResumeDAO.selectResumeByApplicant() - applicantEmail = {}, lang={}", applicantEmail, lang);
		List<Resume> resume = new ArrayList<Resume>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_RESUME_FOR_VACANCY);
				ps.setString(1, applicantEmail);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_RESUME_FOR_VACANCY);
				ps.setString(1, lang);
				ps.setString(2, applicantEmail);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				resume.add(getResumeFromResultSet(rs));
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

	@Override
	public List<Resume> selectListResumeByVacancy(int idVacancy) throws DAOException {
		logger.debug("DBResumeDAO.selectListResumeByVacancy() - applicantEmail = {}", idVacancy);
		List<Resume> resume = new ArrayList<Resume>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_SELECT_RESUME_BY_ID_VACANCY);
			ps.setInt(1, idVacancy);
			rs = ps.executeQuery();
			while (rs.next()) {
				resume.add(getResumeFromResultSet(rs));
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
}
