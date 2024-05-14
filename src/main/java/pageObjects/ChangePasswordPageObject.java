package pageObjects;

import org.openqa.selenium.WebDriver;
import pageUIs.ChangePasswordPageUI;

public class ChangePasswordPageObject extends MyAccountSideBarPageObject{
	WebDriver driver;
	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToDynamicTextBoxInChangingPassWord(String valueToSend, String textboxId) {
		waitForElementClickable(driver, ChangePasswordPageUI.DYNAMIC_TEXTBOX_CHANGE_PASSWORD_BY_ID, textboxId);
		sendkeyToElement(driver,  ChangePasswordPageUI.DYNAMIC_TEXTBOX_CHANGE_PASSWORD_BY_ID, valueToSend, textboxId);
	}


    public void enterIntoChangePasswordform(String password, String newPassword) {
		enterToDynamicTextBoxInChangingPassWord(password,"OldPassword");
		enterToDynamicTextBoxInChangingPassWord( newPassword,"NewPassword");
		enterToDynamicTextBoxInChangingPassWord( newPassword,"ConfirmNewPassword");
    }

	public void clickToChangePasswordButton(){
		waitForElementClickable(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, ChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}
}
