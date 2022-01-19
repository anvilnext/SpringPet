package com.springpet.pages;

import com.springpet.EnvConfig;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage implements WebPage {

    @Getter
    @Autowired
    private EnvConfig envConfig;

    @Autowired
    private WebDriver driver;

    public static final String USERNAME_INPUT = "//input[@placeholder='Username']";
    public static final String PASSWORD_INPUT = "//input[@placeholder='Password']";

    @FindBy(xpath = USERNAME_INPUT)
    private WebElement usernameInput;

    @FindBy(xpath = PASSWORD_INPUT)
    private WebElement passwordInput;

    public void openHomePage() {
        driver.navigate().to(envConfig.getAddress());
    }

    public ProductPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordInput.submit();
        return new ProductPage();
    }
}