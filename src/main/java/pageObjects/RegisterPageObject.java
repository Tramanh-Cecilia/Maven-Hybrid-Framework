package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import pageUIs.user.RegisterPageUI;

public class RegisterPageObject extends BaseElement {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
		
	}

	public String getFirstNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_ERROR_MSG );
		return getElementText(driver,RegisterPageUI.FIRSTNAME_ERROR_MSG );
		
	}

	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_ERROR_MSG );
		return getElementText(driver,RegisterPageUI.LASTNAME_ERROR_MSG );
	}

	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_ERROR_MSG  );
		return getElementText(driver,RegisterPageUI.EMAIL_ERROR_MSG );
	}

	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_ERROR_MSG );
		return getElementText(driver,RegisterPageUI.PASSWORD_ERROR_MSG );
	}

	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver, RegisterPageUI.CONFIRMPASSWORD_ERROR_MSG);
		return getElementText(driver,RegisterPageUI.CONFIRMPASSWORD_ERROR_MSG);
	}

	

	public void enterToFirstNameTextBox(String firstNameValue) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstNameValue);

	}

	public void enterToLastNameTextBox(String lastNameValue) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastNameValue);

	}

	public void enterToEmailTextBox(String emailAddressValue) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX , emailAddressValue);
	}

	public void enterToPasswordNameTextBox(String passwordValue) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX );
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX ,  passwordValue);

	}

	public void enterToConfirmPasswordNameTextBox(String confirmPasswordValue) {
		waitForElementVisible(driver, RegisterPageUI.CONFRIM_PASSWORD_TEXTBOX  );
		sendkeyToElement(driver, RegisterPageUI.CONFRIM_PASSWORD_TEXTBOX  ,  confirmPasswordValue);
	}

	public String getRegisterSuccessMessageText() {
		waitForElementVisible(driver, RegisterPageUI.SUCCESS_MSG);
		return getElementText(driver,RegisterPageUI.SUCCESS_MSG);
	}



	

}
