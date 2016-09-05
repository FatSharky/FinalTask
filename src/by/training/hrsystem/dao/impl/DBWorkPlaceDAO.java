package by.training.hrsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.training.hrsystem.dao.WorkPlaceDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.WorkPlace;

public class DBWorkPlaceDAO implements WorkPlaceDAO {
	private static final Logger logger = Logger.getLogger(DBWorkPlaceDAO.class);
	private static final String SQL_ADD_WORKPLACE = "INSERT INTO workplace (company_name, position, date_begin, date_end, id_resume) VALUES (?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE_WORKPLACE = "UPDATE workplace SET company_name=?, position=?, date_begin=?, date_end=? WHERE id_workplace=?;";
	private static final String SQL_DELETE_WORKPLACE = "DELETE FROM workplace WHERE id_workplace=?;";
	private static final String SQL_ADD_TRANSL_WORKPLACE = "INSERT INTO tworkplace (id_workplace, lang, company_name, position) VALUES (?, ?, ?, ?);";
	private static final String SQL_UPDATE_TRANSL_WORKPLACE = "UPDATE tworkplace SET company_name=?, position=? WHERE id_workplace=? and lang=?;";
	private static final String SQL_DELETE_TRANSL_WORKPLACE = "DELETE FROM tworkplace WHERE id_workplace=? and lang=?;";
	private static final String SQL_SELECT_WORKPLACE_BY_ID_RESUME = "SELECT * FROM workplace WHERE id_resume=?;";
	private static final String SQL_SELECT_TRANSL_WORKPLACE_BY_ID_RESUME = "SELECT w.id_workplace, "
			+ "coalesce(tw.company_name, w.company_name) AS company_name, "
			+ "coalesce(tw.position, w.position) AS position, " + "w.date_begin, w.date_end, w.id_resume "
			+ "FROM workplace AS w LEFT JOIN (SELECT * FROM tworkplace WHERE lang = ?) AS tw USING(id_workplace) WHERE id_resume=?;";

	@Override
	public void addWorkPlace(WorkPlace workplace) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_WORKPLACE);
			ps.setString(1, workplace.getCompanyName());
			ps.setString(2, workplace.getPosition());
			ps.setDate(3, new java.sql.Date(workplace.getDateBegin().getTime()));
			ps.setDate(4, new java.sql.Date(workplace.getDateEnd().getTime()));
			ps.setInt(5, workplace.getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create WorkPlace: ", e);
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
	public void updateWorkPlace(WorkPlace workplace) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_WORKPLACE);
			ps.setString(1, workplace.getCompanyName());
			ps.setString(2, workplace.getPosition());
			ps.setDate(3, new java.sql.Date(workplace.getDateBegin().getTime()));
			ps.setDate(4, new java.sql.Date(workplace.getDateEnd().getTime()));
			ps.setInt(5, workplace.getIdWorkPlace());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild to update WorkPlace: ", e);
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
	public void deleteWorkPlace(int idWorkplace) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_WORKPLACE);
			ps.setInt(1, idWorkplace);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete WorkPlace: ", e);
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
	public void addTranslateWorkPlace(WorkPlace workplace, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_TRANSL_WORKPLACE);
			ps.setInt(1, workplace.getIdWorkPlace());
			ps.setString(2, lang);
			ps.setString(3, workplace.getCompanyName());
			ps.setString(4, workplace.getPosition());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translation of WorkPlace: ", e);
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
	public void updateTranslateWorkPlace(WorkPlace workplace, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_TRANSL_WORKPLACE);
			ps.setString(1, workplace.getCompanyName());
			ps.setString(2, workplace.getPosition());
			ps.setInt(3, workplace.getIdWorkPlace());
			ps.setString(4, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild update translation of WorkPlace: ", e);
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
	public void deleteTranslateWorkPlace(int idWorkplace, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_TRANSL_WORKPLACE);
			ps.setInt(1, idWorkplace);
			ps.setString(2, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete translation of WorkPlace: ", e);
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
	public List<WorkPlace> getWorkPlaceByIdResume(int idResume, String lang) throws DAOException {
		List<WorkPlace> workplace = new ArrayList<WorkPlace>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_WORKPLACE_BY_ID_RESUME);
				ps.setInt(1, idResume);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_WORKPLACE_BY_ID_RESUME);
				ps.setString(1, lang);
				ps.setInt(2, idResume);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				workplace.add(getWorkPlaceFromResultSet(rs));
			}
		} catch (SQLException e) {
			throw new DAOException("Faild to find Company: ", e);
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

		return workplace;
	}

	private WorkPlace getWorkPlaceFromResultSet(ResultSet set) throws SQLException {
		WorkPlace workPlace = new WorkPlace();
		workPlace.setIdWorkPlace(set.getInt(1));
		workPlace.setCompanyName(set.getString(2));
		workPlace.setPosition(set.getString(3));
		workPlace.setDateBegin(set.getDate(4));
		workPlace.setDateEnd(set.getDate(5));
		workPlace.setIdResume(set.getInt(6));
		return workPlace;

	}
}
