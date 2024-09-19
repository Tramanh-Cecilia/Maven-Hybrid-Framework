package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;
import pageObjects.admin.AdminProductPageObject;
import pageObjects.admin.AdminSideBarPageObject;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_11_admin_SearchWithProductName extends BaseTest {

    private AdminLoginPageObject adminLoginPage;
    private AdminProductPageObject adminProductPage;
    private AdminDashboardPageObject adminDashboardPage;
    private AdminSideBarPageObject adminSideBarPage;
    private WebDriver driver;
    String productName="Lenovo IdeaCentre 600 All-in-One PC";
    @Parameters ({"browser","adminUrl","adminEmail","adminPassword"})
    @BeforeClass
    public void beforeClass(String browserName, String adminUrl, String adminEmail, String adminPassword){
        driver= getBrowserDrivers(browserName, adminUrl);
        adminLoginPage= PageGeneratorManager.getAdminLoginPage(driver);
        adminDashboardPage=  adminLoginPage.loginToAdmin(adminEmail, adminPassword);
        adminDashboardPage.isPageLoadedSuccess(driver);

    }
    @Test
    public void Admin_01_Search_With_One_Product(Method method){
        ExtentTestManager.startTest(method.getName()," Admin_01_Search_With_One_Product");
        ExtentTestManager.getTest().log(Status.INFO,"Admin_01 - step 1:  click to Product Link on Side Bar Page");
        adminProductPage=  adminDashboardPage.openAdminProductPage();

        ExtentTestManager.getTest().log(Status.INFO,"Admin_01 - step 2:  Enter to Search Textbox");
        adminProductPage.isPageLoadedSuccess(driver);
        adminProductPage.clickToSearchSection();

        adminProductPage.enterToDynamicSearchTextbox(productName,"SearchProductName");
        ExtentTestManager.getTest().log(Status.INFO,"Admin_01 - step 3:  Click to Search Button");
        adminProductPage.clickToSearchButton();

        ExtentTestManager.getTest().log(Status.INFO,"Admin_01 - step 4:  Verify product Name");
        String expectedProductName =adminProductPage.getTextInDynamicCellByproductNameAndColumnName(productName,"Product name");
        Assert.assertEquals(productName,expectedProductName );

        Assert.assertEquals(adminProductPage.isProductPulishedByDynamicProductName(productName), "true");


    }

    @Test
    public void Admin_02_Search_With_Parent (Method method){
        ExtentTestManager.startTest(method.getName()," Admin_02_Search_With_Parent ");
        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 1:  click to Product Link on Side Bar Page");
        adminProductPage.refreshCurrentPage(driver);
        adminProductPage.isPageLoadedSuccess(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 2:  Click To Search Section");
        adminProductPage.clickToSearchSection();

        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 3:  Enter To Search product Name textBox");
        adminProductPage.enterToDynamicSearchTextbox(productName,"SearchProductName");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 4:  Choose Category");
        adminProductPage.selectValueInDynamicSearchDropdownById("Computers","SearchCategoryId");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 5:  Check To Sub Category ");
        adminProductPage.uncheckToCheckBoxSearchInSubCategories();
        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 6:  Click To Search Button ");
        adminProductPage.clickToSearchButton();
        ExtentTestManager.getTest().log(Status.INFO,"Admin_02 - step 7: Verify Empty Data in Table");
        Assert.assertEquals(adminProductPage.getEmptyErrorMessage(),"No data available in table");


    }
    @Test
    public void Admin_03_Search_With_ProductName_and_SubCategory (Method method){
        ExtentTestManager.startTest(method.getName()," Admin_03_Search_With_ProductName_and_SubCategory ");
        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 1:  click to Product Link on Side Bar Page");
        adminProductPage.refreshCurrentPage(driver);
        adminProductPage.isPageLoadedSuccess(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 2:  Click To Search Section");
        adminProductPage.clickToSearchSection();

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 3:  Enter To Search product Name textBox");
        adminProductPage.enterToDynamicSearchTextbox(productName,"SearchProductName");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 4:  Choose Category");
        adminProductPage.selectValueInDynamicSearchDropdownById("Computers","SearchCategoryId");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 5:  Check To Sub Category ");
        adminProductPage.checkToCheckBoxSearchInSubCategories();
        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 6:  Click To Search Button ");
        adminProductPage.clickToSearchButton();
        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 7: Verify product in the table");
        String expectedProductName =adminProductPage.getTextInDynamicCellByproductNameAndColumnName(productName,"Product name");
        Assert.assertEquals(productName,expectedProductName );


    }@Test
    public void Admin_04_Search_With_ProductName_and_SubCategory_laptops (Method method){
        ExtentTestManager.startTest(method.getName(),"  Admin_04_Search_With_ProductName_and_SubCategory_laptops");
        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 1:  click to Product Link on Side Bar Page");
        adminProductPage.refreshCurrentPage(driver);
        adminProductPage.isPageLoadedSuccess(driver);


        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 2:  Click To Search Section");
        adminProductPage.clickToSearchSection();

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 3:  Enter To Search product Name textBox");
        adminProductPage.enterToDynamicSearchTextbox(productName,"SearchProductName");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 4:  Choose Category Computers >> Desktops");
        adminProductPage.selectValueInDynamicSearchDropdownById("Computers >> Desktops","SearchCategoryId");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 5:  Uncheck To Sub Category ");
        adminProductPage.uncheckToCheckBoxSearchInSubCategories();
        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 6:  Click To Search Button ");
        adminProductPage.clickToSearchButton();
        ExtentTestManager.getTest().log(Status.INFO,"Admin_03 - step 7: Verify product in the table");
        String expectedProductName =adminProductPage.getTextInDynamicCellByproductNameAndColumnName(productName,"Product name");
        Assert.assertEquals(productName,expectedProductName );


    }

    @Test
    public void Admin_05_Search_By_SKU (Method method){
        ExtentTestManager.startTest(method.getName()," Admin_05_Search_By_SKU");
        ExtentTestManager.getTest().log(Status.INFO,"Admin_05 - step 1:  click to Product Link on Side Bar Page");
        adminProductPage.refreshCurrentPage(driver);
        adminProductPage.isPageLoadedSuccess(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Admin_05 - step 2:  Click To Search Section");
        adminProductPage.clickToSearchSection();

        ExtentTestManager.getTest().log(Status.INFO,"Admin_5 - step 3:  Enter To Search product Name textBox");
        adminProductPage.enterToDynamicSearchTextbox("LE_IC_600","GoDirectlyToSku");

        ExtentTestManager.getTest().log(Status.INFO,"Admin_5 - step 4:  Click to GO button at SKU Textbox");
        adminProductPage.clickToGoButtonAtSKUTextbox();
        adminProductPage.isPageLoadedSuccess(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Admin_5 - step 6:  Verify product Name");
        Assert.assertEquals(adminProductPage.getProductNameInProductTextBoxInEditPageDetail(), productName);


    }
    @AfterClass
    public void afterClass(){

    }


}
