package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.ResumeDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Resume;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.resume.WrongResumeNameServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class ResumeServiceImpl implements ResumeService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addResume(String name, String military, String email)
			throws WrongResumeNameServiceException, ServiceException {

		logger.debug("ResumeServiceImpl: addResume() : user's data is valid (name = {}, military={}, email={}", name,
				military, email);

		if (!Validation.validateStringField(name)) {
			throw new WrongResumeNameServiceException("wrong resume name");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			ResumeDAO resumeDAO = daoFactory.getResumeDAO();
			Resume resume = new Resume();
			resume.setName(name);
			resume.setMilitatyType(Parser.fromStringToMilitaryType(military));
			User applicant = new User();
			applicant.setEmail(email);
			resume.setApplicant(applicant);

			resumeDAO.addResume(resume);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new resume", e);
		}

	}

	@Override
	public void updateResume(String name, String military, String idResume) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteResume(String idResume) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Resume> selectResumeByEmail(String email, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

}
