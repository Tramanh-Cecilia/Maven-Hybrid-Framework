package com.nopcommerce.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_05_WebDriverManager extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private String emailAddress = getEmailRandom();
	Random rand;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDrivers(browserName);

		homePage = new HomePageObject(driver);

	}

	@Test
	public void Register_01_Empty_Data() {
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		System.out.println(4);
		registerPage.clickToRegisterButton();
		System.out.println(5);
		Assert.assertEquals(registerPage.getFirstNameErrorMessageText(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessageText(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Email() {
		registerPage.clickToNopcommerceLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Kennedy");
		registerPage.enterToEmailTextBox("John@kednedy@US");
		registerPage.enterToPasswordNameTextBox("123456");
		registerPage.enterToConfirmPasswordNameTextBox("123456");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getEmailErrorMessageText(), "Wrong email");
	}

	@Test
	public void Register_03_Invalid_Password() {
		registerPage.clickToNopcommerceLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Kennedy");
		registerPage.enterToEmailTextBox("John@kednedy@US");
		registerPage.enterToPasswordNameTextBox("123");
		registerPage.enterToConfirmPasswordNameTextBox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getPasswordErrorMessageText(),
				"Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void Register_04_Invalid_Confirm_Password() {
		registerPage.clickToNopcommerceLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Kennedy");
		registerPage.enterToEmailTextBox("John@kednedy@US");
		registerPage.enterToPasswordNameTextBox("123456");
		registerPage.enterToConfirmPasswordNameTextBox("123");
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessageText(),
				"The password and confirmation password do not match.");
	}

	@Test
	public void Register_05_Success() {
		registerPage.clickToNopcommerceLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Kennedy");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordNameTextBox("123456");
		registerPage.enterToConfirmPasswordNameTextBox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");

	}

	@Test
	public void Register_06_Login_Success() {
		registerPage.clickToNopcommerceLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();

		customerPage = new CustomerPageObject(driver);
		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "John");
		Assert.assertEquals(customerPage.getLasttNameAttributeValue(), "Kennedy");
		Assert.assertEquals(customerPage.getEmailAddressAttributeValue(), emailAddress);

	}

	@AfterClass
	public void afterClass() {
	}

}
