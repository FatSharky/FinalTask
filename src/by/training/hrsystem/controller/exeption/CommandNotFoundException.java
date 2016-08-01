package by.training.hrsystem.controller.exeption;

public class CommandNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommandNotFoundException(String message) {
		super(message);
	}

	public CommandNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
