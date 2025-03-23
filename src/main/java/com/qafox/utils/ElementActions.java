package com.qafox.utils;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ElementActions {
    private ElementActions(){

    }
    @Step("sending data: {data} to the element {locator}")
    public static void sendData(WebDriver driver, By locator, String data){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver, locator).sendKeys(data);
        LogsUtil.info("data entered",data," in the field",locator.toString());
    }
    @Step("clicking the {locator} element")
    public static void click(WebDriver driver, By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        findElement(driver,locator).click();
        LogsUtil.info("clicked on element",locator.toString());
    }
    @Step("Getting text from {locator} element")
    public static String getText(WebDriver driver, By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        LogsUtil.info("getting text from ", locator.toString()," text:", findElement(driver,locator).getText());
        return findElement(driver,locator).getText();
    }

    public static String getValue(WebDriver driver,By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        LogsUtil.info("getting value from ", locator.toString()," text:", findElement(driver,locator).getDomAttribute("value"));
        return findElement(driver,locator).getDomAttribute("value");

    }

    public static String getType(WebDriver driver,By locator){
        Waits.waitForElementClickability(driver,locator);
        Scrolling.scrollToElement(driver,locator);
        LogsUtil.info("getting type from ", locator.toString()," text:", findElement(driver,locator).getDomAttribute("type"));
        return findElement(driver,locator).getDomAttribute("type");
    }

    public static WebElement findElement(WebDriver driver, By locator){
        LogsUtil.info("finding element", locator.toString());
        return driver.findElement(locator);
    }

    public static List<WebElement> findElements(WebDriver driver, By locator){
        LogsUtil.info("finding element", locator.toString());
        return driver.findElements(locator);
    }

    public static void select(WebDriver driver,By locator,String value){
        WebElement element = findElement(driver,locator);
        Select select = new Select(element);
        select.selectByValue(value);

    }
    public static void hover(WebDriver driver, By locator) {
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(locator);
        actions.moveToElement(element).perform();
    }
}
