package by.training.hrsystem.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.impl.ChangeLocaleCommand;
import by.training.hrsystem.command.impl.ToIndexPageCommand;
import by.training.hrsystem.command.impl.ToPrivateOfficeCommand;
import by.training.hrsystem.command.impl.ToRegstrationPageCommand;
import by.training.hrsystem.command.impl.UserLogOutCommand;
import by.training.hrsystem.command.impl.UserLoginCommand;
import by.training.hrsystem.command.impl.UserRegistrationCommand;

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
