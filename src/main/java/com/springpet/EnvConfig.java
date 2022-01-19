package com.springpet;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@Data
@PropertySource(
        value = "${config.location}",
        factory = YamlPropertySourceFactory.class
)
@EnableConfigurationProperties(EnvConfig.class)
@ConfigurationProperties("properties")
public class EnvConfig {
    private String browser;
    private String environment;
    private String address;
}
