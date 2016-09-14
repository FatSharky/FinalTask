package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Verify;
import by.training.hrsystem.service.exeption.ServiceException;

public interface VerifyService {
	void addResumeToVacancy(int idVacancy, int idResume) throws ServiceException;

	List<Verify> verifyList(int idVacancy) throws ServiceException;

	List<Verify> passVerifyList(int idVacancy) throws ServiceException;

	Verify selectVerifyById(int idVerify) throws ServiceException;

	void verifyResumePass(int idVerify) throws ServiceException;

	void verifyResumeNotPass(int idVerify) throws ServiceException;
}
