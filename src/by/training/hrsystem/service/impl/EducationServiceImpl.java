package by.training.hrsystem.service.impl;

import java.util.List;

import by.training.hrsystem.dao.EducationDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.Education;
import by.training.hrsystem.service.EducationService;

public class EducationServiceImpl implements EducationService {

	@Override
	public void addEducation(Education education) {
		if (education == null) {

		}
		// Validation from note
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();
			educationDAO.addEducation(education);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateEducation(Education education) {

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();
			educationDAO.updateEducation(education);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEducation(int idEducation) {
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();
			educationDAO.deleteEducation(idEducation);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addTranslationEducation(Education education, String lang) {
		if (education == null) {

		}
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			EducationDAO educationDAO = daoFactory.getEducationDAO();
			educationDAO.addTranslateEduc(education, lang);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updateTranslationEducation(Education education, String lang) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteTranlationEducation(int idEducation, String lang) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Education> selectEducationByIdResume(int idResume, String lang) {
		// TODO Auto-generated method stub
		return null;
	}

}
