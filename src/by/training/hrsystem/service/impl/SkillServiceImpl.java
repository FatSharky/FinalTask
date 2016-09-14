package by.training.hrsystem.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.dao.SkillDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Skill;
import by.training.hrsystem.service.SkillService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.skill.ListSkillIsEmptyServiceException;
import by.training.hrsystem.service.exeption.skill.SkillServiceException;
import by.training.hrsystem.service.exeption.skill.WrongRaitingServiceException;
import by.training.hrsystem.service.exeption.skill.WrongSkillNameServiceException;
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class SkillServiceImpl implements SkillService {
	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void addSkill(String name, String raiting, int idResume)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException {

		logger.debug("SkillServiceImpl: addSkill() : user's data is valid (name = {}, raiting={}, idResume={}", name,
				raiting, idResume);

		if (!Validation.validateStringField(name)) {
			throw new WrongSkillNameServiceException("wrong skillName");
		}
		if (raiting == null) {
			throw new WrongRaitingServiceException("wrong raiting");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			SkillDAO skillDAO = daoFactory.getSkillDAO();

			Skill skill = new Skill();
			skill.setName(name);
			skill.setRaiting(Parser.fromStringToSkill(raiting));
			skill.setIdResume(idResume);

			skillDAO.addSkill(skill);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new skill", e);
		}

	}

	@Override
	public void updateSkill(String name, String raiting, int idSkill)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException {
		if (!Validation.validateStringField(name)) {
			logger.debug("SkillServiceImpl: updateSkill() : user's data is valid (name = {}, raiting={}, idSkill={}",
					name, raiting, idSkill);
			throw new WrongSkillNameServiceException("wrong skillName");
		}
		if (raiting == null) {
			throw new WrongRaitingServiceException("wrong raiting");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			SkillDAO skillDAO = daoFactory.getSkillDAO();

			Skill skill = new Skill();
			skill.setName(name);
			skill.setRaiting(Parser.fromStringToSkill(raiting));
			skill.setIdSkill(idSkill);
			skillDAO.updateSkill(skill);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new skill", e);
		}

	}

	@Override
	public void deleteSkill(int idSkill) throws ServiceException {
		logger.debug("SkillServiceImpl: deleteSkill() : user's data is valid (idSkill={}", idSkill);
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			SkillDAO skillDAO = daoFactory.getSkillDAO();
			skillDAO.deleteSkill(idSkill);
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not delete education");
		}

	}

	@Override
	public List<Skill> selectSkillByIdResume(int idResume, String lang)
			throws ListSkillIsEmptyServiceException, SkillServiceException {
		logger.debug("SkillServiceImpl: selectSkillByIdResume(): user's data is valid (idResume={}, lang={}", idResume,
				lang);
		List<Skill> listSkill = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			SkillDAO skillDAO = daoFactory.getSkillDAO();

			listSkill = skillDAO.getSkillByIdResume(idResume, lang);

		} catch (DAOException e) {
			throw new SkillServiceException("Service laye: can not show list of education");
		}
		return listSkill;
	}
}
