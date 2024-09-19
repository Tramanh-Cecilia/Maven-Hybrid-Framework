package pageObjects.admin;

import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminProductPageUI;
import pageUIs.admin.AdminSideBarPageUI;

public class AdminProductPageObject extends AdminSideBarPageObject{

    private WebDriver driver;
    public AdminProductPageObject(WebDriver driver) {
        super(driver);
        this.driver= driver;
    }


    public void enterToDynamicSearchTextbox(String searchText, String searchTexboxId){
        waitForElementClickable(driver, AdminProductPageUI.DYNAMIC_SEARCH_TEXTBOX_BY_ID, searchTexboxId);
        sendkeyToElement(driver, AdminProductPageUI.DYNAMIC_SEARCH_TEXTBOX_BY_ID,searchText, searchTexboxId);
    }

    public void clickToSearchButton(){
        waitForElementClickable(driver, AdminProductPageUI.SEARCH_BUTTON);
        clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
    }

    public String getTextInDynamicCellByproductNameAndColumnName(String productName, String columnName){
        int rowIndex= getListElementSize(driver, AdminProductPageUI.DYNAMIC_ROW_BY_PRODUCT_NAME, productName)+1;
        int columnIndex= getListElementSize(driver, AdminProductPageUI.DYNAMIC_COLUMN_BY_COLUMN_NAME, columnName)+1;
        return getElementText(driver, AdminProductPageUI.DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));

    }


    public String isProductPulishedByDynamicProductName(String productName){
        int rowIndex= getListElementSize(driver, AdminProductPageUI.DYNAMIC_ROW_BY_PRODUCT_NAME, productName)+1;
        return getElementAttribute(driver,AdminProductPageUI.PUBLSIHED_COLUMN_BY_ROW_INDEX_AND_COLUMN_INDEX,"nop-value",String.valueOf(rowIndex),String.valueOf(7));
    }

    public boolean isSearchRowOpened(){
        waitForElementVisible(driver, AdminProductPageUI.SEARCH_ROW);
        String searchRowClass= getElementAttribute(driver, AdminProductPageUI.SEARCH_ROW,"class");
        if (searchRowClass.contains("opened")) {
            return true;
        }
        return false;

    }

    public void clickToSearchSection(){
        if (!isSearchRowOpened()) {
            waitForElementClickable(driver, AdminProductPageUI.SEARCH_SECTION);
            clickToElement(driver,AdminProductPageUI.SEARCH_SECTION);
        }

    }


    public void clickToGoButtonAtSKUTextbox(){
        waitForElementClickable(driver,AdminProductPageUI.GO_BUTTON_AT_SKU_TEXTBOX);
        clickToElement(driver,AdminProductPageUI.GO_BUTTON_AT_SKU_TEXTBOX);
    }

    public void selectValueInDynamicSearchDropdownById(String valueToChoose, String dropdownId){
        selectItemInDefaultDropdown(driver, AdminProductPageUI.DYNAMIC_DROPDOWN_BY_ID,valueToChoose,dropdownId);
    }

    public void uncheckToCheckBoxSearchInSubCategories(){
        waitForElementClickable(driver, AdminProductPageUI.CHECKBOX_IN_SUB_CATEGORIES);
        uncheckToElement(driver, AdminProductPageUI.CHECKBOX_IN_SUB_CATEGORIES);
    }

    public String getEmptyErrorMessage(){
        waitForElementVisible(driver, AdminProductPageUI.EMPTY_ERROR_MESSAGE);
        return getElementText(driver, AdminProductPageUI.EMPTY_ERROR_MESSAGE);
    }

    public void checkToCheckBoxSearchInSubCategories() {
        waitForElementClickable(driver, AdminProductPageUI.CHECKBOX_IN_SUB_CATEGORIES);
        checkToElement(driver, AdminProductPageUI.CHECKBOX_IN_SUB_CATEGORIES);
    }

    public String getProductNameInProductTextBoxInEditPageDetail(){
        waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX_IN_EDIT_PRODUCT_PAGE);
        return getElementAttribute(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX_IN_EDIT_PRODUCT_PAGE, "value");
    }
}
