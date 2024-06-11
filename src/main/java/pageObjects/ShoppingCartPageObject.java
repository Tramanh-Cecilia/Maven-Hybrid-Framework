package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BaseElement {
    private WebDriver driver;
    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public String getShoppingCartTitle(){
    waitForElementVisible(driver, ShoppingCartPageUI.PAGE_TITLE);
    return getElementText(driver, ShoppingCartPageUI.PAGE_TITLE);
    }
}
