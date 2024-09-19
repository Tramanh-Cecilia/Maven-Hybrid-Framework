package pageObjects.orangeHrm.MainHRM;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHrm.HomePageUI;

public class HomePageObject extends BaseElement {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        super(driver);
        this.driver= driver;
    }

    public String getCurrentUserName(){
        waitForElementClickable(driver, HomePageUI.CURRENT_USERNAME);
        return getElementText(driver, HomePageUI.CURRENT_USERNAME);
    }

    public Object clickToDynamicSideBarLinkByText(String textPageName){
        waitForElementClickable(driver, HomePageUI.SIDEBAR_LINK_BY_TEXT,  textPageName);
        clickToElement(driver, HomePageUI.SIDEBAR_LINK_BY_TEXT,  textPageName);


        switch (textPageName) {
            case "Admin":
                return PageGeneratorManagerOrangeHRM.getuserManagementPageObject(driver);

            default:
                new RuntimeException("Sidebar page Name Incorrect");
                return null;
        }

    }

}
