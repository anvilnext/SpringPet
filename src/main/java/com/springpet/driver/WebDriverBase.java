//
//package com.springpet.driver;
//
//import lombok.RequiredArgsConstructor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.springframework.stereotype.Component;
//
//public class WebDriverBase {
//
//    private static WebDriver driver;
//
//    public static WebDriver getDriver()
//    {
//        if (driver == null)
//        {
//            final String browserName = DriverProperties.getProperty(DriverProperties.BROWSER_NAME);
//            switch (browserName) {
//                case "chrome":
//                    System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
//                    System.setProperty("webdriver.chrome.logfile", "/log.log");
//                    System.setProperty("webdriver.chrome.verboseLogging", "true");
//                    driver = new ChromeDriver();
//
//                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
//                    driver = new FirefoxDriver();
//            }
//        }
//        return driver;
//    }
//}
//
