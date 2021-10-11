package com.springpet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class ShoppingCartPage implements WebPage {

    @Autowired
    private WebDriver driver;

    public static final String SHOPPING_CART_ITEM_LABEL = "//div[@class='inventory_item_name'][text()='%s']";

    public boolean checkProductIsInCart(String product) {
        return driver.findElement(By.xpath(format(SHOPPING_CART_ITEM_LABEL, product))).isDisplayed();
    }
}
