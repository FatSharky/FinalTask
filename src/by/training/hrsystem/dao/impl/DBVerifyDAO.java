package by.training.hrsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.VerifyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.pool.ConnectionPool;
import by.training.hrsystem.dao.pool.exception.ConnectionPoolException;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.Verify;
import by.training.hrsystem.domain.type.PassType;

public class DBVerifyDAO implements VerifyDAO {

	private static final Logger logger = LogManager.getRootLogger();

	private static final String SQL_ADD_RESUME_TO_VACANCY = "INSERT INTO verify (id_vacancy, id_resume) VALUES (?, ?);";
	private static final String SQL_DELETE_VERIFY = "DELETE FROM verify WHERE id_verify=?;";
	private static final String SQL_VERIFY_RESUME = "UPDATE verify SET pass=? WHERE id_verify=?;";
	private static final String SQL_SELECT_VERIFY_BY_ID_VACANCY = "SELECT v.id_verify, v.pass, r.id_resume, r.name, r.publish_date, r.email FROM verify as v, resume as r "
			+ "WHERE v.id_vacancy=? and r.id_resume=v.id_resume; ";
	private static final String SQL_SELECT_VERIFY_BY_ID = "SELECT * FROM verify WHERE id_verify=?;";

	@Override
	public void addResumeToVacancy(Verify verify) throws DAOException {
		logger.debug("DBVerifyDAO.addResumeToVacancy() - verify = {}", verify);
		Connection conn = null;
		PreparedStatement ps = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_ADD_RESUME_TO_VACANCY);
			ps.setInt(1, verify.getVacancy().getIdVacancy());
			ps.setInt(2, verify.getResume().getIdResume());
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException("Faild create to addResumeToVacancy: ", e);
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
	public void deleteVerify(int idVerify) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void verifyResume(Verify verify) throws DAOException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Verify> verifyList(int idVacancy) throws DAOException {
		logger.debug("DBVerifyDAO.verify() - idVacancy = {}", idVacancy);
		List<Verify> verifyList = new ArrayList<Verify>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ConnectionPool pool = null;
		try {
			pool = ConnectionPool.getInstance();
			conn = pool.takeConnection();
			ps = conn.prepareStatement(SQL_SELECT_VERIFY_BY_ID_VACANCY);
			ps.setInt(1, idVacancy);
			rs = ps.executeQuery();
			while (rs.next()) {
				verifyList.add(getVerifyFromResultSet(rs));
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

		return verifyList;

	}

	@Override
	public Verify getVerifyById(int idVerify) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	private Verify getVerifyFromResultSet(ResultSet set) throws SQLException {
		Verify verify = new Verify();
		verify.setIdVerify(set.getInt(1));
		verify.setPass(PassType.valueOf(set.getString(2).toUpperCase()));
		Resume resume = new Resume();
		resume.setIdResume(set.getInt(3));
		resume.setName(set.getString(4));
		resume.setPublishDate(set.getDate(5));
		User applicant = new User();
		applicant.setEmail(set.getString(6));
		resume.setApplicant(applicant);
		verify.setResume(resume);
		return verify;
	}
}
