package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pojoTestData.UserInfo;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class Common_Register extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;
    private LoginPageObject loginPage;
    private FakerConfig fakerConfig;
    private static UserInfo userInfo;
    public static String emailAddress, password, firstName, lastName;

    @Parameters({"browser", "userUrl"})
    @BeforeTest()
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDrivers(browserName, url);

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Register");

        registerPage = PageGeneratorManager.getRegisterPage(driver);
        fakerConfig = FakerConfig.getFaker();

        userInfo = UserInfo.getUser();
        userInfo.setFirstName(fakerConfig.getFirstName());
        userInfo.setLastName(fakerConfig.getLasttName());
        userInfo.setEmailAddress(fakerConfig.getEmailAddress());
        userInfo.setPassword(fakerConfig.getPassword());
        emailAddress = userInfo.getEmailAddress();
        password = userInfo.getPassword();
        firstName= userInfo.getFirstName();
        lastName= userInfo.getLastName();

        registerPage.setToRegisterform(userInfo);
        registerPage.clickToRegisterButton();
        driver.quit();
    }


}
