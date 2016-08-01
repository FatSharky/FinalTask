package by.training.hrsystem.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.controller.constant.ControllerFields;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommandName commandName = CommandName.valueOf((request.getParameter(ControllerFields.COMMAND)));
		Command command = CommandHelper.getCommand(commandName);
		command.execute(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CommandName commandName = CommandName.valueOf((request.getParameter(ControllerFields.COMMAND)));
		Command command = CommandHelper.getCommand(commandName);
		command.execute(request, response);
	}

}
