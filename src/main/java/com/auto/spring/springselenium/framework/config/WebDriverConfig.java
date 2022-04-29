package com.auto.spring.springselenium.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.auto.spring.springselenium.framework.scope.ThreadScopeBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@LazyConfiguration
public class WebDriverConfig
{
    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public  WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return  new FirefoxDriver();
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
