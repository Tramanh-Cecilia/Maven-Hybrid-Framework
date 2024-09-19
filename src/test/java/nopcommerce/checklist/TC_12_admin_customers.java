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
import pageObjects.admin.*;
import pojoTestData.UserInfo;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class TC_12_admin_customers extends BaseTest {

    private AdminLoginPageObject adminLoginPage;
    private AdminCustomerPageObject adminCustomerPage;
    private AdminDashboardPageObject adminDashboardPage;
    private FakerConfig fakerData;
    private UserInfo userInfo;

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
    public void Admin_Customer_01_Create_New_Customer(Method method){
        ExtentTestManager.startTest(method.getName()," Admin_Customer_01_Create_New_Customer");
        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 1:  Open Admin Customer Page");
        adminCustomerPage=  adminDashboardPage.openAdminCustomerPage();

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 2:  Click To Add New Customer Button");
        adminCustomerPage.isPageLoadedSuccess(driver);
        adminCustomerPage.clickToAddNewCustomerButton();

        adminCustomerPage.sleepInSecond(2);

        fakerData = new FakerConfig();
        userInfo= UserInfo.getUser();
        userInfo.setEmailAddress(fakerData.getEmailAddress());
        userInfo.setPassword(fakerData.getPassword());
        userInfo.setFirstName(fakerData.getFirstName());
        userInfo.setLastName(fakerData.getLasttName());
        userInfo.setCompanyName(fakerData.getCompany());
        userInfo.setDOB(fakerData.getDOB());

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 3:  Enter to Customer Info Form");
        adminCustomerPage.enterToCreateCustomerForm(userInfo, "Male", "Your store name", "Guests", "Not a vendor", "Add new Customer Guests");

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 4:  Click to ave button");
        adminCustomerPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 5:  get Alert Message");
        var successMessage = adminCustomerPage.getAlertSuccessMessage();

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 6:  Verify Success Message");
        Assert.assertTrue(successMessage.contains("The new customer has been added successfully."));
        adminCustomerPage.sleepInSecond(1);
        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 7:  Select guests option in Customer Role Searchbox");
        adminCustomerPage.SelectGuestOptionInCustomerRoleSearchBox();

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 8:  Enter to email Search textbox");
        adminCustomerPage.enterToDynamicSearchTextBoxById("SearchEmail",userInfo.getEmailAddress());

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 9: click To Search Button");
        adminCustomerPage.clickToSearchButton();
        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 10: Wait for Ajax button undisplayed");
        adminCustomerPage.isAjaxButtonUndisplayed();

//        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 11: verify email address");
//        Assert.assertEquals(adminCustomerPage.getTextInDynamicCellBytextInRowAndColumnName(userInfo.getEmailAddress(),"Email"), userInfo.getEmailAddress());

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 12: verify Name");
        Assert.assertEquals(adminCustomerPage.getTextInDynamicCellBytextInRowAndColumnName(userInfo.getEmailAddress(),"Name"), userInfo.getFirstName()+ " "+ userInfo.getLastName());

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 13: Verify Company Name");
        Assert.assertEquals(adminCustomerPage.getTextInDynamicCellBytextInRowAndColumnName(userInfo.getEmailAddress(),"Company name"), userInfo.getCompanyName());

        ExtentTestManager.getTest().log(Status.INFO," Admin_Customer_01 - step 14: verify Customer Role ");
        Assert.assertEquals(adminCustomerPage.getTextInDynamicCellBytextInRowAndColumnName(userInfo.getEmailAddress(),"Customer roles"), "Guests");
    }


    @AfterClass
    public void afterClass(){
//        driver.close();

    }


}
