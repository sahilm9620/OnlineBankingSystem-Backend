package in.co.vwits.onlinebanking.entity.exception;

public class AccountNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundException(String message) {
		super(message);
	}
}