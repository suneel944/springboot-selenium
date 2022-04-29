package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import com.auto.spring.springselenium.framework.annotations.LazyAutowired;


@Service
public class BrowserActions
{
    @LazyAutowired
    private WebDriver driver;

    public boolean launchUrl(String url)
    {
        try
        {
            this.driver.get(url);
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }
}
