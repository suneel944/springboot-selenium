package com.auto.spring.springselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import com.auto.spring.springselenium.annotations.LazyConfiguration;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
public class WebDriverConfig
{
    @Bean
    @Scope("browserscope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public  WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return  new FirefoxDriver();
    }

    @Bean
    @Scope("browserscope")
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
