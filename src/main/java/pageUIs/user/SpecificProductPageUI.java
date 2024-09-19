package pageUIs.user;

import org.openqa.selenium.WebElement;

public class SpecificProductPageUI {
    public static final String ADD_REVIEW_LINK="css=div.product-review-links.add-review";
    public static final String TITLE_SECTION_TEXTBOX ="xpath=//input[@class='review-title']" ;
    public static final String TEXTAREA_SECTION_FOR_REVIEW ="CSS=textarea.review-text" ;
    public static final String SUBMIT_REVIEW_BUTTON = "css=button#add-review";
    public static final String DYNAMIC_BUTTON_BY_CLASS = "css=div.%s";
    public static final String LIST_RELATED_PRODUCTS = "xpath=//div[@class='related-products-grid product-grid']//h2[@class='product-title']//a";
    public static final String DYNAMIC_ATTRIBUTE_DROPDOWN_BY_ATTRIBUTE_INDEX ="css=dd#product_attribute_input_%s select" ;
    public static final String DYNAMIC_ATTRIBUTE_INDEX_BY_ATTRIBUTE_NAME ="xpath=//label[contains(text(),'%s')]//parent::dt/preceding-sibling::dt" ;
    public static final String DROPDWN_LIST_IN_ATTRIBUTE_DROPDOWN_BY_ATTRIBUTE_INDEX = "xpath=//dd[@id='product_attribute_input_%s']//option";
    public static final String DYNAMIC_ATTRIBUTE_WITH_DYNAMIC_VALUE ="xpath=//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[contains(text(),'%s')]/preceding-sibling::input" ;
    public static final String LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE = "xpath=//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label";
    public static final String DYNAMIC_OPTIONS_BY_NAME = "xpath=//label[contains(text(),'%s')]/parent::dt/following-sibling::dd//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String ADD_TO_CART_BUTTON ="xpath=//div[@class='add-to-cart-panel']//button[text()='Add to cart']" ;
    public static final String PRICE_TEXT_BY_ID = "css=span#price-value-1";
    public static final String NUMBER_OF_PRODUCT_ITEM_TEXTBOX ="xpath=//input[@id='product_enteredQuantity_1']" ;
    public static final String UPDATE_BUTTON ="xpath=//input[@id='product_enteredQuantity_1']//following-sibling::button" ;


    public static final String ESTIMATE_SHIPPING_BUTTON ="xpath=//div[@class='common-buttons']//a[contains(text(),' Estimate shipping ')]" ;
    public static final String DROPDOWN_COUNTRY_IN_ESTIMATE_SHIPPING_POPUP ="CSS=div#estimate-shipping-popup select#CountryId" ;
    public static final String LIST_OPTON_IN_COUNTRY_DROPDOWN_IN_ESTIMATE_SHIPPING_POPUP ="CSS=div#estimate-shipping-popup select#CountryId option" ;
    public static final String ZIP_POSTALCODE_TEXTBOX_IN_ESTIMATE_SHIPPING_POPUP ="CSS=div#estimate-shipping-popup input#ZipPostalCode" ;
    public static final String APPLY_BUTTON_IN_ESTIMATE_SHIPPING_POPUP ="CSS=div#estimate-shipping-popup button.button-2.apply-shipping-button" ;
    public static final String TERM_OF_SERVICE_CHECKBOX ="CSS=input#termsofservice" ;
    public static final String CHECKOUT_BUTTON ="css=button#checkout" ;
}
