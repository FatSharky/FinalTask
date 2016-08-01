package by.training.hrsystem.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;

import by.training.hrsystem.dao.VerifyDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.Verify;

public class DBVerifyDAO implements VerifyDAO {
	private static final Logger LOGGER = Logger.getLogger(DBUserDAO.class);
	private static final String SQL_ADD_RESUME_TO_VACANCY = "INSERT INTO verify (id_vacancy, id_resume) VALUES (?, ?);";
	private static final String SQL_DELETE_VERIFY = "DELETE FROM verify WHERE id_verify=?;";
	private static final String SQL_VERIFY_RESUME = "UPDATE verify SET pass=? WHERE id_verify=?;";
	private static final String SQL_SELECT_VERIFY_BY_ID_VACANCY = "SELECT * FROM verify WHERE id_vacancy=?;";
	private static final String SQL_SELECT_VERIFY_BY_ID = "SELECT * FROM verify WHERE id_verify=?;";

	@Override
	public void addResumeToVacancy(Verify verify) throws DAOException {
		// TODO Auto-generated method stub

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
	public List<Verify> verifyList(int idVacancy) throws DAOException, DataDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Verify getVerifyById(int idVerify) throws DAOException, DataDoesNotExistException {
		// TODO Auto-generated method stub
		return null;
	}

}
