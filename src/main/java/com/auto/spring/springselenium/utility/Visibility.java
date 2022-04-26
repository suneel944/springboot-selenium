package com.auto.spring.springselenium.utility;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

@Component
public class Visibility
{
    public boolean isElementDisplayed(WebElement element)
    {
        try
        {
            return element.isDisplayed();
        } catch (Exception e)
        {
            return false;
        }
    }
}