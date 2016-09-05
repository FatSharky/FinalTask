package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.ListResumeIsEmptyServiceException;
import by.training.hrsystem.service.exeption.resume.WrongResumeNameServiceException;

public interface ResumeService {
	void addResume(String name, String military, String email) throws WrongResumeNameServiceException, ServiceException;

	void updateResume(String name, String military, int idResume)
			throws WrongResumeNameServiceException, ServiceException;

	void deleteResume(String idResume);

	List<Resume> selectResumeByEmail(String email, String lang, int first, int perPage)
			throws ListResumeIsEmptyServiceException, ServiceException;

	List<Resume> selectResumeForVacancy(String applicantEmail, String lang) throws ServiceException;

	int countAllResume() throws ServiceException;

	int countVacancyByEmail(String hrEmail) throws ServiceException;

	Resume selectResumeById(int idResume, String lang) throws ServiceException;

	List<Resume> selectListResumeByVacancy(int idVacancy) throws ServiceException;

}
