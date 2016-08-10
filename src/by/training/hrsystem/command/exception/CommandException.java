package by.training.hrsystem.command.exception;

public class CommandException extends Exception {

	private static final long serialVersionUID = 1L;

	public CommandException(Exception message) {
		super(message);
	}

	public CommandException(String message) {
		super(message);
	}

	public CommandException(String message, Throwable cause) {
		super(message, cause);
	}
}
