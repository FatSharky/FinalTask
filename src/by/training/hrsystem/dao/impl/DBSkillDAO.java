package by.training.hrsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.SkillDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.Skill;
import by.training.hrsystem.domain.type.SkillType;

public class DBSkillDAO implements SkillDAO {

	private static final Logger logger = LogManager.getRootLogger();
	private static final String SQL_ADD_SKILL = "INSERT INTO skill (name, raiting, id_resume) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE_SKILL = "UPDATE skill SET name=?, raiting=? WHERE id_skill=?;";
	private static final String SQL_DELETE_SKILL = "DELETE FROM skill WHERE id_skill=?;";
	private static final String SQL_ADD_TRANSLATION_SKILL = "INSERT INTO tskill (id_skill, lang, name) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE_TRANSLATION_SKILL = "UPDATE tskill SET name=? WHERE id_skill=? and lang=?;";
	private static final String SQL_DELETE_TRANSLATION_SKILL = "DELETE FROM tskill WHERE id_skill=? and lang=?;";
	private static final String SQL_SELECT_SKILL_BY_ID_RESUME = "SELECT * FROM skill WHERE id_resume=?;";
	private static final String SQL_SELECT_TRANSL_SKILL_BY_ID_RESUME = "SELECT s.id_skill, coalesce(ts.name, s.name) AS name, s.raiting, s.id_resume "
			+ "FROM skill AS s LEFT JOIN (SELECT * FROM tskill WHERE lang = ?) AS ts USING(id_skill) WHERE id_resume=?;";

	@Override
	public void addSkill(Skill skill) throws DAOException {
		logger.debug("DBSkillDAO.addSkill() - skill = {}", skill);
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_SKILL);
			ps.setString(1, skill.getName());
			ps.setString(2, skill.getRaiting().getSkillType());
			ps.setInt(3, skill.getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create skill: ", e);
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
	public void updateSkill(Skill skill) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_SKILL);
			ps.setString(1, skill.getName());
			ps.setString(2, skill.getRaiting().getSkillType());
			ps.setInt(3, skill.getIdSkill());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild update skill: ", e);
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
	public void deleteSkill(int idSkill) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_SKILL);
			ps.setInt(1, idSkill);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete skill: ", e);
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
	public void addTranslateSkill(Skill skill, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_TRANSLATION_SKILL);
			ps.setInt(1, skill.getIdResume());
			ps.setString(2, lang);
			ps.setString(3, skill.getName());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translation for resume: ", e);
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
	public void updateTranslateSkill(Skill skill, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_TRANSLATION_SKILL);
			ps.setString(1, skill.getName());
			ps.setInt(2, skill.getIdResume());
			ps.setString(3, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild update translation for resume: ", e);
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
	public void deleteTranslateSkill(int idSkill, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_TRANSLATION_SKILL);
			ps.setInt(1, idSkill);
			ps.setString(2, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete translation skill: ", e);
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
	public List<Skill> getSkillByIdResume(int idResume, String lang) throws DAOException {
		List<Skill> skill = new ArrayList<Skill>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_SKILL_BY_ID_RESUME);
				ps.setInt(1, idResume);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_SKILL_BY_ID_RESUME);
				ps.setString(1, lang);
				ps.setInt(2, idResume);

			}
			rs = ps.executeQuery();
			while (rs.next()) {
				skill.add(getSkillFromResultSet(rs));
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
		return skill;
	}

	private Skill getSkillFromResultSet(ResultSet set) throws SQLException {
		Skill skill = new Skill();
		skill.setIdSkill(set.getInt(SQLField.SKILL_ID));
		skill.setName(set.getString(SQLField.SKILL_NAME));
		skill.setRaiting(SkillType.valueOf(set.getString(SQLField.SKILL_RAITING).toUpperCase()));
		skill.setIdResume(set.getInt(SQLField.SKILL_ID_RESUME));
		return skill;

	}
}
