package by.training.hrsystem.service;

import java.util.Date;

import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.WrongPasswordServiceException;

public interface UserService {
	User login(String email, String password)
			throws WrongEmailServiceException, WrongPasswordServiceException, ServiceException;

	User registration(String email, String password, String copyPass, String surname, String name, String secondName,
			String skype, String contcatPhone, String birth_date, Role role)
			throws WrongEmailServiceException, ServiceException;
}
