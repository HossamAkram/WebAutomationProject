package com.qafox.pages;

import com.qafox.utils.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    //variables
    WebDriver driver;

    //constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By searchBox = By.cssSelector("input[name='search'].form-control.input-lg");
    private By searchButton = By.cssSelector("button.btn.btn-default.btn-lg");
    private By currencyDropdown = By.cssSelector("button.btn.btn-link.dropdown-toggle");
    private By wishlistLink = By.id("wishlist-total");
    private By shoppingCartLink = By.xpath("//a[@title='Shopping Cart']");
    //private By checkoutLink = By.xpath("//a[@title='Checkout']");
    private By cartDropdownButton = By.id("cart-total");
    private By addToCartButton = By.xpath("//button[contains(@onclick, 'cart.add')]");
    private By addToWishListButton = By.xpath("//button[contains(@onclick, 'wishlist.add')]");
    private By compareProductButton = By.xpath("//button[contains(@onclick, 'compare.add')]");
    private By addedToComparisonListMessage = By.cssSelector("div.alert.alert-success.alert-dismissible");
    private By productComparisonLink = By.xpath("//a[contains(@href, 'product/compare')]");
    private By priceElement = By.cssSelector("div.caption p.price");


    //navigate to page
    public HomePage navigateToHomePage(){
        BrowserActions.navigateToUrl(driver,PropertiesUtil.getPropertyValue("homePage"));
        return this;
    }

    //actions
    @Step("Click on currency dropdown")
    public HomePage clickCurrencyDropdown() {
        ElementActions.click(driver, currencyDropdown);
        return this;
    }

    @Step("Select currency: {0}")
    public HomePage selectCurrency(String currency) {
        driver.findElement(By.xpath("//button[@name='" + currency + "']")).click();
        return this;
    }

    @Step("Add product {productName} to cart")
    public HomePage addProductToCart(String productName) {
        By productAddToCartButton = By.xpath("//div[contains(@class, 'product-thumb')]//h4/a[normalize-space(text())='" + productName + "']/ancestor::div[contains(@class, 'product-thumb')]//button[contains(@onclick, 'cart.add')]");
        ElementActions.click(driver, productAddToCartButton);
        return this;
    }


    @Step("Add product to wishlist")
    public HomePage addProductToWishlist() {
        ElementActions.click(driver, addToWishListButton);
        return this;
    }

    @Step("Add product to comparison")
    public HomePage addProductToComparison() {
        ElementActions.click(driver, compareProductButton);
        return this;
    }
    @Step("Click on Wishlist link")
    public HomePage clickWishlistLink() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ElementActions.click(driver, wishlistLink);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Click on Shopping Cart link")
    public HomePage clickShoppingCartLink() {
        ElementActions.click(driver, shoppingCartLink);
        return this;
    }

    @Step("Click on Compare List link")
    public HomePage clickCompareListLink() {
        ElementActions.click(driver, productComparisonLink);
        return this;
    }


    @Step("Search for a product")
    public HomePage searchForProduct(String productName) {
        ElementActions.sendData(driver, searchBox, productName);
        return this;
    }

    @Step("Click search button")
    public HomePage clickSearchButton() {
        ElementActions.click(driver, searchButton);
        return this;
    }


    //validations
    @Step("Validate cart items")
    public HomePage validateCartItems(String expectedCount) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("cart-total"), expectedCount));
        String actualText = ElementActions.getText(driver, cartDropdownButton);
        Validations.validateEquals(actualText, expectedCount, "Cart item count mismatch!");
        return this;
    }

    @Step("Validate redirection to Wishlist page")
    public HomePage validateWishlistPage() {
        Validations.validatePageUrl(driver, PropertiesUtil.getPropertyValue("wishlistPage"));
        return this;
    }

    @Step("Validate redirection to Shopping Cart page")
    public HomePage validateShoppingCartPage() {
        Validations.validatePageUrl(driver, PropertiesUtil.getPropertyValue("shoppingCartPage"));
        return this;
    }

    @Step("Validate search results for product: {productName}")
    public HomePage validateSearchResults(String productName) {
        By searchResult = By.xpath("//h4/a[text()='" + productName + "']");
        String actualProductName = ElementActions.getText(driver, searchResult);
        Validations.validateEquals(actualProductName, productName, "Product name mismatch!");
        return this;
    }

    @Step("Validate the success message for adding a product to the comparison list")
    public HomePage validateAddedToComparisonListMessage() {
        String expectedMessage = "Success: You have added";
        String actualMessage = ElementActions.getText(driver,addedToComparisonListMessage);
        Validations.validateTrue(actualMessage.contains(expectedMessage), "The comparison success message is not displayed!");
        return this;
    }
    @Step("Validate redirection to Product Comparison page")
    public void validateProductComparisonPage() {
        Validations.validatePageUrl(driver, PropertiesUtil.getPropertyValue("productComparisonPage"));
    }
    @Step("Validate that the currency has changed to {currencySymbol}")
    public HomePage validateCurrencyChanged(String currencySymbol) {
        Waits.waitForElementPresence(driver,priceElement);
        String priceText = ElementActions.getText(driver,priceElement);
        Validations.validateTrue(priceText.contains(currencySymbol), "Currency not changed to " + currencySymbol);
        return this;
    }


}
