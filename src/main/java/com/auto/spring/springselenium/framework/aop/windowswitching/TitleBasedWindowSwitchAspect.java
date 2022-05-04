package com.auto.spring.springselenium.framework.aop.windowswitching;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.framework.service.WindowSwitcher;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;
import com.auto.spring.springselenium.framework.annotations.windowswitching.TitleBasedWindowSwitch;

@Aspect
@Component
@Log4j2
public class TitleBasedWindowSwitchAspect
{
    @LazyAutowired
    private WindowSwitcher windowSwitcher;

    @Before("@target(titleBasedWindowSwitch) && within(com.auto.spring.springselenium..*)")
    public void before(TitleBasedWindowSwitch titleBasedWindowSwitch)
    {
        log.info("before : triggering window switch aop");
        this.windowSwitcher.switchWindowByTitle(titleBasedWindowSwitch.value());
        log.info("before : triggered window switch aop");
    }
}
