package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_06_Search_Functions extends BaseTest {
    WebDriver driver;

    private HomePageObject homePage;
    private SearchPageObject searchPage;
    private CategoriesPageObject categoriesPage;

    private LoginPageObject loginPage;
    @Parameters ({"browser","url"})
    @BeforeClass

    public void beforeClass (String browser, String url){

        driver=getBrowserDrivers(browser,url);

        homePage= PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

        homePage= PageGeneratorManager.getHomePage(driver);
        homePage.clickToFooterLinkByName("Search");
        searchPage=PageGeneratorManager.getSearchPageObject(driver);
    }

    @Test
    public void Search_01_Search_with_Empty_Data(Method method){
        ExtentTestManager.startTest(method.getName(), "Search_01_Search_with_Empty_Data");
        ExtentTestManager.getTest().log(Status.INFO,"Search_01_ Step 1: Enter to textbox with empty data  ");

        searchPage.enterToSearchKeyWordTextBox("");
        ExtentTestManager.getTest().log(Status.INFO,"Search_01_ Step 2: click To Search Button");
        searchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO,"Search_01_ Step 3: verify error message");
        Assert.assertEquals(searchPage.getErrorMessageOfSearchForm(),"Search term minimum length is 3 characters");

    }

    @Test
    public void Search_02_Search_With_Data_Not_Exist(Method method){
        ExtentTestManager.startTest(method.getName(),"Search_02_Search_With_Data_Not_Exist");
        ExtentTestManager.getTest().log(Status.INFO,"Search_02 - Step 1: Search with value = macbook Pro 2050");
        searchPage.enterToSearchKeyWordTextBox("Macbook Pro 2050");
        ExtentTestManager.getTest().log(Status.INFO,"Search_02 - Step 2: click to Search Button");
        searchPage.clickToSearchButton();
        Assert.assertEquals(searchPage.getNoProductResultMessageInSearchForm(),"No products were found that matched your criteria.");
    }

    @Test
    public void Search_03_Search_With_Product_Name(Method method){
        ExtentTestManager.startTest(method.getName(),"Search_03_Search_With_Product_Name");
        ExtentTestManager.getTest().log(Status.INFO,"Search_03 - Step 1:Search with -Lenovo ");
        searchPage.enterToSearchKeyWordTextBox("Lenovo");

        ExtentTestManager.getTest().log(Status.INFO,"Search_03 - Step 2:Click To Search Button  ");
        searchPage.clickToSearchButton();
        categoriesPage= PageGeneratorManager.getCategoriesPageObject(driver);
        ExtentTestManager.getTest().log(Status.INFO,"Search_03 - Step 03: Verify Number of Product displayed ");
         Assert.assertEquals(categoriesPage.getSizeOfProductList(), 2);

        ExtentTestManager.getTest().log(Status.INFO,"Search_03 - Step 04: Verify product Name ");
         Assert.assertTrue(categoriesPage.getSingleProductName("Lenovo IdeaCentre 600 All-in-One PC"));
         Assert.assertTrue(categoriesPage.getSingleProductName("Lenovo Thinkpad X1 Carbon Laptop"));


    }

    @Test
    public void Search_04_Search_With_Parent_Categories(Method method){
        ExtentTestManager.startTest(method.getName(),"Search_04_Search_With_Parent_Categories");
        ExtentTestManager.getTest().log(Status.INFO,"Search_04:  Step 1: enter to Search textbox with value : Apple MAcbook Pro");
        searchPage.enterToSearchKeyWordTextBox("Apple MacBook Pro");
        ExtentTestManager.getTest().log(Status.INFO,"Search_04:  Step 2: Click To advanced Search Checkbox.");
        searchPage.clickToAdvancedSearchCheckbox();

        ExtentTestManager.getTest().log(Status.INFO,"Search_04:  Step 3: Click To advanced Search Checkbox.");
        searchPage.selectValueInDynamicDropdownOfAdvancedSearch("Computers","cid");

        ExtentTestManager.getTest().log(Status.INFO,"Search_04:  Step 3: click To Search Button.");
        searchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO,"Search_04:  Step 4: Verify error message.");
        Assert.assertTrue(searchPage.getNoProductResultMessageInSearchForm().contains("No products were found that matched your criteria."));


    }

    @Test
    public void Search_05_Advanced_Search_With_Correct_Manufacturer(Method method){
        ExtentTestManager.startTest(method.getName(),"Search_05_Advanced_Search_With_Correct_Manufacturer");
        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 01:Enter into search textbox");
        searchPage.enterToSearchKeyWordTextBox("Apple MacBook Pro");
        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 02:Click to advanced Search Checkbox");
        searchPage.clickToAdvancedSearchCheckbox();

        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 03: Select Category ");
        searchPage.selectValueInDynamicDropdownOfAdvancedSearch("Computers","cid");
        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 04: Check to CheckBox sub category");
        searchPage.clickToDynamicCheckBoxInsearchPageByName("Automatically search sub categories");

        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 05: select manufaturer");
        searchPage.selectValueInDynamicDropdownOfAdvancedSearch("Apple","mid");

        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 06: Click to search Button");
        searchPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 07: Turn to Category Page");
        categoriesPage= PageGeneratorManager.getCategoriesPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Search 05: - Step 08: Verify product display");
        Assert.assertTrue( categoriesPage.getSingleProductName("Apple MacBook Pro 13-inch"));

    }


    @AfterClass
    public void afterClass(){
        driver.close();
    }

}
