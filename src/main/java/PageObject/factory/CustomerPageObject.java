package PageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePagefactory;

public class CustomerPageObject extends BasePagefactory{
	WebDriver driver;
	
	@CacheLookup
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	public CustomerPageObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(this.driver, this);
	}
	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, firstNameTextBox);
		return  getElementAttribute(driver, firstNameTextBox, "value");
	}
	public String getLasttNameAttributeValue() {
		waitForElementVisible(driver, lastNameTextBox);
		return  getElementAttribute(driver,lastNameTextBox, "value");
	}
	public String getEmailAddressAttributeValue() {
		waitForElementVisible(driver, emailTextBox);
		return  getElementAttribute(driver, emailTextBox, "value");
	}
}
