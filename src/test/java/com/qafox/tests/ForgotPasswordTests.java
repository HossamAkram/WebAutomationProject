package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.listeners.TestNGListeners;
import com.qafox.pages.ForgotPasswordPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class ForgotPasswordTests extends TestBase {

    //tests
    @Test
    public void forgotPasswordValidEmail(){
        new ForgotPasswordPage(DriverManager.getDriver())
                .navigateToForgotPasswordPage()
                .enterEmail(testData.getJsonData("loginCredentials.validEmail"))
                .clickContinueButton()
                .validateEmailConfirmationMessage();
    }

    @Test
    public void forgotPasswordInvalidEmail(){
        new ForgotPasswordPage(DriverManager.getDriver())
                .navigateToForgotPasswordPage()
                .enterEmail(testData.getJsonData("invalidemail@domain.com"))
                .clickContinueButton()
                .validateInvalidEmailErrorMessage();

    }

}
