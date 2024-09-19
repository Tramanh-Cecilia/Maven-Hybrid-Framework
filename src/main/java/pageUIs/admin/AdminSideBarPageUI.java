package pageUIs.admin;

public class AdminSideBarPageUI {

    public static final String PRODUCT_LINK_IN_ADMIN_SIDE_BAR ="xpath=//nav[@class='mt-2']//p[contains(text(),'Products') and not(contains(text(),'purchased'))]" ;
    public static final String CATALOG_LINK_IN_ADMIN_SIDE_BAR  ="xpath=//nav[@class='mt-2']//i[@class='nav-icon fas fa-book']//following-sibling::p[contains(text(),'Catalog')]" ;
    public static final String CUSTOMER_LINK_IN_ADMIN_SIDE_BAR  ="xpath=//nav[@class='mt-2']//i[@class='nav-icon far fa-user']//following-sibling::p[contains(text(),'Customers')]" ;
    public static final String CUSTOMER_LIST_LINK_IN_ADMIN_SIDE_BAR  ="xpath=//a[contains(@href,'Admin/Customer/List')]" ;

}
