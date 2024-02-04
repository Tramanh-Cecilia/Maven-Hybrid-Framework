package pageObjects.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public AdminLoginPageObject clickToAdminLogoutLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.LOG_OUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

}
