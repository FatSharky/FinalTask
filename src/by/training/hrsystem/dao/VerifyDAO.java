package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.Verify;

public interface VerifyDAO {
	
	void addResumeToVacancy(Verify verify) throws DAOException;

	void deleteVerify(int idVerify) throws DAOException;

	void verifyResume(Verify verify) throws DAOException;

	List<Verify> verifyList(int idVacancy) throws DAOException, DataDoesNotExistException;

	Verify getVerifyById(int idVerify) throws DAOException, DataDoesNotExistException;
}
