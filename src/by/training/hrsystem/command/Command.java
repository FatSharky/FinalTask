package by.training.hrsystem.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.hrsystem.command.exception.CommandException;

public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException;
}
