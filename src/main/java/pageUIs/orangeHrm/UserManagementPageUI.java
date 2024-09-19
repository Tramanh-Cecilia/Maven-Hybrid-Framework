package pageUIs.orangeHrm;

public class UserManagementPageUI {
    public static final String SAVE_BUTTON ="xpath=//button[@type='submit']" ;
    public static final String ADD_BUTTON ="xpath=//button//i[@class='oxd-icon bi-plus oxd-button-icon']" ;
    public static final String DYNAMIC_DROPDOWN_BY_DROPDOWN_NAME ="xpath=//label[contains(text(), '%s')]//parent::div//following-sibling::div/div" ;
    public static final String DYNAMIC_VALUE_TO_SELECT_IN_DROPDOWN_BY_NAME = "xpath=//label[contains(text(), '%s')]//parent::div//following-sibling::div/div//div//span[text()='%s']";
    public static final String DYNAMIC_TEXTBOX_BY_TEXTBOX_NAME = "xpath=//label[text()='%s']//parent::div//following-sibling::div//input";
    public static final String AUTO_COMPLETE_OPTION_FOR_EMPLOYEENAME_TEXTBOX = "xpath=//div[@class='oxd-autocomplete-option']//span";
    public static final String SUCCESS_MESSAGE = "css=p.oxd-text.oxd-text--p.oxd-text--toast-message.oxd-toast-content-text";
    public static final String LOADING_SPINNER_ICON = "css=div.oxd-loading-spinner";
    public static final String SEARCH_TEXTBOX_BY_TEXTBOX_NAME = "xpath=//label[text()='%s']//parent::div//following-sibling::div//input";
    public static final String SEARCH_DROPDOWN_BY_DROPDOWN_NAME = "xpath=//label[text()='%s']//parent::div//following-sibling::div";

 //table   --
    public static final String INDEX_COLUMN_BY_DYNAMIC_COLUMN_NAME = "xpath=//div[text()='%s']//preceding-sibling::div";
    public static final String INDEX_ROW_BY_DYNAMIC_USER_NAME = "xpath=//div[text()='%s']//parent::div//parent::div//parent::div[@class='oxd-table-card']/preceding-sibling::div";
    public static final String DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//div[@class='oxd-table-body']/div[%s]//div[%s][@role='cell']/div";
    public static final String EDIT_BUTTON_BY_USER_NAME = "xpath=//div[@class='oxd-table-body']/div[%s]//div[6][@role='cell']/div//i[@class='oxd-icon bi-pencil-fill']";
    public static final String DELETE_USER_BUTTON_BY_USER_NAME = "xpath=//div[@class='oxd-table-body']/div[%s]//div[6][@role='cell']/div//i[@class='oxd-icon bi-trash']";
    public static final String CONFIRM_DELETE_USERNAME_BUTTON = "xpath=//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
    public static final String CANCEL_DELETE_USERNAME_BUTTON = "xpath=//button[@class='oxd-button oxd-button--medium oxd-button--ghost orangehrm-button-margin']";

    public static final String NO_RECORD_FOUND_TEXT = "xpath=//span[text()='No Records Found']";
}
