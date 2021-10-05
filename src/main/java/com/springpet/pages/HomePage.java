package com.springpet.pages;

import com.springpet.data.BaseData;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HomePage {

    private WebDriver driver;

/*    public HomePage() {
        PageFactory.initElements(driver, this);
    }*/

    public static final String USERNAME_INPUT = "//input[@placeholder='Username']";
    public static final String PASSWORD_INPUT = "//input[@placeholder='Password']";

    @FindBy(xpath = USERNAME_INPUT)
    private WebElement usernameInput;

    @FindBy(xpath = PASSWORD_INPUT)
    private WebElement passwordInput;

    public void openHomePage() {
        driver.navigate().to(BaseData.SWAG);
    }

    public ProductPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        passwordInput.submit();
        return new ProductPage();
    }
}