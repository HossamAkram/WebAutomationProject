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
    public HomePageTests searchForProduct(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .searchForProduct("macbook")
                .clickSearchButton()
                .validateSearchResults("MacBook");
        return this;
    }

    @Test
    public void addProductToCart(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .addProductToCart()
                .validateCartItems(PropertiesUtil.getPropertyValue("macbookAdded"))
                .clickShoppingCartLink()
                .validateShoppingCartPage();
    }

    @Test
    public void addProductToWishlist(){
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .addProductToWishlist()
                .clickWishlistLink()
                .validateWishlistPage();
    }

    @Test
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
