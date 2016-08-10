package by.training.hrsystem.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.command.util.QueryUtil;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;

public class ToPrivateOfficeCommand implements Command {

	private static final String USER_ATTR = "user";

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		User user = (User) request.getSession().getAttribute(USER_ATTR);
		if (user != null) {
			try {
				if (user.getRole() == Role.APPLICNAT) {
					request.getRequestDispatcher(PageName.APPLICANT_OFFICE_PAGE).forward(request, response);
				} else if (user.getRole() == Role.HR) {
					request.getRequestDispatcher(PageName.HR_OFFICE_PAGE).forward(request, response);
				}
			} catch (IOException | ServletException ex) {
				throw new CommandException(ex);
			}
			QueryUtil.saveHttpQuery(request);

		} else {
			try {
				request.getRequestDispatcher(PageName.ERROR_ACCESS_PAGE).forward(request, response);
			} catch (IOException | ServletException ex) {
				throw new CommandException(ex);
			}
		}

	}
}
