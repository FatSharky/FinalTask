package by.training.hrsystem.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.impl.ChangeLocaleCommand;
import by.training.hrsystem.command.impl.ToIndexPageCommand;
import by.training.hrsystem.command.impl.ToRegstrationPageCommand;
import by.training.hrsystem.command.impl.UserLogOutCommand;
import by.training.hrsystem.command.impl.UserLoginCommand;
import by.training.hrsystem.command.impl.UserRegistrationCommand;
import by.training.hrsystem.command.impl.applicant.AddEducationCommand;
import by.training.hrsystem.command.impl.applicant.AddResumeCommand;
import by.training.hrsystem.command.impl.applicant.AddResumeLanguageCommand;
import by.training.hrsystem.command.impl.applicant.AddResumeToVacancyCommand;
import by.training.hrsystem.command.impl.applicant.AddSkillCommand;
import by.training.hrsystem.command.impl.applicant.AddWorkplaceCommand;
import by.training.hrsystem.command.impl.applicant.DeleteEducationCommand;
import by.training.hrsystem.command.impl.applicant.DeleteResumeLanguageCommand;
import by.training.hrsystem.command.impl.applicant.DeleteSkillCommand;
import by.training.hrsystem.command.impl.applicant.DeleteWorkPlaceCommand;
import by.training.hrsystem.command.impl.applicant.EditEducationCommand;
import by.training.hrsystem.command.impl.applicant.EditResumeCommand;
import by.training.hrsystem.command.impl.applicant.EditResumeLanguageCommand;
import by.training.hrsystem.command.impl.applicant.EditSkillCommand;
import by.training.hrsystem.command.impl.applicant.EditWorkPlaceCommand;
import by.training.hrsystem.command.impl.applicant.ShowResumeCommand;
import by.training.hrsystem.command.impl.applicant.ToApplicantAddResumeCommand;
import by.training.hrsystem.command.impl.applicant.ToApplicantEditResumeCommand;
import by.training.hrsystem.command.impl.applicant.ToApplicantListResumeCommand;
import by.training.hrsystem.command.impl.common.ApplicantEditProfileCommand;
import by.training.hrsystem.command.impl.common.SearchVacancyByNameCommand;
import by.training.hrsystem.command.impl.common.ShowVacancyCommand;
import by.training.hrsystem.command.impl.common.ToEditProfileCommand;
import by.training.hrsystem.command.impl.common.ToPrivateOfficeCommand;
import by.training.hrsystem.command.impl.hr.ActivateVacancyCommand;
import by.training.hrsystem.command.impl.hr.AddVacancyCommand;
import by.training.hrsystem.command.impl.hr.DeactivateVacancyCommand;
import by.training.hrsystem.command.impl.hr.DeleteVacancyCommand;
import by.training.hrsystem.command.impl.hr.HotVacancyCommand;
import by.training.hrsystem.command.impl.hr.HrPrivateOfficeShowVacancy;
import by.training.hrsystem.command.impl.hr.ShowApplicantsWhoLeaveResume;
import by.training.hrsystem.command.impl.hr.ToHrAddVacancyCommand;
import by.training.hrsystem.command.impl.hr.ToHrListVacancyCommand;
import by.training.hrsystem.command.impl.hr.ToVerifyListCommand;

public class CommandHelper {
	private static final CommandHelper INSTANCE = new CommandHelper();
	private Map<CommandName, Command> commands = new HashMap<>();

	private CommandHelper() {
		commands.put(CommandName.USER_REGISTRARION, new UserRegistrationCommand());
		commands.put(CommandName.USER_LOGIN, new UserLoginCommand());
		commands.put(CommandName.USER_LOGOUT, new UserLogOutCommand());
		commands.put(CommandName.SWITCH_LOCALE, new ChangeLocaleCommand());
		commands.put(CommandName.TO_REGISTRATION_PAGE, new ToRegstrationPageCommand());
		commands.put(CommandName.TO_PRIVATE_OFFICE, new ToPrivateOfficeCommand());
		commands.put(CommandName.TO_INDEX_PAGE, new ToIndexPageCommand());
		commands.put(CommandName.TO_APPLICANT_EDIT_PROFILE, new ToEditProfileCommand());
		commands.put(CommandName.APPLICANT_EDIT_PROFILE, new ApplicantEditProfileCommand());
		commands.put(CommandName.TO_APPLICANT_ADD_RESUME, new ToApplicantAddResumeCommand());
		commands.put(CommandName.ADD_RESUME, new AddResumeCommand());
		commands.put(CommandName.TO_APPLICANT_LIST_RESUME, new ToApplicantListResumeCommand());
		commands.put(CommandName.SHOW_VACANCY, new ShowVacancyCommand());
		commands.put(CommandName.TO_HR_LIST_VACANCY, new ToHrListVacancyCommand());
		commands.put(CommandName.TO_HR_ADD_VACANCY_PAGE, new ToHrAddVacancyCommand());
		commands.put(CommandName.ADD_VACANCY, new AddVacancyCommand());
		commands.put(CommandName.HR_PRIVATE_OFFICE_SHOW_VACANCY, new HrPrivateOfficeShowVacancy());
		commands.put(CommandName.DELETE_VACANCY, new DeleteVacancyCommand());
		commands.put(CommandName.ACTIVATE_VACANCY, new ActivateVacancyCommand());
		commands.put(CommandName.DEACTIVATE_VACANCY, new DeactivateVacancyCommand());
		commands.put(CommandName.HOT_VACANCY, new HotVacancyCommand());
		commands.put(CommandName.TO_APPLICANT_EDIT_RESUME, new ToApplicantEditResumeCommand());
		commands.put(CommandName.SHOW_RESUME, new ShowResumeCommand());
		commands.put(CommandName.EDIT_RESUME, new EditResumeCommand());
		commands.put(CommandName.ADD_EDUCATION, new AddEducationCommand());
		commands.put(CommandName.DELETE_EDUCATION, new DeleteEducationCommand());
		commands.put(CommandName.EDIT_EDUCATION, new EditEducationCommand());
		commands.put(CommandName.ADD_RESUME_LANGUAGE, new AddResumeLanguageCommand());
		commands.put(CommandName.DELETE_RESUME_LANGUAGE, new DeleteResumeLanguageCommand());
		commands.put(CommandName.EDIT_RESUME_LANGUAGE, new EditResumeLanguageCommand());
		commands.put(CommandName.ADD_SKILL, new AddSkillCommand());
		commands.put(CommandName.DELETE_SKILL, new DeleteSkillCommand());
		commands.put(CommandName.EDIT_SKILL, new EditSkillCommand());
		commands.put(CommandName.ADD_WORKPLACE, new AddWorkplaceCommand());
		commands.put(CommandName.EDIT_WORKPLACE, new EditWorkPlaceCommand());
		commands.put(CommandName.DELETE_WORKPLACE, new DeleteWorkPlaceCommand());
		commands.put(CommandName.SEARCH_VACANCY, new SearchVacancyByNameCommand());
		commands.put(CommandName.ADD_RESUME_TO_VACANCY, new AddResumeToVacancyCommand());
		commands.put(CommandName.TO_VERIFY_LIST, new ToVerifyListCommand());
		commands.put(CommandName.SHOW_APPLICANT_WHO_LEAVE_RESUME, new ShowApplicantsWhoLeaveResume());

	}

	public Command getCommand(String name) {
		name = name.replace('-', '_');
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;

	}

	public static CommandHelper getInstance() {
		return INSTANCE;
	}
}
