package orangeHrm;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.orangeHrm.MainHRM.LoginPageObject;
import pageObjects.orangeHrm.MainHRM.PageGeneratorManagerOrangeHRM;


public class CommonLoginPage extends BaseTest {

    protected static WebDriver driver;
    private LoginPageObject loginPageOrange;


    @Parameters({"url", "browser","username","password"})
    @BeforeTest
    public void beforeTest(String url,String browser, String username , String password ){
        driver= getBrowserDrivers(browser, url);
        loginPageOrange= PageGeneratorManagerOrangeHRM.getLoginPageObject(driver);
        loginPageOrange.enterIntoLoginForm(username,password);


    }
    public static WebDriver getDriverFromLogin() {
        return driver;
    }

}
