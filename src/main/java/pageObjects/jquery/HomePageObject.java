package pageObjects.jquery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jquery.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToColumnTextBoxByName(String columnName, String valueToSend) {
		waitForElementVisible(driver, HomePageUI.COLUMN_TEXTBOX_BYNAME, columnName);
		sendkeyToElement(driver, HomePageUI.COLUMN_TEXTBOX_BYNAME, valueToSend, columnName);
	}

	public void clickToPagingByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGE_LINK_BY_NUMBER, pageNumber);
	}

	public boolean isPageActiveByNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}

	public boolean isRowValueDisplaye(String female, String country, String male, String total) {
		waitForElementClickable(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
		return isElementDisplayed(driver, HomePageUI.DYNAMIC_ROW_VALUE, female, country, male, total);
	}

	public void clickToRowAction(String countryName, String action) {
		waitForElementClickable(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, countryName, action);
		clickToElement(driver, HomePageUI.ROW_ACTION_BY_COUNTRY_NAME, countryName, action);

	}

	public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToSend) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		System.out.println(columnIndex);
		sendkeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_ROW_INDEX_AND_COLUMN_INDEX, valueToSend, rowIndex,
				String.valueOf(columnIndex));
	}

	public void selectDropDownByColumnNameAndRowIndex(String columnName, String rowIndex, String dropdownItem) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,
				String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, dropdownItem,
				rowIndex, String.valueOf(columnIndex));
	}

	public void clickToCheckBoxByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,
				String.valueOf(columnIndex));
		clickToElement(driver, HomePageUI.DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,
				String.valueOf(columnIndex));
	}

	public String getTextOfCellByColumnNameAndRowIndex(String columnName, String rowIndex) {
		int columnIndex = getListElementSize(driver, HomePageUI.COLUMN_INDEX_BY_ADMIN_COLUMN_NAME, columnName) + 1;
		return getElementText(driver, HomePageUI.DYNAMIC_ADMIN_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, rowIndex,
				String.valueOf(columnIndex));

	}

}
