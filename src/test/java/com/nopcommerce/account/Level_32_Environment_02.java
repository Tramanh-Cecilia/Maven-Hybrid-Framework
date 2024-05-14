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

public class Level_32_Environment_02 extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;
	private EnvironmentConfig environmentConfig;


	@Parameters({"browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		ConfigFactory.setProperty("serverName",serverName);
		environmentConfig= ConfigFactory.create(EnvironmentConfig.class);

		driver = getBrowserDrivers(browserName,environmentConfig.appUrl() );


		System.out.println(environmentConfig.appUrl());

	}

	@Test
	public void Register_01_Check_Error_Message() {

	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
