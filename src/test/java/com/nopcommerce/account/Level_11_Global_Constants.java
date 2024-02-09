package com.nopcommerce.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
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

public class Level_11_Global_Constants extends BaseTest {

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
	private String adminURL=GlobalConstants.ADMIN_USER_URL;
	private String userURL=GlobalConstants.DEV_USER_URL;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDrivers(browserName, userURL);
		

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
	//	homePage = loginPage.clickToLoginButton();
		homePage.clickToLogOutLink();
		
		homePage.openPageUrl(driver, adminURL);
		adminLoginPage= PageGeneratorManager.getAdminLoginPage(driver);
		
		adminDashboardPage= adminLoginPage.loginToAdmin(GlobalConstants.DEV_ADMIN_USER_NAME, GlobalConstants.DEV_ADMIN_PASSWORD);
	
		Assert.assertTrue(adminDashboardPage.isPageLoadedSuccess(driver));

	}

	@Test
	public void Register_02_Admin_To_User() {
		adminLoginPage =adminDashboardPage.clickToAdminLogoutLink();
		adminLoginPage.openPageUrl(driver, userURL);
		homePage= PageGeneratorManager.getHomePage(driver);
		
		
	}

	@Test
	public void User_03_Switch_Page() {
		
	}

	@AfterClass
	public void afterClass() {
	}

}
