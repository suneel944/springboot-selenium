package com.auto.spring.springselenium.runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/java/com/auto/spring/springselenium/bdd/features",
        glue = "com.auto.spring.springselenium.bdd",
        tags = "@amazon",
        plugin = {
                "pretty",
                "json:temp/reports/json/report.json",
                "html:temp/reports/html/report.html"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object [][] scenarios() {
        return super.scenarios();
    }
}