package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.InterviewMarkDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.InterviewMark;
import by.training.hrsystem.service.InterviewMarkService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class InterviewMarkServiceImpl implements InterviewMarkService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addMark(String skill, String mark, String idInterview) throws ServiceException {

		logger.debug("InterviewMarkServiceImpl.addMark() user's data is valid skill = {}, mark={}, idInterview={}",
				skill, mark, idInterview);

		if (!Validation.validateSmallMultyTextField(skill)) {
			throw new ServiceException("wrong skill name");
		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			InterviewMarkDAO interviewMarkDAO = daoFactory.getInterviewMarkDAO();
			InterviewMark interviewMark = new InterviewMark();
			interviewMark.setSkill(skill);
			interviewMark.setMark(Parser.fromStringToSkill(mark));
			interviewMark.setIdInterview(Parser.parseStringtoInt(idInterview));
			interviewMarkDAO.addMark(interviewMark);
		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new skill", e);
		}

	}

	@Override
	public List<InterviewMark> selectMarkOfTechicalInterview(int idVerify) throws ServiceException {
		logger.debug("InterviewMarkServiceImpl.selectMarkOfTechicalInterview() : idVerify", idVerify);
		List<InterviewMark> listInterviewMark = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			InterviewMarkDAO interviewMarkDAO = daoFactory.getInterviewMarkDAO();
			listInterviewMark = interviewMarkDAO.selectMarkOfTechicalInterview(idVerify);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not show list of marks");
		}
		return listInterviewMark;
	}

	@Override
	public List<InterviewMark> selectMarkOfPreliminaryInterview(int idVerify) throws ServiceException {
		logger.debug("InterviewMarkServiceImpl.selectMarkOfPreliminaryInterview : idVerify", idVerify);
		List<InterviewMark> listInterviewMark = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			InterviewMarkDAO interviewMarkDAO = daoFactory.getInterviewMarkDAO();
			listInterviewMark = interviewMarkDAO.selectMarkOfPreliminaryInterview(idVerify);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not show list of marks");
		}
		return listInterviewMark;
	}

	@Override
	public void deleteInterviewMark(int idMark) throws ServiceException {
		logger.debug("InterviewMarkServiceImpl.deleteInterviewMark : idMark={}", idMark);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			InterviewMarkDAO interviewMarkDAO = daoFactory.getInterviewMarkDAO();
			interviewMarkDAO.deleteMark(idMark);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not delete interview mark");
		}

	}

}
