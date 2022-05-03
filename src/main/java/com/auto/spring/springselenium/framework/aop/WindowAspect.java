package com.auto.spring.springselenium.framework.aop;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.auto.spring.springselenium.framework.annotations.Window;
import com.auto.spring.springselenium.framework.service.WindowSwitcher;

@Aspect
@Component
@Log4j2
public class WindowAspect
{
    @Autowired
    private WindowSwitcher windowSwitcher;

    @Before("@target(window) && within(com.auto.spring.springselenium..*)")
    public void before(Window window)
    {
        log.info("before : triggering window switch aop");
        this.windowSwitcher.switchWindowByTitle(window.value());
        log.info("before : triggered window switch aop");
    }

    @After("@target(window) && within(com.auto.spring.springselenium..*)")
    public void after(Window window)
    {
        log.info("after : triggering window switch aop");
        this.windowSwitcher.switchWindowByIndex(0);
        log.info("after : triggered window switch aop");
    }
}
