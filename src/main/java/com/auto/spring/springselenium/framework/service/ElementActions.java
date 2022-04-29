package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class ElementActions
{
    @Lazy
    @Autowired
    private JavascriptExecutor js;

    public boolean clickOnElement(WebElement element)
    {
        try
        {
            element.click();
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean clickOnElementUsingJs(WebElement element)
    {
        try
        {
            this.js.executeScript("arguments[0].click();",element);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean selectFromDropDownByValue(WebElement element, String value)
    {
        try
        {
            Select select = new Select(element);
            select.selectByValue(value);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean selectFromDropDownByIndex(WebElement element, int index)
    {
        try
        {
            Select select = new Select(element);
            select.selectByIndex(index);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean deSelectFromDropDownByValue(WebElement element, String value)
    {
        try
        {
            Select select = new Select(element);
            select.deselectByValue(value);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean deSelectFromDropDownByIndex(WebElement element, int index)
    {
        try
        {
            Select select = new Select(element);
            select.deselectByIndex(index);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}