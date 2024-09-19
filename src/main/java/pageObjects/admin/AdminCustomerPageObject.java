package pageObjects.admin;

import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminCustomerPageUI;
import pojoTestData.UserInfo;

public class AdminCustomerPageObject extends AdminSideBarPageObject {
    private WebDriver driver;

    public AdminCustomerPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;

    }

    public void clickToAddNewCustomerButton() {
        waitForElementClickable(driver, AdminCustomerPageUI.CREATE_NEW_BUTTON);
        clickToElementByJS(driver, AdminCustomerPageUI.CREATE_NEW_BUTTON);
    }

    public void enterToCreateCustomerForm(UserInfo userInfo, String gender, String newsletterOption, String customerRoleOption, String managerOfVendorOption, String adminComment
    ) {
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME,userInfo.getEmailAddress(), "Email");
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME, userInfo.getPassword(), "Password");
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME, userInfo.getFirstName(), "First name");
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME, userInfo.getLastName(), "Last name");
        checkToElement(driver, AdminCustomerPageUI.DYNAMIC_GENDER_RADIO_BUTTON_BY_GENDER, gender);
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME, userInfo.getDOB(), "Date of birth");
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME, userInfo.getCompanyName(), "Company name");
        checkToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME,"Is tax exempt");
        selectItemAutofield("Newsletter", newsletterOption);
        selectItemAutofield("Customer roles", customerRoleOption);
        selectItemInDefaultDropdown(driver, AdminCustomerPageUI.MANAGER_VENDOR_ID_DROPDOWN_LIST, managerOfVendorOption);
        sendkeyToElement(driver, AdminCustomerPageUI.ADMIN_COMMENT_TEXT_AREA,  adminComment);

    }

    public void selectItemAutofield(String textboxField, String optionValue){
        if (isElementUnDisplayed(driver, AdminCustomerPageUI.SELECTED_OPTION_IN_AUTOFIELD_SEARCHBOX_BY_DYNAMIC_TEXT,textboxField)) {
            clickToElement(driver, AdminCustomerPageUI.SELECTED_OPTION_IN_AUTOFIELD_SEARCHBOX_BY_DYNAMIC_TEXT, textboxField);
        } else {
            clickToElement(driver, AdminCustomerPageUI.DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME, textboxField);

        }
        waitForElementClickable(driver, AdminCustomerPageUI.DYNAMIC_OPTION_IN_AUTOFIELD_BY_TEXT,  optionValue);
        clickToElement(driver, AdminCustomerPageUI.DYNAMIC_OPTION_IN_AUTOFIELD_BY_TEXT,  optionValue);

    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, AdminCustomerPageUI.SAVE_BUTTON);
        clickToElementByJS(driver, AdminCustomerPageUI.SAVE_BUTTON);
    }
    public String getAlertSuccessMessage(){
        waitForElementVisible(driver, AdminCustomerPageUI.ALERT_SUCCESS_MASSAGE);
        return getElementText(driver, AdminCustomerPageUI.ALERT_SUCCESS_MASSAGE);
    }

    public void SelectGuestOptionInCustomerRoleSearchBox(){
        if (isElementUnDisplayed(driver, AdminCustomerPageUI.SELECTED_OPTION_IN_CUSTOMER_ROLE_FIELD_SEARCHBOX)) {

            clickToElement(driver, AdminCustomerPageUI.SELECTED_OPTION_IN_CUSTOMER_ROLE_FIELD_SEARCHBOX);
        } else {
            waitForElementClickable(driver, AdminCustomerPageUI.CUSTOMER_ROLE_FIELD_SEARCHBOX);
            clickToElement(driver, AdminCustomerPageUI.CUSTOMER_ROLE_FIELD_SEARCHBOX);
        }
        waitForElementClickable(driver, AdminCustomerPageUI. CUSTOMER_ROLE_OPTION_DROPDOWN, "Guests");
        clickToElement(driver, AdminCustomerPageUI. CUSTOMER_ROLE_OPTION_DROPDOWN, "Guests");
    }

    public void enterToDynamicSearchTextBoxById(String textboxId, String valueToSend){
        waitForElementClickable(driver, AdminCustomerPageUI.DYNAMIC_SEARCH_TEXTBOX_BY_ID, textboxId);
        sendkeyToElement(driver, AdminCustomerPageUI.DYNAMIC_SEARCH_TEXTBOX_BY_ID,valueToSend, textboxId);
    }

    public void clickToSearchButton(){
        waitForElementClickable(driver, AdminCustomerPageUI.SEARCH_CUSTOMER_BUTTON);
        clickToElement(driver, AdminCustomerPageUI.SEARCH_CUSTOMER_BUTTON);
    }

    public void isAjaxButtonUndisplayed(){
        waitForElementInvisible(driver, AdminCustomerPageUI.AJAX_LOADING_ICON);
    }

    public String getTextInDynamicCellBytextInRowAndColumnName(String textValue, String columnName){
        int rowIndex= getListElementSize(driver, AdminCustomerPageUI.DYNAMIC_ROW_INDEX_BY_TEXT_IN_COLUMN,textValue)+ 1;
        int columnIndex= getListElementSize(driver, AdminCustomerPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName)+ 1;
       return getElementText(driver, AdminCustomerPageUI.DYNAMIC_CELL_BY_DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX, String.valueOf(rowIndex), String.valueOf(columnIndex));

    }
}
