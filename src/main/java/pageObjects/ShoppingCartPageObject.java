package pageObjects;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.user.ShoppingCartPageUI;

public class ShoppingCartPageObject extends BaseElement {
    private WebDriver driver;

    public ShoppingCartPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getShoppingCartTitle() {
        waitForElementVisible(driver, ShoppingCartPageUI.PAGE_TITLE);
        return getElementText(driver, ShoppingCartPageUI.PAGE_TITLE);
    }


    public String getInformationOfItemInMiniShoppingCartByClassName(String itemClassName) {
        waitForElementVisible(driver, ShoppingCartPageUI.DYNAMIC_INFORMATION_OF_ITEM_BY_CLASS_NAME, itemClassName);
        return getElementText(driver, ShoppingCartPageUI.DYNAMIC_INFORMATION_OF_ITEM_BY_CLASS_NAME, itemClassName);
    }

    public SpecificProductPageObject clickToEditLinkByProductNameRow(String productName, String columnName) {
        int rowIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME, productName) + 1;
        int columnIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        clickToElement(driver, ShoppingCartPageUI.DYNAMIC_EDIT_LINK_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));
        return PageGeneratorManager.getSpecificProductPageObject(driver);

    }

    public void clickToDynamicCellByDynamicRowIndexandColumnIndex(String productName, String columnName) {
        int rowIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME, productName) + 1;
        int columnIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        clickToElement(driver, ShoppingCartPageUI.DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));

    }

    public void sendTextDynamicCellByDynamicRowIndexandColumnIndex(String productName, String columnName, String valueToSend) {
        int rowIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME, productName) + 1;
        int columnIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        sendkeyToElement(driver, ShoppingCartPageUI.QUANTITY_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, String.valueOf(rowIndex), String.valueOf(columnIndex));

    }


    public void clickToQuantiyCellByDynamicRowIndexandColumnIndexWithNumberOfClick(String productName, String columnName, int numberOfClick) {
        int rowIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME, productName) + 1;
        int columnIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        for (int i=0; i<numberOfClick; i++ ) {
            clickToElement(driver, ShoppingCartPageUI.QUANTITY_BUTTON_BY_ROW_INDEX_AND_COLUMN_INDEX,String.valueOf(rowIndex), String.valueOf(columnIndex) );
            isAjaxLoadingUndisplayed();
        }

    }



    public String getTextOfDynamicCellByDynamicRowIndexandColumnIndex(String productName, String columnName) {
        int rowIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME, productName) + 1;
        int columnIndex = getListElementSize(driver, ShoppingCartPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
        return getElementText(driver, ShoppingCartPageUI.DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));

    }

    public String getOrderSummaryContent() {
        waitForElementClickable(driver, ShoppingCartPageUI.ORDER_SUMMARY_CONTENT_TEXT);
        return getElementText(driver, ShoppingCartPageUI.ORDER_SUMMARY_CONTENT_TEXT);
    }
}
