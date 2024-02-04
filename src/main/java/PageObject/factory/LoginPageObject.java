package PageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePagefactory;

public class LoginPageObject extends BasePagefactory {
	WebDriver driver;
	@CacheLookup
	@FindBy(xpath = "//input[@class='email']")
	private WebElement emailTextbox;

	@FindBy(xpath = "//input[@class='password']")
	private WebElement passwordTextbox;

	@FindBy(xpath = "//button[@class='button-1 login-button']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
	private WebElement loginErrorMessage;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForElementClickable(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);

	}

	public void enterToPasswordTextbox(String password) {
		waitForElementClickable(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);

	}
}
