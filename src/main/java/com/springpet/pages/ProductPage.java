package com.springpet.pages;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
@RequiredArgsConstructor
public class ProductPage {

    private WebDriver driver;

/*    public ProductPage(driver) {
        PageFactory.initElements(driver, this);
    }*/

    public static final String ADD_TO_CART_BUTTON = "//div[@class='inventory_item_name'][text()='%s']//ancestor::div[@class='inventory_item']//button";
    public static final String SHOPPING_CART_LABEL = "//a[@class='shopping_cart_link']";

    @FindBy(xpath = ADD_TO_CART_BUTTON)
    private WebElement addToCartButton;

    @FindBy(xpath = SHOPPING_CART_LABEL)
    private WebElement shoppingCartLabel;

    public void addToCart(String product) {
        driver.findElement(By.xpath(format(ADD_TO_CART_BUTTON, product))).click();
    }

    public ShoppingCartPage openShoppingCart() {
        shoppingCartLabel.click();
        return new ShoppingCartPage();
    }

    public boolean checkUrlOnMainPage(String ending) {
        return driver.getCurrentUrl().endsWith(ending);
    }
}