package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Service;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@Service
public class Scrollers
{
    @LazyAutowired
    private JavascriptExecutor js;

    public boolean scrollToElement(WebElement element)
    {
        try
        {
            js.executeScript("arguments[0].scrollIntoView();", element);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean scrollToCoordinates(String x, String y)
    {
        try
        {
            js.executeScript("window.scrollBy(" + x + "," + y + ")");
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }

    public boolean scrollVertically(String pixelOffset)
    {
        try
        {
            js.executeScript("window.scrollBy(0,"+pixelOffset+")");
            return true;
        } catch (Exception e)
        {
            return false;
        }

    }

    public boolean scrollToBottomPage()
    {
        try
        {
            js.executeScript("window.scrollBy(0,document.body.scrollHeight");
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
