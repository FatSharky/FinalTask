package by.training.hrsystem.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import by.training.hrsystem.dao.EducationDAO;
import by.training.hrsystem.dao.constant.SQLField;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.Education;
import by.training.hrsystem.domain.type.EducationType;
import by.training.hrsystem.domain.type.PostgraduateType;

public class DBEducationDAO implements EducationDAO {

	private static final Logger logger = Logger.getLogger(DBEducationDAO.class);
	private static final String SQL_ADD_EDUCATION = "INSERT INTO education (institution, faculty, department, education, course, grad_year, postgraduate, id_resume) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	private static final String SQL_UPDATE_EDUCATION = "UPDATE education SET institution=?, faculty=?, department=?, education=?, course=?, grad_year=?, postgraduate=? WHERE id_education=?;";
	private static final String SQL_DELETE_EDUCATION = "DELETE FROM education WHERE id_education=?;";
	private static final String SQL_ADD_TRANSLATION_EDUC = "INSERT INTO teducation (id_education, lang, institution, faculty, department) "
			+ "VALUES (?, ?, ?, ?, ?);";
	private static final String SQL_UPADATE_TRANSLATION_EDUC = "UPDATE teducation SET institution=?, faculty=?, department=? "
			+ "WHERE id_education=? and lang=?;";
	private static final String SQL_DELETE_TRANSLATION_EDUC = "DELETE FROM teducation WHERE id_education=? and lang=?;";
	private static final String SQL_SELECT_EDUC_BY_ID_RESUME = "SELECT * FROM education WHERE id_resume=?;";
	private static final String SQL_SELECT_TRANSL_EDUC_BY_ID_RESUME = "SELECT e.id_education, "
			+ "coalesce(tr.institution, e.institution) AS education, " + "coalesce(tr.faculty, e.faculty) AS faculty, "
			+ "coalesce(tr.department, e.department) AS department, "
			+ "e.education, e.course, e.grad_year, e.postgraduate, e.id_resume "
			+ "FROM education AS e LEFT JOIN (SELECT * FROM teducation WHERE lang = ?) AS tr "
			+ "USING(id_education) WHERE id_resume=?;";

	@Override
	public void addEducation(Education education) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_EDUCATION);
			ps.setString(1, education.getInstitution());
			ps.setString(2, education.getFaculty());
			ps.setString(3, education.getDepartment());
			ps.setString(4, education.getEducation().getEducationType());
			ps.setInt(5, education.getCourse());
			ps.setDate(6, new java.sql.Date(education.getGradYear().getTime()));
			ps.setString(7, education.getPostGraduate().getPostgraduateType());
			ps.setInt(8, education.getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create Education: ", e);
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
	public void updateEducation(Education education) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPDATE_EDUCATION);
			ps.setString(1, education.getInstitution());
			ps.setString(2, education.getFaculty());
			ps.setString(3, education.getDepartment());
			ps.setString(4, education.getEducation().getEducationType());
			ps.setInt(5, education.getCourse());
			ps.setDate(6, new java.sql.Date(education.getGradYear().getTime()));
			ps.setString(7, education.getPostGraduate().getPostgraduateType());
			ps.setInt(8, education.getIdEducation());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild to update Education: ", e);
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
	public void deleteEducation(int idEducation) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_EDUCATION);
			ps.setInt(1, idEducation);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete Education: ", e);
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
	public void addTranslateEduc(Education education, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_TRANSLATION_EDUC);
			ps.setInt(1, education.getIdEducation());
			ps.setString(2, lang);
			ps.setString(3, education.getInstitution());
			ps.setString(4, education.getFaculty());
			ps.setString(5, education.getDepartment());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create translation of Education: ", e);
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
	public void updateTranslateEduc(Education education, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_UPADATE_TRANSLATION_EDUC);
			ps.setString(1, education.getInstitution());
			ps.setString(2, education.getFaculty());
			ps.setString(3, education.getDepartment());
			ps.setInt(4, education.getIdEducation());
			ps.setString(5, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild to update translation of Education: ", e);
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
	public void deleteTranslateEduc(int idEducation, String lang) throws DAOException {
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_DELETE_TRANSLATION_EDUC);
			ps.setInt(1, idEducation);
			ps.setString(2, lang);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild delete translation of Education: ", e);
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
	public List<Education> getEducationByIdResume(int idResume, String lang)
			throws DAOException, DataDoesNotExistException {
		List<Education> education = new ArrayList<Education>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			if (lang.equals(SQLField.DEFAULT_LANGUAGE)) {
				ps = conn.prepareStatement(SQL_SELECT_EDUC_BY_ID_RESUME);
				ps.setInt(1, idResume);
			} else {
				ps = conn.prepareStatement(SQL_SELECT_TRANSL_EDUC_BY_ID_RESUME);
				ps.setString(1, lang);
				ps.setInt(2, idResume);
			}
			rs = ps.executeQuery();
			if (rs.next()) {
				education.add(getEducationFromResultSet(rs));
			} else {
				throw new DataDoesNotExistException("Company not found!");
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

		return education;

	}

	private Education getEducationFromResultSet(ResultSet set) throws SQLException {
		Education education = new Education();
		education.setIdEducation(set.getInt(SQLField.EDUCATION_ID));
		education.setInstitution(set.getString(SQLField.EDUCATION_INSTITUTION));
		education.setFaculty(set.getString(SQLField.EDUCATION_FACULTY));
		education.setDepartment(set.getString(SQLField.EDUCATION_DEPARTMENT));
		education.setEducation(EducationType.valueOf(set.getString(SQLField.EDUCATION_EDUCATION)));
		education.setCourse(set.getInt(SQLField.EDUCATION_COURSE));
		education.setGradYear(set.getDate(SQLField.EDUCATION_GRAND_YEAR));
		education.setPostGraduate(PostgraduateType.valueOf(set.getString(SQLField.EDUCATION_POSTGRADUATE)));
		education.setIdResume(set.getInt(SQLField.EDUCATION_ID_RESUME));
		return education;
	}

}
