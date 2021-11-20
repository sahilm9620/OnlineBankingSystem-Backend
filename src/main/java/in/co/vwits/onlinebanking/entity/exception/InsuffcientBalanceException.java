package in.co.vwits.onlinebanking.entity.exception;

public class InsuffcientBalanceException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InsuffcientBalanceException(String message) {
		super(message);
	}
}
