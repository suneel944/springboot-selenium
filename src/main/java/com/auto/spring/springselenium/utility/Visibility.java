package com.auto.spring.springselenium.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;
import org.openqa.selenium.NoSuchElementException;

@Component
public class Visibility
{
    public static boolean isElementDisplayed(WebElement element)
    {
        try
        {
            return element.isDisplayed();
        } catch (NoSuchElementException e)
        {
            return false;
        }
    }
}