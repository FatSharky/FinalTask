package by.training.hrsystem.dao;

import java.util.List;

import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.domain.Skill;

public interface SkillDAO {

	void addSkill(Skill skill) throws DAOException;

	void updateSkill(Skill skill) throws DAOException;

	void deleteSkill(int idSkill) throws DAOException;

	void addTranslateSkill(Skill skill, String lang) throws DAOException;

	void updateTranslateSkill(Skill skill, String lang) throws DAOException;

	void deleteTranslateSkill(int idSkill, String lang) throws DAOException;

	List<Skill> getSkillByIdResume(int idResume, String lang) throws DAOException, DataDoesNotExistException;

}
