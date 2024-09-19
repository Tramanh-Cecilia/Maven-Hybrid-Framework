package pageObjects.orangeHrm.MainHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHrm.AdminHRM.UserManagement;

public class PageGeneratorManagerOrangeHRM {



    public static LoginPageObject getLoginPageObject(WebDriver driver){
        return new LoginPageObject(driver);

    }

    public static HomePageObject getHomePageObject(WebDriver driver){
        return new HomePageObject(driver);

    }

    public static UserManagement getuserManagementPageObject(WebDriver driver){
        return new UserManagement(driver);

    }
}
