package com.springpet.driver;

import java.io.IOException;
import java.util.Properties;

public class DriverProperties {
    public static final String BROWSER_NAME = "browserName";

    private DriverProperties() {
    }

    public static String getProperty(final String name) {
        try {
            final Properties props = new Properties();
            props.load(DriverProperties.class.getResourceAsStream("/browser.properties"));

            final String property = props.getProperty(name);
            if (property == null) {
                throw new IllegalArgumentException("Could not read property");
            }
            return property;
        }
        catch (IOException e) {
            throw new IllegalStateException();
        }
    }
}

