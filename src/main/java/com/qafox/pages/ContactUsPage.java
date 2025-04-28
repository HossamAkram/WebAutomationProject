package com.qafox.pages;

import com.qafox.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
    //variables
    WebDriver driver;
    //constructor
    public ContactUsPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By nameField = By.id("input-name");
    private By emailField = By.id("input-email");
    private By enquiryField = By.id("input-enquiry");
    private By submitButton = By.cssSelector("input.btn.btn-primary");
    private By nameErrorMsg = By.xpath("//div[@class='text-danger' and contains(text(),'Name must be')]");
    private By emailErrorMsg = By.xpath("//div[@class='text-danger' and contains(text(),'E-Mail Address')]");
    private By enquiryErrorMsg = By.xpath("//div[@class='text-danger' and contains(text(),'Enquiry must be')]");


    //navigate to page
    @Step("Navigate to Contact Us page")
    public ContactUsPage navigateToContactUsPage() {
        BrowserActions.navigateToUrl(driver, PropertiesUtil.getPropertyValue("contactUsPage"));
        return this;
    }


    //actions
    @Step("Enter name: {name}")
    public ContactUsPage enterName(String name) {
        ElementActions.sendData(driver, nameField, name);
        return this;
    }

    @Step("Enter email: {email}")
    public ContactUsPage enterEmail(String email) {
        ElementActions.sendData(driver, emailField, email);
        return this;
    }

    @Step("Enter enquiry: {enquiry}")
    public ContactUsPage enterEnquiry(String enquiry) {
        ElementActions.sendData(driver, enquiryField, enquiry);
        return this;
    }

    @Step("Click Submit button")
    public ContactUsPage clickSubmit() {
        ElementActions.click(driver, submitButton);
        return this;
    }

    //validations
    @Step("Validate name error message is displayed correctly")
    public ContactUsPage validateNameErrorMessage() {
        String actualText = ElementActions.getText(driver,nameErrorMsg);
        String expectedText = PropertiesUtil.getPropertyValue("invalidNameFieldMessage");
        CustomSoftAssertion.softAssertion.assertEquals(actualText, expectedText, "Name error message mismatch");
        return this;
    }

    @Step("Validate email error message is displayed correctly")
    public ContactUsPage validateEmailErrorMessage() {
        String actualText = ElementActions.getText(driver,emailErrorMsg);
        String expectedText = PropertiesUtil.getPropertyValue("invalidEmailFieldMessage");
        CustomSoftAssertion.softAssertion.assertEquals(actualText, expectedText, "Email error message mismatch");
        return this;
    }

    @Step("Validate enquiry error message is displayed correctly")
    public ContactUsPage validateEnquiryErrorMessage() {
        String actualText = ElementActions.getText(driver,enquiryErrorMsg);
        String expectedText = PropertiesUtil.getPropertyValue("invalidEnquiryFieldMessage");
        CustomSoftAssertion.softAssertion.assertEquals(actualText, expectedText, "Enquiry error message mismatch");
        return this;
    }
    @Step("Validate successful Contact Us submission by checking the URL")
    public ContactUsPage validateSuccessfulSubmissionUrl() {
        String actualUrl = BrowserActions.getCurrentUrl(driver);
        String expectedUrl = PropertiesUtil.getPropertyValue("contactUsSuccess");
        Validations.validateEquals(actualUrl, expectedUrl, "The Contact Us success URL is not as expected!");
        return this;
    }


}
