package commons;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import pageObjects.HomePageObject;
import pageUIs.user.BaseElementUI;

public class BaseElement extends BasePage {
	
	WebDriver driver;
	
	public BaseElement(WebDriver driver) {
		this.driver = driver;
	}




	public HomePageObject clickToNopcommerceLogo() {
		waitForElementClickable(driver, BaseElementUI.NOPCOMMERCE_LOGO);
		clickToElement(driver,BaseElementUI.NOPCOMMERCE_LOGO );
		return PageGeneratorManager.getHomePage(driver);

	}
	public void clickToHeaderLinkByName(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);

	}

	public void clickToHeaderLinkByNameWithJS(String pageName) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
		clickToElementByJS(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);

	}
	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, BaseElementUI.DYNAMIC_BUTTON_BY_TEXT,buttonText);
	}
	public String getErrorMessageByID(String errorMessageID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_ERROR_MESSAGE_BY_ID, errorMessageID);
		return getElementText(driver,BaseElementUI.DYNAMIC_ERROR_MESSAGE_BY_ID,errorMessageID );
		
	}
	public void enterToTextBoxById(String textBoxID, String  valueToSendKey) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textBoxID);
		sendkeyToElement(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,valueToSendKey, textBoxID );

	}
	public String getTextBoxAttributeValueByID(String textboxID) {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID,textboxID);
		return getElementAttribute(driver, BaseElementUI.DYNAMIC_TEXTBOX_BY_ID, "value",textboxID);
	}

	private static final String getEmailRandom() {
		Random rand = new Random();
		return "John" + rand.nextInt(99999) + "@gmail.com";

	}
	
	public String getNotificationHeaderMessage () {
		waitForElementVisible(driver, BaseElementUI.DYNAMIC_NOTIFICATION_HEADER);
		return getElementText(driver, BaseElementUI.DYNAMIC_NOTIFICATION_HEADER);
	}

	public void clickToCloseButtonOnSuccessMessageBanner(){
		waitForElementClickable(driver,BaseElementUI.CLOSE_BUTTON_FOR_SUCCESS_MESSAGE);
		clickToElement(driver,BaseElementUI.CLOSE_BUTTON_FOR_SUCCESS_MESSAGE );
	}

}
