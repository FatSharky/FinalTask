package by.training.hrsystem.service;

import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.userexception.UserServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongBirthDateServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongNameServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongPasswordServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongPhoneServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSkypeServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSurnameServiceException;

public interface UserService {
	User login(String email, String password)
			throws WrongEmailServiceException, WrongPasswordServiceException, ServiceException;

	User registration(String email, String password, String copyPass, String surname, String name, String secondName,
			String skype, String contcatPhone, String birth_date, Role role)
			throws WrongEmailServiceException, WrongPasswordServiceException, WrongSurnameServiceException,
			WrongNameServiceException, WrongSkypeServiceException, WrongPhoneServiceException,
			WrongBirthDateServiceException, UserServiceException, ServiceException;
}
