package com.auto.spring.springselenium.bdd;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import com.auto.spring.springselenium.framework.service.Screenshots;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

public class Hooks
{
    @LazyAutowired
    private Screenshots screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName());
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }
}
