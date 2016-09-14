package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.Interview;

public interface InterviewDAO {
	void addInterview(Interview interview) throws DAOException;

	void deleteInterview(int idInterview) throws DAOException;

	List<Interview> selectInterviewByIdVerify(int idVerify) throws DAOException;

}
