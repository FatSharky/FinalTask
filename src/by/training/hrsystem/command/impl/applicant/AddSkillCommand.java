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
import by.training.hrsystem.service.SkillService;
import by.training.hrsystem.service.exeption.ServiceException;
import by.training.hrsystem.service.exeption.skill.WrongRaitingServiceException;
import by.training.hrsystem.service.exeption.skill.WrongSkillNameServiceException;
import by.training.hrsystem.service.factory.ServiceFactory;

public class AddSkillCommand implements Command{

	private static final Logger logger = LogManager.getRootLogger();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws CommandException, ServletException, IOException {
		logger.debug("addSkillCommand:execute() start");
		int idResume = Integer.parseInt(request.getParameter(Attribute.ID_RESUME));
		User user = (User) request.getSession().getAttribute(Attribute.USER);

		String skillName = request.getParameter(Attribute.SKILL_NAME);
		String skillLevel = request.getParameter(Attribute.SKILL_LEVEL);
		if (user != null) {
			if (user.getRole() == Role.APPLICANT) {
				ServiceFactory serviceFactory = ServiceFactory.getInstance();
				SkillService skillService = serviceFactory.getSkillService();
				
				try {
					skillService.addSkill(skillName, skillLevel, idResume);
				} catch (WrongSkillNameServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WrongRaitingServiceException e) {
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

		logger.debug("addSkillCommand:execute() stop");
	}


}
