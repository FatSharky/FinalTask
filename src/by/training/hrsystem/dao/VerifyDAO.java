package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.Verify;

public interface VerifyDAO {

	void addResumeToVacancy(Verify verify) throws DAOException;

	void verifyResume(int idVerify) throws DAOException;

	List<Verify> verifyList(int idVacancy) throws DAOException;

	List<Verify> passVerifyList(int idVacancy) throws DAOException;

	Verify getVerifyById(int idVerify) throws DAOException;
}
