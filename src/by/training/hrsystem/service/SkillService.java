package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Skill;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.skill.ListSkillIsEmptyServiceException;
import by.training.hrsystem.service.exeption.skill.SkillServiceException;
import by.training.hrsystem.service.exeption.skill.WrongRaitingServiceException;
import by.training.hrsystem.service.exeption.skill.WrongSkillNameServiceException;

public interface SkillService {
	void addSkill(String name, String raiting, int idResume)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException;

	void updateSkill(String name, String raiting, int idSkill)
			throws WrongSkillNameServiceException, WrongRaitingServiceException, ServiceException;

	void deleteSkill(int idSkill) throws ServiceException;

	List<Skill> selectSkillByIdResume(int idResume, String lang)
			throws ListSkillIsEmptyServiceException, SkillServiceException;
}
