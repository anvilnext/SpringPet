package com.springpet;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {FrameworkConfiguration.class})
@CucumberContextConfiguration
public class CucumberTestContextConfiguration {

}
