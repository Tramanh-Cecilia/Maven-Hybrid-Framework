package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.facebook.CreateAccountPageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateAccountButton() {
		waitForElementClickable(driver, CreateAccountPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver,CreateAccountPageUI.CREATE_ACCOUNT_BUTTON);
		
	}

	public boolean IsFirstNameTextboxDisplayed() {
		waitForElementVisible(driver,CreateAccountPageUI.FIRSTNAME_TETBOX);
		return isElementDisplayed(driver, CreateAccountPageUI.FIRSTNAME_TETBOX);
		
	}

	public boolean IsSurNameTextboxDisplayed() {
		waitForElementVisible(driver,CreateAccountPageUI.SURNAME_TETBOX);
		return isElementDisplayed(driver, CreateAccountPageUI.SURNAME_TETBOX);
		
	}

	public boolean IsEmailTextboxDisplayed() {
		waitForElementVisible(driver,CreateAccountPageUI.EMAIL_TETBOX);
		return isElementDisplayed(driver, CreateAccountPageUI.EMAIL_TETBOX);
		
	}

	public boolean IsPasswordTextboxDisplayed() {
		waitForElementVisible(driver,CreateAccountPageUI.PASSWORD_TETBOX);
		return isElementDisplayed(driver, CreateAccountPageUI.PASSWORD_TETBOX);
		
	}
	public boolean IsConfirmEmailtextboxDisplayed() {
		waitForElementVisible(driver,CreateAccountPageUI.CONFIRM_EMAIL_TETBOX);
		return isElementDisplayed(driver, CreateAccountPageUI.CONFIRM_EMAIL_TETBOX);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementClickable(driver, CreateAccountPageUI.EMAIL_TETBOX);
		sendkeyToElement(driver, CreateAccountPageUI.EMAIL_TETBOX, email);
		
		
	}


	public void clickToCloseSignInPopUp() {
		waitForElementClickable(driver, CreateAccountPageUI.CLOSE_POPUP_ACCOUNT_BUTTON);
		clickToElement(driver,CreateAccountPageUI.CLOSE_POPUP_ACCOUNT_BUTTON);
		
		
	}

	public boolean IsFirstNameTextboxUnDisplayed() {
		return isElementUnDisplayed(driver,CreateAccountPageUI.FIRSTNAME_TETBOX);
	
	}

	public boolean IsSurNameTextboxUnDisplayed() {
		return isElementUnDisplayed(driver,CreateAccountPageUI.SURNAME_TETBOX);
	}

	public boolean IsEmailTextboxUnDisplayed() {
		return isElementUnDisplayed(driver,CreateAccountPageUI.EMAIL_TETBOX);
	}

	public boolean IsPasswordTextboxUnDisplayed() {
		return isElementUnDisplayed(driver,CreateAccountPageUI.PASSWORD_TETBOX);
	}

	public boolean IsConfirmEmailtextboxUnDisplayed() {
		return isElementUnDisplayed(driver,CreateAccountPageUI.CONFIRM_EMAIL_TETBOX);
	}


	

}
