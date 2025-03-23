package com.qafox.pages;

import com.qafox.utils.ElementActions;
import com.qafox.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcountCreatedPage {
    //variables
    WebDriver driver;

    //constructor
    public AcountCreatedPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    By continueButton = By.cssSelector("a.btn.btn-primary");
    By successMessage = By.xpath("//h1[text()='Your Account Has Been Created!']");

    //actions


    //validations


}
