package com.qafox.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Validations {

    private Validations(){

    }
    @Step("Validate true")
    public static void validateTrue(boolean condition , String message){
        Assert.assertTrue(condition,message);
        LogsUtil.info("Validating the Condition is true");

    }
    @Step("Validate false")
    public static void validateFalse(boolean condition , String message){
        Assert.assertFalse(condition,message);
    }
    @Step("Validate equals")
    public static void validateEquals(String actual , String expected , String message){
        Assert.assertEquals(actual,expected,message);
        LogsUtil.info("Validating that actual value: '" + actual + "' matches expected value: '" + expected + "'.");    }
    @Step("Validate not equals")
    public static void validateNotEquals(String actual , String expected , String message){
        Assert.assertNotEquals(actual,expected,message);
    }
    @Step("Validate page url: {expected}")
    public static void validatePageUrl(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getCurrentUrl(driver), expected);
    }
    @Step("Validate page title: {expected}")
    public static void validatePageTitle(WebDriver driver, String expected){
        Assert.assertEquals(BrowserActions.getPageTitle(driver), expected);
    }

}
