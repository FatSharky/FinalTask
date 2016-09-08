package by.training.hrsystem.service;

import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.exeption.ServiceException;

public interface UserService {
	User login(String email, String password) throws ServiceException;

	User registration(String email, String password, String copyPass, String surname, String name, String secondName,
			String skype, String contcactPhone, String birth_date, String role) throws ServiceException;

	User updateProfile(String password, String copyPass, String surname, String name, String secondName, String skype,
			String contcactPhone, String birth_date, String email) throws ServiceException;

	User selectUserByEmail(String email) throws ServiceException;

	User selectUserByIdVacancy(int idVacancy) throws ServiceException;

	User selectUserByIdResume(int idResume) throws ServiceException;

	int countAllApplicants() throws ServiceException;;
}
