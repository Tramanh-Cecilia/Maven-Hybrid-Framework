package com.jquery.table;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jquery.HomePageObject;
import pageObjects.jquery.PageGeneratorManager;
import pageObjects.jquery.UploadPageObject;
import pageUIs.jquery.UploadPageUI;

public class Level_14_UploadFile extends BaseTest {

	private WebDriver driver;
	String catImage = "cats.jpg";
	String computerImage = "computer.jpg";
	HomePageObject homePage;
	String[] filenames = { catImage, computerImage };
	UploadPageObject uploadPage;

	@Parameters({ "browser", "Url" })
	@BeforeClass
	public void beforeClass(String browserName, String Url) {
		driver = getBrowserDrivers(browserName, Url);

		uploadPage = PageGeneratorManager.getUploadPage(driver);

	}

	@Test
	public void TC_01_Jquery_Upload_single_File() {
		uploadPage.uploadMultipleFiles(driver, catImage);
		uploadPage.uploadMultipleFiles(driver, computerImage);
		Assert.assertTrue(uploadPage.isFileLoadingSucceed(catImage));
		Assert.assertTrue(uploadPage.isFileLoadingSucceed(computerImage));
		uploadPage.clickToStartButtonForEachFile();

		Assert.assertTrue(uploadPage.isFileAlreadyUploaded(catImage));
		Assert.assertTrue(uploadPage.isFileAlreadyUploaded(computerImage));

	}

	@Test
	public void TC_02_Upload_Multiple_file() {
		uploadPage.refreshCurrentPage(driver);
		uploadPage.uploadMultipleFiles(driver, filenames);
		Assert.assertTrue(uploadPage.isFileLoadingSucceed(catImage));
		Assert.assertTrue(uploadPage.isFileLoadingSucceed(computerImage));
		uploadPage.clickToStartButtonForEachFile();

		Assert.assertTrue(uploadPage.isFileAlreadyUploaded(catImage));
		Assert.assertTrue(uploadPage.isFileAlreadyUploaded(computerImage));
	}

	@Test
	public void TC_03_gofile() {
		uploadPage.openPageUrl(driver, "https://gofile.io/uploadFiles");
		Assert.assertFalse(uploadPage.isLoadingIconDisappear(driver, UploadPageUI.SPINNER_ICON_AT_MAIN_PAGE));
		uploadPage.uploadMultipleFilesWithDynamicLocator(driver, UploadPageUI.FILE_UPLOADED_BUTTON, filenames);
		Assert.assertFalse(uploadPage.isLoadingIconDisappear(driver, UploadPageUI.SPINNER_ICON_AFTER_UPLOAD));
		Assert.assertTrue(uploadPage.isMultipleProgressbarDisappear());
		Assert.assertTrue(uploadPage.isSuccessMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
	}

}
