package com.nopcommerce.account;

import static org.testng.Assert.assertEquals;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.AddressPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class TC_01_MyAccount extends BasePage {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private String osName = System.getProperty("os.name");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerPageObject customerPage;
	private AddressPageObject addressPage;
	private String emailAddress = getEmailRandom();
	private String emailValue = "automationfc.vn@gmail.com";
	private String passwordValue = "123456";
	private String newPassword = "123456789";

	Random rand;

	@BeforeClass
	public void beforeClass() {

		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		registerPage.enterToFirstNameTextBox("Kennedy");
		registerPage.enterToLastNameTextBox("US");
		registerPage.enterToEmailTextBox(emailAddress);
		registerPage.enterToPasswordNameTextBox(passwordValue);
		registerPage.enterToConfirmPasswordNameTextBox(passwordValue);
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessageText(), "Your registration completed");
		registerPage.clickToNopcommerceLogo();

		homePage = new HomePageObject(driver);
		homePage.clickToMyLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		homePage.clickToMyAccountLink();

		customerPage = new CustomerPageObject(driver);

	}

	@Test(enabled = false)
	public void TC_01_Update_Customer_Info() {
		customerPage.selectGender();
		customerPage.enterToFirstNameTextBox("Automation");
		customerPage.enterToLastNameTextBox("FC");
		customerPage.selectDayInDOBDropdown("1");
		customerPage.selectMonthInDOBDropdown("January");
		customerPage.selectYearInDOBDropDown("1999");
		customerPage.enterToEmailTextBox("automationfc.vn@gmail.com");
		customerPage.enterToCompanyNameTextBox("Automation FC");
		customerPage.clickToSaveButton();
		assertEquals(customerPage.getTextSuccessNotification(), "The customer info has been updated successfully.");
		customerPage.checkSelectedFemaleGender();

		Assert.assertEquals(customerPage.getFirstNameAttributeValue(), "Automation");
		Assert.assertEquals(customerPage.getLasttNameAttributeValue(), "FC");
		Assert.assertEquals(customerPage.getSelectedDayOfBirthdayValue(), "1");
		Assert.assertEquals(customerPage.getSelectedMonthOfBirthdayValue(), "January");
		Assert.assertEquals(customerPage.getSelectedYearOfBirthdayValue(), "1999");
		Assert.assertEquals(customerPage.getEmailAddressAttributeValue(), "automationfc.vn@gmail.com");
		Assert.assertEquals(customerPage.getCompanyNameAttributevalue(), "Automation FC");
		Assert.assertTrue(customerPage.checkSelectedFemaleGender());
	}

	@Test
	public void TC_02_Add_Address_Info() {
		customerPage.clickToAddressesLInk();
		customerPage.clickToAddNewButton();
		addressPage = new AddressPageObject(driver);
		addressPage.enterToFirstNameTextBox("Automation");
		addressPage.enterToLastNameTextBox("FC");
		addressPage.enterToEmailTextBox(emailValue);
		addressPage.enterToCompanyTextBox("Automation FC");
		addressPage.selectCountryDropDown("Viet Nam");
		addressPage.selectSateDropDown("Other");
		addressPage.enterToCityTextBox("Da Nang");
		addressPage.enterToAddress1TextBox("123/04 Le Lai");
		addressPage.enterToAdress2TextBox("234/05 Hai Phong");
		addressPage.enterToZipCodeTextBox("550000");
		addressPage.enterToPhoneNumberTextBox("0123456789");
		addressPage.enterToFaxNumberTextBox("0987654321");
		addressPage.clickToSaveButton();

		Assert.assertEquals(addressPage.getNameTextBoxValue(), "Automation FC");
		Assert.assertEquals(addressPage.getEmailTexBoxValue(), "Email: " + emailValue);
		Assert.assertEquals(addressPage.getPhoneNumberTexBoxValue(), "Phone number: 0123456789");
		Assert.assertEquals(addressPage.getCompanyTexBoxValue(), "Automation FC");
		Assert.assertEquals(addressPage.getFaxNumberTexBoxValue(), "Fax number: 0987654321");
		Assert.assertEquals(addressPage.getAddress1TexBoxValue(), "123/04 Le Lai");
		Assert.assertEquals(addressPage.getAddress2TexBoxValue(), "234/05 Hai Phong");
		Assert.assertEquals(addressPage.getCityStateZipValue(), "Da Nang, 550000");
		Assert.assertEquals(addressPage.getCountryTexBoxValue(), "Viet Nam");

	}

	@Test
	public void TC_03_Change_Password() {
		customerPage = new CustomerPageObject(driver);
		customerPage.clickToChangePasswordLink();
		customerPage.enterToOldPasswordTextbox(passwordValue);
		customerPage.enterToNewPasswordTextbox(newPassword);
		customerPage.enterToConfirmPasswordTextbox(newPassword);
		customerPage.clickToChangePasswordButton();
		Assert.assertEquals(customerPage.getPasswordChangedMessage(), "Password was changed");
		customerPage.clickToCloseSucessMessageButton();
		customerPage.waitForSucessBannerDisappear();

		homePage = new HomePageObject(driver);
		homePage.clickToLogOutLink();
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(passwordValue);
		loginPage.clickToLoginButton();
		Assert.assertEquals(loginPage.getErrorMessageForWrongPassword(),
				"Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		
		loginPage.enterToEmailTextbox(emailAddress);
		loginPage.enterToPasswordTextbox(newPassword);
		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);
		Assert.assertFalse(homePage.IsLoginButtonNotDisplayed());

	}

	@Test
	public void Register_04_Invalid_Confirm_Password() {
	}

	@Test
	public void Register_05_Success() {
	}

	@Test
	public void Register_06_Login_Success() {

	}

	@AfterClass
	public void afterClass() {
	}

	public String getEmailRandom() {
		Random rand = new Random();
		return "John" + rand.nextInt(99999) + "@gmail.com";

	}

}
