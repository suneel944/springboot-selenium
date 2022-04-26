package com.auto.spring.springselenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class State
{
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
}
