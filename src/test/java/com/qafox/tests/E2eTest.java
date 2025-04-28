package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.listeners.TestNGListeners;
import com.qafox.pages.ContactUsPage;
import com.qafox.pages.HomePage;
import com.qafox.pages.LoginPage;
import com.qafox.pages.RegisterPage;
import com.qafox.utils.PropertiesUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Instant;

@Listeners(TestNGListeners.class)
public class E2eTest extends TestBase{

    //tests
    @Test
    public void E2eScenario(){

        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail")+Instant.now().toEpochMilli())
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton()
                .clickMyAccountDropdown()
                .clickMyAccountOption("Logout");
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
                .addProductToCart("MacBook")
                .validateCartItems(PropertiesUtil.getPropertyValue("macbookAdded"))
                .addProductToWishlist()
                .addProductToComparison()
                .validateAddedToComparisonListMessage()
                .clickCompareListLink()
                .clickWishlistLink()
                .clickShoppingCartLink()
                .validateShoppingCartPage();
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateSuccessfulSubmissionUrl();



        //register with valid data and logout
        //login with valid data
        //search for a product
        //add product to cart
        //checkout?



    }

}
