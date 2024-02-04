package PageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePagefactory;

public class RegisterPageObject extends BasePagefactory{
	WebDriver driver;
	@CacheLookup
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;

	
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result']")
	private WebElement successMessage;
	
	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMessage;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMessage;
	
	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMessage;
	
	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMessage;
	
	@FindBy(xpath = "//div[@class='header-logo']")
	private WebElement nopCommerceLogo;
	
	
	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}
	public String getFirstNameErrorMessageText() {
		waitForElementVisible(driver, firstNameErrorMessage);
		return getElementText(driver, firstNameErrorMessage);
	}
	public String getLastNameErrorMessageText() {
		waitForElementVisible(driver, lastNameErrorMessage);
		return getElementText(driver, lastNameErrorMessage);
	}
	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, emailErrorMessage);
		return getElementText(driver, emailErrorMessage);
	}
	public String getPasswordErrorMessageText() {
		waitForElementVisible(driver, passwordErrorMessage);
		return getElementText(driver, passwordErrorMessage);
	}
	public String getConfirmPasswordErrorMessageText() {
		waitForElementVisible(driver, confirmPasswordErrorMessage);
		return getElementText(driver, confirmPasswordErrorMessage);
	}
	public void clickToNopcommerceLogo() {
		waitForElementClickable(driver, nopCommerceLogo);
		clickToElement(driver, nopCommerceLogo);
		
	}
	public void enterToFirstNameTextBox(String firstName) {
		waitForElementClickable(driver, firstNameTextBox);
		sendkeyToElement(driver, firstNameTextBox, firstName);

		
	}
	public void enterToLastNameTextBox(String lastName) {
		waitForElementClickable(driver, lastNameTextBox);
		sendkeyToElement(driver, lastNameTextBox, lastName);

		
	}
	public void enterToEmailTextBox(String emailAddress) {
		waitForElementClickable(driver, emailTextBox);
		sendkeyToElement(driver, emailTextBox, emailAddress);

		
	}
	public void enterToPasswordNameTextBox(String password) {
		waitForElementClickable(driver, passwordTextBox);
		sendkeyToElement(driver, passwordTextBox, password);

		
	}
	public void enterToConfirmPasswordNameTextBox(String confirmPassword) {
		waitForElementClickable(driver,confirmPasswordTextBox);
		sendkeyToElement(driver, confirmPasswordTextBox, confirmPassword);

		
	}
	public String getRegisterSuccessMessageText() {
		waitForElementVisible(driver, successMessage);
		return getElementText(driver, successMessage);
	}
}
