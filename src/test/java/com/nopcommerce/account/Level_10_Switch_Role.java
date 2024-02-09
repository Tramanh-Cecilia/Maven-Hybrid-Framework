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
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class Level_10_Switch_Role extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private OrderPageObject orderPage;

	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String emailAddress = getEmailRandom();
	Random rand;
	private String adminURL, endUserUrl;

	@Parameters({"browser","adminUrl","userUrl"})
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String userUrl) {
		driver = getBrowserDrivers(browserName, userUrl);
		this.adminURL= adminUrl;
		endUserUrl= userUrl;

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
//		homePage = loginPage.clickToLoginButton();
		homePage.clickToLogOutLink();
		
		homePage.openPageUrl(driver, this.adminURL);
		adminLoginPage= PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage= adminLoginPage.loginToAdmin("admin@yourstore.com", "admin");
	
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

	}

	@Test
	public void Register_02_Admin_To_User() {
		adminLoginPage =adminDashboardPage.clickToAdminLogoutLink();
		adminLoginPage.openPageUrl(driver, endUserUrl);
		homePage= PageGeneratorManager.getHomePage(driver);
		
		
	}

	@Test
	public void User_03_Switch_Page() {
	

	}

	@AfterClass
	public void afterClass() {
	}

}
