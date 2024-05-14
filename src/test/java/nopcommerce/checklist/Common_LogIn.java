package nopcommerce.checklist;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pojoTestData.UserInfo;
import utilities.FakerConfig;

public class Common_LogIn extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;

    private FakerConfig fakerConfig;
    private static UserInfo userInfo;
    public static String emailAddress, password;

    @Parameters({"browser", "userUrl"})
    @BeforeTest
    public void beforeTest(String browserName, String url) {
        driver = getBrowserDrivers(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);


    }


}
