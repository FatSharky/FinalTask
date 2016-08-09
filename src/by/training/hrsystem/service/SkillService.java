package by.training.hrsystem.service;

import by.training.hrsystem.domain.type.SkillType;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.skill.WrongRaitingServiceException;
import by.training.hrsystem.service.exeption.skill.WrongSkillNameServiceException;

public interface SkillService {
	void addSkill(String name, SkillType raiting, String idResume)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException;

	void updateSkill(String name, SkillType raiting, String idSkill)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException;

	void deleteSkill(String idSkill) throws ServiceException;
}
