package nopcommerce.checklist;


import com.aventstack.extentreports.Status;
import commons.BaseTest;
import commons.PageGeneratorManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.*;
import pageUIs.user.SpecificProductPageUI;
import pojoTestData.CheckOutInfo;
import reportConfig.ExtentTestManager;
import utilities.FakerConfig;

import java.lang.reflect.Method;


public class TC_10_Order extends BaseTest {
    WebDriver driver;
    private HomePageObject homePage;
    private LoginPageObject loginPage;

    private CategoriesPageObject categoriesPage;
    private SpecificProductPageObject specificProductPage;
    private ShoppingCartPageObject shoppingCartPage;
    private CheckoutPageObject checkoutPage;
    private FakerConfig fakerData;
    private CheckOutInfo checkoutInfor;

    private CustomerPageObject customerPage;
    private OrderPageObject orderPage;





    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        driver = getBrowserDrivers(browserName, url);
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

    }

    @Test
    public void Order_01_Add_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_01_Add_Shopping_Cart");
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 1 - Hover to Computer category ");
        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.hoverToHeaderMenuByHeaderProductName("Computers");

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 2 - Hover to Desktops sublist category");
        homePage.selectADynamicProductinSublistMenuByName("Desktops ");

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 3 - Click To product -Build your own computer ");
        categoriesPage.clickToProductByProductName("Build your own computer");

        specificProductPage = PageGeneratorManager.getSpecificProductPageObject(driver);


        specificProductPage.selectAnItemInAttributeDropdown(" Processor", "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 4 - Select dropdown list WITH RAM attribute ");
        specificProductPage.selectAnItemInAttributeDropdown("RAM", "8GB [+$60.00]");


        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 5 - Select item in HDD attribute ");
        specificProductPage.selectAnItemInAttributeWithRadioType("HDD", "400 GB [+$100.00]");

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 6 - Select item in OS attribute ");
        specificProductPage.selectAnItemInAttributeWithRadioType("OS", "Vista Premium [+$60.00]");

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 7 - Select item in software Checkbox attribute ");
        specificProductPage.selectMultipleItemInAttributeWithCheckboxType("Software");

        var producPrice = specificProductPage.getProductPrice();

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 8 - Click To add To Cart Button ");
        specificProductPage.clickToAddToCartButton();


        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 9 - Verify Notification message ");
        Assert.assertEquals(specificProductPage.getNotificationHeaderMessage(), "The product has been added to your shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 10- click To close Button ");
        specificProductPage.clickToCloseButtonOnSuccessMessageBanner();

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 11- Hover to Supping Cart headerName");
        specificProductPage.refreshCurrentPage(driver);
        specificProductPage.hoverToHeaderLinkByName("Shopping cart");

        shoppingCartPage = PageGeneratorManager.getShoppingCartPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 12- very the number of items");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("count").contains("There are 1 item(s) in your cart"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 13- verify the name of product");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("name").contains("Build your own computer"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 14- verify Attribute of the product");

        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("8GB [+$60.00]"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 15- verify Attribute of the product");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("400 GB [+$100.00]"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 16- verify Attribute of the product");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("Vista Premium [+$60.00]"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_01: Step 17- verify product price");
        System.out.println(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("totals"));
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("totals").contains("$1,500.00"));


    }

    @Test
    public void Order_02_Edit_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), "Order_02_Edit_Shopping_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 1: Click To Shopping Cart On header");
        shoppingCartPage.clickToHeaderLinkByName("Shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 2: Click To edit link of a product");
        specificProductPage = shoppingCartPage.clickToEditLinkByProductNameRow("Build your own computer", "product");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 3: Choose Processor");
        specificProductPage.selectAnItemInAttributeDropdown(" Processor", "2.2 GHz Intel Pentium Dual-Core E2200");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 4: Choose Ram");
        specificProductPage.selectAnItemInAttributeDropdown(" RAM ", "4GB [+$20.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 5: Choose HD");
        specificProductPage.selectAnItemInAttributeWithRadioType("HDD", "320 GB");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 6: Choose OS");
        specificProductPage.selectAnItemInAttributeWithRadioType("OS", "Vista Home [+$50.00]");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 7: Choose software");
        specificProductPage.selectOneItemInAttributeWithCheckboxType("Software", "Microsoft Office [+$50.00]");
        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 8: Update number of products");
        specificProductPage.updateNumberOfProductAddToCart("2");
        var producPrice = specificProductPage.getProductPrice();
        System.out.println(producPrice );
        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 9: Compare product price");
        Assert.assertEquals(producPrice, "$1,320.00");

        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 10: Click To header Link Shopping Cart");
        specificProductPage.refreshCurrentPage(driver);
        specificProductPage.hoverToHeaderLinkByName("Shopping cart");

        shoppingCartPage = PageGeneratorManager.getShoppingCartPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO, " Order_02 -Step 12- very the number of items");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("count").contains("There are 2 item(s) in your cart"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_02 -Step 13- verify the name of product");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("name").contains("Build your own computer"));
        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step- verify Attribute of the product");

        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("4GB [+$20.00]"));
        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 15- verify Attribute of the product");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("320 GB"));
        ExtentTestManager.getTest().log(Status.INFO, "Order_02 -Step 16- verify Attribute of the product");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("Vista Home [+$50.00]"));
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("attributes").contains("Microsoft Office [+$50.00]"));
        ExtentTestManager.getTest().log(Status.INFO, " Order_02 -Step 17- verify product price");
        Assert.assertTrue(shoppingCartPage.getInformationOfItemInMiniShoppingCartByClassName("price").contains("$2,640.00"));


    }

    @Test
    public void Order_03_Remove_Product_From_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), " Order_03_Remove_Product_From_Shopping_Cart");
        ExtentTestManager.getTest().log(Status.INFO, "Order_03  - step 1: click to header Link");
        shoppingCartPage.clickToHeaderLinkByName("Shopping cart");

        ExtentTestManager.getTest().log(Status.INFO, "Order_03  - Step 2: click To remove button");
        shoppingCartPage.clickToDynamicCellByDynamicRowIndexandColumnIndex("Build your own computer", "remove-from-cart");

        ExtentTestManager.getTest().log(Status.INFO, "Order_03  - Step 3: Verify message -Your Shopping Cart is empty!");
        Assert.assertEquals(shoppingCartPage.getOrderSummaryContent(), "Your Shopping Cart is empty!");
    }

    @Test
    public void Order_04_Update_Product_In_Shopping_Cart(Method method) {
        ExtentTestManager.startTest(method.getName(), " Order_04_Update_Product_In_Shopping_Cart");

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.hoverToHeaderMenuByHeaderProductName("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 2 - Hover to Desktops sublist category");
        homePage.selectADynamicProductinSublistMenuByName("Desktops");

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 3 - Click To product add to cart button ");
        categoriesPage.clickToAddToCartButtonBasedOnProductName("Lenovo IdeaCentre 600 All-in-One PC");
        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 4 - wait for Ajax button undisplayed");
        categoriesPage.isAjaxLoadingUndisplayed();

        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 5 - Click to Header Link - Shopping cart");
        categoriesPage.clickToHeaderLinkByNameWithJS("Shopping cart");

        shoppingCartPage = PageGeneratorManager.getShoppingCartPageObject(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 6 - Update the number of product");
        shoppingCartPage.clickToQuantiyCellByDynamicRowIndexandColumnIndexWithNumberOfClick("Lenovo IdeaCentre 600 All-in-One PC", "quantity", 4);

        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 7 - Verify the total price");
        Assert.assertEquals(shoppingCartPage.getTextOfDynamicCellByDynamicRowIndexandColumnIndex("Lenovo IdeaCentre 600 All-in-One PC",
                "subtotal"), "$2,500.00");

        ExtentTestManager.getTest().log(Status.INFO, "Order_04: Step 8 - Remove From cart");

        shoppingCartPage.clickToDynamicCellByDynamicRowIndexandColumnIndex("Lenovo IdeaCentre 600 All-in-One PC", "remove-from-cart");

    }

    @Test
    public void Order_05_Checkout_Shopping_Cart(Method method){
        ExtentTestManager.startTest(method.getName(), " Order_05_Checkout_Shopping_Cart");

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.hoverToHeaderMenuByHeaderProductName("Computers");

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 2 - Hover to Desktops sublist category");
        homePage.selectADynamicProductinSublistMenuByName("Notebooks");

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);
        categoriesPage.isPageLoadedSuccess(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 3 - Click To product add to cart button ");
        var  productName="Apple MacBook Pro 13-inch";
        categoriesPage.clickToAddToCartButtonBasedOnProductName("Apple MacBook Pro 13-inch");

        specificProductPage= PageGeneratorManager.getSpecificProductPageObject(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 4 - Click To product add to cart button ");
        specificProductPage.sleepInSecond(3);
        specificProductPage.clickToAddToCartButton();
        specificProductPage.clickToCloseButtonOnSuccessMessageBanner();
        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 5- Click To Header link");
        specificProductPage.clickToHeaderLinkByNameWithJS("Shopping cart");
        specificProductPage.sleepInSecond(3);

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 6- Click To Estimate Shipping button");
        specificProductPage.clickToEstimateShippingButton();

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 7- Select Value In Shipping Country Dropdown");
        specificProductPage.selectValueOFCountryInShippingPopup("Viet Nam");

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 8- sendkey To Postal Code Textbox");
        specificProductPage.sendkeyToZipPostalCodeTextboxInEstimateShippingPopup("550000");
        specificProductPage.isAjaxLoadingUndisplayed();
        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 9- Click to Apply Button");
        specificProductPage.sleepInSecond(3);
        specificProductPage.clickToApplyButtonInEstimateShippingPopup();

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 10- Click to term of service Checkbox");
        specificProductPage.clickToTermOfServiceCheckBox();

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 11- Click To Checkout Button");
        checkoutPage = specificProductPage.clickToCheckOutButton();

        fakerData = new FakerConfig();
        checkoutInfor = CheckOutInfo.getCheckOutInfo();
        checkoutInfor.setFirstName(fakerData.getFirstName());
        checkoutInfor.setLastName(fakerData.getLasttName());
        checkoutInfor.setEmail(fakerData.getEmailAddress());
        checkoutInfor.setCompany(fakerData.getCompany());
        checkoutInfor.setCity(fakerData.getCityName());
        checkoutInfor.setAddress1(fakerData.getStreetAddress());
        checkoutInfor.setAddress2(fakerData.getSecondAddress());
        checkoutInfor.setZipcode(fakerData.getZipcode());
        checkoutInfor.setPhoneNumber(fakerData.getPhoneNumber());
        checkoutInfor.setFaxNumber(fakerData.getFaxnumber());


        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 12- Enter Into Shipping Address form");
        checkoutPage.completeShippingAddressForm( checkoutInfor, "Viet Nam", "Other");

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 13- Choose Shipping method ");
        checkoutPage.chooseMethodList("Ground ($0.00)");

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 13- Choose Payment method ");
        checkoutPage.choosePaymentMethodByPaymentText("Check / Money Order");

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 14- Click to continue button ");
        checkoutPage.clickToContinueButtonInPaymentInformation();

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 15- Verify fullName in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("name"),
                checkoutInfor.getFirstName()+ " "+ checkoutInfor.getLastName());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 16- Verify Email in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("email").substring(7),
                checkoutInfor.getEmail());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 16- Verify Phone Number in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("phone").substring(7),
                checkoutInfor.getPhoneNumber());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 17- Verify Fax Number in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("fax").substring(5),
                checkoutInfor.getFaxNumber());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 18- Verify Company in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("company"),
                checkoutInfor.getCompany());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 19- Verify Country in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("country"),
              "Viet Nam");


        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 21- Verify City in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("city"),
                checkoutInfor.getCity());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 22- Verify Address 1 in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("address1"),
                checkoutInfor.getAddress1());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 23- Verify Address 2 in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("address2"),
                checkoutInfor.getAddress2());

        ExtentTestManager.getTest().log(Status.INFO, "Order_05: Step 23- Verify Zip Code in Shipping Address ");
        Assert.assertEquals( checkoutPage.getDynamicInforInShippingInforSectionByClassName("zippostalcode"),
                checkoutInfor.getZipcode());

        Assert.assertEquals(checkoutPage.getProdutNameInDynamicCell( productName,"Product"), productName);
        Assert.assertEquals(checkoutPage.getProdutNameInDynamicCell( productName,"Price"),"$1,800.00");
        Assert.assertEquals(checkoutPage.getProdutNameInDynamicCell( productName,"Qty."),"2");
        Assert.assertEquals(checkoutPage.getProdutNameInDynamicCell( productName,"Total"),"$3,600.00");

        checkoutPage.clickToConfirmButtonInConfirmSection();
        Assert.assertEquals(checkoutPage.getSuccessMessageForCompletedOrder(), "Your order has been successfully processed!");
        var orderNumber= checkoutPage.getOrderNumberForCompleteOrder();
        checkoutPage.clickToHeaderLinkByName("My account");
        customerPage = PageGeneratorManager.getCustomerPage(driver);
        orderPage= customerPage.openOrderPage();

        Assert.assertEquals(orderNumber.substring(14),orderPage.getOrderNumber().substring(14));
        orderPage.clickToDetailButton();

        orderNumber =orderNumber.substring(18);
        Assert.assertEquals(orderNumber, orderPage.getOrderNumerInDetailSection());


    }



    @AfterClass
    public void afterClass() {
//        driver.close();
    }


}
