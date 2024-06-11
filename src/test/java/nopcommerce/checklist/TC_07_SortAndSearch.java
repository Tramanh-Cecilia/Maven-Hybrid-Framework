package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.aspectj.lang.annotation.After;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.CategoriesPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_07_SortAndSearch extends BaseTest {

    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;
    private CategoriesPageObject categoryPage;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeCLass(String browserName, String userUrl) {
        driver = getBrowserDrivers(browserName, userUrl);

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");

        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

        homePage = PageGeneratorManager.getHomePage(driver);


    }

    @Test
    public void Sort_01_Sort_With_Name_FromAToZ(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort_01_Sort_With_Name_FromAToZ");
        ExtentTestManager.getTest().log(Status.INFO, "Sort 01 -Step 1: Hover to Product Header");

        homePage.hoverToProductOnHeaderMenuwithDynamicProductName("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Sort 01 -Step 2: Select NoteBooks sublist");
        homePage.selectADynamicProductinSublistMenuByName("Notebooks");
        categoryPage = PageGeneratorManager.getCategoriesPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Sort 01 - Step 3: Select Sort Type From A to Z");
        categoryPage.selectSortTypeInSortDropdown("Name: A to Z","products-orderby");


        ExtentTestManager.getTest().log(Status.INFO, "Sort 01 - Step 4: verify product Name is sort From A to Z successfully");
        Assert.assertTrue(categoryPage.isProductSortByName());


    }

    @Test
    public void Sort_02_Sort_With_ProductName_FromZtoA(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sort_02_Sort_With_ProductName_FromZtoA");

        ExtentTestManager.getTest().log(Status.INFO, "Sort 02 -Step 1: Select Sort Option from Name from Z to A");
        categoryPage.selectSortTypeInSortDropdown("Name: Z to A", "products-orderby");

        ExtentTestManager.getTest().log(Status.INFO, "Sort 02 -Step 2: verify product Name is sort From Z to A successfully");
        Assert.assertTrue(categoryPage.isProductSortByName());

    }

    @Test
    public void Sort_03_Sort_By_Product_Price_From_Low_To_High (Method method){
        ExtentTestManager.startTest(method.getName(),"Sort_03_Sort_By_Product_Price_From_Low_To_High ");
        ExtentTestManager.getTest().log(Status.INFO,"Sort 03 - Step 1: Select sort Option - Price: Low to High  ");
        categoryPage.selectSortTypeInSortDropdown("Price: Low to High", "products-orderby");

        ExtentTestManager.getTest().log(Status.INFO,"Sort 03 - Step 2: Verify Product Price is sort from Low to High  ");
        Assert.assertTrue(categoryPage.isProductSortByPrice());
    }


    @Test
    public void Sort_04_Sort_By_Product_Price_From_High_To_Low (Method method){
        ExtentTestManager.startTest(method.getName()," Sort_04_Sort_By_Product_Price_From_High_To_Low ");
        ExtentTestManager.getTest().log(Status.INFO,"Sort 04 - Step 1: Select sort Option - Price: High to Low  ");
        categoryPage.selectSortTypeInSortDropdown("Price: Low to High", "products-orderby");

        ExtentTestManager.getTest().log(Status.INFO,"Sort 04 - Step 2: Verify Product Price is sort from  High to Low  ");
        Assert.assertTrue(categoryPage.isProductSortByPrice());
    }

    @Test
    public void Sort_05_Display_Only_3_product(Method method){
        ExtentTestManager.startTest(method.getName()," Sort_5_Display_Only_3_product");
        ExtentTestManager.getTest().log(Status.INFO,"Sort 05 - Step 1: Select PageSize in Dropdown ");
        categoryPage.selectSortTypeInSortDropdown("3","products-pagesize");

        ExtentTestManager.getTest().log(Status.INFO,"Sort 5 - Step 2 Verify that the number of product displaying on the page is lower than 3");
        categoryPage.isNumberOfProductsLowerThanExpected(3);

       ExtentTestManager.getTest().log(Status.INFO," Sort 5 - Step 3 : Verify that next Page Icon has displayed");
        Assert.assertTrue( categoryPage.isNextOrPreviousPageIconDisplay("next-page"));

        ExtentTestManager.getTest().log(Status.INFO," Sort 5 - Step 4 : Click To Page 2");
        categoryPage.clickToDynamicPageNUmber("2");

        ExtentTestManager.getTest().log(Status.INFO,"Sort 5 - Step 5: Verify that Previous Page Icon has displayed ");
        Assert.assertTrue( categoryPage.isNextOrPreviousPageIconDisplay("previous-page"));
    }

    @Test
    public void Sort_06_Display_Only_6_Products(Method method){
        ExtentTestManager.startTest(method.getName()," Sort_06_Display_Only_6_Products");
        ExtentTestManager.getTest().log(Status.INFO, "Sort 06:  Step 1: Select PageSize Product = 6");
        categoryPage.selectSortTypeInSortDropdown("6","products-pagesize");

        ExtentTestManager.getTest().log(Status.INFO,"Sort 06  -  Step 02 : Verify that number of product is lower or equal 6");
        categoryPage.isNumberOfProductsLowerThanExpected(6);

        ExtentTestManager.getTest().log(Status.INFO,"Sort 06  -  Step 02 : Verify that NextPage icon is undisplayed");
        categoryPage.isNextOrPreviousPageIconUnDisplayed("next-page");



    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }

}
