package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@LazyService
@Log4j2
public class Launcher
{
    @LazyAutowired
    private WebDriver driver;

    public boolean launchUrl(String url)
    {
        try
        {
            log.info("launching url {}", url);
            this.driver.get(url);
            log.info("launched url {}", url);
            return true;
        } catch (Exception e)
        {
            log.error("failed to launch url {} : {}", url, e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }
}
