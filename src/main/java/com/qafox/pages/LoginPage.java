package com.qafox.pages;

import com.qafox.utils.BrowserActions;
import com.qafox.utils.ElementActions;
import com.qafox.utils.PropertiesUtil;
import com.qafox.utils.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    //variables
    WebDriver driver;

    //constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    //navigate to page
    public LoginPage navigateToLoginPage(){
        BrowserActions.navigateToUrl(driver,PropertiesUtil.getPropertyValue("loginPage"));
        return this;
    }

    //locators
    private By email=By.id("input-email");
    private By password=By.id("input-password");
    private By continueButton =By.cssSelector("input.btn.btn-primary");
    private By errorMessage = By.cssSelector("div.alert.alert-danger.alert-dismissible");


    //actions
    @Step("Enter email {0}")
    public LoginPage enterEmail(String email) {
        ElementActions.sendData(driver, this.email, email);
        return this;
    }

    @Step("Enter password {0}")
    public LoginPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    @Step("Click on the login button")
    public LoginPage clickLoginButton() {
        ElementActions.click(driver, continueButton);
        return this;
    }

    //validations

    @Step("Validate login error message")
    public LoginPage validateLoginErrorMessage() {
        String expectedMessage = "Warning: No match for E-Mail Address and/or Password.";
        String actualMessage = ElementActions.getText(driver, By.cssSelector("div.alert.alert-danger.alert-dismissible"));
        Validations.validateEquals(actualMessage, expectedMessage, "Login error message validation");
        return this;
    }

    public void validateRedirectionToAcountPage(){

        Validations.validatePageUrl(driver,PropertiesUtil.getPropertyValue("acountPage"));
    }

}
