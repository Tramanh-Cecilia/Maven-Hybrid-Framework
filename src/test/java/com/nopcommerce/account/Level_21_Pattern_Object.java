package com.nopcommerce.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_21_Pattern_Object extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String emailAddress = getEmailRandom();
	Random rand;

	@Parameters({"browser","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String userUrl) {
		driver = getBrowserDrivers(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void Register_01_Empty_Data() {

		log.info("Register_01 _ Step 1_click to register Link on Header");
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		log.info("Register_01 _ Step 2_click to register Button");
		registerPage.clickToButtonByText("Register");

		log.info("Register_01 _ Step 3_Verify Firtname Error Message");
		Assert.assertEquals(registerPage.getErrorMessageByID("FirstName"), "First name is required.");

		log.info("Register_01 _ Step 3_Verify lastName Error Message");
		Assert.assertEquals(registerPage.getErrorMessageByID("LastName"), "Last name is required.");

		log.info("Register_01 _ Step 3_Verify Email Error Message");
		Assert.assertEquals(registerPage.getErrorMessageByID("Email"), "Email is required.");

		log.info("Register_01 _ Step 3_Verify Password Error Message");
		Assert.assertEquals(registerPage.getErrorMessageByID("Password"), "Password is required.");

		log.info("Register_01 _ Step 3_Verify ConfirmPassword Error Message");
		Assert.assertEquals(registerPage.getErrorMessageByID("ConfirmPassword"), "Password is required.");
	}

	@Test
	public void Register_02_Invalid_Email() {

		log.info("Register_02 _ Step 1_Click to Nopcommerce Logo");
		homePage = registerPage.clickToNopcommerceLogo();
		log.info("Register_02 _ Step 2_Click to Register Link on header");
		homePage.clickToHeaderLinkByName("Register");

		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("Register_02 _ Step 3_Sendkey to Firtname Textbox");
		registerPage.enterToTextBoxById("FirstName","John");

		log.info("Register_02 _ Step 4_Sendkey to Lastname Textbox");
		registerPage.enterToTextBoxById("LastName","Kennedy");

		log.info("Register_02 _ Step 5_Sendkey to Email Textbox");
		registerPage.enterToTextBoxById( "Email","John@kednedy@US");

		log.info("Register_02 _ Step 6_Sendkey to Password Textbox");
		registerPage.enterToTextBoxById("Password","123456");

		log.info("Register_02 _ Step 7_Sendkey to ConfirmPassword Textbox");
		registerPage.enterToTextBoxById("ConfirmPassword","123456");

		log.info("Register_02 _ Step 8_Click To Register Button in Register Page");
		registerPage.clickToButtonByText("Register");
		log.info("Register_02 _ Step 9_verify Error Message --- Wrong Email ");
		Assert.assertEquals(registerPage.getErrorMessageByID("Email"), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {

		log.info("Register_03 _ Step 1_Click to Nopcommerce Logo");
		homePage = registerPage.clickToNopcommerceLogo();

		log.info("Register_03 _ Step 2_Click to Register Link on header");
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register_03 _ Step 3_Sendkey to Firtname Textbox");
		registerPage.enterToTextBoxById("FirstName","John");

		log.info("Register_03 _ Step 4_Sendkey to Lastname Textbox");
		registerPage.enterToTextBoxById("LastName","Kennedy");

		log.info("Register_03 _ Step 5_Sendkey to Email Textbox");
		registerPage.enterToTextBoxById("Email","John@gmail.com");

		log.info("Register_03 _ Step 6_Sendkey to Password Textbox");
		registerPage.enterToTextBoxById("Password","123");

		log.info("Register_03 _ Step 7_Sendkey to ConfirmPassword Textbox");
		registerPage.enterToTextBoxById("ConfirmPassword","123" );

//		log.info("Register_03 _ Step 8_Click To Register Button in Register Page");
//		registerPage.clickToButtonByText("Register");

		log.info(
				"Register_03 _ Step 9_verify Error Message --- Password must meet the following rules:\\nmust have at least 6 characters");
		Assert.assertEquals(registerPage.getErrorMessageByID("Password"),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Invalid_Confirm_Password() {
		
		log.info("Register_04 _ Step 1_Click to Nopcommerce Logo");
		homePage = registerPage.clickToNopcommerceLogo();
		log.info("Register_04 _ Step 2_Click to Register Link on header");
		homePage.clickToHeaderLinkByName("Register");
		registerPage = PageGeneratorManager.getRegisterPage(driver);
		
		log.info("Register_04 _ Step 3_Sendkey to Firtname Textbox");
		registerPage.enterToTextBoxById("FirstName","John");

		log.info("Register_04 _ Step 4_Sendkey to Lastname Textbox");
		registerPage.enterToTextBoxById("LastName","Kennedy");

		log.info("Register_04 _ Step 5_Sendkey to Email Textbox");
		registerPage.enterToTextBoxById("Email","John@gmail.com");

		log.info("Register_04 _ Step 6_Sendkey to Password Textbox");
		registerPage.enterToTextBoxById("Password","123456" );

		log.info("Register_04 _ Step 7_Sendkey to ConfirmPassword Textbox");
		registerPage.enterToTextBoxById("ConfirmPassword", "12345678" );

		log.info("Register_04 _ Step 8_Click To Register Button in Register Page");
		registerPage.clickToButtonByText("Register");
		
		log.info(
				"Register_04 _ Step 9_verify Error Message --- The password and confirmation password do not match.");
		Assert.assertEquals(registerPage.getErrorMessageByID("ConfirmPassword"),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		log.info("Register_05 _ Step 1_Click to Nopcommerce Logo");
		homePage = registerPage.clickToNopcommerceLogo();
		log.info("Register_05 _ Step 2_Click to Register Link on header");
		homePage.clickToHeaderLinkByName("Register");
		
		registerPage = PageGeneratorManager.getRegisterPage(driver);

		log.info("Register_05 _ Step 3_Sendkey to Firtname Textbox");
		registerPage.enterToTextBoxById("FirstName","John");

		log.info("Register_05 _ Step 4_Sendkey to Lastname Textbox");
		registerPage.enterToTextBoxById("LastName","Kennedy");

		log.info("Register_05 _ Step 5_Sendkey to Email Textbox");
		registerPage.enterToTextBoxById( "Email",emailAddress);

		log.info("Register_05 _ Step 6_Sendkey to Password Textbox");
		registerPage.enterToTextBoxById("Password","123456");

		log.info("Register_05 _ Step 7_Sendkey to ConfirmPassword Textbox");
		registerPage.enterToTextBoxById( "ConfirmPassword","123456");

		log.info("Register_05 _ Step 8_Click To Register Button in Register Page");
		registerPage.clickToButtonByText("Register");
		
		log.info("Register_05 _ Step 9_Verify Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@Test
	public void Register_06_Login_Success() {
		
		log.info("Register_06 _ Step 1_Click to Nopcommerce Logo");
		homePage = registerPage.clickToNopcommerceLogo();
		log.info("Register_06 _ Step 2_Click to Log in Link on header");
		homePage.clickToHeaderLinkByName("Log in");
		loginPage = PageGeneratorManager.getUserLoginPage(driver);
		log.info("Register_06 _ Step 3_Sendkey to Email Textbox in Login Page");
		loginPage.enterToTextBoxById("Email",emailAddress );
		log.info("Register_06 _ Step 4_Sendkey to PasswordTextbox in Login Page");
		loginPage.enterToTextBoxById("Password","123456" );
		
		log.info("Register_06 _ Step 5_Click To Login Button");
		loginPage.clickToButtonByText("Log in");
		homePage = PageGeneratorManager.getHomePage(driver);
		log.info("Register_06 _ Step 6_Click To Account Link on Header");
		homePage.clickToHeaderLinkByName("My account");
		customerPage = PageGeneratorManager.getCustomerPage(driver);
		log.info("Register_06 _ Step 7_Verify account");
		Assert.assertEquals(customerPage.getTextBoxAttributeValueByID("FirstName"), "John");
		Assert.assertEquals(customerPage.getTextBoxAttributeValueByID("LastName"), "Kennedy");
		Assert.assertEquals(customerPage.getTextBoxAttributeValueByID("Email"), emailAddress);


	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
		
	}

}
