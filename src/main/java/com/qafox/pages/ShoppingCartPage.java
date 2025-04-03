package com.qafox.pages;

import com.qafox.utils.ElementActions;
import com.qafox.utils.PropertiesUtil;
import com.qafox.utils.Validations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    //variables
    WebDriver driver;

    //constructor
    public ShoppingCartPage(WebDriver driver){
        this.driver=driver;
    }

    //locators
    private By productTotal = By.xpath("//table//td[contains(text(),'Total')]/following-sibling::td");
    private By shoppingCartTotal = By.xpath("//td[strong[text()='Total:']]/following-sibling::td");
    private By outOfStock = By.xpath("//td[@class='text-left']/span[@class='text-danger']");
    private By productsNotAvailableMessage = By.xpath("//div[contains(@class, 'alert-danger') and contains(text(), 'not available')]");
    private By checkoutButton = By.xpath("//a[@class='btn btn-primary' and text()='Checkout']");
    private By continueShoppingButton = By.xpath("//a[text()='Continue Shopping']");
    private By removeItemButton = By.xpath("//button[@class='btn btn-danger' and @data-original-title='Remove']");


    //navigate to page
    public ShoppingCartPage navigateToShoppingCartPage() {
        driver.get(PropertiesUtil.getPropertyValue("shoppingCartPage"));
        return this;
    }

    // Actions
    public ShoppingCartPage clickCheckoutButton() {
        ElementActions.click(driver, checkoutButton);
        return this;
    }

    public ShoppingCartPage clickContinueShoppingButton() {
        ElementActions.click(driver, continueShoppingButton);
        return this;
    }

    public ShoppingCartPage clickRemoveItem() {
        ElementActions.click(driver, removeItemButton);
        return this;
    }

    // Validations
    public ShoppingCartPage validateCartTotal() {
        String productTotalText = ElementActions.getText(driver, productTotal);
        String cartTotalText = ElementActions.getText(driver, shoppingCartTotal);

        Validations.validateEquals(productTotalText, cartTotalText, "Cart total does not match product total!");
        return this;
    }

    public ShoppingCartPage validateStockAndProceed() {
        if (!ElementActions.getElements(driver, outOfStock).isEmpty()) {
            Validations.validateEquals(
                    ElementActions.getText(driver, productsNotAvailableMessage),
                    "Products marked with *** are not available in the desired quantity or not in stock!\n",
                    "Out of stock message not displayed!");
            clickRemoveItem().clickContinueShoppingButton();
        } else {
            clickCheckoutButton();
        }
        return this;
    }
}




