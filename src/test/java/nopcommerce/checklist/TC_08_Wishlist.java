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
import pageUIs.user.ShoppingCartPageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;

public class TC_08_Wishlist extends BaseTest {
    private WebDriver driver;

    private HomePageObject homePage;
    private LoginPageObject loginPage;

    private CategoriesPageObject categoriesPage;
    private WishListPageObject wishListPage;
    private SpecificProductPageObject specificProductPage;

    private ShoppingCartPageObject shoppingCartPage;


    @Parameters({"browser", "userUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {

        driver = getBrowserDrivers(browserName, url);

        homePage = PageGeneratorManager.getHomePage(driver);

        homePage.clickToHeaderLinkByName("Log in");
        loginPage = PageGeneratorManager.getUserLoginPage(driver);
        loginPage.enterToLoginForm(Common_Register.emailAddress, Common_Register.password);

        homePage = PageGeneratorManager.getHomePage(driver);
        homePage.ChooseProductOnHeaderorSubMenuwithDynamicProductName();

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);


    }

    @Test
    public void Wishlist_01_Add_To_Wishlist(Method method) {
        ExtentTestManager.startTest(method.getName(), "Wishlist_01_Add_To_Wishlist");
        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 01: Step 1 - Get random product");
        specificProductPage = categoriesPage.getRandomProductToWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 01: Step 2 - Verify success Message on header");
        Assert.assertTrue(specificProductPage.getNotificationHeaderMessage().contains("The product has been added to your "));

        specificProductPage.clickToCloseButtonOnSuccessMessageBanner();

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 01: Step 3 - Click To header Link wishList");
        specificProductPage.clickToHeaderLinkByNameWithJS("Wishlist");

        wishListPage = PageGeneratorManager.getWishListPageObject(driver);

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 01: Step 4 - verify that product is added to wishlist");
        wishListPage.isSpecificProductNameExist(CategoriesPageObject.productName);

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 01: Step 5 - Click to Sharing Link");
        wishListPage.clickToSharingLinkInWishList();

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 01: Step 4 - verify Wish list title");
        Assert.assertEquals(wishListPage.getWishListTitle(), "Wishlist of " + Common_Register.firstName + " " + Common_Register.lastName);


    }

    @Test
    public void Wishlist_02_Add_Product_To_Cart_From_Wishlist_Page(Method method) {
        ExtentTestManager.startTest(method.getName(), " Wishlist_02_Add_Product_To_Cart_From_Wishlist_Page");
        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 02:  - Step 1: Click To header Link Wishlist");
        wishListPage.backToPage(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 02:  - Step 2: Click to CheckBox at Add To Cart Column");
        wishListPage.clickToCheckBoxForProductInTable(CategoriesPageObject.productName, "Add to cart");
        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 02:  - Step 3: Click to Add To Cart Button");
        shoppingCartPage = wishListPage.clickToButtonByText("Add to cart");

        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 02:  - Step 4: Verify Shopping Cart Page displays");
        Assert.assertEquals(shoppingCartPage.getShoppingCartTitle(), "Shopping cart");

        shoppingCartPage.clickToHeaderLinkByName("Wishlist");

        wishListPage = PageGeneratorManager.getWishListPageObject(driver);
        ExtentTestManager.getTest().log(Status.INFO, "Wishlist 02:  - Step 4: Verify that product Name is non-exist");
        Assert.assertFalse(wishListPage.isSpecificProductNameExist(CategoriesPageObject.productName));


    }

    @Test
    public void Wishlist_03_Remove_Product_From_Wishlist(Method method) {

        homePage= PageGeneratorManager.getHomePage(driver);
        homePage.ChooseProductOnHeaderorSubMenuwithDynamicProductName();

        categoriesPage = PageGeneratorManager.getCategoriesPageObject(driver);

        specificProductPage = categoriesPage.getRandomProductToWishList();
        specificProductPage.clickToCloseButtonOnSuccessMessageBanner();
        specificProductPage.clickToHeaderLinkByNameWithJS("Wishlist");

        wishListPage = PageGeneratorManager.getWishListPageObject(driver);

        wishListPage.clickToRemoveButtonInWishlistTable(CategoriesPageObject.productName, "Remove");

        Assert.assertTrue(wishListPage.getNoDataMessage().contains("The wishlist is empty!"));

        Assert.assertFalse(wishListPage.isSpecificProductNameExist(CategoriesPageObject.productName));
    }

    @AfterClass
    public void afterClass() {
        driver.close();

    }
}
