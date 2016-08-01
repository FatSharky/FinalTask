package by.training.hrsystem.controller;

import by.training.hrsystem.command.Command;
import by.training.hrsystem.command.impl.ChangeLanguageCommand;
import by.training.hrsystem.command.impl.UserLoginCommand;

public class CommandHelper {

	public static Command getCommand(CommandName commandName) {
		switch (commandName) {
		case USER_LOGIN: {
			return new UserLoginCommand();
		}
		case SWITCH_LOCALE: {
			return new ChangeLanguageCommand();

		}
		case USER_REGISTRARION: {

		}

		default: {
			return null;
		}
		}
	}

}
