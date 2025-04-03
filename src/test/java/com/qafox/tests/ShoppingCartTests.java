package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.pages.ShoppingCartPage;
import org.testng.annotations.Test;

public class ShoppingCartTests extends TestBase {

    //tests
    @Test(dependsOnMethods = {"com.qafox.tests.LoginTests.validLoginTest","com.qafox.tests.HomePageTests.searchForProduct","com.qafox.tests.HomePageTests.addProductToCart"})
    public void testValidateStockAndProceed() {
        new ShoppingCartPage(DriverManager.getDriver())
                .navigateToShoppingCartPage()
                .validateCartTotal()
                .validateStockAndProceed();
    }


}
