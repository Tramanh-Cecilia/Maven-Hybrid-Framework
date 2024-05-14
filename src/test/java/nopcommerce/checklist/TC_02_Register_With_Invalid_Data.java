package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import pojoTestData.UserInfo;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class TC_02_Register_With_Invalid_Data extends BaseTest {

    private WebDriver driver;
    private UserInfo userInfo;
    private HomePageObject homePage;
    private RegisterPageObject registerPage;

    private FakerConfig fakerData;


    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDrivers(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Register");
        registerPage = PageGeneratorManager.getRegisterPage(driver);

        userInfo = UserInfo.getUser();
        fakerData = FakerConfig.getFaker();

        userInfo.setFirstName(fakerData.getFirstName());
        userInfo.setLastName(fakerData.getLasttName());
        userInfo.setEmailAddress(fakerData.getEmailAddress());
        userInfo.setPassword(fakerData.getEmailAddress());

    }

    @Test
    public void Register_01_Register_With_Empty_Data(Method method) {
        ExtentTestManager.startTest(method.getName(), "TC_01_Register_With_Empty_Data");
        ExtentTestManager.getTest().log(Status.INFO, "Step 1 : click to Register Button");
        registerPage.clickToRegisterButton();
        ExtentTestManager.getTest().log(Status.INFO, "Step 2 : verify FN message");
        Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("FirstName-error"), "First name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 3: verify LastName message");
        Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("LastName-error"), "Last name is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 4 : click to Email Message");
        Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("Email-error"), "Email is required.");

        ExtentTestManager.getTest().log(Status.INFO, "Step 5 : click to Confirm Password Message");
        Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("ConfirmPassword-error"), "Password is required.");

    }

    @Test
    public void Register_02_Register_With_invalid_Email(Method method) {
        ExtentTestManager.startTest(method.getName(), "Register_02_Register_With_invalid_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Register_02: Set to Register form");
        userInfo.setEmailAddress(fakerData.getFirstName());
        registerPage.setToRegisterform(userInfo);
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO,"Register_03: Get Email Error Message");
        Assert.assertEquals(registerPage.getEmailErrorMessageText(),"Please enter a valid email address.");


    }

    @Test
    public void Register_04_Register_with_Existing_Email_Address(Method method){
        ExtentTestManager.startTest(method.getName(), "Register_04_Register_with_Existing_Email_Address");
        ExtentTestManager.getTest().log(Status.INFO,"Step 1: Set email ");
        userInfo.setEmailAddress(fakerData.getEmailAddress());
        var emailAdress= userInfo.getEmailAddress();

        ExtentTestManager.getTest().log(Status.INFO,"Step 2: Set to Register form");
        registerPage.setToRegisterform(userInfo);

        ExtentTestManager.getTest().log(Status.INFO, "step 3: click to register button");
        registerPage.clickToRegisterButton();

        homePage= PageGeneratorManager.getHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO,"step 4: Click to Log out Link on the Header");
        homePage.clickToHeaderLinkByName("Log out");

        ExtentTestManager.getTest().log(Status.INFO, "step 5: click to Register link");
        homePage.clickToHeaderLinkByName("Register");
        registerPage= PageGeneratorManager.getRegisterPage(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Step 6: Set to Register form"+emailAdress);
        userInfo.setEmailAddress(emailAdress);
        registerPage.setToRegisterform(userInfo);

        ExtentTestManager.getTest().log(Status.INFO,"step 7: Click to Register Button");
        registerPage.clickToRegisterButton();

        ExtentTestManager.getTest().log(Status.INFO, "Step 8: Verify Error Message for Email Textbox");
        Assert.assertEquals(registerPage.getEmailValidationErrorMessageText(), "The specified email already exists");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
