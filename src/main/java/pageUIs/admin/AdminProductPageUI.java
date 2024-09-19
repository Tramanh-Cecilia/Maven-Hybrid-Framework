package pageUIs.admin;

import org.openqa.selenium.WebElement;

public class AdminProductPageUI {

    public static final String DYNAMIC_SEARCH_TEXTBOX_BY_ID="css=input#%s";//SearchProductName
    public static final String SEARCH_BUTTON="CSS=button#search-products";
    public static final String DYNAMIC_DROPDOWN_BY_ID ="css=select#%s" ;
    public static final String SEARCH_SECTION="CSS=div.row.search-row";
    public static final String SEARCH_ROW="xpath=//div[contains(@class,'row search-row')]";
    public static final String DYNAMIC_ROW_BY_PRODUCT_NAME="XPATH=//td[contains(text(),'%s')]//parent::tr//preceding-sibling::tr";
    public static final String DYNAMIC_COLUMN_BY_COLUMN_NAME="XPATH=//th[text()='%s']//preceding-sibling::th";
    public static final String DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX="XPATH=//tr[%s]//td[%s]";
    public static final String PUBLSIHED_COLUMN_BY_ROW_INDEX_AND_COLUMN_INDEX="XPATH=//tr[%s]//td[%s]//i";

    public static final String CHECKBOX_IN_SUB_CATEGORIES ="css=input#SearchIncludeSubCategories" ;
    public static final String EMPTY_ERROR_MESSAGE ="css=td.dataTables_empty" ;
    public static final String GO_BUTTON_AT_SKU_TEXTBOX ="css=button#go-to-product-by-sku" ;
    public static final String PRODUCT_NAME_TEXTBOX_IN_EDIT_PRODUCT_PAGE ="css=input#Name" ;


}
