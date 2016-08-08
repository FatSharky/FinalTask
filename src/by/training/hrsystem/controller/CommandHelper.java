package by.training.hrsystem.controller;

import java.util.HashMap;
import java.util.Map;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.impl.ChangeLanguageCommand;
import by.training.hrsystem.command.impl.UserLoginCommand;
import by.training.hrsystem.command.impl.UserRegistrationCommand;

public class CommandHelper {
	private static final CommandHelper instance = new CommandHelper();
	private Map<CommandName, Command> commands = new HashMap<>();

	private CommandHelper() {
		commands.put(CommandName.USER_REGISTRARION, new UserRegistrationCommand());
		commands.put(CommandName.USER_LOGIN, new UserLoginCommand());
		commands.put(CommandName.SWITCH_LOCALE, new ChangeLanguageCommand());
	}

	public Command getCommand(String name) {
		name = name.replace('-', '_');
		CommandName commandName = CommandName.valueOf(name.toUpperCase());
		Command command = commands.get(commandName);
		return command;

	}

	public static CommandHelper getInstance() {
		return instance;
	}
}
