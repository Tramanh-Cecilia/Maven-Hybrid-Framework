package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class TC_05_Add_Product_Review extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private FakerConfig fakerConfig;

    private CategoriesPageObject categoriesPage;
    private SpecificProductPageObject specificProductPage;
    private MyProductReviewPage productReviewPage;

    private CustomerPageObject customerPage;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeTest(String browser, String url) {
        driver = getBrowserDrivers(browser, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);


    }

    @Test
    public void Account_03_Add_Review_For_My_Product(Method method) {
        ExtentTestManager.startTest(method.getName(), "");
        ExtentTestManager.getTest().log(Status.INFO, "");
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.ChooseProductOnHeaderorSubMenuwithDynamicProductName();
//

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);

        var productName = categoriesPage.getRandomProductName();
        System.out.println(productName);


        specificProductPage = categoriesPage.openASpecificProductPageByProductName(productName);
        specificProductPage.addReviewForProduct();

        fakerConfig = FakerConfig.getFaker();
        specificProductPage.addToReviewForm(fakerConfig.getRandomText(), fakerConfig.getFirstName());
        specificProductPage.clickToAddReviewButton();

        Assert.assertEquals(specificProductPage.getNotificationHeaderMessage(),"Product review is successfully added.");

        specificProductPage.clickToHeaderLinkByNameWithJS("Account");

        customerPage=PageGeneratorManager.getCustomerPage(driver);
        productReviewPage= customerPage.openMyProductRevewPage("My product reviews");

        Assert.assertEquals(productReviewPage.getReviewProductTitle(),fakerConfig.getFirstName() );
        Assert.assertEquals(productReviewPage.getReviewProductTextArea(),fakerConfig.getRandomText());


    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}
