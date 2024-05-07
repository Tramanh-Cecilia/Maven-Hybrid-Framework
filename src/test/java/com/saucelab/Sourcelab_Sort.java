package com.saucelab;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.Soucelab.LoginPageObject;
import pageObjects.Soucelab.PageGeneratorManager;
import pageObjects.Soucelab.ProductPageObject;
import pageUIs.sourcelab.ProductPageUI;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sourcelab_Sort extends BaseTest {

    private WebDriver driver;
    private LoginPageObject loginPage;
    private ProductPageObject productPage;
    protected String userName = "standard_user";
    protected String password = "secret_sauce";

    @Parameters({"browser", "url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDrivers(browserName, url);
        loginPage = PageGeneratorManager.getLoginPageObject(driver);

        loginPage.enterToUsernameTextbox(userName);
        loginPage.enterToPassTextbox(password);
        loginPage.clickToLoginButton();
        productPage = PageGeneratorManager.getProductPageObject(driver);

    }

    @Test
    public void Sourcelab_01_ASC(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sourcelab_01_ASC");
        ExtentTestManager.getTest().log(Status.INFO, "TC01 - Step 01: Click to Dropdown Name (A to Z) ");

        productPage.clickToSortDropdown("Name (A to Z)");
        ExtentTestManager.getTest().log(Status.INFO, "TC01 - Step 02: verify Product Name Sorting By Ascending ");
        Assert.assertTrue(productPage.isProductNameSortByAscending());


    }

    @Test
    public void Sourcelab_02_DESC(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sourcelab_02_DESC");
        ExtentTestManager.getTest().log(Status.INFO, "TC02 - Step 01: Click to Dropdown Name (Z to A)");

        productPage.clickToSortDropdown("Name (Z to A)");

        ExtentTestManager.getTest().log(Status.INFO, "TC02 - Step 02: verify Product Name Sorting By Desscending ");
        Assert.assertTrue(productPage.isProductNameSortByDesscending());


    }

    public void Sourcelab_03_Product_Price_ASC(Method method) {
        ExtentTestManager.startTest(method.getName(), "Sourcelab_03_Product_Price_ASC");
        ExtentTestManager.getTest().log(Status.INFO, "TC02 - Step 01: Click to Dropdown Sort -- Price (low to high)");

        productPage.clickToSortDropdown("Price (low to high)");

        ExtentTestManager.getTest().log(Status.INFO, "TC03 - Step 02: verify Product Price Sorting By Ascending ");
        Assert.assertTrue(productPage.isProductPriceSortByAscending());


    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

