package orangeHrm;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.orangeHrm.AdminHRM.UserManagement;
import pageObjects.orangeHrm.MainHRM.HomePageObject;
import pageObjects.orangeHrm.MainHRM.PageGeneratorManagerOrangeHRM;
import pojoTestData.OrangeHRMdata.AdminInfor;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class Admin_01_UserManagement extends BaseTest {

    private WebDriver driver;
    private HomePageObject homePageObject;
    private UserManagement userManagementPage;
    private FakerConfig fakerConfig;
    private AdminInfor adminInfor;

    private String username;
    private String currentUsername;

    @BeforeClass
    public void beforeClass(){
        driver = CommonLoginPage.getDriverFromLogin();
        homePageObject= PageGeneratorManagerOrangeHRM.getHomePageObject(driver);
        homePageObject.sleepInSecond(2);
           currentUsername= homePageObject.getCurrentUserName();
        userManagementPage= (UserManagement) homePageObject.clickToDynamicSideBarLinkByText("Admin");
    }

    @BeforeMethod
    public void beforeTest(){
        userManagementPage.sleepInSecond(2);

    }
    @Test
    public void Admin_01_Add_new_Admin (Method method){
        ExtentTestManager.startTest(method.getName()," TC_01_Add_new_Admin");
        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 1:  Click To Add Button ");
        userManagementPage.clickToAddButton();

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 2: click to User Role dropdown");
        userManagementPage.selectValueInDynamicDropdownByName("User Role","Admin");

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 3:  click to status dropdown");
        userManagementPage.selectValueInDynamicDropdownByName("Status","Enabled");

        fakerConfig= FakerConfig.getFaker();
        adminInfor= AdminInfor.getAdminInfor();
        username = fakerConfig.getUserName();
        adminInfor.setUserName(fakerConfig.getUserName());
        adminInfor.setPassword(fakerConfig.getPassword());

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 4: add password");
        userManagementPage.enterToDynamicTextBoxInUserManagement("Password",adminInfor.getPassword());

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 5: add Confirm password");
        userManagementPage.enterToDynamicTextBoxInUserManagement("Confirm Password",adminInfor.getPassword());

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 6: add UserName");
        userManagementPage.enterToDynamicTextBoxInUserManagement("Username", username);

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 7: Enter to employee name textbox");
        userManagementPage.enterToEmployeeTextbox(currentUsername);

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 8: click to Save Button");
        userManagementPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 9: Verify Success message");
        Assert.assertEquals(userManagementPage.getSuccessMessage(),"Successfully Saved");

        Assert.assertTrue(userManagementPage.isLoadingSpinnerUndisplayed());
    }

    @Test
    public void Admin_02_Search_System_User (Method method){
        ExtentTestManager.startTest(method.getName(),"  TC_02_Search_System_User");
        ExtentTestManager.getTest().log(Status.INFO,"TC 01 | Step 01: Wait for Loading Spinner invisible");
        userManagementPage= (UserManagement) homePageObject.clickToDynamicSideBarLinkByText("Admin");
        userManagementPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO,"TC 02 | Step 02: Search User");
        userManagementPage.enterToDynamicSearchTextBox(username, "Username");

        ExtentTestManager.getTest().log(Status.INFO,"TC 02 | Step 03: Click To Search Button");
        userManagementPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO,"TC 02| Step 04: get User role");
        String userole= userManagementPage.getTextinDynamicCellByUserName(username, "User Role");

        ExtentTestManager.getTest().log(Status.INFO,"TC 02 | Step 05: Verify user role");
        Assert.assertEquals( userole, "Admin");

        ExtentTestManager.getTest().log(Status.INFO,"TC 02 | Step 06: Status");
        String status= userManagementPage.getTextinDynamicCellByUserName(username, "Status");

        ExtentTestManager.getTest().log(Status.INFO,"TC 02 | Step 07: verify status");
        Assert.assertEquals( status, "Enabled");
    }
    @Test
    public void Admin_03_Edit_Existing_User(Method method){
        ExtentTestManager.startTest(method.getName()," Admin_03_Edit_Existing_User");
        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 01: Wait for Loading Spinner invisible");
        userManagementPage= (UserManagement) homePageObject.clickToDynamicSideBarLinkByText("Admin");
//        userManagementPage.
        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 02: click to Edit Button");
        userManagementPage.deleteOrEditUsernameByDynamicActionAndUserName(username, "edit");

        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 03: Wait for Loading Spinner invisible");
        userManagementPage.isLoadingSpinnerUndisplayed();

        userManagementPage.sleepInSecond(2);

        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 04: Update User Role");
        userManagementPage.selectValueInDynamicDropdownByName("User Role","ESS");

        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 05: click To Save Button");
        userManagementPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 06: get user role");
        String userole= userManagementPage.getTextinDynamicCellByUserName(username, "User Role");

        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 07: Verify that user role has been updated ");
        Assert.assertEquals( userole, "ESS");

    }
    @Test
    public void Admin_04_Delete_Usename(Method method) {
        ExtentTestManager.startTest(method.getName(), " Admin_04_Delete_Usename");
        ExtentTestManager.getTest().log(Status.INFO,"Admin 03 | Step 01: click to delete button");
        userManagementPage.deleteOrEditUsernameByDynamicActionAndUserName(username, "delete");

        ExtentTestManager.getTest().log(Status.INFO,"Admin 04 | Step 02: click to Cancel Button in confirm dialog");
        Assert.assertTrue(userManagementPage.cancelOrConfirmDeleteUserNameByAction("cancel"));

        ExtentTestManager.getTest().log(Status.INFO,"Admin 04 | Step 03: click to delete button again");
        userManagementPage.deleteOrEditUsernameByDynamicActionAndUserName(username, "delete");

        ExtentTestManager.getTest().log(Status.INFO,"Admin 04 | Step 04: confirm delete username");
        Assert.assertTrue(userManagementPage.cancelOrConfirmDeleteUserNameByAction("delete"));

        ExtentTestManager.getTest().log(Status.INFO,"Admin 04 | Step 05: search deleted username");
        userManagementPage.enterToDynamicSearchTextBox(username, "Username");

        ExtentTestManager.getTest().log(Status.INFO,"Admin 04 | Step 06: click to search button");
        userManagementPage.clickToSaveButton();

        Assert.assertEquals(userManagementPage.getNoRecordTextAfterSearchButton(),"No Records Found");
    }
}
