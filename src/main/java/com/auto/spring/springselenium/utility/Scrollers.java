package com.auto.spring.springselenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Component;

@Component
public class Scrollers
{
    public static void scrollToElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void scrollToCoordinates(WebDriver driver, String x, String y)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public static void scrollVertically(WebDriver driver, String pixelOffset)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixelOffset+")");
    }

    public static void scrollToBottomPage(WebDriver driver)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight");
    }
}
