package commons;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;
import pageUIs.user.BaseElementUI;


public class BasePage {
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
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout)).until(ExpectedConditions.alertIsPresent());

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

	public void sendKeyToAlert(WebDriver driver, String keysToSend) {
		waitForALertPresence(driver).sendKeys(keysToSend);
	}

	public void switchToWindowByID(WebDriver driver, String pageID) {
		Set<String> allIds = driver.getWindowHandles();

		for (String id : allIds) {
			if (!id.equals(allIds)) {
				driver.switchTo().window(id);
				break;

			}
		}
	}

	public void switchToWindowByTitile(WebDriver driver, String pageTitle) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			driver.switchTo().window(id);
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(pageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowWithoutParentID(WebDriver driver, String parentID) {
		Set<String> allIDs = driver.getWindowHandles();

		for (String id : allIDs) {
			if (!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();

			}
		}
		driver.switchTo().window(parentID);
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public Set<Cookie> getBrowserCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}

	public void setCookies(WebDriver driver, Cookie cookie) {
		driver.manage().addCookie(cookie);
	}

// webElelemt
	public By getByLocator(String locatorValue) {
		By by= null;
		if (locatorValue.startsWith("xpath=")|| locatorValue.startsWith("XPath=")|| locatorValue.startsWith("XPATH=")||locatorValue.startsWith("Xpath=")) {
			by =By.xpath(locatorValue.substring(6));
		} else if (locatorValue.startsWith("css=")|| locatorValue.startsWith("CSS=")||locatorValue.startsWith("Css=")) {
			by =By.cssSelector(locatorValue.substring(4));
		} else if (locatorValue.startsWith("name=")|| locatorValue.startsWith("NAME=")||locatorValue.startsWith("Name=")) {
			by =By.name(locatorValue.substring(5));
		}else if (locatorValue.startsWith("id=")|| locatorValue.startsWith("ID=")||locatorValue.startsWith("Id=")) {
			by =By.id(locatorValue.substring(3));
		}else if (locatorValue.startsWith("class=")|| locatorValue.startsWith("CLASS=")||locatorValue.startsWith("Class=")) {
			by =By.className(locatorValue.substring(6));
		}else if (locatorValue.startsWith("tagname=")|| locatorValue.startsWith("TAGNAME=")||locatorValue.startsWith("Tagname=")) {
			by =By.tagName(locatorValue.substring(8));
		} else {
			throw new RuntimeException("Locator Type is not valid");
		}
				
		return by;
		
	}
	
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public String getDynamicLocator(String locator, String...restParams) {
		return String.format(locator,(Object[]) restParams);
		
	}
	
	public WebElement getWebElement(WebDriver driver, String locator) {
		return driver.findElement(getByLocator(locator));
	}
	public WebElement getWebElement(WebDriver driver, String locator,String...restParams) {
		return driver.findElement(getByLocator(locator ));
	}

	public List<WebElement> getListWebElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		getWebElement(driver, locator).click();
	}
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}
	
	public void clickToElement(WebDriver driver, String locator, String...restParams) {
		getWebElement(driver, getDynamicLocator(locator, restParams)).click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend) {
		getWebElement(driver, locator).clear();
		getWebElement(driver, locator).sendKeys(valueToSend);

	}
	public void sendkeyToElement(WebDriver driver, String locator, String valueToSend, String...restParams) {
		getWebElement(driver, getDynamicLocator(locator, restParams)).clear();
		getWebElement(driver, getDynamicLocator(locator, restParams)).sendKeys(valueToSend);

	}

	public String getElementText(WebDriver driver, String locator) {
		return getWebElement(driver, locator).getText();

	}
	
	public String getElementText(WebDriver driver, String locator, String...restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).getText();

	}

	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
		new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
	}
	public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue,String...restParams) {
		new Select(getWebElement(driver, getDynamicLocator(locator, restParams))).selectByVisibleText(itemValue);
	}


	public String selectFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
	}
	public String selectFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator,String...restParams) {
		return new Select(getWebElement(driver, getDynamicLocator(locator, restParams))).getFirstSelectedOption().getText();
	}

	public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
		return new Select(getWebElement(driver, locator)).isMultiple();
	}

	public void selectedItemInDropdown(WebDriver driver, String parentlocator, String childxpath,
			String expectedTextItem) {
		clickToElement(driver, parentlocator);
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childxpath)));

		List<WebElement> listItems = driver.findElements(By.xpath(childxpath));

		for (WebElement tempItem : listItems) {
			if (tempItem.getText().trim().equals(expectedTextItem)) {
				tempItem.click();
				break;

			}
		}

	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		return getWebElement(driver, locator).getAttribute(attributeName);
	}
	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String...restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).getAttribute(attributeName);
	}

	public String getElementCssValue(WebDriver driver, String locator, String propertyName) {
		return getWebElement(driver, locator).getCssValue(propertyName);
	}

	public String convertRGBAToHexaColor(WebDriver driver, String locator) {
		return Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
	}

	public int getListElementSize(WebDriver driver, String locator) {
		return getListWebElement(driver, locator).size();
	}
	
	public int getListElementSize(WebDriver driver, String locator, String restParams) {
		return getListWebElement(driver, getDynamicLocator(locator, restParams)).size();
	}

	/**
	 * Apply for checkbox and radio Button
	 * 
	 * @param Driver
	 * @param locator
	 */
	public void checkToElement(WebDriver driver, String locator) {
		if (!getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}
	

	/**
	 * Only apply for checkbox
	 * 
	 * @param Driver
	 * @param locator
	 */
	public void uncheckToElement(WebDriver driver, String locator) {
		if (getWebElement(driver, locator).isSelected()) {
			getWebElement(driver, locator).click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	public boolean isElementDisplayed(WebDriver driver,String locator,String...restParams) {
		return getWebElement(driver, getDynamicLocator(locator, restParams)).isDisplayed();
	}
	public void setImplicitWait (WebDriver driver, long timeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
	}
	
	public boolean isElementUnDisplayed(WebDriver driver, String locator) {
		boolean status= false;
		setImplicitWait(driver, shortTimeout);
		List<WebElement> elements= getListWebElement(driver, locator);
		setImplicitWait(driver,longTimeout);
		if (elements.size()==1 && !elements.get(0).isDisplayed())
			status = true;
		else if (elements.size()> 0) {
			status = true;
		} else {
			return status ;
		}
		return status;
		
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getWebElement(driver, locator).isEnabled();
	}

	public void switchToIframe(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
	}

	public void switchToDefaultContent(WebDriver driver, String locator) {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
		;
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
		;
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
		;
	}

	public void dragAndDropClickToElement(WebDriver driver, String sourceLocator, String targetLocator) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator))
				.perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();

	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		return ((JavascriptExecutor) driver).executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		String textActual = (String) ((JavascriptExecutor) driver)
				.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(WebDriver driver, String locator) {
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				"border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element,
				originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElementOnTop(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				getWebElement(driver, locator));
	}

	public void scrollToElementOnDown(WebDriver driver, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);",
				getWebElement(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')",
				getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');",
				getWebElement(driver, locator));
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;",
				getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locator));
		return status;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	public void waitForElementVisible(WebDriver driver, String locator, String...restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicLocator(locator, restParams))));
	}


	public void waitForListElementVisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	public Boolean waitForListElementInvisible(WebDriver driver, String locator) {
		return new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver,locator)));
	}
	public void waitForElementInvisible(WebDriver driver, WebElement locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.invisibilityOf(locator));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
		.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String...restParams) {
		new WebDriverWait(driver, Duration.ofSeconds(longTimeout))
				.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicLocator(locator, restParams))));
	}

	public boolean isPageLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) jsExecutor.executeScript("return(window.jQuery != null) && (jQuery.active === 0);");

			}
		};
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");

			}
		};
		return explicitWait.until(jQueryLoad) && explicitWait.until((jsLoad));
	}
	
	public void uploadMultipleFiles(WebDriver driver, String...fileNames) {
		String filePath= GlobalConstants.UPLOAD_PATH;
		String fullFileName="";
		for(String file: fileNames){
			fullFileName= fullFileName+ filePath+ file+ "\n";
		}
		fullFileName=fullFileName.trim();
		getWebElement(driver,BaseElementUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
		
	}
	public void uploadMultipleFilesWithDynamicLocator(WebDriver driver,String UploadButton, String...fileNames) {
		String filePath= GlobalConstants.UPLOAD_PATH;
		String fullFileName="";
		for(String file: fileNames){
			fullFileName= fullFileName+ filePath+ file+ "\n";
		}
		fullFileName=fullFileName.trim();
		getWebElement(driver,UploadButton).sendKeys(fullFileName);
		
	}
	
	
	private long longTimeout=GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout=GlobalConstants.SHORT_TIMEOUT;



}

//WebElement 
