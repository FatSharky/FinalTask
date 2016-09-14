package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.InterviewMark;

public interface InterviewMarkDAO {
	void addMark(InterviewMark mark) throws DAOException;

	void deleteMark(int idMark) throws DAOException;

	List<InterviewMark> selectMarkOfTechicalInterview(int idVerify) throws DAOException;

	List<InterviewMark> selectMarkOfPreliminaryInterview(int idVerify) throws DAOException;
}
