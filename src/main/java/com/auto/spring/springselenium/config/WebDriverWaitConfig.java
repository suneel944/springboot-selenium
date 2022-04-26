package com.auto.spring.springselenium.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class WebDriverWaitConfig
{
    @Value("${default.timeout:60}")
    private long timeOut;

    @Autowired
    protected WebDriverWait wait;

    @Bean
    public WebDriverWait getWebDriverWait(WebDriver driver)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeOut));
    }
}
