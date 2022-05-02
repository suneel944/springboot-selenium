package com.auto.spring.springselenium.framework.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.context.annotation.Profile;
import com.auto.spring.springselenium.framework.annotations.ThreadScopeBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@Profile("!remote")
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
