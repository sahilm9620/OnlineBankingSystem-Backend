package in.co.vwits.onlinebanking.utils;

public final class Constants {

	public static String WELCOME_EMAIL_TEMPLATE = "registration_email.ftlh";
	public static String ACCOUNT_VERIFICATION_EMAIL_TEMPLATE = "account_verify_email.ftlh";
	public static String AMOUNT_CREDITED_EMAIL_TEMPLATE = "credited.ftlh";
	public static String AMOUNT_DEBITED_EMAIL_TEMPLATE = "debited.ftlh";
	public static String YES = "Y";
	public static String NO = "N";
	public static String DEFAULT_ACCOUNT_TYPE = "Saving";
	public static String GET_ACCOUNT_DETAILS_API = "account/{acno}";
	public static String GET_ALL_ACCOUNT_DETAILS_API = "account/";
	public static String LIST_OF_ACCOUNTS_TO_BE_VERIFIED_API = "account/verify";
	public static String CHECK_ACCOUNT_VERIFICATION_API = "account/verify/{cid}";
	public static String VERIFY_ACCOUNT_API = "account/verify/{custId}/{adminId}";
	public static String GET_CUSTOMER_DETAILS_API = "customer/{CustId}";
	public static String GET_ALL_CUSTOMER_DETAILS_API = "customer";
	public static String ADD_CUSTOMER_DETAILS_API = "customer/add";
	public static String TRANSFER_MONEY_API = "transfer/{toAccNo}/{fromAccNo}/{transPassword}";
	public static String USER_LOGIN_API = "user/login";
	public static String ADMIN_LOGIN_API = "admin/login";
	public static String GET_PAYEES_OF_ACCOUNT_API = "payee/{accNo}";
	public static String GET_ALL_PAYEES_API = "payee";
	public static String ADD_PAYEE_API = "payee/add/{accNo}";
	public static String DELETE_PAYEE_API = "payee/delete/{beneficiaryId}";
	public static String CHANGE_LOGIN_PASSWORD_API = "customer/login/password";
	public static String CHANGE_TRANSACTION_PASSWORD_API = "customer/transaction/password";
	public static String CHANGE_ADMIN_PASSWORD_API = "admin/login/password";
	public static String GET_TRANSACTION_OF_ACCOUNT_API = "transaction/{accNo}";
	public static String GET_ALL_TRANSACTION_API = "transaction";

}
