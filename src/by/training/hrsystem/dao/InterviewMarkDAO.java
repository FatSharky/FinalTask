package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.InterviewMark;

public interface InterviewMarkDAO {
	void addMark(InterviewMark mark) throws DAOException;

	void updateMark(InterviewMark mark) throws DAOException;

	void deleteMark(int idMark) throws DAOException;

	List<InterviewMark> selectMarkByIdInterview(int idInterview) throws DAOException, DataDoesNotExistException;

}
