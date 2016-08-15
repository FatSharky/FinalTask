package by.training.hrsystem.service;

import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.userexception.PasswordNotEqualsServiceException;
import by.training.hrsystem.service.exeption.userexception.UserServiceException;
import by.training.hrsystem.service.exeption.userexception.UserWithThisEmailExistServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongBirthDateServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongNameServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongPasswordServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongPhoneServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSecondnameServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSkypeServiceException;
import by.training.hrsystem.service.exeption.userexception.WrongSurnameServiceException;

public interface UserService {
	User login(String email, String password)
			throws WrongEmailServiceException, WrongPasswordServiceException, ServiceException;

	User registration(String email, String password, String copyPass, String surname, String name, String secondName,
			String skype, String contcactPhone, String birth_date)
			throws WrongEmailServiceException, WrongPasswordServiceException, PasswordNotEqualsServiceException,
			WrongSurnameServiceException, WrongNameServiceException, WrongSecondnameServiceException,
			WrongSkypeServiceException, WrongPhoneServiceException, WrongBirthDateServiceException,
			UserWithThisEmailExistServiceException, UserServiceException, ServiceException;
}
