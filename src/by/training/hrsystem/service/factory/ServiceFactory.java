package by.training.hrsystem.service.factory;

import by.training.hrsystem.service.EducationService;
import by.training.hrsystem.service.InitConnectionService;
import by.training.hrsystem.service.UserService;
import by.training.hrsystem.service.impl.EducationServiceImpl;
import by.training.hrsystem.service.impl.InitConnectionServiceImpl;
import by.training.hrsystem.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory INSTANCE = new ServiceFactory();

	private final UserService userService = new UserServiceImpl();
	private final InitConnectionService initPoolService = new InitConnectionServiceImpl();
	private final EducationService educationService = new EducationServiceImpl();

	private ServiceFactory() {
	}

	public static ServiceFactory getInstance() {
		return INSTANCE;
	}

	public UserService getUserService() {
		return userService;
	}

	public InitConnectionService getInitPoolService() {
		return initPoolService;
	}

	public EducationService getEducationService() {
		return educationService;
	}

}
