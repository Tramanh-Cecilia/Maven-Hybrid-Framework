package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CustomerPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.OrderPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointPageObject;
import pageObjects.admin.AdminDashboardPageObject;
import pageObjects.admin.AdminLoginPageObject;

public class PageGeneratorManager {
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static  RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	public static  LoginPageObject getUserLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static  CustomerPageObject getCustomerPage(WebDriver driver) {
		return new CustomerPageObject(driver);
	}
	public static AddressPageObject getAddressPage(WebDriver driver) {
		return new AddressPageObject(driver);
	}
	
	public static OrderPageObject  getOrderPage(WebDriver driver) {
		return new OrderPageObject (driver);
	}
	public static RewardPointPageObject  getRewardPointPage(WebDriver driver) {
		return new RewardPointPageObject(driver);
	}
	public static AdminLoginPageObject  getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObject  getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static ChangePasswordPageObject  getchangePasswordPageObject (WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	
}
