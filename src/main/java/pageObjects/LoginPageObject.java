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

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver,UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

	public String getErrorMessageForWrongPassword() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

}
