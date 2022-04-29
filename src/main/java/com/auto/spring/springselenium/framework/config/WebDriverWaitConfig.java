package com.auto.spring.springselenium.framework.config;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;

@LazyConfiguration
public class WebDriverWaitConfig
{
    @Value("${default.timeout:60}")
    private long timeOut;

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public WebDriverWait webDriverWait(WebDriver driver)
    {
        return new WebDriverWait(driver, Duration.ofSeconds(this.timeOut));
    }
}
