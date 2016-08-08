package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Education;

public interface EducationService {
	void addEducation(Education education);

	void updateEducation(Education education);

	void deleteEducation(int idEducation);

	void addTranslationEducation(Education education, String lang);

	void updateTranslationEducation(Education education, String lang);

	void deleteTranlationEducation(int idEducation, String lang);

	List<Education> selectEducationByIdResume(int idResume, String lang);

}
