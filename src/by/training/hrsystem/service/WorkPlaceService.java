package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.WorkPlace;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.education.EducationServiceException;
import by.training.hrsystem.service.exeption.workplace.ListWorkPlaceIsEmptyServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongCompanyNameServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongDateBeginServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongDateEndServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongDateServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongPositionServiceException;

public interface WorkPlaceService {
	void addWorkplace(String companyName, String position, String dateBegin, String dateEnd, int idResume)
			throws WrongCompanyNameServiceException, WrongPositionServiceException, WrongDateBeginServiceException,
			WrongDateEndServiceException, WrongDateServiceException, ServiceException;

	void updateWorkplace(String companyName, String position, String dateBegin, String dateEnd, int idWorkPlace)
			throws WrongCompanyNameServiceException, WrongPositionServiceException, WrongDateBeginServiceException,
			WrongDateEndServiceException, WrongDateServiceException, ServiceException;

	void deleteWorkplace(int idWorPlace) throws EducationServiceException;

	List<WorkPlace> selectWorkPlaceByIdResume(int idResume, String lang)
			throws ListWorkPlaceIsEmptyServiceException, ServiceException;
}
