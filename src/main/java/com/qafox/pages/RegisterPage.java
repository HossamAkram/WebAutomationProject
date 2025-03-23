package com.qafox.pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qafox.utils.*;
public class RegisterPage {
    //variables
    WebDriver driver;
    //constructor
    public  RegisterPage(WebDriver driver){
        this.driver=driver;
    }

    //navigate to register page
    public RegisterPage navigateToRegisterPage(){
        BrowserActions.navigateToUrl(driver,PropertiesUtil.getPropertyValue("registerPage"));
        return this;
    }

    //locators
    private By firstName=By.id("input-firstname");
    private By lastName=By.id("input-lastname");
    private By email=By.id("input-email");
    private By telephone=By.id("input-telephone");
    private By password=By.id("input-password");
    private By confirmPassword=By.id("input-confirm");
    private By TermsCheckButton=By.cssSelector("input[name='agree']");
    private By continueButton =By.cssSelector("input.btn.btn-primary");
    private By myAccountDropdown = By.cssSelector("a[title='My Account']");
    private By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");


    //actions
    @Step("Enter first name {0}")
    public RegisterPage enterFirstName(String firstName) {
        ElementActions.sendData(driver, this.firstName, firstName);
        return this;
    }

    @Step("Enter last name {0}")
    public RegisterPage enterLastName(String lastName) {
        ElementActions.sendData(driver, this.lastName, lastName);
        return this;
    }

    @Step("Enter email {0}")
    public RegisterPage enterEmail(String email) {
        ElementActions.sendData(driver, this.email, email);
        return this;
    }
    @Step("Enter telephone number: {0}")
    public RegisterPage enterTelephone(String telephoneNumber) {
        ElementActions.sendData(driver, telephone, telephoneNumber);
        return this;
    }

    @Step("Enter password {0}")
    public RegisterPage enterPassword(String password) {
        ElementActions.sendData(driver, this.password, password);
        return this;
    }

    @Step("Confirm password {0}")
    public RegisterPage confirmPassword(String confirmPassword) {
        ElementActions.sendData(driver, this.confirmPassword, confirmPassword);
        return this;
    }
    @Step("Toggle terms and conditions checkbox")
    public RegisterPage toggleTermsCheckButton() {
        ElementActions.click(driver, TermsCheckButton);
        return this;
    }

    @Step("Click on the continue button")
    public RegisterPage clickContinueButton() {
        ElementActions.click(driver, continueButton);
        return this;
    }


    @Step("Click on My Account dropdown")
    public RegisterPage clickMyAccountDropdown() {
        ElementActions.click(driver, myAccountDropdown);
        return this;
    }

    @Step("Click on '{option}' from My Account dropdown")
    public RegisterPage clickMyAccountOption(String option) {
        By optionLocator = By.xpath("//li[@class='dropdown open']//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='" + option + "']");
        ElementActions.click(driver, optionLocator);
        return this;
    }


    //validations
    public void validateRedirectionToAcountCreatedPage(){
        Validations.validatePageUrl(driver,PropertiesUtil.getPropertyValue("acountCreatedPage"));

    }
    public RegisterPage validateSuccessMessage(){
        Validations.validateEquals(ElementActions.getText(driver, successMessage), "Your Account Has Been Created!","Wrong redirection");
        return this;
    }


}

