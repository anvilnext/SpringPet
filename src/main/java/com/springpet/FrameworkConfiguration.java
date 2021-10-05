package com.springpet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;

@Configuration
@ComponentScan(basePackages = "com.springpet")
@EnableConfigurationProperties
public class FrameworkConfiguration {

    @Bean
    public WebDriver driver()
    {
            System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.logfile", "/log.log");
            System.setProperty("webdriver.chrome.verboseLogging", "true");
            return new ChromeDriver();
    }
}
