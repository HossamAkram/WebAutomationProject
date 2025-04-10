package com.qafox.pages;

import com.qafox.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    //variables
    WebDriver driver;

    //constructor
    public ForgotPasswordPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By email=By.id("input-email");
    private By continueButton =By.cssSelector("input.btn.btn-primary");
    private By emailConfirmationMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
    private By invalidEmailErrorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");
    private By myAccountDropdown = By.cssSelector("a[title='My Account']");
    private By logoutOption = By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']");


    //navigate to page
    @Step("Navigate to forgot password page")
    public ForgotPasswordPage navigateToForgotPasswordPage(){
        //ElementActions.click(driver,myAccountDropdown);
        //ElementActions.click(driver,logoutOption);
        BrowserActions.navigateToUrl(driver,PropertiesUtil.getPropertyValue("forgotPasswordPage"));
        return this;
    }
    //actions
    @Step("Enter email {0}")
    public ForgotPasswordPage enterEmail(String email) {
        ElementActions.sendData(driver, this.email, email);
        return this;
    }


    @Step("Click on the continue button")
    public ForgotPasswordPage clickContinueButton() {
        ElementActions.click(driver, continueButton);
        return this;
    }

    //validations
    @Step("Validate that the confirmation email message is displayed")
    public ForgotPasswordPage validateEmailConfirmationMessage() {
        String actualMessage = ElementActions.getText(driver, emailConfirmationMessage);
        String expectedMessage = "An email with a confirmation link has been sent your email address.";
        Validations.validateEquals(actualMessage, expectedMessage, "The confirmation message is not as expected!");
        return this;
    }

    @Step("Validate that the invalid email error message is displayed")
    public ForgotPasswordPage validateInvalidEmailErrorMessage() {
        Waits.waitForElementPresence(driver,invalidEmailErrorMessage);
        String actualMessage = ElementActions.getText(driver, invalidEmailErrorMessage);
        String expectedMessage = "Warning: The E-Mail Address was not found in our records, please try again!";
        Validations.validateEquals(actualMessage, expectedMessage, "The error message is not as expected!");
        return this;
    }

}
