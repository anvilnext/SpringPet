package com.springpet.basesteps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverBaseSteps {

    @Autowired
    private WebDriver driver;

    public void maximizeDriver() {
        driver.manage().window().maximize();
    }

    public void quitDriver() {
        driver.quit();
    }
}
