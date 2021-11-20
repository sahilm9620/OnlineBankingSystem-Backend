package in.co.vwits.onlinebanking.entity.exception;

public class PayeeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PayeeNotFoundException(String message) {
		super(message);
	}
}
