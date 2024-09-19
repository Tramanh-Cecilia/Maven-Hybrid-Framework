package pageObjects;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.user.CompareProductPageUI;

import java.util.ArrayList;
import java.util.List;

public class CompareProductPageObject extends BaseElement {
    private WebDriver driver;
    public CompareProductPageObject(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public List<WebElement> getListOfProductInComparelist(){
        waitForElementVisible(driver, CompareProductPageUI.LIST_PRODUCT_NAME_IN_COMPARE_LIST);
        return getListWebElement(driver, CompareProductPageUI.LIST_PRODUCT_NAME_IN_COMPARE_LIST);
    }

    public List<String> getListOfProductName(){
        List<String> ListProductName= new ArrayList<>();
        List<WebElement> productList = getListOfProductInComparelist();
        for (WebElement product : productList) {
            ListProductName.add(product.getText());
        }
        return ListProductName;

    }

    public String getDynamicCellByProductName(String productName, String rowName){
        int columnIndex= getListElementSize(driver,CompareProductPageUI.DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME, productName)+1;
        int  rowIndex= getListElementSize(driver, CompareProductPageUI.DYNAMIC_ROW_INDEX_BY_ROW_CLASS_NAME,rowName )+ 1;
        return getElementText(driver, CompareProductPageUI.DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));

    }

}
