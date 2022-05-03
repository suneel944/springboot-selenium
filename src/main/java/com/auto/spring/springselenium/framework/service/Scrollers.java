package com.auto.spring.springselenium.framework.service;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import com.auto.spring.springselenium.framework.annotations.LazyService;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;

@LazyService
@Log4j2
public class Scrollers
{
    @LazyAutowired
    private JavascriptExecutor js;

    public boolean scrollToElement(WebElement element)
    {
        try
        {
            log.info("scrolling to element");
            js.executeScript("arguments[0].scrollIntoView();", element);
            log.info("scrolled to element");
            return true;
        } catch (Exception e)
        {
            log.error("failed to scroll to element {}", e.getMessage());
            log.debug("caught {}");
            return false;
        }
    }

    public boolean scrollToCoordinates(String x, String y)
    {
        try
        {
            log.info("scrolling to coordinates {}:x {}:y", x,y);
            js.executeScript("window.scrollBy(" + x + "," + y + ")");
            log.info("scrolled to coordinates {}:x {}:y", x,y);
            return true;
        } catch (Exception e)
        {
            log.error("failed to scroll to coordinates {}:x {}:y {}", x,y,e.getMessage());
            log.debug("caught {}");
            return false;
        }

    }

    public boolean scrollVertically(String pixelOffset)
    {
        try
        {
            log.info("scrolling vertically");
            js.executeScript("window.scrollBy(0,"+pixelOffset+")");
            log.info("scrolled vertically");
            return true;
        } catch (Exception e)
        {
            log.error("failed to scroll vertically {}", e.getMessage());
            log.debug("caught {}");
            return false;
        }

    }

    public boolean scrollToBottomPage()
    {
        try
        {
            log.info("scrolling to bottom most part of page");
            js.executeScript("window.scrollBy(0,document.body.scrollHeight");
            log.info("scrolled to bottom most part of page");
            return true;
        } catch (Exception e)
        {
            log.error("failed to scroll to bottom most part of page {}", e.getMessage());
            log.debug("caught {}");
            return false;
        }
    }
}
