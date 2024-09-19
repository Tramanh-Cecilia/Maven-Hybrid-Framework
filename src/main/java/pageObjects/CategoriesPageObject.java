package pageObjects;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.user.BaseElementUI;
import pageUIs.user.CategoriesPageObjectUI;
import pageUIs.user.SpecificProductPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CategoriesPageObject extends BaseElement {
    WebDriver driver;
    private HomePageObject homePage;

    public static String productName;

    public CategoriesPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getRandomProductName() {
        waitForListElementVisible(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        List<WebElement> ListOfProductName = getListWebElement(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        int numberOfProduct = getListElementSize(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        Random rand = new Random();
        return ListOfProductName.get(rand.nextInt(numberOfProduct)).getText();

    }

    public void clickToProductByProductName(String productName){
        waitForElementClickable(driver, CategoriesPageObjectUI.DYNAMIC_PRODUCT_BY_TEXT_NAME, productName);
        clickToElement(driver, CategoriesPageObjectUI.DYNAMIC_PRODUCT_BY_TEXT_NAME, productName);
    }

    public SpecificProductPageObject openASpecificProductPageByProductName(String productName) {
        clickToProductByProductName(productName);
        isPageLoadedSuccess(driver);
        return PageGeneratorManager.getSpecificProductPageObject(driver);
    }


    public SpecificProductPageObject getRandomProductToWishList() {
        List<WebElement> listProduct = getListOfProductName();
        Random rand = new Random();
        boolean success = false;

        while (!success && !listProduct.isEmpty()) {
            int index = rand.nextInt(listProduct.size());
            productName = listProduct.get(index).getText();
            try {
                SpecificProductPageObject productPage = openASpecificProductPageByProductName(productName);
                success = productPage.isAddToWishListSuccessfully();


                if (success) {
                    break;
                } else {  // If adding to wishlist failed, remove the product from the list and try another
                    listProduct.remove(index);
                    backToPage(driver);
                }

            } catch (Exception e) {
                listProduct.remove(index);
                backToPage(driver);
                homePage = PageGeneratorManager.getHomePage(driver);
                homePage.ChooseProductOnHeaderorSubMenuwithDynamicProductName();
            }


        }
        if (!success) {
            throw new RuntimeException("Failed to add any product to the wishlist.");
        } else {
            return PageGeneratorManager.getSpecificProductPageObject(driver);
        }
    }

    public SpecificProductPageObject openRandomProductPage() {
        List<WebElement> listProduct = getListOfProductName();
        var randomItem = getRandomNumberInGivenRange(listProduct.size());
        var productName = listProduct.get(randomItem).getText();
        return openASpecificProductPageByProductName(productName);

    }


    public int getSizeOfProductList() {
        waitForListElementVisible(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        return getListElementSize(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);

    }

    public List<WebElement> getListOfProductName() {
        waitForListElementVisible(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        return getListWebElement(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
    }

    public int getNumberOfProductOnPage() {
        waitForListElementVisible(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        return getListElementSize(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
    }


    public boolean isNumberOfProductsLowerThanExpected(int expectedNumber) {
        if (getNumberOfProductOnPage() == expectedNumber || getNumberOfProductOnPage() < expectedNumber) {
            return true;
        } else {
            return false;
        }
    }

    public void clickToDynamicPageNUmber(String pageNumber) {
        waitForElementClickable(driver, CategoriesPageObjectUI.DYNAMIC_PAGE_NUMBER, pageNumber);
        clickToElement(driver, CategoriesPageObjectUI.DYNAMIC_PAGE_NUMBER, pageNumber);
        isElementUnDisplayed(driver, BaseElementUI.AJAX_ICON);
    }

    public boolean isNextOrPreviousPageIconDisplay(String iconClass) {
        return isElementDisplayed(driver, CategoriesPageObjectUI.NEXT_AND_PREVIOUS_PAGE_ICON, iconClass);
    }

    public boolean isNextOrPreviousPageIconUnDisplayed(String iconClass) {
        return isElementUnDisplayed(driver, CategoriesPageObjectUI.NEXT_AND_PREVIOUS_PAGE_ICON, iconClass);
    }


    public boolean getSingleProductName(String expectedName) {
        waitForListElementVisible(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        List<WebElement> ListOfProductName = getListWebElement(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_NAME);
        for (WebElement productName : ListOfProductName) {
            var productNameText = productName.getText();
            if (productNameText.equals(expectedName)) {
                return true;

            }

        }

        return false;
    }

    public void selectSortTypeInSortDropdown(String sortValue, String dropdownID) {
        waitForElementClickable(driver, CategoriesPageObjectUI.DYNAMIC_SORT_DROPDOWN_BY_ID, dropdownID);
        clickToElement(driver, CategoriesPageObjectUI.DYNAMIC_SORT_DROPDOWN_BY_ID, dropdownID);
        selectItemInDefaultDropdown(driver, CategoriesPageObjectUI.DYNAMIC_SORT_DROPDOWN_BY_ID, sortValue, dropdownID);
        isElementUnDisplayed(driver, BaseElementUI.AJAX_ICON);
    }

    public String getFirstSortTypeOptionInSortDropdown(String dropdownID) {
        waitForListElementVisible(driver, CategoriesPageObjectUI.DYNAMIC_SORT_DROPDOWN_BY_ID, dropdownID);
        return selectFirstSelectedTextInDefaultDropdown(driver, CategoriesPageObjectUI.DYNAMIC_SORT_DROPDOWN_BY_ID, dropdownID);
    }

    public boolean isProductSortByName() {
        List<WebElement> listProductName = getListOfProductName();

        List<String> actualProductName = new ArrayList<>();

        for (int i = 0; i < listProductName.size(); i++) {
            try {
                WebElement productName = listProductName.get(i);
                waitForElementClickable(driver, productName);
                actualProductName.add(productName.getText());
//
            } catch (StaleElementReferenceException e) {
// Re-fetch the elements
                listProductName = getListOfProductName();
                // Fetch the current element text again
                WebElement refreshedProductName = listProductName.get(i);
                ;
                waitForElementClickable(driver, refreshedProductName);
                actualProductName.add(refreshedProductName.getText());
//
            }
        }
        List<String> expectedProductName = new ArrayList<>();
        for (String name : actualProductName) {
            expectedProductName.add(name);

        }

        if (getFirstSortTypeOptionInSortDropdown("products-orderby").contains("A to Z")) {
            Collections.sort(expectedProductName);

        } else {
            Collections.sort(expectedProductName);
            Collections.reverse(expectedProductName);


        }
        return actualProductName.equals(expectedProductName);
    }

    public List<WebElement> getListOfProductPrice() {
        waitForListElementVisible(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_PRICE);
        return getListWebElement(driver, CategoriesPageObjectUI.LIST_OF_PRODUCT_PRICE);

    }

    public boolean isProductSortByPrice() {
        List<WebElement> listProductPrice = getListOfProductPrice();
        waitForElementInvisible(driver, BaseElementUI.AJAX_ICON);

        List<Float> actualProductPrice = new ArrayList<>();

        for (int i = 0; i < listProductPrice.size(); i++) {
            boolean success = false;
            int attemps = 0;

            while (!success && attemps < 3) {
                try {
                    WebElement singleProduct = listProductPrice.get(i);
                    actualProductPrice.add(Float.valueOf(singleProduct.getText().substring(1).replace(",", "")));
                    success = true;

                } catch (StaleElementReferenceException e) {
                    listProductPrice = getListOfProductPrice();
                    attemps++;
                    System.out.println("Retrying to fetch product price. Attempt: " + attemps);
                }
            }
            if (!success) {
                throw new RuntimeException("Failed to fetch product price after multiple attempts.");
            }

        }
        List<Float> expectedProductPrice = new ArrayList<>();
        for (WebElement price : listProductPrice)
            expectedProductPrice.add(Float.valueOf(price.getText().substring(1).replace(",", "")));

        if (getFirstSortTypeOptionInSortDropdown("products-orderby").contains("Price: Low to High")) {
            Collections.sort(expectedProductPrice);


        } else {
            Collections.sort(expectedProductPrice);
            Collections.reverse(expectedProductPrice);

        }

        return actualProductPrice.equals(expectedProductPrice);
    }

    public void clickToCompareButtonBasedOnProductName(String productName) {
        waitForElementClickable(driver, CategoriesPageObjectUI.COMPARE_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(driver, CategoriesPageObjectUI.COMPARE_BUTTON_BY_PRODUCT_NAME, productName);

    }

    public void clickToAddToCartButtonBasedOnProductName(String productName) {
        waitForElementClickable(driver, CategoriesPageObjectUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
        clickToElement(driver, CategoriesPageObjectUI.ADD_TO_CART_BUTTON_BY_PRODUCT_NAME, productName);
        isAjaxLoadingUndisplayed();

    }

    public String getProductPriceBasedOnProductName(String productName){
        waitForElementClickable(driver, CategoriesPageObjectUI.PRODUCT_PRICE_BY_PRODUCT_NAME, productName);
        return getElementText(driver, CategoriesPageObjectUI.PRODUCT_PRICE_BY_PRODUCT_NAME, productName);

    }

    public String getRadondomProductName() {
        List<WebElement> listProduct = getListOfProductName();
        var randomItem = getRandomNumberInGivenRange(getSizeOfProductList());
        return listProduct.get(randomItem).getText();

    }

    public String addProductToCompareListWithoutRepeating(String previousProductName) {
        List<WebElement> listProduct = getListOfProductName();
        var randomItem = getRandomNumberInGivenRange(getSizeOfProductList());
        var nextProductName = listProduct.get(randomItem).getText();
        if (!previousProductName.equals(nextProductName)) {
            clickToCompareButtonBasedOnProductName(nextProductName);
            return nextProductName;
        } else {
            listProduct.remove(randomItem);
            var newSize = listProduct.size();
            var newProductName = listProduct.get(getRandomNumberInGivenRange(newSize)).getText();
            clickToCompareButtonBasedOnProductName(newProductName);
            return newProductName;

        }


    }

    public void clickToMultipleProductsOnPage(){
        int size =getNumberOfProductOnPage();
        for (int i = 0; i < size; i ++){
           var productName= getListOfProductName().get(i).getText();
            clickToProductByProductName(productName);
            backToPage(driver);
        }

    }

}





