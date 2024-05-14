package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ser.Serializers;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_03_Login_Successfully extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        driver = getBrowserDrivers(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);


    }


    @Test
    public void LogIn_01_Login_Successfully(Method method) {
        ExtentTestManager.startTest(method.getName(), "");
        ExtentTestManager.getTest().log(Status.INFO, "");

        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(TC_01_Register_Successfully.emailAddress, TC_01_Register_Successfully.password);

        homePage = PageGeneratorManager.getHomePage(driver);
        Assert.assertEquals(homePage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");


    }

    @AfterClass
    public void afterClasss() {
        driver.quit();
    }

}
