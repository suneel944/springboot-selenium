package com.auto.spring.springselenium.framework.config;

import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.Profile;
import org.springframework.beans.factory.annotation.Value;
import com.auto.spring.springselenium.framework.annotations.ThreadScopeBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import com.auto.spring.springselenium.framework.annotations.LazyConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;

@Profile("remote")
@LazyConfiguration
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver(){
        return new RemoteWebDriver(this.url, new FirefoxOptions());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver(){
        return new RemoteWebDriver(this.url, new ChromeOptions());
    }
}