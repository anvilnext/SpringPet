package com.springpet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.springpet")
@PropertySource(value = "browser.properties")
@EnableConfigurationProperties
public class FrameworkConfiguration {

    @Value("${browserName:}")
    private String browserName;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebDriver driver()
    {
        switch (browserName) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
                System.setProperty("webdriver.gecko.logfile", "/log.log");
                System.setProperty("webdriver.gecko.verboseLogging", "true");
                return new FirefoxDriver();

            case "chrome":
                System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                System.setProperty("webdriver.chrome.logfile", "/log.log");
                System.setProperty("webdriver.chrome.verboseLogging", "true");
                return new ChromeDriver();

            default:
                return null;
        }
    }
}
