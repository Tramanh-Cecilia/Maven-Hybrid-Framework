package pageUIs.user;

public class CheckoutPageUI {

    public static final String DYNAMIC_TEXTBOX_BY_TEXT="xpath=//label[contains(text(),'%s')]//following-sibling::input";
    public static final String DYNAMIC_DROPDOWN_BY_TEXT="xpath=//label[contains(text(),'%s')]//following-sibling::select";
    public static final String CONTINUE_BUTTON="xpath=//button[@id='save-billing-address-button']//following-sibling::button";
    public static final String DYNAMIC_METHOD_LIST_RADIO_BUTTON_BY_MEDTHOD_TEXT="xpath=//ul[@class='method-list']//label[text()='%s']//preceding-sibling::input";
    public static final String DYNAMIC_PAYMENT_METHOD_RADIO_BUTTON_BY_PAYMENT_TEXT="xpath=//label[contains(text(),'%s')]//preceding-sibling::input";
    public static final String CONTINUE_BUTTON_IN_DYNAMIC_SECTION ="css=button.%s" ;
    public static final String DYNAMIC_SHIPPING_INFO_BY_CLASS_NAME ="css=div.shipping-info li.%s" ;
    public static final String DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME="xpath=//a[text()='%s']//parent::td//parent::tr//preceding-sibling" ;
    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME="xpath=//th[contains(text(),'%s')]//preceding-sibling::th" ;


    public static final String DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX ="xpath=//tr[%s]//td[%s]" ;
    public static final String COMPLETE_ORDER_MESSAGE = "css=div.section.order-completed div.title";
    public static final String ORDER_NUMBER_FOR_COMPLETE_ORDER ="css=div.order-number" ;
}
