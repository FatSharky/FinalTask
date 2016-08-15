package by.training.hrsystem.service.impl;

import java.util.List;

import by.training.hrsystem.dao.SkillDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
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

	@Override
	public void addSkill(String name, String raiting, String idResume)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException {
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
			skill.setIdResume(Parser.parseStringtoInt(idResume));

			skillDAO.addSkill(skill);

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new skill", e);
		}

	}

	@Override
	public void updateSkill(String name, String raiting, String idSkill)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException {
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
			skill.setIdResume(Parser.parseStringtoInt(idSkill));

			skillDAO.updateSkill(skill);
			;

		} catch (DAOException | ParserException e) {
			throw new ServiceException("Service layer: cannot make a new skill", e);
		}

	}

	@Override
	public void deleteSkill(String idSkill) throws ServiceException {
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			SkillDAO skillDAO = daoFactory.getSkillDAO();
			skillDAO.deleteSkill(Parser.parseStringtoInt(idSkill));
		} catch (DAOException e) {
			throw new ServiceException("Service layer: can not delete education");
		}

	}

	@Override
	public List<Skill> selectSkillByIdResume(String idResume, String lang)
			throws ListSkillIsEmptyServiceException, SkillServiceException {
		List<Skill> listSkill = null;
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			SkillDAO skillDAO = daoFactory.getSkillDAO();
			try {
				listSkill = skillDAO.getSkillByIdResume(Parser.parseStringtoInt(idResume), lang);
			} catch (DataDoesNotExistException e) {
				throw new ListSkillIsEmptyServiceException("list is empty");
			}
		} catch (DAOException e) {
			throw new SkillServiceException("Service laye: can not show list of education");
		}
		return listSkill;
	}
}
