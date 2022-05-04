package com.auto.spring.springselenium.framework.beans.drivers.selenium;

import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import com.auto.spring.springselenium.framework.annotations.others.LazyConfiguration;
import com.auto.spring.springselenium.framework.annotations.parallelexecution.ThreadScopeBean;

@Profile("!remote")
@LazyConfiguration
public class WebDriverBean
{
    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public org.openqa.selenium.WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return  new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public org.openqa.selenium.WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
