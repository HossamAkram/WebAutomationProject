package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.listeners.TestNGListeners;
import com.qafox.pages.HomePage;
import com.qafox.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class E2eTest extends TestBase{

    //tests
    @Test
    public void E2eScenario(){

        /*new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.item1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.item1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.item1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.item1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.item1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.item1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton()
                .clickMyAccountDropdown()
                .clickMyAccountOption("Logout");*/
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterEmail(testData.getJsonData("loginCredentials.validEmail"))
                .enterPassword(testData.getJsonData("loginCredentials.validPassword"))
                .clickLoginButton()
                .validateRedirectionToAcountPage();
        new HomePage(DriverManager.getDriver())
                .navigateToHomePage()
                .clickCurrencyDropdown()
                .selectCurrency("EUR")
                .validateCurrencyChanged("€")
                .searchForProduct("iphone")
                .clickSearchButton()
                .validateSearchResults("iPhone")
                .navigateToHomePage()
                .addProductToCart("iPhone")
                .addProductToWishlist()
                .addProductToComparison()
                .validateAddedToComparisonListMessage()
                .clickCompareListLink()
                .clickWishlistLink()
                .clickShoppingCartLink()
                .validateShoppingCartPage();


        //register with valid data and logout
        //login with valid data
        //search for a product
        //add product to cart
        //checkout?



    }

}
