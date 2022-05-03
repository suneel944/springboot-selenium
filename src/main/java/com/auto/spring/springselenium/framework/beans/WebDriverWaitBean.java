package com.auto.spring.springselenium.framework.beans;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;

@LazyConfiguration
public class WebDriverWaitBean
{
    @Value("${default.timeout:60}")
    private long timeOut;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public org.openqa.selenium.support.ui.WebDriverWait webDriverWait(WebDriver driver)
    {
        return new org.openqa.selenium.support.ui.WebDriverWait(driver, Duration.ofSeconds(this.timeOut));
    }
}
