package PageObject.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BasePagefactory;

public class HomePageObject extends BasePagefactory{
	WebDriver driver;
	@CacheLookup
	@FindBy(how= How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(how= How.XPATH, using = "//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(xpath = "//a[@class='ico-account']")
	private WebElement myAccountLink;
	
	@FindBy(className = "ico-logout")
	private WebElement logOutLink;
	
	public HomePageObject(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clickToRegisterLink() {
		waitForElementClickable(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}
	public void clickToLoginLink() {
		waitForElementClickable(driver, loginLink);
		clickToElement(driver, loginLink);
	}
	public void clickToMyAccountLink() {
		waitForElementClickable(driver, myAccountLink);
		clickToElement(driver, myAccountLink);
	}
	
}
