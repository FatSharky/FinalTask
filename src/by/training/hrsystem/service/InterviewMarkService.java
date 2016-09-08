package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.InterviewMark;
import by.training.hrsystem.service.exeption.ServiceException;

public interface InterviewMarkService {

	void addMark(String skill, String mark, String idInterview) throws ServiceException;

	List<InterviewMark> selectMarkOfTechicalInterview(int idVerify) throws ServiceException;

	List<InterviewMark> selectMarkOfPreliminaryInterview(int idVerify) throws ServiceException;

}
