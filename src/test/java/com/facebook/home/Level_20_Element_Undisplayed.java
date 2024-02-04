package com.facebook.home;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;


public class Level_20_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	HomePageObject homePage;
	private String emailAddress = getEmailRandom();
	Random rand;


	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String url) {
		driver = getBrowserDrivers(browserName, url);

		homePage = PageGeneratorManager.getHomePage(driver);
		
	}

	@Test
	public void TC_01_Element_Displayed() {
		
		log.info("User 01 _ click to register Button");
		homePage.clickToCreateAccountButton();
		
		verifyTrue(homePage.IsFirstNameTextboxDisplayed());
		verifyTrue(homePage.IsSurNameTextboxDisplayed());
		verifyTrue(homePage.IsEmailTextboxDisplayed());
		verifyTrue(homePage.IsPasswordTextboxDisplayed());
		homePage.enterToEmailTextbox("123@gmail.com");
		log.info("TC 01 _Verify confirm Email Textbox displays");
		verifyTrue(homePage.IsConfirmEmailtextboxDisplayed());

	}
	@Test
	public void TC_02_Element_Undisplayed_In_HTML() {
		
		log.info("Start TC 02");
		log.info("TC 02 _ Step 2_Enter to Email Textbox with empty Value ");
		homePage.enterToEmailTextbox("");
		homePage.sleepInSecond(3);
		log.info("TC 02 _ Step 2_Verify confirm Email Textbox is not displaysed");
		verifyTrue(homePage.IsConfirmEmailtextboxUnDisplayed());
		
	}
	
	@Test
	public void TC_03_Element_undisplayed_Not_In_HTML() {
		
		log.info("Start TC 03");
		homePage.clickToCloseSignInPopUp();
		log.info("TC 03_Step 1 _Verify FN textbox is not displayed after closing Popup ");
		verifyFalse(homePage.IsFirstNameTextboxUnDisplayed());
		
		log.info("TC 03 Step 2 _Verify Surname textbox is not displayed after closing Popup ");
		verifyFalse(homePage.IsSurNameTextboxUnDisplayed());
		
		log.info("TC 03_Step 3 _Verify Email textbox is not displayed after closing Popup ");
		verifyFalse(homePage.IsEmailTextboxUnDisplayed());
		
		log.info("TC 03_Step 4 _Verify Password Password is not displayed after closing Popup ");
		verifyFalse(homePage.IsPasswordTextboxUnDisplayed());
	}

	

	@AfterClass
	public void afterClass() {
	driver.quit();
	}

}
