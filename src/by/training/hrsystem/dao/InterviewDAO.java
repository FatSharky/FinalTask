package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.Interview;

public interface InterviewDAO {
	void addInterview(Interview interview) throws DAOException;

	void updateInterview(Interview interview) throws DAOException;

	void deleteInterview(Interview interview) throws DAOException;

	List<Interview> selectInterviewByIdVerify(int idVerify) throws DAOException;

}
