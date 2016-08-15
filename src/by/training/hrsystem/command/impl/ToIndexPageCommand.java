package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.command.util.QueryUtil;

public class ToIndexPageCommand implements Command {

	public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException {

		try {
			request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
		} catch (IOException | ServletException ex) {
			throw new CommandException(ex);
		}
		QueryUtil.saveHttpQuery(request);
	}
}
