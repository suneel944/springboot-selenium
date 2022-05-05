package com.auto.spring.springselenium.pages;

import org.openqa.selenium.WebDriver;
import javax.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;

public abstract class BasePage
{
    @LazyAutowired
    protected WebDriver driver;

    @LazyAutowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init()
    {
        PageFactory.initElements(this.driver, this);
    }

    /*each page object has to implement this*/
    public abstract boolean isAt(String... args);
}
