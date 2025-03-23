package com.qafox.tests;

import com.qafox.listeners.TestNGListeners;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class E2eTest extends TestBase{

    //tests
    @Test
    public void E2eScenario(){

        new RegisterTests()
                .registerWithValidData()
                .validLoginTest()
                .searchForProduct()
                .addProductToCart();



        //register with valid data and logout
        //login with valid data
        //search for a product
        //add product to cart
        //checkout?



    }

}
