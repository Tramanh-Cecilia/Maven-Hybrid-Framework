package com.nopcommerce.account;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.*;
import reportConfig.ExtentTestManager;

public class TC_01_MyAccount extends BaseTest {

	private WebDriver driver;

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject userLoginPage;
	private CustomerPageObject customerPage;
	private AddressPageObject addressPage;
	private ChangePasswordPageObject ChangePasswordPage;
	public static String emailAddress = getEmailRandom();
	private String emailValue = "automation1234.vn@gmail.com";
	private String passwordValue = "123456";
	private String newPassword = "123456789";
	private String firstName = "Annabella";
	private String lastName = "Tarek";

	Random rand;

	@Parameters({ "browser", "userUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl) {

		driver = getBrowserDrivers(browserName, userUrl);

		homePage = PageGeneratorManager.getHomePage(driver);

		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.clickToButtonByText("Register");

		registerPage.enterToDynamicTextboxByName("FirstName", firstName);

		registerPage.enterToDynamicTextboxByName("LastName", lastName);

		registerPage.enterToDynamicTextboxByName("Email", emailAddress);

		registerPage.enterToDynamicTextboxByName("Password", passwordValue);

		registerPage.enterToDynamicTextboxByName("ConfirmPassword", passwordValue);


		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

		registerPage.clickToHeaderLinkByName("Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);
		userLoginPage.clickToLoginButton();
		userLoginPage.enterToDynamicTextboxInLoginPage("Email", emailAddress);
		userLoginPage.enterToDynamicTextboxInLoginPage("Password", passwordValue);
		userLoginPage.clickToLoginButton();
		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToHeaderLinkByName("My account");

		customerPage = PageGeneratorManager.getCustomerPage(driver);

	}

	@Test
	public void Account_01_Update_Customer_Info(Method method) {

		ExtentTestManager.startTest(method.getName(), "Account-01_Update_Customer_Info");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 01: Select female Gender ");

		customerPage.selectFemaleGender();
		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 02: Input FN");
		customerPage.enterToDynamicTextBoxByIDInAccountPage("Automation", "FirstName");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 03: Input LN");
		customerPage.enterToDynamicTextBoxByIDInAccountPage("FC", "LastName");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 04: Input DOB");
		customerPage.selectDynamicValueInDOBDropDownInAccountPageByName("5", "DateOfBirthDay");
		customerPage.selectDynamicValueInDOBDropDownInAccountPageByName("January", "DateOfBirthMonth");
		customerPage.selectDynamicValueInDOBDropDownInAccountPageByName("1999", "DateOfBirthYear");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 06:Input Email ");
		customerPage.enterToDynamicTextBoxByIDInAccountPage(emailValue, "Email");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 07:Input Company name");
		customerPage.enterToDynamicTextBoxByIDInAccountPage("Automation FC", "Company");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 08: Click Save Button");
		customerPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 09: Verify Successful Message ");
		assertEquals(customerPage.getTextSuccessNotification(), "The customer info has been updated successfully.");

		ExtentTestManager.getTest().log(Status.INFO,
				"Account-01- Step 010: Verify that Female button has been selected");
		Assert.assertTrue(customerPage.checkSelectedFemaleGender());

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify FirstName Infor");
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Automation");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify LastName Infor");
		Assert.assertEquals(customerPage.getLasttNameAttributeValue(), "FC");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify BirthDay Infor");
		Assert.assertEquals(customerPage.getDynamicBirthdayValue("DateOfBirthDay"), "5");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify BirthMonthInfor");
		Assert.assertEquals(customerPage.getDynamicBirthdayValue("DateOfBirthMonth"), "January");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify BirthYear Infor");
		Assert.assertEquals(customerPage.getDynamicBirthdayValue("DateOfBirthYear"), "1999");

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify Email Infor");
		Assert.assertEquals(customerPage.getEmailAddressAttributeValue(), emailValue);

		ExtentTestManager.getTest().log(Status.INFO, "Account-01- Step 011: verify Company Infor");
		Assert.assertEquals(customerPage.getCompanyNameAttributevalue(), "Automation FC");

	}

	@Test
	public void Account_02_Add_Address_Info(Method method) {

		ExtentTestManager.startTest(method.getName(), "Account-02_Add_Address_Info");

		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 01: Click to Address Link");
		
		customerPage.openDynamicSidePageBar("Addresses");
		addressPage = new AddressPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 02: Click to Add new Button");
		addressPage.clickToAddNewButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 03: Add FirstName");
		addressPage.enterToDynamicTextboxById("Automation", "Address_FirstName");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 04: Add Last Name");
		addressPage.enterToDynamicTextboxById("FC", "Address_LastName");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 05: Add Email Address");
		addressPage.enterToDynamicTextboxById(emailValue, "Address_Email");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 06: Add Address Company");
		addressPage.enterToDynamicTextboxById("Automation FC", "Address_Company");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 07: Add Country");
		addressPage.enterToDynamicTextboxById("Viet Nam", "Address_CountryId");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 08: Add State/province");
		addressPage.enterToDynamicTextboxById("Other", "Address_StateProvinceId");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 09: Add City");
		addressPage.enterToDynamicTextboxById("Da Nang", "Address_City");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 10: Add Address 1");
		addressPage.enterToDynamicTextboxById("123/04 Le Lai", "Address_Address1");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 11: Add Address 2");
		addressPage.enterToDynamicTextboxById("234/05 Hai Phong", "Address_Address2");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 12: Add Zipcode");
		addressPage.enterToDynamicTextboxById("550000", "Address_ZipPostalCode");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 13: Add Phone Number ");
		addressPage.enterToDynamicTextboxById("0123456789", "Address_PhoneNumber");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 14: Add Fax Number");
		addressPage.enterToDynamicTextboxById("0987654321", "Address_FaxNumber");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 15: Click To save Button");
		addressPage.clickToSaveButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 16: Verify Name");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("name"), "Automation FC");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 17: Verify  Email Value");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("email"), "Email: " + emailValue);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 18:Verify  Phoen Number");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("phone"), "Phone number: 0123456789");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 19: Verify COmpany");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("company"), "Automation FC");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 20: Verify Fax");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("fax"), "Fax number: 0987654321");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 21: Verify Address 1");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("address1"), "123/04 Le Lai");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 22: Verify Address 2");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("address2"), "234/05 Hai Phong");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 23: Verify City + Zip code");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("city-state-zip"), "Da Nang, 550000");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account-02- Step 24: Verify Country");
		Assert.assertEquals(addressPage.getDynamicTexBoxValueByClass("country"), "Viet Nam");

	}

	@Test
	public void Account_03_Change_Password(Method method) {
		
		ExtentTestManager.startTest(method.getName(), "Account_03_Update_Customer_Info");

		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 01: Open Change Password Page ");
		addressPage.openDynamicSidePageBar("Change password");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 02: enter Old Password ");
		ChangePasswordPage.enterToDynamicTextBoxInChangingPassWord(passwordValue,"OldPassword");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 03: enter New Password  ");
		ChangePasswordPage.enterToDynamicTextBoxInChangingPassWord(newPassword,"NewPassword");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 04: enter to confirm New Password  ");
		ChangePasswordPage.enterToDynamicTextBoxInChangingPassWord(newPassword,"ConfirmNewPassword");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 05: Click to Change password Button");
		ChangePasswordPage.clickToButtonByText("Change password");
	
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 06: Verify message of changing password");
		Assert.assertEquals(ChangePasswordPage.getNotificationHeaderMessage(),"Password was changed");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 07: Click to Log Out button ");
		ChangePasswordPage.clickToHeaderLinkByName("Log out");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 08: Click to Log In button  ");
		ChangePasswordPage.clickToHeaderLinkByName("Log in");
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 9: Open Loging Page ");
		userLoginPage= new LoginPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 10: Enter to Email Textbox in Login Page ");
		userLoginPage.enterToDynamicTextboxInLoginPage("Email", emailValue);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 11: Enter to Password Textbox in Login Page with OLD Password ");
		userLoginPage.enterToDynamicTextboxInLoginPage("Password", passwordValue);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 12: Click to Login Button");
		userLoginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 13: Get Error Message for Wrong Password ");
		userLoginPage.getErrorMessageInLoginPage();
		
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 14: Enter to Email Textbox in Login Page ");
		userLoginPage.enterToDynamicTextboxInLoginPage("Email", emailValue);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 15: Enter to Password Textbox in Login Page with new Password ");
		userLoginPage.enterToDynamicTextboxInLoginPage("Password", newPassword);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 16: Click to Login Button");
		userLoginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 17: Open HomePage ");
		homePage= PageGeneratorManager.getHomePage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Account_03- Step 18: verify HomePage is displayed after logging ");
		Assert.assertEquals(homePage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");

	}
//
//	@Test
//	public void Register_04_Invalid_Confirm_Password() {
//	}
//
//	@Test
//	public void Register_05_Success() {
//	}
//
//	@Test
//	public void Register_06_Login_Success() {
//
//	}

	@AfterClass
	public void afterClass() {
	}


}
