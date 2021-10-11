package com.springpet.configDTO;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "properties")
public class PropertiesDTO {
    private String browser;
    private String environment;
    private String address;
}
