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

    public void scrollToElement(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public void scrollToCoordinates(String x, String y)
    {
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void scrollVertically(String pixelOffset)
    {
        js.executeScript("window.scrollBy(0,"+pixelOffset+")");
    }

    public void scrollToBottomPage()
    {
        js.executeScript("window.scrollBy(0,document.body.scrollHeight");
    }
}
