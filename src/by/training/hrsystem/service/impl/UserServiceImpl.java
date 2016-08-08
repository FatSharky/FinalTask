package by.training.hrsystem.service.impl;

import by.training.hrsystem.dao.UserDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.UserServiceException;
import by.training.hrsystem.service.exeption.WrongBirthDateServiceException;
import by.training.hrsystem.service.exeption.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.WrongNameServiceException;
import by.training.hrsystem.service.exeption.WrongPasswordServiceException;
import by.training.hrsystem.service.exeption.WrongPhoneServiceException;
import by.training.hrsystem.service.exeption.WrongSkypeServiceException;
import by.training.hrsystem.service.exeption.WrongSurnameServiceException;
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
		} catch (DataDoesNotExistException e) {
			throw new ServiceException("Service layer: cannot find user");
		}
	}

	@Override
	public User registration(String email, String password, String copyPass, String surname, String name,
			String secondName, String skype, String contcactPhone, String birth_date, Role role)
			throws ServiceException {

		if (!Validation.validateEmail(email)) {
			throw new WrongEmailServiceException("Wrong email");
		}
		if (!Validation.validatePassword(password, copyPass)) {
			throw new WrongPasswordServiceException("Passwords do not match");
		}
		if (!Validation.validateStringField(surname)) {
			throw new WrongSurnameServiceException("Wrong surname");
		}
		if (!Validation.validateStringField(name)) {
			throw new WrongNameServiceException("Wrong name");
		}
		if (!Validation.validateStringField(secondName)) {
			throw new WrongSurnameServiceException("Wrong Surname");
		}
		if (!Validation.validateStringField(skype)) {
			throw new WrongSkypeServiceException("Wrong Skype");
		}
		if (!Validation.validatePhoneField(contcactPhone)) {
			throw new WrongPhoneServiceException("Wrong contact phone");
		}
		if (!Validation.validateDateField(birth_date)) {
			throw new WrongBirthDateServiceException("Wrong birht date");
		}

		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();

			User newUser = new User();
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setSurname(surname);
			newUser.setName(name);
			newUser.setSkype(skype);
			newUser.setContactPhone(Parser.parseStringtoInt(contcactPhone));
			newUser.setBirthDate(Parser.parseStringtoDate(birth_date));
			newUser.setRole(role.APPLICNAT);
			userDAO.addUser(newUser);

			return newUser;
		} catch (DAOException e) {
			throw new UserServiceException("Service layer: cannot make a registration", e);
		} catch (ParserException e) {
			throw new ServiceException("Service layer: cannot parse");
		}
	}

}
