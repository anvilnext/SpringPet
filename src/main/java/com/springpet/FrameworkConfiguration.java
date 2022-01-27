package com.springpet;

import com.springpet.yaml.EnvConfig;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;

@Configuration
@ComponentScan(basePackages = "com.springpet")
@ConfigurationPropertiesScan(basePackages = "com.springpet")
@EnableConfigurationProperties
public class FrameworkConfiguration {

    @Getter
    @Autowired
    private EnvConfig envConfig;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public WebDriver driver()
    {
        return Match(envConfig.getBrowser()).of(
                Case($("firefox"), () -> {
                    System.setProperty("webdriver.gecko.driver", "webdrivers/geckodriver.exe");
                    System.setProperty("webdriver.gecko.logfile", "/log.log");
                    System.setProperty("webdriver.gecko.verboseLogging", "true");
                    return new FirefoxDriver();
                }),
                Case($("chrome"), () -> {
                    System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
                    System.setProperty("webdriver.chrome.logfile", "/log.log");
                    System.setProperty("webdriver.chrome.verboseLogging", "true");
                    return new ChromeDriver();
                })
        );
    }
}
