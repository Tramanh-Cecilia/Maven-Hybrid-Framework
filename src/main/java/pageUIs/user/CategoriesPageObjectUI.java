package pageUIs.user;

public class CategoriesPageObjectUI {

    public static final String LIST_OF_PRODUCT_NAME="XPATH=//h2[@class='product-title']";
    public static final String LIST_OF_PRODUCT_PRICE="css=div.prices";
    public static final String DYNAMIC_PRODUCT_BY_TEXT_NAME="XPATH=//h2[@class='product-title']//a[contains(text(),'%s')]";
    public static final String DYNAMIC_SORT_DROPDOWN_BY_ID="CSS=select#%s";  //products-pagesize
    public static final String DYNAMIC_PAGE_NUMBER="xpath=//li[@class='individual-page']//a[@data-page='%s']";
    public static final String NEXT_AND_PREVIOUS_PAGE_ICON="xpath=//li[@class='%s']";




}
