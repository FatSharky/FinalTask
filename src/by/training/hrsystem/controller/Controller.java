package by.training.hrsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public final static String COMMAND = "command";

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND);
		Command command = CommandHelper.getInstance().getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (CommandException ex) {
			request.getRequestDispatcher(PageName.ERROR_PAGE).forward(request, response);
		}
	}

}
