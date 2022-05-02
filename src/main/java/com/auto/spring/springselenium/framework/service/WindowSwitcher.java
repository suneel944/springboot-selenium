package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class WindowSwitcher
{
    @Autowired
    private WebDriver driver;

    public boolean switchWindowByTitle(final String title)
    {
        try
        {
            driver.getWindowHandles().stream()
                    .map(handle -> driver.switchTo().window(handle)
                            .getTitle()).filter(t -> t.startsWith(title))
                    .findFirst().orElseThrow(() -> {throw new NullPointerException("");});
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    public boolean switchWindowByIndex(final Integer index)
    {
        try
        {
            String [] handles = driver.getWindowHandles().toArray(new String[0]);
            driver.switchTo().window(handles[index]);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
