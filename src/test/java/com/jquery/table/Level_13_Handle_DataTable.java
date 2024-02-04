package com.jquery.table;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageUIs.user.HomePageUI;



public class Level_13_Handle_DataTable extends BaseTest {

	private WebDriver driver;
	private String emailAddress = getEmailRandom();
	private String nameRandom = getNameRandom();
	Random rand;
	HomePageObject homePage;

	@Parameters({"browser","Url"})
	@BeforeClass
	public void beforeClass(String browserName, String Url) {
		driver = getBrowserDrivers(browserName, Url);
		
		homePage= PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Search() {
		//Search Header 
		homePage.inputToColumnTextBoxByName("Females", "777");
		homePage.inputToColumnTextBoxByName("Country", "Algeria");


	}

	@Test
	public void TC_02_Paging() {
		homePage.clickToPagingByNumber("10");
		Assert.assertTrue(homePage.isPageActiveByNumber("10"));
		homePage.clickToPagingByNumber("1");
		Assert.assertTrue(homePage.isPageActiveByNumber("1"));
	}

	@Test
	public void TC_03_Displayed() {
		//verify any row
		Assert.assertTrue(homePage.isRowValueDisplaye("384187", "Afghanistan", "407124","791312"));

	}
	@Test
	public void TC_04_Icon_Button_Checkbox() {
		homePage.clickToRowAction("Afghanistan", "edit");
		homePage.refreshCurrentPage(driver);
		

	}
	
	@Test
	public void TC_05_action_By_Index() {
		homePage.openPageUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
		// nhap vao cot contact person dong thu 2
		homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person", "2", "Oliver");

		// select du lieu tai cot country dong thu
		homePage.selectDropDownByColumnNameAndRowIndex("Country","3", "United Kingdom");
		// click vao checkbox NPO dong thu 1
		homePage.clickToCheckBoxByColumnNameAndRowIndex("NPO?","1");

	}

	@Test
	public void TC_06_Live_tech_Panda() {
		homePage.openPageUrl(driver, "http://live.techpanda.org/");
	// create an account
		homePage.clickToElement(driver, pageUIs.jquery.HomePageUI.ACCOUNT_LINK);
		homePage.clickToElement(driver, pageUIs.jquery.HomePageUI.REGISTER_LINK_IN_HEADER );
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.FIRSTNAME_TEXTBOX, nameRandom);
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.LASTNAME_TEXTBOX, "Hill");
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.PASSWORD_TEXTBOX, "ABC!712");
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.CONFIRM_PASSWORD_TEXTBOX, "ABC!712");
		homePage.clickToElement(driver, pageUIs.jquery.HomePageUI.REGISTER_BUTTON );
		homePage.isElementDisplayed(driver, pageUIs.jquery.HomePageUI.SUCCESS_REGISTER_MESSAGE);
		
		homePage.openPageUrl(driver, "http://live.techpanda.org/index.php/backendlogin");
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.USERNAME_TEXTBOX_ADMIN, "User01");
		homePage.sendkeyToElement(driver, pageUIs.jquery.HomePageUI.PASSWORD_TEXTBOX_ADMIN, "guru99com");
		homePage.clickToElement(driver, pageUIs.jquery.HomePageUI.LOGIN_BUTTON_ADMIN);
	
		if (homePage.isElementDisplayed(driver, pageUIs.jquery.HomePageUI.INCOMING_MESSAGE_POPUP)==true) {
			homePage.clickToElement(driver, pageUIs.jquery.HomePageUI.CLOSE_BUTTON_OF_INCOMING_MESSAGE_POPUP);
		}
		
		String emailText= homePage.getTextOfCellByColumnNameAndRowIndex("Email", "1");
		String nameText= homePage.getTextOfCellByColumnNameAndRowIndex("Name", "1");
		Assert.assertEquals(emailText, emailAddress);
		Assert.assertEquals(nameText, nameRandom+" Hill");
	
		
		
	}
	@Test
	public void TC_07_Gofile() {
		
	}
	@AfterClass
	public void afterClass() {
	}
	
	public String getEmailRandom() {
		Random rand = new Random();
		return "John" + rand.nextInt(99999) + "@gmail.com";

	}
	public String getNameRandom() {
		Random rand = new Random();
		return "David" + rand.nextInt(999) ;

	}

}
