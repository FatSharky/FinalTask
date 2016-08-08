package by.training.hrsystem.dao.impl;

import by.training.hrsystem.dao.UserDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class DBUserDAO implements UserDAO {

	private static final Logger logger = Logger.getLogger(DBUserDAO.class);
	private static final String SQL_ADD_USER = "INSERT INTO user (email, password, surname, name, secondname, skype, contact_phone, birth_date, role) "
			+ "VALUES (?, md5(?), ?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_GET_USER_BY_EMAIL_PASS = "SELECT * FROM user WHERE email=? and password=md5(?);";

	private static final String SQL_GET_USER_BY_EMAIL = "SELECT * FROM user WHERE email=?;";

	@Override
	public void addUser(User user) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_USER);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSurname());
			ps.setString(4, user.getName());
			ps.setString(5, user.getSecondName());
			ps.setBytes(6, user.getPhoto());
			ps.setString(7, user.getSkype());
			ps.setInt(8, user.getContactPhone());
			ps.setDate(9, new Date(user.getBirthDate().getTime()));
			ps.setString(10, user.getRole().getRole());
		} catch (SQLException e) {
			throw new DAOException("Faild insert new User: ", e);
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
	public void addTranslateUser(User user, String lang) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUser(String email) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTranslateUser(String email, String lang) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateUser(User user) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateTranslateUser(User user, String lang) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public User userAuthentication(String email, String password) throws DAOException {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_GET_USER_BY_EMAIL_PASS);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = getUserFromResultSet(rs);
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
				logger.error("Faild to close connection or ps or rs", e);
			}
		}
		return user;
	}

	@Override
	public User getUserByEmail(String email) throws DAOException {
		User user = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_GET_USER_BY_EMAIL);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = getUserFromResultSet(rs);
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
		return user;
	}

	private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setEmail(resultSet.getString(SQLField.USER_EMAIL));
		user.setPassword(resultSet.getString(SQLField.USER_PASSWORD));
		user.setSurname(resultSet.getString(SQLField.USER_SURNAME));
		user.setName(resultSet.getString(SQLField.USER_NAME));
		user.setSecondName(resultSet.getString(SQLField.USER_SECONDNAME));
		user.setPhoto(resultSet.getBytes(SQLField.USER_PHOTO));
		user.setSkype(resultSet.getString(SQLField.USER_SKYPE));
		user.setContactPhone(resultSet.getInt(SQLField.USER_CONTACT_PHONE));
		user.setBirthDate(resultSet.getDate(SQLField.USER_BIRTH_DATE));
		user.setRole(Role.valueOf(resultSet.getString(SQLField.USER_ROLE)));
		return user;
	}

}
