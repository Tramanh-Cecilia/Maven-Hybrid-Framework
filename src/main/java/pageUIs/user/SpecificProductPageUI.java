package pageUIs.user;

import org.openqa.selenium.WebElement;

public class SpecificProductPageUI {
    public static final String ADD_REVIEW_LINK="css=div.product-review-links.add-review";
    public static final String TITLE_SECTION_TEXTBOX ="xpath=//input[@class='review-title']" ;
    public static final String TEXTAREA_SECTION_FOR_REVIEW ="CSS=textarea.review-text" ;
    public static final String SUBMIT_REVIEW_BUTTON = "css=button#add-review";
    public static final String DYNAMIC_BUTTON_BY_CLASS = "css=div.%s";
}
