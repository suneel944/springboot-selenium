package com.auto.spring.springselenium.framework.aop;

import com.auto.spring.springselenium.framework.annotations.Window;
import com.auto.spring.springselenium.framework.service.WindowSwitcher;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect
{
    @Autowired
    private WindowSwitcher windowSwitcher;

    @Before("@target(window) && within(com.auto.spring.springselenium..*)")
    public void before(Window window)
    {
        this.windowSwitcher.switchWindowByTitle(window.value());
    }

    @After("@target(window) && within(com.auto.spring.springselenium..*)")
    public void after(Window window)
    {
        this.windowSwitcher.switchWindowByIndex(0);
    }
}
