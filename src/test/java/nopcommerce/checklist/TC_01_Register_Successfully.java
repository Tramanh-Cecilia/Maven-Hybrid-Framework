package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import pojoTestData.UserInfo;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class TC_01_Register_Successfully extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private FakerConfig fakerConfig;
    private static UserInfo userInfo;
    static String emailAddress, password;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
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
        emailAddress= userInfo.getEmailAddress();
        password= userInfo.getPassword();
    }


    @Test
    public void TC_01_Register_Successfully(Method method) {
        ExtentTestManager.startTest(method.getName(),"TC_01_Register_Successfully");
        ExtentTestManager.getTest().log(Status.INFO,"Step 1: Set To Register Form");
        registerPage.setToRegisterform(userInfo);


        ExtentTestManager.getTest().log(Status.INFO,"Step 2: Click to Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Step 3: Verify Success Message Text");
        Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
