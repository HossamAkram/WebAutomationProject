package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.listeners.TestNGListeners;
import com.qafox.pages.HomePage;
import com.qafox.utils.PropertiesUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class HomePageTests extends TestBase {

    //tests
    @Test
    public void searchForProduct(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .searchForProduct("iphone")
                .clickSearchButton()
                .validateSearchResults("iPhone");

    }

    @Test
    public void addProductToCart(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .addProductToCart("iPhone")
                .validateCartItems(PropertiesUtil.getPropertyValue("iphoneAdded"))
                .clickShoppingCartLink()
                .validateShoppingCartPage();
    }

    @Test(dependsOnMethods = "com.qafox.tests.LoginTests.validLoginTest")
    public void addProductToWishlist(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .addProductToWishlist()
                .clickWishlistLink()
                .validateWishlistPage();
    }

    @Test(dependsOnMethods = "com.qafox.tests.LoginTests.validLoginTest")
    public void addProductToCompareList(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .addProductToComparison()
                .validateAddedToComparisonListMessage()
                .clickCompareListLink()
                .validateProductComparisonPage();
    }

    @Test
    public void changeCurrency(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .clickCurrencyDropdown()
                .selectCurrency("EUR")
                .validateCurrencyChanged("€");
    }

}
