//package com.nopcommerce.account;
//
//import java.lang.reflect.Method;
//import java.util.Random;
//
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import com.relevantcodes.extentreports.LogStatus;
//
//import commons.BaseTest;
//import commons.PageGeneratorManager;
//import pageObjects.AddressPageObject;
//import pageObjects.CustomerPageObject;
//import pageObjects.HomePageObject;
//import pageObjects.LoginPageObject;
//import pageObjects.OrderPageObject;
//import pageObjects.RegisterPageObject;
//import pageObjects.RewardPointPageObject;
//import reportConfig.ExtentManager;
//
//public class Level_18_ExtentReportVer2 extends BaseTest {
//
//	private WebDriver driver;
//	private HomePageObject homePage;
//	private RegisterPageObject registerPage;
//	private LoginPageObject loginPage;
//	private CustomerPageObject customerPage;
//	private OrderPageObject orderPage;
//	private AddressPageObject addressPage;
//	private RewardPointPageObject rewardPointPage;
//	private String emailAddress = getEmailRandom();
//	Random rand;
//
//
//	@Parameters("browser")
//	@BeforeClass
//	public void beforeClass(String browserName) {
//		driver = getBrowserDrivers(browserName);
//
//		homePage = PageGeneratorManager.getHomePage(driver);
//		
//	}
//
//	@Test
//	public void Register_01_Check_Error_Message(Method method) {
//		ExtentManager.startTest(method.getName(), "Register_01_Check_Error_Message");
//		ExtentManager.getTest().log(LogStatus.INFO, "NewCustomer - Step 01: Open 'Register' page");
//		homePage.clickToRegisterLink();
//		
//		registerPage = new RegisterPageObject(driver);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_  Step 2_ click to register Button");
//		registerPage.clickToRegisterButton();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_Step 2_ get FN error message and verify FN message is displayed ");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
//	
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_Step 3_ verify FN error message ");
//		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(),  "First name is required.");
//		
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_Step 4_verify LN error message ");
//		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is d.");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_Step 5 _ verify email  error message ");
//		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_Step 6 _ verify password  error message ");
//		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Fail_Step 7 _  verify confirm password error message ");
//		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");
//
//
//
//	}
//	@Test
//	public void Register_05_Success(Method method) {
//		ExtentManager.startTest(method.getName(), "Register_05_Success");
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 01: Open 'Register' page");
//		homePage =registerPage.clickToNopcommerceLogo();
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 02: Click to register Link");
//		registerPage =homePage.clickToRegisterLink();
//		
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 03: Enter To FN textbox");
//		registerPage.enterToFirstNameTextBox("John");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 04: Enter To LastName textbox");
//		registerPage.enterToLastNameTextBox("Kennedy");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 05: Enter to Email Texbox");
//		registerPage.enterToEmailTextBox(emailAddress);
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 06: Enter to Password Texbox");
//		registerPage.enterToPasswordNameTextBox("123456");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 07: Enter to Confirm Password Texbox");
//		registerPage.enterToConfirmPasswordNameTextBox("123456");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 08: Click to register button");
//		registerPage.clickToRegisterButton();
//		ExtentManager.getTest().log(LogStatus.INFO, "Register Success - Step 09: Get Success Message.");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
//
//	}
//
//	
//
//	@AfterClass
//	public void afterClass() {
//	driver.quit();
//	}
//
//}
