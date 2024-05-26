package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.user.SearchPageObjectUI;

public class SearchPageObject extends BaseElement {
    WebDriver driver;

    public SearchPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToSearchKeyWordTextBox(String searchValue) {
        waitForElementVisible(driver, SearchPageObjectUI.SEARCH_KEY_WORD_TEXTBOX);
        sendkeyToElement(driver, SearchPageObjectUI.SEARCH_KEY_WORD_TEXTBOX, searchValue);
    }

    public void selectValueInDropDownOfAdvancedSearch(String searchValue) {
        waitForElementClickable(driver, SearchPageObjectUI.DYNAMIC_DROPDOWN_IN_ADVANCED_SEARCH);
        selectItemInDefaultDropdown(driver, SearchPageObjectUI.DYNAMIC_DROPDOWN_IN_ADVANCED_SEARCH, searchValue);
    }

    public void checkToAdvancedSearchButton() {
        waitForElementClickable(driver, SearchPageObjectUI.ADVANCED_SEARCH_CHECKBOX);
        checkToElement(driver, SearchPageObjectUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void clickToSearchButton(){
        waitForElementClickable(driver, SearchPageObjectUI.SEARCH_BUTTON_IN_SEARCH_FORM);
        clickToElement(driver, SearchPageObjectUI.SEARCH_BUTTON_IN_SEARCH_FORM);
    }

    public String getErrorMessageOfSearchForm(){
        waitForElementVisible(driver, SearchPageObjectUI.WARNING_ERROR_MESSAGE);
       return getElementText(driver, SearchPageObjectUI.WARNING_ERROR_MESSAGE);
    }

    public String getNoProductResultMessageInSearchForm(){
        waitForElementVisible(driver, SearchPageObjectUI.NO_PRODUCT_RESULT_ERROR_MESSAGE);
        return getElementText(driver, SearchPageObjectUI.NO_PRODUCT_RESULT_ERROR_MESSAGE);
    }

    public void clickToAdvancedSearchCheckbox() {
        waitForElementClickable(driver,SearchPageObjectUI.ADVANCED_SEARCH_CHECKBOX);
        checkToElement(driver,SearchPageObjectUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectValueInDynamicDropdownOfAdvancedSearch(String valueToSelect, String dropdownName) {
        waitForElementVisible(driver, SearchPageObjectUI.DYNAMIC_DROPDOWN_IN_ADVANCED_SEARCH, dropdownName);
        selectItemInDefaultDropdown(driver, SearchPageObjectUI.DYNAMIC_DROPDOWN_IN_ADVANCED_SEARCH,valueToSelect, dropdownName);
    }

    public void clickToDynamicCheckBoxInsearchPageByName(String checkboxName) {
        waitForElementClickable(driver, SearchPageObjectUI.DYNAMIC_SEARCH_CHECKBOX_BY_NAME,checkboxName);
        checkToElement(driver, SearchPageObjectUI.DYNAMIC_SEARCH_CHECKBOX_BY_NAME,checkboxName);
    }
}


