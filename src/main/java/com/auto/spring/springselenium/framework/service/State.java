package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Service;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@Service
public class State
{

    @LazyAutowired
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
