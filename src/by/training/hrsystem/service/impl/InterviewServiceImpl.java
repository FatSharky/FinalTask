package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.InterviewDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Interview;
import by.training.hrsystem.domain.Verify;
import by.training.hrsystem.service.InterviewService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.interview.InterviewServiceException;
import by.training.hrsystem.service.exeption.interview.WrongDateInterviewServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class InterviewServiceImpl implements InterviewService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addInterviewService(String interivewType, String dateInterview, String idVerify)
			throws WrongDateInterviewServiceException, InterviewServiceException, ServiceException {
		logger.debug(
				"InterviewServiceImpl : registration() : interview's data is valid (interivewType = {}, dateInterview = {}, "
						+ "idVerify = {}",
				interivewType, dateInterview, idVerify);

		if (!Validation.validateDateTime(dateInterview)) {
			throw new WrongDateInterviewServiceException("wrong dateInterview");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			InterviewDAO interviewDAO = daoFactory.getInterviewDAO();

			Interview interview = new Interview();
			interview.setInterviewType(Parser.fromStringToInterviewType(interivewType));
			interview.setDateBegin(Parser.parseToDateTime(dateInterview));
			Verify verify = new Verify();
			verify.setIdVerify(Parser.parseStringtoInt(idVerify));
			interview.setVerify(verify);
			interviewDAO.addInterview(interview);
		} catch (DAOException e) {
			throw new InterviewServiceException("Service layer: cannot make a registration", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: can not parse date");
		}

	}

	@Override
	public List<Interview> selectInterviewByVerify(int idVerify) throws ServiceException {
		logger.debug("InterviewServiceImpl.selectInterviewByVerify() : idVerify", idVerify);
		List<Interview> listInterview = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			InterviewDAO interviewDAO = daoFactory.getInterviewDAO();
			listInterview = interviewDAO.selectInterviewByIdVerify(idVerify);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not show list of interview");
		}
		return listInterview;
	}

}
