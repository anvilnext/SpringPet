package com.springpet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "browser.properties")
public class HomePage implements WebPage {

    @Autowired
    private WebDriver driver;

    @Value("${address:}")
    private String address;

    public static final String USERNAME_INPUT = "//input[@placeholder='Username']";
    public static final String PASSWORD_INPUT = "//input[@placeholder='Password']";

    @FindBy(xpath = USERNAME_INPUT)
    private WebElement usernameInput;

    @FindBy(xpath = PASSWORD_INPUT)
    private WebElement passwordInput;

    public void openHomePage() {
        driver.navigate().to(address);
    }

    public ProductPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordInput.submit();
        return new ProductPage();
    }
}