package com.auto.spring.springselenium.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import javax.annotation.PostConstruct;

public abstract class Base
{
    @Lazy
    @Autowired
    protected WebDriver driver;

    @Lazy
    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init()
    {
        PageFactory.initElements(this.driver, this);
    }

    /*each page object has to implement this*/
    public abstract boolean isAt();
}
