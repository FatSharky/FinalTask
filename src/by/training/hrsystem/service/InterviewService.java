package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Interview;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.interview.InterviewServiceException;
import by.training.hrsystem.service.exeption.interview.WrongDateInterviewServiceException;

public interface InterviewService {
	void addInterviewService(String interivewType, String dateInterview, String idVerify)
			throws WrongDateInterviewServiceException, InterviewServiceException, ServiceException;

	void deleteInterview(int idInterview) throws ServiceException;

	List<Interview> selectInterviewByVerify(int idVerify) throws ServiceException;

}
