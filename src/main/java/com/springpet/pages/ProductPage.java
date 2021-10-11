package com.springpet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ProductPage implements WebPage {

    @Autowired
    private WebDriver driver;

    public static final String ADD_TO_CART_BUTTON = "//div[@class='inventory_item_name'][text()='%s']//ancestor::div[@class='inventory_item']//button";
    public static final String SHOPPING_CART_LABEL = "//a[@class='shopping_cart_link']";

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