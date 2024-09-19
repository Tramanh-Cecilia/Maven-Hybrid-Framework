package pageUIs.user;

public class WishListPageUI {
    public static final String PRODUCT_COLUMN= "xpath=//tbody//tr//td[@class='product']";
    public static final String WISHLIST_SHARING_LINK= "xpath=//div[@class='share-info']//a";
    public static final String WISHLIST_PAGE_TITLE= "xpath=//div[@class='page-title']//h1";
    public static final String BUTTON_BY_TEXT_IN_WISHLIST= "xpath=//div[@class='buttons']//button[contains(text(),'%s')]";
    public static final String ROW_INDEX_BY_PRODUCT_NAME= "xpath=//a[contains(text(), '%s')]/parent::td/parent::tr/preceding-sibling::tr";
    public static final String COLUMN_INDEX_BY_COLUMN_NAME_TEXT= "xpath=//th[text()='%s']/preceding-sibling::th";
    public static final String DYNAMIC_CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX= "xpath=//tr[%s]//td[%s]";


    public static final String NO_DATA_MESSAGE_TEXT ="CSS=div.no-data";
}
