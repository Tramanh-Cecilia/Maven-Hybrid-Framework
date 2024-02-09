package pageUIs.user;

public class UserLoginPageUI {
	public static final String EMAIL_TEXTBOX="xpath=//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX="xpath=//input[@id='Password']";
	public static final String DYNAMIC_TEXTBOX_BY_NAME="xpath=//input[@id='%s']";
	
	public static final String LOGIN_BUTTON="xpath=//button[@class='button-1 login-button']";
	
	public static final String LOGIN_ERROR_MESSAGE= "xpath=//div[@class='message-error validation-summary-errors']";
	public static final String EMAIL_ERROR_MESSAGE= "xpath=//span//span[@id='Email-error']";
}
