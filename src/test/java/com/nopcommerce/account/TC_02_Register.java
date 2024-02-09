package com.nopcommerce.account;

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
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class TC_02_Register extends BaseTest {

	private WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private final String emailAddress = getEmailRandom();
	private String firstName= "Annabella";
	private String lastName= "Tarek";
	public String password= "123456@";

	@Parameters({ "browser", "userUrl" })
	@BeforeClass 
	public void beforeClass(String browserName, String userUrl) {

		driver = getBrowserDrivers(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.clickToButtonByText("Register");
	}

	@Test
	public void Register_01_Empty_Data(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC_01_Register_with_Empty_Data");

	

		ExtentTestManager.getTest().log(Status.INFO, "TC-01- Step 01: Compare FirstName Error Message");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("FirstName-error"),
				"First name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "TC-01- Step 02:  Compare LastName Error Message");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("LastName-error"),
				"Last name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "TC-01- Step 03: Compare Email Error Message");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("Email-error"), "Email is required.");

		ExtentTestManager.getTest().log(Status.INFO, "TC-01- Step 04: Compare Password Error Message");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("Password-error"),
				"Password is required.");

		ExtentTestManager.getTest().log(Status.INFO, "TC-01- Step 05: Compare ConfirmPassword Error Message");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("ConfirmPassword-error"),
				"Password is required.");

	};

	@Test
	public void TC_02_Register_with_Invalid_Email(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC_02_Register_with_Invalid_Email");
		ExtentTestManager.getTest().log(Status.INFO, "TC-02- Step 01: Enter to Email Texbox");
		registerPage.enterToDynamicTextboxByName("Email", "123");

		ExtentTestManager.getTest().log(Status.INFO, "TC-02- Step 02: Click To Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC-02- Step 03: get Email Error Message - Wrong Email");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("Email-error"), "Wrong email");
	}


	@Test
	public void TC_03_Register_with_Valid_Information(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC_03_Register_with_Invalid_Email");

		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 01: Enter to FirstName Texbox");
		registerPage.enterToDynamicTextboxByName("FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 02: Enter to LastName Texbox");
		registerPage.enterToDynamicTextboxByName("LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 03: Enter to Email Texbox");
		registerPage.enterToDynamicTextboxByName("Email", emailAddress);
		 System.out.println(emailAddress);
		
			
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 04: Enter to  Password Texbox");
		registerPage.enterToDynamicTextboxByName("Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 05: Enter to  Confirm Password Texbox");
		registerPage.enterToDynamicTextboxByName("ConfirmPassword", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 06: Click To Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 07: verify success message ");
		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
		
	}
	

	public String getEmailAddress() {
		return emailAddress;
	}

	@Test
	public void TC_04_Register_with_Invalid_Information(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC-04_Register_with_Invalid_Information");

		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 01: Click to Continue Button");
		registerPage.clickToContinueButton() ;
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 02: Click to Register Button");
		homePage= PageGeneratorManager.getHomePage(driver);
		homePage.clickToHeaderLinkByName("Register");
		registerPage=  PageGeneratorManager.getRegisterPage(driver);
		
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 03: Enter to FirstName Texbox");
		registerPage.enterToDynamicTextboxByName("FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 04: Enter to LastName Texbox");
		registerPage.enterToDynamicTextboxByName("LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 05: Enter to Email Texbox"+ emailAddress);
		registerPage.enterToDynamicTextboxByName("Email", emailAddress);
			
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 06: Enter to  Password Texbox" +password);
		registerPage.enterToDynamicTextboxByName("Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 07: Enter to  Confirm Password Texbox");
		registerPage.enterToDynamicTextboxByName("ConfirmPassword", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 08: Click To Register Button");
		registerPage.clickToRegisterButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 09: verify Email validation error message ");
		Assert.assertEquals(registerPage.getEmailValidationErrorMessageText(),"The specified email already exists");
		
	}
	
	@Test
	public void TC_05_Register_with_Password_Less_Than_6_Letters(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC-05_Register_with_Password_Less_Than_6_Letters");

		ExtentTestManager.getTest().log(Status.INFO, "TC-05- Step 01: Enter to FirstName Texbox");
		registerPage.enterToDynamicTextboxByName("FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-05- Step 02: Enter to LastName Texbox");
		registerPage.enterToDynamicTextboxByName("LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-05- Step 03: Enter to Email Texbox");
		registerPage.enterToDynamicTextboxByName("Email", emailAddress);
			
		ExtentTestManager.getTest().log(Status.INFO, "TC-05- Step 04: Enter to  Password Texbox");
		registerPage.enterToDynamicTextboxByName("Password", "123");
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-05- Step 05: Enter to  Confirm Password Texbox");
		registerPage.enterToDynamicTextboxByName("ConfirmPassword", "123");
		

		ExtentTestManager.getTest().log(Status.INFO, "TC-05- Step 09: verify Email validation error message ");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("Password-error"),"Password must meet the following rules:\n"	
				+ "must have at least 6 characters");
		
	}


	@Test
	public void TC_06_Register_with_Wrong_Confirm_Password(Method method) {

		ExtentTestManager.startTest(method.getName(), "TC-06_Register_with_Wrong_Confirm_Password");

		ExtentTestManager.getTest().log(Status.INFO, "TC-06- Step 01: Enter to FirstName Texbox");
		registerPage.enterToDynamicTextboxByName("FirstName", firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-06- Step 02: Enter to LastName Texbox");
		registerPage.enterToDynamicTextboxByName("LastName", lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-06- Step 03: Enter to Email Texbox");
		registerPage.enterToDynamicTextboxByName("Email", emailAddress);
			
		ExtentTestManager.getTest().log(Status.INFO, "TC-06- Step 04: Enter to  Password Texbox");
		registerPage.enterToDynamicTextboxByName("Password", password);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-06- Step 05: Enter to  Confirm Password Texbox");
		registerPage.enterToDynamicTextboxByName("ConfirmPassword", "123");
		

		ExtentTestManager.getTest().log(Status.INFO, "TC-06- Step 09: verify Email validation error message ");
		Assert.assertEquals(registerPage.getDynamicErrorMessageTextByTextboxName("ConfirmPassword-error"),"The password and confirmation password do not match.");
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
		
	}

	

}
