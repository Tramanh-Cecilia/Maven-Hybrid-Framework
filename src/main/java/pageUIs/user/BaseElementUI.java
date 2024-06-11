package pageUIs.user;

import org.openqa.selenium.WebElement;

public class BaseElementUI {
	public static final String NOPCOMMERCE_LOGO = "xpath=//div[@class='header-logo']";

	public static final String AJAX_ICON="css=div.ajax-products-busy";
	public static final String UPLOAD_FILE_TYPE="CSS=input[name='files[]']";
	public static final String DYNAMIC_HEADER_LINK_BY_NAME ="xpath=//div[@class='header-links']//a[contains(string(),'%s')]";
	public static final String DYNAMIC_BUTTON_BY_TEXT ="xpath=//button[text()='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID ="id=%s-error";
	public static final String DYNAMIC_TEXTBOX_BY_ID ="css=input[id='%s']";
	public static final String DYNAMIC_NOTIFICATION_HEADER ="xpath=//div[@id='bar-notification']//p[@class='content']";
	public static final String CLOSE_BUTTON_FOR_SUCCESS_MESSAGE = "xpath=//div[@class='bar-notification success']//span[@class='close']";
	public static final String DYNAMIC_FOOTER_LINK_BY_NAME = "xpath=//div[@class='footer-upper']//a[contains(text (), '%s')]";
}
