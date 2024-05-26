package pageUIs.user;

public class SearchPageObjectUI {

    public static final String SEARCH_KEY_WORD_TEXTBOX="xpath=//div[@class='form-fields']//input[@class='search-text']";
    public static final String DYNAMIC_DROPDOWN_IN_ADVANCED_SEARCH="css=select#%s";//cid and mid
    public static final String ADVANCED_SEARCH_CHECKBOX="xpath=//input[@type='checkbox']";
    public static final String DYNAMIC_SEARCH_CHECKBOX_BY_NAME="xpath=//label[contains(text(),'%s')]/preceding-sibling::input";
    public static final String SEARCH_IN_PRODUCT_DESCRIPTION_CHECKBOX="css=input#sid";
    public static final String SEARCH_BUTTON_IN_SEARCH_FORM="xpath=//div[@class='buttons']//button[@class='button-1 search-button']";
    public static final String WARNING_ERROR_MESSAGE="css=div.warning";
    public static final String NO_PRODUCT_RESULT_ERROR_MESSAGE="css=div.no-result";



}
