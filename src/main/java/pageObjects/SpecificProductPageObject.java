package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.user.SpecificProductPageUI;

public class SpecificProductPageObject extends BaseElement {
    WebDriver driver;

    public SpecificProductPageObject(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }


    public void addReviewForProduct(){
        waitForElementClickable(driver, SpecificProductPageUI.ADD_REVIEW_LINK);
        clickToElement(driver, SpecificProductPageUI.ADD_REVIEW_LINK);
    }

    public void addToReviewForm(String randomText, String firstName) {
        waitForElementVisible(driver,SpecificProductPageUI.TITLE_SECTION_TEXTBOX);
        sendkeyToElement(driver, SpecificProductPageUI.TITLE_SECTION_TEXTBOX,firstName);
        waitForElementVisible(driver,SpecificProductPageUI.TEXTAREA_SECTION_FOR_REVIEW );
        sendkeyToElement(driver, SpecificProductPageUI.TEXTAREA_SECTION_FOR_REVIEW ,randomText);
    }

    public void clickToAddReviewButton() {
        waitForElementClickable(driver, SpecificProductPageUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver, SpecificProductPageUI.SUBMIT_REVIEW_BUTTON);
    }
}
