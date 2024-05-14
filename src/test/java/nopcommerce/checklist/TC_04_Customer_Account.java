package nopcommerce.checklist;

import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.*;
import pojoTestData.jsonData.JsonDataNopCommerce;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;

public class TC_04_Customer_Account extends BaseTest {
    private WebDriver driver;
    private HomePageObject homePage;
    private JsonDataNopCommerce customerData;
    private LoginPageObject loginPage;
    private AddressPageObject addressPage;
    private MyAccountSideBarPageObject accountSideBarPage;
    private ChangePasswordPageObject changePasswordPage;
    private FakerConfig fakerConfig;

    private String newPassword;

    private CustomerPageObject customerPage;

    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDrivers(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

        customerData = JsonDataNopCommerce.getJsonDataNopCommerce("CustomerInfor.json");

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);

    }

    @Test
    public void Account_01_Update_Customer_Information(Method method) {
        ExtentTestManager.startTest(method.getName(), "Account_01_Update_Customer_Information");
        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 01: Select Gender ");
        customerPage.selectDynamicGender("M");
        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 02: Input information ");
        customerPage.setToCustomerInforForm(customerData);

        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 03: Click to save button");
        customerPage.clickToSaveButton();

        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 04: Verify Success message");
        Assert.assertEquals(customerPage.getTextSuccessNotification(), "The customer info has been updated successfully.");


        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 05: Verify Textbox Information");
        Assert.assertEquals(customerPage.getAttributeValueOfDynamicTextbox("FirstName"), customerData.getFirstName());
        Assert.assertEquals(customerPage.getAttributeValueOfDynamicTextbox("LastName"), customerData.getLastName());
        Assert.assertEquals(customerPage.getAttributeValueOfDynamicTextbox("Email"), customerData.getEmail());
        Assert.assertEquals(customerPage.getAttributeValueOfDynamicTextbox("Company"), customerData.getCompanyName());

        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 06: Verify Gender");
        Assert.assertTrue(customerPage.checkDynamicGenderRadioButtonSelected("M"));

        ExtentTestManager.getTest().log(Status.INFO, "Account 01_ Step 07: Verify DOB");
        Assert.assertEquals(customerPage.getDynamicBirthdayValue("DateOfBirthDay"), customerData.getDayOfDOB());
        Assert.assertEquals(customerPage.getDynamicBirthdayValue("DateOfBirthMonth"), customerData.getMonthOfDOB());
        Assert.assertEquals(customerPage.getDynamicBirthdayValue("DateOfBirthYear"), customerData.getYearOfDOB());

    }

    @Test
    public void Account_02_Update_Customer_Address(Method method) {
        ExtentTestManager.startTest(method.getName(), " Account_02_Update_Customer_Address");
        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 1: click to Add new Button");
        addressPage = customerPage.openAddressPage();
        addressPage.clickToAddNewButton();

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 2: enter FN");
        addressPage.enterToDynamicTextboxById(customerData.getFirstName(), "Address_FirstName");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 3: Enter LastName ");
        addressPage.enterToDynamicTextboxById(customerData.getLastName(), "Address_LastName");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 3: Enter Address Email");
        addressPage.enterToDynamicTextboxById(customerData.getEmail(), "Address_Email");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 4: enter Address Company");
        addressPage.enterToDynamicTextboxById(customerData.getCompanyName(), "Address_Company");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 5: Select country");
        addressPage.selectDynamicDropdownByID(customerData.getCountry(), "Address_CountryId");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 6: Select State");
        addressPage.selectDynamicDropdownByID(customerData.getState(), "Address_StateProvinceId");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 7: enter to City textbox");
        addressPage.enterToDynamicTextboxById(customerData.getCity(), "Address_City");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 8: Enter to Address1 textbox");
        addressPage.enterToDynamicTextboxById(customerData.getAddress1(), "Address_Address1");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 9: Enter to Address2 textbox");
        addressPage.enterToDynamicTextboxById(customerData.getAddress2(), "Address_Address2");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 10: Enter to Postal Code textbox");
        addressPage.enterToDynamicTextboxById(customerData.getPostalcode(), "Address_ZipPostalCode");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 11: Enter to FaxNumber textbox");
        addressPage.enterToDynamicTextboxById(customerData.getFaxnumber(), "Address_FaxNumber");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 12: Enter to Phone Number textbox");
        addressPage.enterToDynamicTextboxById(customerData.getPhonenumber(), "Address_PhoneNumber");

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 13: Click to Save Button ");
        addressPage.clickToSaveButton();

        var fullName = customerData.getFirstName() + " " + customerData.getLastName();

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 14: verify Fullname");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("name"), fullName);

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 14: verify Email");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("email"), "Email: " + customerData.getEmail());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 15: verify Phone Number");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("phone"), "Phone number: " + customerData.getPhonenumber());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 16: verify Fax Number");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("fax"), "Fax number: " + customerData.getFaxnumber());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 17: verify Company Name");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("company"), customerData.getCompanyName());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 18: verify Country");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("country"), customerData.getCountry());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 19: verify Address1");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("address1"), customerData.getAddress1());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 20: verify Address2");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("address2"), customerData.getAddress2());

        ExtentTestManager.getTest().log(Status.INFO, "Account_02 - Step 21: verify Postal Code");
        Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("zippostalcode"), customerData.getPostalcode());


    }

    @Test
    public void Account_03_Change_Password(Method method) {
        ExtentTestManager.startTest(method.getName(), "Account_03_Change_Password");
        ExtentTestManager.getTest().log(Status.INFO, "Account_03 - Step 1: Click to Change Password Page");

        changePasswordPage = addressPage.openChangePasswordPage("Change password");

        fakerConfig = FakerConfig.getFaker();
        newPassword = fakerConfig.getPassword();
        ExtentTestManager.getTest().log(Status.INFO, "Account_03 - Step 2: Enter to Change Password form");
        changePasswordPage.enterIntoChangePasswordform(Common_Register.password, newPassword);

        ExtentTestManager.getTest().log(Status.INFO, "Account_03 - Step 3: Click to change Password Button");
        changePasswordPage.clickToChangePasswordButton();

        Assert.assertEquals(changePasswordPage.getNotificationHeaderMessage(), "Password was changed");
       ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 4: Close Banner");
        changePasswordPage.clickToCloseButtonOnSuccessMessageBanner();

        ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 5: Click to Log out Button");
        changePasswordPage.clickToHeaderLinkByNameWithJS("Log out");
        homePage=PageGeneratorManager.getHomePage(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 6: Click to Log In Button");
        homePage.clickToHeaderLinkByName("Log in");
        loginPage= PageGeneratorManager.getUserLoginPage(driver);

        ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 7:Enter To  Login form with old Password "+Common_Register.password);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

        ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 8:Verify error message");
        Assert.assertEquals( loginPage.getErrorMessageInLoginPage(), "Login was unsuccessful. Please correct the errors and try again.\n"
                + "The credentials provided are incorrect");

        ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 9:Enter To Log in Form with New password "+ newPassword);
        loginPage.enterToLoginForm(Common_Register.emailAddress, newPassword);

        ExtentTestManager.getTest().log(Status.INFO,"Account_03 - Step 10:Get url ");
        Assert.assertEquals(homePage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");




    }

    @AfterClass
    public void afterClass() {

    }
}
