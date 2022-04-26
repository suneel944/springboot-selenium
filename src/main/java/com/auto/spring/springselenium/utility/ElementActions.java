package com.auto.spring.springselenium.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.stereotype.Component;


@Component
public class ElementActions
{
    public static boolean clickOnElement(WebElement element)
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

    public boolean clickOnElementUsingJs(WebDriver driver, WebElement element)
    {
        try
        {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
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