package home.loan.app.config.exception;

public class LoginRequiredException extends RuntimeException {

		public LoginRequiredException(String message) {
			super(message);
		}
}
