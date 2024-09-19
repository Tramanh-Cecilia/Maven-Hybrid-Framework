package pageUIs.user;

public class HomePageUI {
	
	public static final String REGISTER_LINK="xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK ="xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK ="xpath=//a[@class='ico-account']";
	public static final String LOGOUT_LINK ="xpath=//a[@class='ico-logout']";


    public static final String DYNAMIC_PRODUCT_NAME_ON_HEADER_MENU = "xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_PRODUCT_NAME_ON_SUBLIST_MENU = "xpath=//ul[@class='top-menu notmobile']//ul[@class='sublist first-level']//a[contains(text(),'%s')]";

    public static final String LIST_PRODUCTS_ON_ON_HEADER_MENU ="xpath=//ul[@class='top-menu notmobile']/li[not(@class='sublist first-level')]/a" ;
    public static final String DYNAMIC_SUBLIST_PRODUCTS_ON_ON_HEADER_MENU ="xpath=//ul[@class='top-menu notmobile']//a[contains(text(),'%s')]//parent::li//ul/li/a" ;
}
