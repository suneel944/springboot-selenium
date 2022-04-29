package com.auto.spring.springselenium.framework.service;

import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Lazy;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BrowserActions
{
    @Lazy
    @Autowired
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
