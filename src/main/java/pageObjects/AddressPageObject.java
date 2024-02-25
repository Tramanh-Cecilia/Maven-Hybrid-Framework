package pageObjects;

import org.openqa.selenium.WebDriver;

import pageUIs.user.AddressPageUI;

public class AddressPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickToAddNewButton() {
		waitForElementClickable(driver, AddressPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressPageUI.ADD_NEW_BUTTON);

	}



	public void clickToSaveButton() {
		waitForElementClickable(driver,  AddressPageUI.SAVE_ADDRESS_BUTTON);
		clickToElement(driver,  AddressPageUI.SAVE_ADDRESS_BUTTON);
		
	}

	public String getNameTextBoxValue() {
		waitForElementVisible(driver, AddressPageUI.NAME_VALUE_FIELD);
		return getElementText(driver, AddressPageUI.NAME_VALUE_FIELD);
	
	}

	public String getEmailTexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.EMAIL_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.EMAIL_VALUE_FIELD);

	}

	public String getPhoneNumberTexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.PHONE_NUMBER_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.PHONE_NUMBER_VALUE_FIELD);

	}

	public String getCompanyTexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.COMPANY_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.COMPANY_VALUE_FIELD);

	}

	public String getFaxNumberTexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.FAX_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.FAX_VALUE_FIELD);

	}

	public String getAddress1TexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_1_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.ADDRESS_1_VALUE_FIELD);

	}

	public String getAddress2TexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.ADDRESS_2_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.ADDRESS_2_VALUE_FIELD);

	}

	public String getCityStateZipValue() {
		waitForElementVisible(driver, AddressPageUI.CITY_STATE_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.CITY_STATE_VALUE_FIELD);

	}

	public String getCountryTexBoxValue() {
		waitForElementVisible(driver, AddressPageUI.COUNTRY_VALUE_FIELD);
		return getElementText(driver,AddressPageUI.COUNTRY_VALUE_FIELD);

	}

	public void enterToDynamicTextboxById(String valueToSend, String textboxID) {
		waitForElementClickable(driver,  AddressPageUI.DYNAMIC_UPDATE_ADDRESS_PAGE_TEXTBOX, textboxID);
		sendkeyToElement(driver, AddressPageUI.DYNAMIC_UPDATE_ADDRESS_PAGE_TEXTBOX, valueToSend , textboxID);
		
	}
	public String getDynamicTexBoxValueByClass(String textboxClass) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_INFORMATION_VALUE_FIELD,textboxClass );
		return getElementText(driver,AddressPageUI.DYNAMIC_INFORMATION_VALUE_FIELD, textboxClass );

	}


	

}
