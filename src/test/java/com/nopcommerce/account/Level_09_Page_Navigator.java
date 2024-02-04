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

public class Level_09_Page_Navigator extends BaseTest {

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

		registerPage = homePage.clickToRegisterLink();
		registerPage.enterToFirstNameTextBox("John");
		registerPage.enterToLastNameTextBox("Kennedy");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordNameTextBox("123456");
		registerPage.enterToConfirmPasswordNameTextBox("123456");
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
		homePage = registerPage.clickToNopcommerceLogo();
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		homePage = loginPage.clickToLoginButton();
		


	}

	@Test
	public void Register_02_Admin_To_User() {

		
	}

	@Test
	public void User_03_Switch_Page() {
		addressPage = customerPage.openAddressPage();
		orderPage = addressPage.openOrderPage();
		addressPage = orderPage.openAddressPage();
		rewardPointPage = addressPage.openRewardPointPage();
		customerPage = rewardPointPage.openCustomerPage();
		
	}

	@AfterClass
	public void afterClass() {
	}

}
