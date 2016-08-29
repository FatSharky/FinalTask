package by.training.hrsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.ResumeLangugaeDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.ResumeLanguage;
import by.training.hrsystem.domain.type.LanguageLevelType;

public class DBResumeLanguageDAO implements ResumeLangugaeDAO {
	
	private static final Logger logger = LogManager.getRootLogger();
	
	private static final String SQL_ADD_RESEUME_LANGUAGE = "INSERT INTO resumelanguage (name, raiting, id_resume) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE_RESUME_LANGUAGE = "UPDATE resumelanguage SET name=?, raiting=? WHERE id_language=?;";
	private static final String SQL_DELETE_RESUME_LANGUAGE = "DELETE FROM resumelanguage WHERE id_language=?;";
	private static final String SQL_ADD_TRANSL_RESUME_LANGUGE = "INSERT INTO tresumelanguage (id_language, lang, name) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE_TRANSL_RESUME_LANG = "UPDATE tresumelanguage SET name=? WHERE id_language=? and lang=?;";
	private static final String SQL_DELETE_TRANSL_RESUME_LANG = "DELETE FROM tresumelanguage WHERE id_language=? and lang=?;";
	private static final String SQL_SELECT_RESUME_LANG_BY_ID_RESUME = "SELECT * FROM resumelanguage WHERE id_resume=?;";
	private static final String SQL_SELECT_TRANSL_LANG_BY_ID_RESUME = "SELECT r.id_language, coalesce(tr.name, r.name) AS name, r.raiting, r.id_resume "
			+ "FROM resumelanguage AS r LEFT JOIN (SELECT * FROM tresumelanguage WHERE lang = ?) AS tr USING(id_language) WHERE id_resume=?;";

	@Override
	public void addResumeLang(ResumeLanguage resumeLang) throws DAOException {
		logger.debug("DBResumeLanguageDAO.addResume() - language = {}", resumeLang);
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_RESEUME_LANGUAGE);
			ps.setString(1, resumeLang.getName());
			ps.setString(2, resumeLang.getRaiting().getLanguageLevelType());
			ps.setInt(3, resumeLang.getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create Language for resume: ", e);
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
	public void updateResumeLang(ResumeLanguage resumeLang) throws DAOException {
		logger.debug("DBResumeLanguageDAO.updateResumeLang() - language = {}", resumeLang);
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_RESUME_LANGUAGE);
			ps.setString(1, resumeLang.getName());
			ps.setString(2, resumeLang.getRaiting().getLanguageLevelType());
			ps.setInt(3, resumeLang.getIdLanguage());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild to update Language for resume: ", e);
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
	public void deleteResumeLang(int idLanguage) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_RESUME_LANGUAGE);
			ps.setInt(1, idLanguage);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete Language: ", e);
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
	public void addTranslateResumeLang(ResumeLanguage resumeLang, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_TRANSL_RESUME_LANGUGE);
			ps.setInt(1, resumeLang.getIdResume());
			ps.setString(2, lang);
			ps.setString(3, resumeLang.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translationLanguage for resume: ", e);
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
	public void updateTranslateResumeLang(ResumeLanguage resumeLang, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_TRANSL_RESUME_LANG);
			ps.setString(1, resumeLang.getName());
			ps.setInt(2, resumeLang.getIdResume());
			ps.setString(3, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translationLanguage for resume: ", e);
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
	public void deleteTranslateResumeLang(int idResumeLang, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_TRANSL_RESUME_LANG);
			ps.setInt(1, idResumeLang);
			ps.setString(2, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete translation of Language for resume: ", e);
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
	public List<ResumeLanguage> getResumeLangByIdResume(int idResume, String lang) throws DAOException {
		List<ResumeLanguage> language = new ArrayList<ResumeLanguage>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_RESUME_LANG_BY_ID_RESUME);
				ps.setInt(1, idResume);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_LANG_BY_ID_RESUME);
				ps.setString(1, lang);
				ps.setInt(2, idResume);

			}
			rs = ps.executeQuery();
			while (rs.next()) {
				language.add(getLanguageFromResultSet(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find langugae: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn);
				ps.close();
				rs.close();
			} catch (SQLException | ConnectionPoolException e) {
				logger.error("Faild to close connection or ps or rs", e);
			}
		}
		return language;
	}

	private ResumeLanguage getLanguageFromResultSet(ResultSet set) throws SQLException {
		ResumeLanguage language = new ResumeLanguage();
		language.setIdLanguage(set.getInt(1));
		language.setName(set.getString(2));
		language.setRaiting(LanguageLevelType.valueOf(set.getString(3).toUpperCase().replace(' ', '_')));
		language.setIdResume(set.getInt(4));
		return language;

	}
}
