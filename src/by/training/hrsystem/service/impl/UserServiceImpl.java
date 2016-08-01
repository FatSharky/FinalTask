package by.training.hrsystem.service.impl;

import java.util.Date;

import by.training.hrsystem.dao.UserDAO;
import by.training.hrsystem.dao.exception.DAOException;
import by.training.hrsystem.dao.exception.DataDoesNotExistException;
import by.training.hrsystem.dao.factory.DAOFactory;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.WrongEmailServiceException;
import by.training.hrsystem.service.exeption.WrongPasswordServiceException;

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
	public User registration(String email, String password, String surname, String name, String secondName,
			String skype, int contcactPhone, Date birth_date, Role role)
			throws WrongEmailServiceException, ServiceException {
		try {
			DAOFactory daoFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoFactory.getUserDAO();

			User userWithThisEmail = userDAO.getUserByEmail(email);
			if (userWithThisEmail != null) {
				throw new WrongEmailServiceException("Wrong email");
			}

			User newUser = new User();
			newUser.setEmail(email);
			newUser.setPassword(password);
			newUser.setSurname(surname);
			newUser.setName(name);
			newUser.setSkype(skype);
			newUser.setContactPhone(contcactPhone);
			newUser.setBirthDate(birth_date);
			newUser.setRole(role);
			userDAO.addUser(newUser);

			return newUser;
		} catch (DAOException e) {
			throw new ServiceException("Service layer: cannot make a registration", e);
		} catch (DataDoesNotExistException e) {
			throw new ServiceException("Service layer: data does not exist");
		}
	}

}
