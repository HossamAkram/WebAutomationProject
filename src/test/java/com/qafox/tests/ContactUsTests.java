package com.qafox.tests;

import com.qafox.drivers.DriverManager;
import com.qafox.pages.ContactUsPage;
import org.testng.annotations.Test;

public class ContactUsTests extends TestBase {

    @Test(description = "Valid submission with correct data")
    public void testValidContactUsSubmission() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateSuccessfulSubmissionUrl();
    }

    @Test(description = "Missing name field")
    public void testMissingNameField() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName("")
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateNameErrorMessage();
    }

    @Test(description = "Missing email field")
    public void testMissingEmailField() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail("")
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateEmailErrorMessage();
    }

    @Test(description = "Missing enquiry field")
    public void testMissingEnquiryField() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry("")
                .clickSubmit()
                .validateEnquiryErrorMessage();
    }

    @Test(description = "Name too short")
    public void testNameTooShort() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.shortName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateNameErrorMessage();
    }

    @Test(description = "Name too long")
    public void testNameTooLong() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.longName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateNameErrorMessage();
    }

    @Test(description = "Invalid email format")
    public void testInvalidEmailFormat() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail(testData.getJsonData("contactUs.invalidEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.validEnquiry"))
                .clickSubmit()
                .validateEmailErrorMessage();
    }

    @Test(description = "Enquiry too short")
    public void testEnquiryTooShort() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.shortEnquiry"))
                .clickSubmit()
                .validateEnquiryErrorMessage();
    }

   /* @Test(description = "Enquiry too long", priority = 1)
    public void testEnquiryTooLong() {
        new ContactUsPage(DriverManager.getDriver())
                .navigateToContactUsPage()
                .enterName(testData.getJsonData("contactUs.validName"))
                .enterEmail(testData.getJsonData("contactUs.validEmail"))
                .enterEnquiry(testData.getJsonData("contactUs.longEnquiry"))
                .clickSubmit()
                .validateEnquiryErrorMessage();
    }*/

}
