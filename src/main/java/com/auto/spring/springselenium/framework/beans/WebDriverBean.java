package com.auto.spring.springselenium.framework.beans;

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
