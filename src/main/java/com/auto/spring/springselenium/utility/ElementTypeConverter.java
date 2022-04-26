package com.auto.spring.springselenium.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElementTypeConverter
{
    @Lazy
    @Autowired
    private WebDriver driver;

    public WebElement returnWebElement(By element)
    {
        return this.driver.findElement(element);
    }

    public List<WebElement> returnWebElements(By element)
    {
        return this.driver.findElements(element);
    }

    public static By returnByLocator(WebElement element)
    {
        String ele = element.toString().split(
                "(?=\\sid:\\s|\\sname:\\s|\\sselector:\\s|\\slink text:|\\sxpath:\\s|" +
                        "By.id:\\s|By.name:\\s|By.tagName:\\s|By.className:\\s|By.cssSelector:\\s|" +
                        "By.linkText:\\s|By.partialLinkText:\\s|By.xpath:\\s)")[1];
        String[] locator = StringUtils.removeEnd(ele, "]").split(":\\s");
        String method = locator[0].trim();
        if (method.equals("xpath"))
            return By.xpath(locator[1]);
        String selector = StringUtils.removeEnd(locator[1], "'");
        switch (method) {
            case "id":
            case "By.id":
                return By.id(selector);
            case "name":
            case "By.name":
                return By.name(selector);
            case "By.tagName":
                return By.tagName(selector);
            case "By.className":
                return By.className(selector);
            case "selector":
            case "By.cssSelector":
                return By.cssSelector(selector);
            case "By.linkText":
                return By.linkText(selector);
            case "link text":
            case "By.partialLinkText":
                return By.partialLinkText(selector);
            case "By.xpath":
                return By.xpath(selector);
            default:
                return null;
        }
    }
}
