package pageUIs.jquery;

public class HomePageUI {
	public static final String COLUMN_TEXTBOX_BYNAME="xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String PAGE_LINK_BY_NUMBER="xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
	public static final String PAGE_LINK_ACTIVE_BY_NUMBER="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String DYNAMIC_ROW_VALUE="xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']//following-sibling::td[@data-key='males' and text()='%s']//following-sibling::td[@data-key='total' and text()='%s']";
	public static final String ROW_ACTION_BY_COUNTRY_NAME="xpath=//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";

	public static final String COLUMN_INDEX_BY_COLUMN_NAME="xpath=//th[text()='%s']/preceding-sibling::th" ;
	public static final String DYNAMIC_TEXTBOX_ROW_INDEX_AND_COLUMN_INDEX ="xpath=//tr[%s]/td[%s]/input";
	public static final String DYNAMIC_DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX ="xpath=//tr[%s]/td[%s]//select";
	public static final String DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX ="xpath=//tr[%s]/td[%s]//input";
	
	//Live techpanda
	public static final String ACCOUNT_LINK="xpath=//div[@class='account-cart-wrapper']//span[text()='Account']";
	public static final String REGISTER_LINK_IN_HEADER="xpath=//div[@id='header-account']//a[text()='Register']";
	public static final String FIRSTNAME_TEXTBOX="css=input#firstname";
	public static final String LASTNAME_TEXTBOX="css=input#lastname";
	public static final String EMAIL_ADDRESS_TEXTBOX="css=input#email_address";
	public static final String PASSWORD_TEXTBOX="css=input#password";
	public static final String CONFIRM_PASSWORD_TEXTBOX="css=input#confirmation";
	public static final String REGISTER_BUTTON="xpath=//button[@title='Register']";
	public static final String SUCCESS_REGISTER_MESSAGE="css=li.success-msg";
	
	//admin
	public static final String USERNAME_TEXTBOX_ADMIN="XPATH=//input[@id='username']";
	public static final String PASSWORD_TEXTBOX_ADMIN="XPATH=//input[@id='login']";
	public static final String LOGIN_BUTTON_ADMIN="XPATH=//input[@type='submit']";
	public static final String INCOMING_MESSAGE_POPUP="XPATH=//div[@class='message-popup-content']";
	public static final String CLOSE_BUTTON_OF_INCOMING_MESSAGE_POPUP="XPATH=//a[@onclick='closeMessagePopup(); return false;']";
	public static final String COLUMN_INDEX_BY_ADMIN_COLUMN_NAME="XPATH=//span[text()='%s']//ancestor::th//preceding-sibling::th";
	public static final String DYNAMIC_ADMIN_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX="XPATH=//div[@class='grid']//tbody//tr[%s]/td[%s]";

	
}
