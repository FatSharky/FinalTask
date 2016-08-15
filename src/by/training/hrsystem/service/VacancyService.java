package by.training.hrsystem.service;

import java.util.List;

import by.training.hrsystem.domain.Vacancy;
import by.training.hrsystem.service.exeption.ServiceException;

public interface VacancyService {

	List<Vacancy> selectAllVacancy(String lang) throws ServiceException;

}
