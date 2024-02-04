package commons;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePagefactory {
	WebDriver driver;
	
	//Web brower
		public static BasePage getBasePage() {
			return new BasePage();
		}
		
		public void openPageUrl(WebDriver driver, String pageurl) {
			driver.get(pageurl);
		}

		public String getPageTitle(WebDriver driver, String pageTitle) {
			return driver.getTitle();

		}

		public String getCurrentPageUrl(WebDriver driver) {
			return driver.getCurrentUrl();

		}

		public Alert waitForALertPresence(WebDriver driver) {
			return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());

		}

		public String getPageSourceCode(WebDriver driver) {
			return driver.getPageSource();
		}

		public void backToPage(WebDriver driver) {
			driver.navigate().back();
		}

		public void forwardToPage(WebDriver driver) {
			driver.navigate().forward();
		}

		public void refreshCurrentPage(WebDriver driver) {
			driver.navigate().refresh();
		}

		public void acceptToAlert(WebDriver driver) {
			waitForALertPresence(driver).accept();
		}

		public void cancelToAlert(WebDriver driver) {
			waitForALertPresence(driver).dismiss();
		}

		public String getTextInAlert(WebDriver driver) {
			return waitForALertPresence(driver).getText();
		}
		
		public void clickToElement(WebDriver driver, WebElement element) {
			element.click();
		}
		public void sendkeyToElement(WebDriver driver,WebElement element, String valueToSend) {
			element.clear();
			element.sendKeys(valueToSend);

		}

		public String getElementText(WebDriver driver, WebElement element) {
			return element.getText();

		}
		public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
			return element.getAttribute(attributeName);
		}
		
		public void waitForElementVisible(WebDriver driver, WebElement element) {
			new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
		}
		public void waitForElementClickable(WebDriver driver, WebElement element) {
			new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(element));
		}


}
