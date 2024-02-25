package com.nopcommerce.account;

import java.lang.reflect.Method;


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
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import reportConfig.ExtentTestManager;

public class TC_03_Login extends BaseTest {

	private WebDriver driver;
	private RegisterPageObject registerPage;
	private LoginPageObject userLoginPage;
	private HomePageObject homePage;
	private final String emailAddress = TC_02_Register.emailAddress;
	private String firstName= "Annabella";
	private String lastName= "Tarek";
	public String password= "123456@";

	@Parameters({ "browser", "userUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl) {

		driver = getBrowserDrivers(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		 System.out.println(emailAddress);
		
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		registerPage.clickToButtonByText("Register");
		
		registerPage.enterToDynamicTextboxByName("FirstName", firstName);
		
		registerPage.enterToDynamicTextboxByName("LastName", lastName);
		
		registerPage.enterToDynamicTextboxByName("Email", emailAddress);
	
		registerPage.enterToDynamicTextboxByName("Password", password);
		
		registerPage.enterToDynamicTextboxByName("ConfirmPassword", password);
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(),"Your registration completed");
		
	}

	@Test
	public void Login_01_Empty_Data(Method method) {

		ExtentTestManager.startTest(method.getName(), "Login-01_Login with Empty Data");

		ExtentTestManager.getTest().log(Status.INFO, "Login-01- Step 01: Open 'Log In' page");

		registerPage.clickToHeaderLinkByName("Log in");
		userLoginPage = PageGeneratorManager.getUserLoginPage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login-01- Step 02: Click To Log In Button");
		userLoginPage.clickToLoginButton();
		

		ExtentTestManager.getTest().log(Status.INFO, "Login-01- Step 03: verify Email Error Message");
		Assert.assertEquals(userLoginPage.getEmailErrorMessage(), "Please enter your email");

	};

	@Test 
	public void  Login_02_Login_with_Invalid_Email(Method method) {
		

		ExtentTestManager.startTest(method.getName(), "Login-01_Login_with_Invalid_Email");
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-02- Step 01: Enter to Email Texbox");
		userLoginPage.enterToDynamicTextboxInLoginPage("Email", "123@gmail.com");

		ExtentTestManager.getTest().log(Status.INFO, "TC-02- Step 02: Click To Log In Button");
		userLoginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "TC-02- Step 03: get Email Error Message - Wrong Email");
		Assert.assertEquals(userLoginPage.getErrorMessageInLoginPage(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "No customer account found");
	}

	@Test
	public void  Login_03_Login_with_Wrong_Password(Method method) {
	
		 System.out.println(emailAddress);

		ExtentTestManager.startTest(method.getName(), "Login-03_Login_with_Wrong_Password");
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 01: Enter to Email Texbox");
		userLoginPage.enterToDynamicTextboxInLoginPage("Email",emailAddress);
		System.out.println( emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 02: Enter to Password Textbox in log in Page");
		userLoginPage.enterToDynamicTextboxInLoginPage("Password","789045" );

		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 03: Click To Log In Button");
		userLoginPage.clickToLoginButton();

		
		ExtentTestManager.getTest().log(Status.INFO, "TC-03- Step 04: get  Error Message - Wrong Password");
		Assert.assertEquals(userLoginPage.getErrorMessageInLoginPage(), "Login was unsuccessful. Please correct the errors and try again.\n"
				+ "The credentials provided are incorrect");
	}

	
	
	@Test 
	public void  Login_04_Login_with_Correct_credentials(Method method) {
		

		
		ExtentTestManager.startTest(method.getName(), "Login-03_Login_with_Correct_credentials");
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 01: Enter to Email Texbox" );
		userLoginPage.enterToDynamicTextboxInLoginPage("Email",emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 02: Enter to Password Textbox in log in Page");
		userLoginPage.enterToDynamicTextboxInLoginPage("Password",password);

		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 03: Click To Log In Button");
		userLoginPage.clickToLoginButton();

		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 04: switch to Homepage");
		homePage= PageGeneratorManager.getHomePage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "TC-04- Step 05: verify switch to Homepage successfully");
		Assert.assertEquals(homePage.getCurrentPageUrl(driver), "https://demo.nopcommerce.com/");
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();

	}



}
