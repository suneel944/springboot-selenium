package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@LazyService
@Log4j2
public class State
{
    @LazyAutowired
    private JavascriptExecutor js;

    public boolean isElementEnabled(WebElement element)
    {
        try
        {
            log.info("verifying whether element is enabled");
            boolean result = element.isEnabled();
            log.info("verified: element is {}", result?"enabled": "not enabled");
            return result;
        } catch (Exception e)
        {
            log.error("failed to verify element is enabled {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean isElementClickable(WebElement element)
    {
        try
        {
            log.info("verifying whether element is clickable");
            boolean result = element.isDisplayed() && element.isEnabled();
            log.info("verified: element is {}", result?"clickable": "not clickable");
            return result;
        } catch (Exception e)
        {
            log.error("failed to verify element is clickable {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean isPageLoaded()
    {
        try
        {
            log.info("verifying if page load is completed");
            boolean result = this.js.executeScript("return document.readyState").equals("complete");
            log.info("verified: page load is {}", result?"completed":"not completed");
            return result;
        } catch (Exception e)
        {
            log.error("failed to verify if page load is completed {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }
}
