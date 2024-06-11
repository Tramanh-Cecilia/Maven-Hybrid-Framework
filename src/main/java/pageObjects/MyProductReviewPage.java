package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.user.MyAccountSideBarPageUI;
import pageUIs.user.MyProductReviewPageUI;

public class MyProductReviewPage extends BaseElement {
    WebDriver driver;


    public MyProductReviewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getReviewProductTitle() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
    }

    public String getListOfProduct() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_TITLE_TEXT);
    }

    public String getReviewProductTextArea() {
        waitForElementVisible(driver, MyProductReviewPageUI.REVIEW_PRODUCT_TEXTAREA);
        return getElementText(driver, MyProductReviewPageUI.REVIEW_PRODUCT_TEXTAREA);
    }
}
