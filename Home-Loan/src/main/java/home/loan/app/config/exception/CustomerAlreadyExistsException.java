package home.loan.app.config.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	public CustomerAlreadyExistsException(String msg) {
		super(msg);
	}
}
