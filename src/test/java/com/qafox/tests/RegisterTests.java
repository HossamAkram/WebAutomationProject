package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.listeners.TestNGListeners;
import com.qafox.pages.RegisterPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListeners.class)
public class RegisterTests extends TestBase {

    // Tests
    @Test
    public void registerWithEmptyForm() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .clickContinueButton();
    }

    @Test
    public void registerWithMissingFirstName() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public void registerWithMissingLastName() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public void registerWithMissingEmail() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public void registerWithMissingTelephone() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public void registerWithMissingPassword() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public void registerWithMissingConfirmPassword() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public void registerWithMismatchedPasswords() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword("DifferentPassword123")
                .toggleTermsCheckButton()
                .clickContinueButton();
    }

    @Test
    public LoginTests registerWithValidData() {
        new RegisterPage(DriverManager.getDriver())
                .navigateToRegisterPage()
                .enterFirstName(testData.getJsonData("registerCredentials.user1.firstName"))
                .enterLastName(testData.getJsonData("registerCredentials.user1.lastName"))
                .enterEmail(testData.getJsonData("registerCredentials.user1.validEmail"))
                .enterTelephone(testData.getJsonData("registerCredentials.user1.telephone"))
                .enterPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .confirmPassword(testData.getJsonData("registerCredentials.user1.validPassword"))
                .toggleTermsCheckButton()
                .clickContinueButton()
                .clickMyAccountDropdown()
                .clickMyAccountOption("Logout");

        // .validateRedirectionToAcountCreatedPage();
        return new LoginTests();
    }
}
