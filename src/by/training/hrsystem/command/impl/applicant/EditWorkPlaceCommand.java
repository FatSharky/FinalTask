package by.training.hrsystem.command.impl.applicant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.constant.Attribute;
import by.training.hrsystem.command.constant.PageName;
import by.training.hrsystem.command.exception.CommandException;
import by.training.hrsystem.domain.User;
import by.training.hrsystem.domain.role.Role;
import by.training.hrsystem.service.WorkPlaceService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongCompanyNameServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongDateBeginServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongDateEndServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongDateServiceException;
import by.training.hrsystem.service.exeption.workplace.WrongPositionServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class EditWorkPlaceCommand implements Command {

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("EditWorkPlaceCommand:execute() start");
		int idWorkplace = Integer.parseInt(request.getParameter(Attribute.ID_WORKPLACE));
		User user = (User) request.getSession().getAttribute(Attribute.USER);

		String name = request.getParameter(Attribute.WORKPLACE_NAME);
		String position = request.getParameter(Attribute.WORKPLACE_POSITION);
		String dateBegin = request.getParameter(Attribute.WORKPLACE_DATE_BEGIN);
		String dateEnd = request.getParameter(Attribute.WORKPLACE_DATE_END);
		if (user != null) {
			if (user.getRole() == Role.APPLICANT) {
				ServiceFactory serviceFactory = ServiceFactory.getInstance();
				WorkPlaceService workPlaceService = serviceFactory.getWorkPlaceService();

				try {
					workPlaceService.updateWorkplace(name, position, dateBegin, dateEnd, idWorkplace);
				} catch (WrongCompanyNameServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WrongPositionServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WrongDateBeginServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WrongDateEndServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WrongDateServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			HttpSession session = request.getSession(true);
			String prevQuery = (String) session.getAttribute(Attribute.PREV_QUERY);
			if (prevQuery != null) {
				response.sendRedirect(prevQuery);
			} else {
				request.getRequestDispatcher(PageName.INDEX_PAGE).forward(request, response);
			}
		} else {
			request.getRequestDispatcher(PageName.ERROR_ACCESS_PAGE).forward(request, response);
		}

		logger.debug("EditWorkplaceCommand:execute() stop");
	}

}
