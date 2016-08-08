package by.training.hrsystem.service.impl;

import by.training.hrsystem.dao.UserDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.UserService;
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
import by.training.hrsystem.service.parser.Parser;
import by.training.hrsystem.service.parser.exception.ParserException;
import by.training.hrsystem.service.validation.Validation;

public class UserServiceImpl implements UserService {

	@Override
	public User login(String email, String password)
			throws WrongEmailServiceException, WrongPasswordServiceException, ServiceException {
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			User user = userDAO.userAuthentication(email, password);
			if (user == null) {
				throw new WrongEmailServiceException("Wrong email");
			}
			if (!user.getPassword().equals(password)) {
				throw new WrongPasswordServiceException("Wrong password");
			}
			return user;
		} catch (DAOException e) {
			throw new ServiceException("Service layer: cannot make a login operation", e);
		}
	}

	@Override
	public User registration(String email, String password, String copyPass, String surname, String name,
			String secondName, String skype, String contcactPhone, String birth_date, Role role)
			throws WrongEmailServiceException, WrongPasswordServiceException, PasswordNotEqualsServiceException,
			WrongSurnameServiceException, WrongNameServiceException, WrongSecondnameServiceException,
			WrongSkypeServiceException, WrongPhoneServiceException, WrongBirthDateServiceException,
			UserWithThisEmailExistServiceException, UserServiceException, ServiceException {

		if (!Validation.validateEmail(email)) {
			throw new WrongEmailServiceException("Wrong email");
		}
		if (!Validation.validatePassword(password)) {
			throw new WrongPasswordServiceException("Wrong password");
		}
		if (!password.equals(copyPass)) {
			throw new PasswordNotEqualsServiceException("Password not equals");
		}
		if (!Validation.validateStringField(surname)) {
			throw new WrongSurnameServiceException("Wrong surname");
		}
		if (!Validation.validateStringField(name)) {
			throw new WrongNameServiceException("Wrong name");
		}
		if (!Validation.validateStringField(secondName)) {
			throw new WrongSecondnameServiceException("Wrong Surname");
		}
		if (!Validation.validateStringField(skype)) {
			throw new WrongSkypeServiceException("Wrong Skype");
		}
		if (!Validation.validatePhoneField(contcactPhone)) {
			throw new WrongPhoneServiceException("Wrong contact phone");
		}
		if (!Validation.validateFullDateField(birth_date)) {
			throw new WrongBirthDateServiceException("Wrong birht date");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();
			User userWithThisEmail = userDAO.getUserByEmail(email);
			if (userWithThisEmail != null) {
				throw new UserWithThisEmailExistServiceException("User with this email exist");
			}

			User newUser = new User();
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setSurname(surname);
			newUser.setName(name);
			newUser.setSkype(skype);
			newUser.setContactPhone(Parser.parseStringtoInt(contcactPhone));
			newUser.setBirthDate(Parser.parseToFullDate(birth_date));
			userDAO.addUser(newUser);

			return newUser;
		} catch (DAOException e) {
			throw new UserServiceException("Service layer: cannot make a registration", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: can not parse date");
		}
	}

}
