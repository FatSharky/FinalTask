package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.command.util.QueryUtil;
import by.training.hrsystem.service.ResumeService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class ToIndexPageCommand implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {

		logger.debug("ToIndexPageCommand:execute() start");

		try {
			ServiceFactory serviceFactory = ServiceFactory.getInstance();
			ResumeService resumeService = serviceFactory.getResumeService();
			int countResume = resumeService.countAllResume();
			request.setAttribute(Attribute.COUNT_ALL_RESUME, countResume);
			request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			QueryUtil.saveHttpQuery(request);
		} catch (ServiceException e) {
			throw new CommandException("comand layer");
		}

	}
}