package pageObjects.jquery;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jquery.UploadPageUI;

public class UploadPageObject extends BasePage {
	WebDriver driver;

	public UploadPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isFileLoadingSucceed(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickToStartButtonForEachFile() {
		List<WebElement> startButtons = getListWebElement(driver, UploadPageUI.START_BUTTONS);
		for (WebElement button : startButtons) {
			waitForElementClickable(driver, button);
			clickToElement(driver, button);

		}
	}

	public boolean isFileAlreadyUploaded(String fileName) {
		waitForElementVisible(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadPageUI.FILE_UPLOADED_BY_NAME, fileName);
	}

	public void waitForIconInvisible(WebDriver driver, String locator) {
		waitForElementInvisible(driver, UploadPageUI.SPINNER_ICON_AT_MAIN_PAGE);
	}

	public boolean isLoadingIconDisappear(WebDriver driver, String loadingButton) {
		waitForElementInvisible(driver, loadingButton);
		return isElementDisplayed(driver, loadingButton);

	}

	public Boolean isMultipleProgressbarDisappear() {
		return waitForListElementInvisible(driver, UploadPageUI.PROGRESS_BAR_AFTER_UPLOAD);

	}

	public boolean isSuccessMessageDisplayed() {
		waitForElementVisible(driver, UploadPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UploadPageUI.SUCCESS_MESSAGE);
	}
	
	

}
