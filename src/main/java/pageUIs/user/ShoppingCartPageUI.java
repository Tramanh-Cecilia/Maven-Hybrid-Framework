package pageUIs.user;

public class ShoppingCartPageUI {

    public static final String PAGE_TITLE = "css=div.page-title h1";
    public static final String DYNAMIC_INFORMATION_OF_ITEM_BY_CLASS_NAME = "css=div.mini-shopping-cart div.%s";
    public static final String DYNAMIC_ROW_INDEX_BY_PRODUCT_NAME = "xpath=//a[contains(text(),'%s')]//parent::td[@class='product']//parent::tr//preceding-sibling::tr";
    public static final String DYNAMIC_COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//th[@class='%s']//preceding-sibling::th";
    public static final String DYNAMIC_EDIT_LINK_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//div/a[text()='Edit']";
    public static final String DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]";
    public static final String QUANTITY_TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//input";
    public static final String ORDER_SUMMARY_CONTENT_TEXT = "css=div.order-summary-content";
    public static final String QUANTITY_BUTTON_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]//div[@class='quantity up']";

}
