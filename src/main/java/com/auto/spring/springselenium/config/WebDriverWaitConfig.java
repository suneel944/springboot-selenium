package com.auto.spring.springselenium.config;

import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.time.Duration;

@Lazy
@Configuration
public class WebDriverWaitConfig
{
    @Value("${default.timeout:60}")
    private long timeOut;

    @Bean
    public WebDriverWait webDriverWait(WebDriver driver)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeOut));
    }
}
