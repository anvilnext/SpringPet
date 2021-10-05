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
public class ShoppingCartPage {

    private WebDriver driver;

/*    public ShoppingCartPage(driver) {
        PageFactory.initElements(driver, this);
    }*/

    public static final String SHOPPING_CART_ITEM_LABEL = "//div[@class='inventory_item_name'][text()='%s']";

    @FindBy(xpath = SHOPPING_CART_ITEM_LABEL)
    private WebElement shoppingCartItemLabel;

    public boolean checkProductIsInCart(String product) {
        return driver.findElement(By.xpath(format(SHOPPING_CART_ITEM_LABEL, product))).isDisplayed();
    }
}
