package by.training.hrsystem.service;

import by.training.hrsystem.domain.User;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.user.PasswordNotEqualsServiceException;
import by.training.hrsystem.service.exeption.user.UserServiceException;
import by.training.hrsystem.service.exeption.user.UserWithThisEmailExistServiceException;
import by.training.hrsystem.service.exeption.user.WrongBirthDateServiceException;
import by.training.hrsystem.service.exeption.user.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.user.WrongNameServiceException;
import by.training.hrsystem.service.exeption.user.WrongPasswordServiceException;
import by.training.hrsystem.service.exeption.user.WrongPhoneServiceException;
import by.training.hrsystem.service.exeption.user.WrongSecondnameServiceException;
import by.training.hrsystem.service.exeption.user.WrongSkypeServiceException;
import by.training.hrsystem.service.exeption.user.WrongSurnameServiceException;

public interface UserService {
	User login(String email, String password)
			throws WrongEmailServiceException, WrongPasswordServiceException, ServiceException;

	User registration(String email, String password, String copyPass, String surname, String name, String secondName,
			String skype, String contcactPhone, String birth_date, String role)
			throws WrongEmailServiceException, WrongPasswordServiceException, PasswordNotEqualsServiceException,
			WrongSurnameServiceException, WrongNameServiceException, WrongSecondnameServiceException,
			WrongSkypeServiceException, WrongPhoneServiceException, WrongBirthDateServiceException,
			UserWithThisEmailExistServiceException, UserServiceException, ServiceException;
	
	User updateProfile(String password, String copyPass, String surname, String name, String secondName,
			String skype, String contcactPhone, String birth_date, String email)
			throws WrongEmailServiceException, WrongPasswordServiceException, PasswordNotEqualsServiceException,
			WrongSurnameServiceException, WrongNameServiceException, WrongSecondnameServiceException,
			WrongSkypeServiceException, WrongPhoneServiceException, WrongBirthDateServiceException,
			UserWithThisEmailExistServiceException, UserServiceException, ServiceException;

}
