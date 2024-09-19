package pageObjects.admin;

import commons.BaseElement;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminCustomerPageUI;
import pageUIs.admin.AdminSideBarPageUI;

public class AdminSideBarPageObject extends BaseElement {

    private WebDriver driver;
    public AdminSideBarPageObject(WebDriver driver) {
        super(driver);
        this.driver= driver;

    }

    public AdminProductPageObject openAdminProductPage(){
        waitForElementClickable(driver, AdminSideBarPageUI.CATALOG_LINK_IN_ADMIN_SIDE_BAR);
        clickToElement(driver, AdminSideBarPageUI.CATALOG_LINK_IN_ADMIN_SIDE_BAR);
        waitForElementClickable(driver, AdminSideBarPageUI.PRODUCT_LINK_IN_ADMIN_SIDE_BAR);
        clickToElement(driver, AdminSideBarPageUI.PRODUCT_LINK_IN_ADMIN_SIDE_BAR);
        return PageGeneratorManager.getAdminProductPage(driver);

    }


    public AdminCustomerPageObject openAdminCustomerPage(){
        waitForElementClickable(driver, AdminSideBarPageUI.CUSTOMER_LINK_IN_ADMIN_SIDE_BAR);
        clickToElement(driver, AdminSideBarPageUI.CUSTOMER_LINK_IN_ADMIN_SIDE_BAR);
        waitForElementClickable(driver, AdminSideBarPageUI.CUSTOMER_LIST_LINK_IN_ADMIN_SIDE_BAR);
        clickToElement(driver, AdminSideBarPageUI.CUSTOMER_LIST_LINK_IN_ADMIN_SIDE_BAR);
        return PageGeneratorManager.getAdminCustomerPage(driver);

    }


}
