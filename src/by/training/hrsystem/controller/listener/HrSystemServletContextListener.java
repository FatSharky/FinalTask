package by.training.hrsystem.controller.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.training.hrsystem.service.InitConnectionService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class HrSystemServletContextListener implements ServletContextListener {

	public HrSystemServletContextListener() {
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		InitConnectionService poolService = serviceFactory.getInitPoolService();
		try {
			poolService.initConnection();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		InitConnectionService poolService = serviceFactory.getInitPoolService();
		try {
			poolService.destroyConnection();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
