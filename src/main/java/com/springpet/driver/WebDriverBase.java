package com.springpet.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBase {
    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        if (driver == null)
        {
            System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.logfile", "/log.log");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
