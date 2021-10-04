package com.springpet.basesteps;

import com.springpet.driver.WebDriverBase;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class DriverBaseSteps {

    private static WebDriver driver = WebDriverBase.getDriver();

    public static void maximizeDriver() {
        driver.manage().window().maximize();
    }

    public static void quitDriver() {
        driver.quit();
    }
}