package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@LazyService
@Log4j2
public class Visibility
{
    @LazyAutowired
    private WebDriver driver;

    @LazyAutowired
    private WebDriverWait wait;

    @LazyAutowired
    private ElementTypeConverter elementTypeConverter;

    public boolean isElementPresent(WebElement element)
    {
        try
        {
            log.info("verifying whether element is present in dom");
            driver.findElement(this.elementTypeConverter.returnByLocator(element));
            log.info("verified: element is present in dom");
            return true;
        } catch (Exception e)
        {
            log.error("failed to verify element presence {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element)
    {
        try
        {
            log.info("verifying whether element is displayed");
            boolean result = element.isDisplayed();
            log.info("verified: element is {}", result?"displayed": "not displayed");
            return result;
        } catch (Exception e)
        {
            log.error("failed to verify element visibility {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }
}