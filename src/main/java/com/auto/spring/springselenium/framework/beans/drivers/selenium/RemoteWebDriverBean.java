package com.auto.spring.springselenium.framework.beans.drivers.selenium;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.framework.service.BrowserOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;
import com.auto.spring.springselenium.framework.annotations.others.LazyConfiguration;
import com.auto.spring.springselenium.framework.annotations.parallelexecution.ThreadScopeBean;

@Profile("remote")
@LazyConfiguration
public class RemoteWebDriverBean
{
    @LazyAutowired
    private BrowserOptions browserOptions;

    @Value("${selenium.grid.url}")
    private URL url;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
        return new org.openqa.selenium.remote.RemoteWebDriver(this.url, browserOptions.getFirefoxOptions());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver(){
        return new org.openqa.selenium.remote.RemoteWebDriver(this.url, browserOptions.getChromeOptions());
    }
}