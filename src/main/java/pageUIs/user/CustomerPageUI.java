package pageUIs.user;

public class CustomerPageUI {
	public static final String FIRSTNAME_TEXTBOX="id=FirstName";
	public static final String LASTNAME_TEXTBOX ="id=LastName";
	public static final String EMAIL_ADDRESS_TEXTBOX ="id=Email";
	public static final String COMPANY_NAME_TEXTBOX ="id=Company";
	public static final String MALE_RADIO_BUTTON="xpath=//span[@class='male']";
	public static final String FEMALE_RADIO_BUTTON="xpath=//span[@class='female']";
	public static final String DAY_OF_BIRTHDAY_DROPDOWN="xpath=//select[@name='DateOfBirthDay']";
	public static final String MONTH_OF_BIRTHDAY_DROPDOWN="xpath=//select[@name='DateOfBirthMonth']";
	public static final String YEAR_OF_BIRTHDAY_DROPDOWN="xpath=//select[@name='DateOfBirthYear']";
	public static final String SAVE_BUTTTON="ID=save-info-button";
	public static final String UPDATE_SUCCESS_NOTIFICATION="xpath=//div[@class='bar-notification success']";
	public static final String ADDRESSES_LINK="xpath=//div[@class='side-2']//a[@href='/customer/addresses']";
	public static final String ADD_NEW_BUTTON="xpath=//div[@class='add-button']";
	
	public static final String CHANGE_PASSWORD_LINK="xpath=//a[@href='/customer/changepassword']";
	public static final String OLD_PASSWORD_TEXTBOX="id=OldPassword";
	public static final String NEW_PASSWORD_TEXTBOX="xpath=//input[@id='NewPassword']";
	public static final String CONFIRM_NEWPASSWORD_TEXTBOX="xpath=//input[@id='ConfirmNewPassword']";
	public static final String CHANGE_PASSWORD_BUTTON="xpath=//button[@class='button-1 change-password-button']";
	public static final String PASSWORD_CHANGE_SUCCESS_MESS="xpath=//p[text()='Password was changed']";
	public static final String PASSWORD_CHANGE_MESS_CLOSE_BUTTON="xpath=//span[@title='Close']";
	
}
