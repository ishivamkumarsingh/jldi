package com.nopcommerce.util;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.nopcommerce.stepdefinitions",
        plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json", 
                  "html:target/cucumber-reports/index.html"},
        monochrome = true,
        publish = true
)
public class CucumberRunner {
}


