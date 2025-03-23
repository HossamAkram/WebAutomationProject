package com.qafox.tests;


import com.qafox.drivers.DriverManager;
import com.qafox.listeners.TestNGListeners;
import com.qafox.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class LoginTests extends TestBase {

    //tests
    @Test
    public void loginWithEmptyFields() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .clickLoginButton()
                .validateLoginErrorMessage();
    }

    @Test
    public void loginWithoutEmail() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterPassword(testData.getJsonData("loginCredentials.validPassword"))
                .clickLoginButton()
                .validateLoginErrorMessage();
    }

    @Test
    public void loginWithoutPassword() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterEmail(testData.getJsonData("loginCredentials.validEmail"))
                .clickLoginButton()
                .validateLoginErrorMessage();
    }

    @Test
    public void loginWithInvalidPassword() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterEmail(testData.getJsonData("loginCredentials.validEmail"))
                .enterPassword("InvalidPassword123")
                .clickLoginButton()
                .validateLoginErrorMessage();
    }

    @Test
    public void loginWithInvalidEmail() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterEmail("invalidemail@domain.com")
                .enterPassword(testData.getJsonData("loginCredentials.validPassword"))
                .clickLoginButton()
                .validateLoginErrorMessage();
    }

    @Test
    public HomePageTests validLoginTest() {
        new LoginPage(DriverManager.getDriver())
                .navigateToLoginPage()
                .enterEmail(testData.getJsonData("loginCredentials.validEmail"))
                .enterPassword(testData.getJsonData("loginCredentials.validPassword"))
                .clickLoginButton()
                .validateRedirectionToAcountPage();
        return new HomePageTests();
    }





}
