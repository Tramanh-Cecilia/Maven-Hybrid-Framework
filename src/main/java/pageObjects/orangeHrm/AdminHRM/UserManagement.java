package pageObjects.orangeHrm.AdminHRM;

import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHrm.UserManagementPageUI;

public class UserManagement extends BaseElement {
    private WebDriver driver;

    public UserManagement(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddButton() {
        waitForElementClickable(driver, UserManagementPageUI.ADD_BUTTON);
        clickToElement(driver, UserManagementPageUI.ADD_BUTTON);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, UserManagementPageUI.SAVE_BUTTON);
        clickToElement(driver, UserManagementPageUI.SAVE_BUTTON);
    }

    public void clickToDynamDropdownByDropdownName(String dropdownName) {
        waitForElementClickable(driver, UserManagementPageUI.DYNAMIC_DROPDOWN_BY_DROPDOWN_NAME, dropdownName);
        clickToElement(driver, UserManagementPageUI.DYNAMIC_DROPDOWN_BY_DROPDOWN_NAME, dropdownName);

    }

    public void selectValueInDynamicDropdownByName(String dropdownName, String valueToSelect) {

            clickToDynamDropdownByDropdownName(dropdownName);
            waitForElementClickable(driver, UserManagementPageUI.DYNAMIC_VALUE_TO_SELECT_IN_DROPDOWN_BY_NAME, dropdownName, valueToSelect);
            clickToElement(driver, UserManagementPageUI.DYNAMIC_VALUE_TO_SELECT_IN_DROPDOWN_BY_NAME, dropdownName, valueToSelect);



    }

    public void enterToDynamicTextBoxInUserManagement(String texboxName, String valueToSend) {
        waitForElementClickable(driver, UserManagementPageUI.DYNAMIC_TEXTBOX_BY_TEXTBOX_NAME, texboxName);
        sendkeyToElement(driver, UserManagementPageUI.DYNAMIC_TEXTBOX_BY_TEXTBOX_NAME, valueToSend, texboxName);
    }

    public void enterToEmployeeTextbox(String keyTosearch) {
        enterToDynamicTextBoxInUserManagement("Employee Name", keyTosearch);

            waitForElementClickable(driver, UserManagementPageUI.AUTO_COMPLETE_OPTION_FOR_EMPLOYEENAME_TEXTBOX);
            clickToElement(driver, UserManagementPageUI.AUTO_COMPLETE_OPTION_FOR_EMPLOYEENAME_TEXTBOX);



    }

    public String getSuccessMessage() {
        waitForElementVisible(driver, UserManagementPageUI.SUCCESS_MESSAGE);
        return getElementText(driver, UserManagementPageUI.SUCCESS_MESSAGE);
    }

    public boolean isLoadingSpinnerUndisplayed() {
        return isElementUnDisplayed(driver, UserManagementPageUI.LOADING_SPINNER_ICON);
    }

    public void enterToDynamicSearchTextBox(String valueToSearch, String textboxName) {
        waitForElementClickable(driver, UserManagementPageUI.SEARCH_TEXTBOX_BY_TEXTBOX_NAME, textboxName);
        sleepInSecond(2);
        sendkeyToElement(driver, UserManagementPageUI.SEARCH_TEXTBOX_BY_TEXTBOX_NAME, valueToSearch, textboxName);
        sleepInSecond(2);
    }

    public String getRowIndexByUserName(String username) {

            int indexRow = getListElementSize(driver, UserManagementPageUI.INDEX_ROW_BY_DYNAMIC_USER_NAME, username) + 1;
            return String.valueOf(indexRow);


    }


    public String getTextinDynamicCellByUserName(String username, String columnName) {

            int indexRow = getListElementSize(driver, UserManagementPageUI.INDEX_ROW_BY_DYNAMIC_USER_NAME, username) + 1;
            int indexColumn = getListElementSize(driver, UserManagementPageUI.INDEX_COLUMN_BY_DYNAMIC_COLUMN_NAME, columnName) + 1;
            return getElementText(driver, UserManagementPageUI.DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(indexRow), String.valueOf(indexColumn));


    }

    public void deleteOrEditUsernameByDynamicActionAndUserName(String username, String action) {

        int indexRow = getListElementSize(driver, UserManagementPageUI.INDEX_ROW_BY_DYNAMIC_USER_NAME, username) + 1;
        switch (action.toLowerCase()) {
            case "delete":
                clickToElement(driver, UserManagementPageUI.DELETE_USER_BUTTON_BY_USER_NAME, String.valueOf(indexRow), username);
                break;
            case "edit":
                clickToElement(driver, UserManagementPageUI.EDIT_BUTTON_BY_USER_NAME, String.valueOf(indexRow), username);
                break;
        }
    }


    public boolean cancelOrConfirmDeleteUserNameByAction(String action){


            switch (action.toLowerCase()){
                case "cancel":
                waitForElementClickable(driver, UserManagementPageUI.CANCEL_DELETE_USERNAME_BUTTON);
                clickToElement(driver, UserManagementPageUI.CANCEL_DELETE_USERNAME_BUTTON);
                return true;
                case "delete":
                    waitForElementClickable(driver, UserManagementPageUI.CONFIRM_DELETE_USERNAME_BUTTON);
                    clickToElement(driver, UserManagementPageUI.CONFIRM_DELETE_USERNAME_BUTTON);
                    return true;
            }


        return false;
    }

    public String getNoRecordTextAfterSearchButton(){
        waitForElementClickable(driver, UserManagementPageUI.NO_RECORD_FOUND_TEXT);
        return getElementText(driver, UserManagementPageUI.NO_RECORD_FOUND_TEXT);
    }



}
