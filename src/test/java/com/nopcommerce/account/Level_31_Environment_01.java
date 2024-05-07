package com.nopcommerce.account;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class Level_31_Environment_01 extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;



	@Parameters({"browser", "server"})
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {
		driver = getBrowserDriversByServerName( browserName,serverName );


		System.out.println(serverName);

	}

	@Test
	public void Register_01_Check_Error_Message() {

	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
