package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class Practice {

    WebDriver driver;

    public static Practice getPractice() {
        return new Practice();
    }

    public void openPageUrl(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getCurrentUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public Alert waitForAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public void sendkeyToAlert(WebDriver driver, String value) {
        waitForAlertPresence(driver).sendKeys(value);
    }

    public String getTextOfAlert(WebDriver driver, String value) {
        return waitForAlertPresence(driver).getText();

    }

    public By getByLocator(String locator) {
        By by = null;
        if (locator.startsWith("xpath=") || locator.startsWith("XPATH=") || locator.startsWith("Xpath=")) {
            by = By.xpath(locator.substring(6));
        }
        if (locator.startsWith("CSS=")) {
            by = By.xpath(locator.substring(4));
        }


        return by;
    }

    public String getDynamicLocator(String locator, String... restParams) {
        return String.format(locator, (Object) restParams);
    }

    public WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getWebElement(WebDriver driver, String locator, String... restParams) {
        return driver.findElement(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public List<WebElement> getListofWebElement(WebDriver driver, String locator, String... restParams) {
        return driver.findElements(getByLocator(getDynamicLocator(locator, restParams)));
    }

    public void clickToElement(WebDriver driver, String locator) {
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParams) {
        getWebElement(driver, getDynamicLocator(locator, restParams)).click();
    }

    public void sendKeyToElement(WebDriver driver, String locator, String... restParams) {
        getWebElement(driver, locator, restParams).clear();
        getWebElement(driver, getDynamicLocator(locator, restParams)).sendKeys();
    }

    public String getText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();

    }

    public String getText(WebDriver driver, String locator, String value) {
        return getWebElement(driver, locator).getAttribute(value);

    }

    public int getElementsSize(WebDriver driver, String locator, String restParams) {
        return getListofWebElement(driver, locator, restParams).size();

    }

    public void checkToElement(WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    public void uncheckToElement(WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            clickToElement(driver, locator);
        }
    }

    //set wait truoc
    public void setImplicitWait(WebDriver driver, long timeOut) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    //check hien thi

    public boolean isElementDisplayed(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();

    }

    public boolean isElementUndisplayed(String locator) {
        boolean status = false;
        setImplicitWait(driver, 3);
        List<WebElement> elementList = getListofWebElement(driver, locator);
        if (elementList.size() == 1 && !elementList.get(0).isDisplayed()) {
            status = true;
        } else if (elementList.size() > 0) {
            status = true;
        } else {
            return status;
        }
        return status;

    }

    public boolean isElementslected(WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public void watForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void watForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }
    public void waitForElementClickable(WebDriver driver, String locator){
     new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));

    }
    public void selectValueInDefaultDropDown(String locator, String value){
       new Select(getWebElement(driver, locator)).selectByVisibleText(value);
    }

    public String getTextofSelectOptionInDefaultDropDown(String locator){
        return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
    }

    public void getFirstSelectedItem(String locator){
        new Select(getWebElement(driver, locator)).getFirstSelectedOption();
    }

    public void SelectIntemInDefaultDropDown(WebDriver driver, String parentLocator, String childLocator, String expectedValue){
        waitForElementClickable(driver,parentLocator);
        clickToElement(driver,parentLocator);
        waitForElementClickable(driver,childLocator);
        List<WebElement>listElement= getListofWebElement(driver, childLocator);
try {
    for (WebElement element:listElement)
        if (element.getText().trim().equals(expectedValue))
            element.click();

} catch (Exception e) {
    throw new RuntimeException(e);
}

    }


}







