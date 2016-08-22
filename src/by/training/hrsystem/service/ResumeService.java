package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.ListResumeIsEmptyServiceException;
import by.training.hrsystem.service.exeption.resume.WrongResumeNameServiceException;

public interface ResumeService {
	void addResume(String name, String military, String email) throws WrongResumeNameServiceException, ServiceException;

	void updateResume(String name, String military, String idResume);

	void deleteResume(String idResume);

	List<Resume> selectResumeByEmail(String email, String lang)
			throws ListResumeIsEmptyServiceException, ServiceException;

	int countAllResume() throws ServiceException;
}
