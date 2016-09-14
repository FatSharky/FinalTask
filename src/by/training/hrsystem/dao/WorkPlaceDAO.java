package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.domain.WorkPlace;

public interface WorkPlaceDAO {
	void addWorkPlace(WorkPlace workplace) throws DAOException;

	void updateWorkPlace(WorkPlace workplace) throws DAOException;

	void deleteWorkPlace(int idWorkplace) throws DAOException;

	void addTranslateWorkPlace(WorkPlace workplace, String lang) throws DAOException;

	void updateTranslateWorkPlace(WorkPlace workplace, String lang) throws DAOException;

	void deleteTranslateWorkPlace(int idWorkplace, String lang) throws DAOException;

	List<WorkPlace> getWorkPlaceByIdResume(int idResume, String lang) throws DAOException;

}
