package by.training.hrsystem.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import by.training.hrsystem.dao.InterviewMarkDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.InterviewMark;
import by.training.hrsystem.domain.type.SkillType;

public class DBInterviewMarkDAO implements InterviewMarkDAO {
	private static final Logger LOGGER = Logger.getLogger(DBUserDAO.class);
	private static final String SQL_ADD_INTERVIEW_MARK = "INSERT INTO interview_mark (skill, mark, id_interview) VALUES (?, ?, ?);";
	private static final String SQL_UPDATE_INERVIEW_MARK = "UPDATE interview_mark SET  skill=?,  mark=?, WHERE id_mark=?;";
	private static final String SQL_DELETE_INTERVIEW_MARK = "DELETE interview_mark WHERE id_mark=?";
	private static final String SQL_SELECT_MARK_BY_ID_INTERVIEW = "SELECT * FROM interview_mark "
			+ "WHERE id_interview=?";

	@Override
	public void addMark(InterviewMark mark) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_INTERVIEW_MARK);
			ps.setString(1, mark.getSkill());
			ps.setString(2, mark.getMark().getSkillType());
			ps.setInt(3, mark.getIdInterview());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create Interview mark: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn, ps);
			} catch (ConnectionPoolException e) {
				LOGGER.error("Faild to close connection", e);
			}
		}

	}

	@Override
	public void updateMark(InterviewMark mark) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_INERVIEW_MARK);
			ps.setString(1, mark.getSkill());
			ps.setString(2, mark.getMark().getSkillType());
			ps.setInt(3, mark.getIdMark());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild update Interview mark: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn, ps);
			} catch (ConnectionPoolException e) {
				LOGGER.error("Faild to close connection", e);
			}
		}

	}

	@Override
	public void deleteMark(int idMark) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_INTERVIEW_MARK);
			ps.setInt(1, idMark);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete mark: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn, ps);
			} catch (ConnectionPoolException e) {
				LOGGER.error("Faild to close connection", e);
			}
		}

	}

	@Override
	public List<InterviewMark> selectMarkByIdInterview(int idInterview) throws DAOException, DataDoesNotExistException {
		List<InterviewMark> mark = new ArrayList<InterviewMark>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_SELECT_MARK_BY_ID_INTERVIEW);
			ps.setInt(1, idInterview);
			rs = ps.executeQuery();
			if (rs.next()) {
				mark.add(getMarkFromResultSet(rs));
			} else {
				throw new DataDoesNotExistException("Company not found!");
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find Languages: ", e);
		} catch (ConnectionPoolException e) {
			throw new DAOException("Connection pool problems!", e);
		} finally {
			try {
				ConnectionPool.getInstance().closeConnection(conn, ps, rs);
			} catch (ConnectionPoolException e) {
				LOGGER.error("Faild to close connection", e);
			}
		}
		return mark;
	}

	private InterviewMark getMarkFromResultSet(ResultSet set) throws SQLException {
		InterviewMark skill = new InterviewMark();
		skill.setIdMark(set.getInt(SQLField.IMARK_ID));
		skill.setSkill(set.getString(SQLField.IMARK_SKILL));
		skill.setMark(SkillType.valueOf(set.getString(SQLField.IMARK_MARK)));
		skill.setIdInterview(set.getInt(SQLField.IMARK_ID_INERVIEW));
		return skill;

	}

}
