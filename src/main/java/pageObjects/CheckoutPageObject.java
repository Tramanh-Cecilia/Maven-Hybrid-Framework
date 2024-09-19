package pageObjects;


import commons.BaseElement;
import org.openqa.selenium.WebDriver;
import pageUIs.user.CheckoutPageUI;
import pojoTestData.CheckOutInfo;

public class CheckoutPageObject extends BaseElement {
    private WebDriver driver;

    public CheckoutPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void completeShippingAddressForm(CheckOutInfo checkOutInfo, String country, String state) {
        isPageLoadedSuccess(driver);
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getFirstName(), "First name");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getLastName(), "Last name");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getEmail(), "Email");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getCompany(), "Company");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getCity(), "City");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getAddress1(), "Address 1");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getAddress2(), "Address 2");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getZipcode(), "Zip / postal code");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getPhoneNumber(), "Phone number");
        sendkeyToElement(driver, CheckoutPageUI.DYNAMIC_TEXTBOX_BY_TEXT, checkOutInfo.getFaxNumber(), "Fax number");
        selectItemInDefaultDropdown(driver, CheckoutPageUI.DYNAMIC_DROPDOWN_BY_TEXT, country, "Country");
        selectItemInDefaultDropdown(driver, CheckoutPageUI.DYNAMIC_DROPDOWN_BY_TEXT, state, "State / province:");
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON);
    }

    public void chooseMethodList(String methodText){
        waitForElementClickable(driver, CheckoutPageUI.DYNAMIC_METHOD_LIST_RADIO_BUTTON_BY_MEDTHOD_TEXT, methodText);
        checkToElement(driver, CheckoutPageUI.DYNAMIC_METHOD_LIST_RADIO_BUTTON_BY_MEDTHOD_TEXT, methodText);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_IN_DYNAMIC_SECTION,"button-1.shipping-method-next-step-button");

    }
    public void choosePaymentMethodByPaymentText(String paymentText){
        waitForElementClickable(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_RADIO_BUTTON_BY_PAYMENT_TEXT, paymentText);
        checkToElement(driver, CheckoutPageUI.DYNAMIC_PAYMENT_METHOD_RADIO_BUTTON_BY_PAYMENT_TEXT, paymentText);
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_IN_DYNAMIC_SECTION,"button-1.payment-method-next-step-button");

    }

    public void clickToContinueButtonInPaymentInformation(){
        waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_IN_DYNAMIC_SECTION, "button-1.payment-info-next-step-button" );
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_IN_DYNAMIC_SECTION, "button-1.payment-info-next-step-button" );
    }
    public void clickToConfirmButtonInConfirmSection(){
        waitForElementClickable(driver, CheckoutPageUI.CONTINUE_BUTTON_IN_DYNAMIC_SECTION, "button-1.confirm-order-next-step-button" );
        clickToElement(driver, CheckoutPageUI.CONTINUE_BUTTON_IN_DYNAMIC_SECTION, "button-1.confirm-order-next-step-button" );
    }

    public String getDynamicInforInShippingInforSectionByClassName(String className){
        waitForElementVisible(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFO_BY_CLASS_NAME, className);
        return getElementText(driver, CheckoutPageUI.DYNAMIC_SHIPPING_INFO_BY_CLASS_NAME, className);

    }
    public String getSuccessMessageForCompletedOrder(){
        waitForElementVisible(driver, CheckoutPageUI.COMPLETE_ORDER_MESSAGE);
        return getElementText(driver, CheckoutPageUI.COMPLETE_ORDER_MESSAGE);

    }
    public String getOrderNumberForCompleteOrder(){
        waitForElementVisible(driver, CheckoutPageUI.ORDER_NUMBER_FOR_COMPLETE_ORDER);
        return getElementText(driver, CheckoutPageUI.ORDER_NUMBER_FOR_COMPLETE_ORDER);

    }

    public String getProdutNameInDynamicCell(String productName, String columnName){
        int rowIndex= getListElementSize(driver,CheckoutPageUI.DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME,productName)+1;
        int columnIndex = getListElementSize(driver,CheckoutPageUI.DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME,columnName)+1;
        return getElementText(driver, CheckoutPageUI.DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX,String.valueOf(rowIndex), String.valueOf(columnIndex) );
    }


}
