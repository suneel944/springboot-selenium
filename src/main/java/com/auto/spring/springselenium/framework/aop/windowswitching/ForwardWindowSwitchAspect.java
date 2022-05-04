package com.auto.spring.springselenium.framework.aop.windowswitching;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.auto.spring.springselenium.framework.service.WindowSwitcher;
import com.auto.spring.springselenium.framework.annotations.others.LazyAutowired;
import com.auto.spring.springselenium.framework.annotations.windowswitching.IterativeForwardWindowSwitch;

@Aspect
@Component
@Log4j2
public class ForwardWindowSwitchAspect
{
    @LazyAutowired
    private WindowSwitcher windowSwitcher;

    @Before("@annotation(iterativeForwardWindowSwitch)")
    public void before(IterativeForwardWindowSwitch iterativeForwardWindowSwitch)
    {
        log.info("before : triggering forward window switch aop");
        this.windowSwitcher.switchToSucceedingWindow(iterativeForwardWindowSwitch.value());
        log.info("before : triggered forward window switch aop");
    }
}
