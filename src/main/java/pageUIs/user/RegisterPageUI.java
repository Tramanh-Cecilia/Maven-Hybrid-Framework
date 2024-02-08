package pageUIs.user;

public class RegisterPageUI {
	public static final String FIRSTNAME_TEXTBOX ="xpath=//input[@id='FirstName']";
	public static final String LASTNAME_TEXTBOX ="xpath=//input[@id='LastName']";
	public static final String EMAIL_TEXTBOX ="xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX ="xpath=//input[@id='Password']";
	public static final String CONFRIM_PASSWORD_TEXTBOX ="xpath=//input[@id='ConfirmPassword']";
	public static final String REGISTER_BUTTON = "xpath=//button[@id='register-button']";
	public static final String SUCCESS_MSG = "xpath=//div[@class='result']";
	
	public static final String FIRSTNAME_ERROR_MSG = "xpath=//span[@id='FirstName-error']";
	public static final String LASTNAME_ERROR_MSG = "xpath=//span[@id='LastName-error']";
	public static final String EMAIL_ERROR_MSG = "xpath=//span[@id='Email-error']";
	public static final String PASSWORD_ERROR_MSG = "xpath=//span[@id='Password-error']";
	public static final String CONFIRMPASSWORD_ERROR_MSG = "xpath=//span[@id='ConfirmPassword-error']";
	public static final String EMAIL_VALIDATION_ERROR_MSG = "xpath=//div[@class='message-error validation-summary-errors']//li";
	
	public static final String DYNAMIC_ERROR_MESSAGE_BY_NAME= "xpath=//span[@id='%s']";
	public static final String DYNAMIC_TEXTBOX_BY_NAME= "xpath=//input[@id='%s']";
	
	public static final String CONTINUE_BUTTON_AFTER_REGISTRATION = "xpath=//a[text()='Continue']";
	

}
