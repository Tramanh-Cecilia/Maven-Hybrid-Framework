package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.user.WishListPageUI;

import java.util.List;

public class WishListPageObject extends BaseElement {

    private WebDriver driver;

    public WishListPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public List<WebElement> getAllProductsInTheTable() {

            waitForListElementVisible(driver, WishListPageUI.PRODUCT_COLUMN);
            return getListWebElement(driver, WishListPageUI.PRODUCT_COLUMN);
    }



    public boolean isSpecificProductNameExist(String expectedProductName) {
        int size= getListElementSize(driver,WishListPageUI.PRODUCT_COLUMN );

        if (size!=0){
            List<WebElement> allProduct = getAllProductsInTheTable();
            for (WebElement product : allProduct) {
                if (product.getText().equals(expectedProductName)) {
                    return true;
                }

            }
        }


        return false;
    }

    public void clickToSharingLinkInWishList() {
        waitForElementClickable(driver, WishListPageUI.WISHLIST_SHARING_LINK);
        clickToElement(driver, WishListPageUI.WISHLIST_SHARING_LINK);
    }

    public String getWishListTitle() {
        waitForElementVisible(driver, WishListPageUI.WISHLIST_PAGE_TITLE);
        return getElementText(driver, WishListPageUI.WISHLIST_PAGE_TITLE);
    }

    public void clikToButtonByTextInWishListPage(String buttonText) {
        waitForElementClickable(driver, WishListPageUI.BUTTON_BY_TEXT_IN_WISHLIST, buttonText);
        clickToElement(driver, WishListPageUI.BUTTON_BY_TEXT_IN_WISHLIST, buttonText);

    }

    public void clickToCheckBoxForProductInTable(String productName, String columnName) {

        try {
            boolean isProductExit = isSpecificProductNameExist(productName);
            if (isProductExit) {
                int rowIndex = getListElementSize(driver, WishListPageUI.ROW_INDEX_BY_PRODUCT_NAME, productName) + 1;
                int columnIndex = getListElementSize(driver, WishListPageUI.COLUMN_INDEX_BY_COLUMN_NAME_TEXT, columnName) + 1;
                clickToElement(driver, WishListPageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX,String.valueOf(rowIndex), String.valueOf(columnIndex));



            }


        } catch (Exception e) {
            System.out.println("This product is not exist in wishlist table");
        }


    }

    public void clickToRemoveButtonInWishlistTable (String productName, String columnName){
        int rowIndex= getListElementSize(driver, WishListPageUI.ROW_INDEX_BY_PRODUCT_NAME, productName)+1;
        int columnIndex=getListElementSize(driver, WishListPageUI.COLUMN_INDEX_BY_COLUMN_NAME_TEXT,columnName )+1;
        clickToElement(driver, WishListPageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));


    }

    public String getNoDataMessage (){
        waitForElementVisible(driver, WishListPageUI.NO_DATA_MESSAGE_TEXT);
        return getElementText(driver, WishListPageUI.NO_DATA_MESSAGE_TEXT);

    }
}
