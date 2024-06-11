package pageObjects;

import org.openqa.selenium.WebDriver;

import pageUIs.user.CustomerPageUI;
import pojoTestData.jsonData.JsonDataNopCommerce;

public class CustomerPageObject extends MyAccountSideBarPageObject {
	WebDriver driver;

	public CustomerPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;

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

	public String getAttributeValueOfDynamicTextbox(String textboxID) {
		waitForElementVisible(driver, CustomerPageUI.DYNAMIC_TEXTBOX_BY_ID_ACCOUNT_PAGE, textboxID);
		return getElementAttribute(driver, CustomerPageUI.DYNAMIC_TEXTBOX_BY_ID_ACCOUNT_PAGE, "value", textboxID);

	}

	public void selectFemaleGender() {
		waitForElementVisible(driver, CustomerPageUI.FEMALE_RADIO_BUTTON);
		checkToElement(driver, CustomerPageUI.FEMALE_RADIO_BUTTON);

	}

	public void selectDynamicGender(String genderValue) {
		waitForElementVisible(driver, CustomerPageUI.DYNAMIC_RADIO_BUTTON,genderValue );
		checkToElement(driver, CustomerPageUI.DYNAMIC_RADIO_BUTTON, genderValue);

	}

	public void enterToDynamicTextBoxByIDInAccountPage(String valueToSend, String textboxID) {
		waitForElementVisible(driver, CustomerPageUI.DYNAMIC_TEXTBOX_BY_ID_ACCOUNT_PAGE, textboxID);
		sendkeyToElement(driver, CustomerPageUI.DYNAMIC_TEXTBOX_BY_ID_ACCOUNT_PAGE, valueToSend, textboxID);

	}

	
	
	public void selectDynamicValueInDOBDropDownInAccountPageByName(String selectedValue, String dropdownName ) {
		waitForElementVisible(driver, CustomerPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, CustomerPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, selectedValue, dropdownName );
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

	public boolean checkDynamicGenderRadioButtonSelected(String genderValue) {
		waitForElementVisible(driver, CustomerPageUI.DYNAMIC_RADIO_BUTTON, genderValue);
		return isElementSelected(driver, CustomerPageUI.DYNAMIC_RADIO_BUTTON, genderValue);

	}

	public String getCompanyNameAttributevalue() {
		waitForElementVisible(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerPageUI.COMPANY_NAME_TEXTBOX, "value");

	}


	
	public String getDynamicBirthdayValue(String dropdownName) {
		waitForElementClickable(driver, CustomerPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, dropdownName);
		return selectFirstSelectedTextInDefaultDropdown(driver, CustomerPageUI.DYNAMIC_DOB_DROPDOWN_BY_NAME, dropdownName);

	}
	public void clickToDynamicLinkOnSideBar(String linkName) {
		waitForElementClickable(driver, CustomerPageUI.DYNAMIC_LINK_SIDE_BAR_ACCOUNT_PAGE,linkName);
		clickToElement(driver, CustomerPageUI.DYNAMIC_LINK_SIDE_BAR_ACCOUNT_PAGE,linkName);

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
		waitForElementVisible(driver, CustomerPageUI.PASSWORD_CHANGE_SUCCESS_MESS);
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

	public void setToCustomerInforForm(JsonDataNopCommerce customerData) {
	enterToDynamicTextBoxByIDInAccountPage(customerData.getFirstName(),"FirstName");
	enterToDynamicTextBoxByIDInAccountPage(customerData.getLastName(),
			"LastName");
	enterToDynamicTextBoxByIDInAccountPage(customerData.getEmail(),"Email");
	enterToDynamicTextBoxByIDInAccountPage(customerData.getCompanyName(),"Company");
	selectDynamicValueInDOBDropDownInAccountPageByName(customerData.getDayOfDOB(),"DateOfBirthDay");
	selectDynamicValueInDOBDropDownInAccountPageByName(customerData.getMonthOfDOB(),"DateOfBirthMonth");
	selectDynamicValueInDOBDropDownInAccountPageByName(customerData.getYearOfDOB(),"DateOfBirthYear");
	}



}
