package pageObjects;

import org.openqa.selenium.WebDriver;

import pageUIs.user.AddressPageUI;

public class AddressPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public AddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToFirstNameTextBox(String addressFirstName) {
		waitForElementClickable(driver,  AddressPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FIRST_NAME_TEXTBOX, addressFirstName);
		
		
	}

	public void enterToLastNameTextBox(String addressLastName) {
		waitForElementClickable(driver,  AddressPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.LAST_NAME_TEXTBOX, addressLastName);
		
	}

	public void enterToEmailTextBox(String addressEmailValue) {
		waitForElementClickable(driver,  AddressPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.EMAIL_TEXTBOX, addressEmailValue);
		
	}

	public void enterToCompanyTextBox(String addressCompanyValue) {
		waitForElementClickable(driver,  AddressPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.COMPANY_TEXTBOX, addressCompanyValue);
		
	}

	public void selectCountryDropDown(String countryValue) {
		waitForElementClickable(driver, AddressPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropdown(driver, AddressPageUI.COUNTRY_DROPDOWN, countryValue);
		
	}

	public void selectSateDropDown(String stateProvinceValue) {
		waitForElementClickable(driver, AddressPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemInDefaultDropdown(driver, AddressPageUI.STATE_PROVINCE_DROPDOWN, stateProvinceValue);
		
	}

	public void enterToCityTextBox(String addressCityValue) {
		waitForElementClickable(driver,  AddressPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.CITY_TEXTBOX, addressCityValue);
		
	}

	public void enterToAddress1TextBox(String address01Value) {
		waitForElementClickable(driver,  AddressPageUI.ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_1_TEXTBOX, address01Value);
		
	}

	public void enterToAdress2TextBox(String address02Value) {
		waitForElementClickable(driver,  AddressPageUI.ADDRESS_2_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ADDRESS_2_TEXTBOX, address02Value);
		
	}

	public void enterToZipCodeTextBox(String addressZipCodeValue) {
		waitForElementClickable(driver,  AddressPageUI.ZIP_POSTALCODE_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.ZIP_POSTALCODE_TEXTBOX, addressZipCodeValue);
		
	}

	public void enterToPhoneNumberTextBox(String addressPhoneNumberValue) {
		waitForElementClickable(driver,  AddressPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.PHONE_NUMBER_TEXTBOX, addressPhoneNumberValue);
		
	}

	public void enterToFaxNumberTextBox(String addressFaxValue) {
		waitForElementClickable(driver,  AddressPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressPageUI.FAX_NUMBER_TEXTBOX, addressFaxValue);
		
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


	

}
