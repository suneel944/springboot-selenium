package com.auto.spring.springselenium.utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class State
{

    @Lazy
    @Autowired
    private JavascriptExecutor js;

    public static boolean isElementEnabled(WebElement element)
    {
        try
        {
            return element.isEnabled();
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean isElementClickable(WebElement element)
    {
        try
        {
            return element.isDisplayed() && element.isEnabled();
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean isPageLoaded()
    {
        try
        {
            return this.js.executeScript("return document.readyState").equals("complete");
        } catch (Exception e)
        {
            return false;
        }
    }
}
