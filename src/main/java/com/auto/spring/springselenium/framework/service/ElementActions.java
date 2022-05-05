package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@LazyService
@Log4j2
public class ElementActions
{
    @LazyAutowired
    private JavascriptExecutor js;

    public boolean clickOnElement(WebElement element)
    {
        try
        {
            log.info("clicking on element");
            element.click();
            log.info("clicked on element");
            return true;
        } catch (Exception e)
        {
            log.error("failed to click on element: {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean clickOnElementUsingJs(WebElement element)
    {
        try
        {
            log.info("clicking on element using javascript");
            this.js.executeScript("arguments[0].click();",element);
            log.info("clicked on element using javascript");
            return true;
        } catch (Exception e)
        {
            log.error("failed to click on element using javascript: {}", e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean selectFromDropDownByValue(WebElement element, String value)
    {
        try
        {
            log.info("selecting from dropdown by value {}", value);
            Select select = new Select(element);
            select.selectByValue(value);
            log.info("selected from dropdown by value {}", value);
            return true;
        } catch (Exception e)
        {
            log.error("failed to select from dropdown by value {} : {}", value, e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean selectFromDropDownByIndex(WebElement element, int index)
    {
        try
        {
            log.info("selecting from dropdown by index {}", String.valueOf(index));
            Select select = new Select(element);
            select.selectByIndex(index);
            log.info("selected from dropdown by index {}", String.valueOf(index));
            return true;
        } catch (Exception e)
        {
            log.error("failed to select from dropdown by index {} : {}", String.valueOf(index), e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean deSelectFromDropDownByValue(WebElement element, String value)
    {
        try
        {
            log.info("deselecting from dropdown by value {}", value);
            Select select = new Select(element);
            select.deselectByValue(value);
            log.info("deselected from dropdown by value {}", value);
            return true;
        } catch (Exception e)
        {
            log.error("failed to deselect from dropdown by value {} : {}", value, e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public boolean deSelectFromDropDownByIndex(WebElement element, int index)
    {
        try
        {
            log.info("deselecting from dropdown by index {}", String.valueOf(index));
            Select select = new Select(element);
            select.deselectByIndex(index);
            log.info("deselected from dropdown by index {}", String.valueOf(index));
            return true;
        } catch (Exception e)
        {
            log.error("failed to deselect from dropdown by index {} : {}", String.valueOf(index), e.getMessage());
            log.debug("caught {}", e);
            return false;
        }
    }

    public String getTextFromElement(WebElement element)
    {
        try
        {
            log.info("fetching text from element");
            String text = element.getText();
            log.info("fetched text from element");
            return text;
        } catch (Exception e)
        {
            log.error("failed to fetch text from element {}", e.getMessage());
            log.debug("caught {}", e);
            return null;
        }
    }
}