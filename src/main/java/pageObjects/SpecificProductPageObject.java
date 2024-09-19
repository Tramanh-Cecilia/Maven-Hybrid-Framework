package pageObjects;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import pageUIs.user.BaseElementUI;
import pageUIs.user.CategoriesPageObjectUI;
import pageUIs.user.HomePageUI;
import pageUIs.user.SpecificProductPageUI;

import java.util.List;

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
            boolean isDisplay = isElementUnDisplayed(driver, BaseElementUI.SUCCESS_MESSAGE_NOTIFICATION);
            if (isDisplay) {
                return true;
            } else {
                return false;

            }

        } catch (Exception e) {
            return false;
        }

    }

    public void openRelatedProductInRelatedSection() {
        List<WebElement> listRelatedProduct = getListWebElement(driver, SpecificProductPageUI.LIST_RELATED_PRODUCTS);
        var randomItem = getRandomNumberInGivenRange(listRelatedProduct.size());
        listRelatedProduct.get(randomItem).click();


    }


    public void selectAnItemInAttributeDropdown(String attributeName, String itemValue) {
        int attributeIndex = getListElementSize(driver, SpecificProductPageUI.DYNAMIC_ATTRIBUTE_INDEX_BY_ATTRIBUTE_NAME, attributeName) + 1;
        selectedItemInDropdown(driver, SpecificProductPageUI.DYNAMIC_ATTRIBUTE_DROPDOWN_BY_ATTRIBUTE_INDEX, SpecificProductPageUI.DROPDWN_LIST_IN_ATTRIBUTE_DROPDOWN_BY_ATTRIBUTE_INDEX, itemValue, String.valueOf(attributeIndex), String.valueOf(attributeIndex));
    }

    public void selectAnItemInAttributeWithRadioType(String attributeLabel, String itemValue) {
        waitForElementClickable(driver, SpecificProductPageUI.DYNAMIC_ATTRIBUTE_WITH_DYNAMIC_VALUE, attributeLabel, itemValue);
        clickToElement(driver, SpecificProductPageUI.DYNAMIC_ATTRIBUTE_WITH_DYNAMIC_VALUE, attributeLabel, itemValue);
    }

    public void selectMultipleItemInAttributeWithCheckboxType(String attributeLabel) {
        List<WebElement> listOption = getListWebElement(driver, SpecificProductPageUI.LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE, attributeLabel);
        int size = getListElementSize(driver, SpecificProductPageUI.LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE, attributeLabel);
        for (int i = 0; i < size; i++) {
            String itemName = listOption.get(i).getText();
            checkToElement(driver, SpecificProductPageUI.DYNAMIC_OPTIONS_BY_NAME, attributeLabel, itemName);

        }

    }

    public void selectOneItemInAttributeWithCheckboxType(String attributeLabel, String selectedItemText) {
        deselectMultipleItemsInAttributeWithCheckboxType(attributeLabel);
        List<WebElement> listOption = getListWebElement(driver, SpecificProductPageUI.LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE, attributeLabel);
        int size = getListElementSize(driver, SpecificProductPageUI.LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE, attributeLabel);
        for (int i = 0; i < size; i++) {
            String itemName = listOption.get(i).getText();
            if (itemName.equals(selectedItemText)) {
                checkToElement(driver, SpecificProductPageUI.DYNAMIC_OPTIONS_BY_NAME, attributeLabel, itemName);
                break;
            }

        }

    }


    public void deselectMultipleItemsInAttributeWithCheckboxType(String attributeLabel) {
        List<WebElement> listOption = getListWebElement(driver, SpecificProductPageUI.LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE, attributeLabel);
        int size = getListElementSize(driver, SpecificProductPageUI.LIST_OPTION_IN_DYNAMIC_ATTRIBUTE_WITH_CHECKBOX_TYPE, attributeLabel);
        for (int i = 0; i < size; i++) {
            String itemName = listOption.get(i).getText();
            uncheckToElement(driver, SpecificProductPageUI.DYNAMIC_OPTIONS_BY_NAME, attributeLabel, itemName);

        }

    }

    public void clickToAddToCartButton() {
        waitForElementClickable(driver, SpecificProductPageUI.ADD_TO_CART_BUTTON);
        clickToElement(driver, SpecificProductPageUI.ADD_TO_CART_BUTTON);
        isAjaxLoadingUndisplayed();
    }

    public void hoverToHeaderLinkByName(String pageName) {
        waitForElementClickable(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
        hoverToElement(driver, BaseElementUI.DYNAMIC_HEADER_LINK_BY_NAME, pageName);
    }

    public String getProductPrice() {
        waitForElementVisible(driver, SpecificProductPageUI.PRICE_TEXT_BY_ID);
        return getElementText(driver, SpecificProductPageUI.PRICE_TEXT_BY_ID);
    }

    public void updateNumberOfProductAddToCart(String itemNumber){
        waitForElementClickable(driver, SpecificProductPageUI.NUMBER_OF_PRODUCT_ITEM_TEXTBOX);
        sendkeyToElement(driver, SpecificProductPageUI.NUMBER_OF_PRODUCT_ITEM_TEXTBOX,  itemNumber);
        clickToElement(driver, SpecificProductPageUI. UPDATE_BUTTON);
        isAjaxLoadingUndisplayed();
    }

    public void clickToEstimateShippingButton(){
        waitForElementClickable(driver, SpecificProductPageUI.ESTIMATE_SHIPPING_BUTTON);
        clickToElement(driver,SpecificProductPageUI.ESTIMATE_SHIPPING_BUTTON );
    }

    public CheckoutPageObject clickToCheckOutButton(){
        waitForElementClickable(driver, SpecificProductPageUI.CHECKOUT_BUTTON);
        clickToElement(driver,SpecificProductPageUI.CHECKOUT_BUTTON );
        return PageGeneratorManager.getCheckoutPageObject(driver);
    }
    public void selectValueOFCountryInShippingPopup(String itemValue){
        selectedItemInDropdown(driver, SpecificProductPageUI.DROPDOWN_COUNTRY_IN_ESTIMATE_SHIPPING_POPUP, SpecificProductPageUI.LIST_OPTON_IN_COUNTRY_DROPDOWN_IN_ESTIMATE_SHIPPING_POPUP, itemValue);

    }

    public void sendkeyToZipPostalCodeTextboxInEstimateShippingPopup(String valueToSend){
        waitForElementClickable(driver, SpecificProductPageUI.ZIP_POSTALCODE_TEXTBOX_IN_ESTIMATE_SHIPPING_POPUP);
        sendkeyToElement(driver, SpecificProductPageUI.ZIP_POSTALCODE_TEXTBOX_IN_ESTIMATE_SHIPPING_POPUP, valueToSend);
    }

    public void clickToApplyButtonInEstimateShippingPopup(){
        waitForElementClickable(driver, SpecificProductPageUI.APPLY_BUTTON_IN_ESTIMATE_SHIPPING_POPUP);
        clickToElement(driver,SpecificProductPageUI.APPLY_BUTTON_IN_ESTIMATE_SHIPPING_POPUP);
        isAjaxLoadingUndisplayed();
    }
    public void clickToTermOfServiceCheckBox(){
        waitForElementClickable(driver, SpecificProductPageUI.TERM_OF_SERVICE_CHECKBOX);
        checkToElement(driver, SpecificProductPageUI.TERM_OF_SERVICE_CHECKBOX);
    }




}
