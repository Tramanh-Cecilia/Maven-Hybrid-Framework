package com.nopcommerce.account;

import commons.BaseTest;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import utilities.EnvironmentConfig;
import utilities.PropertiesConfig;

public class Level_33_Environment_Property_03 extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private PropertiesConfig propertiesConfig;


	@Parameters({"browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		propertiesConfig= PropertiesConfig.getProperties(serverName);

		driver = getBrowserDrivers(browserName,propertiesConfig.getApplicationUrl());


		System.out.println(propertiesConfig.getApplicationUrl());

	}

	@Test
	public void Register_01_Check_Error_Message() {

	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
