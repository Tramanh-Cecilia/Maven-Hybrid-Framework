package pageObjects.orangeHrm.MainHRM;

import commons.BaseElement;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHrm.LoginPageUI;

public class LoginPageObject extends BaseElement {

    private WebDriver driver;


    public LoginPageObject(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public void enterIntoLoginForm(String userName, String password){
        try {
            waitForElementClickable(driver, LoginPageUI.USERNAME_TEXTBOX);
            sendkeyToElement(driver,LoginPageUI.USERNAME_TEXTBOX, userName);
            waitForElementClickable(driver, LoginPageUI.PASSWORD_TEXTBOX);
            sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX, password);
            clickToElement(driver,LoginPageUI.LOGIN_BUTTON);



        } catch (Exception e) {
            e.getStackTrace();
            throw new RuntimeException("Login is unsuccessful.");
        }



    }
}
