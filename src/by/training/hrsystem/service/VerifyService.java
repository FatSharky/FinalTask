package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Verify;
import by.training.hrsystem.service.exeption.ServiceException;

public interface VerifyService {
	void addResumeToVacancy(int idVacancy, int idResume) throws ServiceException;

	List<Verify> verifyList(int idVacancy) throws ServiceException;

}
