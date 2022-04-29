package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Service;

@Service
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