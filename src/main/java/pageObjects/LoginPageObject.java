package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import pageUIs.user.UserLoginPageUI;

public class LoginPageObject extends BaseElement {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver= driver;
	
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver,UserLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, emailAddress);
		

	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver,UserLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);

	}
	
	public void enterToDynamicTextboxInLoginPage(String textboxName, String valueToSend) {
		waitForElementVisible(driver,UserLoginPageUI.DYNAMIC_TEXTBOX_BY_NAME,textboxName );
		sendkeyToElement(driver, UserLoginPageUI.DYNAMIC_TEXTBOX_BY_NAME, valueToSend,textboxName);

	}
	
	

	public void clickToLoginButton() {
		waitForElementClickable(driver,UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
	}

	public String getErrorMessageInLoginPage() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	

}
