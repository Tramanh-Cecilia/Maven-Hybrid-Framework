package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_09_Compare_list extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;

    private CategoriesPageObject categoriesPage;
    private CompareProductPageObject compareProductPage;
    private SpecificProductPageObject specificProductPage;
    @Parameters ({"browser","userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url){

       driver = getBrowserDrivers(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

    }
    @Test
    public void Compare_01_Add_To_Compare_List(Method method){
        ExtentTestManager.startTest(method.getName()," Compare_01_Add_To_Compare_List");
        homePage = PageGeneratorManager.getHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 01: Choose random product");
        homePage.ChooseProductOnHeaderorSubMenuwithDynamicProductName();

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 02: get random product Name");
        String productName1 = categoriesPage.getRadondomProductName();
        String productPrice1= categoriesPage.getProductPriceBasedOnProductName(productName1);
        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 03: Add the first product to compare list");
        categoriesPage.clickToCompareButtonBasedOnProductName(productName1);

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 04: Verify notification Message");
        String actualMessage = categoriesPage.getNotificationHeaderMessage();
        Assert.assertEquals( actualMessage, "The product has been added to your product comparison");

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 05: Add the second product to compare list");
        String productName2 = categoriesPage.addProductToCompareListWithoutRepeating(productName1);
        String productPrice2= categoriesPage.getProductPriceBasedOnProductName(productName2);
        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 06: Verify notification Message");
        String actualMessage1 = categoriesPage.getNotificationHeaderMessage();
        Assert.assertEquals( actualMessage1, "The product has been added to your product comparison");

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 07: Open Compare Page Object");
        categoriesPage.clickToHiddenLinkInSuccessMessage();

        compareProductPage=PageGeneratorManager.getCompareProductPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 8: Compare Product Name 1");
        Assert.assertTrue(compareProductPage.getListOfProductName().contains(productName1));

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 8: Compare Product Name 2");
        Assert.assertTrue(compareProductPage.getListOfProductName().contains(productName2));

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 8: Compare Product Price 1");
        Assert.assertEquals(compareProductPage.getDynamicCellByProductName(productName1, "product-price"), productPrice1);

        ExtentTestManager.getTest().log(Status.INFO,"Compare 01 - Step 8: Compare Product Price 2");
        Assert.assertEquals(compareProductPage.getDynamicCellByProductName(productName2, "product-price"), productPrice2);


    }
    @Test
    public void Compare_02_Recent_View_Products (Method method) {
        ExtentTestManager.startTest(method.getName(), " Compare_02_Recent_View_Products");
        homePage= PageGeneratorManager.getHomePage(driver);

        homePage.hoverToHeaderMenuByHeaderProductName("Computers");
        homePage.selectADynamicProductinSublistMenuByName("Desktops ");

        categoriesPage=PageGeneratorManager.getCategoriesPageObject(driver);
        categoriesPage.clickToProductByProductName("Build your own computer");
        categoriesPage.backToPage(driver);
        categoriesPage.clickToProductByProductName("Digital Storm VANQUISH 3 Custom Performance PC");
        categoriesPage.backToPage(driver);
        categoriesPage.clickToProductByProductName("Lenovo IdeaCentre 600 All-in-One PC");
        homePage= PageGeneratorManager.getHomePage(driver);
        homePage.hoverToHeaderMenuByHeaderProductName("Computers");
        homePage.selectADynamicProductinSublistMenuByName("Notebooks ");
        categoriesPage=PageGeneratorManager.getCategoriesPageObject(driver);
        categoriesPage.clickToProductByProductName("Apple MacBook Pro 13-inch");
        categoriesPage.backToPage(driver);
        categoriesPage.clickToProductByProductName("Asus N551JK-XO076H Laptop");

    }

    @AfterClass
    public void afterClass(){
        driver.close();
    }


}
