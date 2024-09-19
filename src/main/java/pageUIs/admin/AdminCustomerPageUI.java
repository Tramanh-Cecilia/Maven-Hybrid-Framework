package pageUIs.admin;

import org.openqa.selenium.WebElement;

public class AdminCustomerPageUI {
    public static final String CREATE_NEW_BUTTON ="css=a.btn.btn-primary" ;
    public static final String SAVE_BUTTON ="xpath=//button[@name='save']" ;
    public static final String SEARCH_CUSTOMER_BUTTON ="css=button#search-customers" ;
    public static final String DYNAMIC_GENDER_RADIO_BUTTON_BY_GENDER ="CSS=input#Gender_%s" ;
    public static final String MANAGER_VENDOR_ID_DROPDOWN_LIST ="CSS=select#VendorId" ;
    public static final String DYNAMIC_FIELD_IN_CUSTOMER_FORM_BY_FIELD_NAME="xpath=//label[text()='%s']//parent::div//parent::div//following-sibling::div//input" ;
    public static final String DYNAMIC_OPTION_IN_AUTOFIELD_BY_TEXT="xpath=//li[contains(text(), '%s')]" ;
    public static final String SELECTED_OPTION_IN_AUTOFIELD_SEARCHBOX_BY_DYNAMIC_TEXT="xpath=//label[text()='%s']//parent::div//parent::div//following-sibling::div//span[@class='select2-selection__choice__remove']" ;
    public static final String ALERT_SUCCESS_MASSAGE="xpath=//div[@class='alert alert-success alert-dismissable']" ;
    public static final String CUSTOMER_ROLE_FIELD_SEARCHBOX="xpath=//select[@id='SelectedCustomerRoleIds']//following-sibling::span//input[@class='select2-search__field']" ;
    public static final String SELECTED_OPTION_IN_CUSTOMER_ROLE_FIELD_SEARCHBOX="xpath=//select[@id='SelectedCustomerRoleIds']//following-sibling::span//span[@class='select2-selection__choice__remove']" ;
    public static final String GUEST_OPTION_IN_CUSTOMER_ROLE_FIELD_SEARCHBOX="XPATH=//li[contains(text(), 'Guests')]" ;
    public static final String DYNAMIC_SEARCH_TEXTBOX_BY_ID="CSS=input#%s" ;
    public static final String AJAX_LOADING_ICON = "CSS=div#ajaxBusy";
    public static final String DYNAMIC_ROW_INDEX_BY_TEXT_IN_COLUMN = "xpath=//td[text()='%s']//parent::tr";
    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//th[text()='%s']//preceding-sibling::th";
    public static final String DYNAMIC_CELL_BY_DYNAMIC_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]";
    public static final String ADMIN_COMMENT_TEXT_AREA = "xpath=//label[text()='Admin comment']//parent::div//parent::div//following-sibling::div//textarea";
    public static final String CUSTOMER_ROLE_OPTION_DROPDOWN = "xpath=//li[text()='%s']";
}
