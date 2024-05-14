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


	public void enterToDynamicTextboxById(String valueToSend, String textboxID) {
		waitForElementClickable(driver,  AddressPageUI.DYNAMIC_UPDATE_ADDRESS_PAGE_TEXTBOX, textboxID);
		sendkeyToElement(driver, AddressPageUI.DYNAMIC_UPDATE_ADDRESS_PAGE_TEXTBOX, valueToSend , textboxID);
		
	}
	public String getDynamicTexBoxValueByClass(String textboxClass) {
		waitForElementVisible(driver, AddressPageUI.DYNAMIC_INFORMATION_VALUE_FIELD,textboxClass );
		return getElementText(driver,AddressPageUI.DYNAMIC_INFORMATION_VALUE_FIELD, textboxClass );

	}

	public void selectDynamicDropdownByID(String selectedValue, String dropdownID){
		waitForElementClickable(driver,AddressPageUI.DYNAMIC_DROPDOWN_BY_ID, dropdownID );
		selectItemInDefaultDropdown(driver,AddressPageUI.DYNAMIC_DROPDOWN_BY_ID, selectedValue,dropdownID);
	}


	

}
