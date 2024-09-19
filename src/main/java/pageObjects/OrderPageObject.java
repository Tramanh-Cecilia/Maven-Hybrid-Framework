package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.user.OrderPageUI;

public class OrderPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public OrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getOrderNumber(){
		waitForElementVisible(driver, OrderPageUI.ORDER_NUMBER_TEXT);
		return getElementText(driver, OrderPageUI.ORDER_NUMBER_TEXT);
	}

	public void clickToDetailButton(){
		waitForElementClickable(driver, OrderPageUI.DETAIL_BUTTON);
		clickToElement(driver, OrderPageUI.DETAIL_BUTTON);
	}
	public String getOrderNumerInDetailSection(){
		waitForElementClickable(driver, OrderPageUI.ORDER_NUMBER_IN_DETAIL_SECTION);
		return getElementText(driver, OrderPageUI.ORDER_NUMBER_IN_DETAIL_SECTION).substring(7);
	}
	

}
