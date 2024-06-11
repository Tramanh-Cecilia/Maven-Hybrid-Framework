package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageUIs.user.SpecificProductPageUI;

public class SpecificProductPageObject extends BaseElement {
    WebDriver driver;

    public SpecificProductPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void addReviewForProduct() {
        waitForElementClickable(driver, SpecificProductPageUI.ADD_REVIEW_LINK);
        clickToElement(driver, SpecificProductPageUI.ADD_REVIEW_LINK);
    }

    public void addToReviewForm(String randomText, String firstName) {
        waitForElementVisible(driver, SpecificProductPageUI.TITLE_SECTION_TEXTBOX);
        sendkeyToElement(driver, SpecificProductPageUI.TITLE_SECTION_TEXTBOX, firstName);
        waitForElementVisible(driver, SpecificProductPageUI.TEXTAREA_SECTION_FOR_REVIEW);
        sendkeyToElement(driver, SpecificProductPageUI.TEXTAREA_SECTION_FOR_REVIEW, randomText);
    }

    public void clickToAddReviewButton() {
        waitForElementClickable(driver, SpecificProductPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, SpecificProductPageUI.SUBMIT_REVIEW_BUTTON);
    }

    public void clickToDynamicButtonByClassName(String classButton) {
        waitForElementClickable(driver, SpecificProductPageUI.DYNAMIC_BUTTON_BY_CLASS, classButton);
        clickToElement(driver, SpecificProductPageUI.DYNAMIC_BUTTON_BY_CLASS, classButton);
    }

    public boolean isAddToWishListSuccessfully() {

        try {
            clickToDynamicButtonByClassName("add-to-wishlist");

            if (getNotificationHeaderMessage().contains("The product has been added to your ")) {
                return true;
            } else {
                return false;

            }


        } catch (Exception e) {
            return false;
        }

    }


}
