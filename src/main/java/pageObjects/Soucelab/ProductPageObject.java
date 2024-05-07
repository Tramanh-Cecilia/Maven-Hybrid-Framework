package pageObjects.Soucelab;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.sourcelab.ProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPageObject extends BasePage {

    private WebDriver driver;

    public ProductPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSortDropdown(String sortType) {
        waitForElementClickable(driver, ProductPageUI.SORT_DROPDOWN);
        selectItemInDefaultDropdown(driver, ProductPageUI.SORT_DROPDOWN, sortType);
    }

    public boolean isProductNameSortByAscending() {
        List<WebElement> actualListOfProduct = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);
        List<String> actualProductName = new ArrayList<String>();

        for (WebElement productName : actualListOfProduct) {
            actualProductName.add(productName.getText());
        }

        List<String> expectedProductName = new ArrayList<String>();
        for (String name : actualProductName) {
            expectedProductName.add(name);
        }
        // sort theo ASC -default
        Collections.sort(expectedProductName);
        return actualProductName.equals(expectedProductName);
    }

    public boolean isProductNameSortByDesscending() {
        List<WebElement> actualListOfProduct = getListWebElement(driver, ProductPageUI.PRODUCT_NAME);

        List<String> actualProductName = new ArrayList<String>();

        for (WebElement productName : actualListOfProduct) {
            actualProductName.add(productName.getText());
        }

        List<String> expectedProductName = new ArrayList<String>();
        for (String name : actualProductName) {
            expectedProductName.add(name);
        }
        // sort theo ASC -default
        Collections.sort(expectedProductName);
        Collections.reverse(expectedProductName);

        return actualProductName.equals(expectedProductName);
    }

    public boolean isProductPriceSortByAscending() {
        List<WebElement> actualListOfProductPrice = getListWebElement(driver, ProductPageUI.PRODUCT_PRICE);

        List<Float> actualProductPrice = new ArrayList<Float>();

        for (WebElement productName : actualListOfProductPrice) {
            actualProductPrice.add(Float.parseFloat(productName.getText().replace("$","")));

        }

        List<Float> expectedProductPrice = new ArrayList<Float>();
        for (Float price : actualProductPrice) {
            expectedProductPrice.add(price);
        }
        // sort theo ASC -default
        Collections.sort(expectedProductPrice);


        return actualProductPrice.equals(expectedProductPrice);
    }
}
