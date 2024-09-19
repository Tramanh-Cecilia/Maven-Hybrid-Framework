package pageObjects.admin;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends AdminSideBarPageObject {
	WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
	}

	public AdminLoginPageObject clickToAdminLogoutLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.LOG_OUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOG_OUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

}
