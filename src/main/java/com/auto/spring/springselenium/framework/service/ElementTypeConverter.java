package com.auto.spring.springselenium.framework.service;

import java.util.List;
import org.openqa.selenium.By;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.lang3.StringUtils;
import com.auto.spring.springselenium.framework.annotations.others.LazyService;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

@LazyService
@Log4j2
public class ElementTypeConverter
{
    @LazyAutowired
    private WebDriver driver;

    public WebElement returnWebElement(By element)
    {
        try
        {
            log.info("converting by locator to web element");
            WebElement ele = this.driver.findElement(element);
            log.info("converted by locator to web element");
            return ele;
        } catch (Exception e)
        {
            log.error("failed to convert by locator to web element : {}", e.getMessage());
            log.debug("caught {}", e);
            throw new RuntimeException("failed to convert by locator to web element");
        }
    }

    public List<WebElement> returnWebElements(By element)
    {
        try
        {
            log.info("converting by locator to web elements");
            List<WebElement> ele = this.driver.findElements(element);
            log.info("converted by locator to web elements");
            return ele;
        } catch (Exception e)
        {
            log.error("failed to convert by locator to web elements : {}", e.getMessage());
            log.debug("caught {}", e);
            throw new RuntimeException("failed to convert by locator to web elements");
        }
    }

    public By returnByLocator(WebElement element)
    {
        try
        {
        log.info("converting web element to by locator");
        String ele = element.toString().split(
                "(?=\\sid:\\s|\\sname:\\s|\\sselector:\\s|\\slink text:|\\sxpath:\\s|" +
                        "By.id:\\s|By.name:\\s|By.tagName:\\s|By.className:\\s|By.cssSelector:\\s|" +
                        "By.linkText:\\s|By.partialLinkText:\\s|By.xpath:\\s)")[1];
        String[] locator = StringUtils.removeEnd(ele, "]").split(":\\s");
        String method = locator[0].trim();
        if (method.equals("xpath"))
        {
            log.info("converted web element to By.xpath locator");
            return By.xpath(locator[1]);
        }
        String selector = StringUtils.removeEnd(locator[1], "'");
        switch (method)
        {
            case "id":
            case "By.id":
                log.info("converted web element to By.id locator");
                return By.id(selector);
            case "name":
            case "By.name":
                log.info("converted web element to By.name locator");
                return By.name(selector);
            case "By.tagName":
                log.info("converted web element to By.tagName locator");
                return By.tagName(selector);
            case "By.className":
                log.info("converted web element to By.className locator");
                return By.className(selector);
            case "selector":
            case "By.cssSelector":
                log.info("converted web element to By.cssSelector locator");
                return By.cssSelector(selector);
            case "By.linkText":
                log.info("converted web element to By.linkText locator");
                return By.linkText(selector);
            case "link text":
            case "By.partialLinkText":
                log.info("converted web element to By.partialLinkText locator");
                return By.partialLinkText(selector);
            default:
                log.error("extracted method {} is currently not supported", method);
                throw new RuntimeException("extracted element's method '"+method+"' doesn't match supported case choices");
        }
        } catch (Exception e)
        {
            log.error("failed to convert web element to by locator : {}", e.getMessage());
            log.debug("caught {}", e);
            return null;
        }
    }
}
