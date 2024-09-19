package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebElement;
import pageUIs.user.HomePageUI;

import java.util.List;

public class HomePageObject extends BaseElement {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegisterPageObject clickToRegisterLink() {
        waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
        clickToElement(driver, HomePageUI.REGISTER_LINK);
        return PageGeneratorManager.getRegisterPage(driver);
    }

    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return PageGeneratorManager.getUserLoginPage(driver);

    }

    public CustomerPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return PageGeneratorManager.getCustomerPage(driver);
    }

    public void clickToMyLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);

    }

    public void clickToLogOutLink() {
        waitForElementClickable(driver, HomePageUI.LOGOUT_LINK);
        clickToElement(driver, HomePageUI.LOGOUT_LINK);

    }

    public boolean IsLoginButtonNotDisplayed() {
        return isElementDisplayed(driver, HomePageUI.LOGIN_LINK);
    }

    public List<WebElement> getListOfProductNameOnHeaderMenu() {
        waitForElementVisible(driver, HomePageUI.LIST_PRODUCTS_ON_ON_HEADER_MENU);
        return getListWebElement(driver, HomePageUI.LIST_PRODUCTS_ON_ON_HEADER_MENU);
    }


    public String ChooseProductOnHeaderorSubMenuwithDynamicProductName() {
        String headerName=getRandomNameOfProductMenu();
        hoverToHeaderMenuByHeaderProductName(headerName);

        if (isHeaderMenuHasSublist(headerName)) {
            String chosenProductSublistText= getSublistName(headerName);
            selectADynamicProductinSublistMenuByName(chosenProductSublistText);
            return chosenProductSublistText;
        } else {
			clickToElement(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_ON_HEADER_MENU, headerName);
            return headerName;
		}

    }

    public String getRandomNameOfProductMenu(){
        int listHeaderItems = getListElementSize(driver, HomePageUI.LIST_PRODUCTS_ON_ON_HEADER_MENU);
        String headerName = getListOfProductNameOnHeaderMenu().get(getRandomNumberInGivenRange(listHeaderItems)).getText();
        return headerName;
    }

    public void hoverToHeaderMenuByHeaderProductName(String headerName){
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_ON_HEADER_MENU, headerName);
        hoverToElement(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_ON_HEADER_MENU, headerName);
    }

    public boolean isHeaderMenuHasSublist(String headerName){
        int sublistItems = getListElementSize(driver, HomePageUI.DYNAMIC_SUBLIST_PRODUCTS_ON_ON_HEADER_MENU, headerName);
        if (sublistItems>0 ) {
            return true;
        }
        return false;
    }


    public String getSublistName(String headerName){
        int sublistItems = getListElementSize(driver, HomePageUI.DYNAMIC_SUBLIST_PRODUCTS_ON_ON_HEADER_MENU, headerName);
        return getListWebElement(driver, HomePageUI.DYNAMIC_SUBLIST_PRODUCTS_ON_ON_HEADER_MENU, headerName).get(getRandomNumberInGivenRange(sublistItems)).getText();
    }


    public boolean isSublistChosenBefore(String previousChosenList ){
        String newSublistName= ChooseProductOnHeaderorSubMenuwithDynamicProductName();
        boolean chosen=false;
        if (newSublistName.equals(previousChosenList)) {
            return true;
        }
        return false;

    }

    //lan 1  return
    // remove name1 khi array list
    public void removeSublistFromArray (String itemRemove){
        List<WebElement> listProducts= getListOfProductNameOnHeaderMenu();
        int numberOfHeaderItems = getListElementSize(driver, HomePageUI.LIST_PRODUCTS_ON_ON_HEADER_MENU);


    }





    public void selectADynamicProductinSublistMenuByName(String productName) {
        waitForElementClickable(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_ON_SUBLIST_MENU, productName);
        clickToElement(driver, HomePageUI.DYNAMIC_PRODUCT_NAME_ON_SUBLIST_MENU, productName);
    }
}
