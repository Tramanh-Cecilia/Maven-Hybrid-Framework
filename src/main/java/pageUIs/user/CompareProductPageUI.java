package pageUIs.user;

public class CompareProductPageUI {

    final public static String LIST_PRODUCT_NAME_IN_COMPARE_LIST = "xpath=//tr[@class='product-name']//td//a";
    final public static String DYNAMIC_COLUMN_INDEX_BY_PRODUCT_NAME = "xpath=//td/a[text()='%s']//parent::td/preceding-sibling::td";
    final public static String DYNAMIC_ROW_INDEX_BY_ROW_CLASS_NAME = "xpath=//tr[@class='%s']//preceding-sibling::tr";
    final public static String DYNAMIC_CELL_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tr[%s]//td[%s]";

}
