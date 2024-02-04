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
import pageObjects.AddressPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.OrderPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;

public class Level_16_Logs extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private OrderPageObject orderPage;
	private AddressPageObject addressPage;
	private RewardPointPageObject rewardPointPage;
	private String emailAddress = getEmailRandom();
	Random rand;


	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDrivers(browserName);

		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	@Test
	public void Register_01_User_To_Admin() {
		homePage.clickToRegisterLink();
		//check log
		
		registerPage = new RegisterPageObject(driver);
		log.info("User 01 _ click to register Button");
		registerPage.clickToRegisterButton();
		
		log.info("User 01 _ get FN error message and verify FN message is displayed ");
		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
	
		log.info("User 01 _ verify FN error message ");
		verifyEquals(registerPage.getFirstNameErrorMessageText(),  "First name is required.");
		

		log.info("User 01 _ verify LN error message ");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is d.");
		
		log.info("User 01 _ verify email  error message ");
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
		log.info("User 01 _ verify password  error message ");
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
		log.info("User 01 _ verify confirm password error message ");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");



	}
	@Test
	public void Register_05_Success() {
		homePage =registerPage.clickToNopcommerceLogo();
		registerPage =homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Kennedy");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordNameTextBox("123456");
		registerPage.enterToConfirmPasswordNameTextBox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	

	@AfterClass
	public void afterClass() {
	driver.quit();
	}

}
