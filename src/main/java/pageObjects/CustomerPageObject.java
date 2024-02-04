package pageObjects;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerPageUI;

public class CustomerPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver= driver;
		
	}

	public String getFirstNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, "value");
		
	}

	public String getLasttNameAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.LASTNAME_TEXTBOX, "value");
		
	}

	public String getEmailAddressAttributeValue() {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX, "value");
		
	}

	public void selectGender() {
		waitForElementVisible(driver, CustomerPageUI.FEMALE_RADIO_BUTTON);
		checkToElement(driver, CustomerPageUI.FEMALE_RADIO_BUTTON);
		
	}

	public void enterToFirstNameTextBox(String firstNameValue) {
		waitForElementVisible(driver, CustomerPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.FIRSTNAME_TEXTBOX, firstNameValue);
		
	}

	public void enterToLastNameTextBox(String lastNameValue) {
		waitForElementVisible(driver, CustomerPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.LASTNAME_TEXTBOX, lastNameValue);
		
	}

	public void selectDayInDOBDropdown(String selectedDay) {
		waitForElementVisible(driver, CustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN, selectedDay);
	
	}

	public void selectMonthInDOBDropdown(String selectedMonth) {
		waitForElementVisible(driver, CustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN, selectedMonth);
	
	}

	public void selectYearInDOBDropDown(String selectedYear) {
		waitForElementVisible(driver, CustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN);
		selectItemInDefaultDropdown(driver, CustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN, selectedYear);
		}

	public void enterToEmailTextBox(String emailAddress) {
		waitForElementVisible(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
		
	}

	public void enterToCompanyNameTextBox(String companyName) {
		waitForElementVisible(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX, companyName);
		
	}

	public void clickToSaveButton() {
		waitForElementVisible(driver, CustomerPageUI.SAVE_BUTTTON);
		clickToElement(driver, CustomerPageUI.SAVE_BUTTTON);
		
	}

	public String getTextSuccessNotification() {
		waitForElementVisible(driver, CustomerPageUI.UPDATE_SUCCESS_NOTIFICATION);
		return getElementText(driver, CustomerPageUI.UPDATE_SUCCESS_NOTIFICATION);
	
	}

	public boolean checkSelectedFemaleGender() {
		waitForElementVisible(driver, CustomerPageUI.FEMALE_RADIO_BUTTON);
		return isElementSelected(driver, CustomerPageUI.FEMALE_RADIO_BUTTON);
		
	}


	public String getCompanyNameAttributevalue() {
		waitForElementVisible(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX, "value");
		
	}

	public String getSelectedDayOfBirthdayValue() {
		waitForElementClickable(driver, CustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN);
		return selectFirstSelectedTextInDefaultDropdown(driver, CustomerPageUI.DAY_OF_BIRTHDAY_DROPDOWN);
	
	}

	public String getSelectedMonthOfBirthdayValue() {
		waitForElementClickable(driver, CustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN);
		return selectFirstSelectedTextInDefaultDropdown(driver, CustomerPageUI.MONTH_OF_BIRTHDAY_DROPDOWN);
	
	}

	public String getSelectedYearOfBirthdayValue() {
		waitForElementClickable(driver, CustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN);
		return selectFirstSelectedTextInDefaultDropdown(driver, CustomerPageUI.YEAR_OF_BIRTHDAY_DROPDOWN);
	
	}

	public void clickToAddressesLInk() {
		waitForElementClickable(driver, CustomerPageUI.ADDRESSES_LINK);
		clickToElement(driver, CustomerPageUI.ADDRESSES_LINK);
		
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, CustomerPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, CustomerPageUI.ADD_NEW_BUTTON);
		
	}

	public void clickToChangePasswordLink() {
		waitForElementClickable(driver, CustomerPageUI.CHANGE_PASSWORD_LINK);
		clickToElement(driver, CustomerPageUI.CHANGE_PASSWORD_LINK);
		
	}

	public void enterToOldPasswordTextbox(String passwordValue) {
		waitForElementClickable(driver, CustomerPageUI.OLD_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.OLD_PASSWORD_TEXTBOX, passwordValue);
		
	}

	public void enterToNewPasswordTextbox(String newPasswordValue) {
		waitForElementClickable(driver, CustomerPageUI.NEW_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.NEW_PASSWORD_TEXTBOX, newPasswordValue);
		
	}

	public void enterToConfirmPasswordTextbox(String newConfirmPasswordValue) {
		waitForElementClickable(driver, CustomerPageUI.CONFIRM_NEWPASSWORD_TEXTBOX);
		sendkeyToElement(driver, CustomerPageUI.CONFIRM_NEWPASSWORD_TEXTBOX, newConfirmPasswordValue);
		
	}

	public String getPasswordChangedMessage() {
		waitForElementVisible(driver,CustomerPageUI.PASSWORD_CHANGE_SUCCESS_MESS);
		return getElementText(driver, CustomerPageUI.PASSWORD_CHANGE_SUCCESS_MESS);
	
	}

	public void clickToCloseSucessMessageButton() {
		waitForElementVisible(driver, CustomerPageUI.PASSWORD_CHANGE_MESS_CLOSE_BUTTON);
		clickToElement(driver, CustomerPageUI.PASSWORD_CHANGE_MESS_CLOSE_BUTTON);
		
	}

	public void clickToChangePasswordButton() {
		waitForElementVisible(driver, CustomerPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, CustomerPageUI.CHANGE_PASSWORD_BUTTON);
		
	}

	public void waitForSucessBannerDisappear() {
		waitForElementInvisible(driver, CustomerPageUI.PASSWORD_CHANGE_SUCCESS_MESS);
		
	}



}
